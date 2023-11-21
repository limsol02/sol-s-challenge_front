<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="frontweb.database.PreparedStmtDao"
	import="frontweb.vo.EmpDTO"%>
<%
String proc = request.getParameter("proc");
String empnoStr = request.getParameter("empno");
String ename = request.getParameter("ename");
String job = request.getParameter("job");
String mgrStr = request.getParameter("mgr");
String hiredatestr = request.getParameter("hiredatestr");
String salStr = request.getParameter("sal");
String commStr = request.getParameter("comm");
String deptnoStr = request.getParameter("deptno");
// 숫자형 데이터 초기화
int empno, mgr, deptno;
double sal, comm;
sal = comm = empno = mgr = deptno = 0;
// null이 아니고, 공백이 아닐 때 형변환 처리 trim() : 양옆에 공백 제거
if (empnoStr != null && !empnoStr.trim().equals(""))
	empno = Integer.parseInt(empnoStr);
if (mgrStr != null && !mgrStr.trim().equals(""))
	mgr = Integer.parseInt(mgrStr);
if (salStr != null && !salStr.trim().equals(""))
	sal = Double.parseDouble(salStr);
if (commStr != null && !commStr.trim().equals(""))
	comm = Double.parseDouble(commStr);
if (deptnoStr != null && !deptnoStr.trim().equals(""))
	deptno = Integer.parseInt(deptnoStr);

boolean isProc = false;

if (empnoStr != null) {
	EmpDTO upt = new EmpDTO(empno, ename, job, mgr, hiredatestr, sal, comm, deptno);
	PreparedStmtDao dao = new PreparedStmtDao();
	if (proc.equals("upt")) {
		dao.updateEmp01(upt);
	}
	if (proc.equals("del")) {
		// 삭제 처리
		dao.deleteEmp01(empno);
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
   var isProc = <%=isProc%>;
   var proc = "<%=proc%>"
   if(isProc){
      if(proc=="upt"){
         if(confirm("수정완료\n상세화면이동은 확인, 전체화면이동은 취소")){
            location.href="a01_empDetail.jsp?empno=<%=empno%>";
         }else{
            location.href="a01_empList.jsp";
         }   
      }
      if(proc=="del"){
         alert("삭제완료\n 전체화면으로 이동")
         location.href="a01_empList.jsp";
      }
   }
$(document).ready( function(){
   $("h2").text("수정처리 : <%=empno%>");
	})
</script>
</head>
<body>
	<h2></h2>

</body>
</html>