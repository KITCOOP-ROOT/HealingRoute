<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="./resources/css/main.css" />
<script src="./resources/js/jquery.min.js"></script>
<script src="./resources/js/skel.min.js"></script>
<script src="./resources/js/util.js"></script>
<script src="./resources/js/main.js"></script>
<title>힐링루트 지도검색 결과</title>
    <style>
      #map {
        height: 100%;
      }
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
</head>
<body>
	<!-- Header -->  
<!-- 	<header id="header">
		<div class="inner">
			<div class="content">
				<h1>제목</h1>
				<h2>
					여기에 검색창 넣어야 하나? 넣지말자<br />
				</h2>
				<a href="#" class="button big alt"><span>Let's Go</span></a>
			</div>
			<a href="#" class="button hidden"><span>Let's Go</span></a>
		</div>
	</header> -->
	<!-- main1(지도) -->  
<%-- 	<div class= "main-map">
		<c:import url="test.jsp" />
		<c:import url="map.jsp" />
	</div>
 --%>	<!-- main2(board)-->  
	<div id="main">
		<div class="inner">
			<div class="columns"  id="columns">
				<c:forEach var="b" items="${board}" begin="0" end="20">	
				<div class="image fit">
					<a href="#">
				      	<img src="./resources/image/board/${b.b_image1}" alt="">
      				</a>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Footer -->  
	<footer id="footer">
		<a href="#" class="info fa fa-info-circle"><span>About</span></a>
		<div class="inner">
			<div class="content">
				<h3>Healing Route for you</h3>
				<p>Search a beautiful city where you can be healed.</p>
			</div>
			<div class="copyright">
				<h3>Follow me</h3>
				<ul class="icons">
					<li><a href="#" class="icon fa-twitter"><span
							class="label">Twitter</span></a></li>
					<li><a href="#" class="icon fa-facebook"><span
							class="label">Facebook</span></a></li>
					<li><a href="#" class="icon fa-instagram"><span
							class="label">Instagram</span></a></li>
					<li><a href="#" class="icon fa-dribbble"><span
							class="label">Dribbble</span></a></li>
				</ul>
				&copy; KIC Campus 2017.
			</div>
		</div>
	</footer>
</body>
</html>