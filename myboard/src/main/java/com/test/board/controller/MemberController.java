package com.test.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.board.dao.MemberDao;
import com.test.board.page.Paging;
import com.test.board.service.BoardService;
import com.test.board.service.MailSendService;
import com.test.board.service.MemberService;
import com.test.board.vo.DonateVO;
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

	// 중복 확인
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(MemberVO memberVO) throws Exception {

		int result = memberService.idCheck(memberVO); 

		System.out.println(result);
		return result;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO member, Model model, HttpSession session, Paging navi, String searchWord) {
		MemberVO result = memberService.login(member);

		if (result == null) {
			model.addAttribute("message", "Id와 비밀번호를 확인하십시오.");
			return "login";
		} else if (result.getAuthstatus() == null) {
			model.addAttribute("message", "이메일인증이 완료 되지 않았습니다. 회원가입시 등록하신 이메일을 확인하여 인증을 완료 해주세요");
			return "login";
		} else {
			session.setAttribute("loginId", result.getId());
			model.addAttribute("list", boardService.selectAll(searchWord, navi));
			return "main";
		}
	}
	
	@RequestMapping(value = "/give", method = RequestMethod.POST)
	
	public void donate(@RequestBody HashMap<String, String> donateStr, DonateVO donate) {
		System.out.println(donateStr.get("buyer_name"));
		donate.setImp_uid(donateStr.get("imp_uid"));
		donate.setBuyer_name(donateStr.get("buyer_name"));
		donate.setPaid_amount(donateStr.get("paid_amount"));
		memberService.donate(donate);
		
	}

	@RequestMapping(value = "/signUpConfirm", method = RequestMethod.GET)
	public String signUpConfirm(MemberVO member, Model model) {
		model.addAttribute("email", member.getEmail());
		System.out.println(member.getEmail());
		memberService.updateAuthStatus(member);
		return "signUpConfirm";
	}

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
