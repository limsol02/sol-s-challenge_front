SELECT * 
FROM emp
WHERE ename LIKE '%A%';
-- 리턴할 객체 List<Emp>   getList(String ename)
/*
private int empno;
private String ename;
private String job;
private int mgr;
private Date hiredate;
private double sal;
private double comm;
private int deptno;

 * */
SELECT max(sal)
FROM emp
WHERE deptno=40;
--public double getMaxSal(int deptno){ double max=0; return max}
-- ex) 위 구문 처리할 때 메서드 선언..
-- public double getMax(int deptno){ double max = 0;  return max;}
SELECT ename
FROM emp
WHERE empno = 7369;
-- public String getEname(int empno){ String ename=""; return ename}
SELECT hiredate
FROM emp
WHERE ename = 'SMITH';
-- EX)메서드 선언..
-- public Date getHire(String ename){ Date hire=null; return hire;}
SELECT * FROM emp;
SELECT empno, ename, job
FROM emp
WHERE empno = 7499;
-- empno, ename, job 데이터 유형 확인
-- int    String String
-- ==> VO 처리(여러개 열일 때.)
/* 기존에 Emp에 포함되어 있으면, 추가할 필요없이 재활용
public EmpShort getEmpSht(int empno){ EmpShort es=null; return es;} 
class EmpShort{
	private int empno;
	private String ename;
	private String job;
	//1. 기본생성자, 2. 매개변수 생성자, 3. set/get메서드 선언..

 * */
SELECT * FROM dept;
-- 
-- EX1)메서드선언 public int getDetCnt(int deptno){ int cnt=0; return cnt;}
SELECT count(*)
FROM dept
WHERE deptno = 20;
-- EX2)메서드선언  
-- public Dept getDept(String dname){ Dept d=null; return d;}
/*
class Dept{
	private int deptno;
	private String dname;
	private SAtring loc;
}
**/
SELECT *
FROM dept
WHERE dname = 'ACCOUNTING';
-- 한개의 열에 여러 행이 있는 리턴값, 입력 2개 숫자형
--   List<데이터유형>
--   List<String>, List<Integer>, List<Double>, List<Date>
-- public List<String> getEnames(int start, int end){ }
SELECT ename
FROM emp
WHERE sal BETWEEN 1000 AND 2000;

SELECT sal
FROM emp
WHERE deptno=10;
-- ex)메서드 선언..public List<Double> getSalaries(int deptno){}
SELECT *
FROM emp
WHERE sal BETWEEN 1000 AND 2000;
/*
public List<Emp> getEmpList(int start, int end){
	List<Emp> emplist = new ArrayList<Emp>();
	String sql = "  SELECT *
					FROM emp
					WHERE sal BETWEEN "+start+" AND "+end;
	return emplist;
}
 * */
SELECT *
FROM dept
WHERE dname LIKE '%S%';
-- ex) 메서드 선언.
-- 행이 여러개인지? List(여러개)
-- 열이 여러개인지? 단일 타입 String/int/double, 객체(클래스 선언)
-- public List<Dept> getDeptSch(String sch)

CREATE TABLE member01(
	mno NUMBER,
	name varchar2(50),
	id varchar2(50),
	pwd varchar2(30),
	auth varchar2(20),
	point number
);
/*
class Member{
	private int mno;
	private String name;
	private String id;
	private String pwd;
	private String auth;
	private int point;
}
 * 
 * */


SELECT * FROM member01;
INSERT INTO member01 
	values(1,'홍길동','himan','7777','admin',1000);
INSERT INTO member01 
	values(2,'김길동','goodman','7777','normal',2000);
/*

-- * */
--INSERT INTO member01 
--	values("+ins.getMno()+",'"+ins.getName()+"','himan','7777','admin',1000);
-- 회원가입
-- public void insertMember(Member ins){}

-- 회원리스트확인
SELECT * 
FROM member01
WHERE name LIKE '%길동%';
-- public List<Member> schMember(String nameSch)
-- 로그인처리
-- 화면에 id/pass를 통해서 로그인 처리..
SELECT * 
FROM member01;
SELECT *
FROM member01
WHERE id='himan' AND pwd = '777';
-- 입력값을 id와 pwd 입력 처리, 리턴할 내용을 Member객체를 리턴.
SELECT ename
FROM emp
WHERE empno=7369;
/*
확인할사원번호[####] [검색]   : 사원번호를 입력
해당사원번호해당하는 이름 @@@ 입니다. : 사원명 출력
==> DB서버에 접속 ==> 그 결과를 받아(sql) ==> Java객체로(기능메서드) ==> 화면에 출력..

sql연습
==>  Java객체/변수로(기능메서드) 만드는 방법
출력할 내용을 메서드 리턴 유형과 리턴값으로 선언..
입력할 내용을 메서드 매개변수 유형으로 선언한다.
# 메서드틀.
public 리턴유형 메서드명(입력값){
   리턴유형 변수명 = 초기값;
   String sql= "";
   return 변수명;
}
public String getEname(int empno){
   String sql = "SELECT ename
					FROM emp
				WHERE empno="+empno;

   String ename=null;
   return ename;
}  
 * */
