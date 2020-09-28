package com.mapc.yzcms.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * 邮箱工具
 *
 * @author duchao
 */
@Component
public class MailUtil {

	private final MailSender mailSender;
	@Value("${spring.mail.username}")
	private String username;

	@Autowired
	public MailUtil(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * 发邮件
	 *
	 * 注意：实现消息模板可定制，可以创建cms_mail_template表，暂不定制
	 *
	 * @param toMailbox    目标邮箱
	 * @param emailSubject 邮件主题
	 * @param emailContent 邮件内容
	 */
	public void sendEmail(String toMailbox, String emailSubject, String emailContent) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(username);
		message.setTo(toMailbox);
		message.setSubject(emailSubject);
		message.setText(emailContent);
		mailSender.send(message);
	}
}
