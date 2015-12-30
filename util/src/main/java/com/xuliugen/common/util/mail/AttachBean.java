package com.xuliugen.common.util.mail;

import java.io.File;

/*
 * 附件类，只有文件，即附件才文件名
 * Created by xuliugen on 15/10/18.
 */
public class AttachBean {

    private String cid;

    private File file;

    private String fileName;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public AttachBean() {

    }

    public AttachBean(File file, String fileName) {
        super();
        this.file = file;
        this.fileName = fileName;
    }
}
