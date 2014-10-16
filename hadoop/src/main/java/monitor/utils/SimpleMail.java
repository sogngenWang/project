package monitor.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SimpleMail extends Authenticator {
	//用户邮箱
	private String username;
	//邮箱密码
	private String password;
	// 发送邮箱的smtp邮件服务器地址
	private String smtpAddress;
	// 目标邮箱具体地址
	private String toMail;

	// 需要发送的邮件内容
	private String content;
	// 需要发送的邮件主题
	private String subject;

	public String getContent() {
		return content;
	}

	public String getSmtpAddress() {
		return smtpAddress;
	}

	public void setSmtpAddress(String smtpAddress) {
		this.smtpAddress = smtpAddress;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SimpleMail(String username, String password) {
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}

}
