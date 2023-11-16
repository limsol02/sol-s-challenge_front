package frontweb.database.z01_homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import frontweb.database.DBCon;
import frontweb.database.z01_homework.vo.Emp04;

public class A1113 {
	private Connection con; // 1. 연결
	private Statement stmt; // 2. 대화
	private PreparedStatement pstmt; // 2. (보안걸린)대화
	private ResultSet rs; // 3. 결과

	// SELECT deptno ,count(*) cnt , AVG(sal) aSal FROM emp group by deptno
	public List<Emp04> getEmp04() {
		List<Emp04> elist = new ArrayList<Emp04>();
		String sql = "SELECT deptno ,count(*) cnt , AVG(sal) aSal FROM emp group by deptno";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				elist.add(new Emp04(rs.getInt("deptno"), rs.getInt("cnt"), rs.getDouble("aSal")));
			}
			System.out.println("데이터 건수 : "+elist.size());
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		return elist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A1113 dao = new A1113();
		for (Emp04 e01 : dao.getEmp04()) {
			System.out.print(e01.getDeptno() + "번 부서의 인원은 ");
			System.out.print(e01.getCnt() + "명이고, 평균 급여는 ");
			System.out.print(e01.getaSal() + "원 입니다.\n");

		}

		/*
		 * ==========================================================
		 * 
		 * # 처리순서 1. sql 작성 2. 입력 출력 구분 3. 입력 : 메서드의 매개변수 출력 : 메서드의 리턴유형 4. 메서드 위 내용을
		 * 구분해서 처리 1) 리턴할 데이터 2) sql 선언 5. 기본 연결 설정 부분 복사 6. resultSet객체 => rs.next(),
		 * rs.getXXX("컬럼명"),rs.getXXX(1) 유형에 맞춰서 if, while문 이용
		 * 
		 * [1단계:확인] 1.단일 열 및 단일 행 결과: --1. **최대 급여 조회**: SELECT max(sal) FROM emp; 어떤
		 * 데이터 출력타입 ==> SELECT max(sal) FROM emp 결과 : 5000(double) 컬럼명이 어떤 형태?
		 * rs.get타입유형("컬럼명")
		 * 
		 * public Double getMax() { double max = 0; String sql =
		 * "SELECT max(sal) FROM emp"; try { con = DBCon.con(); stmt =
		 * con.createStatement(); rs = stmt.executeQuery(sql); if(rs.next()) { // 행단위로
		 * 가져오기 max = rs.getDouble("max(sal)"); ==> sql 문에서 max(sal)을 애칭으로 msal이라고 했으면
		 * max = rs.getDouble("msal") 로 해도 상관없다. } } catch (SQLException e) {
		 * System.out.println("DB예외" + e.getMessage()); } catch (Exception e) {
		 * System.out.println("일반예외" + e.getMessage()); } finally { DBCon.close(rs,
		 * stmt, con); System.out.println("자원해제처리!"); } return max; }
		 * =============================================================================
		 * ================================ --2. **총 직원 수 계산**: SELECT count(*) FROM
		 * emp; public int getCnt() { int cnt = 0;
		 * 
		 * String sql = "SELECT count(*) c01 FROM emp"; try { con = DBCon.con(); stmt =
		 * con.createStatement(); rs = stmt.executeQuery(sql); if(rs.next()) { cnt =
		 * rs.getInt("c01"); } } catch (SQLException e) { System.out.println("DB예외" +
		 * e.getMessage()); } catch (Exception e) { System.out.println("일반예외" +
		 * e.getMessage()); } finally { DBCon.close(rs, stmt, con);
		 * System.out.println("자원해제처리!"); } return cnt; }
		 * ================================================================
		 * 
		 * --3. **평균 급여 계산**: SELECT avg(sal) asal FROM emp; 입력값 x(매개변수 넣을거) // 출력값 :
		 * 2077.08(실수 double타입) // 컬럼명 : asal public Double getAvgsal() { double avg =
		 * 0; String sql = "SELECT avg(sal) FROM emp"; try { con = DBCon.con(); stmt =
		 * con.createStatement(); rs = stmt.executeQuery(sql); if(rs.next()) { avg =
		 * rs.getDouble("asal"); } } catch (SQLException e) { System.out.println("DB예외"
		 * + e.getMessage()); } catch (Exception e) { System.out.println("일반예외" +
		 * e.getMessage()); } finally { DBCon.close(rs, stmt, con);
		 * System.out.println("자원해제처리!"); } return avg; }
		 * ============================================================ --4. **최소 급여
		 * 조회**: SELECT min(sal) FROM emp; public Double getMinsal() { double min = 0;
		 * String sql = "SELECT min(sal) FROM emp"; try { con = DBCon.con(); stmt =
		 * con.createStatement(); rs = stmt.executeQuery(sql); if(rs.next()) { min =
		 * rs.getDouble(1); } } catch (SQLException e) { System.out.println("DB예외" +
		 * e.getMessage()); } catch (Exception e) { System.out.println("일반예외" +
		 * e.getMessage()); } finally { DBCon.close(rs, stmt, con);
		 * System.out.println("자원해제처리!"); } return min; }
		 * =============================================================================
		 * ====================== --5. **부서 번호 @@의 총 직원 수**: SELECT count(*) FROM emp
		 * WHERE DEPTNO = 10; public int getCountByNo(int deptno) { int cnt = 0; String
		 * sql = "SELECT count(*) FROM emp WHERE DEPTNO = "+deptno; try { con =
		 * DBCon.con(); stmt = con.createStatement(); rs = stmt.executeQuery(sql);
		 * if(rs.next()) { cnt = rs.getInt(1); } } catch (SQLException e) {
		 * System.out.println("DB예외" + e.getMessage()); } catch (Exception e) {
		 * System.out.println("일반예외" + e.getMessage()); } finally { DBCon.close(rs,
		 * stmt, con); System.out.println("자원해제처리!"); } return cnt; }
		 * 
		 * 
		 * ============================================================================
		 * --[1단계:확인] 2.다중 열 및 단일 행 결과: --1. **전체 직원의 평균 급여와 총 급여**: SELECT avg(sal) ,
		 * sum(sal) FROM emp; public Emp01 getSal() { Emp01 avgSum = null; String sql =
		 * "SELECT AVG(sal), SUM(sal)\r\n" + "FROM EMP"; try { con = DBCon.con(); // 2.
		 * 대화처리 stmt = con.createStatement(); // 3. 결과 rs = stmt.executeQuery(sql); //
		 * 데이터가 있는지 여부만 가져오면 되기에 if(rs.next()) { avgSum = new Emp01(
		 * rs.getDouble("avg(sal)"), rs.getDouble("sum(sal)") ); } // 4. 예외와 자원해제
		 * 
		 * } catch (SQLException e) { System.out.println("DB 예외 : " + e.getMessage()); }
		 * catch (Exception e) { System.out.println("일반 예외 : " + e.getMessage()); }
		 * finally { // 자원해제(연결처리 후 사용한 객체들) DBCon.close(rs, stmt, con); }
		 * 
		 * return avgSum; }
		 * =============================================================================
		 * ================== --2. **직원이름 에서 일하는 직원의 이름과 입사일, SELECT ename, hiredate
		 * FROM emp WHERE ename LIKE upper('%a%'); public Emp02 getSchEname(String sch)
		 * { Emp02 e01 = null; String sql =
		 * "SELECT ename, hiredate FROM emp WHERE ename LIKE upper('%"+sch+"%')"; try {
		 * con = DBCon.con(); stmt = con.createStatement(); rs = stmt.executeQuery(sql);
		 * if(rs.next()) { e01 = new Emp02( rs.getString("ename"),
		 * rs.getDate("hiredate") ); } } catch (SQLException e) {
		 * System.out.println("DB예외" + e.getMessage()); } catch (Exception e) {
		 * System.out.println("일반예외" + e.getMessage()); } finally { DBCon.close(rs,
		 * stmt, con); System.out.println("자원해제처리!"); } return e01; }
		 * =========================================================================
		 * --[1단계:확인] 3. 단일 열 및 다중 행 결과: --1. **모든 부서의 부서 번호 목록**: SELECT deptno FROM
		 * emp; public List<Integer> getDeptno() { List<Integer> deptno = new
		 * ArrayList<Integer>(); String sql = "SELECT deptno FROM emp"; try { con =
		 * DBCon.con(); stmt = con.createStatement(); rs = stmt.executeQuery(sql);
		 * while(rs.next()) { // sql 결과가 행 단위로 여러개 나올 수 있을땐 while씀 deptno.add(
		 * rs.getInt("deptno") ); } system.out.println("현재 조회된 건수 : "+deptno.size()); }
		 * catch (SQLException e) { System.out.println("DB예외" + e.getMessage()); } catch
		 * (Exception e) { System.out.println("일반예외" + e.getMessage()); } finally {
		 * DBCon.close(rs, stmt, con); System.out.println("자원해제처리!"); } return deptno; }
		 * ===================================================================== --2.
		 * **@@@ 이상 급여를 받는 직원들의 이름**: SELECT ename FROM emp WHERE sal>2000; public
		 * List<String> getEname(int sal) { List<String> e01 = new ArrayList<String>();
		 * String sql = "SELECT ename FROM emp WHERE sal>"+sal; try { con = DBCon.con();
		 * stmt = con.createStatement(); rs = stmt.executeQuery(sql); while(rs.next()) {
		 * e01.add( rs.getString("ename") ); } } catch (SQLException e) {
		 * System.out.println("DB예외" + e.getMessage()); } catch (Exception e) {
		 * System.out.println("일반예외" + e.getMessage()); } finally { DBCon.close(rs,
		 * stmt, con); System.out.println("자원해제처리!"); } return e01; }
		 * =============================================================================
		 * ======= --3. **직책이 @@ 인 직원들의 이름**: SELECT ename FROM emp WHERE job LIKE
		 * upper('%m%'); public List<String> getEname(String sch) { List<String> e01 =
		 * new ArrayList<String>(); String sql =
		 * "SELECT ename FROM emp WHERE job LIKE upper('%"+sch+"%')"; try { con =
		 * DBCon.con(); stmt = con.createStatement(); rs = stmt.executeQuery(sql);
		 * while(rs.next()) { e01.add( rs.getString("ename") ); } } catch (SQLException
		 * e) { System.out.println("DB예외" + e.getMessage()); } catch (Exception e) {
		 * System.out.println("일반예외" + e.getMessage()); } finally { DBCon.close(rs,
		 * stmt, con); System.out.println("자원해제처리!"); } return e01; }
		 * =============================================================================
		 * ===================
		 * 
		 * --[1단계:확인] 4. 다중 열 및 다중 행 결과(vo는 개인폴드로 추가해서 만들기) ==> 다중열 : 클래스 필요, 다중행 : list
		 * 필요 ==> List<클래스명> 처리해야함.
		 * 
		 * 
		 * --1. **각 부서이름과 급여를 기준으로 직원의 이름, 직책, 급여**: SELECT ename, job, sal FROM emp
		 * WHERE job LIKE upper('%m%') AND sal>2000; public List<Emp03> getEmp03(String
		 * sch,int sal) { List<Emp03> e01 = new ArrayList<Emp03>(); String sql =
		 * "SELECT ename FROM emp WHERE job LIKE upper('%"+sch+"%') AND sal>"+sal; try {
		 * con = DBCon.con(); stmt = con.createStatement(); rs = stmt.executeQuery(sql);
		 * while(rs.next()) { e01.add(new Emp03( rs.getString("ename")
		 * rs.getString("job") rs.getDouble("sal") )); } } catch (SQLException e) {
		 * System.out.println("DB예외" + e.getMessage()); } catch (Exception e) {
		 * System.out.println("일반예외" + e.getMessage()); } finally { DBCon.close(rs,
		 * stmt, con); System.out.println("자원해제처리!"); } return e01; }
		 * =============================================================================
		 * ===================== --2. **각 직책별 평균 급여**: 
		 * SELECT job, avg(sal) avsal FROM emp GROUP BY job; 
		 * public List<Emp01> getEmp01() { List<Emp01> e01 = new
		 * ArrayList<Emp01>(); String sql ="SELECT job, avg(sal) avsal FROM emp GROUP BY job";
		 *  try { 
		 *  con = DBCon.con();
		 * stmt = con.createStatement(); 
		 * rs = stmt.executeQuery(sql); 
		 * while(rs.next()) {e01.add(new Emp01( rs.getString("job"), rs.getDouble("avsal") )); } } 
		 * catch (SQLException e) { System.out.println("DB예외" + e.getMessage()); } 
		 * catch (Exception e) { System.out.println("일반예외" + e.getMessage()); } 
		 * finally { DBCon.close(rs, stmt, con); System.out.println("자원해제처리!"); } return e01; }
		 * =============================================================================
		 * ==================== 
		 * --3. **각 부서의 직원 수 및 평균 급여**:public List<Emp04> getEmp04() {
		List<Emp04> elist = new ArrayList<Emp04>();
		String sql = "SELECT deptno ,count(*) cnt , AVG(sal) aSal FROM emp group by deptno";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				elist.add(new Emp04(rs.getInt("deptno"), rs.getInt("cnt"), rs.getDouble("aSal")));
			}
			System.out.println("데이터 건수 : "+elist.size());
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		return elist;
	}
		 * 
		 */
	}

}
