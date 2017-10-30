<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agency - Start Bootstrap Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="./resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom Fonts -->
   <!-- 
    <link href="./resources/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    -->
    <!-- Theme CSS -->
    <link href="./resources/css/mypage.css" rel="stylesheet">
    
    <!-- Bootstrap core JavaScript -->
    <script src="./resources/js/jquery.min.js"></script>
    <script src="./resources/js/bootstrap.bundle.js"></script>
    <!-- Plugin JavaScript -->
    <script src="./resources/js/jquery.easing.min.js"></script>

</head>
<body>
	<!--  Navigator -->
    <!-- main top(고정) -->
	<div class = "top-menu-div">
		<c:import url="../main/top.jsp" />
	</div>
    <br><br><br>
    <!-- Header -->
    <c:if test="${not empty myBoard[0].b_image1}">
    <header class="masthead" style="background-image: url('./resources/image/board/${myBoard[0].b_image1}');">
    </c:if>
    <c:if test="${empty myBoard[0].b_image1}">  
    <header class="masthead")>
    </c:if>
      <div class="container">
        <div class="intro-text">
          <div class="intro-heading text-uppercase">${user} 님 </div>
          <div class="intro-lead-in">총 ${count} 곳의 여행지가 있습니다 </div>
          <!-- 
          	<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">자세히 보기</a>
          -->
        </div>
      </div>
    </header>

	<!-- Healing Route Board -->
    <section class="bg-light" id="portfolio">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Healing Route</h2>
            <h3 class="section-subheading text-muted">This is the list you have made on the way</h3>
          </div>	
        </div>		
      	<div class="row">      
          <div class="mypage_content" id="mypage_mainContent">
          <figure>
		    <div class="portfolio-item">         
            <a class="portfolio-link" href="write">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
			<img class="img-fluid" src="./resources/image/board/addNew.jpg">
            </a>
          </div>
          </figure>
          <c:forEach var="my" items="${myBoard}">
          <figure>
          <div class="portfolio-item">
            <a class="portfolio-link" href="showDetail?boardNum=${my.b_num}">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="./resources/image/board/${my.b_image1}" alt="">
            </a>
            <div class="portfolio-caption">
              <h4>${my.b_title}</h4>
              <p class="text-muted">좋아요(${my.b_recommend})</p>
            </div>
          </div>
          </figure>
          </c:forEach>    
      </div>
    </div>
    </section>
  </body>
</html>