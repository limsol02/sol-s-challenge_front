<%@page import="frontweb.database.z01_homework.A1120"%>
<%@page import="frontweb.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
 String mnoStr = request.getParameter("mno");
int mno=0;
Member mem = new Member();
if(mnoStr!=null){
	mno=Integer.parseInt(mnoStr);
	A1120 dao = new A1120();
	mem = dao.getMember(mno);
}

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.1.1.js"></script>
<script>
$(document).ready( function(){
	$("h2").text("회원정보 상세<%=mno%>");
	
	 $("#uptBtn").click(function(){
	      if(confirm("수정하시겠습니까?")){
	         $("[name=proc]").val("upt")
	         $("form").attr("action","A1120_MemberProc.jsp");
	         $("form").submit();
	      }
	   })
	   $("#delBtn").click(function(){
	      if(confirm("삭제하시겠습니까?")){
	         $("[name=proc]").val("del")
	         $("form").attr("action","A1120_MemberProc.jsp");
	         $("form").submit();
	      }
	   })
	
})
</script>

<form>
	<table border aling="center">
	<input type="hidden" name="proc">
		<tr><th>회원번호</th><td><input type="number" name="mno" value="<%=mem.getMno()%>"></td></tr>
		<tr><th>회원이름</th><td><input type="text" name="name" value="<%=mem.getName()%>"></td></tr>
		<tr><th>아이디</th><td><input type="text" name="id" value="<%=mem.getId()%>"></td></tr>
		<tr><th>비밀번호</th><td><input type="text" name="pwd" value="<%=mem.getPwd()%>"></td></tr>
		<tr><th>회원권한</th><td><input type="text" name="auth" value="<%=mem.getAuth()%>"></td></tr>
		<tr><th>포인트</th><td><input type="number" name="point" value="<%=mem.getPoint()%>"></td></tr>
	
		<tr><th colspan="2">
		<input type="button" id="uptBtn" value="수정">
		<input type="button" id="delBtn" value="삭제">
		<input type="button" value="메인리스트 이동"
		 onclick="location.href='A1120.jsp'"/>
		</th></tr>
	</table>
</form>
</head>
<body>
    <h2></h2>

</body>
</html>