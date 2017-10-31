<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Intro</title>
<!--  login  -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="./resources/js/logincheck.js"></script>
<link href="./resources/css/login.css" rel="stylesheet" type="text/css"> 
<link href="./resources/css/familyinsert.css" rel="stylesheet" type="text/css">
<script src="./resources/js/familyresiter.js"></script>

<%
	String email = (String)session.getAttribute("email");
	String log = "";
	 if (email == null) {
		log = "<a href='#' id='myBtn' style='text-align:center; color:white;'>login</a>";
		System.out.println("dddddd");
	} else {
		log = "<a href='logout' onclick=\"javascript:alert('로그아웃 되었습니다')\" style='text-align:center;  color:light-blue;'>logout</a>";
				
	}
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModalIntro").modal();
    });
});
</script>
<!--  login finished -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script src="../resources/js/intro.js"></script>
<link rel="stylesheet" type="text/css" href="https://bootswatch.com/paper/bootstrap.min.css">
<link href="./resources/css/intro.css" rel="stylesheet" type="text/css">

</head>
<body class="main">
	<div class="header align-center">
		<div class="container-fluid ">
			<%=log%>
			
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
				<div id="searchRecord"> </div>
				<!-- 검색 영역 -->
				<div class="search-bar">
				<form class="navbar-form navbar-center" role="search" name="frm" id="searchFrom">
					<input type="text" class="form-control input "  placeholder="도시명을 입력하세요... " autocomplete="off"
						name="cityName" id="cityName" size="auto" onkeydown="searchAddr()">
					<input type="button" class="btn btn-default" onclick="check()" value="O K">
				</form>
				</div>
				<div id="resultList"></div>
				<div id="categoryArea">
				<table>
					<tr>
						<c:forEach var="c" items="${contList}">
							<td nowrap><a href="#" onclick="searchNation('${c.l_continent }'); return false;">${c.l_continent }</a>&nbsp;&nbsp;&nbsp;</td>
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
	<!-- Modal -->

  <!-- Modal 로그인-->
  <div class="modal fade" id="myModalIntro" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <span data-dismiss="modal" onclick="document.getElementById('myModalIntro').style.display='none'" class="close" style="font-size:90px;">&times;</span>
        <div class="modal-header" style="padding:35px 50px;">
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>	      
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" name="loginform">
            <div class="form-group" style="text-align:left">
              <label for="usrname"><span class="glyphicon glyphicon-envelope"></span> UserEmail</label>
              <input type="text" class="form-control" id="f_email" name="f_email" placeholder="Enter email" >
            </div>
            <div class="form-group" style="text-align:left">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" id="f_pwd" name="f_pwd" placeholder="Enter password">
            </div>
            <div class="checkbox" style="text-align:left">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
    		  <br>
              <input type="button" onclick="logincheck()" class="btn btn-primary btn-block" value="login">
          </form>
        </div>
        <div class="modal-footer">
          <p><a data-toggle="modal" href="#id01">회원 가입</a></p>
          <p><a href="#">비밀번호 찾기</a></p>
        </div>
      </div>
      
    </div>
  </div> 

<!-- Modal : 회원 가입 -->
  <div class="modal fade" id="id01" role="dialog">
    <div class="modal-dialog">   
      <!-- Modal content-->
      <div class="modal-content">
      <span data-dismiss="modal"  class="close" style="font-size:90px;">&times;</span>
        <div class="modal-header" style="padding:35px 50px;">
          <h4><span class="glyphicon glyphicon-pencil"></span> 회원가입</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        <form role="form" name="loginfrm" id="loginfrm">
        	<div class="form-group" style="text-align:left">
              <label for="nickname"><span class="glyphicon glyphicon-user"></span> UserNickName</label>
              <input type="text" class="form-control" id="f_nickname" name="f_nickname" placeholder="Enter nickname" required>
            </div>
            <div class="form-group" style="text-align:left">
              <label for="usrname"><span class="glyphicon glyphicon-envelope"></span> UserEmail</label>
              <input type="text" class="form-control" id="f_email" name="f_email" placeholder="Enter email" required>
            </div>
            <div class="form-group" style="text-align:left">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" id="f_pwd" name="f_pwd" placeholder="Enter password" required>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
              <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
            </div>
           	<div class="clearfix">
        	<button type="button" data-dismiss="modal" onclick="document.getElementById('id01').style.display='none'" class="btn btn-danger pull-left">Cancel</button>
        	<button type="button" onclick="input()" value="가입" class="btn btn-success pull-right">Sign Up</button>
     		</div>	                
        </form>
        </div>
      </div>     
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