/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-5-20,上午11:09:22
 *
 */
/**
 * 
 */
package com.jcin.cms.web;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

/**
 * @author Administrator
 *
 */
public class ApplicationConversionServiceFactoryBean extends
		FormattingConversionServiceFactoryBean {
	
	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
