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
����� �����Խ���

<%
	tDto dto = (tDto)request.getAttribute("freepostre"); // ���پ� ��� ������ ��� ��������� vector�� ��� ���ٿ� ���� �� Į�� ���� ������ ������ ������ dto�� ��Ƽ� �����´�
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
					<a href = '/asdWeb/asdController?cmd=hot'>HOT �Խ���</a>
				</li>
				<li>
					<a href = '/asdWeb/asdController?cmd=free'>���� �Խ���</a>
				</li>
				<li>
					<a href = '/asdWeb/asdController?cmd=humor'>���� �Խ���</a>
				</li>
				<li>
					<a href = '/asdWeb/asdController?cmd=unknown'>�͸� �Խ���</a>
				</li>
				<li>
					<a href = '/asdWeb/asdController?cmd=trade'>���� �Խ���</a>
				</li>
			</ul>
		</div>


		<a href="<%=request.getContextPath()%>"> <img src="img/asdnet.png">
		</a>
		
				<%
			if(session.getAttribute("id") == null) {
		%>
			<form action="<%=request.getContextPath() %>/controller">
				���̵� : <input type = "text" size = "10" name = "id">
				��й�ȣ : <input type = "password" size = "10" name = "pw">
				<input type="hidden" name="cmd" value="loginProc">
				<input type="submit" value="�α���">
				<input type = "button" value = "ȸ������" onclick = "location.href = 'join.jsp'">
			</form>
			
			
			
			
			
		<%
			} else {
		%>
			<form action = "logout.jsp">
				<%=session.getAttribute("id")%>�� ȯ���մϴ�. <br>
				<input type = "hidden" name = "id" value = "<%=request.getParameter("id")%>">
				<input type = "submit" value = "�α׾ƿ�">
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
            <input type="text" id="good" name="" value="��õ��   <%=dto.getGood()%>" readonly>
            <input type="text" id="com" name="" value="��ۼ�   <%=dto.getComment()%>" readonly>
            
        </div>
    
        <input type="text" id="title" name="" value="<%=dto.getTitle()%>">
        <section>
            <input type="textarea" id="draw" name="" value="<%=dto.getContent() %>" >
        </section>
        <input type = "button" id="upup" value="��õ" onclick = "location.href = 'likeaction.jsp?brx=<%=brx%>&good=<%=good+1%>&cmd=free'">
        <input type="button" id="btn_up" name="button"value="����">
        
                <input type="button" id="btn_up" value="����" onClick="fix()">
        <input type="button" id="btn_del"value="����" onClick="del()">
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
        		alert("�ۼ��ڰ� �ƴմϴ�");
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
        		alert("�ۼ��ڰ� �ƴմϴ�.");
        	}
		}
        
        </script>
        
        <article id="a">
               
        <div id="board">
            <h2>���� �Խ���</h2>
            <table>
				<tr>
					<th>����</th>
					<th>�۾���</th>
					<th>���</th>
					<th>��¥</th>
				</tr>

				<%
					Vector<tDto> notice = (Vector<tDto>) request.getAttribute("noticere");

					if (notice.size() <= 0) {
				%><tr bgcolor="#F0F0F0">
					<th colspan="4" style="text-align: center">���������� �����ϴ�.</th>
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