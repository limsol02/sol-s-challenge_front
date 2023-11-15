package frontweb.z01_homework;

public class A1115 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
	      1단계:확인] 1. 아래의 요청값을 처리하는 jsp화면을 만들어 보세요
	       
    2)[생각보다 난이도 높음] **간단한 계산기**: 두 숫자와 연산자(+, -, *, /)를 입력받아 결과를 출력하는 JSP 페이지 만들기.
	         <%
	String nStr01 = request.getParameter("num01");
	int num01 = 0;
	if(nStr01 != null){num01 = Integer.parseInt(nStr01);}
	
	String nStr02 = request.getParameter("num02");
	int num02 = 0;
	if(nStr02 != null){num02 = Integer.parseInt(nStr02);}
	
	String cal = request.getParameter("cal");
	if(cal==null){cal="";}
	
	int result = 0;
	
	if(cal.equals("+")){result=num01+num02;}
	
	if(cal.equals("*")){result=num01*num02;}
	
	if(cal.equals("-")){
		if(num01>num02){
			result=num01-num02;
		}else{
			result=num02-num01;
		}
	}
	
	if(cal.equals("/")){
		if(num01>num02){
			result=num01/num02;
		}else{
			result=num02/num01;
		}
	}
	
%>
<form>
	<input type = "text" name = "num01" value="<%=num01%>"/> 
	<input type = "text" name = "num02" value="<%=num02%>"/> 
	<input type = "text" name = "cal" value="<%=cal%>"/> 
	<input type = "submit"/> 
</form>


<h2>결과 : <%=result %> </h2>
	         
	         4) **숫자 덧셈 vs 문자열 결합**: 두 입력값을 받아, 숫자일 경우 합을, 문자열일 경우 결합된 문자열을 출력하는 페이지 만들기.
	            hint) str.matches("-?\\d+(\\.\\d+)?") 활용(숫자형일 때,true)
<%--
	String ranStr01 = request.getParameter("ran01");
	int ran01 = 0;
	if(ranStr01!=null&&ranStr01.matches("-?\\d+(\\.\\d+)?")){ran01=Integer.parseInt(ranStr01);}
	
	String ranStr02 = request.getParameter("ran02");
	int ran02 = 0;
	if(ranStr02!=null&&ranStr02.matches("-?\\d+(\\.\\d+)?")){ran02=Integer.parseInt(ranStr02);}
	
	int r01 = 0;
	String r02 = "";
	
	if(ranStr01.matches("-?\\d+(\\.\\d+)?")&&ranStr02.matches("-?\\d+(\\.\\d+)?")){
		r01 = ran01+ran02;
	}else{
		r02 = ranStr01+ranStr02;
	}
--%>	         
	         
	         
	      [1단계:확인] 2. 아래 내용을 DB로 처리하여 화면에 출력하세요.
	              # 처리순서, sql구문, 메서드선언, 화면호출, 요청값처리
	         1)[선택]  부서번호별 직원 조회: EMP와 각 부서 번호에 해당하는 직원들의 이름과 부서번호를 조회하는 쿼리 작성.
	            부서번호 [10~40  ] [조회] 
	                 사원번호 사원명  급여  부서번호
	         2) 직책명 [     ]
	            입사분기 [1~4 ]  [조회]
	                 사원번호 사원명 직책명 입사분기 입사일 
	          3) 특정 기간에 입사한 직원 조회: EMP 테이블을 사용하여 @@@@/@@/@@ 부터 @@@@/@@/@@ 사이에 입사한 직원들의 목록을 조회하는 쿼리 작성.
	            입사일:[@@@@/@@/@@] ~ [@@@@/@@/@@] [검색]
	            사원번호 사원명 직책 입사일(@@@/@@/@@표시) 부서번호
	       
	       * */
		
	}

}
