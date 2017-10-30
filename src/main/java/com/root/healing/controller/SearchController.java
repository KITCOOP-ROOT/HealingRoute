package com.root.healing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.root.healing.model.LocationDto;
import com.root.healing.model.LocationInter;

@Controller
public class SearchController {
	@Autowired
	@Qualifier("locationDao")
	private LocationInter inter;
	
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
