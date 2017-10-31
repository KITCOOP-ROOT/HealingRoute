
	function input() {		
		var email =  loginfrm.f_email.value;
		var nickname = loginfrm.f_nickname.value;
		var pwd = loginfrm.f_pwd.value; 		
		var pattern = /^[A-Za-z0-9]{4,12}$/;
		
		if(loginfrm.f_email.value == "") {
			alert("이메일을 입력하세요");
		} else if (!email.match(pattern)) {
			alert("입력 양식에따라 작성하시오");
		} else if (loginfrm.f_pwd.value == "") {
			alert("비밀번호를 입력하세요");
		} else if (loginfrm.f_nickname.value == "") {
			alert("닉네임을 입력하세요");
		} else {			
			var isInvalidEmail = false, isInvalidName = false; 
			$.ajax({
				type : "post",
				url : "familyresiter",
				data : {"f_email" : email,"f_nickname" : nickname},
				dataType : "json",
				success : function(register) {
					$(register.insert).each(function(index, arr) {
						if(email == arr["이메일"]) 	isInvalidEmail = true; 
						if(nickname == arr["닉네임"]) isInvalidName = true; 
					});
					if(isInvalidEmail) {
						alert("존재하는 email입니다");
					}else if(isInvalidName) {
						alert("존재하는 닉네임 입니다.");
					} else {
						loginfrm.action = "insert";
						loginfrm.method = "post";
						alert("가입에 성공하였습니다!!")
						loginfrm.submit();
					}
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "error:" + error);
				}
			});
		} 
	}
	// Get the model
	var model = document.getElementById('id01');

	// When the user clicks anywhere outside of the model, close it
	window.onclick = function(event) {
	    if (event.target == model) {
	        model.style.display = "none";
	    }
	}
