package com.root.healing.model;

import java.util.List;

import com.root.healing.controller.SangBean;



public interface DaoInter {
	List<SawonDto> selectDataAll();
	List<SawonDto> searchData(SangBean bean);
	List<BuserDto> buserData(String buser_no);
}
