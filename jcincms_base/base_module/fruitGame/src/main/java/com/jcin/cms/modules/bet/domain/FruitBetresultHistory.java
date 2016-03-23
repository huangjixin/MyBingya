package com.jcin.cms.modules.bet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class FruitBetresultHistory implements Serializable {
    /**
     *   所属表字段为tb_fruit_betresult_history.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String id;

    /**
     *   所属表字段为tb_fruit_betresult_history.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_fruit_betresult_history.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String createBy;

    /**
     *   所属表字段为tb_fruit_betresult_history.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为tb_fruit_betresult_history.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String updateBy;

    /**
     *   所属表字段为tb_fruit_betresult_history.da
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double da;

    /**
     *   所属表字段为tb_fruit_betresult_history.xiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double xiao;

    /**
     *   所属表字段为tb_fruit_betresult_history.dan
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double dan;

    /**
     *   所属表字段为tb_fruit_betresult_history.shuang
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double shuang;

    /**
     *   所属表字段为tb_fruit_betresult_history.pingguo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double pingguo;

    /**
     *   所属表字段为tb_fruit_betresult_history.putao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double putao;

    /**
     *   所属表字段为tb_fruit_betresult_history.boluo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double boluo;

    /**
     *   所属表字段为tb_fruit_betresult_history.caomei
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double caomei;

    /**
     *   所属表字段为tb_fruit_betresult_history.xigua
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double xigua;

    /**
     *   所属表字段为tb_fruit_betresult_history.xiangjiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Double xiangjiao;

    /**
     *   所属表字段为tb_fruit_betresult_history.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String description;

    /**
     *  下单人 所属表字段为tb_fruit_betresult_history.username
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String username;

    /**
     *  用户ID 所属表字段为tb_fruit_betresult_history.user_id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String userId;

    /**
     * 该字段对应数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_fruit_betresult_history.id
     *
     * @return 返回 tb_fruit_betresult_history.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_fruit_betresult_history.id
     *
     * @param id 赋值 tb_fruit_betresult_history.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.create_date
     *
     * @return 返回 tb_fruit_betresult_history.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_fruit_betresult_history.create_date
     *
     * @param createDate 赋值 tb_fruit_betresult_history.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.create_by
     *
     * @return 返回 tb_fruit_betresult_history.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_fruit_betresult_history.create_by
     *
     * @param createBy 赋值 tb_fruit_betresult_history.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.update_date
     *
     * @return 返回 tb_fruit_betresult_history.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_fruit_betresult_history.update_date
     *
     * @param updateDate 赋值 tb_fruit_betresult_history.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.update_by
     *
     * @return 返回 tb_fruit_betresult_history.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 tb_fruit_betresult_history.update_by
     *
     * @param updateBy 赋值 tb_fruit_betresult_history.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.da
     *
     * @return 返回 tb_fruit_betresult_history.da
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getDa() {
        return da;
    }

    /**
     * setter方法 tb_fruit_betresult_history.da
     *
     * @param da 赋值 tb_fruit_betresult_history.da
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDa(Double da) {
        this.da = da;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.xiao
     *
     * @return 返回 tb_fruit_betresult_history.xiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getXiao() {
        return xiao;
    }

    /**
     * setter方法 tb_fruit_betresult_history.xiao
     *
     * @param xiao 赋值 tb_fruit_betresult_history.xiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setXiao(Double xiao) {
        this.xiao = xiao;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.dan
     *
     * @return 返回 tb_fruit_betresult_history.dan
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getDan() {
        return dan;
    }

    /**
     * setter方法 tb_fruit_betresult_history.dan
     *
     * @param dan 赋值 tb_fruit_betresult_history.dan
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDan(Double dan) {
        this.dan = dan;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.shuang
     *
     * @return 返回 tb_fruit_betresult_history.shuang
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getShuang() {
        return shuang;
    }

    /**
     * setter方法 tb_fruit_betresult_history.shuang
     *
     * @param shuang 赋值 tb_fruit_betresult_history.shuang
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setShuang(Double shuang) {
        this.shuang = shuang;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.pingguo
     *
     * @return 返回 tb_fruit_betresult_history.pingguo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getPingguo() {
        return pingguo;
    }

    /**
     * setter方法 tb_fruit_betresult_history.pingguo
     *
     * @param pingguo 赋值 tb_fruit_betresult_history.pingguo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setPingguo(Double pingguo) {
        this.pingguo = pingguo;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.putao
     *
     * @return 返回 tb_fruit_betresult_history.putao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getPutao() {
        return putao;
    }

    /**
     * setter方法 tb_fruit_betresult_history.putao
     *
     * @param putao 赋值 tb_fruit_betresult_history.putao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setPutao(Double putao) {
        this.putao = putao;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.boluo
     *
     * @return 返回 tb_fruit_betresult_history.boluo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getBoluo() {
        return boluo;
    }

    /**
     * setter方法 tb_fruit_betresult_history.boluo
     *
     * @param boluo 赋值 tb_fruit_betresult_history.boluo
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setBoluo(Double boluo) {
        this.boluo = boluo;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.caomei
     *
     * @return 返回 tb_fruit_betresult_history.caomei
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getCaomei() {
        return caomei;
    }

    /**
     * setter方法 tb_fruit_betresult_history.caomei
     *
     * @param caomei 赋值 tb_fruit_betresult_history.caomei
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setCaomei(Double caomei) {
        this.caomei = caomei;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.xigua
     *
     * @return 返回 tb_fruit_betresult_history.xigua
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getXigua() {
        return xigua;
    }

    /**
     * setter方法 tb_fruit_betresult_history.xigua
     *
     * @param xigua 赋值 tb_fruit_betresult_history.xigua
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setXigua(Double xigua) {
        this.xigua = xigua;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.xiangjiao
     *
     * @return 返回 tb_fruit_betresult_history.xiangjiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Double getXiangjiao() {
        return xiangjiao;
    }

    /**
     * setter方法 tb_fruit_betresult_history.xiangjiao
     *
     * @param xiangjiao 赋值 tb_fruit_betresult_history.xiangjiao
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setXiangjiao(Double xiangjiao) {
        this.xiangjiao = xiangjiao;
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.description
     *
     * @return 返回 tb_fruit_betresult_history.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_fruit_betresult_history.description
     *
     * @param description 赋值 tb_fruit_betresult_history.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.username
     *
     * @return 返回 tb_fruit_betresult_history.username
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter方法 tb_fruit_betresult_history.username
     *
     * @param username 赋值 tb_fruit_betresult_history.username
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 所属表字段为 tb_fruit_betresult_history.user_id
     *
     * @return 返回 tb_fruit_betresult_history.user_id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getUserId() {
        return userId;
    }

    /**
     * setter方法 tb_fruit_betresult_history.user_id
     *
     * @param userId 赋值 tb_fruit_betresult_history.user_id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}