/*ex)
확인할 사원명:[SMITH][급여검색]
해당 사원의 급여는 @@@ 입니다.
==> sql 만들고, 기능메서드 선언.
입력할 값 : 사원명 ename  조건문에서 처리 where
출력할 값 : 급여 sal  select에 선언
 * */
SELECT sal
FROM emp
WHERE ename='SMITH';
/*
public double getSal(String ename){
   double sal = 0;
   String sql = "
				 SELECT sal
				FROM emp
				WHERE ename='"+ename+"'  
                ";
   return sal;
}
사원번호 :[    ][직책검색]
해당 사원의 직책은 @@@ 입니다.
입력 : [컬럼명] 조건문에서 처리 where
출력 : [컬럼명] select에 선언
1. sql작성
	select job
	from emp
	where empno=7369;
2. 기능메서드 선언.
public String getJobByEmpno(int empno){
   String job=null;
   String sql = "
	select job
	from emp
	where empno="+empno+"   
   ";
   return job;
}
 *  * */
	select job
	from emp
	where empno=7369;
/*
부서번호 [   ] [해당하는사원명검색]
사원명
@@@
@@@
@@@
@@@
입력 : 부서번호  where deptno=10
출력 : 사원명 select ename
select ename
from emp
where deptno=10;
 * */
select ename
from emp
where deptno=10;
/*
행이 여러개일 때는 List<데이터유형>  
	- 숫자 int   List<Integer>
	-     double List<Double>
	- 문자열    List<String> 
public List<String> getEnamesByDeptno(int deptno){
   List<String> enames = new ArrayList<String();
   String sql= "select ename
					from emp
					where deptno="+deptno;
   return enames;
}
직책 :[    ][사원번호를 확인] 
사원번호
@@@
@@@ 
입력값:
출력값:
sql구문
메서드 선언
public List<Integer> getEmpnosByJob(String job){
   List<Integer> empnos = new List<Integer>();
   String sql= "SELECT EMPNO 
				FROM EMP e 
				WHERE job='"+job+"'";
   return empnos;
}
 * */
SELECT EMPNO 
FROM EMP e 
WHERE job='CLERK';
/*
사원번호[    ] [사원정보확인]
### 사원정보 ####
사원명:@@@
직책:@@@
급여:@@@
부서번호:@@@
입력값 : empno
출력값 : ename, job, sal, deptno
select ename, job, sal, deptno
from emp
where empno = 7499;
ename, job, sal, deptno를 한번에 리턴할 객체
class EmpShow{ ==> class Emp{} 위 내용이 선언된 Emp에 포함되어 있기에
	private String ename;
	private String job;
	private double sal;
	private int deptno;
	// 생성자1(default)
	// 생성자2(매개변수 있는 생성자)
	set/get 메서드 생성.
}
-- 여러개의 컬럼이 있을 때는 클래스로 선언하여 처리한다.
public EmpShow getEmpByEmpno(int empno){
	EmpShow es = null;
	String sql = "select ename, job, sal, deptno
				from emp
				where empno = "+empno
	return e;
}
사원명:[    ] [사원정보확인]
사원번호 직책 급여 부서번호
@@@    @@  @@  @@@
위와 같이 처리되는 sql와 메서드를 선언하세요.
class EmpInfo2{
	private int empno;
	private String job;
	private double sal;
	private int deptno;
}
public EmpInfo2 getEmpInfByEname(String ename){
	EmpInfo2 ei = null;
	String sql = "SELECT empno, job, sal, deptno
				FROM emp
				WHERE ename = '"+ename+"'";
    return ei;
}
 * */
SELECT empno, job, sal, deptno
FROM emp
WHERE ename = 'SMITH';
SELECT * FROM emp;



/*
# 입력값이 다수(2개이상), 리턴할값도(다중행,다중열)
검색할 급여범위
[  ]~[  ] [사원정보검색]
# 조회된값과 리턴유형에 따른 선언 형식
int/double/String : 단일행/단일열
List<데이터유형> : 다중행/단일열
클래스선언 : 단일행/다중열 일때
List<클래스> : 다중행/다중열
public List<Emp> getEmpList(double min, double max){
	List<Emp> empList = new ArrayList<Emp>();
	String sql = "
		SELECT *
		FROM emp
		WHERE sal BETWEEN "+min+" AND "+max+"	
	";
	
	return empList;
}
 * */
