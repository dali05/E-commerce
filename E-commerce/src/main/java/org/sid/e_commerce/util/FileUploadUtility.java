package org.sid.e_commerce.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH="E:/Education/DevloppementWeb/JEE/spring framework/Git/E-commerce/E-commerce/src/main/webapp/assets/images/";
	private static String REAL_PATH="";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile photo, String code) {
		
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
	
		
		if(!new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdirs();
		}
		if(!new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdirs();
		}
		
		
		try {
			
			//server upload
			photo.transferTo(new File(REAL_PATH + code + ".jpg"));
			//my project directory upload
			photo.transferTo(new File(ABS_PATH + code + ".jpg"));
		} catch (IOException e) {
			e.getMessage();
		}
	
	}
	
}
