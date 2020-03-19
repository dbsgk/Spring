<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h3>글쓰기</h3>
<body>
<form method="post" name="boardWriteForm" action="boardWrite.do">
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
		<td width="70">제목</td>
		<td><input type="text" id="subject" name="subject" size="50">
			<div id="subjectDiv"></div></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea id="content" name="content" rows="10" cols="60" ></textarea>
			<div id="contentDiv"></div></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="글쓰기" id="boardFormBtn">
		<input type="reset" value="다시작성"></td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>
</html>