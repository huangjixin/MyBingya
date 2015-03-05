package back.com.jcin.cms.dao.system;

import java.util.List;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.Role;

public interface RoleMapper {
    
    List<Role> getRolesByUserId(String userId);
    
    List<Authorization> getAuthorizationsByRoleId(String id);
}