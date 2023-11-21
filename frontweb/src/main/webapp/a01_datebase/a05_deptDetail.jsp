<%@page import="frontweb.database.PreparedStmtDao"%>
<%@page import="frontweb.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String deptnoStr = request.getParameter("deptno");
int deptno = 0;
Dept dept = new Dept();
if (deptnoStr != null) {
	deptno = Integer.parseInt(deptnoStr);
	PreparedStmtDao dao = new PreparedStmtDao();
	dept = dao.getDept(deptno);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.1.1.js"></script>
<script>
$(document).ready( function(){
	$("h2").text("사원 상세정보<%=deptno%>
	");

		$("#uptBtn").click(function() {
			if (confirm("수정하시겠습니까?")) {
				$("[name=proc]").val("upt")
				$("form").attr("action", "a05_deptProc.jsp");
				$("form").submit();
			}
		})

		$("#delBtn").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				$("[name=proc]").val("del")
				$("form").attr("action", "a05_deptProc.jsp");
				$("form").submit();
			}
		})

	})
</script>
<h2></h2>
<form>
	<input type="hidden" name="proc" />
	<table align="center" width="50%" border>
		<col width="30%">
		<tr>
			<th>부서번호</th>
			<td><input type="number" name="deptno"
				value="<%=dept.getDeptno()%>" /></td>
		</tr>
		<tr>
			<th>부서이름</th>
			<td><input type="text" name="dname" value="<%=dept.getDname()%>" /></td>
		</tr>
		<tr>
			<th>부서위치</th>
			<td><input type="text" name="loc" value="<%=dept.getLoc()%>" /></td>
		</tr>
		<tr>
			<th colspan="2"><input type="button" id="uptBtn" value="수정" />
				<input type="button" id="delBtn" value="삭제" /> <input type="button"
				value="메인리스트 이동" onclick="location.href = 'a05_deptList.jsp'" /></th>
		</tr>
	</table>
</form>
</head>
<body>

</body>
</html>