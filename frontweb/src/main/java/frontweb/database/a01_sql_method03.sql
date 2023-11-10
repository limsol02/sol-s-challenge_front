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










