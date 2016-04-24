package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Order implements Serializable {
    /**
     *   所属表字段为order.id
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String id;

    /**
     *  流水号 所属表字段为order.serialnumber
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String serialnumber;

    /**
     *   所属表字段为order.ordercol
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String ordercol;

    /**
     *  创建日期 所属表字段为order.create_date
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为order.update_date
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  订单付款时间 所属表字段为order.paytime
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date paytime;

    /**
     *  物流类型，如EMS，顺丰 所属表字段为order.logistics
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String logistics;

    /**
     *  订单状态，切勿使用数字，要用字符串 所属表字段为order.status
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String status;

    /**
     *  商品标题 所属表字段为order.title
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String title;

    /**
     *  数量 所属表字段为order.counts
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private Integer counts;

    /**
     *   所属表字段为order.price
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private Double price;

    /**
     *  总金额 所属表字段为order.amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private Double amount;

    /**
     *  实付款 所属表字段为order.real_amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private Double realAmount;

    /**
     *  减免费用 所属表字段为order.dis_amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private Double disAmount;

    /**
     *   所属表字段为order.postage
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private Double postage;

    /**
     *  是否有邮费 所属表字段为order.has_postage
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private Byte hasPostage;

    /**
     *  买家IP 所属表字段为order.buyer_ip
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String buyerIp;

    /**
     *  买家具体地址 所属表字段为order.buyer_addr
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String buyerAddr;

    /**
     *  用户ID 所属表字段为order.userid
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String userid;

    /**
     *   所属表字段为order.username
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private String username;

    /**
     * 该字段对应数据库表 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 order.id
     *
     * @return 返回 order.id
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 order.id
     *
     * @param id 赋值 order.id
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 order.serialnumber
     *
     * @return 返回 order.serialnumber
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getSerialnumber() {
        return serialnumber;
    }

    /**
     * setter方法 order.serialnumber
     *
     * @param serialnumber 赋值 order.serialnumber
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    /**
     * 所属表字段为 order.ordercol
     *
     * @return 返回 order.ordercol
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getOrdercol() {
        return ordercol;
    }

    /**
     * setter方法 order.ordercol
     *
     * @param ordercol 赋值 order.ordercol
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setOrdercol(String ordercol) {
        this.ordercol = ordercol == null ? null : ordercol.trim();
    }

    /**
     * 所属表字段为 order.create_date
     *
     * @return 返回 order.create_date
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 order.create_date
     *
     * @param createDate 赋值 order.create_date
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 order.update_date
     *
     * @return 返回 order.update_date
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 order.update_date
     *
     * @param updateDate 赋值 order.update_date
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 order.paytime
     *
     * @return 返回 order.paytime
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Date getPaytime() {
        return paytime;
    }

    /**
     * setter方法 order.paytime
     *
     * @param paytime 赋值 order.paytime
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    /**
     * 所属表字段为 order.logistics
     *
     * @return 返回 order.logistics
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getLogistics() {
        return logistics;
    }

    /**
     * setter方法 order.logistics
     *
     * @param logistics 赋值 order.logistics
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setLogistics(String logistics) {
        this.logistics = logistics == null ? null : logistics.trim();
    }

    /**
     * 所属表字段为 order.status
     *
     * @return 返回 order.status
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter方法 order.status
     *
     * @param status 赋值 order.status
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 所属表字段为 order.title
     *
     * @return 返回 order.title
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter方法 order.title
     *
     * @param title 赋值 order.title
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 所属表字段为 order.counts
     *
     * @return 返回 order.counts
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Integer getCounts() {
        return counts;
    }

    /**
     * setter方法 order.counts
     *
     * @param counts 赋值 order.counts
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    /**
     * 所属表字段为 order.price
     *
     * @return 返回 order.price
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Double getPrice() {
        return price;
    }

    /**
     * setter方法 order.price
     *
     * @param price 赋值 order.price
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 所属表字段为 order.amount
     *
     * @return 返回 order.amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * setter方法 order.amount
     *
     * @param amount 赋值 order.amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 所属表字段为 order.real_amount
     *
     * @return 返回 order.real_amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Double getRealAmount() {
        return realAmount;
    }

    /**
     * setter方法 order.real_amount
     *
     * @param realAmount 赋值 order.real_amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setRealAmount(Double realAmount) {
        this.realAmount = realAmount;
    }

    /**
     * 所属表字段为 order.dis_amount
     *
     * @return 返回 order.dis_amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Double getDisAmount() {
        return disAmount;
    }

    /**
     * setter方法 order.dis_amount
     *
     * @param disAmount 赋值 order.dis_amount
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setDisAmount(Double disAmount) {
        this.disAmount = disAmount;
    }

    /**
     * 所属表字段为 order.postage
     *
     * @return 返回 order.postage
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Double getPostage() {
        return postage;
    }

    /**
     * setter方法 order.postage
     *
     * @param postage 赋值 order.postage
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setPostage(Double postage) {
        this.postage = postage;
    }

    /**
     * 所属表字段为 order.has_postage
     *
     * @return 返回 order.has_postage
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public Byte getHasPostage() {
        return hasPostage;
    }

    /**
     * setter方法 order.has_postage
     *
     * @param hasPostage 赋值 order.has_postage
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setHasPostage(Byte hasPostage) {
        this.hasPostage = hasPostage;
    }

    /**
     * 所属表字段为 order.buyer_ip
     *
     * @return 返回 order.buyer_ip
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getBuyerIp() {
        return buyerIp;
    }

    /**
     * setter方法 order.buyer_ip
     *
     * @param buyerIp 赋值 order.buyer_ip
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setBuyerIp(String buyerIp) {
        this.buyerIp = buyerIp == null ? null : buyerIp.trim();
    }

    /**
     * 所属表字段为 order.buyer_addr
     *
     * @return 返回 order.buyer_addr
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getBuyerAddr() {
        return buyerAddr;
    }

    /**
     * setter方法 order.buyer_addr
     *
     * @param buyerAddr 赋值 order.buyer_addr
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr == null ? null : buyerAddr.trim();
    }

    /**
     * 所属表字段为 order.userid
     *
     * @return 返回 order.userid
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getUserid() {
        return userid;
    }

    /**
     * setter方法 order.userid
     *
     * @param userid 赋值 order.userid
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 所属表字段为 order.username
     *
     * @return 返回 order.username
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter方法 order.username
     *
     * @param username 赋值 order.username
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}