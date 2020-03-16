<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="0" id="table">
	<tr>
		<th width="100">이름</th>
		<th width="100">아이디</th>
		<th width="100">비밀번호</th>
	</tr>
</table>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType: 'json',
		contentType: 'application/json;charset=UTF-8',
		success: function(data){
			//alert(JSON.stringify(data));
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center', 
					text: items.name
				})).append($('<td/>',{
					align: 'center', 
					text: items.id
				})).append($('<td/>',{
					align: 'center', 
					text: items.pwd
				})).appendTo('#table');
			});
		}
	});
});
</script>
</html>