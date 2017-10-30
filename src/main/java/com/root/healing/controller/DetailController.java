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
public class DetailController {
	@Autowired
	@Qualifier("boardDao")
	private BoardInter inter;
	
	/*@RequestMapping(value="showDetail", method=RequestMethod.GET)
	public ModelAndView showDetailBoard(@RequestParam(value="boardNum") String boardNum){
//		System.out.println(boardNum);
		
		ModelAndView view = new ModelAndView();
		
		List<BoardDto> detailData = inter.readDetailData(boardNum);
		view.setViewName("board/detail");
		view.addObject("detail", detailData);

		return view;
	}*/
	
	@RequestMapping(value="showDetail", method=RequestMethod.GET)
	public ModelAndView showDetailBoard(@RequestParam(value="boardNum") String boardNum){
		BoardDto dto = inter.readDetailData(boardNum);
		return new ModelAndView("board/detail", "detail", dto);
	}
}
