package com.ziroom.entity;

import java.util.Date;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author zhangxiuli
 * @version 1.0
 * @date 2018/10/9 15:46
 * @since 1.0
 */
public class LogEntity {
    /**
     * 主键id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 做了什么事
     */
    private String doSomething;

    /**
     * 状态
     */
    private String status;

    /**
     * 日期
     */
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoSomething() {
        return doSomething;
    }

    public void setDoSomething(String doSomething) {
        this.doSomething = doSomething;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LogEntity() {
    }

    public LogEntity(String id, String username, String doSomething, String status, Date date) {
        this.id = id;
        this.username = username;
        this.doSomething = doSomething;
        this.status = status;
        this.date = date;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", doSomething='" + doSomething + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
