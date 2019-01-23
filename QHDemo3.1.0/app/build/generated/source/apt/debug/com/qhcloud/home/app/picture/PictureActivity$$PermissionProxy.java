// Generated code. Do not modify!
package com.qhcloud.home.app.picture;

import com.zhy.m.permission.*;

public class PictureActivity$$PermissionProxy implements PermissionProxy<PictureActivity> {
@Override
 public void grant(PictureActivity source , int requestCode) {
switch(requestCode) {case 10005:source.requestSdcardSuccess();break;}  }
@Override
 public void denied(PictureActivity source , int requestCode) {
switch(requestCode) {case 10005:source.requestSdcardFailed();break;}  }

}
