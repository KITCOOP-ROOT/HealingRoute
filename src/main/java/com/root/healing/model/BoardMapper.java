package com.root.healing.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	@Select("select * from board inner join location on b_locnum=l_num inner join map on m_loc=l_num order by b_date desc")  // 최신 일자로 정렬 
	List<BoardDto> selectBoardAll();	
	
	@Select("select * from board where b_nickname=#{nickName} order by b_date desc, b_num asc")  // 최신 일자로 정렬 
	List<BoardDto> selectBoardByNickName(String nickName);	

}
