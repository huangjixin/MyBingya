/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.channel.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.common.FileUtils;
import com.jcin.cms.modules.channel.dao.AssetsMapper;
import com.jcin.cms.modules.channel.dao.ChannelMapper;
import com.jcin.cms.modules.channel.dao.DocumentMapper;
import com.jcin.cms.modules.channel.domain.Assets;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="documentService")
public class DocumentServiceImpl extends BaseServiceImpl<Document, String>
		implements IDocumentService {
	private static Logger logger = Logger.getLogger(DocumentServiceImpl.class
			.getName());

	@Resource
	private IChannelService channelService;
	
	@Resource
	private DocumentMapper documentMapper;
	@Resource
	private AssetsMapper assetsMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = documentMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#insert(com.jcin.cms.service.channel.
	 * Document)
	 */
	@Override
	@Transactional
	public String insert(Document record) {
		if(null == record.getId()||"".equals(record.getId())){
			super.insert(record);
		}

//		record.setCreateDate(new Date());
		int result = documentMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		DocumentCriteria documentCriteria = new DocumentCriteria();
		documentCriteria.setOrderByClause("id desc");
		documentCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = documentMapper.selectByExample(documentCriteria);
		page.setRows(list);
		int total = documentMapper.countByExample(documentCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#select(com.jcin.cms.service.channel.DocumentCriteria)
	 */
	//@Override
	public Page select(DocumentCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = documentMapper.selectByExample(criteria);
		page.setRows(list);
		int total = documentMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#selectAll()
	 */
	@Override
	public List<Document> selectAll() {
		List<Document> list = documentMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Document selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Document article = documentMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#update(com.jcin.cms.service.channel.
	 * Document)
	 */
	@Override
	@Transactional
	public String update(Document record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = documentMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Document> list) {
		int result = documentMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * 删除文档的时候，要先删除附件。
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IDocumentService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		if(list.size()>0){
			for (String id : list) {
				Document document = documentMapper.selectByPrimaryKey(id);
				String assetsIds = document.getAssetsIds();
				if(null != assetsIds && !"".equals(assetsIds)){
					String[] ids = assetsIds.split(",");
					for (String assetid : ids) {
						Assets assets = assetsMapper.selectByPrimaryKey(assetid);
						String uploadPath = assets.getPath();
						File file = new File(uploadPath);
						logger.info(file.exists());
						FileUtils.deleteFile(uploadPath);
						
						assetsMapper.deleteByPrimaryKey(assetid);
					}
				}
			}
		}
		DocumentCriteria documentCriteria = new DocumentCriteria();
		documentCriteria.createCriteria().andIdIn(list);
		int result = documentMapper.deleteByExample(documentCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Document> selectByExample(
			DocumentCriteria criteria) {
		return  documentMapper.selectByExample(criteria);
	}

	@Override
	public List<Document> getDocByChannelId(String channelId,Page page) {
		DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		criteria.andChannelIdEqualTo(channelId);
		documentCriteria.setPage(page);
//		documentCriteria.setOrderByClause("id desc");
		List<Document> list  = documentMapper.selectByExample(documentCriteria);
		return list;
	}

	@Override
	public List<Document> getDocByChannelId(String channelId) {
		DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		criteria.andChannelIdEqualTo(channelId);
		List<Document> list  = documentMapper.selectByExample(documentCriteria);
		return list;
	}

	@Override
	public List<Document> getRecommendDoc(Page page) {
		DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		criteria.andRecommendEqualTo(true);
		documentCriteria.setPage(page);
		documentCriteria.setOrderByClause("recommend desc, id desc");
		List<Document> list  = documentMapper.selectByExample(documentCriteria);
		return list;
	}

}
