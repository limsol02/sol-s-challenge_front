package frontweb.database.z01_homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import frontweb.Emp;
import frontweb.database.DBCon;
import frontweb.vo.EmpHire;
import frontweb.vo.EmpHireTerm;

public class A1115 {
	/*1)[선택]  부서번호별 직원 조회: EMP와 각 부서 번호에 해당하는 직원들의 이름과 부서번호를 조회하는 쿼리 작성.
		부서번호 [10~40  ] [조회] 
		사원번호 사원명  급여  부서번호*/
	public List<Emp> getEmpListByDeptno(int deptno){
		List<Emp> elist = new ArrayList<Emp>();
		String sql = "select empno, ename, sal, deptno from emp where deptno=?";
				try (Connection con = DBCon.con();
					PreparedStatement pstmt = con.prepareStatement(sql);) {
					// 내가 처리할 처리코드 1
					pstmt.setInt(1, deptno);
					try (ResultSet rs = pstmt.executeQuery();) {
						// 내가 처리할 처리코드2
						while(rs.next()) {
							elist.add(new Emp(
									rs.getInt("empno"),
									rs.getString("ename"),
									rs.getDouble("sal"),
									rs.getInt("deptno")
									));
						}
						System.out.println("데이터 건수 : "+elist.size());
					}
				} catch (SQLException e) {
					System.out.println("DB에러 : " + e.getMessage());
				} catch (Exception e) {
					System.out.println("일반에러 : " + e.getMessage());
				}
		return elist;
	}
	

/*
SELECT empno, ename, job, to_char(hiredate,'Q') hire_qua,
to_char(hiredate,'YYYY/MM/DD') hire_str 
FROM emp WHERE job LIKE upper(?) AND to_char(hiredate,'Q')=?
*/
	public List<EmpHire> getEmpHireInfo(String job, String hire_qua){
		 List<EmpHire> hiList = new ArrayList<EmpHire>();
		 String sql = "SELECT empno, ename, job, to_char(hiredate,'Q') hire_qua,\r\n"
		 		+ "to_char(hiredate,'YYYY/MM/DD') hire_str \r\n"
		 		+ "FROM emp WHERE job LIKE upper(?) AND to_char(hiredate,'Q')=?";
		 try (Connection con = DBCon.con();
					PreparedStatement pstmt = con.prepareStatement(sql);) {
					// 내가 처리할 처리코드 1
					pstmt.setString(1, "%"+job+"%");
					pstmt.setString(2, hire_qua);
					try (ResultSet rs = pstmt.executeQuery();) {
						// 내가 처리할 처리코드2
						while(rs.next()) {
							hiList.add(new EmpHire(
									rs.getInt("empno"),
									rs.getString("ename"),
									rs.getString("job"),
									rs.getString("hire_qua"),
									rs.getString("hire_str")
									));
						}
						System.out.println("데이터 건수 : "+hiList.size());
					}
				} catch (SQLException e) {
					System.out.println("DB에러 : " + e.getMessage());
				} catch (Exception e) {
					System.out.println("일반에러 : " + e.getMessage());
				}
		 
		 return hiList;
	}
	/*
SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY/MM/DD') hirestr, deptno
FROM emp
WHERE hiredate BETWEEN TO_DATE(?, 'YYYY/MM/DD') AND TO_DATE(?, 'YYYY/MM/DD')
	 * */
	
