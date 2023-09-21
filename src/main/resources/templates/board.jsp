<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<form method="post" action="BoardServlet">
		<input type="text" name="boardName" placeholder="게시판 이름">
		<input type="text" name="boardYear" placeholder="게시년도">
		<input type="text" name="boardMonth" placeholder="게시월">
		<input type="text" name="boardDay" placeholder="게시일">
		문의<input type="radio" name="boardDivide" value="문의" placeholder="게시판 구분">
		리뷰<input type="radio" name="boardDivide" value="리뷰" placeholder="게시판 구분">
		<input type="text" name="boardContentuser">
		<input type="submit" value="등록">
	</form>
</body>
</html>