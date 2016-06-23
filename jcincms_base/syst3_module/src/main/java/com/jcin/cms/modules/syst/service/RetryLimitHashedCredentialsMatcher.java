package com.jcin.cms.modules.syst.service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.jcin.cms.common.PasswordHelper;
import com.jcin.cms.modules.syst.domain.User;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	private IUserService userService;
	
    private Cache<String, AtomicInteger> passwordRetryCache;
    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if(retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        /*if(retryCount.incrementAndGet() > 5) {
            //if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }*/

//        boolean matches = super.doCredentialsMatch(token, info);
        boolean matches = false;
        String password = new String ((char[])token.getCredentials());
        String dbPassword = (String) info.getCredentials();
        if(password.equals(dbPassword)){
        	matches=true;
        }
        
        matches = PasswordHelper.validatePassword(password, dbPassword);
        if(matches) {
            passwordRetryCache.remove(username);
        }
        if(matches){
        	User user = userService.findByUsername(username);
            user.setLoginCount(1+user.getLoginCount());
            user.setLastLogin(user.getLoginDate());
            user.setLoginDate(new Date());
			user.setLoginIp(getIpAddr(request));
            userService.update(user);
        }
        return matches;
    }
    
    public String getIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    } 
}
