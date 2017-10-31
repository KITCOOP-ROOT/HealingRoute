package com.root.healing.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.root.healing.model.BoardDto;
import com.root.healing.model.BoardInter;
import com.root.healing.model.UploadFileDto;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardDao")
	private BoardInter inter;
	
	@Autowired
	private MapController mcont;
	
	@RequestMapping(value="showBoard", method=RequestMethod.GET)
	public ModelAndView showHealingBoard(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="start", defaultValue="0")int start, @RequestParam(value="size", defaultValue="20")int size) {
		
		List<BoardDto> blist = inter.readBoard(start, size);
		mcont.searchCityMap(request, response);
		
		return new ModelAndView("main/main","board", blist);
	}
	
	@RequestMapping(value="showBoard", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> scrollHealingBoard(HttpServletRequest request, HttpServletResponse response, @RequestParam("start")int start, @RequestParam("size")int size) {

		mcont.searchCityMap(request, response);
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
	
	@RequestMapping(value="writeNew",method=RequestMethod.GET)
	public ModelAndView wirteaBoard(@RequestParam("nickname")String nickname) {
		//BoardDto dto = inter.selectdata(b_num);
		ModelAndView view = new ModelAndView("board/write");
		System.out.println(nickname);
		view.addObject("user", nickname);
		return view; 
	}
	
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String gogo(MultipartHttpServletRequest  mRequest, BoardDto dto,UploadFileDto updto){	
		Iterator<String> iter = mRequest.getFileNames();
		List<MultipartFile> files = new ArrayList<MultipartFile>();  
		String fileName[] = {"","","","",""};
		int FIdx = 0;
		while(iter.hasNext()) {		
			String uploadFileName = iter.next();
			
			MultipartFile file = mRequest.getFile(uploadFileName); 
			files.add(file);
			fileName[FIdx] = file.getOriginalFilename();	
			if(fileName[FIdx] == null || fileName[FIdx].equals("")) continue;
			FIdx++;
			
			
			System.out.println("index:"+ (FIdx-1));
			System.out.println("originalFileName: " +fileName[FIdx-1]);
			System.out.println("file사이즈" + file.getSize());
			
			InputStream inputStream = null; 
			OutputStream outputStream = null; 
			String path = mRequest.getSession().getServletContext().getRealPath("resources/image/board/");
				try {
					
					inputStream = file.getInputStream();
					File newFile = new File(path + file.getOriginalFilename());
					if(!newFile.exists()) newFile.createNewFile();
					
					outputStream = new FileOutputStream(newFile);
					
					int read = 0;
					byte[] bytes = new byte[10720000];//Max : 1MB
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
		dto.setB_image1(fileName[0]);
		dto.setB_image2(fileName[1]);
		dto.setB_image3(fileName[2]);
		dto.setB_image4(fileName[3]);
		dto.setB_image5(fileName[4]);
		inter.writeBoard(dto);

		return "redirect:/showBoard";
	}
	

}
