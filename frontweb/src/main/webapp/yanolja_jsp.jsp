<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="frontweb.yanolja.Yanolja"
	import="frontweb.yanolja.Pension" import="java.util.*"%>
<%
Yanolja dao = new Yanolja();
for (Pension pension :dao.getPensionList(null,0,null)) {
	System.out.print(pension.getNo() + "\t");
	System.out.print(pension.getName() + "\t");
	System.out.print(pension.getNumberOfPeople() + "\t");
	System.out.print(pension.getPrice() + "\t");
	System.out.print(pension.getEmptyOfDate() + "\t");
	System.out.print(pension.getLoc() + "\n");
}
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h2>숙소 목록</h2>
<form>
	원하는 지역 <input type="text" name="loc" value="${param.loc}"> 
	인원수 <input type="number" name="numberOfPeople" value="${param.numberOfPeople}"> 
	원하는 날짜<input type="text" name="emptyOfDate" value="${param.emptyOfDate}"> 
	<input type="submit" value="검색">
</form>
<table border="1">
	<tr>
		<th>숙소 번호</th>
		<th>숙소 이름</th>
		<th>수용 인원</th>
		<th>가격</th>
		<th>체크인 날짜</th>
		<th>숙소 위치</th>
	</tr>
	<%
	
	
	String loc = request.getParameter("loc");
	if(loc==null) loc="";

	int numberOfPeople = 0;
	try {
	numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
	} catch (NumberFormatException e) {
	}

	String emptyOfDate = request.getParameter("emptyOfDate");
	if(emptyOfDate==null) emptyOfDate="";


	for(Pension pension:dao.getPensionList(loc,numberOfPeople,emptyOfDate)) {

	%>
	<tr>
		<th><%=pension.getNo()%></th>
		<th><%=pension.getName()%></th>
		<th><%=pension.getNumberOfPeople()%></th>
		<th><%=pension.getPrice()%></th>
		<th><%=pension.getEmptyOfDate()%></th>
		<th><%=pension.getLoc()%></th>
	</tr>
	<%}%>
</table>
</body>
</html>