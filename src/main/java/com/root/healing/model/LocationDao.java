package com.root.healing.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDao implements LocationInter{
	@Autowired
	@Qualifier("locationMapper")
	private LocationMapper mapper;
	
	public List<LocationDto> addrList(String cityName){
		List<String> list = new ArrayList<String>(); 
		list.add(cityName); 
		list.add(cityName); 
		list.add(cityName); 
		
		return mapper.searchData(list);
	}
	
	public List<LocationDto> contList() {
		return mapper.selContList();
	}
	
	public List<LocationDto> nationList(String nation) {
		return mapper.selNatList(nation);
	}
	
	public List<LocationDto> cityList(String city) {
		return mapper.selCityList(city);
	}
}
