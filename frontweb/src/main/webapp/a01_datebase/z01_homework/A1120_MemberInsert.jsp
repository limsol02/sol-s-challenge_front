<%@page import="frontweb.vo.Member"%>
<%@page import="frontweb.database.z01_homework.A1120"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
   A1120 dao = new A1120();
   
   String mnoStr = request.getParameter("mno");
   int mno = 0;
   if(mnoStr!=null){mno = Integer.parseInt(mnoStr);}
   
   String name = request.getParameter("idname");
   if(name==null) name="";
  
   String id = request.getParameter("id");
   if(id==null) id="";
   
   String pwd = request.getParameter("pwd");
   if(pwd==null) pwd="";
   
   String auth = request.getParameter("auth");
   if(auth==null) auth="";
  
   String pointStr = request.getParameter("point");
   int point=0;
   if(pointStr!=null) {point = Integer.parseInt(pointStr);}
   
   boolean isInsert = false;
   if(mnoStr!=null){
	   dao.insertMember(new Member(mno,name,id,pwd,auth,point));
	   isInsert  =true;
	   }
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.1.1.js"></script>
<script>
var isInsert = <%=isInsert%>;
if(isInsert){
	if(!confirm("등록성공! \n 계속 등록???")){
		location.href = 'A1120.jsp';
	}
}

$(document).ready( function(){
	$("h2").text("회원정보수정<%=mno%>");
})
</script>
</head>
<body>
    <h2></h2>
<form>
	<table border aling="center">
		<tr><th>회원번호</th><td><input type="number" name="mno" value="<%=mno%>"></td></tr>
		<tr><th>회원이름</th><td><input type="text" name="name" value="<%=name%>"></td></tr>
		<tr><th>아이디</th><td><input type="text" name="id" value="<%=id%>"></td></tr>
		<tr><th>비밀번호</th><td><input type="text" name="pwd" value="<%=pwd%>"></td></tr>
		<tr><th>회원권한</th><td><input type="text" name="auth" value="<%=auth%>"></td></tr>
		<tr><th>포인트</th><td><input type="number" name="point" value="<%=point%>"></td></tr>
	
		<tr><th colspan="2">
		<input type="submit" value="등록">
		<input type="button" value="메인리스트" onclick="location.href='A1120.jsp'"/>
		</th></tr>
	</table>
</form>
</body>
</html>