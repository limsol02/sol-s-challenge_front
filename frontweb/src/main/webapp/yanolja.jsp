<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="frontweb.pension"
	import="frontweb.dao.Yanolja" import="java.text.SimpleDateFormat"
	import="java.text.ParseException"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	pension p01 = new pension();
	%>
	<h2>펜션 리스트</h2>
	<form>
		지역 입력 : <input type="text" name="loc" value="${param.loc}" /> 
		체크인 날짜 입력 : <input type="text" name="checkIn" value="${param.checkIn}" />
		인원 입력 : <input type="text" name="numberOfPeople" value="${param.numberOfPeople}" /> 
		<input type="submit" value="검색" />
	</form>
	<table border>
		<tr>
			<th>펜션 번호</th>
			<th>펜션 이름</th>
			<th>수용 인원</th>
			<th>가격</th>
			<th>체크인 날짜</th>
			<th>체크아웃 날짜</th>
			<th>숙소 지역</th>
		</tr>
		<%
		// 체크아웃 입력 : <input type="text" name="checkOut" value="${param.checkOut}" /> 
		Yanolja dao = new Yanolja();

		String loc = request.getParameter("loc");
		if (loc == null) loc = "";
		
		String checkIn = request.getParameter("checkIn");
		if (checkIn == null) checkIn = "";
		
		//String checkOut = request.getParameter("checkOut");
		//if (checkOut == null) checkOut = "";
		
		String numberOfPeople = request.getParameter("numberOfPeople");
		if (numberOfPeople == null) loc = "";
		
		

		for (pension plist : dao.getPensionList(loc,checkIn,numberOfPeople)) {
		%>
		<tr>
			<th><%=plist.getNo()%></th>
			<th><%=plist.getName()%></th>
			<th><%=plist.getNumberOfPeople()%></th>
			<th><%=plist.getPrice()%></th>
			<th><%=plist.getCheckIn()%></th>
			<th><%=plist.getCheckOut()%></th>
			<th><%=plist.getLoc()%></th>
		</tr>
		<%
		}
		%>
	</table>


</body>
</html>