<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String rgba = "Red,Green,Blue,Black"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - forTokens 태그 사용</title>
</head>
<body>
<h4>JSTL</h4>
<c:forTokens items = "<%= rgba %>" delims = ", " var="color">
<span style="color : ${color};">${color }</span><br>
</c:forTokens>

</body>
</html>