SELECT *
FROM emp
WHERE sal BETWEEN 1000 AND 2000;
/*
부서번호:[    ]
직책:[    ] [사원정보]

사원번호 사원명 직책명 관리자번호 ...
@@@    @@@   @@   @@
@@@    @@@   @@   @@
@@@    @@@   @@   @@

 * */

SELECT * 
FROM emp
WHERE deptno = 20
AND job LIKE '%A%';
/*
public List<Emp> getSchEmpInfo(int deptno, String jobSch){
	List<Emp> empList = new ArrayList<Emp>();
	String sql = "
		SELECT * 
		FROM emp
		WHERE deptno = "+deptno+"
		AND job LIKE '%"+jobSch+"%'	
	";	
	return empList;
}

날짜별 예약 리스트를 보고 예약 처리하는 구조..

날짜별 예약 내용
검색할 날짜 [    ]
[date]      [StartLoc]   [EndLoc]    [StartTime] [EndTime]
2023-11-14  서울          대구         9            12
2023-11-14  서울          대구         9            12
2023-11-14  서울          대구         9            12
2023-11-14  서울          대구         9            12
==> 예약 처리했을 데이터가 예약 입력되는 처리 
1. 테이블 생성
*/
	CREATE table reservation(
	    rno number,
	    resdate date,
	    startloc varchar2(50),
	    endloc varchar2(50),
	    starttime number(2,0),
	    endtime number(2,0)
	);
/*
class Reservation{
	private int rno;
	private Date resdate;
	private String startloc;
	private String endloc;
	private int starttime;
	private int endtime;
}
 * */

SELECT * FROM reservation;
/*
2. 데이터 입력
*/
SELECT to_date('2023-11-13','YYYY-MM-DD') FROM dual;
CREATE SEQUENCE res_seq; -- 자동 numbering 하는 오라클객체
INSERT INTO reservation values(res_seq.nextval,
       to_date('2023-11-13','YYYY-MM-DD'), 
       '서울','대구',9,12);
INSERT INTO reservation values(res_seq.nextval,
       to_date('2023-11-12','YYYY-MM-DD'), 
       '서울','대구',10,13);
INSERT INTO reservation values(res_seq.nextval,
       to_date('2023-11-18','YYYY-MM-DD'), 
       '서울','대구',11,14);
SELECT to_char(resdate,'YYYY-MM-DD') FROM reservation;       
SELECT * 
FROM reservation
WHERE to_char(resdate,'YYYY-MM-DD') = '2023-11-14'; 

/*
# 예약리스트 조회
3. 조회 sql 작성
SELECT * 
FROM reservation
WHERE to_char(resdate,'YYYY-MM-DD') = '2023-11-14'; 
4. VO 객체 작성
class Reservation{
	private int rno;
	private Date resdate;
	private String startloc;
	private String endloc;
	private int starttime;
	private int endtime;
}
5. 기능메서드 선언.
public List<Reservation> getResListByDate(String date){
	List<Reservation> rlist = new List<Reservation>();
	String sql = "
		SELECT * 
		FROM reservation
		WHERE to_char(resdate,'YYYY-MM-DD') = '"+date+"'	
	";
	return rlist;
}
# 예약 처리 
6. 입력 sql 작성
INSERT INTO reservation values(res_seq.nextval,
       to_date('2023-11-13','YYYY-MM-DD'), 
       '서울','대구',9,12)
7. 기능메서드 선언

public void inserReservation(Reservation ins){
	String sql = "";
}

출발역:[   ]  도착역:[   ]  [검색]
리스트 내용
[열차번호] [열차종류] [출발역][도착역] [좌석정보] [가격] [소요시간]
1. 테이블 생성
2. 기본데이터 입력
3. sql 작성
4. VO 클래스 선언
5. 기능 메서드 선언

*/
CREATE TABLE trainschedule(
	tno char(10),
	ttype varchar2(50),
	departstation varchar2(50),
	arrivalstation varchar2(50),
	seatinfo varchar2(20),
	price NUMBER,
	duration number(3,1)
);
/*
class Trainschedule
private String tno;
private String ttype;
private String departstation;
private String arrivalstation;
private String seatinfo;
private int price;
private double duration;
SELECT * FROM trainschedule
WHERE departstation = '서울' 
AND arrivalstation = '부산'
public List<Trainschedule> getList(String dpart, String arri){
	List<Trainschedule> list = new ArrayList<Trainschedule>();
	String sql = "";
	return list;
}
 * */
