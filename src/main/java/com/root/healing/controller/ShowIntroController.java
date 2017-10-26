package com.root.healing.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.LocationDto;
import com.root.healing.model.LocationInter;

@Controller
public class ShowIntroController {
	@Autowired
	@Qualifier("locationDao")
	private LocationInter inter;
	
	@RequestMapping(value=("showIntro"), method=RequestMethod.GET)
	public ModelAndView getContList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		
		List<LocationDto> contList = inter.contList();
		view.setViewName("intro/intro");
		view.addObject("contList", contList);

		return view;

	}
}
