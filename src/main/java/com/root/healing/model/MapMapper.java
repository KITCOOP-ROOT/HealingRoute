package com.root.healing.model;

import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface MapMapper {
	@Select("select * from map left outer join location on m_loc = l_num")  // 최신 일자로 정렬 
	List<MapXmlDto> selectMapAll();	
}
