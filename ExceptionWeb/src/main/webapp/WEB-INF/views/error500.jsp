<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>500</title>
</head>
<body>
	<h3>[500] 죄송합니다. 서버장애입니다. 나중에 다시 시도해주세요.</h3>
	<p>발생한 예외 : ${pageContext.exception }</p>
	<p>예외 메시지 : ${pageContext.exception.message }</p>
	<ol>
        <c:forEach items="${pageContext.exception.stackTrace }" var ="i">
           <li>${i.toString() }</li>
        </c:forEach>
     </ol>

</body>
</html>