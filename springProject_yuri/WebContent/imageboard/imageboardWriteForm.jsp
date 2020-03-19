<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.label{
	width: 100px;
	text-align: center;
}
</style>
</head>
<body>
<form name="imageboardWriteForm" enctype="multipart/form-data" method="post" action="/miniProject/imageboard/imageboardWrite.do">
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
		<td class="label" >상품코드</td>
		<td><input type="text" value="img_" name="imageId" id="imageId" size="20" >
		<div id="imageIdDiv"></div></td>
	</tr>
	<tr>
		<td class="label">상품명</td>
		<td><input type="text" name="imageName" id="imageName" size="20" placeholder="상품명 입력">
		<div id="imageNameDiv"></div></td>
	</tr>
	<tr>
		<td class="label">단가</td>
		<td><input type="text" name="imagePrice" id="imagePrice" value="0" size="20" placeholder="단가 입력"></td>
	</tr>
	<tr>
		<td class="label">갯수</td>
		<td><input type="text" name="imageQty" id="imageQty" value="0" size="20" placeholder="갯수 입력"></td>
	</tr>
	<tr>
		<td class="label">내용</td>
		<td><textarea name="imageContent" id="imageContent" rows="20" cols="60" placeholder="내용 입력"></textarea>
		<div id="imageContentDiv"></div></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="file" name="image1" id="image1" size="50">
		<div id="image1Div"></div>
	</tr>
	<tr>
		<td colspan="2" class="label">
		<input type="button" value="이미지 등록" id="imageWriteFormBtn">
		<input type="reset" value="다시 작성"></td>
	</tr>
</table>
</form> 

<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>