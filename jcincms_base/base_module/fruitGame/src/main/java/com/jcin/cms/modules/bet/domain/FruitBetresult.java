package com.jcin.cms.modules.bet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class FruitBetresult implements Serializable {
    /**
     *   所属表字段为tb_fruit_betresult.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String id;

    /**
     *   所属表字段为tb_fruit_betresult.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_fruit_betresult.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String createBy;

    /**
     *   所属表字段为tb_fruit_betresult.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为tb_fruit_betresult.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String updateBy;

    /**
     *   所属表字段为tb_fruit_betresult.da
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double da;

    /**
     *   所属表字段为tb_fruit_betresult.xiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double xiao;

    /**
     *   所属表字段为tb_fruit_betresult.dan
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double dan;

    /**
     *   所属表字段为tb_fruit_betresult.shuang
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double shuang;

    /**
     *   所属表字段为tb_fruit_betresult.pingguo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double pingguo;

    /**
     *   所属表字段为tb_fruit_betresult.putao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double putao;

    /**
     *   所属表字段为tb_fruit_betresult.boluo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double boluo;

    /**
     *   所属表字段为tb_fruit_betresult.caomei
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double caomei;

    /**
     *   所属表字段为tb_fruit_betresult.xigua
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double xigua;

    /**
     *   所属表字段为tb_fruit_betresult.xiangjiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double xiangjiao;

    /**
     *   所属表字段为tb_fruit_betresult.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String description;

    /**
     *  下单人 所属表字段为tb_fruit_betresult.username
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String username;

    /**
     *  用户ID 所属表字段为tb_fruit_betresult.user_id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String userId;

    /**
     * 该字段对应数据库表 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_fruit_betresult.id
     *
     * @return 返回 tb_fruit_betresult.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_fruit_betresult.id
     *
     * @param id 赋值 tb_fruit_betresult.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult.create_date
     *
     * @return 返回 tb_fruit_betresult.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_fruit_betresult.create_date
     *
     * @param createDate 赋值 tb_fruit_betresult.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.create_by
     *
     * @return 返回 tb_fruit_betresult.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_fruit_betresult.create_by
     *
     * @param createBy 赋值 tb_fruit_betresult.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult.update_date
     *
     * @return 返回 tb_fruit_betresult.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_fruit_betresult.update_date
     *
     * @param updateDate 赋值 tb_fruit_betresult.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.update_by
     *
     * @return 返回 tb_fruit_betresult.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 tb_fruit_betresult.update_by
     *
     * @param updateBy 赋值 tb_fruit_betresult.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult.da
     *
     * @return 返回 tb_fruit_betresult.da
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getDa() {
        return da;
    }

    /**
     * setter方法 tb_fruit_betresult.da
     *
     * @param da 赋值 tb_fruit_betresult.da
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDa(Double da) {
        this.da = da;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.xiao
     *
     * @return 返回 tb_fruit_betresult.xiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getXiao() {
        return xiao;
    }

    /**
     * setter方法 tb_fruit_betresult.xiao
     *
     * @param xiao 赋值 tb_fruit_betresult.xiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setXiao(Double xiao) {
        this.xiao = xiao;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.dan
     *
     * @return 返回 tb_fruit_betresult.dan
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getDan() {
        return dan;
    }

    /**
     * setter方法 tb_fruit_betresult.dan
     *
     * @param dan 赋值 tb_fruit_betresult.dan
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDan(Double dan) {
        this.dan = dan;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.shuang
     *
     * @return 返回 tb_fruit_betresult.shuang
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getShuang() {
        return shuang;
    }

    /**
     * setter方法 tb_fruit_betresult.shuang
     *
     * @param shuang 赋值 tb_fruit_betresult.shuang
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setShuang(Double shuang) {
        this.shuang = shuang;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.pingguo
     *
     * @return 返回 tb_fruit_betresult.pingguo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getPingguo() {
        return pingguo;
    }

    /**
     * setter方法 tb_fruit_betresult.pingguo
     *
     * @param pingguo 赋值 tb_fruit_betresult.pingguo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setPingguo(Double pingguo) {
        this.pingguo = pingguo;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.putao
     *
     * @return 返回 tb_fruit_betresult.putao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getPutao() {
        return putao;
    }

    /**
     * setter方法 tb_fruit_betresult.putao
     *
     * @param putao 赋值 tb_fruit_betresult.putao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setPutao(Double putao) {
        this.putao = putao;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.boluo
     *
     * @return 返回 tb_fruit_betresult.boluo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getBoluo() {
        return boluo;
    }

    /**
     * setter方法 tb_fruit_betresult.boluo
     *
     * @param boluo 赋值 tb_fruit_betresult.boluo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setBoluo(Double boluo) {
        this.boluo = boluo;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.caomei
     *
     * @return 返回 tb_fruit_betresult.caomei
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getCaomei() {
        return caomei;
    }

    /**
     * setter方法 tb_fruit_betresult.caomei
     *
     * @param caomei 赋值 tb_fruit_betresult.caomei
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setCaomei(Double caomei) {
        this.caomei = caomei;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.xigua
     *
     * @return 返回 tb_fruit_betresult.xigua
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getXigua() {
        return xigua;
    }

    /**
     * setter方法 tb_fruit_betresult.xigua
     *
     * @param xigua 赋值 tb_fruit_betresult.xigua
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setXigua(Double xigua) {
        this.xigua = xigua;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.xiangjiao
     *
     * @return 返回 tb_fruit_betresult.xiangjiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getXiangjiao() {
        return xiangjiao;
    }

    /**
     * setter方法 tb_fruit_betresult.xiangjiao
     *
     * @param xiangjiao 赋值 tb_fruit_betresult.xiangjiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setXiangjiao(Double xiangjiao) {
        this.xiangjiao = xiangjiao;
    }

    /**
     * 所属表字段为 tb_fruit_betresult.description
     *
     * @return 返回 tb_fruit_betresult.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_fruit_betresult.description
     *
     * @param description 赋值 tb_fruit_betresult.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult.username
     *
     * @return 返回 tb_fruit_betresult.username
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter方法 tb_fruit_betresult.username
     *
     * @param username 赋值 tb_fruit_betresult.username
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult.user_id
     *
     * @return 返回 tb_fruit_betresult.user_id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getUserId() {
        return userId;
    }

    /**
     * setter方法 tb_fruit_betresult.user_id
     *
     * @param userId 赋值 tb_fruit_betresult.user_id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}