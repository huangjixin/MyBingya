/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-6-5,下午3:30:35
 *
 */
package com.jcin.cms.service.activemq;

import javax.jms.Destination;

public interface ProducerService {

	public abstract void sendMessage(Destination destination, String message);

}