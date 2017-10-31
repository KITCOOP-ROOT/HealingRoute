package com.root.healing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.root.healing.model.FamilyInter;

@Controller
public class FamilyRegister {
	
	@Autowired
	@Qualifier("familyDao")
	private FamilyInter inter;
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String register(HttpSession session, FamilyBean bean){
		boolean b = inter.insertData(bean);
			
		if(b){
			session.setAttribute("email", bean.getF_email());	
			return "intro/intro";
		}else{
			return "redirect:error.jsp";
		}
	}
	
	
}
