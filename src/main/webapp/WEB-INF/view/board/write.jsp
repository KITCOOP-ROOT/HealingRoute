<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/paper_bootstrap.css">
<link rel="stylesheet" type="text/css" href="./resources/css/boardwrite.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/board_script.js"></script>
</head>
<body>
<c:set var="user" value="${user}"/>
<div class = "top-menu-div">
	<c:import url="../main/top.jsp" />
</div>
<br><br><br><br><br>
<div class="divboard" >
<form action="write" method="post" enctype="multipart/form-data" name="bfrm" id="bfrm">
	<table  class="table table-striped table-hover ">
	<tr class="active">
		<td colspan="4">제목
			<input type="text" name="b_title" size="100">
		</td>
	</tr>  
	<tr class="active">
		<td  class="top_menu_left">닉네임
			<input type="text" name="b_nickname" readonly="readonly" value="${user}">
		</td>
			<td colspan="4">
		<div id="rating" align=center class="starcss">
			<span>
					<img id="image1" onmouseover=show(1) onclick=mark(1)  onmouseout=noshow(1) src="./resources/image/board/starout.png">
					<img id="image2" onmouseover=show(2) onclick=mark(2)  onmouseout=noshow(2) src="./resources/image/board/starout.png">
					<img id="image3" onmouseover=show(3) onclick=mark(3)  onmouseout=noshow(3) src="./resources/image/board/starout.png">
					<img id="image4" onmouseover=show(4) onclick=mark(4)  onmouseout=noshow(4) src="./resources/image/board/starout.png">
					<img id="image5" onmouseover=show(5) onclick=mark(5)  onmouseout=noshow(5) src="./resources/image/board/starout.png">
			</span>
			<br><span id="startext">평가하기</span>
		</div>
		<input type="hidden" name="b_point">
		</td> 
	</tr> 
	<tr>   
		<td colspan="4">
			<div class="file_input_div"> 
				<div id="imageview1" class="file_input_div">
					<img src="./resources/image/board/upphoto.png" class="file_input_img_btn" id="img1"/>
					<input type="file" name="upfile1" id="upfile1"  multiple="multiple" class="file_input_hidden"/>
				</div>
				<div id="imageview2" class="file_input_div">
					<img src="./resources/image/board/upphoto.png" class="file_input_img_btn" id="img2"/>
					<input type="file" name="upfile2" id="upfile2" multiple="multiple" class="file_input_hidden"/>
				</div>
				<div id="imageview3" class="file_input_div">
					<img src="./resources/image/board/upphoto.png" class="file_input_img_btn" id="img3" />
					<input type="file" name="upfile3" id="upfile3" multiple="multiple" class="file_input_hidden" />
				</div>
				<div id="imageview4" class="file_input_div">
					<img src="./resources/image/board/upphoto.png" class="file_input_img_btn" id="img4"/>
					<input type="file" name="upfile4" id="upfile4" multiple="multiple" class="file_input_hidden" />
				</div>
				<div id="imageview5" class="file_input_div">
					<img src="./resources/image/board/upphoto.png" class="file_input_img_btn" id="img5"/>
					<input type="file" name="upfile5" id="upfile5" multiple="multiple" class="file_input_hidden"/>
				</div>
			</div>

		</td>
	</tr>
			
	<tr class="active">
		<td colspan="4">
			<textarea rows="10" style="width: 100%; resize: none;"  name="b_content"></textarea>
		</td>
	</tr>
	<tr class="active">
		<td colspan="4">
			<div class="btn-group btn-group-justified">
			  <a href="#" class="btn btn-default">HOME</a>
			  <a href="#" class="btn btn-default" onclick="javascript:gogo()">글쓰기</a>
			  <a href="#" class="btn btn-default" >다시쓰기</a>
			  <a href="update?b_num=3" class="btn btn-default" >수정하기</a>
			</div>
		</td>
	</tr>
	</table>

</form>
</div>
</body>
</html>
