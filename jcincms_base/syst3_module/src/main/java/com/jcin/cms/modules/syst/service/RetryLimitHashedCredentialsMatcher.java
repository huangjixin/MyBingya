package com.jcin.cms.modules.syst.service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
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
        if(retryCount.incrementAndGet() > 5) {
            //if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }

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
            user.setLoginDate(new Date());
            userService.update(user);
        }
        return true;
    }
}
