package test.com.jcin.cms.service.system.impl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.web.SpringTestCase;
  
/** 
 * 功能概要：UserService单元测试 
 *  
 * @author linbingwen 
 * @since  2015年9月28日  
 */  
public class UserServiceTest extends SpringTestCase {  
    @Autowired  
    private IUserService userService;  
    Logger logger = Logger.getLogger(UserServiceTest.class);  
      
    @Test  
    public void selectUserByIdTest(){  
        User user = userService.findByUsername("admin");  
        logger.debug("查找结果" + user);  
    }  
      
  
}  