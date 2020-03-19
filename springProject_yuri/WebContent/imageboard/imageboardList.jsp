<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<link rel="stylesheet" href="../css/member.css">

<form name="imageboardListForm" method="post" action="imageboardDelete.do">
<table border="1" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<td width="70"><input type="checkbox" id="all" onclick="checkAll()">번호</td>
		<td width="200">이미지</td>
		<td align="center">상품명</td>
		<td align="center">단가</td>
		<td width="70">개수</td>
		<td width="100">합계</td>
	</tr>
	
<c:if test="${list != null }">
	<c:forEach var="imageboardDTO" items="${list }">
	<tr>
		<td width="50" align="center"><input type="checkbox" name="check" value="${imageboardDTO.seq }"> ${imageboardDTO.seq } </td>
		<%-- <td width="300"><a href="#" id="subjectA" onclick="javascript:isLogin(<%=dto.getSeq()%>)"><%=dto.getSubject() %></a></td> --%>
		<%-- <td width="300"><a href="#" id="subjectA" onclick="javascript:isLogin('<%=id%>', <%=dto.getSeq() %>, <%=pg%>)"><%=dto.getSubject() %></a></td> --%>
		<td width="300">
		<%-- <a href="javascript:isLogin('${memId }', ${imageboardDAO.seq }, ${pg })" id="subjectA"> --%>
		<a href="#" onclick="location.href='imageboardView.do?seq=${imageboardDTO.seq}&pg=${pg}'">
		<img src="http://localhost:8080/miniProject/storage/${imageboardDTO.image1 }" width="100" height="100"></a></td>
		<td width="100" align="center">${imageboardDTO.imageName }</td>
		<td width="100" align="center">
		<fmt:formatNumber pattern="#,###원">${imageboardDTO.imagePrice }</fmt:formatNumber></td>
		<td width="50" align="center"><fmt:formatNumber pattern="#,###">${imageboardDTO.imageQty }</fmt:formatNumber></td>
		<td width="50" align="center"><fmt:formatNumber pattern="#,###원">${imageboardDTO.imagePrice * imageboardDTO.imageQty}</fmt:formatNumber></td>
	</tr>
	</c:forEach>
</c:if>
</table>
</form>
<input type="button" value="선택삭제" onclick="checkDelete()">

<div style="width:550px; display:inline-block; text-align:center;">${imageboardPaging.pagingHTML }</div>
<div></div>

<script>
function checkAll(){
	//alert(document.getElementById("all").checked); --JS
	//$('#all').is(':checked'); --JQuery
	//alert(document.getElementsByName("check").length); //checked된걸 알려달라는게 아니라 check가 몇개인지 알려달라
	
	let check = document.getElementsByName("check");
	if(document.getElementById("all").checked){ // T/F로 넘어옴
		for(i=0; i<check.length; i++){ //JS는 자료형이 없음(int i X)
			check[i].checked = true;
		}
	}else{
		for(i=0; i<check.length; i++){
			check[i].checked = false;
		}
	}
}

function checkDelete(){
	let check = document.getElementsByName("check");
	let count;
	for(i=0; i<check.length; i++){
		if(check[i].checked) count++;
	}
	if(count==0)
		alert("항목을 선택하세요");
	else {
		if(confirm("정말 삭제하겠습니까?"))
			document.imageboardListForm.submit();
		else
			return;
	}
}

function imageboardPaging(pg){
	location.href="imageboardList.do?pg="+pg;
}
</script>