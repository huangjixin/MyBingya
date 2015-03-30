/**
 * 一句话描述该类：实现Realm<br/>
 * @author 黄记新
 * @date 2015-3-30,下午3:09:51
 *
 */
/**
 * 
 */
package com.jcin.cms.web;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * @author Administrator
 * 
 */
public class MyRealm implements Realm {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.Realm#getAuthenticationInfo(org.apache.shiro.authc
	 * .AuthenticationToken)
	 */
	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		String username = (String) token.getPrincipal(); // 得到用户名
		String password = new String((char[]) token.getCredentials()); // 得到密码
		if (!"zhang".equals(username)) {
			throw new UnknownAccountException(); // 如果用户名错误
		}
		if (!"123".equals(password)) {
			throw new IncorrectCredentialsException(); // 如果密码错误
		}
		// 如果身份认证验证成功，返回一个AuthenticationInfo实现；
		return new SimpleAuthenticationInfo(username, password, getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.realm.Realm#getName()
	 */
	@Override
	public String getName() {
		return "myRealm";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.realm.Realm#supports(org.apache.shiro.authc.
	 * AuthenticationToken)
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		// 仅支持UsernamePasswordToken类型的Token
		return token instanceof UsernamePasswordToken;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
