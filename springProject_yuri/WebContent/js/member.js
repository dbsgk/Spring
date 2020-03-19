/*function checkWriteForm(){
	//유효성 체크
	if(document.writeForm.name.value=="")
		alert("이름을 입력하세요");
	else if(document.writeForm.id.value=="")
		alert("아이디를 입력하세요");
	//else if(document.writeForm.pwd.value=="")
	else if(document.getElementById("pwd").value=="")	
		alert("비밀번호를 입력하세요");
	else if(document.writeForm.pwd.value != document.writeForm.repwd.value)
		alert("비밀번호가 맞지 않습니다");
	else if(document.writeForm.id.value != document.writeForm.check.value)
		alert("중복체크 하세요");
	else
		document.writeForm.submit();
}*/

//jquery $('');
$('#writeFormBtn').click(function(){  
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	$('#repwdDiv').empty();
	
	if($('#name').val()==''){ //#id 속성 이용
	//if($('input[id=name]').val()==''){ //input속성에서 id값이 name인것(윗방법 #이랑 동일)
	//if($('input[name=name]').val()==''){ //input속성에서 name값이 name인것
		$('#nameDiv').text('이름을 입력하세요'); 
		$('#nameDiv').css('color', 'red')
		$('#nameDiv').css('font-size', '8pt')
		$('#nameDiv').css('font-weight', 'bold')
	}else if($('#id').val()==''){
		$('#idDiv').text('아이디를 입력하세요');
		$('#idDiv').css('color', 'red')
		$('#idDiv').css('font-size', '8pt')
		$('#idDiv').css('font-weight', 'bold')
	}else if($('#pwd').val()==''){
		$('#pwdDiv').text('비밀번호를 입력하세요');
		$('#pwdDiv').css('color', 'red')
		$('#pwdDiv').css('font-size', '8pt')
		$('#pwdDiv').css('font-weight', 'bold')
	}else if($('#pwd').val()!= $('#repwd').val()){
		$('#repwdDiv').text('비밀번호가 맞지 않습니다');
		$('#repwdDiv').css('color', 'red')
		$('#repwdDiv').css('font-size', '8pt')
		$('#repwdDiv').css('font-weight', 'bold')
	}else if($('#id').val() != $('#check').val()){
		$('#idDiv').text('중복체크 하세요');
		$('#idDiv').css('color', 'red')
		$('#idDiv').css('font-size', '8pt')
		$('#idDiv').css('font-weight', 'bold')
	}else
		//$('form[name=writeForm]').submit(); //name속성 이용
		document.forms[0].submit();
}); 

$('#id').focusout(function(){
	if($('#id').val()==''){ 
		$('#idDiv').text('필수정보입니다.')
					.css('color', 'red')
					.css('font-size', '8pt')
					.css('font-weight', 'bold');
	}else{
		$.ajax({
			type: 'post',
			url: '/springProject/member/checkId',
			data: 'id='+$('#id').val(),
			dataType: 'text',
			success: function(data){
				//alert(data);
				if(data=='exist'){
					$('#idDiv').text('사용 불가능').css('color', 'magenta').css('font-size', '8pt');
				}else if(data=='non_exist'){
					$('#check').val($('#id').val());
					$('#idDiv').text('사용 가능').css('color', 'blue').css('font-size', '8pt');
				}
			}
		});
	}
});

function checkIdClose(id){
	opener.writeForm.id.value = id;
	opener.writeForm.check.value = id;
	window.close();
	opener.writeForm.pwd.focus();	
}

/*function checkLoginForm(){
	if(document.loginForm.id.value=="")
		alert("아이디를 입력하세요");
	else if(document.loginForm.pwd.value=="")	
		alert("비밀번호를 입력하세요");
	else
		document.loginForm.submit();
}*/

$('#loginFormBtn').click(function(){
	$('#loginIdDiv').empty();
	$('#loginPwdDiv').empty();
	
	if($('#loginId').val()==''){
		$('#loginIdDiv').text('아이디를 입력하세요')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weight', 'bold');
	}else if($('#loginPwd').val()==''){
		$('#loginPwdDiv').text('비밀번호를 입력하세요')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weight', 'bold');
	}else{
		//$('form[name=loginForm]').submit();
		
		$.ajax({
			type : 'post',
			url : '/springProject/member/login',
			data : {'id' : $('#loginId').val(), 'pwd' : $('#loginPwd').val()},
			dataType : 'text',
			success : function(data){
				if(data == 'success'){
					location.href = '/springProject/main/index';
				}else if(data == 'fail'){
					$('#loginResultDiv').text('로그인 실패')
					                    .css('color', 'red')
					                    .css('font-size','13pt')
					                    .css('font-weight','bold');
				}
			},
			error : function(e){
				console.log(e);
			}
		});
	}
});

