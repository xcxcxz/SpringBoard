package com.test.board.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSendServiceImpl implements MailSendService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public String sendAuthMail(String email) {
		Random random = new Random();
		int authKey = random.nextInt(888888) + 111111; 
		String setFrom = "zzosukeshop@gmail.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "<h1>[이메일 인증]</h1><br><p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
                + "<a href='http://localhost:8080/member/signUpConfirm?email=" 
                + email + "&authKey=" + authKey + "' target='_blenk'>이메일 인증 확인</a>";
		
		try {
			  
			  MimeMessage message = mailSender.createMimeMessage(); MimeMessageHelper
			  helper = new MimeMessageHelper(message, true, "utf-8");
			  helper.setFrom(setFrom); helper.setTo(toMail); helper.setSubject(title);
			  helper.setText(content,true); mailSender.send(message);
			  
			  }catch(Exception e) { e.printStackTrace(); }
		
		String num = Integer.toString(authKey);
		return num;
	}
		
	

}
