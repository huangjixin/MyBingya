/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.channel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.channel.dao.ChannelMapper;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.ChannelCriteria;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="channelService")
public class ChannelServiceImpl extends BaseServiceImpl<Channel, String>
		implements IChannelService {
	private static Logger logger = Logger.getLogger(ChannelServiceImpl.class
			.getName());

	@Resource
	private ChannelMapper channelMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = channelMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#insert(com.jcin.cms.service.channel.
	 * Channel)
	 */
	@Override
	@Transactional
	public String insert(Channel record) {
		 super.insert(record);
		 if("".equals(record.getParentId())){
			 record.setParentId(null);
		 }
//		record.setCreateDate(new Date());
		int result = channelMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		ChannelCriteria channelCriteria = new ChannelCriteria();
		channelCriteria.setOrderByClause("id desc");
		channelCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = channelMapper.selectByExample(channelCriteria);
		page.setRows(list);
		int total = channelMapper.countByExample(channelCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#select(com.jcin.cms.service.channel.ChannelCriteria)
	 */
	//@Override
	public Page select(ChannelCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = channelMapper.selectByExample(criteria);
		page.setRows(list);
		int total = channelMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#selectAll()
	 */
	@Override
	public List<Channel> selectAll() {
		List<Channel> list = channelMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Channel selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Channel article = channelMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#update(com.jcin.cms.service.channel.
	 * Channel)
	 */
	@Override
	@Transactional
	public String update(Channel record) {
		if ("".equals(record.getParentId())) {
			record.setParentId(null);
		}
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = channelMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Channel> list) {
		for (Channel channel : list) {
			if ("".equals(channel.getParentId())) {
				channel.setParentId(null);
			} 
		}
		
		int result = channelMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IChannelService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		ChannelCriteria channelCriteria = new ChannelCriteria();
		channelCriteria.createCriteria().andIdIn(list);
		int result = channelMapper.deleteByExample(channelCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Channel> selectByExample(
			ChannelCriteria criteria) {
		return  channelMapper.selectByExample(criteria);
	}

	@Override
	public List<Channel> getChannelTree(List<Channel> channels) {
		ChannelCriteria channelExample = new ChannelCriteria();
		channelExample.createCriteria().andParentIdIsNull();
		channelExample.setOrderByClause("sort asc");
		List<Channel> list = channelMapper.selectByExample(channelExample);
		List<Channel> children = new ArrayList<Channel>();
		for (Channel object : list) {
			Channel jsonObject = null;
			if(null != channels){
				for (Channel channel : channels) {
					if(object.getId().equals(channel.getId())){
						jsonObject.setChecked(true);
						break;
					}
				}
			}
			
			jsonObject = searialChannel(object,channels);
			if (jsonObject != null) {
				children.add(jsonObject);
			}
		}
		return children;
	}

	@SuppressWarnings("rawtypes")
	public Channel searialChannel(Channel channel,List<Channel> orgs){

		Channel jsonObject = new Channel();
		jsonObject.setId(channel.getId());
		jsonObject.setParentId(channel.getParentId());
		jsonObject.setCode(channel.getCode());
		jsonObject.setDescrition(channel.getDescrition());
		jsonObject.setKeyword(channel.getKeyword());
		jsonObject.setLinkAddr(channel.getLinkAddr());
		jsonObject.setOpenMode(channel.getOpenMode());
		jsonObject.setName(channel.getName());
		jsonObject.setAsdocument(channel.getAsdocument());
		jsonObject.setChannelTemplete(channel.getChannelTemplete());
		jsonObject.setAsdocument(channel.getAsdocument());
		jsonObject.setHidden(channel.getHidden());
		jsonObject.setDocumentId(channel.getDocumentId());

		List<Channel> list = searialChild(channel,orgs);
		if (null != list) {
			jsonObject.setChildren(list);
		}

		return jsonObject;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Channel> searialChild(Channel channel,List<Channel> channels){
		List children = null;
		List<Channel> list = getByParentId(channel.getId());
		if (list != null && list.size() > 0) {
			children = new ArrayList();
		}
		for (Channel object : list) {
			if(null != channels){
				for (Channel channel1 : channels) {
					if(object.getId().equals(channel1.getId())){
						object.setChecked(true);
						break;
					}
				}
			}
			
			Channel jsonObject = searialChannel(object,channels);
			if (jsonObject != null) {
				children.add(jsonObject);
			}
		}
		return children;
	}

	@Override
	public List<Channel> getByParentId(String id) {
		ChannelCriteria channelCriteria = new ChannelCriteria();
		channelCriteria.createCriteria().andParentIdEqualTo(id);
		List<Channel> list = channelMapper.selectByExample(channelCriteria);

		return list;
	}

	@Override
	public Channel getByCode(String code) {
		ChannelCriteria channelCriteria = new ChannelCriteria();
		channelCriteria.createCriteria().andCodeEqualTo(code);
		List<Channel> list = channelMapper.selectByExample(channelCriteria);
		if(list!=null&&list.size()!=0){
			List<Channel> children = new ArrayList<Channel>();
			for (Channel object : list) {
				Channel jsonObject = null;
				
				jsonObject = searialChannel(object,null);
				if (jsonObject != null) {
					children.add(jsonObject);
				}
			}
			list = children;
		}
		
		return list==null||list.size()==0 ? null :list.get(0);
	}

	@Override
	public List<Channel> getChannelTree() {
		ChannelCriteria channelCriteria = new ChannelCriteria();
		channelCriteria.createCriteria().andParentIdIsNull();
		List<Channel> list = channelMapper.selectByExample(channelCriteria);
		if(list!=null&&list.size()!=0){
			List<Channel> children = new ArrayList<Channel>();
			for (Channel object : list) {
				Channel jsonObject = null;
				
				jsonObject = searialChannel(object,null);
				if (jsonObject != null) {
					children.add(jsonObject);
				}
			}
			list = children;
		}
		
		return list;
	}
}
