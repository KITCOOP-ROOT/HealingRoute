package com.root.healing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.BuserDto;
import com.root.healing.model.DaoInter;


@Controller
public class BuserController {
	
	@Autowired
	@Qualifier("sawonDao")
	private DaoInter inter;
	
	@RequestMapping(value="buser" , method=RequestMethod.GET)
	public ModelAndView buserProcess(String buser_no) {
		List<BuserDto> list = inter.buserData(buser_no);
		//System.out.println(list.size());
		return new ModelAndView("buser","data",list);
	}
}
