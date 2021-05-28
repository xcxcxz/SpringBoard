package com.test.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.board.service.BoardService;
import com.test.board.service.MailSendService;
import com.test.board.service.MemberService;
import com.test.board.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	BoardService boardService;

	@Autowired
	MailSendService mss;

	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String insertMember() {
		return "reg";
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String insertMember(MemberVO member, Model model) {
		int result = memberService.insertMember(member);

		if (result == 0) {
			model.addAttribute("message", "이미 사용중 입니다.");
			return "reg";
		} else {
			String authKey = mss.sendAuthMail(member.getEmail());
			member.setAuthkey(authKey);

			Map<String, String> map = new HashMap<String, String>();
			map.put("authKey", member.getAuthkey());
			map.put("email", member.getEmail());
			System.out.println(map);
			memberService.updateAuthKey(member);
		}

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO member, Model model, HttpSession session) {
		MemberVO result = memberService.login(member);

		if (result == null) {
			model.addAttribute("message", "Id와 비밀번호를 확인하십시오.");
			return "login";
		} else {
			session.setAttribute("loginId", result.getId());
			model.addAttribute("list", boardService.selectAll());
			return "main";
		}
	}
	
	//@GetMapping
	//public ModelAndView signUpConfirm(@RequestParam )

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(MemberVO member, Model model, HttpSession session) {
		System.out.println((String) session.getAttribute("loginId"));
		return "main";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(MemberVO member, Model model, HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping(value = "/deleteMember", method = RequestMethod.POST)
	public String deleteMember(HttpSession session) {
		String id = (String) session.getAttribute("loginId");
		memberService.deleteMember(id);
		return "redirect:/";
	}

}
