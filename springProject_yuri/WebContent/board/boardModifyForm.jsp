<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>글수정</h3>
<form method="post" name="boardModifyForm" action="boardModify.do?seq=${boardDTO.seq }&pg=${pg}">
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
		<td width="70">제목</td>
		<td><input type="text" name="subject" size="50" value="${boardDTO.subject }"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="content" rows="10" cols="60" >${boardDTO.content }</textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="글수정" onclick="checkBoardModifyForm()">
		<input type="button" value="취소" onclick=""></td>
	</tr>
</table>
</form>

<script type="text/javascript" src="../js/member.js"></script>