INSERT INTO trainschedule values('KR10000002',
'새마을','서울','부산','A05',50000,4.0);
SELECT * FROM trainschedule
WHERE departstation = '서울' 
AND arrivalstation = '부산';

SELECT job, sal, empno, ename 
FROM emp
WHERE sal BETWEEN 1000 AND 3000;
-- ResultSet rs
-- rs.next() : 행단위로 이동, 1번째 호출 1첫째 row 데이터가 있을 true
--            열단위로 이동 처리 방법
--            rs.get데이터유형("컬럼명"), 
--            rs.get데이터(1) rs.get데이터(2)  rs.get데이터(3)

--            rs.getInt("empno") : 7499 정수형으로 가져온다.
--            rs.getString("ename") : "ALLEN" 문자열로 가져온다.
--            rs.getDouble("sal");
-- ? MANAGER rs.next() 5번호출,  rs.getString("job")
-- 10번째 rs.next() : false
/*
	rs.next() true일 때, 처리되게 로직 구성하려면
		for?, if, while
		
	while(rs.next()){
	    rs.getInt("empno")
        ...
        	
 	    rs.getDouble("sal")
	}		
     if(rs.next()){
         rs.getInt("empno")
 	    rs.getDouble("sal")
     }
     
     public boolean login(String id, String pwd){
     	   boolean isPass=false;
     	   String sql = "select * from member01 where id=? and pwd=?";  	   
     	   while(rs.next()){
     	   	   if(rs.getString("id")!=null){
     	   	   	   isPass = true;
     	   	   }
     	   }
     	   if(rs.next()) isPass=true;   	   
     	   isPass = rs.next();
     	   return isPass;
     }
     
     
 * */
SELECT * FROM emp
WHERE empno =7499; -- rs.next(); rs.next();


SELECT * FROM DEPT WHERE deptno=10;
-- 데이터유형이 다르고 갯수 정해져있는 걸 담아서 사용하기 위하여 class선언

/*
class Dept{
	private int deptno;
	private String dname;
	private String loc;
	Dept(){} 기본생성자
	Dept(int deptno, String dname, String lon){} // 필드 생성자 (초기화)
}

public Dept get Dept(int deptno){
	Dept dept = null;
	
	if(rs.next()){
		rs.getInt("deptno"),
		rs.getString("dname"),
		rs.getString("loc")
		==> ResultSet 객체의 데이터를 생성자를 통해서 객체 생성과 데이터 할당.
		dept = new Dept(
			rs.getInt("deptno"),
			rs.getString("dname"),
			rs.getString("loc")
		)
	}	
}
 * */

-- Dept 객체를 리턴으로 하여 추가 메서드 선언 및 처리..

SELECT * FROM member01 WHERE id='himan';
-- 위 기준 sql 기능메서드 선언, 데이터 로딩 처리
/*
위 기준 sql 기능메서드 선언, 데이터 로팅처리
실행할 셜과가 여러 열에 걸쳐서 나오면
자바의 데이터 유형, 필드명을 지정..

String, int, double, date

class Member{
	private int mno;
	private String name;
	private String id;
	private String pwd;
	private String auth;
	private int point;
}

public Member getMember(String id){
	Member member = null;
	String sql = "SELECT * FROM member01 WHERE id='"+id+"'";
	if(rs.next()){
		member m01 = new Member(
			rs.getInt("mon"),
			rs.getString("name"),
			rs.getString("id"),
			rs.getString("pwd"),
			rs.getString("auth"),
			rs.getInt("point")
			==> Member()에 할당처리하고 return으로 최종 결과값을 받아오는거임
			// DB => sql => ResultSet => VO
		);
	}
	return member;
}
 * */


SELECT * FROM jobs WHERE JOB_ID = 'AD_VP';

/*
한 열을 기준으로 다중행 처리.
List<데이터유형>
*/
SELECT ename FROM emp WHERE DEPTNO =10;
/*
public List<String> getEnames(int deptno){
	List<String> enames = new ArrayList<String>();
	String sql = "SELECT ename FROM emp WHERE DEPTNO ="+deptno;
	while(rs.next()){
		enames.add(rs.getString(1));
		// 반복을 통해 계속 추가처리
	}
	return enames;
}
 * */

SELECT email FROM EMPLOYEES WHERE MANAGER_ID =101;

