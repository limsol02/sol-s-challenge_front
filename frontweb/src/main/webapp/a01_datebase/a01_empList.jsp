<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="frontweb.database.PreparedStmtDao"
	import="frontweb.Emp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	PreparedStmtDao dao = new PreparedStmtDao();
	%>
	<%--  
	<h3 align="center">
		사원명 :
		<%=request.getParameter("ename") == null ? "" : request.getParameter("ename")%></h3>
		<!-- http://localhost:7080/frontweb/a01_datebase/a01_empList.jsp?ename=홍길동&job=사원&deptno=10 -->
	<h3 align="center">
		직책명 :
		<%=request.getParameter("job") == null ? "" : request.getParameter("job")%></h3>
	<h3 align="center">
		부서 :
		<%=request.getParameter("deptno") == null ? "0" : request.getParameter("deptno")%></h3>--%>
	<%
	String ename = request.getParameter("ename");
	if (ename == null) {
		ename = "";
	}
	%>
	<%
	String job = request.getParameter("job");
	if (job == null) {
		job = "";
	}
	%>
	<%
	String deptnoStr = request.getParameter("deptno");
	int deptno = 10; // 10인이유? 초기화면에 10으로 기본 출력하기 위해서
	if (deptnoStr != null) {
		deptno = Integer.parseInt(deptnoStr);
	}
	%>
	<h2 align="center">사원 정보 조회</h2>
	<form>
		<table width="40%" border align="center">
			<col width="40%">
			<col width="60%">
			<tr>
				<th>사원명</th>
				<td><input type="text" name="ename" value="<%=ename%>" /></td>
			</tr>
			<tr>
				<th>직책명</th>
				<td><input type="text" name="job" value="<%=job%>" /></td>
			</tr>
			<tr>
				<th>부서</th>
				<td><input type="text" name="deptno" value="<%=deptno%>" /></td>
			</tr>
			<tr>

				<th colspan="2"><input type="submit" value="검색" /></th>
			</tr>
		</table>
	</form>

	<br>
	<br>
	<br>
	<table border align="center">
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>직책명</th>
			<th>관리번호</th>
			<th>급여</th>
			<th>보너스</th>
			<th>부서번호</th>
		</tr>
		<%
		for (Emp emp : dao.getEmpList(new Emp(ename,job,deptno))) {
		%>
		<tr>
			<th><%=emp.getEmpno()%></th>
			<th><%=emp.getEname()%></th>
			<th><%=emp.getJob()%></th>
			<th><%=emp.getMgr()%></th>
			<th><%=emp.getSal()%></th>
			<th><%=emp.getComm()%></th>
			<th><%=emp.getDeptno()%></th>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>