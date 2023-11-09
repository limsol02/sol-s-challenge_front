/* 부서 번호 [  ] 해당하는 사원명 검색!
 *  그러면 이제
 *  사원명 
 *  @@@
 *  @@@ ...
 * 
 * 입력 : 부서번호 where deptno
 * 출력 : 사원명 select ename
 */
SELECT * FROM emp;
SELECT ename FROM emp WHERE DEPTNO =10;
/*
 ## 행이 여러개일떄는 List<데이터유형> 으로 써야함 ex/ int => Integer
 public List<String> getEname(int deptno){
 	List<String> enames = new ArrayList<String>();
 	String sql = "SELECT ename FROM emp WHERE DEPTNO ="+deptno;
 	return enames;
 }
 * */

-- 직책 : [   ] [사원번호 확인]
SELECT empno FROM emp WHERE job='CLERK';
/*
public List<Integer> getEmpno(String job){
	List<Integ er> en = new ArrayList<Integer>();
	String sql = "SELECT empno FROM emp WHERE job='"+job+"'";
	return en;
}
 * */
/*
사원번호 [  ] [사원정보확인]
### 사원정보 ###
사원명 : @@@
직책 : @@@
급여 : @@@
부서번호 : @@@
 * */
SELECT ename, job, sal, deptno FROM emp WHERE empno=7499;
--> 이건 단일 열인데 행이 많은경우 (타입이 많아서 객체로 지정은하지만, 열이 하나라 List까지 쓸 필요는 없다.)
/*
class EmpShow(){
	private String name;
	private String job;
	private double sal;
	private int deptno;
	// 디폴드생성자
	// 필드 생성자
	// set/get 메서드선언
}
-- 여러개의 컬럼이 있을 때는 클래스로 선언하여 처리한다.
public EmpShow gerEmpByEmpno(int empno){
	EmpShow es = null;
	String sql = "SELECT ename, job, sal, deptno FROM emp WHERE empno="+empno;
	return es;
}
 * */

-- 사원명 : [  ] [사원정보확인]
-- 사원번호 직책 급여 부서번호 
--  @@@  @@   @@  @@@
-- 위와같이 처리되는 sql과 메서드를 선언하세요.

SELECT empno, job, sal, deptno FROM emp WHERE ename='SMITH';

/*
class Emp01에 저거 다 필드넣고 생성자 1, 2 선언하고 겟셋 넣고

public Emp01 getEmpInfo(String ename){
	Emp01 e01 = null;
	String sql = "SELECT empno, job, sal, deptno FROM emp WHERE ename='"+ename+"'";
	return e01;
}
 * */


/*검색할 급여범위
 * [  ]~[  ] [사원정보검색]
 * List : 다중행
 * 클래스 : 다중열일때
 * List<클래스> : 다중행/다중열
 */
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 4000; 
/*
public List<Emp> getEmpList(double min, double max){
	List<Emp> empList = new ArrayList<Emp>();
	String sql="SELECT * FROM emp WHERE sal BETWEEN "+min+" AND "+max;
	return empList;
}
 * */

-- 부서번호 : [  ]
-- 직책 : [  ] [사원정보]

-- 사원번호 사원명 직책명 관리자번호 ...
-- @@@ ㄲ쭈루루루루ㅜ룩

SELECT * FROM emp WHERE DEPTNO = 10 AND job = 'SALESMAN';

/*
public List<Emp> EmpList (int deptno, String job){
	List<Emp> emp01 = new ArrayList<Emp>();
	String sql = "SELECT * FROM emp WHERE DEPTNO = "+deptno+" AND job = '"+job+"'";
	return emp01;
}
 * */




/*
[date]		[StartLoc]	[EndLoc] 	[StartTime] [EndTime]
2023-11-14	서울			대구			9			12
2023-11-14	서울			대구			10			13
2023-11-14	서울			대구			11			14
2023-11-14	서울			대구			12			15

==> 예약 처리했을 데이터가 예약입력되는 처리
1. 테이블 생성
	create reservation(
		rno		number,
		resdate date,
		startloc varchar2(50),
		endloc	varchar2(50),
		starttime number(2,0),
		endtime number(2,0)
	);
	
2. 데이터 입력
# 예약리스트 조회
3. 조회 sql작성
 select * from reservation;

4. VO 객체 작성
5. 기능메서드 선언.
# 예약 처리
6. 입력 sql 작성
INSERT INTO reservation VALUES (res_seq.nextval,
	to_date('2023-11-18','YYYY-MM-DD'),
	'서울','대구',11,14
);

7. 기능메서드 선언
public void inserReservation(Resevation ins){
	String sql="";
}

 * */

-- 1. 테이블생성
create TABLE reservation(
		rno		number,
		resdate date,
		startloc varchar2(50),
		endloc	varchar2(50),
		starttime number(2,0),
		endtime number(2,0)
	);
SELECT * FROM reservation;

-- 2. 데이터입력
CREATE SEQUENCE res_seq; -- > 자동 넘버링 해주는 오라클 객체
INSERT INTO reservation VALUES (res_seq.nextval,
	to_date('2023-11-13','YYYY-MM-DD'),
	'서울','대구',9,12
);
INSERT INTO reservation VALUES (res_seq.nextval,
	to_date('2023-11-12','YYYY-MM-DD'),
	'서울','대구',10,13
);
INSERT INTO reservation VALUES (res_seq.nextval,
	to_date('2023-11-18','YYYY-MM-DD'),
	'서울','대구',11,14
);

-- 3. 날짜별 검색 sql
select * from reservation WHERE to_char(resdate,'YYYY-MM-DD') = '2023-11-14';

--4. VO작성
/*
 class reservation {
 	private int rno;
 	private Date resdate;
 	private String startloc;
 	private String endloc;
 	private int starttime;
 	private int endtime;
 }
 * */

-- 5. 기능메서드 처리
/*
public List<Reservation> getResListByDate(String date){
	List<Reservation> rlist = new ArrayListList<Reservation>();
	String sql = "select * from reservation WHERE to_char(resdate,'YYYY-MM-DD') = '"+date+"'";
	return rlist;
}
 * */

-- 날짜별 예약 리스트르 보고 예약 처리하는 구조
-- 날짜별 예약 내용
-- 검색할 날짜 [ ]

/*
출발역 : [ ] 도착역 : [ ]
리스트내용 
[열차번호] [열차종류] [출발역] [도착역] [좌석정보] [가격] [소요시간]
1. 테이블생성
2. 기본데이터 입력
3. sql 작성
4. VO클래스 선언
5. 기능메서드 선언
 * */
CREATE TABLE trainschedule(
	tno char(20),
	ttype varchar2(50),
	departstation varchar2(50),
	arrivalstation varchar2(50),
	seatinfo varchar2(20),
	price NUMBER,
	duration number(3,1)
);

/*
private String tno;
private String ttype;
private String departstation;
private String arrivalstation;
private String seatinfo;
private int price;
private double duration;

public List<trainschedule> getList(String dpart, String arri){
	List<trainschedule> list = new ArrayList<trainschedule>();
	String sql="";
	return list;
}
 * */
INSERT INTO trainschedule VALUES ('KR10000001','KTX','서울','대전','A01',30000,1.5);
INSERT INTO trainschedule VALUES ('KR10000002','새마을','서울','부산','A01',50000,4.5);
SELECT * FROM trainschedule WHERE departstation='서울' AND arrivalstation='부산';







