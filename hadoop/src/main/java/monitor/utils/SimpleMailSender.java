package monitor.utils;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 简单邮件发送器，可单发，群发。
 * 
 * @author MZULE
 * 
 */
public class SimpleMailSender {

	/**
	 * 发送邮件的props文件
	 */
	private final transient Properties props = System.getProperties();

	/**
	 * 邮箱session
	 */
	private transient Session session;

	/**
	 * 初始化邮件发送器
	 * 
	 */
	public SimpleMailSender(SimpleMail mail) {
		if (null == mail.getSmtpAddress()) {
			// 通过邮箱地址解析出smtp服务器，对大多数邮箱都管用
			String smtpHostName = "smtp." + mail.getUsername().split("@")[1];
			mail.setSmtpAddress(smtpHostName);
		}
		init(mail);
	}

	/**
	 * 初始化
	 * 
	 */
	private void init(SimpleMail mail) {
		// 初始化props
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", mail.getSmtpAddress());
		// 创建session | 验证
		session = Session.getInstance(props, mail);
	}

	/**
	 * 发送邮件
	 * 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void send(SimpleMail mail) throws AddressException,
			MessagingException {
		// 创建mime类型邮件
		final MimeMessage message = new MimeMessage(session);
		// 设置发信人
		message.setFrom(new InternetAddress(mail.getUsername()));
		// 设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(mail.getToMail()));
		// 设置主题
		message.setSubject(mail.getSubject());
		// 设置邮件内容
		message.setContent(mail.getContent(), "text/html;charset=utf-8");
		// 发送
		Transport.send(message);
	}

}