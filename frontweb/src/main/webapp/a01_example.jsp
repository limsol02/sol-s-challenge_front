<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="frontweb.Person"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{color:blue;}
</style>
<script type="text/javascript">
	function ch(obj) {
		obj.style.fontSize="30pt";
		obj.align="center";
	}
</script>
</head>
<body>
<%
	String name = "홍길동";
	Person p01 = new Person("마길동",25,"서울");
%>
	<h2 align="right" onclick="ch(this)"><%=name%></h2>
	<h2 align="center"> 이름 : <%=p01.getName() %></h2>
	<h2 align="center">나이 : <%=p01.getAge() %></h2>
	<h2 align="center">사는곳 : <%=p01.getLoc() %></h2>
</body>
</html>