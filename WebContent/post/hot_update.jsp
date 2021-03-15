<%@page import="com.dto.tDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/write.css">

<script type="text/javascript" src="se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	여기는 자유게시판 수정페이지
	<%
	tDto dto = (tDto) request.getAttribute("hot_update");
	%>
	<div id="head">
		<input type="checkbox" name="menu" id="menu"> <label
			for="menu"> <img src="img/menu1.png" id="mi1">
		</label>

		<div id="sidemenu">
			<ul>
				<li><a href='/asdWeb/asdController?cmd=hot'>HOT 게시판</a></li>
				<li><a href='/asdWeb/asdController?cmd=free'>자유 게시판</a></li>
				<li><a href='/asdWeb/asdController?cmd=humor'>유머 게시판</a></li>
				<li><a href='/asdWeb/asdController?cmd=unknown'>익명 게시판</a></li>
				<li><a href='/asdWeb/asdController?cmd=trade'>장터 게시판</a></li>
			</ul>
		</div>


		<a href="board.jsp" target="_self"> <img src="img/asdnet.png">
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

	<div id="container">
	<form action="<%=request.getContextPath()%>/asdController" name="frm">
		<div id="content">
			
				<input type="hidden" id="writer" name="cmd" value="hot_update"> 
				<input type="text" id="title" name="title" value="<%=dto.getTitle()%>">
				<input type="hidden" id="writer" name="writer" value="<%=dto.getWriter()%>">				
				<input type="hidden" id="date" name="date" value="<%=dto.getDate()%>" readonly>
				<input type="hidden" id="time" name="time"value="<%=dto.getTime()%>" readonly> 
				<input type="hidden" id="good" name="good" value="<%=dto.getGood()%>" readonly>
				<input type="hidden" id="com" name="com" value="<%=dto.getComment()%>" readonly>
				<input type = "hidden" name = "brx" value = "<%=dto.getBrx() %>">
				<div class="jsx-2303464893 editor">
					<div class="fr-box fr-basic fr-top" role="application">
						<div class="fr-wrapper show-placeholder" dir="auto"	style="overflow: scroll;">
							<textarea name="content" id="smartEditor" style="width: 100%; height: 412px;"><%=dto.getContent()%></textarea>
						</div>

					</div>
				</div>
				<div class="btns">
					<input type="button" value="cancel" id="cancelbutton">
					<input type="button" id="savebutton" name="cmd" value="save">
					
					 
				</div>
			
		</div>
		</form>
	</div>
	



	<script>
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "smartEditor",
			//저는 textarea의 id와 똑같이 적어줬습니다.
			sSkinURI : "se2/SmartEditor2Skin.html",
			//경로를 꼭 맞춰주세요! fCreator : "createSEditor2",
			htParams : { // 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
				bUseToolbar : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
				bUseVerticalResizer : false, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
				bUseModeChanger : false
			}
		});

		$(function() {
			$("#savebutton")
					.click(
							function() {
								oEditors.getById["smartEditor"].exec(
										"UPDATE_CONTENTS_FIELD", []);

								var selcatd = $("#selcatd > option:selected")
										.val();
								var title = $("#title").val();
								var content = document.getElementById("smartEditor").value;

								if (selcatd == "") {
									alert("카테고리를 선택해주세요.");
									return;
								}

								if (title == null || title == "") {
									alert("제목을 입력해주세요.");
									$("#title").focus();
									return;
								}

								if (content == "" || content == null
										|| content == '&nbsp;'
										|| content == '<br>'
										|| content == '<br/>'
										|| content == '<p>&nbsp;</p>') {
									alert("본문을 작성해주세요.");
									oEditors.getById["smartEditor"]
											.exec("FOCUS");
									return;
								}
								var result = confirm("발행 하시겠습니까?");

								if (result) {
									alert("발행 완료!");
									frm.submit();
								} else {
									return;
								}

							});
			$("#cancelbutton").click(function() {
				var result = confirm("글쓰기를 취소 하시겠습니까?");
				if (!result) {
					return false;
				} else {
					history.back();
				}
			});
		})
	</script>

</body>
</html>