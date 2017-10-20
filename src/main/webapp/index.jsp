<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <meta charset="utf-8">
    <title>★★힐링루트★★(여행정보/리뷰 사이트)</title>
	<link rel="stylesheet" type="text/css" href="https://bootswatch.com/paper/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./resources/css/index.css">
</head>

<body class="index-main">
<!-- 로고영역 -->
<div>
<img src = "./resources/image/logo_big.png " class="alpha logo-div" >
</div>

<!-- 검색영역 -->
<div class="search-bar">
<form class="navbar-form navbar-center" role="search" >
	<input type="text" class="form-control input" placeholder="Search" size="100" name="search" autocomplete="off"> 
	<input type="submit" class="btn btn-default" value="검색">
</form>
</div>

<!-- 배경 효과 -->
<div class="covervid-wrapper bg_effect"></div>

<!-- 배경 동영상 -->
<div class="movie-div">
	<video id="video" preload="auto" autoplay="true" loop="loop" muted="muted" volume="0">
	<source src="./resources/data/kauai_vid_1.mp4">
	</video>
</div>

</body>
</html>
