<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/style.css"/>
<link rel="stylesheet" href="./resources/css/mypage.css"/>
</head>
<body>
<div class="fixed">
<c:import url="/top.jsp"></c:import>
</div>
<br><br><br><br>
<div class="mypage_container" id="mypage_main">
<!-- 상단 : 블로거 이름 / 블로거 사진 / 수정편집 버튼  -->
<br>
<div class="mypage_header" id="mypage_frontContent">
	<h1> ${user} 님 </h1>
	<h3> 총 ${count} 곳을 다녀오셨네요~ </h3>
</div>
<br>
<br>
<!-- 본문 : 블로거가 올린 블로깅 내용 나열 -->
<div class="mypage_content" id="mypage_mainContent">
	<figure>
        <a href="write">
        	<img src="./resources/image/board/addNew.jpg">
        </a>
        <figcaption>새로 만들기 </figcaption>
    </figure> 
	<c:forEach var="my" items="${myBoard}">
	<figure>
		<a href="showDetail">
        	<img src="./resources/image/board/${my.b_image1}">
        <</a>
        <figcaption>${my.b_title}</figcaption>
    </figure>   
	</c:forEach>
</div>
</div>
</body>
</html>