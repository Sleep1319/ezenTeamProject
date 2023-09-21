
    //카테고리
    function cate() {
        var topCate = document.getElementById("topMenu");
        if (topCate.style.display == "none") {
            topCate.style.display = "block";
        } else {
            topCate.style.display = "none";
        }
    }
   	
   	/*function sendRequest() {
    		
    		if (js_basketID == 0) {
    			var xhr = new XMLHttpRequest();
    	        xhr.open("POST", "BasketDownServlet", true);
    	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    	        var data = "";
    	        xhr.send();
    	        xhr.onreadystatechange = function () {
    	            if (xhr.readyState === 4 && xhr.status === 200) {
    	                // 요청이 완료되면 이곳에서 처리
    	                console.log(xhr.responseText); // 서버 응답을 로그에 출력하거나 다른 작업 수행
    	            }
    	        };
    		}
    	

    if (js_basketID > 0) {
        // 서블릿에 요청을 보내는 AJAX 코드
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "ItemServlet", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        // 요청 데이터 설정
        var data = "basketID=" + basketID; // 필요한 데이터를 전송
        xhr.send(data);
        
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // 요청이 완료되면 이곳에서 처리
                console.log(xhr.responseText); // 서버 응답을 로그에 출력하거나 다른 작업 수행
            }
        };
    }
}*/
