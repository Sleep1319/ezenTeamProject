
    
	function kakaopost() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		           document.querySelector("#LOGIN_POST").value = data.zonecode;
		           document.querySelector("#LOGIN_ADDR").value =  data.address
		           document.querySelector("input[name=ADDR_DETAIL]").focus(); //상세입력 포커싱
		        }
		    }).open();
		}
/*	function checkValue() {
		var form = document.userInfo;
		//스위치 개념?
		//리턴값에 따른 액션 비활성화 체크 필요
		if(!form.LOGIN_ID.value) {
			alert("아이디를 입력하세요.")
			return false;
		}
		if(!form.LOGIN_EMAIL.value) {
			alert("이메일 입력하세요.")
			return false;
		}
		if(!form.LOGIN_PW.value) {
			alert("비밀번호를 입력하세요.")
			return false;
		}
		if(form.LOGIN_PW.value != form.LOGIN_PWch.value) {
			alert("비밀번호가 다릅니다.")
			return false;
		}
		if(!form.LOGIN_NAME.value) {
			alert("이름을 입력하세요.")
			return false;
		}
		if(!form.LOGIN_PHONE.value) {
			alert("전화번호를 입력하세요.")
			return false;
		}	
		return ture;
	} */
	
	function openCheck() {
		window.name = "parentForm"
		window.open("idCheck.jsp", "chkForm", "width=500px, height=300px, resizable = no, scrollbars = no");
	}
	
	//idCheck사용 함수
	function pValue() {
		document.getElementById("userIDCK").value = opener.document.userInfo.LOGIN_ID.value;
	}
	function idCheck() {
		var idCK = document.getElementById("userIDCK");
		var id = idCK.value;
		var idWithoutSpace = id.replace(/\s/g, ''); // 띄어쓰기를 제거한 문자열
		var regex = /^[a-zA-Z0-9]+$/;
    if(idWithoutSpace.length === 0) {
        alert("아이디를 입력하지 않았습니다.");
        return false;
    }
    
    // 특수 문자 및 한글 검사 (알파벳과 숫자만 허용)
    if (!regex.test(id)) {
        alert("한글 및 특수문자 사용 불가");
        return false;
    }
		return true;
	
		
	}
	
	function sendCheckValue() {
		opener.document.userInfo.idDuplication.value = "idCheck";	
		opener.document.userInfo.LOGIN_ID.value = document.getElementById("userIDCK").value;
		
		if(opener != null) {
			opener.chkForm = null;
			self.close();
		}
	}
	function testCK(){
		if(testID != null) {
			alter("테스트 아이디 리스폰 완료" + testID);
		}
	}
	testCK();
	
	function userButton() {
			if(checkID == -1) {
				alert("사용불가 아이디");
				document.getElementById("cancelBtn").style.visibility='visible';
				document.getElementById("useBtn").style.visibility='hidden';
				document.getElementById("msg").innerHTML ="";
			} else if (checkID == 1 && testID != null) {
				var idCK = document.getElementById("userIDCK");
				idCK.value = testID;
				if(idCK.value == testID) {
				document.getElementById("cancelBtn").style.visibility='hidden';
				document.getElementById("useBtn").style.visibility='visible';
				document.getElementById("msg").innerHTML ="사용 가능한 아이디입니다";
				} else {
				document.getElementById("cancelBtn").style.visibility='visible';
				document.getElementById("useBtn").style.visibility='hidden';
				document.getElementById("msg").innerHTML ="확인한 아이디와 다릅니다";	
				}
			}
		}