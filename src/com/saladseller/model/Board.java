package com.saladseller.model;

import java.sql.Date;

/**
 * Created by 5CLASS-184 on 2017-05-29.
 */
public class Board {
    private int b_num;
    private int cat;
    private String title;
    private String content;
    private Date genDate;
    private int viewCount;
    private String spec;
    private String imgPath;
    public Board(){}
    public Board(int b_num,String title,String content,Date genDate,int viewCount,String spec,String imgPath, int cat){
        this.b_num = b_num;
        this.title = title;
        this.content = content;
        this.genDate = genDate;
        this.viewCount = viewCount;
        this.spec = spec;
        this.imgPath = imgPath;
        this.cat = cat;

    }
    public int getB_num() {
        return b_num;
    }
    public void setB_num(int b_num) {
        this.b_num = b_num;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGenDate() {
        return genDate;
    }

    public void setGenDate(Date genDate) {
        this.genDate = genDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
