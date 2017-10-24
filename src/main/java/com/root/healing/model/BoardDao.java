package com.root.healing.model;

import java.util.ArrayList;
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
}
