package com.atguigu.fastdfs.entities;

public class Picture {

    private Integer picId;
    private String picGroupName;
    private String picRemoteFileName;
    private String picTitle;

    public Picture() {

    }

    public Picture(Integer picId, String picGroupName, String picRemoteFileName, String picTitle) {
        super();
        this.picId = picId;
        this.picGroupName = picGroupName;
        this.picRemoteFileName = picRemoteFileName;
        this.picTitle = picTitle;
    }

    @Override
    public String toString() {
        return "Picture [picId=" + picId + ", picGroupName=" + picGroupName + ", picRemoteFileName=" + picRemoteFileName
                + ", picTitle=" + picTitle + "]";
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicGroupName() {
        return picGroupName;
    }

    public void setPicGroupName(String picGroupName) {
        this.picGroupName = picGroupName;
    }

    public String getPicRemoteFileName() {
        return picRemoteFileName;
    }

    public void setPicRemoteFileName(String picRemoteFileName) {
        this.picRemoteFileName = picRemoteFileName;
    }

    public String getPicPagePath() {
        return picGroupName + "/" + picRemoteFileName;
    }

    public String getPicTitle() {
        return picTitle;
    }

    public void setPicTitle(String picTitle) {
        this.picTitle = picTitle;
    }

}
