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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"
	type="text/javascript"></script>
<script src="js/application.js" type="text/javascript"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">


</head>

<body>
	<%
		String id = (String)session.getAttribute("id");
	%>

	<div id="head">
		<input type="checkbox" name="menu" id="menu"> <label for="menu"> <img src="img/menu1.png" id="mi1">
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


		<a href="<%=request.getContextPath()%>/asdComtroller?cmd=board"> <img src="img/asdnet.png" id="logo"></a>
		
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




	<div id="rtwrap">
		<div id="realtime">

			<dl id="rank-list">
				<dt>실시간 급상승 검색어</dt>
				<dd>
					<ol>
				<%
					Vector<tDto> realhot = (Vector<tDto>) request.getAttribute("realhotre");
					int j=1;
					for (int i=0; i <realhot.size(); i++) {
						
				%>

				<li><a href="<%=request.getContextPath()%>/asdController?cmd=hotpost&brx=<%=realhot.get(i).getBrx()%>">
					<%
						out.print(j + ". ");
						out.print(realhot.get(i).getTitle());
						j++;
					}
					%></a>
				</li>
				<%
					
				%>
					</ol>
				</dd>
			</dl>

			<input type="checkbox" name="real" id="real"> <label
				for="real"></label>
			<ul>
				<%
					int k=1;
					for (int i=0; i <realhot.size(); i++) {
						
				%>

				<li><a href="<%=request.getContextPath()%>/asdController?cmd=hotpost&brx=<%=realhot.get(i).getBrx()%>">
					<%
						out.print(k + ". ");
						out.print(realhot.get(i).getTitle());
						k++;
					}
					%></a>
				</li>
				<%
					
				%>
			</ul>
		</div>
	</div>



	<div id="wrap">
		<div id="a">
			<h1>
				<%
					out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=hot&cat=hot'>HOT 게시판</a>/");
				%>
			</h1>
			<ul>
				<%
					Vector<tDto> hot = (Vector<tDto>) request.getAttribute("hotre");
	
					if(hot.size()<=0){
						%>
						<li>게시글이 없습니다.</li>
						<%
					}else{
					
					for (int i = 0; i <hot.size(); i++) {
				%>

				<li><a href="<%=request.getContextPath()%>/asdController?cmd=hotpost&brx=<%=hot.get(i).getBrx()%>&cat=hot">
					<%
							out.print(hot.get(i).getTitle());
						}
					%>
					</a>
				</li>
				<%
					}
				%>
			</ul>
		</div>
		<div id="b">
			<h1>
				<%
				out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=free&cat=free'>자유 게시판</a>/");
				%>
			</h1>
			<ul>
				<%
					Vector<tDto> free = (Vector<tDto>) request.getAttribute("freere");

					if(free.size()<=0){
						%>
						<li>게시글이 없습니다.</li>
						<%
					}else{
					
					for (int i = 0; i < free.size(); i++) {
				%>

				<li><a href="<%=request.getContextPath()%>/asdController?cmd=freepost&brx=<%=free.get(i).getBrx()%>&cat=free">
						<%
								out.print(free.get(i).getTitle());

							}
						%>

				</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div id="c">
			<h1>
				<%
					out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=humor&cat=humor'>유머 게시판</a>/");
				%>
			</h1>
			<ul>
				<%
					Vector<tDto> humor = (Vector<tDto>) request.getAttribute("humorre");
					if(humor.size()<=0){
						%>
						<li>게시글이 없습니다.</li>
						<%
					}else{
					for (int i = 0; i < humor.size(); i++) {
				%>

				<li><a href="<%=request.getContextPath()%>/asdController?cmd=humorpost&brx=<%=humor.get(i).getBrx()%>&cat=humor">
					<%
							out.print(humor.get(i).getTitle());

						}
					%>
				</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div id="d">
			<h1>
				<%
				out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=unknown&cat=unknowns'>익명 게시판</a>/");
				%>
			</h1>
			<ul>
				<%
					Vector<tDto> unknown = (Vector<tDto>) request.getAttribute("unknownsre");

					if(unknown.size()<=0){
						%>
						<li>게시글이 없습니다.</li>
						<%
					}else{
					for (int i = 0; i < unknown.size(); i++) {
				%>

				<li><a href="<%=request.getContextPath()%>/asdController?cmd=unknownspost&brx=<%=unknown.get(i).getBrx()%>&cat=unknowns">
					<%
							out.print(unknown.get(i).getTitle());

						}
					%>
				</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div id="e">
			<h1>
				<%
				out.print("<a href = '" + request.getContextPath() + "/asdController?cmd=trade&cat=trade'>장터 게시판</a>/");
				%>
			</h1>
			<ul>
				<%
					Vector<tDto> trade = (Vector<tDto>) request.getAttribute("tradere");

					if(trade.size()<=0){
						%>
						<li>게시글이 없습니다.</li>
						<%
					}else{
					for (int i = 0; i < trade.size(); i++) {
				%>

				<li><a href="<%=request.getContextPath()%>/asdController?cmd=tradepost&brx=<%=trade.get(i).getBrx()%>&cat=trade">
					<%
							out.print(trade.get(i).getTitle());

						}
					%>
				</a></li>
				<%
					}
				%>
			</ul>
		</div>


	</div>
</body>

</html>