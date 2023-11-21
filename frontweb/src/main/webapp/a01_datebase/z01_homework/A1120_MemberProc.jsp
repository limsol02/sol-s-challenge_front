<%@page import="frontweb.vo.Member"%>
<%@page import="frontweb.database.z01_homework.A1120"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%


String proc = request.getParameter("proc"); 

String mnoStr = request.getParameter("mno");
int mno = 0;
if(mnoStr!=null){mno = Integer.parseInt(mnoStr);}

String name = request.getParameter("name");
if(name==null) name="";

String id = request.getParameter("id");
if(id==null) id="";

String pwd = request.getParameter("pwd");
if(pwd==null) pwd="";

String auth = request.getParameter("auth");
if(auth==null) auth="";

String pointStr = request.getParameter("point");
int point=0;
if(pointStr!=null) {point = Integer.parseInt(pointStr);}


boolean isProc = false;
if (mnoStr != null) {
	Member upt = new Member(mno, name, id,pwd,auth,point);
	A1120 dao = new A1120();
	if (proc.equals("upt")) {
		dao.updateMember(upt);
	}
	if(proc.equals("del")){
		dao.deleteMember(mno);
	}
	
	isProc = true;
}

%>
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
	            location.href='a05_deptDetail.jsp?deptno=<%=mno%>';
				} else {
					location.href = 'A1120.jsp';
				}
			}
			if (proc == "del") {
				alert("삭제완료\n 전체화면으로 이동")
				location.href = 'A1120.jsp';
			}
		}
$(document).ready( function(){
	   $("h2").text("수정처리 : <%=mno%>");
		})
</script>
</head>
<body>
    <h2></h2>

</body>
</html>