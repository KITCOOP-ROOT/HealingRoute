
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
	$("#upfile").on("change", imageviews)
	
});


function imageviews(e) {
	//이미지 정보들을 초기화
	//sel_files =[];
	//$("#imageview").empty();

	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files)

	filesArr.forEach(function(f){
		if(!f.type.match("image.*")){
			alert("확장자는 이미지만 가능");
			return;
		}
		sel_files.push(f);
		
		var reader = new FileReader();
		reader.onload = function(e){
//			img_html ="<a href=\"javascript:void(0);\" onclick=\"deleteiamge("+index+")\" " + "id=\"img_id_"+index+"\">" +
//							"<img src=\"" +e.target.result + "\" data-file='"+f.name+"'  " + "class='file_input_img_btn' title='Click to remove'>" + 
//							"<div class='del'><input type=\"file\" name=\"ufile\" id=\"ufile\" class='file_hidden' /><input type=\"hidden\" name=\"fileNames\" id=\"fileNames\" value=\"" + f.name + "\"/></div></a>"; 
			
			img_html ="<a href=\"javascript:void(0);\" onclick=\"deleteiamge("+index+")\" " + "id=\"img_id_"+index+"\">" +
			"<img src=\"" +e.target.result + "\" data-file='"+f.name+"'  " + "class='file_input_img_btn' title='Click to remove'>" + 
			"<div class='del' style=\"display: inline;\"><input type=\"file\" name=\"ufile\" id=\"ufile\" class='file_hidden' /></div><input type=\"hidden\" name=\"b_image" + (count+1) + "\" value=\"" + f.name + "\"/></a>"; 
			
			index++;
			count++; 
			if(count <= 5){
				$("#imageview").append(img_html);
			}else{
				count =5;
				alert('더이상 추가할수없습니다');
			}
			
		}
		
		reader.readAsDataURL(f);
		
	});
}
	//특정이미지 삭제
function deleteiamge(index){
	console.log("index:" + index);
	sel_files.splice(index,1);
	//input file,hidden값 초기화
	var file = $("#fileNames").val();
	console.log("파일명"+file);
	$(file).empty();
	var ufile = $("#ufile").val();
	console.log("파일명"+ufile);
	$(ufile).empty();
	var img_id ="#img_id_" +index;
	
	$(img_id).remove();
	
	console.log(sel_files);
	count--;
}
//글작성 체크란
function writecheck(bfrm){
	if(bfrm.b_title.value === ""){ 
		alert("제목을 작성해주세요")
		bfrm.b_title.focus();
		return; 
	}else if(bfrm.b_point.value === 0){ 
		alert("별점을 눌러주세요")
		bfrm.b_point.focus();
		return; 
	}
}

//글쓰기 작성 전송
function gogo(){
	if(bfrm.b_title.value === ""){ 
		alert("제목을 작성해주세요")
		bfrm.b_title.focus();
		return; 
	}else if(bfrm.b_point.value === ""){ 
		alert("별점을 눌러주세요")
		bfrm.b_point.focus();
		return; 
	}else{
		bfrm.action = "write";	
		bfrm.method="post";
		bfrm.submit();
	}
	
}



