function boardCheck(){
	//각각의 요소들의 값이 있는지 없는지 검사
	//문서안에 있는frm (form)요소의 name input tag 안의 값의 길이가 0이면
	if(document.frm.name.value.length == 0 ){
		alert("작성자를 입력하세요");
		return false; //action이 일어나지 않게 만들어줌..
	}
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요");
		return false;
	}
	if(document.frm.title.value.length == 0){
		alert("제목을 입력하세요");
		return false; 
	}
	return true;	
}

function open_win(url,name){
	window.open(url,name,"width=500, height=230");
}

function passCheck(){
	if(document.frm.pass.value.length ==0){
		alert("비밀번호를 입력하세요.");
		return false
	}
	return true;
}