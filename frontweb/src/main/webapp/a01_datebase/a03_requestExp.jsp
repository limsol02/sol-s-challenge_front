<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>물건정보입력</h2><br>
<form>
	물건명 : <input type="text" name="pname"><br>
	가격 : <input type="text" name="price"><br>
	갯수 : <input type="text" name="cnt"><br>
	<input type="submit" value="검색"><br>
</form>
<%
// 1단계 : 요청값은 null이거나, 문자열로 처리된다



// 초기 null에 대한 처리
// 문자열은 초기값이 null일 때, 공백으로 변환
String pname = request.getParameter("pname");
if(pname==null){pname="";}

// 숫자형은 숫자형 데이터를 선언하고, 숫자값이 들어올 때, 형변환처리
String priceStr = request.getParameter("price");
int price=0;
if(priceStr!=null){price=Integer.parseInt(priceStr);}

//숫자형은 숫자형 데이터를 선언하고, 숫자값이 들어올 때, 형변환처리
String cntStr = request.getParameter("cnt");
int cnt = 0;
if(cntStr!=null){cnt=Integer.parseInt(priceStr);}

int sum = cnt*price;
%>
<h2>물건정보출력</h2><br>
물건명 : <%=request.getParameter("pname") %><br>
가격 : <%=request.getParameter("price") %><br>
갯수 : <%=request.getParameter("cnt") %><br>
총계 : <%=cnt*price %>
<%--
a04_student.jsp
학생명 : 
국어: 
영어 : 
수학 :
[성적처리]

@@@의 성적
총점 : @@@
평균 : @@@
 --%>
</body>
</html>