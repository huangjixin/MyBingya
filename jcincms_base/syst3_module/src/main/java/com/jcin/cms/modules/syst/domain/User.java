package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {
    /**
     *   所属表字段为tb_user.id
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String id;

    /**
     *  用户登录名 所属表字段为tb_user.username
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String username;

    /**
     *  密码，加密存储 所属表字段为tb_user.password
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String password;

    /**
     *   所属表字段为tb_user.login_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date loginDate;

    /**
     *  创建日期 所属表字段为tb_user.create_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  更新日期 所属表字段为tb_user.update_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  显示名称 所属表字段为tb_user.show_name
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String showName;

    /**
     *  邮箱 所属表字段为tb_user.email
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String email;

    /**
     *  移动电话 所属表字段为tb_user.mobile
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String mobile;

    /**
     *  登录次数 所属表字段为tb_user.login_count
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private Integer loginCount;

    /**
     *  登录IP 所属表字段为tb_user.login_ip
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String loginIp;

    /**
     *  上一次登录 所属表字段为tb_user.last_login
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastLogin;

    /**
     *  性别 所属表字段为tb_user.sex
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private Byte sex;

    /**
     *  创建人 所属表字段为tb_user.create_by
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String createBy;

    /**
     *  更新人 所属表字段为tb_user.update_by
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String updateBy;

    /**
     *  头像 所属表字段为tb_user.head_image
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String headImage;

    /**
     *  会员级别 所属表字段为tb_user.member_lebel_id
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private String memberLebelId;

    /**
     * 该字段对应数据库表 tb_user
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user.id
     *
     * @return 返回 tb_user.id
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user.id
     *
     * @param id 赋值 tb_user.id
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user.username
     *
     * @return 返回 tb_user.username
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter方法 tb_user.username
     *
     * @param username 赋值 tb_user.username
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 所属表字段为 tb_user.password
     *
     * @return 返回 tb_user.password
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter方法 tb_user.password
     *
     * @param password 赋值 tb_user.password
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 所属表字段为 tb_user.login_date
     *
     * @return 返回 tb_user.login_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * setter方法 tb_user.login_date
     *
     * @param loginDate 赋值 tb_user.login_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 所属表字段为 tb_user.create_date
     *
     * @return 返回 tb_user.create_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_user.create_date
     *
     * @param createDate 赋值 tb_user.create_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_user.update_date
     *
     * @return 返回 tb_user.update_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_user.update_date
     *
     * @param updateDate 赋值 tb_user.update_date
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_user.show_name
     *
     * @return 返回 tb_user.show_name
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getShowName() {
        return showName;
    }

    /**
     * setter方法 tb_user.show_name
     *
     * @param showName 赋值 tb_user.show_name
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    /**
     * 所属表字段为 tb_user.email
     *
     * @return 返回 tb_user.email
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter方法 tb_user.email
     *
     * @param email 赋值 tb_user.email
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 所属表字段为 tb_user.mobile
     *
     * @return 返回 tb_user.mobile
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * setter方法 tb_user.mobile
     *
     * @param mobile 赋值 tb_user.mobile
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 所属表字段为 tb_user.login_count
     *
     * @return 返回 tb_user.login_count
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public Integer getLoginCount() {
        return loginCount;
    }

    /**
     * setter方法 tb_user.login_count
     *
     * @param loginCount 赋值 tb_user.login_count
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 所属表字段为 tb_user.login_ip
     *
     * @return 返回 tb_user.login_ip
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * setter方法 tb_user.login_ip
     *
     * @param loginIp 赋值 tb_user.login_ip
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 所属表字段为 tb_user.last_login
     *
     * @return 返回 tb_user.last_login
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * setter方法 tb_user.last_login
     *
     * @param lastLogin 赋值 tb_user.last_login
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 所属表字段为 tb_user.sex
     *
     * @return 返回 tb_user.sex
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * setter方法 tb_user.sex
     *
     * @param sex 赋值 tb_user.sex
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 所属表字段为 tb_user.create_by
     *
     * @return 返回 tb_user.create_by
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_user.create_by
     *
     * @param createBy 赋值 tb_user.create_by
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_user.update_by
     *
     * @return 返回 tb_user.update_by
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 tb_user.update_by
     *
     * @param updateBy 赋值 tb_user.update_by
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 所属表字段为 tb_user.head_image
     *
     * @return 返回 tb_user.head_image
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getHeadImage() {
        return headImage;
    }

    /**
     * setter方法 tb_user.head_image
     *
     * @param headImage 赋值 tb_user.head_image
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }


    /**
     * 所属表字段为 tb_user.member_lebel_id
     *
     * @return 返回 tb_user.member_lebel_id
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public String getMemberLebelId() {
        return memberLebelId;
    }

    /**
     * setter方法 tb_user.member_lebel_id
     *
     * @param memberLebelId 赋值 tb_user.member_lebel_id
     *
     * @mbggenerated 2016年04月17日 11时44分22秒 星期日
     */
    public void setMemberLebelId(String memberLebelId) {
        this.memberLebelId = memberLebelId == null ? null : memberLebelId.trim();
    }
    
    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	private String roleName;
}