<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter, java.util.ArrayList, java.net.URLEncoder"%>
<%@ page import="user.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<title>주문정보</title>
</head>

<body>

<%
String userID = null;
String userName = null;
  	if(session.getAttribute("userID") != null) {
  		userID = (String) session.getAttribute("userID");
  	}
  	if(session.getAttribute("userName") != null) {
  		userName = (String) session.getAttribute("userName");
  	}
  	%>
	<div id="container">
		<div class="headImg"></div>
		<header>
			<div class="head_Se1">
				<div class="top_logo">
					<button type="button" id="top_LogoBtn"><a href="index.jsp">웅스토어</a></button>
				</div>
				<div class="top_Search">
					<span> <input type="text" placeholder="검색어 입력"
						id="inputTypeText">
						<button type="submit" id="top_SearchBtn">
							<img id="searchIcon" src="css/pngwing.com.png">
						</button>
					</span>
				</div>
				<div id="userJoin">
					<%
					if (userID == null) {
					%>
					<a href="userLogin.jsp">로그인</a> <a href="userRegister.jsp">회원가입</a>
					<%
					} else {
					%>
					<a href="userInfo.html" id="userName">사용자: <%= userName %> 님</a> <a href="userLogout.jsp">로그아웃</a>
					<%
					}
					%>
					<%
					if (userID != null && userID.equals("admin")) {					
					%>
					<a href="itemUp.jsp">상품관리</a>
					<% 
					}
					%>
					 <a href="serviceCenter.jsp">고객센터</a>
				</div>
				</div>
				<nav>
					<div class="nav_Category">
						<button type="button" id="category_Btn" onclick="cate()">
							<img src="css/free-icon-options-lines-82122.png">
							<!-- 메뉴 아이콘  제작자: Freepik - Flaticon-->
							<span>카테고리</span>
						</button>
						<ul id="topMenu">
							<li><a href="store.html">상점가자</a></li>
							<li><a href="itemBasket.html">장바구니</a></li>
							<li><a href="#">카테고리</a></li>
							<li><a href="#">카테고리</a></li>
						</ul>
					</div>
					<div class="nav_BtnGroup">
						<span> <!-- 언제든지 개수와 수 변경 가능 -->
							<button type="button" class="nav_Btn">
								<a href="#">임시 버튼</a>
							</button>
							<button type="button" class="nav_Btn">
								<a href="#">임시 버튼</a>
							</button>
							<button type="button" class="nav_Btn">
								<a href="#">임시 버튼</a>
							</button>
							<button type="button" class="nav_Btn">
								<a href="#">임시 버튼</a>
							</button>
						</span>
					</div>
				</nav>
		</header>
		<main>임시 창</main>
	</div>

	<script src="js/action.js"></script>
</body>

</html>