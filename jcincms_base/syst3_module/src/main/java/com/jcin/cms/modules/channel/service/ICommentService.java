package  com.jcin.cms.modules.channel.service;

import java.util.List;

import com.jcin.cms.modules.channel.domain.Comment;
import com.jcin.cms.modules.channel.domain.CommentCriteria;
import com.jcin.cms.modules.channel.service.ICommentService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface ICommentService extends IBaseService<Comment, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(CommentCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Comment> selectByExample(CommentCriteria criteria);
}