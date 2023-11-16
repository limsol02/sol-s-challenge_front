<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String stname = request.getParameter("stname"); 
if(stname==null){stname="";}

String korStr = request.getParameter("kor");
int kor=0;
if(korStr!=null){kor = Integer.parseInt(korStr);}

String engStr = request.getParameter("eng");
int eng=0;
if(engStr!=null){eng = Integer.parseInt(engStr);}

String mathStr = request.getParameter("math");
int math=0;
if(mathStr!=null){math = Integer.parseInt(mathStr);}
%>
<h2>학생정보입력</h2>
<form>
학생명 : <input type="text" name="stname" value="<%=stname%>"/><br>
국어점수 : <input type="text" name="kor" value="<%=kor%>"/><br>
영어점수 : <input type="text" name="eng" value="<%=eng%>"/><br>
수학점수 : <input type="text" name="math" value="<%=math%>"/><br>
<input type="submit" value="성적처리"/><br>
</form>
<h2>성적처리</h2>
<%=stname%>의 성적 <br>
총점 : <%=kor+eng+math %> 점 <br>
평균 : <%=(kor+eng+math)/3 %> 점

</body>
</html>