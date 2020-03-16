/*$('#submit').click(function() {
	alert("클릭");
	if($('#name').val()==''){
		$('#nameDiv').text("이름을 입력해주세요").css('color','red');
	}else if($('#id').val()==''){
		$('#idDiv').text("아이디를 입력해주세요").css('color','red');
	}else if($('#pwd').val()==''){
		$('#pwdDiv').text("비밀번호를 입력해주세요").css('color','red');
	}else
		$('form[name=writeForm]').submit();
		
});

$('#btn-writeForm').click(function(){
	$('#div-name').empty();
	$('#div-id').empty();
	$('#div-pwd').empty();
	$('#div-pwdcheck').empty();
	
	if($('#name').val() == ''){
		$('#div-name').text('이름을 입력하세요');
		$('#div-name').attr('class', 'color-red');
	}else if($('#id').val() == ''){
		$('#div-id').text('ID를 입력하세요');
		$('#div-id').attr('class', 'color-red');
	}else if($('#id').val()!=vId){
		$('#div-id').text('아이디 중복체크가 필요합니다.');
		$('#div-id').attr('class', 'color-red');
	}else if($('#pwd').val()==''){
		$('#div-pwd').text('비밀번호를 입력하세요');
		$('#div-pwd').attr('class', 'color-red');
		document.getElementById("pwd").focus();
	}else if($('#pwd').val() != $('#pwdcheck').val()){
		$('#div-pwdcheck').text('비밀번호가 일치하지 않습니다!');
		$('#div-pwd').attr('class', 'color-red');
		document.getElementById("pwdcheck").focus();
	}else{
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/write',
			data: $('#writeForm').serialize(),
			dataType: 'text',  받을 데이터 있으면 이거 써줘야하.
			success: function() {
				alert('회원가입을 축하합니다.');
			}
		});
	}
});
*/
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
//$('#id').focusout(function() {
//	$('#idDiv').empty();
//	if($('input[name=id]').val()==''){
//		$('#idDiv').text('필수 정보 입력')
//					.css('font-size', '8pt')
//					.css('color', 'magenta');
//	}
//	else {
//		 //userid 를 param.
//        var userid =  $("#id").val(); 
//        
//        $.ajax({
//            async: true,
//            type : 'POST',
//			url: '/chapter06_SpringWebMaven/user/idCheck',
//			data : 'id='+userid,
//            dataType : "json",
//            contentType: "application/json; charset=UTF-8",
//            success : function(data) {
//                if (data.cnt > 0) {
//                    
//                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
//                    //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
//                    $('#idDiv').text('사용 불가능')
//    				.css('font-size', '8pt')
//    				.css('color', 'magenta');
//                    
//                
//                } else {
//                    alert("사용가능한 아이디입니다.");
//                    //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
//                    $('#idDiv').text(data + '사용 가능')
//    				.css('font-size', '8pt')
//    				.css('color', 'blue');
//                    //아이디가 중복하지 않으면  idck = 1 
//                    idck = 1;
//                    
//                }//else
//            },//success
//	    	error : function() {   // 오류가 발생했을 때 호출된다. 
//	    		console.log(err);
//	    		alert('실패');
//	    	}
//			/* 데이터 넘겨주는 방법
//			1. 'name='+name+'&id='+id+'&pwd'+pwd
//			2. {'name':name, 'id':id, 'pwd':pwd}
//			3. 폼.serialize() */
//		}); //ajax
//	}
//});
//아이디 입력상자에서 커서가 벗어나면
//"먼저 아이디를 입력"
//사용 가능(파랑) / 사용불가능 - 나머지는 보라색
//if(사용가능){
//	$('#idDiv').text('사용 가능')
//	.css('font-size', '8pt')
//	.css('color', 'blue');
//} else {
//	$('#idDiv').text('사용 불가능')
//	.css('font-size', '8pt')
//	.css('color', 'purple');
//}
//var id = $('input[name=id]').val();
//$.ajax({ //ajax연동
//	type: 'post',
//	url: 'chapter06_SpringWebMaven/user/getId',
//	data: $('input[name=id]').serialize(),
//	dataType: String,
//	success: function(data){
//		$('#idDiv').text(data + '사용 가능')
//		.css('font-size', '8pt')
//		.css('color', 'blue');
//	},
//	error : function() {   // 오류가 발생했을 때 호출된다. 
//		$('#idDiv').text('사용 불가능')
//		.css('font-size', '8pt')
//		.css('color', 'purple');
//	}