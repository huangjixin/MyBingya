/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.pro.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.pro.dao.ImagesMapper;
import com.jcin.cms.modules.pro.domain.Images;
import com.jcin.cms.modules.pro.domain.ImagesCriteria;
import com.jcin.cms.modules.pro.service.IImagesService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="imagesService")
public class ImagesServiceImpl extends BaseServiceImpl<Images, String>
		implements IImagesService {
	private static Logger logger = Logger.getLogger(ImagesServiceImpl.class
			.getName());

	@Autowired
	private ImagesMapper imagesMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = imagesMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#insert(com.jcin.cms.service.pro.
	 * Images)
	 */
	@Override
	@Transactional
	public String insert(Images record) {
		if(record.getId()==null)
		 	super.insert(record);
		if(null==record.getCreateDate())
			record.setCreateDate(new Date());
		int result = imagesMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		ImagesCriteria imagesCriteria = new ImagesCriteria();
		imagesCriteria.setOrderByClause("id desc");
		imagesCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = imagesMapper.selectByExample(imagesCriteria);
		page.setRows(list);
		int total = imagesMapper.countByExample(imagesCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#select(com.jcin.cms.service.pro.ImagesCriteria)
	 */
	//@Override
	public Page select(ImagesCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = imagesMapper.selectByExample(criteria);
		page.setRows(list);
		int total = imagesMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#selectAll()
	 */
	@Override
	public List<Images> selectAll() {
		List<Images> list = imagesMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Images selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Images record = imagesMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#update(com.jcin.cms.service.pro.
	 * Images)
	 */
	@Override
	@Transactional
	public String update(Images record) {
		// super.update(record);
//		if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());
		int result = imagesMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Images> list) {
		for (Images record : list) {
			if(record.getId()==null  || "".equals(record.getId())){
				record.setId(""+new Date().getTime());
			}
		}
		int result = imagesMapper.insertBatch(list);
		
//		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IImagesService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		ImagesCriteria imagesCriteria = new ImagesCriteria();
		imagesCriteria.createCriteria().andIdIn(list);
		int result = imagesMapper.deleteByExample(imagesCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Images> selectByExample(
			ImagesCriteria criteria) {
		return  imagesMapper.selectByExample(criteria);
	}

}
