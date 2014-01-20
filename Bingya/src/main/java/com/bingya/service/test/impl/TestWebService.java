/**
 * 
 */
package com.bingya.service.test.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Administrator
 *
 */
@WebService
public class TestWebService {

	@WebMethod
	public void hello() {
		System.out.println("hello,world");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
