<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/member.css">

</head>
<body>
<table border="1" cellpadding="5" frame="hsides" rules="rows" valign="top">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td align="center">작성자</td>
		<td align="center">작성일</td>
		<td>조회수</td>
	</tr>
	
<c:if test="${list != null }">
	<c:forEach var="boardDTO" items="${list }">
	<tr>
		<td width="50" align="center">${boardDTO.seq } </td>
		<%-- <td width="300"><a href="#" id="subjectA" onclick="javascript:isLogin(<%=dto.getSeq()%>)"><%=dto.getSubject() %></a></td> --%>
		<%-- <td width="300"><a href="#" id="subjectA" onclick="javascript:isLogin('<%=id%>', <%=dto.getSeq() %>, <%=pg%>)"><%=dto.getSubject() %></a></td> --%>
		<td width="300">
		
		<c:forEach var="i" begin="1" end="${boardDTO.lev }" step="1">
			&emsp;
		</c:forEach>
		<c:if test="${boardDTO.pseq!=0 }">
			<img src="../image/reply.gif">
		</c:if>
		<a href="javascript:isLogin('${memId }', ${boardDTO.seq }, ${pg })" id="subjectA">
		${boardDTO.subject }</a></td>
		
		<td width="100" align="center">${boardDTO.name }</td>
		<td width="100" align="center">${boardDTO.logtime }</td>
		<td width="50" align="center">${boardDTO.hit }</td>
	</tr>
	</c:forEach>
</c:if>
</table>
<%-- <div style="border: 1px solid red; width:100px; float:left">
	<jsp:include page="../main/logo.jsp" />
</div> --%>	
<div style="width:550px; display:inline-block; text-align:center;">${boardPaging.pagingHTML }</div>

</body>
<script>
function isLogin(id, seq, pg){
	if(id=='')
		alert("로그인 하세요");
	else 
		location.href="boardView.do?seq="+seq+"&pg="+pg;

<%-- 	<% if(session.getAttribute("memId")==null){ %>
		alert("로그인 하세요");
	<% }else{ %>
		location.href="boardView.jsp?seq="+seq;
	<% } %>	 --%>	
}
</script>

</html>