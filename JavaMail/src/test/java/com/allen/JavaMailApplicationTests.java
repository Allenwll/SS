package com.allen;

import com.allen.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaMailApplicationTests {
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private TemplateEngine templateEngine;

	private String to="allenzyhang@163.com";
	private String subject="SpringBoot邮件服务";
	
	@Test
	public void contextLoads() {
	}
	@Test
	public void testSimpleMail() throws Exception {
		 String content="测试简单邮件";
		mailService.sendSimpleMail(to,subject,content);
	}
	
	@Test
	public void sendTemplateMail() {
		//创建邮件正文
		Context context = new Context();
		context.setVariable("site", "www.baidu.com");
		String emailContent = templateEngine.process("emailTemplate", context);
		mailService.sendHtmlMail(to,subject,emailContent);
	}
	
	@Test
	public void testHtmlMail() throws Exception{
		String content="<html>\n" +
					   "<body>\n" +
					   "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
					   "</body>\n" +
					   "</html>";
		mailService.sendHtmlMail(to,subject,content);
	}
	@Test
	public void testAttachmentsMail() throws Exception{
		String content="有附件，请查收";
		String filePath="e:\\绑定网站.txt";
		mailService.sendAttachmentsMail(to,subject,content,filePath);
	}
	
	@Test
	public void sendInlineResourceMail() {
		String rscId = "Allen001";
		String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "C:\\Users\\acer\\Pictures\\Camera Roll\\img0.jpg";
		
		mailService.sendInlineResourceMail(to, subject, content, imgPath, rscId);
	}
	
}
