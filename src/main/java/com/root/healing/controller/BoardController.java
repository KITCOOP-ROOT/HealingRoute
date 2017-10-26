package com.root.healing.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.BoardDto;
import com.root.healing.model.BoardInter;

@Controller
public class BoardController {
	private String fileName;
	@Autowired
	@Qualifier("boardDao")
	private BoardInter inter;
	
	@RequestMapping(value="showBoard")
	public ModelAndView showHealingBoard() {
		List<BoardDto> blist = inter.readBoardAll();
		//System.out.println(list.toString());
		return new ModelAndView("main/main","board", blist);
	}
	//새글입력
	
	@RequestMapping(value="write",method=RequestMethod.GET)
	public String wirteaBoard() {
		return "board/write";
	}
	
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String gogo(MultipartHttpServletRequest  request, BoardDto dto
				/*@RequestParam(value="fileNames", defaultValue="") String[] fileNames*/
				/*@RequestParam(value="ufile")MultipartFile[] uploadfiles,*/ 
				/* BindingResult result*/){	
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
			fileName = fileNames[idx];
			
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
	public String writeupdate(MultipartHttpServletRequest  request, BoardDto dto
			/*@RequestParam(value="fileNames", defaultValue="") String[] fileNames*/
			/*@RequestParam(value="ufile")MultipartFile[] uploadfiles,*/ 
			/* BindingResult result*/){	
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
			fileName = fileNames[idx];
			
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
	
