<%@page import="java.util.Vector"%>
<%@page import="com.dto.tDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/freepost.css">
</head>
<body>
여기는 자유게시판

<%
	tDto dto = (tDto)request.getAttribute("freepostre"); // 한줄씩 모든 정보를 들고 오고싶으면 vector를 사용 한줄에 대한 각 칼럼 별로 정보를 들고오고 싶으면 dto에 담아서 가져온다
	int brx=dto.getBrx();
	int good=dto.getGood();
	
%>
   <div id="head">
		<input type="checkbox" name="menu" id="menu"> <label
			for="menu"> <img src="img/menu1.png" id="mi1">
		</label>

		<div id="sidemenu">
			<ul>
				<li>
					<a href = '/asdWeb/asdController?cmd=hot'>HOT 게시판</a>
				</li>
				<li>
					<a href = '/asdWeb/asdController?cmd=free'>자유 게시판</a>
				</li>
				<li>
					<a href = '/asdWeb/asdController?cmd=humor'>유머 게시판</a>
				</li>
				<li>
					<a href = '/asdWeb/asdController?cmd=unknown'>익명 게시판</a>
				</li>
				<li>
					<a href = '/asdWeb/asdController?cmd=trade'>장터 게시판</a>
				</li>
			</ul>
		</div>


		<a href="<%=request.getContextPath()%>"> <img src="img/asdnet.png">
		</a>
		
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
        <div id="titlebar">
        
            <input type="text" id="writer" name="" value="<%=dto.getWriter()%>"  readonly>
            <input type="text" id="date" name="" value="<%=dto.getDate()%>" readonly>
            <input type="text" id="time" name="" value="<%=dto.getTime()%>" readonly>
            <input type="text" id="good" name="" value="추천수   <%=dto.getGood()%>" readonly>
            <input type="text" id="com" name="" value="댓글수   <%=dto.getComment()%>" readonly>
            
        </div>
    
        <input type="text" id="title" name="" value="<%=dto.getTitle()%>">
        <section>
            <input type="textarea" id="draw" name="" value="<%=dto.getContent() %>" >
        </section>
        <input type = "button" id="upup" value="추천" onclick = "location.href = 'likeaction.jsp?brx=<%=brx%>&good=<%=good+1%>&cmd=free'">
        <input type="button" id="btn_up" name="button"value="수정">
        
                <input type="button" id="btn_up" value="수정" onClick="fix()">
        <input type="button" id="btn_del"value="삭제" onClick="del()">
        <input type="hidden" id="idchk" value="<%=session.getAttribute("id")%>">
        <script type="text/javascript">
    	var idchk = document.getElementById('idchk').value;
    	var writer = document.getElementById('writer').value;
        function del() {        	
         	if(idchk==writer)
         	{
        		location.href = location.href = '<%=request.getContextPath()%>/Controller?cmd=delete&brx=<%=dto.getBrx()%>&category=free';
        	}
        	else
        	{
        		alert("작성자가 아닙니다");
        	}        	
        }      
        
        function fix() 
        {         	
        	if(idchk==writer)
        	{
        		location.href = '<%=request.getContextPath()%>/Controller?brx=<%=dto.getBrx()%>&cmd=selectOne_free';
        	}
        	else
        	{
        		alert("작성자가 아닙니다.");
        	}
		}
        
        </script>
        
        <article id="a">
               
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

					for (int i =0; i <v.size(); i++) {
				%>
				<tr>
					<th><a
						href="<%=request.getContextPath()%>/asdController?cmd=freepost&brx=<%=free.get(i).getBrx()%>">
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
        </div>
        <div class="num">
		<% for(int i=1;i<=totalPage;i++){ %>
		<a href="<%=request.getContextPath()%>/asdController?cmd=free&cat=free&pageNum=<%= i %>">[<%= i %>]</a> 
	<%} %>
        </div>

    
        </article>
	</div>
</body>
</html>