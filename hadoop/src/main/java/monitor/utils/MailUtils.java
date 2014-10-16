package monitor.utils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class MailUtils {

	/**
	 * 告警专用
	 * @param content
	 */
	public static void  sendMail(String subject, String content){
		SimpleMail sendMail = new SimpleMail("wsg96321@126.com","wsg.96321");
		sendMail.setToMail("wangsonggen@91.com");
		sendMail.setContent(content);
		sendMail.setSubject(subject);
		SimpleMailSender mailSender = MailSenderFactory.getSender(sendMail);
		try {
			mailSender.send(sendMail);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void alarm(String content){
		sendMail("hadoop集群告警邮件",content);
	}
}
