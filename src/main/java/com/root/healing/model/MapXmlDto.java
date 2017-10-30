package com.root.healing.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapXmlDto {
		private String b_title, b_nickname,b_point; 
		private String m_lat, m_lng, m_loc, m_addr;   
		private String l_city;
		private int b_num;
		
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
		public String getB_point() {
			return b_point;
		}
		public void setB_point(String b_point) {
			this.b_point = b_point;
		}
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
		public int getB_num() {
			return b_num;
		}
		public void setB_num(int b_num) {
			this.b_num = b_num;
		}

}
