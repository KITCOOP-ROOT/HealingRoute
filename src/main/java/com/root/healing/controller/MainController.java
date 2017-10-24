package com.root.healing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.BoardDto;
import com.root.healing.model.BoardInter;

@Controller
public class MainController {
	@Autowired
	@Qualifier("boardDao")
	private BoardInter inter;
	
	@RequestMapping(value="showBoard")
	@ResponseBody
	public ModelAndView showHealingBoard() {
		List<BoardDto> blist = inter.readBoardAll();
		return new ModelAndView("main/main","board", blist);
	}
}