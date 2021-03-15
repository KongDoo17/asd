<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="<%=request.getContextPath() %>/controller">
		<fieldset>
			<legend>Login</legend>
			아이디&nbsp&nbsp&nbsp&nbsp: <input type = "text" size = "10" name = "id"> <br>
			비밀번호 : <input type = "password" size = "10" name = "pw"> <br>
			<input type="hidden" name="cmd" value="loginProc">
			<input type="submit" value="로그인">
		</fieldset>
	</form>
	
	<div>
		<input type = "submit" name = "join" value = "회원가입" onclick = "location.href = 'join.jsp'">
	</div>
</body>
</html>