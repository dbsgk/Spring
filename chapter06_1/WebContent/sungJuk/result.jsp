<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h3>*** ${sungJukDTO.name} 성적 ***</h3>
<body>
총점: <%-- ${dto.tot } --%> ${sungJukDTO.tot}
평균: <%-- ${dto.avg } --%> <fmt:formatNumber pattern="#.##">${sungJukDTO.avg}</fmt:formatNumber>
</body>
</html>