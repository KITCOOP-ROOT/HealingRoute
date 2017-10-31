<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCQjHp-XiLQiHLHI-2lk8gZGPqM4V13l0&callback=initMap"></script>
<script>
function initMap(){
	var map = new google.maps.Map(document.getElementById('map'), {
        center: new google.maps.LatLng(37.525623, 126.936158),
        zoom: 12 });
	
    var infoWindow = new google.maps.InfoWindow;
      
	downloadUrl('http://localhost/root/resources/map.xml', function(data) {
				var xml = data.responseXML;
				var markers = xml.documentElement.getElementsByTagName('marker');
				Array.prototype.forEach.call(markers, function(markerElem) {
					var name = markerElem.getAttribute('name');
					var city = markerElem.getAttribute('l_city');
					var b_point = markerElem.getAttribute('b_point');
					var address = markerElem.getAttribute('address');
					var type = markerElem.getAttribute('type');
					var point = new google.maps.LatLng(
							parseFloat(markerElem.getAttribute('lat')),
							parseFloat(markerElem.getAttribute('lng')));
					var infowincontent = document.createElement('div');
					var strong = document.createElement('strong');
					
					pointImgUrl = "./resources/image/map/";
					pointimg = "";
					if(b_point==1){
						image = "map_star1.png";
					}else if(b_point==2){
						image = "map_star2.png";
					}else if(b_point==3){
						image = "map_star3.png";
					}else if(b_point==4){
						image = "map_star4.png";
					}else if(b_point==5){
						image = "map_star5.png";
					}
					img_url = ' (' + "<img src='"+ pointImgUrl + image + "'>" + ')';
					
					strong.innerHTML= '위치 : ' + city + '<br> 작성자('+ name + ')';
					infowincontent.append(strong);
					infowincontent.appendChild(document.createElement('br'));
					var text = document.createElement('text');
					text.innerHTML= '평점 ' + img_url ;
					infowincontent.appendChild(text);
					infoWindow.setContent(infowincontent);
					infoWindow.open(map, marker);

					var iconBase = './resources/image/';
					
					var marker = new google.maps.Marker({
					    position: point,
					    map: map,
					    icon: iconBase + 'pin.png'});

		              marker.addListener('click', function() {
		                  infoWindow.setContent(infowincontent);
		                  infoWindow.open(map, marker);
		                });
		});
	});
}

function downloadUrl(url, callback) {
	var request = window.ActiveXObject ? new ActiveXObject(
			'Microsoft.XMLHTTP') : new XMLHttpRequest;
	request.onreadystatechange = function() {
		if (request.readyState == 4) {
			callback(request, request.status);
		}
	};
	request.open('GET', url, true);
	request.send(null);
}
	
	
</script>
</head>
<body>
<div id="map"></div>
</body>
</html>