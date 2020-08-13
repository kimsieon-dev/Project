/*변수 선언*/
var pw1 = document.querySelector('#memberbb_password');
var pwMsg = document.querySelector('#alertTxt');
var pwImg1 = document.querySelector('#memberbb_password_img1');

var pw2 = document.querySelector('#pswd2');
var pwImg2 = document.querySelector('#pswd2_img1');
var pwMsgArea = document.querySelector('.int_pass');


var email = document.querySelector('#memberbb_email');

var error = document.querySelectorAll('.error_next_box');

/*이벤트 핸들러 연결*/
pw1.addEventListener("change", checkPw);
pw2.addEventListener("change", comparePw);
email.addEventListener("change", isEmailCorrect);

/*콜백 함수*/
function checkPw() {
    var pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
    if(pw1.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        pwMsg.style.display = "block";
        pwImg1.src = "m_icon_pass.png";
        error[0].style.display = "block";
    } else if(!pwPattern.test(pw1.value)) {
        error[0].innerHTML = "8~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        pwMsg.innerHTML = "사용불가";
        pwMsgArea.style.paddingRight = "93px";
        error[0].style.display = "block";
        
        pwMsg.style.display = "block";
        pwImg1.src = "image/m_icon_not_use.png";
    } else {
        error[0].style.display = "none";
        pwMsg.innerHTML = "안전";
        pwMsg.style.display = "block";
        pwMsg.style.color = "#03c75a";
        pwImg1.src = "image/m_icon_safe.png";
    }
}

function comparePw() {
    if(pw2.value === pw1.value) {
        pwImg2.src = "image/m_icon_check_enable.png";
        error[1].style.display = "none";
    } else if(pw2.value !== pw1.value) {
        pwImg2.src = "image/m_icon_check_disable.png";
        error[1].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[1].style.display = "block";
    } 

    if(pw2.value === "") {
        error[1].innerHTML = "필수 정보입니다.";
        error[1].style.display = "block";
    }
}

function isEmailCorrect() {
    var emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;

    if(email.value === ""){ 
    	error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block"; 
    } else if(!emailPattern.test(email.value)) {
        error[2].style.display = "block";
    } else {
        error[2].style.display = "none"; 
    }
}

function checkValue(){
	var memberbb_password = document.memberModifyForm.memberbb_password;
	
	if(memberbb_password.value == '') {
		alert("비밀번호를 입력해주세요.");
		document.memberModifyForm.memberbb_password.focus();
		return false;
	}
	
	var pswd2 = document.memberModifyForm.pswd2;
	
	if(pswd2.value == '') {
		alert("비밀번호 재확인을 입력해주세요.")
		document.memberModifyForm.pswd2.focus();
		return false;
	}
	
var memberbb_email = document.memberModifyForm.memberbb_email;
	
	if(memberbb_email.value == '') {
		alert("이메일을 입력해주세요.")
		document.memberModifyForm.memberbb_email.focus();
		return false;
	}
}
