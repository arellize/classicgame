package kr.io.classicgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.io.classicgame.domain.Cgame1;
import kr.io.classicgame.domain.Cgame2;
import kr.io.classicgame.domain.Cgame3;
import kr.io.classicgame.service.Cgame1Service;
import kr.io.classicgame.service.Cgame2Service;
import kr.io.classicgame.service.Cgame3Service;

@RestController
public class ScoreController {

	@Autowired
	private Cgame1Service cgame1service;
	
	@Autowired
	private Cgame2Service cgame2service;
	
	@Autowired
	private Cgame3Service cgame3service;
	
	@PostMapping("/insertCgame1")
	public String insertCgame1(Cgame1 cgame1) {
		if(cgame1.getNickname() == null) {
			return "redirect:showerror";
		}
		cgame1service.insertCgame1(cgame1);
		System.out.println("---cgame1insert---");
		return "redirect:main";
		
	}

	@PostMapping("/insertCgame2")
	public String insertCgame2(Cgame2 cgame2) {
		if(cgame2.getNickname() == null) {
			return "redirect:showerror";
		}
		cgame2service.insertCgame2(cgame2);
		System.out.println("---cgame2insert---");
		return "redirect:main";
		
	}
	
	
	@PostMapping("/insertCgame3")
	public String insertCgame3(Cgame3 cgame3) {
		if(cgame3.getNickname() == null) {
			return "redirect:showerror";
		}
		cgame3service.insertCgame3(cgame3);
		System.out.println("---cgame1insert---");
		return "redirect:main";
		
	}
	
	
}
