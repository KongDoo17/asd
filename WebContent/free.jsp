<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.dto.tDto"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="css/board.css">


</head>

<body>

	<div id="head">
		<input type="checkbox" name="menu" id="menu"> <label
			for="menu"> <img src="img/menu1.png" id="mi1">

		</label>

		<div id="sidemenu">
			<ul>
				<li>
					<%
						out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=hot&cat=hot'>HOT 게시판</a>");
					%>
				</li>
				<li>
					<%
						out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=free&cat=free'>자유 게시판</a>");
					%>
				</li>
				<li>
					<%
						out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=humor&cat=humor'>유머 게시판</a>");
					%>
				</li>
				<li>
					<%
						out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=unknown&cat=unknown'>익명 게시판</a>");
					%>
				</li>
				<li>
					<%
						out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=trade&cat=trade'>장터 게시판</a>");
					%>
				</li>
			</ul>
		</div>


		<a href="<%=request.getContextPath()%>/asdComtroller?cmd=board"> <img src="img/asdnet.png"></a> 
		
		<%
			if(session.getAttribute("id") == null) {
		%>
			<form action="<%=request.getContextPath() %>/controller">
				아이디 : <input type = "text" size = "10" name = "id">
				비밀번호 : <input type = "password" size = "10" name = "pw">
				<input type="hidden" name="cmd" value="loginProc">
				<input type="submit" value="로그인">
				<input type = "button" value = "회원가입" onclick = "location.href = 'join.jsp'">
			</form>
			
			
			
			
			
		<%
			} else {
		%>
			<form action = "logout.jsp">
				<%=session.getAttribute("id")%>님 환영합니다. <br>
				<input type = "hidden" name = "id" value = "<%=request.getParameter("id")%>">
				<input type = "submit" value = "로그아웃">
			</form>
		<%
			}
		%>

	</div>
	<div id="wrap">
		<div id="board">
			<h2>자유 게시판</h2>
			<table>
				<tr>
					<th>제목</th>
					<th>글쓴이</th>
					<th>댓글</th>
					<th>날짜</th>
				</tr>

				<%
					Vector<tDto> notice = (Vector<tDto>) request.getAttribute("noticere");

					if (notice.size() <= 0) {
				%><tr bgcolor="#F0F0F0">
					<th colspan="4" style="text-align: center">공지사항이 없습니다.</th>
				</tr>
				<%
					} else {

						for (int i = 0; i < notice.size(); i++) {
				%>
				<tr bgcolor="#F0F0F0">
					<th><a
						href="<%=request.getContextPath()%>/asdController?cmd=noticepost&brx=<%=notice.get(i).getBrx()%>">
							<%
								out.print(notice.get(i).getTitle());
							%>
					</a></th>

					<th>
						<%
							out.print(notice.get(i).getWriter());
						%>
					</th>

					<th>
						<%
							out.print(notice.get(i).getComment());
						%>
					</th>

					<th>
						<%
							out.print(notice.get(i).getDate());
						%>
					</th>
				</tr>
				<%
						}	
					}
				%>



				<%
					Vector<tDto> free = (Vector<tDto>) request.getAttribute("freere");
					int totalPage = (int)request.getAttribute("totalPage");
					Vector<tDto> v = (Vector<tDto>)request.getAttribute("data");

					for (int i = 0; i < v.size(); i++) {
				%>
				<tr>
					<th><a
						href="<%=request.getContextPath()%>/asdController?cmd=freepost&brx=<%=free.get(i).getBrx()%>&cat=free">
							<%
								out.print(v.get(i).getTitle());
							%>
					</a></th>

					<th>
						<%
							out.print(v.get(i).getWriter());
						%>
					</th>

					<th>
						<%
							out.print(v.get(i).getComment());
						%>
					</th>

					<th>
						<%
							out.print(v.get(i).getDate());
						%>
					</th>
				</tr>
				<%
					}
				%>
			</table>
			
			<input type="button" value="입력" style = "float : right" onclick="location.href='<%=request.getContextPath()%>/controller?cmd=write&category=free'">
			
			
		</div>
		<div class="num">
			
	
		<% for(int i=1;i<=totalPage;i++){ %>
		<a href="<%=request.getContextPath()%>/asdController?cmd=free&cat=free&pageNum=<%= i %>">[<%= i %>]</a> 
	<%} %>
		</div>

	</div>
	<div id="ad">
		<img src="img/ad.PNG">
	</div>


</body>

</html>
