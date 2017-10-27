package org.zt.ccty.springboot_mybatis_demo.testbean;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.zt.ccty.springboot_mybatis_demo.mail.MailService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("autumns@126.com","test simple mail"," hello this is simple mail by Jack Duan");
    }

    @Test
    public void sendHtmlMail() throws Exception {
    }

    @Test
    public void sendAttachmentsMail() throws Exception {
    }

    @Test
    public void sendInlineResourceMail() throws Exception {
    }

}