$('#checkPostBtn').click(function(){
	window.open('/springProject/member/checkPost','', 'width=600 height=400 scrollbars=yes');
});

$('#postSearchBtn').click(function(){
	$('#sidoDiv').empty();
	$('#sigunguDiv').empty();
	$('#roadnameDiv').empty();
	
	if($('#sido').val()==''){
		$('#sidoDiv').text('시도 선택')
					.css('color', 'red')
					.css('font-size', '8pt')
					.css('font-weight', 'bold');
	}else if($('#sido').val()!='세종' && $('#sigungu').val()=='') {//세종은 시군구가 없음
		$('#sigunguDiv').text('시군구 선택')
					.css('color', 'red')
					.css('font-size', '8pt')
					.css('font-weight', 'bold');
	}else if($('#roadname').val()==''){
		$('#roadnameDiv').text('도로명 선택')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weight', 'bold');
	}else{
		$.ajax({
			type:'post',
			url:'/springProject/member/postSearch',
			data: $('#checkPostForm').serialize(), //checkPostForm내용을 한번에 보냄
			dataType: "json",
			success: function(data){
				alert(JSON.stringify(data));
				$('#postTable tr:gt(2)').remove();
				$.each(data.list, function(index, items){
					let address = items.sido+' '+items.sigungu+' '+items.yubmyundong+' '+items.ri+' '+items.roadname+' '+items.buildingname;
					
					address = address.replace(/null/g, '');
					
					$('<tr/>').append($('<td/>', {
						align : 'center',
						text : items.zipcode
					})).append($('<td/>', {
						colspan : '3',
						}).append($('<a/>', {
							href: '#',
							class: 'addressA', //css용 class
							text : address
						}))
					).appendTo($('#postTable'));
				});//each
				
				$('a').click(function(){
					
					$('#zipcode', opener.document).val($(this).parent().prev().text());
					$('#addr1', opener.document).val($(this).text());
					$('#addr2', opener.document).focus();
					window.close();
					
					//우편번호, 주소 전달
					//alert($(this).parent().prev().text());
					
				});
			}
			
		});
	}
});

function sendAddr(zipcode, sido, sigungu, yubmyundong, ri, buildingname){
	opener.writeForm.zipcode.value = zipcode;
	opener.writeForm.addr1.value = sido+" "+sigungu+" "+yubmyundong+" "+ri+" "+buildingname;
	window.close();
	opener.writeForm.addr2.focus();
}

function checkPostClose(zipcode, address){
	/* opener.document.forms[0].zipcode.value = zipcode;
	opener.document.forms[1].addr1.value = address;
	window.close();
	opener.writeForm.addr2.focus(); */
	
	opener.document.getElementById('zipcode').value = zipcode;
	opener.document.getElementById('addr1').value = address;
	window.close();
	opener.writeForm.addr2.focus();
}

function checkModifyForm(){
	if(document.modifyForm.name.value=="") 
		alert("이름 입력하세요");
	else if(document.modifyForm.id.value=="") 
		alert("아이디 입력하세요");
	else if(document.modifyForm.pwd.value=="") 
		alert("비밀번호 입력하세요");
	else if(document.modifyForm.pwd.value != document.modifyForm.repwd.value) 
		alert("비밀번호가 일치하지 않습니다");
	else
		document.modifyForm.submit();
}

//function checkBoardWriteForm(){
//	if(document.boardWriteForm.subject.value=="") 
//		alert("제목을 입력하세요");
//	else if(document.boardWriteForm.content.value=="")
//		alert("내용을 입력하세요");
//	else
//		document.boardWriteForm.submit();
//}

function checkBoardModifyForm(){
	if(document.boardModifyForm.subject.value=="") 
		alert("제목을 입력하세요");
	else if(document.boardModifyForm.content.value=="")
		alert("내용을 입력하세요");
	else
		document.boardModifyForm.submit();
}


