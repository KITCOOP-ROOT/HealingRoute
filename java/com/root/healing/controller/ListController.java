package com.root.healing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.DaoInter;



@Controller
public class ListController {
	
	@Autowired
	@Qualifier("sawonDao")
	private DaoInter inter;
	
	@RequestMapping("sawonlist")
	public ModelAndView process() {
		return new ModelAndView("list","data",inter.selectDataAll());
	}
}
