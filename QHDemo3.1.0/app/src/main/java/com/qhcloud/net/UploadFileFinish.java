package com.qhcloud.net;

/**
 * Created by QH on 2017/1/19.
 */
public class UploadFileFinish {
    private String md5;

    private int fileType;

    private long fileSize;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
