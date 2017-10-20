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
}
