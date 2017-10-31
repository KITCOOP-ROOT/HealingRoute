<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<!-- main top(고정) -->
	<div class = "top-menu-div">
		<c:import url="top.jsp" />
	</div>
	<!-- main1(지도) -->
	<div  class="map-div">
		<c:import url="../map/map.jsp" />
	</div>
	<!-- main2(board)-->
	<div id="main" class="main-board">
		<div class="inner">
			<div class="columns" id="columns">
				<c:forEach var="b" items="${board}" begin="0" end="20">
					<div class="image fit">
						<a href="showDetail?boardNum=${b.b_num}"> 
						<img src="./resources/image/board/${b.b_image1}" alt="loading..." >
						</a><br>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
</html>