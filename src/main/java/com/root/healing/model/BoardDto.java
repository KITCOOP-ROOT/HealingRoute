package com.root.healing.model;

public class BoardDto {
	private String b_num, b_title, b_nickname, b_date, b_point, b_recommend, b_mnum; 
	private String b_image1, b_image2, b_image3, b_image4, b_image5; 
	private String b_link, b_content;
	
	public String getB_num() {
		return b_num;
	}
	public void setB_num(String b_num) {
		this.b_num = b_num;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_nickname() {
		return b_nickname;
	}
	public void setB_nickname(String b_nickname) {
		this.b_nickname = b_nickname;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_point() {
		return b_point;
	}
	public void setB_point(String b_point) {
		this.b_point = b_point;
	}
	public String getB_recommend() {
		return b_recommend;
	}
	public void setB_recommend(String b_recommend) {
		this.b_recommend = b_recommend;
	}
	public String getB_mnum() {
		return b_mnum;
	}
	public void setB_mnum(String b_mnum) {
		this.b_mnum = b_mnum;
	}
	public String getB_image1() {
		return b_image1;
	}
	public void setB_image1(String b_image1) {
		this.b_image1 = b_image1;
	}
	public String getB_image2() {
		return b_image2;
	}
	public void setB_image2(String b_image2) {
		this.b_image2 = b_image2;
	}
	public String getB_image3() {
		return b_image3;
	}
	public void setB_image3(String b_image3) {
		this.b_image3 = b_image3;
	}
	public String getB_image4() {
		return b_image4;
	}
	public void setB_image4(String b_image4) {
		this.b_image4 = b_image4;
	}
	public String getB_image5() {
		return b_image5;
	}
	public void setB_image5(String b_image5) {
		this.b_image5 = b_image5;
	}
	public String getB_link() {
		return b_link;
	}
	public void setB_link(String b_link) {
		this.b_link = b_link;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	
	@Override
	public String toString() {
		return "BoardDto [b_num=" + b_num + ", b_title=" + b_title + ", b_nickname=" + b_nickname + ", b_date=" + b_date
				+ ", b_point=" + b_point + ", b_recommend=" + b_recommend + ", b_mnum=" + b_mnum + ", b_image1="
				+ b_image1 + ", b_image2=" + b_image2 + ", b_image3=" + b_image3 + ", b_image4=" + b_image4
				+ ", b_image5=" + b_image5 + ", b_link=" + b_link + ", b_content=" + b_content + "]";
	}
	
	// 추가내용
	private String m_lat,m_lng,m_loc ,m_addr,l_city,l_nation,l_continent ;   
	private int m_num,l_num;
	
	public String getM_lat() {
		return m_lat;
	}
	public void setM_lat(String m_lat) {
		this.m_lat = m_lat;
	}
	public String getM_lng() {
		return m_lng;
	}
	public void setM_lng(String m_lng) {
		this.m_lng = m_lng;
	}
	public String getM_loc() {
		return m_loc;
	}
	public void setM_loc(String m_loc) {
		this.m_loc = m_loc;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getL_city() {
		return l_city;
	}
	public void setL_city(String l_city) {
		this.l_city = l_city;
	}
	public String getL_nation() {
		return l_nation;
	}
	public void setL_nation(String l_nation) {
		this.l_nation = l_nation;
	}
	public String getL_continent() {
		return l_continent;
	}
	public void setL_continent(String l_continent) {
		this.l_continent = l_continent;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public int getL_num() {
		return l_num;
	}
	public void setL_num(int l_num) {
		this.l_num = l_num;
	}
}
