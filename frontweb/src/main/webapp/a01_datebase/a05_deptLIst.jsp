<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="frontweb.database.PreparedStmtDao"
	import="frontweb.Dept"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">부서정보</h2>
	<%
	// 1. import값 처리 Dao, VO
	// 2. 요청값 처리 부서명과 부서위치 value값 설정
	// 3. dao.getDeptList(new Dept(부서명,부서위치)) foreach구문 처리
	PreparedStmtDao dao = new PreparedStmtDao();

	String deptnoStr = request.getParameter("deptno");
	int deptno = 0;
	if (deptnoStr != null)
		deptno = Integer.parseInt(deptnoStr);

	String dname = request.getParameter("dname");
	if (dname == null) {
		dname = "";
	}

	String loc = request.getParameter("loc");
	if (loc == null) {
		loc = "";
	}
	%>
	<form>
		<table align="center" width="50%" border>
			<col width="30%">
			<tr>
				<th>부서번호</th>
				<td><input type="number" name="deptno" value="<%=deptno%>" /></td>
			</tr>
			<tr>
				<th>부서이름</th>
				<td><input type="text" name="dname" value="<%=dname%>" /></td>
			</tr>
			<tr>
				<th>부서위치</th>
				<td><input type="text" name="loc" value="<%=loc%>" /></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="검색" /> <input
					type="button" value="등록 이동"
					onclick="location.href = 'a05_deptInsert.jsp'" /></th>
			</tr>
		</table>
	</form>
	<table align="center" width="80%" border>
		<col width="33%">
		<col width="34%">
		<col width="33%">
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서위치</th>
		</tr>
		<%
		for (Dept d01 : dao.getDeptList(deptno)) {
		%>
		<tr ondblclick="gopage(<%=d01.getDeptno()%>)">
			<th><%=d01.getDeptno()%></th>
			<th><%=d01.getDname()%></th>
			<th><%=d01.getLoc()%></th>
		</tr>
		<%
		}
		%>
		<%--
		"gopage(<%=d01.getDeptno()%>)" : 숫자형일땐 그냥 <%%>안에 넣어도 상관ㅇ벗는데
		"gopage('<%=d01.getDeptno()%>')" : 문자형일땐 '' 안에 넣어줘야함
		 --%>
	</table>
	<script type="text/javascript">
		function gopage(deptno) {
			location.href = 'a05_deptDetail.jsp?deptno=' + deptno;
		}
	</script>
</body>
</html>