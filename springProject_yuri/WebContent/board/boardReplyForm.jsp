<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h3>답글쓰기</h3>
<form method="post" name="boardReplyForm" action="boardReply.do">
<input type="hidden" name="pseq" value="${pseq }">
<input type="hidden" name="pg" value="${pg }">
<table border="1" cellspacing="0" cellpadding="3" >
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
		<input type="button" value="답글쓰기" id="boardFormBtn">
		<input type="reset" value="다시작성"></td>
	</tr>
</table>
</form>

<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>