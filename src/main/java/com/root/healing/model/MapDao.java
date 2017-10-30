package com.root.healing.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MapDao implements MapInter{
	
	@Autowired
	@Qualifier("mapMapper")
	private MapMapper mMapper;
	
	public List<MapXmlDto> readMapAll() {
		return mMapper.selectMapAll();
	}

}
