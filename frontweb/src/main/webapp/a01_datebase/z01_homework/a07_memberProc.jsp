<%@page import="frontweb.database.z01_homework.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import = "frontweb.vo.Member"      
    %>
    
        <style type="text/css">

* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=button], input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}
.customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

.customers td, .customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

.customers tr:nth-child(even){background-color: #f2f2f2;}

.customers tr:hover {background-color: #ddd;}


.customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
  
}

.customers .th_form {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: white;
  color: #04AA6D;
  text-align:center;
}


</style>
<%
String mnoStr = request.getParameter("mno");
String pointStr = request.getParameter("point");
String name = request.getParameter("name");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String auth = request.getParameter("auth");
String proc = request.getParameter("proc");
if(proc==null) proc="";
int mno = 0;

if(mnoStr!=null) {
	mno = Integer.parseInt(mnoStr);
	int point = Integer.parseInt(pointStr);
	MemberDao dao = new MemberDao();
	if(proc.equals("upt")){
		// Member(int mno, String name, String id, String pwd,
				//String auth, int point) 
		if(dao.updateMember(new Member(mno, name, id, pwd, auth, point) ) ==0){
			proc ="수정실패";
		}
	}
	if(proc.equals("del")){
		if(dao.deleteMember(mno)==0){
			proc ="삭제실패";
		}
	}	
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.1.1.js"></script>
<script>
var proc = "<%=proc%>"
if(proc!=""){
	if(proc=="upt"){
		if(confirm("수정 성공\n상세화면은 확인, 조회화면은 취소")){
			location.href="a07_memberDetail.jsp?mno=<%=mno%>";
		}else{
			location.href="a07_memberList.jsp";
		}
	}else if(proc=="del"){
		alert("삭제 성공")
		location.href="a07_memberList.jsp";
	}else{
		alert(proc+"\n 조회화면으로 이동")
		location.href="a07_memberList.jsp";
	}	
}
$(document).ready( function(){
	
})
</script>
</head>
<body>
    <h2></h2>

</body>
</html>