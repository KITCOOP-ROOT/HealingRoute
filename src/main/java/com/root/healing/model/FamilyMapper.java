package com.root.healing.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.root.healing.controller.FamilyBean;

public interface FamilyMapper {
	@Select("select * from family")  
	List<FamilyDto> selectFamilyAll();	
		
	@Insert("insert into family (f_nickname,f_email,f_pwd) values(#{f_nickname},#{f_email},#{f_pwd})")  
	boolean insertFamily(FamilyBean familyBean);	
	
	@Select("select f_email, f_pwd from family where f_email=#{f_email}")
	List<FamilyDto> loginCheck(String f_email);
	
	@Select("select f_email, f_nickname from family where f_email=#{f_email} or f_nickname=#{f_nickname}")
	List<FamilyDto> ResisterCheck(FamilyBean bean);
}
