<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="frontweb.database.PreparedStmtDao"
    import="frontweb.vo.EmpDTO"    
    %>
<%
String empnoStr = request.getParameter("empno");
String ename = request.getParameter("ename");
String job = request.getParameter("job");
String mgrStr = request.getParameter("mgr");
String hiredatestr = request.getParameter("hiredatestr");
String salStr = request.getParameter("sal");
String commStr = request.getParameter("comm");
String deptnoStr = request.getParameter("deptno");
// 숫자형 데이터 초기화
int empno, mgr,deptno ; double sal, comm;
sal= comm = empno = mgr = deptno = 0;
// null이 아니고, 공백이 아닐 때 형변환 처리.  trim() : 양옆에 공백 제거
if(empnoStr!=null&&!empnoStr.trim().equals("")) 
	empno = Integer.parseInt(empnoStr);
if(mgrStr!=null&&!mgrStr.trim().equals("")) mgr = Integer.parseInt(mgrStr);
if(salStr!=null&&!salStr.trim().equals("")) sal = Double.parseDouble(salStr);
if(commStr!=null&&!commStr.trim().equals("")) comm = Double.parseDouble(commStr);
if(deptnoStr!=null&&!deptnoStr.trim().equals("")) deptno = Integer.parseInt(deptnoStr);

boolean isInsert = false;
// 입력값이 있을 때..
if(empnoStr!=null ){
	PreparedStmtDao dao = new PreparedStmtDao();
	dao.insertEmp01(new EmpDTO(
					  empno,ename, job, mgr, hiredatestr,
					  sal, comm, deptno
					));
	isInsert = true;
} 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/frontweb/com/a01_common.css">
<script src="/frontweb/com/jquery-3.6.0.js"></script>
<script>
var isInsert = <%=isInsert%>;
if(isInsert){
	if( !confirm("등록 성공\n계속 등록하시겠습니까?")){
		location.href="a01_empList.jsp";
	}
}

$(document).ready( function(){
	$("h2").text("사원정보등록(<%=empno%>)");
})
</script>
</head>
<body>
    <h2 align="center"></h2>
    <form>
    <table  align="center" border width="50%">
    	<col width="40%">
    	<tr><th>사원번호</th><td><input type="number" name="empno"/></td></tr>
    	<tr><th>사원명</th><td><input type="text" name="ename"/></td></tr>
    	<tr><th>직책명</th><td><input type="text" name="job"/></td></tr>
    	<tr><th>관리자번호</th><td><input type="number" name="mgr"/></td></tr>
    	<tr><th>입사일</th><td><input type="date" name="hiredatestr"/></td></tr>
    	<tr><th>급여</th><td><input type="number" name="sal"/></td></tr>
    	<tr><th>보너스</th><td><input type="number" name="comm"/></td></tr>
    	<tr><th>부서번호</th><td><input type="number" name="deptno"/></td></tr>
    	<tr><th colspan="2">
				<input type="submit" value="등록"/>
				<input type="button" value="메인리스트화면" 
					onclick="location.href='a01_empList.jsp'"/>    	
    		</th></tr>
    </table>
    </form>
</body>
</html>