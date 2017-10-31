package com.root.healing.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	@Autowired
	private LoginClass loginClass;
	
	/*@Pointcut("execution(public * com.root.healing..*(..))")
	private void showMypage(){}
	
	@Around(value="showMypage()")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("#### LoginAspect 시작 ####");    
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        for ( Object o : joinPoint.getArgs() ){
            if ( o instanceof HttpServletRequest ) {
                request = (HttpServletRequest)o;
            }
            if ( o instanceof HttpServletResponse ) {
                response = (HttpServletResponse)o;
            }
        }
        try{
            HttpSession session = request.getSession();
 
                String loginId = (String) session.getAttribute("loginId");
                String userEnterType = (String) session
                        .getAttribute("UserEnterType");
 
                System.out.println("### Margo ==> loginId : " + loginId);
                if (loginId == null || "".equals(loginId)) {
                    System.out.println("### Margo ==> in if loginId : " + loginId);
                    throw new RuntimeException("먼저 로그인을 하셔야 합니다.");
                }          
        	}catch(Exception e){
             
            throw new RuntimeException("먼저 로그인을 하셔야 합니다.");
 
        }      
        Object result = joinPoint.proceed();
        System.out.println("#### LoginAspect 끝 ####");     
        return result;
	}*/
	
	//@Around("execution(* showDetailBoard*(..)) or execution(* showMypage*(..)) or execution(* wirteaBoard*(..))")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		for(Object o:joinPoint.getArgs()){
			if(o instanceof HttpServletResponse){
				response = (HttpServletResponse)o;
			}
			if(o instanceof HttpServletRequest){
				request = (HttpServletRequest)o;
			}
		}
		if(request == null) return null; 
		
		if(!loginClass.loginCheck(request, response)){
			return null;
		}
		
		System.out.println("로직 수행 전");
		Object object = joinPoint.proceed(); //핵심로직 수행
		return object;
	}
}
