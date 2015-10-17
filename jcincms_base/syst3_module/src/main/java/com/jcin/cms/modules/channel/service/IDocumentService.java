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
}