package com.root.healing.model;

import java.util.List;

public interface LocationInter {
	List<LocationDto> addrList(String name);
	List<LocationDto> contList();
	List<LocationDto> nationList(String nation);
	List<LocationDto> cityList(String city);
}
