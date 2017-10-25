package com.root.healing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.BoardDto;
import com.root.healing.model.BoardInter;

@Controller
public class MypageController {
	@Autowired
	@Qualifier("boardDao")
	private BoardInter inter;
	
	@RequestMapping(value="showMypage", method=RequestMethod.GET)
	public ModelAndView showMypage(@RequestParam("nickName")String nickName) {
		ModelAndView view = new ModelAndView("mypage/mypage"); 
		
		List<BoardDto> myList = inter.readBoardByNickName(nickName);
		view.addObject("myBoard", myList);
		view.addObject("user", nickName);
		view.addObject("count", myList.size());
		
		return view; 
	}
}
