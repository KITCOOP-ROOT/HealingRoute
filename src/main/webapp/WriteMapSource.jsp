<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>지역정보 조회</title>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCQjHp-XiLQiHLHI-2lk8gZGPqM4V13l0"></script>
<style>
#map {
	width: 600px;
	height: 600px;
	background-color: grey;
}
</style>
<script type="text/javascript">
window.onload = function() {
  document.getElementById("serachBtn").onclick = requestXhr;
  document.getElementById("search_location").onkeydown=function (event) {
    if(event.keyCode==13){
      requestXhr;
    }
  }
}
var xhr = null;
function requestXhr() {
	if (window.ActiveXObject) {
		xhr = new ActiveXObject("Msxml2.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	}
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				initMap();
			}
		}
	}
	// 검색값
	var location = document.getElementById("search_location").value;
	xhr.open("get", "https://maps.googleapis.com/maps/api/geocode/json?address=" + location + "&language=ko", true);
	xhr.send(null);
}

function initMap() {
	var data = xhr.responseText;
	var parseData = JSON.parse(data);
	var search_lat = parseData.results[0].geometry.location.lat;
	var search_lng = parseData.results[0].geometry.location.lng;
	document.getElementById("mapping").innerHTML =  "<input type=\"hidden\" id=\"m_lat\" value=\""+ search_lat +"\">"+
													"<input type=\"hidden\" id=\"m_lng\" value=\""+ search_lng +"\">"+
													"<div id=\"map\"></div>";
	viewMap(search_lat, search_lng);
}

function viewMap(search_lat, search_lng) {
	var search_loc = {
		lat : search_lat,
		lng : search_lng
	};
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom : 15,
		center : search_loc
	});
	var marker = new google.maps.Marker({
		position : search_loc,
		map : map
	});
}
</script>

</head>

<body>
	검색 지역 : <input type="text" id="search_location">
	<button id="serachBtn">찾기</button>
	<div id="latlngData"></div>
	<div id="mapping"></div>
</body>

</html>
