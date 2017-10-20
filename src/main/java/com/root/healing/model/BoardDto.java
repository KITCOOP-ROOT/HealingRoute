package com.root.healing.model;

public class BoardDto {
	private String b_num, b_title, b_nickname, b_date, b_point, b_recommend, b_locnum; 
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
	public String getB_locnum() {
		return b_locnum;
	}
	public void setB_locnum(String b_locnum) {
		this.b_locnum = b_locnum;
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
				+ ", b_point=" + b_point + ", b_recommend=" + b_recommend + ", b_locnum=" + b_locnum + ", b_image1="
				+ b_image1 + ", b_image2=" + b_image2 + ", b_image3=" + b_image3 + ", b_image4=" + b_image4
				+ ", b_image5=" + b_image5 + ", b_link=" + b_link + ", b_content=" + b_content + "]";
	}

}
