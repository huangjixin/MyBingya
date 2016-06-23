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

import com.jcin.cms.modules.channel.dao.VoteTopicMapper;
import com.jcin.cms.modules.channel.domain.VoteTopic;
import com.jcin.cms.modules.channel.domain.VoteTopicCriteria;
import com.jcin.cms.modules.channel.service.IVoteTopicService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="voteTopicService")
public class VoteTopicServiceImpl extends BaseServiceImpl<VoteTopic, String>
		implements IVoteTopicService {
	private static Logger logger = LoggerFactory.getLogger(VoteTopicServiceImpl.class
			.getName());

	@Autowired
	private VoteTopicMapper voteTopicMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = voteTopicMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#insert(com.jcin.cms.service.channel.
	 * VoteTopic)
	 */
	@Override
	@Transactional
	public String insert(VoteTopic record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = voteTopicMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		VoteTopicCriteria voteTopicCriteria = new VoteTopicCriteria();
		voteTopicCriteria.setOrderByClause("id desc");
		voteTopicCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = voteTopicMapper.selectByExample(voteTopicCriteria);
		page.setRows(list);
		int total = voteTopicMapper.countByExample(voteTopicCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#select(com.jcin.cms.service.channel.VoteTopicCriteria)
	 */
	//@Override
	@Override
	public Page select(VoteTopicCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = voteTopicMapper.selectByExample(criteria);
		page.setRows(list);
		int total = voteTopicMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#selectAll()
	 */
	@Override
	public List<VoteTopic> selectAll() {
		List<VoteTopic> list = voteTopicMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public VoteTopic selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		VoteTopic article = voteTopicMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#update(com.jcin.cms.service.channel.
	 * VoteTopic)
	 */
	@Override
	@Transactional
	public String update(VoteTopic record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = voteTopicMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<VoteTopic> list) {
		int result = voteTopicMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IVoteTopicService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		VoteTopicCriteria voteTopicCriteria = new VoteTopicCriteria();
		voteTopicCriteria.createCriteria().andIdIn(list);
		int result = voteTopicMapper.deleteByExample(voteTopicCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<VoteTopic> selectByExample(
			VoteTopicCriteria criteria) {
		return  voteTopicMapper.selectByExample(criteria);
	}

}
