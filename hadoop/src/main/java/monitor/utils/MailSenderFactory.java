package monitor.utils;

/**
 * 发件箱工厂
 * 
 * @author MZULE
 * 
 */
public class MailSenderFactory {

	/**
	 * 服务邮箱
	 */
	private static SimpleMailSender serviceSms = null;

	/**
	 * 获取邮箱
	 * @param sendMail 
	 * 
	 * @param type
	 *            邮箱类型
	 * @return 符合类型的邮箱
	 */
	public static SimpleMailSender getSender(SimpleMail mail) {
		if (serviceSms == null) {
			serviceSms = new SimpleMailSender(mail);
			return serviceSms;
		}
		
		return serviceSms;
	}

}