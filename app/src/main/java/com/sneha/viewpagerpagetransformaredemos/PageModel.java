package com.sneha.viewpagerpagetransformaredemos;

public class PageModel {

    int img;
    boolean isTextShow = false;
    String title = "";

    public PageModel(int img, String tlt, boolean isTextShow) {
        this.img = img;
        this.isTextShow = isTextShow;
        this.title = tlt;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isTextShow() {
        return isTextShow;
    }

    public void setTextShow(boolean textShow) {
        isTextShow = textShow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