SELECT STREET_ADDRESS FROM LOCATIONS where country_id= upper('us') ;
/*
public List<String> getStreetAddress(String country_id){
	List<String> list = new ArrayList<String>();
	String sql = "SELECT STREET_ADDRESS FROM LOCATIONS where country_id= upper('"+country_id+"')";
	return list;
}
 * */
SELECT * FROM emp WHERE ename LIKE UPPER('%a%');

-- 다중열 ==> 열에 대한 클래스 선언
-- 다중행 ==> 행에대한 List 선언..

/*
# 다중행 다중열 : List<클래스명>
public List<Emp> getEmpList(String sch){
	List<Emp> empList = new ArrayList<Emp>();
	String sql = "SELECT * FROM emp WHERE ename LIKE UPPER('%"+sch+"%')";
	while(rs.next()){
		Emp emp = new Emp(
				rs.getInt("empno"), 
				rs.getString("ename"), 
				rs.getString("job"),
				rs.getInt("mgr"),
				rs.getDate("hiredate"), 
				rs.getDouble("sal"), 
				rs.getDouble("comm"),
				rs.getInt("deptno"));}
		empList.add(emp); // 한행의 여러개의 열을 객체에 담아서(while)
		// 행단위로 계속 추가 처리..
	return empList;
}
 * */

SELECT * FROM dept WHERE dname LIKE upper('%a%');

SELECT EMPLOYEE_ID , FIRST_NAME , EMAIL , SALARY  FROM EMPLOYEES WHERE SALARY BETWEEN  1000 AND 3000;


SELECT employee_id, first_name, email, salary FROM employees WHERE salary BETWEEN 1000 AND 2000;
/*
class Em
 * */

SELECT * FROM MEMBER01 WHERE id='himan' AND PWD =' OR 1=1';
SELECT * FROM MEMBER01 WHERE id='9999' AND PWD =' 'OR 1=1;
SELECT * FROM MEMBER01 WHERE id='9999' AND PWD ='' OR 3=3 --';
-- 아이디 몰라도 걍 암거나 집어넣고 pwd 에 ' OR 1=1 -- 집어넣으면 다됨

SELECT * FROM emp WHERE ename LIKE upper('%a%') 
AND job LIKE upper('%a%') AND deptno=30 ;
-- return List<Emp>
-- 매개변수 ename, job, deptno ==> Emp에 다 있는 애들 ==> Emp로 설정가능..

SELECT * 
	     FROM locations;
--	     WHERE STREET_ADDRESS LIKE ?
--	   AND city LIKE ?;

DROP TABLE emp01 ;
CREATE TABLE emp01 AS SELECT * FROM emp;
ALTER TABLE emp01 MODIFY (ename varchar(50), job varchar2(50));
INSERT INTO emp01 VALUES (1000,'홍길동','사원',7902,to_date('2023-11-15','YYYY-MM-DD'),3000,100,10);
INSERT INTO emp01 VALUES (1001,'김길동','사원',7902,to_date('2023-11-15','YYYY-MM-DD'),3000,100,10);
INSERT INTO emp01 VALUES (1002,'오길동','사원',7902,to_date('2023-11-15','YYYY-MM-DD'),3000,100,10);
/*
class EmpCU{
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredateStr;
	private double sal;
	private double comm;
	private int deptno;
} 

INSERT INTO emp01 VALUES (?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?);
 
 * */
-- 롤백 : 데이터를 등록/수정/삭제 시 commit하기전에는 현재계정에서 임시로 데이터 처리..
-- 	=> commit으로 확정되기 전에는 rollback이 된다. 
SELECT * FROM emp01;

SELECT * FROM DETP01 ;
INSERT INTO DETP01 values(50,'회계','서울');
-- INSERT INTO DETP01 values(?,?,?);
/*
기능 메서드 추가..
public int insertDept01(Dept ins){
	int deptInsCnt = 0;
	return deptInsCnt;
}
 * */

SELECT * FROM emp;
-- 직책명 , 입사분기 입력 검색시 사원번호 사원명 직책명 입사분기 입사일 
SELECT * FROM emp WHERE job LIKE upper('%a%') AND to_char(hiredate,'Q')=1; 
--SELECT * FROM emp WHERE job LIKE upper(?) AND to_char(hiredate,'Q')=?
SELECT to_char(hiredate,'Q') 입사분기 FROM emp;
-- EMP 테이블을 사용하여 @@@@/@@/@@ 부터 @@@@/@@/@@ 사이에 입사한 직원들의 목록을 조회하는 쿼리 작성
SELECT * FROM emp WHERE to_char(HIREDATE,'YYYY/MM/DD') BETWEEN '1980/12/17' AND '1981/04/02'; 

