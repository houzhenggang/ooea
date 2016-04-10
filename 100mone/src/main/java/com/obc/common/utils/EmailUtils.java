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
	private static final String fromUsername = "100mone(system)";
	/** 邮件内容编码，防止乱码 **/
	private static final String charset = "UTF-8";

	/**
	 * 
	 * @Title: sendEmail
	 * 
	 * @author FC
	 * @Description: TODO 【java发送邮件-commons-email】
	 * @param nameAndAddrMap 用户名及对应的邮箱组成的Map
	 * @param subject 邮件主题或标题
	 * @param htmlContent 邮件内容html格式
	 * @throws EmailException
	 * @throws MessagingException
	 * @date 2016年4月10日 下午5:28:55
	 */
	@Deprecated
	public static void sendEmail (	Map<String, String> nameAndAddrMap ,
									String subject ,
									String htmlContent )	throws EmailException ,
															MessagingException {
		/*
		 * ImageHtmlEmail:HTML文本的邮件、通过2代码转转内联图片, 1.3新增的，但我怎么也测试不成功
		 * ImageHtmlEmail网上都是官网上例子而官网上例子比较模糊
		 * ImageHtmlEmail email=new ImageHtmlEmail();
		 */
		HtmlEmail email = new HtmlEmail();//创建能加附件内容为HTML文本的邮件、HTML直接内联图片但必须用setHtmlMsg()传邮件内容  

		for (Map.Entry<String, String> map : nameAndAddrMap.entrySet()) {//遍历用户名及对应的邮箱地址组成的map  
			email.addTo(map.getValue(), map.getKey());//接收方邮箱和用户名  
		}
		//email.addCc("chen_leixing@qq.com");//抄送方  
		//email.addBcc("leixing_chen@120.com");//秘密抄送方  

		email.setCharset(EmailUtils.charset);//设置邮件的字符集为UTF-8防止乱码  
		email.setSubject(subject);//主题  
		email.setHtmlMsg(htmlContent);//邮件内容:<font color='red'>测试简单邮件发送功能！</font>  

		//创建邮件附件可多个   
		EmailAttachment attachment = new EmailAttachment();//创建附件  
		attachment.setPath("D:\\MongoDB.txt");//本地附件，绝对路径    
		//attachment.setURL(new URL("http://www.baidu.com/moumou附件"));//可添加网络上的附件  
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("MongoDB入门精通");//附件描述   
		attachment.setName("NoSQL数据库");//附件名称  
		email.attach(attachment);//添加附件到邮件,可添加多个  
		email.attach(attachment);//添加附件到邮件,可添加多个  
		email.send();//发送邮件  
	}

	/**
	 * 
	 * @Title: send
	 * 
	 * @author FC
	 * @Description: TODO 【邮件发送】
	 * @param addressee 收件人邮箱
	 * @param html 邮件内容
	 * @param adjunct 附件信息【支持多附件】
	 * @throws EmailException
	 * @date 2016年4月10日 下午5:42:10
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
			IStringUtils.log(e, EmailUtils.class);
		}
	}

	public static void main ( String[] args ) throws EmailException {
		EmailUtils.send("201692131@qq.com", "<img src='http://img.hb.aicdn.com/d2024a8a998c8d3e4ba842e40223c23dfe1026c8bbf3-OudiPA_fw580'/><a href='http://run01.com/consumer/register.do'>点击注册</a>", null);
	}
}
