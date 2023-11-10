package frontweb.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import frontweb.Dept;
import frontweb.vo.EmpShort;
import frontweb.vo.Member;
import frontweb.vo.Reservation;

public class EmpDao {
	// 공통으로 사용할 전역 객체 선언
	private Connection con; // 1. 연결
	private Statement stmt; // 2. 대화
	private PreparedStatement pstmt; // 2. (보안걸린)대화
	private ResultSet rs; // 3. 결과
	// 각 기능별 메서드 처리.

	// 1단계
	// select count(*) from emp;
	public int getEmpCount() {
		int cnt = 0;
		String sql = "select count(*) from emp";
		return cnt;
	}

	public EmpShort getEmpShort(int empno) {
		EmpShort se = null;
		String sql = "";
		return se;
	}
	
	public int getEmpCount01() {
		int cnt = 0;
		String sql = "SELECT count(*) FROM DEPT WHERE deptno= 10";
		// 1. 연결객체 선언
		try {
			con = DBCon.con();
			// 2. 대화객체 선언
			stmt = con.createStatement();
			// 3. 결과
			rs = stmt.executeQuery(sql);
			// "SELECT count(*) FROM DEPT WHERE deptno=" + deptno + ""; ==> 단일검색문
			if(rs.next()) cnt = rs.getInt(1);
			// 위 커리문은 절대 null값이 안나오고 0이라도 나오는거라 그냥 rs.next()만 써주면됨
			// 습관들이기 용으로 단일검색if써주는것도 ㄱㅊ
			
			// 4. 자원해제
		} catch (SQLException e) {
			System.out.println("DB연결 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		} finally {
			DBCon.close(rs,stmt,con);
		}

		return cnt;
	}
	

	/* SELECT count(*) FROM DEPT d WHERE deptno=10; */
	public int getCount(int deptno) {
		int cnt = 0;
		String sql = "SELECT count(*) FROM DEPT WHERE deptno=" + deptno + "";
		// 1. 연결객체 선언
		try {
			con = DBCon.con();
			// 2. 대화객체 선언
			stmt = con.createStatement();
			// 3. 결과
			rs = stmt.executeQuery(sql);
			// "SELECT count(*) FROM DEPT WHERE deptno=" + deptno + ""; ==> 단일검색문
			if(rs.next()) cnt = rs.getInt(1);
			// 위 커리문은 절대 null값이 안나오고 0이라도 나오는거라 그냥 rs.next()만 써주면됨
			// 습관들이기 용으로 단일검색if써주는것도 ㄱㅊ
			
			// 4. 자원해제
		} catch (SQLException e) {
			System.out.println("DB연결 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		} finally {
			DBCon.close(rs,stmt,con);
		}

		return cnt;
	}
	
	//SELECT max(sal) FROM emp WHERE deptno=40;
	public double getMax(int deptno){
		double max = 0; 
		String sql = "SELECT max(sal) FROM emp WHERE deptno="+deptno;
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next(); max = rs.getDouble(1);
		} catch (SQLException e) {
			System.out.println("DB연결 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		}finally{
			DBCon.close(con,rs,stmt);
		}
		return max;
		}
	
	
	

	// SELECT ename FROM emp WHERE sal BETWEEN 1000 AND 2000;

	public List<String> getEnames(int start, int end) {
		List<String> enames = new ArrayList<String>();
		String sql = "SELECT ename FROM emp WHERE sal BETWEEN " + start + " AND " + end + "";
		return enames;
	}

	public List<Double> getSal(int deptno) {
		List<Double> sal = new ArrayList<Double>();
		String sql = "SELECT sal FROM emp WHERE deptno=" + deptno + "";
		return sal;
	}

	public List<Dept> getDList(String dname) {
		List<Dept> dlist = new ArrayList<Dept>();
		String sql = "SELECT * FROM dept WHERE dname LIKE '%" + dname + "%'";
		return dlist;
	}

	/*
	 * ### 회원가입 기능 ### - 주의) sql 문자열 숫자
	 * 
	 * INSERT INTO member01 values(1,'홍길동','himan','7777','admin',1000);
	 */
	public void insertMember(Member ins) {
		String sql = "INSERT INTO member01 values(" + ins.getMno() + ",'" + ins.getName() + "'" + ",'" + ins.getId()
				+ "','" + ins.getPwd() + "','" + ins.getAuth() + "'," + ins.getPoint() + ")";
	}

	/*
	 * SELECT * FROM member01 WHERE name LIKE '%길동%'; public List<Member>
	 * schMember(String nameSch)
	 */
	public List<Member> schMember(String nameSch) {
		List<Member> mlist = new ArrayList<Member>();
		String src = "SELECT * FROM member01 WHERE name LIKE '%" + nameSch + "%'";
		return mlist;
	}

	public List<Reservation> getResListByDate(String date) {
		List<Reservation> rlist = new ArrayList<Reservation>();
		String sql = "select * from reservation WHERE to_char(resdate,'YYYY-MM-DD') = '" + date + "'";
		return rlist;
	}

	/*
	 * INSERT INTO reservation VALUES (res_seq.nextval,
	 * to_date('2023-11-13','YYYY-MM-DD'), '서울','대구',9,12 );
	 */
	public void inserReservation(Reservation ins) {
		String sql = "INSERT INTO reservation VALUES (res_seq.nextval,\r\n" + "	to_date('" + ins.getResdate()
				+ "','YYYY-MM-DD'),\r\n" + "	'" + ins.getStartloc() + "','" + ins.getEndloc() + "',"
				+ ins.getStarttime() + "," + ins.getEndtime() + "\r\n" + ")";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 기능메서드 잘 되어있는지 테스트 갑니다잉
		EmpDao dao = new EmpDao();
		System.out.println("사원 정보의 수 : "+dao.getEmpCount01());
		System.out.println("부서별 최고급여 : "+dao.getMax(10));
		
	}

}
