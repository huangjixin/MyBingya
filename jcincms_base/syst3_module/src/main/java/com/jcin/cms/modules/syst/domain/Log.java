package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;

public class Log implements Serializable {
    /**
     *   所属表字段为log.id
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String id;

    /**
     *   所属表字段为log.type
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String type;

    /**
     *   所属表字段为log.create_by
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String createBy;

    /**
     *   所属表字段为log.remote_addr
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String remoteAddr;

    /**
     *   所属表字段为log.user_agent
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String userAgent;

    /**
     *   所属表字段为log.request_uri
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String requestUri;

    /**
     *   所属表字段为log.Method
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String method;

    /**
     *   所属表字段为log.params
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String params;

    /**
     *   所属表字段为log.exception
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String exception;

    /**
     * 该字段对应数据库表 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 log.id
     *
     * @return 返回 log.id
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 log.id
     *
     * @param id 赋值 log.id
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 log.type
     *
     * @return 返回 log.type
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getType() {
        return type;
    }

    /**
     * setter方法 log.type
     *
     * @param type 赋值 log.type
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 所属表字段为 log.create_by
     *
     * @return 返回 log.create_by
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 log.create_by
     *
     * @param createBy 赋值 log.create_by
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 log.remote_addr
     *
     * @return 返回 log.remote_addr
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /**
     * setter方法 log.remote_addr
     *
     * @param remoteAddr 赋值 log.remote_addr
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr == null ? null : remoteAddr.trim();
    }

    /**
     * 所属表字段为 log.user_agent
     *
     * @return 返回 log.user_agent
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * setter方法 log.user_agent
     *
     * @param userAgent 赋值 log.user_agent
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    /**
     * 所属表字段为 log.request_uri
     *
     * @return 返回 log.request_uri
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * setter方法 log.request_uri
     *
     * @param requestUri 赋值 log.request_uri
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    /**
     * 所属表字段为 log.Method
     *
     * @return 返回 log.Method
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getMethod() {
        return method;
    }

    /**
     * setter方法 log.Method
     *
     * @param method 赋值 log.Method
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 所属表字段为 log.params
     *
     * @return 返回 log.params
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getParams() {
        return params;
    }

    /**
     * setter方法 log.params
     *
     * @param params 赋值 log.params
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * 所属表字段为 log.exception
     *
     * @return 返回 log.exception
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getException() {
        return exception;
    }

    /**
     * setter方法 log.exception
     *
     * @param exception 赋值 log.exception
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }
}