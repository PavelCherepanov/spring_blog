package com.blog.blog.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Pavel
 * @version 1.0
 * @date 30.01.2023 22:36
 */
@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("xmaksxasx@yandex.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);


        javaMailSender.send(message);

        System.out.println("Success");
    }
}
