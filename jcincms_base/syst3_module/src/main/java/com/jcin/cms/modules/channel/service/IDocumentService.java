package  com.jcin.cms.modules.channel.service;

import java.util.List;

import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IDocumentService extends IBaseService<Document, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(DocumentCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Document> selectByExample(DocumentCriteria criteria);

	/**
	 * 根据栏目ID查询文档
	 * @param id
	 * @return
	 */
	List<Document> getDocByChannelId(String channelId,Page page);
	
	/**
	 * 根据栏目ID查询文档
	 * @param id
	 * @return
	 */
	List<Document> getDocByChannelId(String channelId);
	
	/**
	 * 查询推荐文档。
	 * @param id
	 * @return
	 */
	List<Document> getRecommendDoc(Page page);
	
	/**
	 * 查询推荐图片。
	 * @param id
	 * @return
	 */
	List<Document> getRecommendImage(Page page);
	
	/**
	 * 查询栏目点击率前十的文档,如果channelId不为空则查询该栏目点击率前十的文档。
	 * @param id
	 * @return
	 */
	List<Document> getClickCountDoc(String code,Page page);

	/**
	 * 根据栏目代码进行查询。
	 * @param Code
	 * @param documentCriteria
	 * @return
	 */
	List<Document> getDocByChannelCode(String code,Page page);
	
	 /**
     * 查询上一条记录
     * @param id
     * @return
     */
    Document selectLastRecord(Document document);
    /**
     * 查询下一条记录
     * @param id
     * @return
     */
    Document selectNextRecord(Document document);
    
    /**
     * 修改文章点击次数。
     * @param id
     * @param count
     * @return
     */
    int updateClickCount(String id,int count);
}