<%@page import="frontweb.Dept"%>
<%@page import="frontweb.database.PreparedStmtDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.1.1.js"></script>
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

boolean isInsert = false;
if (deptnoStr != null) {
	dao.insertDept(new Dept(deptno, dname, loc));
	isInsert = true;
}
%>
<script>
var isInsert = <%=isInsert%>;
if(isInsert){
	if(!confirm("등록성공! \n 계속 등록하시겠습니까?")){
		location.href = 'a05_deptList.jsp';
	}
}

$(document).ready( function(){
	$("h2").text("부서정보 입력 : (<%=deptno%>)");
	})
</script>
</head>
<body>
	<%--
	submit 버튼을 클릭했을 때, form action 으로 지정된 곳으로 페이지?key=value /
	action이 없으면 현재 페이지에 a05_deptInser.jsp?deptno=10&dname=기획&loc=제주
	식으로 현재페이지에 이동한다.
	이렇게 전송이 되면 아래와 같이 요청값을 받는다.
	 --%>
	<h2></h2>
	<h2 align="center">부서정보</h2>
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
				<th colspan="2"><input type="submit" value="등록" /> <input
					type="button" value="메인 리스트 이동"
					onclick="location.href = 'a05_deptList.jsp'" /></th>
			</tr>
		</table>
	</form>
</body>
</html>