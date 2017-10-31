package com.root.healing.model;

import java.util.List;

import com.root.healing.controller.FamilyBean;

public interface FamilyInter {
	List<FamilyDto> readFamilyAll();
	List<FamilyDto> loginData(String f_email);
	boolean insertData(FamilyBean bean);
	List<FamilyDto> getDatalist(FamilyBean bean);
}
