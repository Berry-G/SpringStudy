<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="requestVar" value="EzenIt" scope="request" />
	<c:redirect url="/inc/otherPage.jsp">
		<c:param name="user_param1" value="학원"></c:param>
		<c:param name="user_param2" value="별곡"></c:param>
	</c:redirect>
</body>
</html>