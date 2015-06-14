import javax.mail.MessagingException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * 一句话描述该类：<br/>
 * 
 * @author 黄记新
 * @date 2015-6-14,下午6:06:41
 * 
 */
public class TestMail {

	static ApplicationContext actx = new ClassPathXmlApplicationContext(
			"spring/applicationContext-mail.xml");
	static MailSender sender = (MailSender) actx.getBean("mailSender");
	static SimpleMailMessage mailMessage = (SimpleMailMessage) actx
			.getBean("mailMessage");

	public static void main(String args[]) throws MessagingException {
		mailMessage.setSubject("你好");
		mailMessage.setText("这个是一个通过Spring框架来发送邮件的小程序");
		mailMessage.setTo("635152644@qq.com");
		sender.send(mailMessage);
	}

}
