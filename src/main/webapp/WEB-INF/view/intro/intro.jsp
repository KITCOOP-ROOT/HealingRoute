<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Intro</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../resources/js/intro.js"></script>
<link rel="stylesheet" type="text/css" href="https://bootswatch.com/paper/bootstrap.min.css">
<link href="./resources/css/intro.css" rel="stylesheet" type="text/css">
</head>
<body class="main">
	<div class="header align-right">
		<div class="container-fluid">
			<input type="button" value="로그인">
			<input type="button" value="회원가입">
		</div>
	</div>

	<div class="main container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav" ></div>
			<div class="col-sm-8 text-center" >
				<!-- 로고영역 -->
				<div>
					<img src="./resources/image/logo_big.png" class="alpha logo-div">
				</div>
				<!-- cookie -->
				<div id="searchRecord"></div>
				<!-- 검색 영역 -->
				<div class="search-bar">
				<form class="navbar-form navbar-center" role="search" name="frm" id="searchFrom">
					<input type="text" class="form-control input " 
						placeholder="도시명을 입력하세요...       " autocomplete="off"
						name="cityName" id="cityName" size="auto" onkeydown="searchAddr()"> <input
						type="button" class="btn btn-default" onclick="check()"
						value="O K">
				</form>
				</div>
				<div id="resultList"></div>
				<div id="categoryArea">
				<table>
					<tr>
						<c:forEach var="c" items="${contList }">
							<td><a href="#"
								onclick="searchNation('${c.l_continent }'); return false;">${c.l_continent }</a>&nbsp;&nbsp;&nbsp;</td>
						</c:forEach>
					</tr>
				</table>
				<br>
				<div id="nationDisp"></div>
				<br>
				<div id="cityDisp"></div>
				</div>
			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
	</div>

	<!-- 반투명 배경 -->
	<div class="covervid-wrapper bg_effect"></div>

	<!-- 동영상배경영역 -->
	<div class="movie-div">
		<video id="video" preload="auto" autoplay="true" loop="loop"
			muted="muted" volume="0">
			<source src="./resources/image/kauai_vid_1.mp4">
		</video>
	</div>
	<!-- 동영상배경영역 end -->
</body>
</html>