SELECT * FROM emp WHERE ename LIKE '%A%';
-- 리턴할 객체 List<Emp>	getList(String name)
/*
private int empno;
private String ename;
private String job;
private int mgr;
private Date hiredate;
private double sal;
private double comm;
private int deptno;
 */

-- ex) 위 구문 처리할 때 메서드 선언..
SELECT max(sal) FROM emp WHERE deptno=10;
-- public double getMax(int deptno){double max = 0; return max;}

SELECT ename FROM emp where empno = 7369;
-- public String getEname(int empno){String ename=""; return ename}

SELECT hiredate FROM emp WHERE ename = 'SMITH';
-- public Date getHiredate(String ename){Date hire=null; return hire;}

SELECT empno, ename, job FROM emp WHERE empno=7369;
-- empno, ename, job 데이터 유형 확인
-- int 	  String String 
-- ==> VO 처리 필수(여러개의 열 인경우)
/* 
 public EmpShort getEmpSht(int empno){ EmpShort es =null; return es;}
기존의 Emp안에 포함되어 있다면, 추가할 필요 없이 재활용 가능
 class EmpShort{
 	private int empno;
 	private String ename;
 	private String job;
 	//1. 기본생성자 2.매개변수생성자 3.set/get메서드 선언..
 	}
 * */

SELECT count(*) FROM DEPT d WHERE deptno=10;
-- public int getCount(int deptno){int cnt=0; return cnt;}

SELECT * FROM dept WHERE dname='ACCOUNTING';
--  public class Dept{
--		private int deptno;
-- 		private String dname;
-- 		private String loc;
-- 		밑에 이제 생성자1,2 set/get 넣기}
-- pubulic Dept getDetp(String dname){Dept d01=null; return d01;}

/* 한개의 열에 여러 행이 있는 리턴값, 입력값은 2개(숫자형) */
SELECT ename FROM emp WHERE sal BETWEEN 1000 AND 2000;
/*
## List<데이터유형>
==> List<String>, List<Integer>, List<Double>, List<Date>
public List<String> getEnames(int start, tne end){}
 * */

SELECT sal FROM emp WHERE deptno=10;
/*
 public List<Double> getSal(int deptno){
		List<Double> sal = new ArrayList<Double>();
		String sql = "SELECT sal FROM emp WHERE deptno="+deptno+"";
		return sal;
	}
 * */

SELECT * FROM emp WHERE sal BETWEEN 1000 AND 3000;
/*
public List<Emp> getEmpList(int start, int end){
	List<Emp> emplist = new ArrayList<Emp>();
	String sql="SELECT * FROM emp WHERE sal BETWEEN "+start+" AND "+end+"";
	return emplist;
}
 * */
SELECT * FROM dept WHERE dname LIKE '%S%';
/*
- 행이 여러개인지? List(여러개)
- 열이 여러개인지? 단일타입 String/int/double=2단계 + 객체 클래스선언


 public List<Dept> getDList(String dname){
 	List<Dept> dlist = new ArrayList<Dept>();
 	String sql = "SELECT * FROM dept WHERE dname LIKE '%"+dname+"%'";
 	return dlist;
 }
 * */
CREATE TABLE MEMBER01(
	mno NUMBER,
	name varchar2(50),
	id varchar2(50),
	pwd varchar2(30),
	auth varchar2(20),
	point NUMBER );

/*
class Member{
	private int mno;
	private String name;
	private String id;
	private String pwd;
	private String auth;
	private int point;
}
 * */

SELECT * FROM member01;

INSERT INTO member01 values(1,'홍길동','himan','7777','admin',1000);
INSERT INTO member01 values(2,'김길동','goodman','7777','normal',2000);
/*

 * */

-- 회원가입
/*
INSERT INTO member01 values(1,'홍길동','himan','7777','admin',1000);
public void insertMember(Member ins){}
 * */
-- 회원리스트확인
SELECT * FROM member01 WHERE name LIKE '%길동%';
/*
 SELECT * FROM member01 WHERE name LIKE '%길동%';
 public List<Member> schMember(String nameSch)
 * */
-- 로그인처리
SELECT * FROM member01;
SELECT * FROM MEMBER01 WHERE id = 'himan' AND pwd='7777';

-- 입력값을 id와 pwd 입력처리, 리턴할 내용을 Member 객체로 리턴








