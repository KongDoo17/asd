<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Logout</title>
<link href="<%=request.getContextPath()%>/css/logout.css" rel="stylesheet" type="text/css">
</head>
<body>


		

		
			
			<%
			session.invalidate();
			
			%>
		<script>location.href = "<%=request.getContextPath()%>"; </script>


		


	
</body>
</html>