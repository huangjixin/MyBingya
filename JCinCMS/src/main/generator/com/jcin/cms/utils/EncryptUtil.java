package com.jcin.cms.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * js加密/解密。
 * 
 * @author 黄记新
 * 
 */
public class EncryptUtil {
	
	private Invocable invocable;
	private ScriptEngineManager sem;
	private ScriptEngine se;

//	private static EncryptUtil instance;
	
	public EncryptUtil(){
		if (sem == null) {
			sem = new ScriptEngineManager();
		}
		if (se == null) {
			se = sem.getEngineByExtension("js");
			String path = EncryptUtil.class.getResource("").getPath(); 
			path+="encrypt.js";
			try {
				se.eval(new FileReader(path));
			} catch (FileNotFoundException e) {
				System.out.println("加密Js文件找不到，请把文件放到与当前类同一个路径下");
				e.printStackTrace();
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public static EncryptUtil getInstance() {
//		if (null == null) {
//			instance = new EncryptUtil();
//		}
//
//		return instance;
//	}

	/**
	 * 64位解密
	 * @param source
	 * @return
	 */
	public Object decrypt(String source) {
		Object result = null;
		if (se instanceof Invocable) {
			Invocable invocable = (Invocable) se;
			// JS引擎调用方法
			try {
				result = invocable.invokeFunction("base64decode", source);
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.out.println("脚本没有当前方法");
				e.printStackTrace();
			}
		}
		return result;
	}
}
