<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link href="<%=request.getContextPath()%>/css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="<%=request.getContextPath()%>/controller" name="frm">
		<fieldset>
			<legend>Join</legend>
			<span id="result"></span>
			<table>
				<tr>
					<td>아이디 : </td>
					<td><input type="text" name="id" id="aja"></td>
				<tr>
				<tr>
					<td>비밀번호 : </td>
					<td><input type="password" name="pw"></td>
				<tr>
				<tr>
					<td>이름 : </td>
					<td><input type="text" name="name"></td>
				<tr>
				<tr>
					<td>주소 : </td>
					<td><input type="text" name="address"></td>
				<tr>
				<tr>
					<td>전화번호 : </td>
					<td><input type="text" name="tel"></td>
				<tr>
			</table>
			<input type="hidden" name="cmd" value="insertproc"><br>
			<input type="button" value="가입" onclick="reggo();">
		</fieldset>
	</form>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script type="text/javascript" src="se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

<script>
function reggo() {
  	var str = document.getElementById("result").innerText;
  	if(str=="중복된 아이디입니다"){
  		alert("중복된 아이디입니다.");
  		history.back();
  	}
  	else{
  		alert("가입 성공!");
  		frm.submit();	
  		history.back();
  	}

}


   $(document).ready(function(){
      $("#aja").keyup(function(){
         var params = "id="+$("#aja").val();
         $.ajax({
            type:"POST",
            url:"ajaxproc.jsp",
            data:params,
            dataType:"text",         
            success:function(args){// 실행 성공이라면, 결과는 args에 담김
               $("#result").text(args); 
            },
            error:function(args){
               $("#result").text(args.responseText()+" 에러!");
            }
         });
      });
   });
   

</script>
	
	
	
</body>


</html>