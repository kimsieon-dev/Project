/*변수 선언*/


var id = document.querySelector('#memberbb_id');

var pw1 = document.querySelector('#memberbb_password');
var pwMsg = document.querySelector('#alertTxt');
var pwImg1 = document.querySelector('#memberbb_password_img1');

var pw2 = document.querySelector('#pswd2');
var pwImg2 = document.querySelector('#pswd2_img1');
var pwMsgArea = document.querySelector('.int_pass');

var userName = document.querySelector('#memberbb_name');

var email = document.querySelector('#memberbb_email');

var yy = document.querySelector('#memberbb_yy');
var mm = document.querySelector('#memberbb_mm');
var dd = document.querySelector('#memberbb_dd');

var error = document.querySelectorAll('.error_next_box');


var check_id = false;


/*이벤트 핸들러 연결*/
id.addEventListener("change", checkId);

/* 아이디 중복 확인 */
id.addEventListener("blur", checkId);
pw1.addEventListener("change", checkPw);
pw2.addEventListener("change", comparePw);
userName.addEventListener("change", checkName);
email.addEventListener("change", isEmailCorrect);
yy.addEventListener("change", isBirthCompleted);
mm.addEventListener("change", isBirthCompleted);
dd.addEventListener("change", isBirthCompleted);





/*콜백 함수*/


function checkId() {
    var idPattern = /[a-zA-Z0-9_-]{5,20}/;
    if(id.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
        check_id = false;
    } else if(!idPattern.test(id.value)) {
        error[0].innerHTML = "5~15자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        error[0].style.display = "block";
        check_id = false;
    } else {
    	error[0].innerHTML = "";
    	overlap();
    }
    console.log("아이디 : ", check_id);
}
function overlap() {		// 아이디 중복 확인
	var check = id.value;
//	if(id.value === "") {
//        error[0].innerHTML = "필수 정보입니다.";
//        error[0].style.color = "red";
//        error[0].style.display = "block";
//        check_id = false;
//	} else {
		$.ajax({
			type : "POST",
		    url : "memberoverlapaction.bd",
		    data : {"check" : check},
		    success : function(result) {
		    	if(result.trim() == "true") {
		    		error[0].innerHTML = "이미 사용중이거나 탈퇴한 아이디입니다.";
		            error[0].style.color = "red";
		            error[0].style.display = "block";
		            check_id = false;
		    	} else {
		    		error[0].innerHTML = "멋진 아이디네요!";
		            error[0].style.color = "#08A600";
		            error[0].style.display = "block";
		            check_id = true;
		    	}
		    }
		})
//	}
	console.log("아이디중복 : ", check_id);
}

function checkPw() {
    var pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
    if(pw1.value === "") {
        error[1].innerHTML = "필수 정보입니다.";
        pwMsg.style.display = "block";
        pwImg1.src = "m_icon_pass.png";
        error[1].style.display = "block";
    } else if(!pwPattern.test(pw1.value)) {
        error[1].innerHTML = "8~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        pwMsg.innerHTML = "사용불가";
        pwMsgArea.style.paddingRight = "93px";
        error[1].style.display = "block";
        
        pwMsg.style.display = "block";
        pwImg1.src = "image/m_icon_not_use.png";
    } else {
        error[1].style.display = "none";
        pwMsg.innerHTML = "안전";
        pwMsg.style.display = "block";
        pwMsg.style.color = "#03c75a";
        pwImg1.src = "image/m_icon_safe.png";
    }
}

function comparePw() {
    if(pw2.value === pw1.value) {
        pwImg2.src = "image/m_icon_check_enable.png";
        error[2].style.display = "none";
    } else if(pw2.value !== pw1.value) {
        pwImg2.src = "image/m_icon_check_disable.png";
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.display = "block";
    } 

    if(pw2.value === "") {
        error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block";
    }
}

function checkName() {
    var namePattern = /[가-힣]/;
    if(userName.value === "") {
        error[3].innerHTML = "필수 정보입니다.";
        error[3].style.display = "block";
    } else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
        error[3].innerHTML = "한글을 사용하세요. (특수기호, 공백 사용 불가)";
        error[3].style.display = "block";
    } else {
        error[3].style.display = "none";
    }
}



function isEmailCorrect() {
    var emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;

    if(email.value === ""){ 
    	error[4].innerHTML = "필수 정보입니다.";
        error[4].style.display = "block"; 
    } else if(!emailPattern.test(email.value)) {
        error[4].style.display = "block";
    } else {
        error[4].style.display = "none"; 
    }
}

function isBirthCompleted() {
    var yearPattern = /[0-9]{4}/;

    if(!yearPattern.test(yy.value)) {
        error[5].innerHTML = "태어난 년도 4자리를 정확하게 입력하세요.";
        error[5].style.display = "block";
    } else {
        isMonthSelected();
    }


    function isMonthSelected() {
        if(mm.value === "월") {
            error[5].innerHTML = "태어난 월을 선택하세요.";
        } else {
            isDateCompleted();
        }
    }

    function isDateCompleted() {
        if(dd.value === "") {
            error[5].innerHTML = "태어난 일(날짜) 2자리를 정확하게 입력하세요.";
        } else {
            isBirthRight();
        }
    }
}



function isBirthRight() {
    var datePattern = /\d{1,2}/;
    if(!datePattern.test(dd.value) || Number(dd.value)<1 || Number(dd.value)>31) {
        error[5].innerHTML = "생년월일을 다시 확인해주세요.";
    } else {
        checkAge();
    }
}

function checkAge() {
    if(Number(yy.value) < 1920) {
        error[5].innerHTML = "정말이세요?";
    } else if(Number(yy.value) > 2019) {
        error[5].innerHTML = "미래에서 오셨군요. ^^";
    } else if(Number(yy.value) > 2005) {
        error[5].innerHTML = "만 14세 미만의 어린이는 보호자 동의가 필요합니다.";
    } else {
        error[5].style.display = "none";
    }
}
