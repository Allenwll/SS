package com.allen.service.impl;

import com.allen.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 功能:
 *
 * @date: 2018-10-15 15:05
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
public class MailServiceImpl implements MailService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${mail.fromMail.addr}")
    private String from;
    
    @Override
    public void sendSimpleMail(final String to, final String subject, final String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setSubject(subject);
        //msg.setText(content，true);  解析html
        msg.setText(content);
        
        try {
            mailSender.send(msg);
            LOGGER.info("简单邮件已经发送。");
        } catch (Exception e) {
            LOGGER.error("发送简单邮件时发生异常！", e);
        }
    }
    
    @Override
    public void sendHtmlMail(final String to, final String subject, final String content) {
        MimeMessage msg = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(msg);
            LOGGER.info("HTML邮件发送成功!");
        } catch (Exception e) {
            LOGGER.error("发送HTML邮件时发生异常！", e);
        }
    }
    
    @Override
    public void sendAttachmentsMail(final String to, final String subject, final String content, final String filePath) {
        MimeMessage msg = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(msg);
            LOGGER.info("带附件的邮件已经发送!");
        } catch (Exception e) {
            LOGGER.error("发送带附件的邮件时发生异常！", e);
        }
    }
    
    @Override
    public void sendInlineResourceMail(final String to, final String subject, final String content, final String rscPath, final String rscId) {
        MimeMessage message = mailSender.createMimeMessage();
    
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
        
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
        
            mailSender.send(message);
            LOGGER.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            LOGGER.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }
}
