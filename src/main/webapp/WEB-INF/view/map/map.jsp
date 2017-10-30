<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCQjHp-XiLQiHLHI-2lk8gZGPqM4V13l0&callback=initMap"></script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
<script src="./resources/js/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var nowCenter = new google.maps.LatLng(37.525623,126.936158);
	mapOnload(nowCenter)
});

function over(clickLat,clickLng){
	nowCenter = new google.maps.LatLng(clickLat,clickLng);
	mapOnload(nowCenter);
}

function mapOnload(nowCenter){
	var map = new google.maps.Map(document.getElementById('map'), {
		center : nowCenter,
		zoom : 12
	});
	
	var infoWindow = new google.maps.InfoWindow;
	downloadUrl('http://localhost/root/resources/map.xml', function(data) {
				var xml = data.responseXML;
				var markers = xml.documentElement.getElementsByTagName('marker');
				Array.prototype.forEach.call(markers, function(markerElem) {
					var name = markerElem.getAttribute('name');
					var city = markerElem.getAttribute('city');
					var address = markerElem.getAttribute('address');
					var type = markerElem.getAttribute('type');
					var point = new google.maps.LatLng(
							parseFloat(markerElem.getAttribute('lat')),
							parseFloat(markerElem.getAttribute('lng')));
					var infowincontent = document.createElement('div');
					var strong = document.createElement('strong');
					strong.textContent = name + ' (' + city + ')';
					infowincontent.appendChild(strong);
					infowincontent.appendChild(document.createElement('br'));
					var text = document.createElement('text');
					text.textContent = address
					infowincontent.appendChild(text);
					infoWindow.setContent(infowincontent);
					infoWindow.open(map, marker);
					var iconBase = './resources/image/';
					
					var marker = new google.maps.Marker({
					    position: point,
					    map: map,
					    icon: iconBase + 'pin.png'});
					var count = 0;
					marker.addListener('click', function() {
						if(count==0){
							count++;
						}else{
							count++;
							infoWindow.setContent(infowincontent);
							infoWindow.open(map, marker);
						}
					});
		});
	});
}


function downloadUrl(url, callback) {
	var request = window.ActiveXObject ? new ActiveXObject(
			'Microsoft.XMLHTTP') : new XMLHttpRequest;

	request.onreadystatechange = function() {
		if (request.readyState == 4) {
			request.onreadystatechange = doNothing;
			callback(request, request.status);
		}
	};
	request.open('GET', url, true);
	request.send(null);
}

function doNothing() {
}
	
	
</script>
</head>
<body>
<div id="map"></div>
</body>
</html>