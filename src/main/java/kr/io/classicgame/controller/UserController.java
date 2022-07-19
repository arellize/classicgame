package kr.io.classicgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.io.classicgame.domain.Usertable;
import kr.io.classicgame.service.UserService;

@SessionAttributes("User")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/* pw저장 시에는 비밀번호 그대로 말고 바꿔서 저장하는 기능 넣어야 할듯. */
	@PostMapping("/signup")
	public void signUpUser(Usertable user) {
		
		boolean result = userService.insertUser(user);
		
		if(result) {
			System.out.println("저장 성공");
		}else {
			System.out.println("저장 실패");
		}
	}
	
	/* 로그인 인증 방법 boot security 통해서 추가 구현 예정. */
	@PostMapping("/login") 
	public void login(Usertable user, Model model) {
		Usertable findUser = userService.getUser(user);
		
		if (findUser != null && findUser.getPw().equals(user.getPw())) {
			model.addAttribute("user", findUser);
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
	}
	
	@GetMapping("/logout")
	public void logout(SessionStatus status) {
		status.setComplete();
		System.out.println("로그아웃 완료");
	}
	
}
