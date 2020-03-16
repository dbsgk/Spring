<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="writeForm" id="writeForm" >
<h2>회원가입</h2>
<table border="1" cellpadding="3" cellspacing="0">
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
		<td><input type="password" name="pwd" id="pwd" size="30">
			<div id="pwdDiv"></div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="회원가입" id="writeBtn" >                                   
		<input type="reset" value="다시작성">
		<input type="button" value="목록" onclick="location.href='http://localhost:8080/chapter06_SpringWebMaven/user/list'">
		
	</tr>
</table>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- <script type="text/javascript" src="../js/user1.js"></script> -->
<script type="text/javascript">
$('#writeBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();

	if($('input[name=name]').val()==''){
		$('#nameDiv').text('이름을 입력하세요')
					.css('font-size', '8pt')
					.css('color', 'red');
	}
	else if($('input[name=id]').val()==''){
		$('#idDiv').text('아이디를 입력하세요')
					.css('font-size', '8pt')
					.css('color', 'red');
	}
	else if($('input[name=pwd]').val()==''){
		$('#pwdDiv').text('비밀번호를 입력하세요')
					.css('font-size', '8pt')
					.css('color', 'red');
	}
	else{
		//document.writeForm.submit();
		$.ajax({ //ajax연동
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/write',
			data: $('#writeForm').serialize(),
			//dataType(리턴값)은 없음, ajax에서 데이터를 가져올거면 추가
			success: function(){
				alert('회원가입 완료');
			}
			/* 데이터 넘겨주는 방법
			1. 'name='+name+'&id='+id+'&pwd'+pwd
			2. {'name':name, 'id':id, 'pwd':pwd}
			3. 폼.serialize() */
		}); 
	}
});
$('input[name=id]').focusout(function(){
	$('input[name=id]').empty();
	
	if($('input[name=id]').val()==''){
		$('#idDiv').text('필수입력 항목입니다').css('color', 'red').css('font-size', '8pt');
	}
	else{
		var id = $('input[name=id]').val();
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/checkId',
			data: 'id='+id,
			dataType: 'text',
			success: function(data){
				if(data=='exist'){
					$('#idDiv').text('사용 불가능').css('color', 'blue').css('font-size', '8pt');
				}else if(data=='non_exist'){
					$('#idDiv').text('사용 가능').css('color', 'blue').css('font-size', '8pt');
				}
			},
			error: function(err){
				console.log(err);
				alert('실패');
			}
		});
	}
});
</script>
</html>
<!-- <script type="text/javascript">
$('#writeBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();

	if($('input[name=name]').val()==''){
		$('#nameDiv').text('이름을 입력하세요')
					.css('font-size', '8pt')
					.css('color', 'red');
	}
	else if($('input[name=id]').val()==''){
		$('#idDiv').text('아이디를 입력하세요')
					.css('font-size', '8pt')
					.css('color', 'red');
	}
	else if($('input[name=pwd]').val()==''){
		$('#pwdDiv').text('비밀번호를 입력하세요')
					.css('font-size', '8pt')
					.css('color', 'red');
	}
	else{
		//document.writeForm.submit();
		$.ajax({ //ajax연동
			type: 'post',
			url: 'chapter06_SpringWebMaven/user/write',
			data: $('#writeForm').serialize(),
			//dataType(리턴값)은 없음, ajax에서 데이터를 가져올거면 추가
			success: function(){
				alert('회원가입 완료');
			}
			/* 데이터 넘겨주는 방법
			1. 'name='+name+'&id='+id+'&pwd'+pwd
			2. {'name':name, 'id':id, 'pwd':pwd}
			3. 폼.serialize() */
		}); 
	}
});
</script> -->