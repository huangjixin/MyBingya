/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.channel.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.channel.dao.VoteChoiceMapper;
import com.jcin.cms.modules.channel.domain.VoteChoice;
import com.jcin.cms.modules.channel.domain.VoteChoiceCriteria;
import com.jcin.cms.modules.channel.service.IVoteChoiceService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="voteChoiceService")
public class VoteChoiceServiceImpl extends BaseServiceImpl<VoteChoice, String>
		implements IVoteChoiceService {
	private static Logger logger = LoggerFactory.getLogger(VoteChoiceServiceImpl.class
			.getName());

	@Autowired
	private VoteChoiceMapper voteChoiceMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = voteChoiceMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#insert(com.jcin.cms.service.channel.
	 * VoteChoice)
	 */
	@Override
	@Transactional
	public String insert(VoteChoice record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = voteChoiceMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		VoteChoiceCriteria voteChoiceCriteria = new VoteChoiceCriteria();
		voteChoiceCriteria.setOrderByClause("id desc");
		voteChoiceCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = voteChoiceMapper.selectByExample(voteChoiceCriteria);
		page.setRows(list);
		int total = voteChoiceMapper.countByExample(voteChoiceCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#select(com.jcin.cms.service.channel.VoteChoiceCriteria)
	 */
	//@Override
	public Page select(VoteChoiceCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = voteChoiceMapper.selectByExample(criteria);
		page.setRows(list);
		int total = voteChoiceMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#selectAll()
	 */
	@Override
	public List<VoteChoice> selectAll() {
		List<VoteChoice> list = voteChoiceMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public VoteChoice selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		VoteChoice article = voteChoiceMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#update(com.jcin.cms.service.channel.
	 * VoteChoice)
	 */
	@Override
	@Transactional
	public String update(VoteChoice record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = voteChoiceMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<VoteChoice> list) {
		int result = voteChoiceMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteChoiceService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		VoteChoiceCriteria voteChoiceCriteria = new VoteChoiceCriteria();
		voteChoiceCriteria.createCriteria().andIdIn(list);
		int result = voteChoiceMapper.deleteByExample(voteChoiceCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<VoteChoice> selectByExample(
			VoteChoiceCriteria criteria) {
		return  voteChoiceMapper.selectByExample(criteria);
	}

}
