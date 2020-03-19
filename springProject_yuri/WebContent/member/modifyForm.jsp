<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>회원정보 수정</h2>
<form name="modifyForm" method="post" action="modify.do">
<table border="1" cellpadding="3" cellspacing="0">
<tr>
	<td width="90" align="center">이름</td>
	<td><input type="text" name="name" id="name" value="${memberDTO.name }">
		<div id="nameDiv"></div>
	</td>
</tr>
<tr>
	<td align="center">아이디</td>
	<td>
		<input type="text" name="id" id="id" size="25" value="${memberDTO.id }" readonly>
		<input type="hidden" name="check" id="check" value="${memberDTO.id }">
		<div id="idDiv"></div>
	</td>
</tr>
<tr>
	<td align="center">비밀번호</td>
	<td><input type="password" name="pwd" id="pwd" size="30">
		<div id="pwdDiv"></div>
	</td>
</tr>
<tr>
	<td align="center">재확인</td>
	<td><input type="password" name="repwd" id="repwd" size="30">
		<div id="repwdDiv"></div>
	</td>
</tr>
<tr>
	<td align="center">성별</td>
	<td><input type="radio" name="gender" value="0" >남
		<input type="radio" name="gender" value="1">여
	</td>
</tr>
<tr>
	<td align="center">이메일</td>
	<td><input type="text" name="email1" size="15" value="${memberDTO.email1 }"> 
	@ 
	<input type="text" name="email2" list="email2" >
	<datalist id="email2">
	 <option value="gmail.com">
	 <option value="hanmail.net">
	 <option value="naver.com">
	</datalist>
	</td>
</tr>
<tr>
	<td align="center">핸드폰</td>
	<td>
	<select name="tel1" style="width: 60px;">
	<option value="010">010
	<option value="011">011
	<option value="019">019
	</select>
	 - 
	 <input type="text" name="tel2" size="5" value="${memberDTO.tel2 }"> 
	 - 
	 <input type="text" name="tel3" size="5" value="${memberDTO.tel3 }"></td>
</tr>
<tr>
	<td align="center">주소</td>
	<td><input type="text" name="zipcode" id="zipcode" size="6" value="${memberDTO.zipcode }"> 
	<input type="button" value="우편번호검색" onclick="checkPost()">
	<br>
	<input type="text" name="addr1" id="addr1" size="50" placeholder="주소" value="${memberDTO.addr1 }">
	<br>
	<input type="text" name="addr2" id="addr2" size="50" placeholder="상세 주소" value="${memberDTO.addr2 }">
</tr>

<tr>
	<td colspan="2" align="center">
	<!-- <input type="button" value="회원가입" onclick="javascript:checkWriteForm()"> **jquery사용하면 onclick를 쓰면 안됨!!!**-->
	<input id="writeFormBtn" type="button" value="수정">
	<input type="reset" value="다시작성">
</tr>
</table>
</form>    

<script>
window.onload = function(){
	document.modifyForm.gender[${memberDTO.gender}].checked = true;
	document.modifyForm.email2.value = '${memberDTO.email2}';
	document.modifyForm.tel1.value = '${memberDTO.tel1}';
}
</script>

<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
