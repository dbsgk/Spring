<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="result.do">  
<table border="1">
	<tr>
		<td width="50" align="center">이름</td>
		<td>
		<input type="text" size="10" name="name">
		</td>
	</tr>
	<tr>
		<td align="center">국어</td>
		<td>
		<input type="text" size="10" name="kor">
		</td>
	</tr>
	<tr>
		<td width="50" align="center">영어</td>
		<td>
		<input type="text" size="10" name="eng">
		</td>
	</tr>
	<tr>
		<td width="50" align="center">수학</td>
		<td>
		<input type="text" size="10" name="math">
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="계산" >
		<input type="reset" value="취소">
		</td>
		
	</tr>
</table>
</form>
</body>

</html>