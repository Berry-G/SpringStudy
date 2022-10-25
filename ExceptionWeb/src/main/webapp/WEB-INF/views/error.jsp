<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<h1>에러가 발생했습니다.</h1>
	<p>발생한 예외 : ${pageContext.exception }</p>
	<p>예외 메시지 : ${pageContext.exception.message }</p>
	<ol>
        <c:forEach items="${pageContext.exception.stackTrace }" var ="i">
           <li>${i.toString() }</li>
        </c:forEach>
     </ol>

</body>
</html>