package com.root.healing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.SawonDao;
import com.root.healing.model.SawonDto;

@Controller
public class SearchController {
	
	@Autowired
	private SawonDao dao;
	// 수정된 서치 컨트롤러23
	
	@RequestMapping(value="search", method=RequestMethod.POST)
	public ModelAndView searchProcess(SangBean bean) {
		List<SawonDto> list = dao.searchData(bean);
		//System.out.println(list.size());
		//System.out.println(bean.getSearchWord());
		return new ModelAndView("list","data",list);
	}
}
