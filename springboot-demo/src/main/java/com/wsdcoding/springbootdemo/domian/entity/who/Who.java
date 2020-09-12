package com.wsdcoding.springbootdemo.domian.entity.who;

import javax.persistence.*;

@Table(name = "who")
public class Who {
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String des;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des
     */
    public void setDes(String des) {
        this.des = des;
    }
}