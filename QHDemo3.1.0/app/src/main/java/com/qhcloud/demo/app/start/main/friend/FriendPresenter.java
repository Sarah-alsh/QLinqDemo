package com.qhcloud.demo.app.start.main.friend;import android.content.Context;import android.util.Log;import com.qhcloud.demo.app.BasePresenter;import com.qhcloud.demo.entity.UserInfo;import com.qhcloud.demo.manager.model.FriendImp;import com.qhcloud.demo.manager.model.biz.IFriend;import com.qhcloud.demo.util.AppUtil;import com.qhcloud.net.BaseInfo;import com.qhcloud.net.DownloadFileResultInfo;import com.qhcloud.net.FriendRemark;import com.qhcloud.net.FriendVersion;import org.reactivestreams.Subscription;import java.util.ArrayList;import java.util.List;import io.reactivex.Flowable;import io.reactivex.android.schedulers.AndroidSchedulers;import io.reactivex.functions.Action;import io.reactivex.functions.Consumer;import io.reactivex.schedulers.Schedulers;/** * 好友列表presenter * @author youngbin */public class FriendPresenter extends BasePresenter {    private static final String TAG = "FriendPresenter";    private IFriend mIFriend;    private IFriendView mIFriendView;    //本地用户信息    private List<UserInfo> mUserInfoList;    private List<FriendVersion> mFriendVersion;    public FriendPresenter(Context context) {        super(context);    }    public FriendPresenter(Context context, IFriendView iFriendView) {        this(context);        mIFriend = new FriendImp(context);        mIFriendView = iFriendView;        init();    }    private synchronized void init() {        mDisposable.add(Flowable.empty()                .doOnSubscribe(new Consumer<Subscription>() {                    @Override                    public void accept(Subscription subscription) throws Exception {                        mUserInfoList = mIFriend.query();                    }                })                .subscribeOn(Schedulers.io())                .observeOn(AndroidSchedulers.mainThread())                .doOnComplete(new Action() {                    @Override                    public void run() throws Exception {                        mIFriendView.setAdapter(mUserInfoList);                    }                })                .subscribe());    }    /**     * 比较版本     */    public void compareVersion(List<FriendVersion> list) {        Log.i(TAG, "compareVersion: 开始比较版本信息");        if (list == null || list.isEmpty()) {            //网络数据库没有好友列表，清空本地数据库            mUserInfoList = null;            mIFriend.clean();            mIFriendView.setAdapter(null);            return;        }        mFriendVersion = list;        final List<Integer> uidRemarkList = new ArrayList<>();        final List<Integer> uidBaseList = new ArrayList<>();        for (FriendVersion friendVersion : list) {            if (friendVersion == null) {                continue;            }            boolean remarkExist = false;            if (mUserInfoList != null) {                for (UserInfo userInfo : mUserInfoList) {                    if (userInfo == null) {                        continue;                    }                    if (friendVersion.getUid() == userInfo.getUid()) {                        remarkExist = true;                        //数据未比较                        if (friendVersion.getRemarks_version() != userInfo.getRemarkVersion()) {                            //备注版本不一致，需要更新                            userInfo.setRemarkState(UserInfo.STATE_UPDATE);                            uidRemarkList.add(friendVersion.getUid());                        } else {                            //备注版本一致，不需要更新                            userInfo.setRemarkState(UserInfo.STATE_NEWEAST);                        }                        if (friendVersion.getBase_version() != userInfo.getBaseVersion()) {                            //备注版本不一致，需要更新                            userInfo.setBaseState(UserInfo.STATE_UPDATE);                            uidBaseList.add(friendVersion.getUid());                        } else {                            //备注版本一致，不需要更新                            userInfo.setBaseState(UserInfo.STATE_NEWEAST);                        }                        break;                    }                }            }            //不存在本地，数据添加            if (!remarkExist) {                uidBaseList.add(friendVersion.getUid());                uidRemarkList.add(friendVersion.getUid());            }        }        mDisposable.add(Flowable.empty()                .doOnSubscribe(new Consumer<Subscription>() {                    @Override                    public void accept(Subscription subscription) throws Exception {                        if (mUserInfoList != null) {                            //当备注状态和基本信息状态同时为默认状态，则此条数据未参与比较，执行删除操作                            for (UserInfo userInfo : mUserInfoList) {                                if (userInfo.getBaseState() == UserInfo.STATE_NORMAL                                        && userInfo.getRemarkState() == UserInfo.STATE_NORMAL) {                                    long result = mIFriend.deleteById(userInfo.getUid());                                    Log.i(TAG, "删除本地数据: uid=" + userInfo.getUid() + ",result=" + result);                                }                            }                        }                        if (!uidRemarkList.isEmpty()) {                            Log.i(TAG, "accept: 更新remark.size=" + uidRemarkList.size());                            mIFriend.getFriendRemarks(uidRemarkList, getSeq());                        }                        if (!uidBaseList.isEmpty()) {                            Log.i(TAG, "accept: baseinfo.size=" + uidBaseList.size());                            mIFriend.getFriendInfo(uidBaseList, getSeq());                        }                        mUserInfoList = mIFriend.query();                    }                })                .subscribeOn(Schedulers.io())                .observeOn(AndroidSchedulers.mainThread())                .doOnComplete(new Action() {                    @Override                    public void run() throws Exception {                        mIFriendView.setAdapter(mUserInfoList);                    }                })                .subscribe());    }    /**     *更新好友备注信息     */    public void updateRemark(final List<FriendRemark> list) {        if (list == null || list.isEmpty() || mFriendVersion == null || mFriendVersion.isEmpty()) {            return;        }        mDisposable.add(Flowable.empty().doOnSubscribe(new Consumer<Subscription>() {            @Override            public void accept(Subscription subscription) throws Exception {                for (FriendRemark friendRemark : list) {                    //回调没有携带版本号，只能自己查了                    for (FriendVersion friendVersion : mFriendVersion) {                        if (friendRemark.getUid() == friendVersion.getUid()) {                            long result = mIFriend.updateRemark(friendRemark.getUid(), friendRemark.getRemark(), friendVersion.getRemarks_version());                            Log.i(TAG, "accept: update remark, uid=" + friendRemark.getUid() + ",result=" + result + ",remark=" + friendRemark.getRemark());                            break;                        }                    }                }            }        }).subscribeOn(Schedulers.io())                .observeOn(AndroidSchedulers.mainThread())                .doOnComplete(new Action() {                    @Override                    public void run() throws Exception {                        init();                    }                })                .subscribe());    }    /**     *更新好友基本信息     */    public void updateBase(final List<BaseInfo> list) {        if (list == null || list.isEmpty() || mFriendVersion == null || mFriendVersion.isEmpty()) {            return;        }        mDisposable.add(Flowable.empty().doOnSubscribe(new Consumer<Subscription>() {            @Override            public void accept(Subscription subscription) throws Exception {                for (BaseInfo baseInfo : list) {                    //回调没有携带版本号，只能自己查了                    for (FriendVersion friendVersion : mFriendVersion) {                        if (baseInfo.getUid() == friendVersion.getUid()) {                            long result = mIFriend.updateBaseInfo(baseInfo, friendVersion.getBase_version());                            Log.i(TAG, "accept: update base, uid=" + baseInfo.getUid() + ",result=" + result + ",name=" + baseInfo.getAlias());                            break;                        }                    }                    long fileId = AppUtil.parseLong(baseInfo.getLogoUrl());                    if (fileId > 0) {                        mIFriend.getAvatarUrlById(fileId, getSeq(baseInfo.getUid()));                    }                }            }        }).subscribeOn(Schedulers.io())                .observeOn(AndroidSchedulers.mainThread())                .doOnComplete(new Action() {                    @Override                    public void run() throws Exception {                        init();                    }                })                .subscribe());    }    /**     * 更新头像     */    public void updateAvatarUrl(final DownloadFileResultInfo info, final long seq) {        if (info == null || seq < 0) {            return;        }        if (!mSeqMap.containsKey(seq)) {            return;        }        mDisposable.add(Flowable.empty()                .doOnSubscribe(new Consumer<Subscription>() {                    @Override                    public void accept(Subscription subscription) throws Exception {                        mIFriend.updateAvatarUrl((Integer) getObject(seq), info.getDown_url());                    }                }).subscribeOn(Schedulers.io())                .observeOn(AndroidSchedulers.mainThread())                .doOnComplete(new Action() {                    @Override                    public void run() throws Exception {                        init();                    }                }).subscribe());    }    private void getUids() {        Log.i(TAG, "getUids: 拉取所有好友id");        mDisposable.add(Flowable.empty()                .doOnSubscribe(new Consumer<Subscription>() {                    @Override                    public void accept(Subscription subscription) throws Exception {                        int result = mIFriend.getFriendUids(getSeq());                    }                })                .subscribeOn(Schedulers.newThread())                .subscribe());    }    public void onRefresh() {        getUids();    }    public void onLoad() {    }}