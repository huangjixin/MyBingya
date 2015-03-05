package back.com.jcin.cms.dao.system;

import java.util.List;

import com.jcin.cms.domain.system.Authorization;

public interface AuthorizationMapper {
    /**
     * 根据菜单查询访问列表。
     * @param userId
     * @return
     */
    List<Authorization> selectByUserId(String userId);
}