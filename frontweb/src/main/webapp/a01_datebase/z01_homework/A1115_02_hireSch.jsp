<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="frontweb.database.z01_homework.A1115"
	import="frontweb.vo.EmpHire"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.1.1.js"></script>
</head>
<body>
<%
String job = request.getParameter("job");
if(job==null){job="";}

String hire_qua = request.getParameter("hire_qua");
if(hire_qua==null){hire_qua="1";}
A1115 dao = new A1115();
%>

<script type="text/javascript">
	$(document).ready(function(){
		$("[name=hire_qua]").val("<%=hire_qua%>");
		$("[name=job]").val("<%=job%>");
		$("[name=hire_qua]").change(function(){
			$("form").submit();
		})
		})
		
	</script>

	<h2 align="center">사원정보 조회</h2>
	<form>
	<table align="center" width="40%" border>
		<tr>
			<th>직책명</th>
			<td><input type="text" name="job" value="<%=job %>" /></td>
		</tr>
		<tr>
			<th>입사분기</th>
			<td><select name = "hire_qua" value="<%=hire_qua %>">
				<option value="1" >1/4분기</option>
				<option value="2">2/4분기</option>
				<option value="3">3/4분기</option>
				<option value="4">4/4분기</option>
			</select></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="조회"/></th>
		</tr>
	</table>
	</form>

	
	<br><br><br><br>
	<table align="center" width="80%" border>
		<col width="25%"><col width="25%"><col width="25%"><col width="25%">
		<tr>
			<th>사원번호</th>
			<th>직책명</th>
			<th>입사분기</th>
			<th>입사일</th>
		</tr>
	<%
	for(EmpHire emp : dao.getEmpHireInfo(job, hire_qua)){
	%>
		<tr>
			<td><%=emp.getEmpno() %></td>
			<td><%=emp.getJob() %></td>
			<td><%=emp.getHire_qua() %>/4</td>
			<td><%=emp.getHire_str() %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>