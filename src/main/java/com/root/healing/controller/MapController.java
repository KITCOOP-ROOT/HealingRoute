package com.root.healing.controller;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.root.healing.model.BoardInter;
import com.root.healing.model.MapXmlDto;

@Controller
public class MapController {
	
	@Autowired
	private BoardInter binter;
	
	@ResponseBody
	public void searchCityMap() {
		// 맵 리스트 출력용
		List<MapXmlDto> maplist = binter.readMap();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// root element
			Element markers = doc.createElement("markers");
			doc.appendChild(markers);
			int count = 1;
			for (MapXmlDto dto : maplist) {
				// maker element
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

				Attr l_city = doc.createAttribute("l_city");
				l_city.setValue(dto.getL_city());
				marker.setAttributeNode(l_city);

				Attr b_point = doc.createAttribute("b_point");
				b_point.setValue(dto.getB_point());
				marker.setAttributeNode(b_point);

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
	}
}
