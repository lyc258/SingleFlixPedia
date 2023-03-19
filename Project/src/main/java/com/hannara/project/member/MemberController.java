package com.hannara.project.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/main")
	public String main() {
		return "main";
	}

	@RequestMapping(value = "/loginForm")
	public String loginForm(MemberDto dto) {
		return "member/loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String member_id, String pwd, boolean rememberid, HttpServletRequest request,
			HttpServletResponse response) {
		if (!logincheck(member_id, pwd)) {
			//System.out.println(member_id);
			//System.out.println(pwd);
			return "redirect:/loginForm";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("member_id", member_id);

			//System.out.println("-------");
			//System.out.println("-----");

			return "main";
		}

	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/main";
		
	}

	@RequestMapping("/register")
	public String register() {
		return "member/registerForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDto dto) {
		memberService.join(dto);
		return "redirect:/main";

	}

	private boolean logincheck(String member_id, String pwd) {
		MemberDto dto = memberService.getinfo(member_id);
		//System.out.println(dto);
		return dto != null && dto.getMember_id().equals(member_id);
	}
}
