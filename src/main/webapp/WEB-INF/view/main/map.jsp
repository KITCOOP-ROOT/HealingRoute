<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>map</title>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
<script async defer	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCQjHp-XiLQiHLHI-2lk8gZGPqM4V13l0&callback=initMap"></script>
<script>
  function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: {lat: 37.531125, lng: 126.928477}
    });
    var labels = 'ABCD';
    var markers = locations.map(function(location, i) {
      return new google.maps.Marker({
        position: location,
        label: labels[i % labels.length]
      });
    });

    // Add a marker clusterer to manage the markers.
    var markerCluster = new MarkerClusterer(map, markers,
        {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
  }
  var locations = [
	  
    {lat: 37.551169, lng: 126.988173},
    {lat: 37.525017, lng: 126.939052},
    {lat: 37.525623, lng: 126.936158},
    {lat: 37.520617, lng: 127.022938}
  ]

  
</script>
</head>
<body>
<c:forEach var="d" items="${board}" varStatus="status">
	<input type="hidden" value="${d.m_lat}" id="map_lat${status.index}">
	<input type="hidden" value="${d.m_lng}" id="map_lng${status.index}">
</c:forEach>
	<div id="map"></div>
</body>
</html>