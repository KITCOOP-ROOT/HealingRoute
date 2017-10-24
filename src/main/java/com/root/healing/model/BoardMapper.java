package com.root.healing.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	@Select("select b_num, b_title, b_nickname, b_date, b_point, b_recommend, b_locnum, "
			+ "b_image1, b_image2, b_image3, b_image4, b_image5, b_link, b_content "
			+ "from board order by b_date desc, b_num asc")  // 최신 일자로 정렬 
	List<BoardDto> selectBoardAll();	

}
