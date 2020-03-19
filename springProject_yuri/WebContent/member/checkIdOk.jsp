<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- 
<body>
	${param.id }사용 가능
	<input type="button" value="사용하기" onclick="checkIdClose('${param.id}')">
</body> 
--%>
<body>
	${id }사용 가능 <!-- requestScope.id와 같은말 (id는 pageScope가 없으면 자동으로 requestScope.id를 찾음) -->
	<input type="button" value="사용하기" onclick="checkIdClose('${id}')">
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>