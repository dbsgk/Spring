<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 주소창: http://localhost:8080/mvcMember/member/loginForm.do
	 실제 결과창 : /member/loginForm.jsp -->


<form id="loginForm" name="loginForm" method="post" action="/springProject/member/login">
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id" id="loginId">
			<div id="loginIdDiv"></div>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="pwd" id="loginPwd">
			<div id="loginPwdDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<!-- <input type="button" value="로그인" onclick="checkLoginForm()"> -->
			<input type="button" value="로그인" id="loginFormBtn">
			<input type="button" value="회원가입" 
				onclick="javascript:location.href='/springProject/member/writeForm'">                                 
		</td>
	</tr>
</table>
<br><br>
<div id="loginResultDiv"></div>
</form>
<!-- jquery.com에서 js파일 다운받아서 넣어놓음
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script> -->
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>







