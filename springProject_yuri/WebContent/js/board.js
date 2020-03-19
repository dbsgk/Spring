$('#boardFormBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val()==''){ 
		$('#subjectDiv').text('제목을 입력하세요')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weight', 'bold');
		
	}else if($('#content').val() == ''){
		$('#contentDiv').text('내용을 입력하세요')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weight', 'bold');
			
	}else
		document.forms[0].submit();
});

$('#imageWriteFormBtn').click(function(){
	$('#imageIdDiv').empty();
	$('#imageNameDiv').empty();
	$('#imageContentDiv').empty();
	$('#image1Div').empty();
	
	if($('#imageId').val() == ''){
		$('#imageIdDiv').text('상품코드를 입력하세요')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weight', 'bold');
	}else if($('#imageName').val() == ''){
		$('#imageNameDiv').text('상품명을 입력하세요')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weight', 'bold');
	}else if($('#imageContent').val() == ''){
		$('#imageContentDiv').text('내용을 입력하세요')
							.css('color', 'red')
							.css('font-size', '8pt')
							.css('font-weight', 'bold');
	}else if($('#image1').val() == ''){
		$('#image1Div').text('이미지파일이 없습니다.')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weight', 'bold');
	}else
		document.forms[0].submit();
});