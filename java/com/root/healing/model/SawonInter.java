package com.root.healing.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.root.healing.controller.SangBean;

public interface SawonInter {
	@Select("select sawon_no,sawon_name,ifnull(buser_name,'무소속') as "
			+ " buser_name,sawon_jik,buser_no,concat(substr(sawon_ibsail,1,4),'년 '"
			+ " ,quarter(sawon_ibsail),'사분기') as sawon_ibsail from"
			+ " sawon left join buser on buser_num=buser_no order by sawon_name asc,buser_name asc")
	List<SawonDto> selectDataAll();
	
	
	@Select("select sawon_no,sawon_name,ifnull(buser_name,'무소속') as buser_name,buser_no,sawon_jik,concat(substr(sawon_ibsail,1,4),'년 ',quarter(sawon_ibsail),'사분기') as sawon_ibsail from"
			+" sawon left join buser on buser_num=buser_no where buser_name like concat('%',#{searchWord},'%') order by buser_name asc,sawon_name asc")
	List<SawonDto> searchData(SangBean bean);
	
	@Select("select * from buser where buser_no=#{buser_no}")
	List<BuserDto> buserData(String buser_no);
	
	
}
