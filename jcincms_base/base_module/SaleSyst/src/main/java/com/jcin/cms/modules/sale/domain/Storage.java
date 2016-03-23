package com.jcin.cms.modules.sale.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class Storage implements Serializable {
    /**
     *   所属表字段为tb_storage.id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    private String id;

    /**
     *  产品名称 所属表字段为tb_storage.pro_name
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    private String proName;

    /**
     *   所属表字段为tb_storage.pro_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    private String proId;

    /**
     *  关联进货表 所属表字段为tb_storage.buy_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    private String buyId;

    /**
     *  关联销售表 所属表字段为tb_storage.sale_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    private String saleId;

    /**
     *  库存数量 所属表字段为tb_storage.procount
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    private Double procount;

    /**
     * 该字段对应数据库表 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_storage.id
     *
     * @return 返回 tb_storage.id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_storage.id
     *
     * @param id 赋值 tb_storage.id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_storage.pro_name
     *
     * @return 返回 tb_storage.pro_name
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public String getProName() {
        return proName;
    }

    /**
     * setter方法 tb_storage.pro_name
     *
     * @param proName 赋值 tb_storage.pro_name
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    /**
     * 所属表字段为 tb_storage.pro_id
     *
     * @return 返回 tb_storage.pro_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public String getProId() {
        return proId;
    }

    /**
     * setter方法 tb_storage.pro_id
     *
     * @param proId 赋值 tb_storage.pro_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    /**
     * 所属表字段为 tb_storage.buy_id
     *
     * @return 返回 tb_storage.buy_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public String getBuyId() {
        return buyId;
    }

    /**
     * setter方法 tb_storage.buy_id
     *
     * @param buyId 赋值 tb_storage.buy_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public void setBuyId(String buyId) {
        this.buyId = buyId == null ? null : buyId.trim();
    }

    /**
     * 所属表字段为 tb_storage.sale_id
     *
     * @return 返回 tb_storage.sale_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public String getSaleId() {
        return saleId;
    }

    /**
     * setter方法 tb_storage.sale_id
     *
     * @param saleId 赋值 tb_storage.sale_id
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }

    /**
     * 所属表字段为 tb_storage.procount
     *
     * @return 返回 tb_storage.procount
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public Double getProcount() {
        return procount;
    }

    /**
     * setter方法 tb_storage.procount
     *
     * @param procount 赋值 tb_storage.procount
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    public void setProcount(Double procount) {
        this.procount = procount;
    }
}