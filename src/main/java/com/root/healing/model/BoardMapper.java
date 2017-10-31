package com.root.healing.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	@Select("select * from board inner join location on b_mnum=l_num inner join map on m_loc=l_num  order by b_date desc")  // 최신 일자로 정렬 
	List<BoardDto> selectBoard();

	@Select("select m_lat, m_lng, m_addr, l_city, b_nickname,b_num,b_point from board inner join map on b_mnum = m_num " + 
			" inner join location on m_loc=l_num order by b_num desc")  // 최신 일자로 정렬 
	List<MapXmlDto> readmap();
	
	@Select("select * from board where b_nickname=#{nickName} order by b_date desc, b_num asc")  // 최신 일자로 정렬 
	List<BoardDto> selectBoardByNickName(String nickName);	
	
	@Select("select * from board inner join location on b_mnum=l_num inner join map on m_loc=l_num where b_num=#{b_num}")
	BoardDto selectData(String b_num);
	
	//새글 작성
	@Insert("<script>insert into <choose>" 
	        + "<when test=\"b_image1 != null\"> "
	        	+ "board(b_title,b_nickname,b_point,b_image1,b_image2,b_image3,b_image4,b_image5,b_content) "
	        	+ "values(#{b_title},#{b_nickname},#{b_point},#{b_image1},#{b_image2},#{b_image3},#{b_image4},#{b_image5},#{b_content}) "
	        + "</when><otherwise>"
        		+ "board(b_title,b_nickname,b_content,b_point) "
        		+ "values(#{b_title},#{b_nickname},#{b_content},#{b_point}) "
			+ "</otherwise></choose></script>")
	int insertBoard(BoardDto dto);
	
	@Select("select * from board inner join map on b_mnum=m_num where b_num=#{boardNum}") // 선택 데이터 출력
	BoardDto selectDetailData(String boardNum);
}
