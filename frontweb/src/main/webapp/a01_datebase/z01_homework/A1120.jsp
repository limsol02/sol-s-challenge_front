<%@page import="frontweb.vo.Member"%>
<%@page import="frontweb.database.z01_homework.A1120"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   <%
   A1120 dao = new A1120();
   
   String mnoStr = request.getParameter("mno");
   int mno = 0;
   if(mnoStr!=null){mno = Integer.parseInt(mnoStr);}
   
   String name = request.getParameter("name");
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
   
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.1.1.js"></script>
<script>
$(document).ready( function(){
	$("h2").text("회원정보리스트<%=mno%>");
})
</script>
</head>
<body>
    <h2 align="center"></h2>


<form>
	<table border align="center">
		<tr><th>회원번호</th><td><input type="number" name="mno" value="<%=mno%>"></td></tr>
		<tr><th>회원이름</th><td><input type="text" name="name" value="<%=name%>"></td></tr>
		<tr><th>아이디</th><td><input type="text" name="id" value="<%=id%>"></td></tr>
		<tr><th>비밀번호</th><td><input type="text" name="pwd" value="<%=pwd%>"></td></tr>
		<tr><th>회원권한</th><td><input type="text" name="auth" value="<%=auth%>"></td></tr>
		<tr><th>포인트</th><td><input type="number" name="point" value="<%=point%>"></td></tr>
	
		<tr><th colspan="2">
		<input type="submit" value="검색">
		<input type="button" value="회원등록 이동" onclick="location.href='A1120_MemberInsert.jsp'"/>
		</th></tr>
	</table>
</form>
<br>
	<br>
	<br>
	<table border align="center">
		<tr>
			<th>회원번호</th>
			<th>회원이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>회원권한</th>
			<th>포인트</th>
			
		</tr>
		<%
		for (Member mem: dao.getMemList(mno)){
		%>
		<tr ondblclick = "goPage(<%=mem.getMno()%>)">
			<th><%=mem.getMno()%></th>
			<th><%=mem.getName()%></th>
			<th><%=mem.getId()%></th>
			<th><%=mem.getPwd()%></th>
			<th><%=mem.getAuth()%></th>
			<th><%=mem.getPoint()%></th>
		</tr>
		<%
		}
		%>
	</table>
<script type= "text/javascript">
	function goPage(mno){
			//alert(empno)
			location.href = "A1120_MemberDetail.jsp?mno="+mno;
	}
	</script>
</body>
</html>