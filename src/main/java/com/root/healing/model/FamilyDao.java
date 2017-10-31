package com.root.healing.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.root.healing.controller.FamilyBean;

@Repository
public class FamilyDao implements FamilyInter{
	@Autowired
	@Qualifier("familyMapper")
	private FamilyMapper mapper;
	
	public List<FamilyDto> readFamilyAll() {
		return mapper.selectFamilyAll();
		
	}	
	public List<FamilyDto> loginData(String f_email) {
		return mapper.loginCheck(f_email);
	}
	
	public boolean insertData(FamilyBean bean) {
		return mapper.insertFamily(bean);
	}
	
	public List<FamilyDto> getDatalist(FamilyBean bean) {
		return mapper.ResisterCheck(bean);
	}
}
	

