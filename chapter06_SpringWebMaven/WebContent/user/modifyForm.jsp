<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정할 아이디 입력 : <input type="text" name="searchId" id="searchId">
<input type="button" id="searchBtn" value="검색">
<br><br>
<div id="resultDiv"></div>

<div id="modifyFormDiv">
<form id="modifyForm" method="post">
<table border="1" cellpadding="3" cellspacing="0">
<tr>
	<td width="90" align="center">이름</td>
	<td>
		<input type="text" name="name" id="name">
		<div id="nameDiv"></div>
	</td>
</tr>
<tr>
	<td align="center">아이디</td>
	<td>
		<input type="text" name="id" id="id" size="25" readonly>
	</td>
</tr>
<tr>
	<td align="center">비밀번호</td>
	<td>
		<input type="password" name="pwd" id="pwd" size="30">
		<div id="pwdDiv"></div>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="button" id="modifyBtn" value="수정">                     
	<input type="reset" id="resetBtn" value="다시작성">
</tr>
</table>
</form>
</div>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#modifyFormDiv').hide();
	
	$('#searchBtn').click(function(event){
		$('#resultDiv').empty();
		
		if($('#searchId').val()==''){
			$('#resultDiv').text('먼저 아이디 입력하세요')
			$('#resultDiv').css('color','red')
			$('#resultDiv').css('font-size','10pt')
			$('#resultDiv').css('font-weight','bold')
		}else{
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/getUser',
				data: 'id='+$('#searchId').val(),
				dataType: 'json',
				success: function(data){
					if($.isEmptyObject(data)){
						$('#resultDiv').text('수정할 아이디가 없습니다');
						$('#resultDiv').css('color','red')
						$('#resultDiv').css('font-size','10pt')
						$('#resultDiv').css('font-weight','bold')
					}else{
						$('#modifyFormDiv').show();
						
						$('#name').val(data.name);
						$('#id').val(data.id);
					}
						
				},
				error: function(err){
					alert(err);
					console.log(err);
				}
			});
		}
	});
	
	$('#resetBtn').click(function(){
		$('#searchBtn').trigger('click');
	});
	
	$('#modifyBtn').click(function(){
		$('#nameDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val()==''){
			$('#nameDiv').text('이름 입력')
			$('#nameDiv').css('color','red')
			$('#nameDiv').css('font-size','8pt')
			$('#nameDiv').css('font-weight','bold')
		
		}else if($('#pwd').val()==''){
			$('#pwdDiv').text('비밀번호 입력')
			$('#pwdDiv').css('color','red')
			$('#pwdDiv').css('font-size','8pt')
			$('#pwdDiv').css('font-weight','bold')
		
		}else{
			//$('#modifyForm').submit();
			
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/modify',
				data: $('#modifyForm').serialize(),
				success: function(){
					alert("회원정보를 수정하였습니다");
				}
			});
		}
	});
});
</script>
<!-- <html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정할 아이디 입력: <input type="text" id="searchId">
<input type="button" value="검색" id="searchBtn">
<div id="resultDiv"></div>
<br>
<div id="tableDiv" style="display:none;">
<form id="modifyForm">
<table border="1" cellpadding="3" cellspacing="0" id="table">
	<tr>
		<td width="90" align="center">이름</td>
		<td><input type="text" name="name" placeholder="이름 입력" id="name">
			<div id="nameDiv"></div>
		</td>
	</tr>
	<tr>
		<td align="center">아이디</td>
		<td>
			<input type="text" name="id" size="25" placeholder="아이디 입력" id="id">
			<div id="idDiv"></div>
		</td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="text" name="pwd" id="pwd" size="30">
			<div id="pwdDiv"></div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="수정" id="modifyBtn" >                                   
		<input type="reset" value="다시작성">
	</tr>
</table>
</form>
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#modifyFormDiv').hide();
	
	$('#searchBtn').click(function(event){ //클릭이벤트가 발생할때 trigger가 발생

		var id = $('#searchId').val();
		
		if(id==''){
			$('#resultDiv').text('아이디를 입력하세요').css('color', 'blue').css('font-size', '8pt');
		}else{
			$.ajax({
				type: 'post',
				url:'/chapter06_SpringWebMaven/user/getUser',
				data: 'id='+id,
				dataType: 'json', //객체(userDTO)는 가져올 수 없으니 json으로 가져와야함!!!
				success: function(data){
					alert(data.name);
					if($.isEmptyObject(data))
						$('#searchIdDiv').text('해당 아이디가 없습니다').css('color', 'red').css('font-size', '9pt');
					else{
						//$('#resultDiv').css('display', 'block');
						$('#resultDiv').show();
						$('#name').val(data.name);
						$('#id').val(data.id);
						
					}
				},
				error: function(error){
					alert("error:"+error);
				}
			});
		}
	});
	$('#resetBtn').click(function(){
		$('#searchBtn').trigger('click'); //
	});
});
$('#modifyBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val==''){
		$('#nameDiv').text("이름을 입력해주세요").css("color", "red").css('font-size', '9pt');
	}else if($('#pwd').val==''){
		$('#pwdDiv').text("비밀번호를 입력해주세요").css("color", "red").css('font-size', '9pt');
	}else{
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/modify',
			data: $('#modifyForm').serialize(),
			success: function(){
				alert('수정완료');
			}
		});
	}
});

</script>
</html> -->
<!--  $(document).ready(function(){
	$('#searchBtn').click(function(){
		$('#resultDiv').empty();
		
		if($('#searchId').val()==''){
			$('#resultDiv').text('필수입력 항목입니다').css('color', 'red').css('font-size', '8pt');
		}
		else{
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/getUser',
				data: 'id='+$('#searchId').val(),
				dataType: 'json',
				success: function(data){
					alert(JSON.stringify(data));
					if(data=='exist'){
						$('#resultDiv').empty();
						$.ajax({
							type: 'post',
							url: '/chapter06_SpringWebMaven/user/checkId',
						 	data: $('#seachId').val(),
							dataType: 'json',
							success: function(dto){
								$('#name').val(dto.name);
								$('#id').val(dto.id);
								$('#pwd').val(dto.pwd);
								$('#table').show();
							}
						
					}else if(data=='non_exist'){
						$('#resultDiv').text('수정할 아이디가 없습니다.').css('color', 'blue').css('font-size', '8pt');
					}
				},
				error: function(err){
					console.log(err);
					alert('실패');
				}
			});
		}
		
	});
});  -->