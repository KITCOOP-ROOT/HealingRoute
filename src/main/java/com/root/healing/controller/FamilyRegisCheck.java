package com.root.healing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.root.healing.model.FamilyDto;
import com.root.healing.model.FamilyInter;

@Controller
public class FamilyRegisCheck {
	
	@Autowired
	@Qualifier("familyDao")
	private FamilyInter inter;
	
	@RequestMapping(value = "familyresiter")
	@ResponseBody
	public Map<String, Object> ajax(FamilyBean bean){
		List<Map<String, String>> para = new ArrayList<Map<String,String>>();
				
		Map<String, String> data = null;
		
		List<FamilyDto> getlog = inter.getDatalist(bean);	
		if(getlog == null)
			System.out.println("없음");
		for(FamilyDto f:getlog){
			data = new HashMap<String, String>();
			data.put("이메일", f.getF_email());
			data.put("닉네임", f.getF_nickname());
			para.add(data);
		}
		
		Map<String, Object> register = new HashMap<String, Object>();
		register.put("insert", para);
		
		return register;
	}
}
