package com.root.healing.model;

import java.util.List;

public interface BoardInter {
	List<BoardDto> readBoardAll();
	//새글쓰기
	boolean writeBoard(BoardDto dto);
	//
	BoardDto selectdata(String b_num);
}
