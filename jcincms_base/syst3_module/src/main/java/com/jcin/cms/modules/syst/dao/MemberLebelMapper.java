package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.MemberLebel;
import com.jcin.cms.modules.syst.domain.MemberLebelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberLebelMapper {
    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int insertBatch(List<MemberLebel> list);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int countByExample(MemberLebelCriteria example);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int deleteByExample(MemberLebelCriteria example);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int insert(MemberLebel record);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int insertSelective(MemberLebel record);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    List<MemberLebel> selectByExample(MemberLebelCriteria example);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    MemberLebel selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int updateByExampleSelective(@Param("record") MemberLebel record, @Param("example") MemberLebelCriteria example);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int updateByExample(@Param("record") MemberLebel record, @Param("example") MemberLebelCriteria example);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int updateByPrimaryKeySelective(MemberLebel record);

    /**
     * 该方法由系统生成 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    int updateByPrimaryKey(MemberLebel record);
}