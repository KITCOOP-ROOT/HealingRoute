
//평점 이벤트 입력란----------------------
var locked = 0; //이미지고정을위한 lock
var stateMsg; //br_scope의 출력값
var toggle =false; //클릭을위한 이벤트
function show(b_point){
	var i;
	var image;
	var el;
	e = document.getElementById('startext');
	//Lock 체크 
	if(locked) return; //lock이면 아래를 수행 안함
	
	//1. 별 초기화(5개)
	locked=0;
	noshow(5);
	//2. 노란별 이미지 출력
	for (i = 1; i <= b_point; i++){
		image = 'image' + i;
		el= document.getElementById(image);
		el.src="./resources/image/board/starover.png";
	}
	//3. 값을 출력
	stateMsg = b_point * 2;
	e.innerHTML = stateMsg + "점";
	
}

function noshow(b_point){

	if(locked) //클릭 뒤 mouseout action : 별 그림 고정
		return;
	var i;
	var image;
	var el;
	
	for(i = 1; i<=b_point; i++){ // 별 회색으로 
		image = 'image' + i;
		el= document.getElementById(image);
		el.src="./resources/image/board/starout.png";
		
	}
	document.getElementById('startext').innerHTML ="평가하기"; //점수 리셋
	b_point = 0;
	stateMsg = b_point;
	
}

function lock(b_point){
	show(b_point);
	locked =1;

}

function unlock(b_point){
	locked=0;
	noshow(5);
}

//별점 버튼클릭시 발생하는 이벤트----------------------
function mark(b_point){

	if(toggle ==false){ //시작
		toggle =true;
		lock(b_point);
		document.bfrm.b_point.value = stateMsg;
	}
	else {
		toggle=false;
		unlock(b_point);
		stateMsg = 0;
		document.bfrm.b_point.value = stateMsg;
	}
}

//이미지 미리보기 div값

//이미지 정보들을 담을 배열
var sel_files=[];
var img_html;
var count =0;
var index =0;//업로드 수량
$(document).ready(function(){
	//count ++;
	$("#upfile1").on("change", { index : '1' }, imageviews);
	$("#upfile2").on("change", { index : '2' }, imageviews);
	$("#upfile3").on("change", { index : '3' }, imageviews);
	$("#upfile4").on("change", { index : '4' }, imageviews);
	$("#upfile5").on("change", { index : '5' }, imageviews);
});

function imageviews(e) {
		var f= e.target.files[0];
		
		if(!f.type.match("image.*")){
			alert("확장자는 이미지만 가능");
			return;
		}
		//sel_files.push(f);
		
		var index = e.data.index; 
		console.log("index!!!!!:" + index)
		
		var reader = new FileReader();
		reader.onload = function(e){ 
			img_html ="<input type=\"hidden\" name=\"b_image" + (index) + "\" value=\"" + f.name + "\"/>" +
						"<div class='file_input_div'><a href=\"#\" onclick='javascript:deleteiamge("+ index +")'>" +
								"<img src='./resources/image/board/ex.jpg' id='del' class='file_input_img_del'/></a></div>"; 
			$("#img"+index).attr("src", e.target.result);
			$("#imageview").append(img_html);
			
		}
		
		reader.readAsDataURL(f);
		
}
	//특정이미지 삭제
function deleteiamge(index){
	alert("삭제");
	var file1 = $("#upfile1").val();
	var file2 = $("#upfile2").val();
	var file3 = $("#upfile3").val();
	var file4 = $("#upfile4").val();
	var file5 = $("#upfile5").val();
	console.log("파일명"+file1);
	console.log("파일명"+file2);
	$(file1).empty();
	$(file2).empty();
	$(file3).empty(); 
	$(file4).empty();
	$(file5).empty();
	$("#img" + index).attr('src', './resources/image/board/upphoto.png'); 
	console.log($("#del").remove());
}




//글쓰기 작성 전송
function gogo(){
	if(bfrm.b_point.value === ""){ 
		alert("별점을 눌러주세요")
		bfrm.b_point.focus();
		return; 
	}else if(bfrm.b_title.value === ""){ 
		alert("제목을 작성해주세요")
		bfrm.b_title.focus();
		return; 
	}else{
		bfrm.action = "write";	
		bfrm.method="post";
		bfrm.submit();
	}
	
}
//글 수정
function update(){
	if(bfrm.b_point.value === ""){ 
		alert("별점을 눌러주세요")
		bfrm.b_point.focus();
		return; 
	}else if(bfrm.b_title.value === ""){ 
		alert("제목을 작성해주세요")
		bfrm.b_title.focus();
		return; 
	}else{
		bfrm.action = "update";	
		bfrm.method="post";
		bfrm.submit();
	}
}




