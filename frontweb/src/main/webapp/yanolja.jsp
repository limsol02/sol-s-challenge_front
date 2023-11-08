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
		체크아웃 입력 : <input type="text" name="checkOut" value="${param.checkOut}" /> 
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
		Yanolja dao = new Yanolja();

		String loc = request.getParameter("loc");
		if (loc == null)
			loc = "";
		String checkInStr = request.getParameter("checkIn");
		String checkOutStr = request.getParameter("checkOut");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date checkIn = null;
		Date checkOut = null;

		try {
			if (checkInStr != null && !checkInStr.isEmpty()) {
				checkIn = dateFormat.parse(checkInStr);
			}

			if (checkOutStr != null && !checkOutStr.isEmpty()) {
				checkOut = dateFormat.parse(checkOutStr);
			}
		} catch (ParseException e) {
			// 날짜 문자열을 파싱하는 동안 오류가 발생한 경우의 예외 처리
			e.printStackTrace(); // 오류 정보를 출력하거나 다른 예외 처리 동작을 수행
		}

		String numberOfPeopleStr = request.getParameter("numberOfPeople");
		int numberOfPeople = 0; // 기본값 설정

		if (numberOfPeopleStr != null && !numberOfPeopleStr.isEmpty()) {
			try {
				numberOfPeople = Integer.parseInt(numberOfPeopleStr);
			} catch (NumberFormatException e) {
				// 숫자로 변환할 수 없는 경우에 대한 예외 처리
			}
		}

		for (pension plist : dao.getPensionList(loc,checkIn,checkOut,numberOfPeople)) {
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