<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
  <style type="text/css">
  	* { box-sizing: border-box;}
  	a {text-decoration: none;}
  	form
  	{
  		width: 400px;
		height: 500px;
		display: flex;
		flex-direction: column;
		align-items: center;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		border:1px solid rgb(89,117,196);
		border-radius: 10px;
  	}
  	input[type='text'], input[type='password']
  	{
  		width:300px;
  		height: 40px;
  		border: 1px solid rgb(89,117,196);
  		border-radius: 5px;
  		padding: 0 10px;
  		margin-bottom: 10px;
  	}
  	button {
		background-color: rgb(89,117,196);
		color: white;
		width: 300px;
		height: 50px;
		font-size: 17px;
		border: none;
		border-radius: 10px;
		margin: 20px 0 30px 0;
}
	#title
	{
		font-size: 30px;
		margin: 40px 0 30px 0;
	}
	
	#msg
	{
		height: 30px;
		text-align: center;
		font-size: 16px;
		color : red;
		margin-bottom: 20px;
	}
  </style>
<title>로그인</title>
</head>
<body>
	<form action="/ezensat/login/login" method="post" onsubmit="return formCheck(this)">
		<h3 id="title">Login</h3>
		<div id="msg">
			<c:if test="${not empty param.msg }">
			<i class="fa fa-exclamation-circle">${URLDecoder.decode(param.msg) }</i>
			</c:if>
		</div>
		
		<input type="text" name="id" placeholder="이메일 입력" autofocus />
		<input type="password" name="pwd" placeholder="비밀번호" />
		<input type="hidden" name="toURL" value="${param.toURL }" />
		<button>로그인</button>
		
		<div>
			<label><input type="checkbox" name="remeberId" />아이디 기억</label> | 
			<a href="">비밀번호 찾기</a> | 
			<a href="">회원가입</a>
		</div>
	</form>
	
		<script type="text/javascript">
		function formCheck(frm) {
			let msg =''
			
			if(frm.id.value.length == 0) {
				setMessage('id를 입력해주세요.', frm.id)
				return false;
			}
			
			if(frm.pwd.value.length == 0) {
				setMessage('비밀번호를 입력해주세요.', frm.pwd)
				return false;
			}
			
			return true;
		}
		
		function setMessage(msg, element) {
			document.getElementById("msg").innerHTML =`<i class="fa fa-exclamation-circle">${'${msg}'}</i>` ;
			if (element) {															//ë°±ë¨ì´ ë¨¼ì  ì¤íëê¸° ëë¬¸ì
				element.select();		//값을 잘못 입력되었을때 그 요소를 선택되게하는 것임
			}
		}
		
	</script>
</body>
</html>