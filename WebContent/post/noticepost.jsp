<%@page import="com.dto.tDto"%>
<%@page import="com.dao.tDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	����� ��������
	<%
		tDao dao = new tDao();
		tDto dto = (tDto) request.getAttribute("noticepostre");
		out.print("<br>");
		out.print(dto.getBrx() + "<br>");
		out.print(dto.getTitle() + "<br>");
		out.print(dto.getContent() + "<br>");
		out.print(dto.getWriter() + "<br>");
		out.print(dto.getDate() + "<br>");
		out.print(dto.getTime() + "<br>");
		out.print(dto.getGood() + "<br>");
		out.print(dto.getComment() + "<br>");
		int brx=dto.getBrx();
		int good=dto.getGood();
	%>
	<input type="submit" value="��õ" onclick="test()">
	<a onclick="return confirm('��õ�Ͻðڽ��ϱ�?')" href="./likeaction.jsp?brx=<%=brx%>&good=<%=good+1%>&cmd=free">��õ</a> 
	

</body>
</html>