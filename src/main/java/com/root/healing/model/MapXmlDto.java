package com.root.healing.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapXmlDto {
		private String b_title, b_nickname; 
		private String m_lat, m_lng, m_loc, m_addr;   
		private String l_city;
		private int b_num;
		
		private String lat,lng,name,address,city;
		private int num;
		
		public String getLat() {
			return lat;
		}
		public String getLng() {
			return lng;
		}
		
		public String getName() {
			return name;
		}
		public String getAddress() {
			return address;
		}
		public String getCity() {
			return city;
		}
		public int getNum() {
			return num;
		}
		public MapXmlDto(String m_lat, String m_lng, String m_addr, String l_city, String b_nickname,int b_num) {
			this.lat = m_lat;
			this.lng = m_lng;
			this.address = m_addr;
			this.city = l_city;
			this.name = b_nickname;
			this.num = b_num;
			
		}
		public String getB_title() {
			return b_title;
		}

		public String getB_nickname() {
			return b_nickname;
		}

		public String getM_lat() {
			return m_lat;
		}

		public String getM_lng() {
			return m_lng;
		}

		public String getM_loc() {
			return m_loc;
		}

		public String getM_addr() {
			return m_addr;
		}

		public String getL_city() {
			return l_city;
		}

		public int getB_num() {
			return b_num;
		}

}
