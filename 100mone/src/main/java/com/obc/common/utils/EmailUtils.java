package com.obc.common.utils;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.obc.common.constant.Canonical;

/**
 * 
 * @ClassName: EmailUtils
 *
 * @author FC
 * @Description: TODO 【发送邮件】
 * @date 2016年4月10日 上午11:53:23
 */
public class EmailUtils {

	/** 邮箱服务器的登录用户名 **/
	private static final String username = "system@100mone.com";
	/** 邮箱服务器的密码 **/
	private static final String password = "Fc13656110595";
	/** 邮箱服务器smtp host,此处采用自己的QQ邮箱作为邮件服务器 **/
	private static final String smtpHost = "smtp.exmail.qq.com";
	/** 发送方的邮箱（必须为邮箱服务器的登录用户名） **/
	private static final String fromEmail = "system@100mone.com";
	/** 发送方姓名 **/
	private static final String fromUsername = "system（100mone.com）";
	/** 邮件内容编码，防止乱码 **/
	private static final String charset = "UTF-8";


	/**
	 * 
	 * <br>方法名： send
	 * 
	 * <br>描述：【邮件发送】 
	 * <br>创建时间： 2016年5月31日 上午2:39:42 
	 * @param addressee 收件人邮箱
	 * @param html 邮件内容
	 * @param adjunct 附件信息【支持多附件】
	 */
	public static void send (	String addressee ,
								String html ,
								List<EmailAttachment> adjunct ) {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(false);//是否开启调试默认不开启  
			email.setSSLOnConnect(true);//开启SSL加密  
			email.setStartTLSEnabled(true);//开启TLS加密  
			//设置smtp host,此处采用自己的QQ邮箱作为邮件服务器  
			email.setHostName(EmailUtils.smtpHost);
			//登录邮件服务器的用户名和密码（保证邮件服务器POP3/SMTP服务开启）  
			email.setAuthentication(EmailUtils.username, EmailUtils.password);

			email.setFrom(EmailUtils.fromEmail, EmailUtils.fromUsername);
			//发送方
			email.addTo(addressee);
			email.setCharset(EmailUtils.charset);//设置邮件的字符集为UTF-8防止乱码  
			email.setSubject(Canonical.emailSubject);//主题 
			email.setHtmlMsg(html);//邮件内容
			//附件
			if (adjunct != null && adjunct.size() > 0) {
				for (EmailAttachment attachment : adjunct) {
					email.attach(attachment);
				}
			}
			email.send();//发送邮件
		}
		catch (EmailException e) {
			MoneStringUtils.log(e, EmailUtils.class);
		}
	}

}
