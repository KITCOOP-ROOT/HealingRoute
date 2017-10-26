package com.root.healing.model;

import java.util.List;

public interface BoardInter {
	public List<BoardDto> readBoardAll();
	public List<BoardDto> readBoard(int start, int size);
	public List<BoardDto> readBoardByNickName(String nickName); 
}
