<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		log = "<a href='#' id='myBtn' style='text-align:center;font-size:1.5rem'>login</a>";
		System.out.println("dddddd");
	} else {
		log = "<a href='logout' onclick=\"javascript:alert('로그아웃 되었습니다')\" style='text-align:center;font-size:1.5rem''>logout</a>";
				
	}
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModalTop").modal('show');
    });
});
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="./resources/js/script_member.js"></script>
<link rel="stylesheet" type="text/css"	href="./resources/css/paper_bootstrap.css">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">


<!--  login finished -->
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
				<span><%=log%>&nbsp;&nbsp;/ &nbsp;&nbsp;<a href="showMypage?nickName=메시">마이페이지</a></span>
				<span></span>
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

	<!-- Modal -->

  <!-- Modal 로그인-->
  <div class="modal fade" id="myModalTop" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <span data-dismiss="modal" onclick="document.getElementById('myModalTop').style.display='none'" class="close" style="font-size:90px;">&times;</span>
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

</body>
</html>