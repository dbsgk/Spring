<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#topDiv a{ /* topDiv안에 있는 a태그 */
	padding:10px
}
</style>
<h2>
<img src="../image/2.gif" width="70" height="70" align="middle" onclick="location.href='/springProject/main/index.do'" style="cursor: pointer;"> <br>MVC를 이용한 미니 프로젝트
</h2>

<div id="topDiv">
<c:if test="${sessionScope.memId == null}">
	<a href="/springProject/member/writeForm">회원가입</a>
	<a href="/miniProject/member/loginForm">로그인</a>
</c:if>
<c:if test="${sessionScope.memId != null}">
	<a href="/miniProject/board/boardWriteForm">글쓰기</a>
</c:if>

	<a href="/miniProject/board/boardList.do?pg=1">목록</a>
	
<c:if test="${memId!=null && memId=='admin'}">
	<a href="/miniProject/imageboard/imageboardWriteForm.do">이미지등록</a>
</c:if>
	<a href="/miniProject/imageboard/imageboardList.do?pg=1">이미지목록</a><br>
</div>