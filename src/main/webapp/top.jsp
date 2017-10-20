<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String memid = (String) session.getAttribute("idKey");
	String gradeKey = (String) session.getAttribute("gradeKey");

	String log = "";
	String mem1 = "";
	String mem2 = "";
	String mem3 = "";
	String mem4 = "";

	if (memid == null) {
		log = "<a href='/web_project/member/member_login.jsp'>로그인 /  </a><a href='/web_project/member/member_register.jsp'>회원가입</a>";
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script> 
<link rel="stylesheet" type="text/css" href="./resources/css/paper_bootstrap.css">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">

</head>
<body>
	<div class="div">
		<nav class="navbar navbar-default">
			<table>
				<tr>
					<td class="top_menu_left">
						<!-- 로고 부분 -->
						<div class="navbar-header">
							<a href="#"><img src="./resources/image/logo_small.png" class="apple"></a>
						</div>
					</td>
					<td style="text-align: right;">
						<div class="collapse navbar-collapse 100" id="bs-example-navbar-collapse-1">
							<div class="form-group 100">
									<table class="100">
										<tr>
											<td>
											<!-- 검색기능 부분 -->
											<form class="navbar-form navbar-left 100" role="search" >
											<input type="text" class="form-control input"
												placeholder="Search" size="90%" name="search"> <!-- <button type="submit" class="btn btn-default">검색</button> -->
											</form>
											</td>
											<!-- 로그인/회원가입 부분 -->
											<td nowrap>
												<span><%=log%></span>&nbsp; 
												<span><%=mem1%></span>
											</td>
										</tr>
									</table>
							</div>
						</div>
					</td>
					<td class="right">
						<!-- 메뉴바 부분 -->
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span>
						</button>
					</td>

				</tr>
			</table>

		</nav>
	</div>
	<br>
	<br>
	<br>
	<br>

</body>
</html>