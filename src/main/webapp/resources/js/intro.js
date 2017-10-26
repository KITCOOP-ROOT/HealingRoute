// 검색어 자동완성
var lastKeyword = "";

function searchAddr() {
	$("#cityName").keyup(function() {
		var word = $("#cityName").val();
		
		if(word == ""){ // 검색어를 지웠을 경우
			lastKeyword = "";
//			$("#result").hide();
			$("#resultList").hide();
		} else if(word != lastKeyword){
			lastKeyword = word; // 마지막에 검색한 값 갱신
		
			if(lastKeyword != ""){
//				$("#result").show();
				$("#resultList").show();
				$.ajax({
					type : "post",
					url : "cityList",
					data : {"cityName" : frm.cityName.value},
					dataType : "json",
					success : function(addrDatas) {
						var str = "<table class='t align-left' >";
//						var str = "";
						var list = addrDatas.datas;
						
						$(list).each(function(index, objArr) {
//							str += "<a href='#' onclick='selectData(\"" + objArr["l_city"] + ", " + objArr["l_nation"] + ", " + objArr["l_continent"] + "\"); return false;'>" + objArr["l_city"] + ", " + objArr["l_nation"] + ", " + objArr["l_continent"] + "</a>";
//							str += "<br>";
							 									
							if(index == 0 || index % 3 == 0) str += "<tr>";
							str += "<td><a href='#' onclick='selectData(\"" + objArr["l_city"] + ", " + objArr["l_nation"] + ", " + objArr["l_continent"] + "\"); return false;'>" + objArr["l_city"] + ", " + objArr["l_nation"] + ", " + objArr["l_continent"] + "</a>&nbsp;&nbsp;</td>";
							if((index+1) % 3 == 0) str += "</tr>";
							
						});
						
						str += "</table>";
						$("#resultList").html(str);
						
						if(list.length == 0){
							$("#resultList").text("검색 결과가 없습니다.");
						}
					},
					error : function() {
						$("#resultList").text("검색 결과가 없습니다.");
					}
				 });
			}
		}
	});
}

// 선택한 대륙에 따른 국가 출력
function searchNation(continent) {
	$("#nationDisp").empty();
	$("#cityDisp").empty();
	$("#cityName").val(""); // 대륙 변경 시 검색창 비움
	$.ajax({
		type : "post",
		url : "nationList",
		data : {"nation" : continent},
		dataType : "json",
		success : function(nationDatas) {
			var str = "<table><tr>";
			var list = nationDatas.datas;

			$(list).each(function(index, objArr) {
				str += "<td><a href='#' onclick='searchCity(\"" + objArr["l_nation"] + "\"); return false;'>" + objArr["l_nation"] + "</a>&nbsp;&nbsp;&nbsp;</td>";
			});
			
			str += "</tr></table>";
			$("#nationDisp").html(str);
		},
		error : function() {
			alert("fail");
		}
	});
}


//선택한 국가에 따른 도시 출력
function searchCity(nation) {
	$("#cityDisp").empty();
	$("#cityName").val(""); // 국가 변경 시 검색창 비움
	$.ajax({
		type : "post",
		url : "city",
		data : {"city" : nation},
		dataType : "json",
		success : function(cityDatas) {
			var str = "<table><tr>";
			var list = cityDatas.datas;
			
			$(list).each(function(index, objArr) {
				str += "<td><a href='#' onclick='selectData(\"" + objArr["l_city"] + ", " + objArr["l_nation"] + ", " + objArr["l_continent"] + "\"); return false;'>" + objArr["l_city"] + "</a>&nbsp;&nbsp;&nbsp;</td>";
			});
			
			str += "</tr></table>";
			$("#cityDisp").html(str);
		},
		error : function() {
			alert("fail");
		}
	});
}

$(document).ready(function() {
	readCookie('city');
});

function check() {
	if(frm.cityName.value == ""){
		alert("도시명을 입력하세요.");
		return;
	}else if(frm.cityName.value == "도시명을 입력하세요."){
		alert("도시명을 입력하세요.");
		return;
	}
	var fullArrd = frm.cityName.value.split(",");
	var city = fullArrd[0];

	addCookie(city);
	frm.action = "showBoard?search=" + city; 
	frm.submit(); 
	
}

//cookie 생성
function creatCookie(cName, cValue, days) {
	var cookieStr = cName + "=" + escape(cValue);
	
	if(days) {
		var expires = new Date();
        expires.setDate(expires.getDate() + days);
        cookieStr += "; expires=" + expires.toGMTString();
    }
	
	document.cookie = cookieStr;
}

// cookie 추가
function addCookie(cValue) {
	var maxItem = 2; // cookie 최대 갯수
	var prev_cValue = readCookie('city');
	
	if ((prev_cValue == '') || (prev_cValue == null)) {
		creatCookie('city', cValue, 7);
	} else {
		if (readCookie('city').split(', ').length > maxItem) {
			prev_cValue = prev_cValue.substring(prev_cValue.indexOf(',') + 1);
		}
		
		if (prev_cValue.match(cValue)) {
			console.log(cValue); // 이미 존재하는 경우 console에만 출력하고 실제 반영되지 않음
		} else {
			creatCookie('city', prev_cValue + ', ' + cValue, 7);
		}
	}
}

// cookie 읽기
function readCookie(cName) {
	var cLink = '';
	
	cName = cName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cName);
    var cValue = '';
    
    if(start != -1){
        start += cName.length;
        var end = cookieData.indexOf(';', start);
       
        if(end == -1)end = cookieData.length;
        cValue = cookieData.substring(start, end);
    }
    var cData = unescape(cValue);
    var temp = cData.split(', ');
    
    for(var i = temp.length-1; i >= 0; i--){
	   cLink += "<a href='#' onclick='selectData(\"" + temp[i] + "\"); return false;'>" + temp[i] + "</a> "
	}

    $("#searchRecord").html(cLink);
    return cData;
}

// 선택된 도시명을 검색창에 출력
function selectData(city) {
	$("#cityName").val(city);
	$("#resultList").empty();
}