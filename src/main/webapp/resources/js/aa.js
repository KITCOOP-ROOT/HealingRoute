var sel_files=[];
$(document).ready(function(){
	$("#input_imgs").on("change", imageviews)
});
function imageviews(e) {
	//alert("aa");
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
			var img_html ="<img src=\"" +e.target.result + "\"/>";
			$(".imgs_wrap").append(img_html);
			
		}
		reader.readAsDataURL(f);
	});
}