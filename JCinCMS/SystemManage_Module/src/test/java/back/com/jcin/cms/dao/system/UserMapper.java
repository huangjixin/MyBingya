package back.com.jcin.cms.dao.system;

import java.util.List;

import com.jcin.cms.domain.system.User;

public interface UserMapper {
     
    List<User> getUsersByRoleId(String roleId);
}