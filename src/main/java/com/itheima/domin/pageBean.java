package com.itheima.domin;

import java.util.List;

public class pageBean {
    private Long total;
    private List rows;


    public pageBean() {
    }

    public pageBean(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    /**
     * 获取
     * @return total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 获取
     * @return rows
     */
    public List getRows() {
        return rows;
    }

    /**
     * 设置
     * @param rows
     */
    public void setRows(List rows) {
        this.rows = rows;
    }

    public String toString() {
        return "pageBean{total = " + total + ", rows = " + rows + "}";
    }
}
