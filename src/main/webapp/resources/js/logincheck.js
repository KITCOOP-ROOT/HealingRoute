
function logout(){
	action = "logout";
	method = "post";
	submit();
}

function logincheck(){
	var fmail = "";
	var pwd = "";
	
	
	$.ajax({
		type: "post",
		url : "logincheck",
		data : {"f_email" : $("#f_email").val(), "f_pwd" : $("#f_pwd").val()},
		dataType: "json",
		success : function(logdata){
		$(logdata.logindata).each(function(index, objArr){
			fmail = objArr["이메일"];
			pwd = objArr["패스워드"];
		});
		if(loginform.f_email.value == ""){
			alert("이메일을 입력하세요!");
		}else if (fmail != $("#f_email").val()){
				alert("등록되지 않는 이메일 입니다");
			}else if(loginform.f_pwd.value == ""){
				alert("비밀번호를 입력하세요!");
			}else if(pwd != $("#f_pwd").val()){
				alert("비밀번호가 틀렸습니다");
			}
			else{				
				alert("로그인 성공!!");
				loginform.action = "login";
				loginform.method = "post";
				loginform.submit();
			}
		},
	error : function(request, status, error) {
		alert("code:" + request.status + "\n" + "error:" + error);
			}
		});	
	}
