<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	String memid = (String) session.getAttribute("idKey");
	String gradeKey = (String) session.getAttribute("gradeKey");

	String log = "";
	String mem1 = "";
	String mem2 = "";
	String mem3 = "";
	String mem4 = "";

	if (memid == null) {
		log = "<a href='/web_project/member/member_login.jsp'>로그인</a>  /  <a href='/web_project/member/member_register.jsp'>회원가입</a>";
	} else {
		if (gradeKey != null && gradeKey.equals("admin")) {
			//admin 로그인 시 관리자 메뉴 보이기
			log = "<a href='/web_project/member/member_logout.jsp'>로그아웃</a>";
			mem1 = "<br><a href='/web_project/admin/admin_main.jsp'>&#9776;관리자 메뉴</a>";
		} else {
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
<script src="./resources/js/script_member.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
<link rel="stylesheet" type="text/css"	href="./resources/css/paper_bootstrap.css">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">

</head>
<body>
<div class="top-menu-div">
<nav class="navbar navbar-default">
	<div class="top-logo">
		<a href="/"><img src="./resources/image/logo_small.png"	class="logo"></a>
	</div>
	<div class="collapse navbar-collapse top-search" id="bs-example-navbar-collapse-1">
		<div class="form-group">
			<form class="navbar-form navbar-center" role="search" name="frm" id="searchFrom">
			<table class="100">
				<tr>
					<td>
						<input type="text"  class="form-control form-text"  placeholder="도시명을 입력하세요..." autocomplete="off" name="cityName"
						id="cityName" size="400" onkeydown="searchAddr()">
					</td>
					<td nowrap>
					
					</td>
				</tr>
			</table>
			<div class="top-login">
				<span><a href="showMypage?nickName=메시">마이페이지</a></span><br>
				<span><%=log%></span>&nbsp; <span><%=mem1%></span>
			</div>
			</form>
		</div>
	</div>
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
	</nav>
</div>
</body>
</html>