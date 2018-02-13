package com.SchedulingMail2.SchedulingMail2.hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
//	@Autowired
//	public NotificationService(JavaMailSender javaMailSender) {
//		this.javaMailSender=javaMailSender;
//	}
	
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        mailMessage.setTo("mrk19933@gmail.com");
        //mailMessage.setFrom("pfeing3eme@gmail.com");
        mailMessage.setSubject("Riadh bombarding u");
        mailMessage.setText("hadhi app 3meltiha ana taw hhhhhhhhhhhh");
        
        javaMailSender.send(mailMessage);
    }
}