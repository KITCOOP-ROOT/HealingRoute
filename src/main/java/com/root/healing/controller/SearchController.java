package com.root.healing.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.root.healing.model.BoardInter;
import com.root.healing.model.LocationDto;
import com.root.healing.model.LocationInter;
import com.root.healing.model.MapXmlDto;

@Controller
public class SearchController {
	@Autowired
	@Qualifier("locationDao")
	private LocationInter inter;
	
	@Autowired
	private BoardInter binter;
	
	@RequestMapping(value=("cityList"), method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> searchAddr(@RequestParam("cityName") String cityName){
		List<Map<String, String>> addrList = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		List<LocationDto> addrs = inter.addrList(cityName);
		
		for(LocationDto s : addrs){
			data = new HashMap<String, String>();
			data.put("l_city", s.getL_city());
			data.put("l_nation", s.getL_nation());
			data.put("l_continent", s.getL_continent());
			addrList.add(data);
		}
		Map<String, Object> addrDatas = new HashMap<String, Object>();
		addrDatas.put("datas", addrList);
		
		//맵 리스트 출력용
				List<MapXmlDto> maplist = binter.readMap();
				 try {
			         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			         Document doc = dBuilder.newDocument();
			         // root element
			         Element markers = doc.createElement("markers");
			         doc.appendChild(markers);
			         int count=1;
			         for(MapXmlDto dto : maplist) {
			        	 //  maker element
			        	 Element marker = doc.createElement("marker");
				         markers.appendChild(marker);
				         
				         // setting attribute to element
				         Attr id = doc.createAttribute("id");
				         id.setValue(Integer.toString(count));
				         marker.setAttributeNode(id);
			             count++;
			             
			             Attr name = doc.createAttribute("name");
			             name.setValue(dto.getB_nickname());
			             marker.setAttributeNode(name);
			             
				         Attr address = doc.createAttribute("address");
				         address.setValue(dto.getM_addr());
				         marker.setAttributeNode(address);
				         
				         Attr lat = doc.createAttribute("lat");
				         lat.setValue(dto.getM_lat());
				         marker.setAttributeNode(lat);
				         
				         Attr lng = doc.createAttribute("lng");
				         lng.setValue(dto.getM_lng());
				         marker.setAttributeNode(lng);
			             
				         Attr city = doc.createAttribute("city");
				         city.setValue(dto.getL_city());
				         marker.setAttributeNode(city);
				         
			 		}
			         TransformerFactory transformerFactory = TransformerFactory.newInstance();
			         Transformer transformer = transformerFactory.newTransformer();
			         DOMSource source = new DOMSource(doc);
			         System.out.println(source);
			         StreamResult result = new StreamResult(new File("C:/project_git/HealingRoute/src/main/webapp/resources/map.xml"));
			         transformer.transform(source, result);
			         StreamResult consoleResult = new StreamResult(System.out);
			         transformer.transform(source, consoleResult);
			      } catch (Exception e) {
			         e.printStackTrace();
			      }
		
		return addrDatas;
		
	}
	
	@RequestMapping(value=("nationList"), method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> searchNation(@RequestParam("nation") String nation){
//		System.out.println(nation);
		List<Map<String, String>> nationList = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		List<LocationDto> nations = inter.nationList(nation);
		
		for(LocationDto l : nations){
			data = new HashMap<String, String>();
			data.put("l_nation", l.getL_nation());
			nationList.add(data);
		}
		Map<String, Object> nationDatas = new HashMap<String, Object>();
		nationDatas.put("datas", nationList);
		return nationDatas;
	}
	
	@RequestMapping(value=("city"), method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> searchCity(@RequestParam("city") String city){
//		System.out.println(city);
		List<Map<String, String>> cityList = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		List<LocationDto> citys = inter.cityList(city);
		
		for(LocationDto c : citys){
			data = new HashMap<String, String>();
			data.put("l_city", c.getL_city());
			data.put("l_nation", c.getL_nation()); 
			data.put("l_continent", c.getL_continent()); 
			cityList.add(data);
		}
		Map<String, Object> cityDatas = new HashMap<String, Object>();
		cityDatas.put("datas", cityList);
		return cityDatas;
	}
}
