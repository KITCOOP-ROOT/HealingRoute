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
	
	public List<BoardDto> readBoard(int start, int size) {
		List<BoardDto> buff = mapper.selectBoardAll(); 
		
		if(buff.size() > start + size) { 
			return buff.subList(start, start+size);
		} else if(buff.size() >= start){ 
			return buff.subList(start, buff.size()); 
		} else {
			return null; 
		}
	}
	
	public List<BoardDto> readBoardByNickName(String nickName) {
		return mapper.selectBoardByNickName(nickName);
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
	
	public List<BoardDto> readMap() {
		List<BoardDto> dto = mapper.selectBoardAll();
		return dto ;
	}
	
}