	public List<EmpHireTerm> getEmpHireList(String start, String end){
		List<EmpHireTerm> list = new ArrayList<EmpHireTerm>();
		String sql = "SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY/MM/DD') hirestr, deptno\r\n"
				+ "FROM emp\r\n"
				+ "WHERE hiredate BETWEEN TO_DATE(?, 'YYYY/MM/DD') AND TO_DATE(?, 'YYYY/MM/DD')";
		 try (Connection con = DBCon.con();
					PreparedStatement pstmt = con.prepareStatement(sql);) {
					// 내가 처리할 처리코드 1
					pstmt.setString(1, start);
					pstmt.setString(2, end);
					try (ResultSet rs = pstmt.executeQuery();) {
						// 내가 처리할 처리코드2
						while(rs.next()) {
							list.add(new EmpHireTerm(
									rs.getInt("empno"),
									rs.getString("ename"),
									rs.getString("job"),
									rs.getString("hirestr"),
									rs.getInt("deptno")
									));
						}
						System.out.println("데이터 건수 : "+list.size());
					}
				} catch (SQLException e) {
					System.out.println("DB에러 : " + e.getMessage());
				} catch (Exception e) {
					System.out.println("일반에러 : " + e.getMessage());
				}
		return list;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A1115 dao = new A1115();
		dao.getEmpHireInfo("S","1");
		for(EmpHire e :dao.getEmpHireInfo("S","1")) {
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\n");
			
		}
		/*
1단계:확인] 1. 아래의 요청값을 처리하는 jsp화면을 만들어 보세요
1) **사용자 이름 출력하기**: 사용자로부터 이름을 입력받아, "안녕하세요, [이름]님!" 이라고 출력하는 페이지 만들기.
<%
String name = request.getParameter("name");
if(name == null){name="";}
 %>
 <form>
 	<input type="text" name="name" value="<%=name%>"/><br>
 	<input type="submit"><br>
 </form>
 <h2><%=name %>님 안녕하세요!</h2>
 
			
2)[생각보다 난이도 높음] **간단한 계산기**: 두 숫자와 연산자(+, -, *, /)를 입력받아 결과를 출력하는 JSP 페이지 만들기.
<%
 String numStr01 = request.getParameter("num01");
 int num01=0;
 if(numStr01!=null){num01=Integer.parseInt(numStr01);}
 
 String numStr02 = request.getParameter("num02");
 int num02=0;
 if(numStr02!=null){num02=Integer.parseInt(numStr02);}
 
 String cal=request.getParameter("cal");
 if(cal==null){cal="";}
 
 int r01 = 0;
 if(cal.equals("+")){r01 = num01+num02 ;}
 if(cal.equals("-")){r01 = num01-num02 ;}
 if(cal.equals("*")){r01 = num01*num02 ;}
 if(cal.equals("/")){r01 = num01/num02 ;}
 
 %>
	<form>
		<input type = "text" name="num01" value="num01">
		<input type = "text" name="num02" value="num02">
		<input type = "text" name="cal" value="cal">
		<input type = "submit" name="num01" >
	</form>

	<h2>
	결과 : <%=r01 %>
	</h2>


3) **로그인 시뮬레이션**: 사용자 아이디와 비밀번호를 입력받아, 특정 아이디/비밀번호와 일치할 때 "로그인 성공"을, 그렇지 않으면 "로그인 실패"를 출력하는 페이지 만들기.
<%
String id = request.getParameter("id");
if(id == null){id="";}

String pwd = request.getParameter("pwd");
if(pwd==null){pwd="";}

String tureId = "himan";
String turePwd = "7777";
String result="";

if(id.equals(tureId) && pwd.equals(turePwd)){
	 result = "로그인 성공";
}else{
	 result="로그인 실패";
}
 %>
 
 <form>
 	<input type="text" name="id" value="<%=id%>"/><br>
 	<input type="text" name="pwd" value="<%=pwd%>"/><br>
 	<input type="submit"><br>
 </form>
 
 
 <h2>로그인 여부 : <%=result%></h2>
 
4) **숫자 덧셈 vs 문자열 결합**: 두 입력값을 받아, 숫자일 경우 합을, 문자열일 경우 결합된 문자열을 출력하는 페이지 만들기.
		hint) str.matches("-?\\d+(\\.\\d+)?") 활용(숫자형일 때,true)
 <%
 String ran01Str = request.getParameter("ran01");
 String ran02Str = request.getParameter("ran02");
 int ran01 = 0;
 int ran02 = 0;
 int result1 = 0;
 String result2 = "";

 if(ran01Str != null && ran02Str != null){
    if(ran01Str.matches("-?\\d+(\\.\\d+)?") && ran02Str.matches("-?\\d+(\\.\\d+)?")){
    	ran01 = Integer.parseInt(ran01Str);
    	ran02 = Integer.parseInt(ran02Str);
       result1 = ran01 + ran02;
    }else{
       result2 = ran01Str + ran02Str;
    }   
 }

 %>
 
 <form>
 	<input type="text" name="ran01" value="<%=ran01%>"/><br>
 	<input type="text" name="ran02" value="<%=ran02%>"/><br>
 	<input type="submit"><br>
 </form>
 

 <h2>둘다 숫자형 : <%=result1 %> </h2>
 <h2>아닌경우 : <%=result2 %> </h2>		
		

5) **숫자 짝/홀 판별 **: 숫자면 짝수인지 홀수인지 판별하고 출력하는 JSP 페이지 만들기.
<%
 String numStr01 = request.getParameter("num01");
 int num01 = 0;
 if(numStr01!=null){num01 = Integer.parseInt(numStr01);}
 
 String numStr02 = request.getParameter("num02");
 int num02 = 0;
 if(numStr02!=null){num02 = Integer.parseInt(numStr02);}
 
 String result01 = "";
 String result02 = "";
 if(num01%2==0){
	 result01 = "짝수입니다";
 }else{
	 result01 = "홀수입니다";
 }
 
 if(num02%2==0){
	 result02 = "짝수입니다";
 }else{
	 result02 = "홀수입니다";
 }
 %>
 
 <form>
 	<input type="text" name="num01" value="<%=num01%>"/><br>
 	<input type="text" name="num02" value="<%=num02%>"/><br>
 	<input type="submit"><br>
 </form>
 

 <h2>첫번째숫자 : <%=result01 %> </h2>
 <h2>두번째숫자 : <%=result02 %> </h2>
 
[1단계:확인] 2. 아래 내용을 DB로 처리하여 화면에 출력하세요.
		    # 처리순서, sql구문, 메서드선언, 화면호출, 요청값처리

1)[선택]  부서번호별 직원 조회: EMP와 각 부서 번호에 해당하는 직원들의 이름과 부서번호를 조회하는 쿼리 작성.
		부서번호 [10~40  ] [조회] 
		사원번호 사원명  급여  부서번호
<%
 PreparedStmtDao dao = new PreparedStmtDao();
 %>
 
 <h2 align="center">사원 정보 조회</h2>
 <%
 String deptnoStr = request.getParameter("deptno");
 int deptno = 0;
 if(deptnoStr!=null){deptno=Integer.parseInt(deptnoStr);}
 %>
	<form>
		<table width="40%" border align="center">
			<tr>
				<th>부서번호</th>
				<td><input type="text" name="deptno" value="<%=deptno%>" /></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="검색" /></th>
			</tr>
		</table>
	</form>

	<br>
	<br>
	<br>
	<table border align="center">
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>급여</th>
			<th>부서번호</th>
		</tr>
		<%
		for (Emp emp : dao.getEmpList01(deptno)) {
		%>
		<tr>
			<th><%=emp.getEmpno()%></th>
			<th><%=emp.getEname()%></th>
			<th><%=emp.getSal()%></th>
			<th><%=emp.getDeptno()%></th>
		</tr>
		<%
		}
		%>
	</table>

2) 직책명 [     ]
		입사분기 [1~4 ]  [조회]
		사원번호 사원명 직책명 입사분기 입사일 
		
		<%
 PreparedStmtDao dao = new PreparedStmtDao();
 %>
 
 <h2 align="center">사원 정보 조회</h2>
 <%
 String job = request.getParameter("job");
 if(job==null){job="";}
 
 String dateStr = request.getParameter("date");
 int date = 0;
 if(dateStr!=null){date=Integer.parseInt(dateStr);}
 %>
	<form>
		<table width="40%" border align="center">
			<tr>
				<th>직책명</th>
				<td><input type="text" name="job" value="<%=job%>" /></td>
			</tr>
			<tr>
				<th>분기</th>
				<td><input type="text" name="date" value="<%=date%>" /></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="검색" /></th>
			</tr>
		</table>
	</form>

	<br>
	<br>
	<br>
	<table border align="center">
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>직책명</th>
			<th>입사일</th>
		</tr>
		<%
		for (Emp emp : dao.getEmpList03(job,date)) {
		%>
		<tr>
			<th><%=emp.getEmpno()%></th>
			<th><%=emp.getEname()%></th>
			<th><%=emp.getJob()%></th>
			<th><%=emp.getHiredate()%></th>
		</tr>
		<%
		}
		%>
	</table>

3) 특정 기간에 입사한 직원 조회: EMP 테이블을 사용하여 @@@@/@@/@@ 부터 @@@@/@@/@@ 사이에 입사한 직원들의 목록을 조회하는 쿼리 작성.
		입사일:[@@@@/@@/@@] ~ [@@@@/@@/@@] [검색]
		사원번호 사원명 직책 입사일(@@@/@@/@@표시) 부서번호

<%
 PreparedStmtDao dao = new PreparedStmtDao();
 %>
 
 <h2 align="center">사원 정보 조회</h2>
 <%
 String start = request.getParameter("start");
 if(start==null){start="";}
 
 String end = request.getParameter("end");
 if(end==null){end="";}
 
 
 %>
	<form>
		<table width="40%" border align="center">
			<tr>
				<th>날짜 1</th>
				<td><input type="text" name="start" value="<%=start%>" /></td>
			</tr>
			<tr>
				<th>날짜 2</th>
				<td><input type="text" name="end" value="<%=end%>" /></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="검색" /></th>
			</tr>
		</table>
	</form>

	<br>
	<br>
	<br>
	<table border align="center">
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>직책명</th>
			<th>입사일</th>
		</tr>
		<%
		for (Emp emp : dao.getEmpList04(start,end)) {
		%>
		<tr>
			<th><%=emp.getEmpno()%></th>
			<th><%=emp.getEname()%></th>
			<th><%=emp.getJob()%></th>
			<th><%=emp.getHiredate()%></th>
		</tr>
		<%
		}
		%>
	</table>
		 * */
		
		
	}

}
