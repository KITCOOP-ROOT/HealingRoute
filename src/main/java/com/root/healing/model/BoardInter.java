package com.root.healing.model;

import java.util.List;

public interface BoardInter {
	public List<BoardDto> readBoardAll();
	public List<BoardDto> readBoard(int start, int size);
	public List<BoardDto> readBoardByNickName(String nickName);
	//새글쓰기
	public boolean writeBoard(BoardDto dto);
	public BoardDto selectdata(String b_num); 
	//Map
	public List<MapXmlDto> readMap();
}
