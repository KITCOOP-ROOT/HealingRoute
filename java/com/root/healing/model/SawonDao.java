package com.root.healing.model;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.root.healing.controller.SangBean;


@Repository
public class SawonDao implements DaoInter {
	@Autowired
	private SawonInter inter;
	
	
	public List<SawonDto> selectDataAll() {
		return inter.selectDataAll();
	}
	
	public List<SawonDto> searchData(SangBean bean) {
		return inter.searchData(bean);
		
	}

	public List<BuserDto> buserData(String buser_no) {
		return inter.buserData(buser_no);
	}
	
	
	
	
	
	
}
