package com.jcin.cms.modules.sale.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Buy implements Serializable {
    /**
     *   所属表字段为tb_buy.id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_buy.create_date
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_buy.create_by
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String createBy;

    /**
     *   所属表字段为tb_buy.pro_id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String proId;

    /**
     *  销售数量 所属表字段为tb_buy.buy_num
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private Double buyNum;

    /**
     *  销售数量 所属表字段为tb_buy.buy_amount
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private Double buyAmount;

    /**
     *  总额 所属表字段为tb_buy.total_amount
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private Double totalAmount;

    /**
     *   所属表字段为tb_buy.pro_name
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String proName;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date benginDate;
    
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endDate;
    
    /**
     * 该字段对应数据库表 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private static final long serialVersionUID = 1L;

    public Date getBenginDate() {
		return benginDate;
	}

	public void setBenginDate(Date benginDate) {
		this.benginDate = benginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
    /**
     * 所属表字段为 tb_buy.id
     *
     * @return 返回 tb_buy.id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_buy.id
     *
     * @param id 赋值 tb_buy.id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_buy.create_date
     *
     * @return 返回 tb_buy.create_date
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_buy.create_date
     *
     * @param createDate 赋值 tb_buy.create_date
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_buy.create_by
     *
     * @return 返回 tb_buy.create_by
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_buy.create_by
     *
     * @param createBy 赋值 tb_buy.create_by
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_buy.pro_id
     *
     * @return 返回 tb_buy.pro_id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getProId() {
        return proId;
    }

    /**
     * setter方法 tb_buy.pro_id
     *
     * @param proId 赋值 tb_buy.pro_id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    /**
     * 所属表字段为 tb_buy.buy_num
     *
     * @return 返回 tb_buy.buy_num
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public Double getBuyNum() {
        return buyNum;
    }

    /**
     * setter方法 tb_buy.buy_num
     *
     * @param buyNum 赋值 tb_buy.buy_num
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setBuyNum(Double buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * 所属表字段为 tb_buy.buy_amount
     *
     * @return 返回 tb_buy.buy_amount
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public Double getBuyAmount() {
        return buyAmount;
    }

    /**
     * setter方法 tb_buy.buy_amount
     *
     * @param buyAmount 赋值 tb_buy.buy_amount
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setBuyAmount(Double buyAmount) {
        this.buyAmount = buyAmount;
    }

    /**
     * 所属表字段为 tb_buy.total_amount
     *
     * @return 返回 tb_buy.total_amount
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * setter方法 tb_buy.total_amount
     *
     * @param totalAmount 赋值 tb_buy.total_amount
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 所属表字段为 tb_buy.pro_name
     *
     * @return 返回 tb_buy.pro_name
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getProName() {
        return proName;
    }

    /**
     * setter方法 tb_buy.pro_name
     *
     * @param proName 赋值 tb_buy.pro_name
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }
}