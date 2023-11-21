<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="frontweb.database.z01_homework.vo.locations"
	import="frontweb.database.z01_homework.A1114"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	A1114 dao = new A1114();
	%>
	<h2>뭔지모를 주소조회</h2>
	<table border >
		<tr>
			<th>Location_id</th>
			<th>City</th>
			<th>Country_id</th>
			<th>Postal_code</th>
			<th>State_province</th>
			<th>Street_address</th>
		</tr>
		<%for(locations l01 : dao.getLocList("S","T")) {%>
		<tr>
			<td><%=l01.getLocation_id() %></td>
			<td><%=l01.getCity() %></td>
			<td><%=l01.getCountry_id() %></td>
			<td><%=l01.getPostal_code() %></td>
			<td><%=l01.getState_province() %></td>
			<td><%=l01.getStreet_address() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>