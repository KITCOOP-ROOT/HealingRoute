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
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/board_script.js"></script>
</head>
<body>
<div class="div">
<form action="write" method="post" enctype="multipart/form-data" name="bfrm" id="bfrm">
	<table>
	<tr>
		<td>닉네임</td>
		<td colspan="2">
			<input type="text" name="b_nickname">
		</td>
		<td>제목</td>
		<td colspan="2">
			<input type="text" name="b_title">
		</td>
	
	</tr>
	<tr>
		<td>이미지</td>
		<td>
			<div class="file_input_div">
			<img src="./resources/image/board/upphoto.png" class="file_input_img_btn"/>
			<input type="file" name="upfile" id="upfile" class="file_input_hidden" multiple="multiple"/>
			</div>
		</td>
		<td colspan="4">
				 <div id="imageview" class="divdom"></div>
		</td>
	</tr>
	<tr>
		<td>
		별점
		</td>
		<td colspan="4">
		<div id="rating" align=center>
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
		<td>글내용</td>
		<td colspan="4">
			<textarea rows="10" style="width: 99%"  name="b_content" ></textarea>
		</td>
	</tr>
 
	<tr>
		<td>
			<input type="button" value="수정" onclick="javascript:update()">
		</td>
	</tr>
	</table>
</form>
</div>
</body>
</html>