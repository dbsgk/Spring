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
	<div class="search">
		<select id="searchOption">
			<option>선택</option>
			<option value="name">이름</option>
			<option value="id">아이디</option>
		</select> 
		<input type="text" id="searchText">
		<button id="searchBtn">검색</button>
	</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#searchBtn').click(function(){
		if($('#searchText').val()==''){
			alert('이름 또는 아이디를 입력하세요');
			return false; //밑의 소스 수행하지 말고 빠져나가라, JS에서는 return false;
			//return false;//이거 안적으면 alert뜬다음에 그대로 코드 돌아감.
		}else{
			$('#table tr:gt(0)').remove();
			
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/search',
				data: JSON.stringify({
						'searchOption':$('#searchOption').val(),
						'searchText':$('#searchText').val()	
					}),
					 //'searchOption='+$('#searchOption').val()+'&searchText='+$('#searchText').val(),
					// {'searchOption':$('#searchOption').val(),'searchText':$('#searchText').val()} json표기법으로 데이터보내기(실제 json으로 넘기는게 아니라 표기방식이 그런거)
				dataType: 'json',
				contentType: 'application/json;charset=UTF-8', //이게 있어야지 @RequestBody로 받을 수 있다.
					
				success:function(data){
					alert(JSON.stringify(data));
					
					$.each(data.list, function(index, items){ //확장for문
						$('<tr/>').append($('<td/>',{
							align: 'center',
							text: items.name
						})).append($('<td/>', {
							align: 'center',
							text: items.id
						})).append($('<td/>', {
							align: 'center',
							text: items.pwd
						})).appendTo('#table');
						//$('<td/>',{}) : <td>안에 {}내용을 집어넣겠다
					});
				}
			});
			
		}
	});
	
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