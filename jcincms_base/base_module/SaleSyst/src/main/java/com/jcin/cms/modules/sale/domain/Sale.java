package com.jcin.cms.modules.sale.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Sale implements Serializable {
    /**
     *   所属表字段为tb_sale.id
     *
     * @mbggenerated 2016年03月21日 13时48分42秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_sale.pro_id
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    private String proId;
    
    /**
     *   所属表字段为tb_sale.buy_id
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    private String buyId;

    /**
     *  销售数量 所属表字段为tb_sale.sale_amount
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    private Double saleAmount;

    /**
     *  总额 所属表字段为tb_sale.total_amount
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    private Double totalAmount;

    /**
     *   所属表字段为tb_sale.create_date
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_sale.create_by
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    private String createBy;

    /**
     *  销售数量 所属表字段为tb_sale.sale_num
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    private Double saleNum;

    /**
     *   所属表字段为tb_sale.pro_name
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    private String proName;

    /**
     * 该字段对应数据库表 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    private static final long serialVersionUID = 1L;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date benginDate;
    
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

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endDate;
	
    /**
     * 所属表字段为 tb_sale.id
     *
     * @return 返回 tb_sale.id
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_sale.id
     *
     * @param id 赋值 tb_sale.id
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_sale.pro_id
     *
     * @return 返回 tb_sale.pro_id
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public String getProId() {
        return proId;
    }

    /**
     * setter方法 tb_sale.pro_id
     *
     * @param proId 赋值 tb_sale.pro_id
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    /**
     * 所属表字段为 tb_sale.sale_amount
     *
     * @return 返回 tb_sale.sale_amount
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public Double getSaleAmount() {
        return saleAmount;
    }

    /**
     * setter方法 tb_sale.sale_amount
     *
     * @param saleAmount 赋值 tb_sale.sale_amount
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public void setSaleAmount(Double saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * 所属表字段为 tb_sale.total_amount
     *
     * @return 返回 tb_sale.total_amount
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * setter方法 tb_sale.total_amount
     *
     * @param totalAmount 赋值 tb_sale.total_amount
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 所属表字段为 tb_sale.create_date
     *
     * @return 返回 tb_sale.create_date
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_sale.create_date
     *
     * @param createDate 赋值 tb_sale.create_date
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_sale.create_by
     *
     * @return 返回 tb_sale.create_by
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_sale.create_by
     *
     * @param createBy 赋值 tb_sale.create_by
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_sale.sale_num
     *
     * @return 返回 tb_sale.sale_num
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public Double getSaleNum() {
        return saleNum;
    }

    /**
     * setter方法 tb_sale.sale_num
     *
     * @param saleNum 赋值 tb_sale.sale_num
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public void setSaleNum(Double saleNum) {
        this.saleNum = saleNum;
    }

    /**
     * 所属表字段为 tb_sale.pro_name
     *
     * @return 返回 tb_sale.pro_name
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public String getProName() {
        return proName;
    }

    /**
     * setter方法 tb_sale.pro_name
     *
     * @param proName 赋值 tb_sale.pro_name
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

	public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}
}