package com.bean;

public class XiTongBug {
    private int id;
    private String bid;
    private String name;
    private int count;
    private String jibie;
    private String yuname;
    private String type;
    private boolean tongzhi;
    private boolean fankui;
    private boolean ctest;
    private boolean update;

    @Override
    public String toString() {
        return "XiTongBug{" +
                "id=" + id +
                ", bid='" + bid + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", jibie='" + jibie + '\'' +
                ", yuname='" + yuname + '\'' +
                ", type='" + type + '\'' +
                ", tongzhi=" + tongzhi +
                ", fankui=" + fankui +
                ", ctest=" + ctest +
                ", update=" + update +
                '}';
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getJibie() {
        return jibie;
    }

    public void setJibie(String jibie) {
        this.jibie = jibie;
    }

    public String getYuname() {
        return yuname;
    }

    public void setYuname(String yuname) {
        this.yuname = yuname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTongzhi() {
        return tongzhi;
    }

    public void setTongzhi(boolean tongzhi) {
        this.tongzhi = tongzhi;
    }

    public boolean isFankui() {
        return fankui;
    }

    public void setFankui(boolean fankui) {
        this.fankui = fankui;
    }

    public boolean isCtest() {
        return ctest;
    }

    public void setCtest(boolean ctest) {
        this.ctest = ctest;
    }
}
