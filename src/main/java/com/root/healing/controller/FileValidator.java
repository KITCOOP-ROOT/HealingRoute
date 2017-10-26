package com.root.healing.controller;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.root.healing.model.UploadFileDto;


@Service
public class FileValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return false;
	}

	public void validate(Object uploadfile, Errors errors) {
		UploadFileDto file = (UploadFileDto)uploadfile;

		if(file.getUpfile().length==0 && file.getFileNames()==null) errors.rejectValue("file", "","업로드할 파일을 선택");
	}
}
