<%@page import="frontweb.database.z01_homework.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "frontweb.vo.Member"   
    %>
<%
MemberDao dao = new MemberDao();
String name = request.getParameter("name");
if(name==null) name = "";
String auth = request.getParameter("auth");
if(auth==null) auth = "";
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=button], input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}
.customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

.customers td, .customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

.customers tr:nth-child(even){background-color: #f2f2f2;}

.customers tr:hover {background-color: #ddd;}


.customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
  
}

.customers .th_form {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: white;
  color: #04AA6D;
  text-align:center;
}


</style>
<script src="/frontweb/com/jquery-3.6.0.js"></script>

<script>
$(document).ready( function(){
	
})
</script>
</head>
<body>
<h2 align="center">회원정보조회</h2>


<form>
<table  class="customers"  width="40%" border align="center">
	<col width="40%">
	<col width="60%">
	<tr><th class="th_form" >회원명</th><td><input type="text" name="name" 
							value="<%=name%>"/></td>
	<tr><th class="th_form" >권한</th><td><input type="text" name="auth" value="<%=auth%>"/></td>
	<tr><th class="th_form"  colspan="2">
			<input type="submit"  value="검색"/>
			<input type="button" value="등록화면" 
				onclick="location.href='a07_memberInsert.jsp'"
			/>
			</th>
</table>
</form>


<table class="customers" width="80%" border  align="center">
	<tr><th>회원번호</th><th>아이디</th><th>회원명</th><th>권한</th>
		<th>포인트</th></tr>
	<%
	for(Member mem:dao.getMemberList(name, auth)){ %>		
	<tr ondblclick="goPage(<%=mem.getMno()%>)">
		<td><%=mem.getMno()%></td>	
		<td><%=mem.getId()%></td>	
		<td><%=mem.getName()%></td>
		<td><%=mem.getAuth()%></td>
		<td><%=mem.getPoint()%></td></tr>
	<%}%>			
</table>
<script type="text/javascript">
	function goPage(mno){
		location.href="a07_memberDetail.jsp?mno="+mno;
	}
	
</script>	
</body>
</html>


