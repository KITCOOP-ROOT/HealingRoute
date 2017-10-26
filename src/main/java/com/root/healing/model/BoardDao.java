package com.root.healing.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardInter{
	@Autowired
	@Qualifier("boardMapper")
	private BoardMapper mapper;
	
	public List<BoardDto> readBoardAll() {
		return mapper.selectBoardAll();
	}
	
	public boolean writeBoard(BoardDto dto) {
		boolean b = false;
		try {
			int re= mapper.insertBoard(dto);
			if(re>0)
			b = true;
		} catch (Exception e) {
			System.out.println("insertData err :" + e);
			b= false;
		}
		return b;
	}
	
	public BoardDto selectdata(String b_num) {
		return mapper.selectData(b_num);
	}

}
