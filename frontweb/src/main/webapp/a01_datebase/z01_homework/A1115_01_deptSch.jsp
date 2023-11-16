<%@page import="frontweb.database.z01_homework.A1115"%>
<%@page import="frontweb.Emp" import = "java.util.List"%>
<%@page import="frontweb.database.PreparedStmtDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.1.1.js"></script>
</head>
<body>

	<%
	String deptnoStr = request.getParameter("deptno");
	int deptno = 10;
	if (deptnoStr != null) {
		deptno = Integer.parseInt(deptnoStr);
	}
	
	A1115 dao = new A1115();
	List<Emp> empList = dao.getEmpListByDeptno(deptno);	
	%>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("[name=deptno]").val("<%=deptno%>");
		// 부서번호 select를 변경할 때 이벤트..
		$("[name=deptno]").change(function(){
			// form에 있는 내용을 전송 처리, submit버튼을 클릭한 것과 동일하게 취급
			$("form").submit();
		})
		})
		
	</script>
	<h2>
		부서번호 확인 :
		<%=deptno%></h2>
	
	<%
	
	%>
	
	<form>
		부서번호 : <select name="deptno">
			<option>10</option>
			<option>20</option>
			<option>30</option>
			<option>40</option>
		</select> <input type="submit" value="조회">
	</form>
	<table border>
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>급여</th>
			<th>부서번호</th>
		</tr>
		<%for(Emp emp : empList){ %>
		<tr>
			<td><%=emp.getEmpno() %></td>
			<td><%=emp.getEname() %></td>
			<td><%=emp.getSal() %></td>
			<td><%=emp.getDeptno() %></td>
		</tr>
		<%} %>
	</table>





</body>
</html>