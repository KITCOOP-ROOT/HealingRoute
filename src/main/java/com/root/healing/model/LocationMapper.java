package com.root.healing.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface LocationMapper {
	@Select("select l_city, l_nation, l_continent from location where l_city like CONCAT('%',#{list[0]},'%') OR l_nation like CONCAT('%',#{list[1]},'%') OR l_continent like CONCAT('%',#{list[2]},'%')") 
	List<LocationDto> searchData(List<String> list);	
	
	
	@Select("select distinct l_continent from location")
	List<LocationDto> selContList();
	
	@Select("select distinct l_nation from location where l_continent=#{continent}")
	List<LocationDto> selNatList(String nation);
	
	@Select("select l_city, l_nation, l_continent from location where l_nation=#{nation}")
	List<LocationDto> selCityList(String city);
/*


<select id="nation" parameterType="String" resultType="citys">
	select distinct l_nation from location where l_continent=#{continent};
</select>

<select id="city" parameterType="String" resultType="citys">
	select l_city, l_nation, l_continent from location where l_nation=#{nation};
</select>

<select id="boardNum" resultType="detail">
	select b_num from board;
</select>*/
}
