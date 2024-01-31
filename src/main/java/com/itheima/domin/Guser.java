package com.itheima.domin;

public class Guser {
    private int id;
    private String gPhnumber;
    private String gPassward;

    public Guser() {
    }

    public Guser(int id, String gPhnumber, String gPassward) {
        this.id = id;
        this.gPhnumber = gPhnumber;
        this.gPassward = gPassward;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return gPhnumber
     */
    public String getGPhnumber() {
        return gPhnumber;
    }

    /**
     * 设置
     * @param gPhnumber
     */
    public void setGPhnumber(String gPhnumber) {
        this.gPhnumber = gPhnumber;
    }

    /**
     * 获取
     * @return gPassward
     */
    public String getGPassward() {
        return gPassward;
    }

    /**
     * 设置
     * @param gPassward
     */
    public void setGPassward(String gPassward) {
        this.gPassward = gPassward;
    }

    public String toString() {
        return "guser{id = " + id + ", gPhnumber = " + gPhnumber + ", gPassward = " + gPassward + "}";
    }
}
