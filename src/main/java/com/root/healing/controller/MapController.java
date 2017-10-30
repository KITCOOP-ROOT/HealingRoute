package com.root.healing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.root.healing.model.BoardDto;
import com.root.healing.model.BoardInter;

@Controller
public class MapController {
	
	@Autowired
	@Qualifier("boardDao")
	private BoardInter inter;
/*	
	@RequestMapping("map.xml")
	@ResponseBody
	public String allMapRead() {
		List<BoardDto> blist = inter.readMap();
		if(blist == null) return null; 
		
		String mapXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		mapXml += "<markers>";
		int count=1;
		for(BoardDto dto : blist) {
			mapXml += "<marker ";
			mapXml += " id=\"" + count + "\" ";
			mapXml += " name=\"" + dto.getB_nickname()+ "\" ";
			mapXml += " address=\"" + dto.getM_addr()+ "\"";
			mapXml += " lat=\"" + dto.getM_lat() + "\"";
			mapXml += " lng=\"" + dto.getM_lng()+ "\"";
			mapXml += " type=\""+ dto.getL_city() +"\"" ;
			mapXml += " />";
			count++;
		}
		mapXml += "</markers>";
		return mapXml ;
	}
*/
}
