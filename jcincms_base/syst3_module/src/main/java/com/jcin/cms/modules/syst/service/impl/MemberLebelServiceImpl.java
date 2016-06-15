/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.MemberLebelMapper;
import com.jcin.cms.modules.syst.domain.MemberLebel;
import com.jcin.cms.modules.syst.domain.MemberLebelCriteria;
import com.jcin.cms.modules.syst.service.IMemberLebelService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="memberLebelService")
public class MemberLebelServiceImpl extends BaseServiceImpl<MemberLebel, String>
		implements IMemberLebelService {
	private static Logger logger = LoggerFactory.getLogger(MemberLebelServiceImpl.class
			.getName());

	@Autowired
	private MemberLebelMapper memberLebelMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = memberLebelMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#insert(com.jcin.cms.service.syst.
	 * MemberLebel)
	 */
	@Override
	@Transactional
	public String insert(MemberLebel record) {
		if(record.getId()==null)
		 	super.insert(record);
		int result = memberLebelMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		MemberLebelCriteria memberLebelCriteria = new MemberLebelCriteria();
		memberLebelCriteria.setOrderByClause("id desc");
		memberLebelCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = memberLebelMapper.selectByExample(memberLebelCriteria);
		page.setRows(list);
		int total = memberLebelMapper.countByExample(memberLebelCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#select(com.jcin.cms.service.syst.MemberLebelCriteria)
	 */
	//@Override
	public Page select(MemberLebelCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = memberLebelMapper.selectByExample(criteria);
		page.setRows(list);
		int total = memberLebelMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#selectAll()
	 */
	@Override
	public List<MemberLebel> selectAll() {
		List<MemberLebel> list = memberLebelMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public MemberLebel selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		MemberLebel record = memberLebelMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#update(com.jcin.cms.service.syst.
	 * MemberLebel)
	 */
	@Override
	@Transactional
	public String update(MemberLebel record) {
		int result = memberLebelMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<MemberLebel> list) {
		int result = memberLebelMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IMemberLebelService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		MemberLebelCriteria memberLebelCriteria = new MemberLebelCriteria();
		memberLebelCriteria.createCriteria().andIdIn(list);
		int result = memberLebelMapper.deleteByExample(memberLebelCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<MemberLebel> selectByExample(
			MemberLebelCriteria criteria) {
		return  memberLebelMapper.selectByExample(criteria);
	}

}
