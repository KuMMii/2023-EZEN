function loginCheck(){
	if(document.frm.userid.value.length==0){
		alert("아이디를 입력하세요");
		document.frm.userid.value.focus();
		return false;
	}
	if(document.frm.pwd.value.length==0){
		alert("비밀번호를 입력하세요");
		document.frm.pwd.value.focus();
		return false;
	}
	return true;
}

function idCheck(){
	
	if(document.frm.userid.value==""){
			alert('아이디를 먼저 입력 후 중복체크 버튼을 클릭하세요');
			document.frm.userid.focus();
			return;
		}
		
		var inputid = document.frm.userid.value;
		var opt = 'toolbar=no, menubar=no, scrollbars=ues, width=500, height=200';
		window.open('board.do?command=idcheck&userid='+inputid ,'id-check',opt);
		
}

function idok(userid){
	opener.frm.userid.value=userid;
	opener.frm.reid.value=userid;
	self.close();
}


function joinCheck(){
		if(document.frm.name.value==""){
			alert("이름은 필수입력 사항입니다.");
			document.frm.name.focus(); //focus는 커서 깜빡이게 하는거!
			return false;
		}else if(document.frm.userid.value.length<4){
			alert("아이디는 4글자 이상이어야 합니다.")
			document.frm.userid.focus();
			return false;
		}else if(document.frm.userid.value!=document.frm.reid.value){
			alert("아이디는 중복체크를 하지 않으셨습니다.")
			document.frm.userid.focus();
			return false;
		}else if(document.frm.pwd.value.length==0){
			alert("비밀번호는 필수입력 사항입니다.")
			document.frm.pwd.focus();
			return false;
		}else if(document.frm.pwd.value!=document.frm.pwd_check.value){
			alert("비밀번호 확인이 일치하지 않습니다.")
			document.frm.pwd.focus();
			return false;
		}else{
			return true;
		}
	}
	
	function updateCheck(){
		if(document.frm.name.value==""){
			alert('이름은 필수입력 사항입니다.');
			document.frm.name.focus();
			return false;
		}else if(document.frm.pwd.value.length==0){
			alert('비밀번호는 필수입력 사항입니다.');
			document.frm.pwd.focus();
			return false;
		}else if(document.frm.pwd.value!=document.frm.pwd_check.value){
			alert('비밀번호 확인이 일치하지 않습니다.');
			document.frm.pwd.focus();
			return false;
		}else {
			return true;
		}
	}
	
	function boardCheck(){
			if(document.frm.pass.value==""){
			alert('비밀번호는 필수입력 사항입니다.');
			document.frm.pass.focus();
			return false;
		}else if(document.frm.title.value==""){
			alert('제목은 필수입력 사항입니다.');
			document.frm.title.focus();
			return false;
		}else if(document.frm.content.value==""){
			alert('내용을 입력해주세요.');
			document.frm.content.focus();
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	