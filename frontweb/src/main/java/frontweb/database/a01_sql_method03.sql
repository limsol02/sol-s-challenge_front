SELECT empno, ename, job, sal FROM emp where sal BETWEEN 1000 AND 3000;
-- ResultSet rs
-- rs.next() : 테이블의 데이터를 행 단위로 호출(이동), 1번쨰 호출하면 1번째 ROW 호출 ==> 데이터가 있으면 true(boolean값)

-- 만약 rs.getInt("empno") : 7499 정수형으로 가져온다.
-- 	  rs.getString("ename") : "ALLEN" 문자열로 가져온다.
--	## rs.get데이터유형("컬럼명") ==> 열단위로 정보값을 가지고옴
--  ## rs.get데이터(1), rs.get데이터(2) ... 이런식으로 (idx)로 호출도 가능하다.

-- ?MANAGER rs.next() 5번 호출, rs.getString("job")
-- 10번째 rs.next() 호출하면 false

/*
 rs.next() 가 true일때 처리되게 로직 구성하려면
 for? if? while? 뭘쓸까? 
 while(rs.next()){
 	rs.getInt("empno")
 	...
 	rs.getDouble("sal")
 }

 * */
SELECT * FROM emp where empno = 7499; -- rs.next() 
/*
이런경우는 값이 하나만 있으면 되니까 굳~이 while문 아늤고
if(rs.next(){
	rs.getInt("empno")
	...
	rx.getDouble("sal")
} 로 처리가능

만약에 boolean값으로 받아들이고 싶으면
public boolean login(String id, String pwd){
	boolean isPass=false;
	String sql="select * from emp where id=? and pwd=?";
	while(rs.next()){
		if(rs.getString("id")!=null){
			isPass = true;
		}
	}
	위에 while문 다 필요없고 rs.next() 자체가 boolean값(데이터 있는지 없는지 t/f)
	걍 isPass=rs.next(); 로 끝낼수있긴함==> 진짜 간단한경우
	
	return isPass;	
}
 * */


--[1단계:확인] 1.단일 열 및 단일 행 결과:
--1. **최대 급여 조회**:
SELECT max(sal) FROM emp;
--2. **총 직원 수 계산**:
SELECT count(*) FROM emp;
--3. **평균 급여 계산**:
SELECT avg(sal) FROM emp;
--4. **최소 급여 조회**:
SELECT min(sal) FROM emp;
--5. **부서 번호 @@의 총 직원 수**:
SELECT count(*) FROM emp WHERE DEPTNO = 10;


--[1단계:확인] 2.다중 열 및 단일 행 결과:
--1. **전체 직원의 평균 급여와 총 급여**:
SELECT avg(sal) , sum(sal) FROM emp;
--2. **직원이름 에서 일하는 직원의 이름과 입사일,
SELECT ename, hiredate FROM emp WHERE ename LIKE upper('%a%');

/*
public Emp03 getNameHire(String sch){
	Emp03 e03 = null;
	String sql = "SELECT ename, hiredate FROM emp WHERE ename LIKE upper('%"+sch+"%')";
	try{
		con = DBCon.con();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			e03 = new Emp03(
				rs.getString("ename"),
				rs.getDate("hiredate")
			);
		}	
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
	return e03;
}
 * */
--[1단계:확인] 3. 단일 열 및 다중 행 결과:
--1. **모든 부서의 부서 번호 목록**:
SELECT deptno FROM emp;
--2. **@@@ 이상 급여를 받는 직원들의 이름**:
SELECT ename FROM emp WHERE sal>2000;
--3. **직책이 @@ 인 직원들의 이름**:

SELECT ename FROM emp WHERE job LIKE upper('%m%');
--[1단계:확인] 4. 다중 열 및 다중 행 결과(vo는 개인폴드로 추가해서 만들기)
--1. **각 부서이름과  급여를 기준으로 직원의 이름, 직책, 급여**: 
SELECT ename, job, sal FROM emp WHERE job LIKE upper('%m%') AND sal>2000;
--2. **각 직책별 평균 급여**:
SELECT avg(sal) FROM emp WHERE job LIKE upper('%m%');
--3. **각 부서의 직원 수 및 평균 급여**:
SELECT count(*) , AVG(sal) FROM emp WHERE job LIKE upper('%m%');


SELECT * FROM PENSION WHERE loc='가평'AND NUMBEROFPEOPLE = 6 AND 
to_char(CHECKIN,'YYYY-MM-DD')='2023-11-10';
SELECT deptno, avg(sal) avsal FROM emp WHERE deptno=30 group by deptno;

SELECT deptno ,count(*) cnt , AVG(sal) FROM emp group by deptno;


SELECT e.*, to_date(hiredate,'YYYY-MM-DD') hiredateStr
		           FROM emp01 e
		           WHERE empno=7499; 
		          
SELECT * FROM  emp01;

UPDATE emp01 
SET 
EMPNO = 1000,
ename ='김영희',
job = '대리',
mgr = 9999,
hiredate = TO_DATE('2023-11-01','YYYY-MM-DD') ,
sal = 3500,
comm = 200,
deptno =10 WHERE empno=6555;

/*
UPDATE emp01 
SET 
ename =?,
job =?,
mgr = ?,
hiredate = TO_DATE(?,'YYYY-MM-DD') ,
sal = ?,
comm = ?,
deptno =? 
WHERE empno=?
 * */

SELECT * FROM dept WHERE DEPTNO =10;
/*SELECT * FROM dept WHERE DEPTNO =?*/

CREATE TABLE dept01
AS SELECT * FROM dept;
SELECT * FROM dept01;

INSERT INTO dept01 VALUES(10, '홍길동', '서울');
/*INSERT INTO dept01 VALUES(?, ?, ?) */

	            
SELECT * FROM MEMBER01 ;

/* SELECT * FROM MEMBER01 WHERE mno=? */

INSERT INTO MEMBER01 VALUES (3,'최길동','heyee','7777','일반',2000);
/*INSERT INTO MEMBER01 VALUES (?,?,?,?,?,?)*/

UPDATE MEMBER01
SET 
name = '박길동', id='himan2', pwd='8888', auth='관리자', point=2500  WHERE mno=1;
