package com.root.healing.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileDto {

	private MultipartFile[] upfile;
	private String[] fileNames;
	

	public String[] getFileNames() {
		return fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	public MultipartFile[] getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile[] upfile) {
		this.upfile = upfile;
	}

	
	
	
}
