<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table border="1" width="500" cellpadding="3" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<td rowspan="4">
		<img src="http://localhost:8080/miniProject/storage/${imageboardDTO.image1 }" width="100" height="100"></td>
		<td width="200">상품명 : ${imageboardDTO.imageName }</td>
	</tr>
	<tr>
		<td>단가 : ${imageboardDTO.imagePrice }</td>
	</tr>
	<tr>
		<td>개수 : ${imageboardDTO.imageQty }</td>
	</tr>
	<tr>
		<td>합계 : ${imageboardDTO.imagePrice * imageboardDTO.imageQty }</td>
	</tr>
	<tr>
		<td colspan="2" height="200">${imageboardDTO.imageContent }</td>
	</tr>
</table>
		<input type="button" value="목록" onclick="location.href='imageboardList.do?pg=${pg}'">