package com.root.healing.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.BoardDto;
import com.root.healing.model.BoardInter;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardDao")
	private BoardInter inter;
	
	@RequestMapping(value="showBoard", method=RequestMethod.GET)
	public ModelAndView showHealingBoard(@RequestParam(value="start", defaultValue="0")int start, @RequestParam(value="size", defaultValue="20")int size) {
		List<BoardDto> blist = inter.readBoard(start, size);
		return new ModelAndView("main/main","board", blist);
	}
	
	@RequestMapping(value="showBoard", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> scrollHealingBoard(@RequestParam("start")int start, @RequestParam("size")int size) {
		Map<String, Object> scrollDatas = new HashMap<String, Object>();
		List<Map<String, String>> datas = new ArrayList<Map<String,String>>();

		List<BoardDto> blist = inter.readBoard(start, size);
		if(blist == null) return null; 
		for(BoardDto dto : blist) {
			Map<String, String> data = new HashMap<String, String>();
			data.put("b_num", dto.getB_num());
			data.put("b_title", dto.getB_title());
			data.put("b_nickname", dto.getB_nickname());
			data.put("b_date", dto.getB_date());
			data.put("b_point", dto.getB_point());
			data.put("b_recommend", dto.getB_recommend());
			data.put("b_mnum", dto.getB_mnum());
			data.put("b_image1", dto.getB_image1());
			data.put("b_image2", dto.getB_image2());
			data.put("b_image3", dto.getB_image3());
			data.put("b_image4", dto.getB_image4());
			data.put("b_image5", dto.getB_image5());
			data.put("b_link", dto.getB_link());
			data.put("b_content", dto.getB_content());
			datas.add(data); 			
		}
		scrollDatas.put("datas", datas);
		
		return scrollDatas;
	}
	//새글입력
	
	@RequestMapping(value="write",method=RequestMethod.GET)
	public String wirteaBoard() {
		return "board/write";
	}
	
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String gogo(MultipartHttpServletRequest  request, BoardDto dto){	
		// 1. file --> local folder
		List<MultipartFile> files = request.getFiles("ufile");
		// file이 없는 경우 종료
		if (files == null) {
			System.out.println("여기? ");
			return "main/main";
		}
		// file 이름 받기 
		String[] fileNames = new String[5]; 
		fileNames[0] = dto.getB_image1();
		fileNames[1] = dto.getB_image2();
		fileNames[2] = dto.getB_image3();
		fileNames[3] = dto.getB_image4();
		fileNames[4] = dto.getB_image5();
		// file 등록
		for (int idx = 0; idx < files.size(); idx++) {
			MultipartFile file = files.get(idx);
			String fileName = fileNames[idx];
			
			InputStream inputStream = null; 
			OutputStream outputStream = null; 
			try {
				inputStream = file.getInputStream();
				
				File newFile = new File("C:/Users/kitcoop/git/HealingRoute/src/main/webapp/resources/image/board/" + fileName);
				if(!newFile.exists()) newFile.createNewFile();
				
				outputStream = new FileOutputStream(newFile);
				
				int read = 0;
				byte[] bytes = new byte[1024];
				while((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} catch (Exception e) {
				System.out.println("uploadOk err : " + e);
			} finally {
				try {
					if (outputStream != null) outputStream.close();
					if (inputStream != null) inputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		// 2. file name --> DB
		inter.writeBoard(dto);

		return "main/main";
	}
	
	//수정하기
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateaBoard() {
		return "board/update";
	}
	
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String writeupdate(MultipartHttpServletRequest  request, BoardDto dto){	
		// 1. file --> local folder
		List<MultipartFile> files = request.getFiles("ufile");
		// file이 없는 경우 종료
		if (files == null) {
			System.out.println("여기? ");
			return "main/main";
		}
		// file 이름 받기 
		String[] fileNames = new String[5]; 
		fileNames[0] = dto.getB_image1();
		fileNames[1] = dto.getB_image2();
		fileNames[2] = dto.getB_image3();
		fileNames[3] = dto.getB_image4();
		fileNames[4] = dto.getB_image5();
		// file 등록
		for (int idx = 0; idx < files.size(); idx++) {
			MultipartFile file = files.get(idx);
			String fileName = fileNames[idx];
			
			InputStream inputStream = null; 
			OutputStream outputStream = null; 
			try {
				inputStream = file.getInputStream();
				
				File newFile = new File("C:/Users/kitcoop/git/HealingRoute/src/main/webapp/resources/image/board/" + fileName);
				if(!newFile.exists()) newFile.createNewFile();
				
				outputStream = new FileOutputStream(newFile);
				
				int read = 0;
				byte[] bytes = new byte[1024];
				while((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} catch (Exception e) {
				System.out.println("uploadOk err : " + e);
			} finally {
				try {
					if (outputStream != null) outputStream.close();
					if (inputStream != null) inputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		// 2. file name --> DB
		inter.writeBoard(dto);
		
		return "main/update";
	}
}
