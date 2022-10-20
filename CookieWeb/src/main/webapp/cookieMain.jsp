<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키생성 메인페이지</title>
</head>
<body>
	<h2>쿠키(Cookie) 생성 및 설정</h2>
	<%
		Cookie cookie = new Cookie("ezenCookie2", "이젠쿠키맛나2");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(3600);					//쿠키 유지 시간을 1시간으로 설정
		response.addCookie(cookie);
	%>
	<h2>쿠키 설정 후 쿠키 값 확인</h2>
	<%
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies)
		{
			String cookieName = c.getName();
			String cookieValue = c.getValue();
			out.println(String.format("%s : %s<br>", cookieName, cookieValue));
		}
	%>
</body>
</html>