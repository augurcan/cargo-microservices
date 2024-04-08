package com.cargo.mailservice.service;

import com.cargo.mailservice.dto.MailDto;
import com.cargo.mailservice.dto.UserDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender javaMailSender;

    @Value("${SPRING_MAIL_USERNAME}")
    private String mailUsername;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @RabbitListener(queues = "mailQueue")
    public void sendMail(MailDto mailDto){
        javaMailSender.send(createMessage(mailDto.getSender()));
        javaMailSender.send(createMessage(mailDto.getRecipient()));
    }
    private SimpleMailMessage createMessage(UserDto userDto){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailUsername);
        simpleMailMessage.setTo(userDto.getEmail());
        simpleMailMessage.setText("sample text");
        simpleMailMessage.setSubject("sample subject");
        return simpleMailMessage;
    }
}
