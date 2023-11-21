<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="frontweb.Dept"%>
<%@page import="frontweb.database.PreparedStmtDao"%>

<%
String proc = request.getParameter("proc");
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

boolean isProc = false;

if (deptnoStr != null) {
	Dept upt = new Dept(deptno, dname, loc);
	PreparedStmtDao dao = new PreparedStmtDao();
	if (proc.equals("upt")) {
		dao.updateDept(upt);
	}
	if (proc.equals("del")) {
		// 삭제 처리
		dao.deleteDept(deptno);
	}
	isProc = true;
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
   $("h2").text("수정처리 : <%=deptno%>");
	})
   var isProc = <%=isProc%>;
   var proc = "<%=proc%>"
   if(isProc){
      if(proc=="upt"){
         if(confirm("수정완료\n상세화면이동은 확인, 전체화면이동은 취소")){
            location.href="a05_deptDetail.jsp?deptno=<%=deptno%>
	";
			} else {
				location.href = "a05_deptList.jsp";
			}
		}
		if (proc == "del") {
			alert("삭제완료\n 전체화면으로 이동")
			location.href = "a05_deptList.jsp";
		}
	}
</script>
</head>
<body>
	<h2></h2>

</body>
</html>