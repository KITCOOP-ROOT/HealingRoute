package com.root.healing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.BoardDto;
import com.root.healing.model.BoardInter;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardDao")
	private BoardInter inter;
	
	@RequestMapping(value="showBoard", method=RequestMethod.GET)
	public ModelAndView showHealingBoard(@RequestParam(value="start", defaultValue="0")int start, @RequestParam(value="size", defaultValue="20")int size) {
		List<BoardDto> blist = inter.readBoard(start, size);
		//System.out.println(list.toString());
		return new ModelAndView("main/main","board", blist);
	}
	
	@RequestMapping(value="showBoard", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> scrollHealingBoard(@RequestParam("start")int start, @RequestParam("size")int size) {
		Map<String, Object> scrollDatas = new HashMap<String, Object>();
		List<Map<String, String>> datas = new ArrayList<Map<String,String>>();

		List<BoardDto> blist = inter.readBoard(start, size);
		if(blist == null) return null; 
		for(BoardDto dto : blist) {
			Map<String, String> data = new HashMap<String, String>();
			data.put("b_num", dto.getB_num());
			data.put("b_title", dto.getB_title());
			data.put("b_nickname", dto.getB_nickname());
			data.put("b_date", dto.getB_date());
			data.put("b_point", dto.getB_point());
			data.put("b_recommend", dto.getB_recommend());
			data.put("b_locnum", dto.getB_locnum());
			data.put("b_image1", dto.getB_image1());
			data.put("b_image2", dto.getB_image2());
			data.put("b_image3", dto.getB_image3());
			data.put("b_image4", dto.getB_image4());
			data.put("b_image5", dto.getB_image5());
			data.put("b_link", dto.getB_link());
			data.put("b_content", dto.getB_content());
			datas.add(data); 			
		}
		scrollDatas.put("datas", datas);
		
		return scrollDatas;
	}
}
