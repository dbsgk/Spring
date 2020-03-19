<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style type="text/css">
.contents{
	white-space: pre-wrap;
	word-break: break-all;
	width: 500px;
}
</style>

<table border="1" frame="hsides" rules="rows">
	<tr>
		<td colspan="3">${boardDTO.subject }</td>
	</tr>
	<tr>
		<td width="200">글번호:${boardDTO.seq }</td>
		<td width="200">작성자:${boardDTO.name }</td>
		<td width="200">조회수:${boardDTO.hit }</td>
	</tr>
	<tr>
		<td  colspan="3" height="200" valign="top">
		<pre class="contents">${boardDTO.content }</pre></td>
	</tr>
	<tr>
		<td colspan="3" align="center">
		<input type="button" value="목록" onclick="location.href='boardList.do?pg=${pg}'">
		<input type="button" value="답글" onclick="location.href='boardReplyForm.do?pseq=${boardDTO.seq}&pg=${pg }'">
		<c:if test="${boardDTO.id == memId}">
			<input type="button" value="수정" onclick="location.href='boardModifyForm.do?seq=${boardDTO.seq }&pg=${pg }'">
			<input type="button" value="삭제" onclick="location.href='boardDelete.do?seq=${boardDTO.seq}&pg=${pg }'">
		</c:if>
		</td>
	</tr>
</table>

