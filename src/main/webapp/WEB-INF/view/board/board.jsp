<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String memid = (String)session.getAttribute("idKey");
String gradeKey = (String)session.getAttribute("gradeKey");

String log = "";
String mem1 = "";
String mem2 = "";
String mem3 = "";
String mem4 = "";

if(memid == null){
	log = "<a href='/web_project/member/member_login.jsp'>로그인 /  </a><a href='/web_project/member/member_register.jsp'>회원가입</a>";
}else{
	if(gradeKey != null && gradeKey.equals("admin")){
		//admin 로그인 시 관리자 메뉴 보이기
		log = "<a href='/web_project/member/member_logout.jsp'>로그아웃</a>";
		mem1 = "<br><a href='/web_project/admin/admin_main.jsp'>&#9776;관리자 메뉴</a>";
	}else{
		log = "<a href='/web_project/member/member_logout.jsp'>로그아웃</a>";
		mem1 = "<a href='/web_project/member/member_update.jsp'>회원정보 수정</a>";
	}
}
%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/paper_bootstrap.css">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
</head>
<body>
<div class="div">
<nav class="navbar navbar-default">
	 <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
	<table>
		<tr>
			<td>
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="#"><img src="./resources/image/apple.png" class="apple"></a>
			    </div>
			</td>
			<td>
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <form class="navbar-form navbar-left" role="search">
			        <div class="form-group">
			          <input type="text" class="form-control" placeholder="Search">
			        </div>
			        <button type="submit" class="btn btn-default">검색</button>
			      </form>
			      <ul class="nav navbar-nav navbar-right">
			        <li>
			    		 <span><%=log %></span>
			        </li>
			        <li>
						<span><%=mem1 %></span>
			        </li>
			      </ul>
			    </div>
			  </div>
			</td>
		</tr>
	</table>
	</nav>
</div>
</body>
</html>