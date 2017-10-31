package com.root.healing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.root.healing.model.FamilyDto;
import com.root.healing.model.FamilyInter;

@Controller
public class FamilyLogController {
	@Autowired
	@Qualifier("familyDao")
	private FamilyInter inter;

	@RequestMapping(value="logincheck")
	@ResponseBody
	public Map<String, Object> goSubmit(HttpSession session ,@RequestParam("f_email")String email, @RequestParam("f_pwd")String pwd){
		List<Map<String, String>> para = new ArrayList<Map<String,String>>();
						
		Map<String, String> data = null;
		System.out.println(email);
		
		List<FamilyDto> getlog = inter.loginData(email);
		if(getlog != null){ //db 값이 있을 때
			for(FamilyDto m:getlog){
				String emailKey = m.getF_email();
				if(emailKey.equals(email)){
					session.setAttribute("email", emailKey);
				}
				
				data = new HashMap<String, String>();
				data.put("이메일", m.getF_email());
				data.put("패스워드", m.getF_pwd());
				para.add(data);
			}
		}
		//session.setAttribute("email", email);
		Map<String, Object> logdata = new HashMap<String, Object>();
		logdata.put("logindata", para);
		
		return logdata;	
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String main(){		

		return "redirect:/intro";	//매핑값 써주세요
	}
	
	@RequestMapping("logout")
	public String Logout(HttpSession session){
		session.invalidate();
		System.out.println("로그아웃성공");
		return "redirect:/intro"; 
	}	
}
