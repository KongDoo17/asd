<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dao.write_dao"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String contents = request.getParameter("notice_content");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String writer = (String)session.getAttribute("id");


		write_dao dao = new write_dao();

		if (category.equals("unknowns")) {
			if(writer==null){%>
			<script>
				alert('로그인 해주세요');
				location.href='" + request.getContextPath() + "/asdController?cmd=board';
			</script>
				
			<%
			}else{
				
				int result = dao.insertUnknown(title, contents, category, writer);

				if (result > 0) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href='" + request.getContextPath() + "/asdController?cmd=board'");
					script.println("</script>");
				} else {
		%>
		<script>
			alert('오류발생');
		</script>
		<%
				}

			}
		}
		
		
		else if (category.equals("trade")) {
			
			
			if(writer==null){%>
			<script>
				alert('로그인 해주세요');
				location.href='" + request.getContextPath() + "/asdController?cmd=board';
			</script>
				
			<%
			}else{
				
				int result = dao.insertTrade(title, contents, category, writer);

				if (result > 0) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href='" + request.getContextPath() + "/asdController?cmd=board'");
					script.println("</script>");
				} else {
		%>
		<script>
			alert('오류발생');
		</script>
		<%
				}

			}
		}
		
		else {
			
			if(writer==null){%>
			<script>
				alert('로그인 해주세요');
				location.href='" + request.getContextPath() + "/asdController?cmd=board';
			</script>
				
			<%
			}else{
				
				int result = dao.insertRow(title, contents, category, writer);

				if (result > 0) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href='" + request.getContextPath() + "/asdController?cmd=board'");
					script.println("</script>");
				} else {
		%>
		<script>
			alert('오류발생');
		</script>
		<%
				}

			}
		}
			
	%>



</body>
</html>