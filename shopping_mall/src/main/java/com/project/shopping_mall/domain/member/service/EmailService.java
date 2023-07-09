package com.project.shopping_mall.domain.member.service;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;
    private String authNum;

    // RandomCode 만들기
    private String createRandomCode(){
        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for(int i=0; i<8; i++){
            int index = random.nextInt(3);

            switch (index){
                case 0:
                    // a~z (Ex. 1+97 = 98 -> (char) 98 = 'b')
                    key.append((char) (random.nextInt(26)+97));
                    break;
                case 1:
                    // A~Z
                    key.append((char) (random.nextInt(26)+65)) ;
                    break;
                case 2:
                    // 0~9
                    key.append((random.nextInt(9)));
                    break;
            }
        }

        return key.toString();
    }

    // 메일 양식 작성
    private MimeMessage createEmail(String email) throws MessagingException, UnsupportedEncodingException{

        authNum = createRandomCode();
        String setFrom = "test1234@gmail.com"; // 보내는 사람
        String toEmail = email; // 받는 사람
        String title = "회원가입 인증 번호입니다."; // 제목

        MimeMessage message = javaMailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, toEmail); // 받는 사람 이메일 설정
        message.setSubject(title); // 제목 설정
        message.setFrom(setFrom); // 보내는 이메일
        message.setText(setContext(authNum),"utf-8","html"); // Text 설정

        return message;
    }

    // 실제 메일 전송
    public String sendEmail(String toEmail) throws MessagingException, UnsupportedEncodingException {

        // 메일 전송에 필요한 정보 설정
        MimeMessage emailForm = createEmail(toEmail);

        // 실제 메일 전송
        javaMailSender.send(emailForm);

        return authNum;
    }

    // 타임 리프를 이용한 context 설정
    private String setContext(String code){
        Context context = new Context();
        context.setVariable("code", code);

        return templateEngine.process("mail", context); // mail.html
    }


}