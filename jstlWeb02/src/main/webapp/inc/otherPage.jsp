<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>other Page</title>
</head>
<body>
<ul>
	<!-- 리다이렉트는 request영역 공우 X -->
	<li>저장된 값 : ${requestVar }</li>
	<li>매개변수1 : ${param.user_param1}</li>
	<li>매개변수2 : ${param.user_param2}</li>
	
</ul>

</body>
</html>