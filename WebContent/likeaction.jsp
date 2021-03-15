<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="com.dao.*"%>
<%@ page import="com.dto.*"%>
<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String brx = (String) request.getParameter("brx");
		String good = (String) request.getParameter("good");
		String cmd = (String) request.getParameter("cmd");
		out.print(brx);
		tDao dao = new tDao();
		int result = 0;

		if (cmd.equals("free")) {
			result = dao.freelike(brx, good);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='" + request.getContextPath() + "/asdController?cmd=board'");
			script.println("</script>");
			script.close();
			return;

			}
		else if (cmd.equals("humor")) {
			result = dao.humorlike(brx, good);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='" + request.getContextPath() + "/asdController?cmd=board'");
			script.println("</script>");
			script.close();
			return;

			}
		else if (cmd.equals("hot")) {
			result = dao.hotlike(brx, good);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='" + request.getContextPath() + "/asdController?cmd=board'");
			script.println("</script>");
			script.close();
			return;

			}
		
	%>
</body>
</html>