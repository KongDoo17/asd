<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.dao.*" %>  


<%
	request.setCharacterEncoding("utf-8");	
%>
<jsp:useBean id="tDto" class="com.dto.tDto"/>
<jsp:setProperty property="*" name="tDto"/>

<%
	users_dao dao = new users_dao();
	String id = request.getParameter("id");
	int result = dao.idChk(id);
	if(result>0){
		out.print("중복된 아이디입니다");
		
	}else{
		out.print("사용가능한 아이디입니다");
	}
	
	


%>
