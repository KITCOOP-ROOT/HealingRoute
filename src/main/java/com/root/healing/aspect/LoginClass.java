package com.root.healing.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class LoginClass {
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
		if(request == null) return false; 
		HttpSession session = request.getSession();
		
		if(session != null && session.getAttribute("email") != null){ //로그인 되어 있을 때
			System.out.println("test");
			return true;
		}else{
			System.out.println("로그인부터 해라");
			return false;
		}
	}
}
