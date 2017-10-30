<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"/>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css" href="./resources/css/styleDetail.css" />
<script type="text/javascript" src="./resources/js/jqueryDetail.js"></script>
<link href="./resources/css/bootstrapDetail.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
<link href="./resources/css/business-casual.css" rel="stylesheet">

<title>Detail</title>
</head>
<body>
<!-- main top(고정) -->
<div class = "top-menu-div">
	<c:import url="../main/top.jsp" />
</div>
<br><br><br>
<div class="container">
	<div class="i_date text-lg text-muted">${detail.b_date }</div>

	<!-- Image Banner -->
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="carousel-item active">
				<img class="d-block img-fluid w-100" src="./resources/image/board/${detail.b_image1}" width="800" height="600" alt="">
            </div>
            <div class="carousel-item">
				<img class="d-block img-fluid w-100" src="./resources/image/board/${detail.b_image2}" width="800" height="600" alt="">
            </div>
            <div class="carousel-item">
				<img class="d-block img-fluid w-100" src="./resources/image/board/${detail.b_image3}" width="800" height="600" alt="">
            </div>
            <div class="carousel-item">
				<img class="d-block img-fluid w-100" src="./resources/image/board/${detail.b_image4}" width="800" height="600" alt="">
            </div>
            <div class="carousel-item">
				<img class="d-block img-fluid w-100" src="./resources/image/board/${detail.b_image5}" width="800" height="600" alt="">
            </div>
		</div>
			
			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
	</div>
        
	<div class="i_addr text-muted">${detail.m_addr }</div>
        
	<div class="text-center mt-4">
		<div class="text-heading text-muted text-lg">평점 ${detail.b_point }</div>
			<h1 class="my-2">${detail.b_title }</h1>
			<hr class="divider2" align="right">
			<div class="i_addr text-muted"><a href="${detail.b_link }" target="_blank">${detail.b_link }</a></div>
			<div class="recommend text-muted text-lg"><img src="./resources/image/h.png" width="20px" height="20px"><br> 
				<strong>${detail.b_recommend }</strong>
			</div>
	</div>
        <div class="bg-faded p-4 my-4">
        	<hr class="divider">
        	<h2 class="text-center text-lg text-uppercase my-0"> 
				<strong>${detail.b_nickname } ' S REVIEW</strong>
        	</h2>
        	<hr class="divider">
        	<p>${detail.b_content }</p>
        	<p></p>
		</div>
</div>

<!-- Bootstrap core JavaScript -->
<script src="./resources/js/jquery.min.js"></script>
<script src="./resources/js/bootstrap.bundle.js"></script>
</body>
</html>