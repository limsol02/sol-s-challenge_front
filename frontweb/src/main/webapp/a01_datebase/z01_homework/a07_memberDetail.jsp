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
	int mno = 0;
	Member mem = new Member();
	if(mnoStr!=null){ 
		mno = Integer.parseInt(mnoStr);
		MemberDao dao = new MemberDao();
		mem = dao.getMember(mno);
	}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/frontweb/com/a03_comm.css">
<script src="jquery-3.1.1.js"></script>
<script>
$(document).ready( function(){
	$("th").addClass("th_form");
	$("h2").text("회원정보상세(<%=mno%>)");
	// <input type="hidden" name="proc" />
	$("#uptBtn").click(function(){
		if(confirm("수정하시겠습니까?")){
			$("[name=proc]").val("upt")
			$("form").submit();
		}
	})
	$("#delBtn").click(function(){
		if(confirm("삭제하시겠습니까?")){
			$("[name=proc]").val("del")
			$("form").submit();			
		}		
	})	
})
</script>
</head>
<body>
    <h2 align="center"></h2>
    <form action="a07_memberProc.jsp">
    	<!-- type="hidden" 화면에 보이지 않지만 요청값으로 중요한 의미가 있을
    		때 사용. : 이경우, proc페이지 전송시, 수정/삭제를 구분하여 전송 -->
    	<input type="hidden" name="proc" />
    <table   class="customers"  align="center" border width="50%">
    	<col width="40%">
     	<tr><th>회원번호</th><td><input type="text" name="mno" value="<%=mem.getMno()%>"/></td></tr>
     	<tr><th>회원아이디</th><td><input type="text" name="id" value="<%=mem.getId()%>"/></td></tr>
    	<tr><th>패스워드</th><td><input type="text" name="pwd" value="<%=mem.getPwd()%>"/></td></tr>
    	<tr><th>회원명</th><td><input type="text" name="name" value="<%=mem.getName()%>"/></td></tr>
    	<tr><th>권한</th><td><input type="text" name="auth" value="<%=mem.getAuth()%>"/></td></tr>
    	<tr><th>포인트</th><td><input type="number" name="point" value="<%=mem.getPoint()%>"/></td></tr>
 
     	<tr><th colspan="2">
				<input type="button" id="uptBtn" value="수정"/>
				<input type="button" id="delBtn" value="삭제"/>
				<input type="button" value="메인리스트화면" 
					onclick="location.href='a07_memberList.jsp'"/>    	
    		</th></tr>
    </table>
    </form>

</body>
</html>