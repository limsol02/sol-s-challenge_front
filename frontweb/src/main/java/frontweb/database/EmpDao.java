package frontweb.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frontweb.Dept;
import frontweb.vo.EmpShort;
import frontweb.vo.Jobs;
import frontweb.vo.Member;
import frontweb.vo.Reservation;

public class EmpDao {
	// 공통으로 사용할 전역 객체 선언
	private Connection con; // 1. 연결
	private Statement stmt; // 2. 대화
	private PreparedStatement pstmt; // 2. (보안걸린)대화
	private ResultSet rs; // 3. 결과

//=================복사용========================================================
	public Object template01(Object sch) {
		Object ob = false;
		String sql = "sql";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		return ob;
	}
//===========================================================================
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
		String sql = "Select empno, ename, job from emp where empno=" + empno;
		try {
			// 1. 연결처리 ? 필드에 선언된 connection 객체를 con = DBConn에 할당
			con = DBCon.con();
			// 2. 대화처리
			stmt = con.createStatement();
			// 3. 결과처리
			rs = stmt.executeQuery(sql);
			// 데이터가 있는지 여부만 가져오면 되기에
			if (rs.next()) {
				// ResultSet 객체 안에 있는 데이터를 메서드를
				// 이용해서 EmpShort객체로 할당
				se = new EmpShort(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"));
			}
			// + 예외처리
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			// 4. 자원해제(연결처리 후 사용한 객체들)
			DBCon.close(rs, stmt, con);
		}
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
			if (rs.next())
				cnt = rs.getInt(1);
			// 위 커리문은 절대 null값이 안나오고 0이라도 나오는거라 그냥 rs.next()만 써주면됨
			// 습관들이기 용으로 단일검색if써주는것도 ㄱㅊ

			// 4. 자원해제
		} catch (SQLException e) {
			System.out.println("DB연결 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
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
			if (rs.next())
				cnt = rs.getInt(1);
			// 위 커리문은 절대 null값이 안나오고 0이라도 나오는거라 그냥 rs.next()만 써주면됨
			// 습관들이기 용으로 단일검색if써주는것도 ㄱㅊ

			// 4. 자원해제
		} catch (SQLException e) {
			System.out.println("DB연결 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
		}

		return cnt;
	}

	// SELECT max(sal) FROM emp WHERE deptno=40;
	public double getMax(int deptno) {
		double max = 0;
		String sql = "SELECT max(sal) FROM emp WHERE deptno=" + deptno;
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			max = rs.getDouble(1);
		} catch (SQLException e) {
			System.out.println("DB연결 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		} finally {
			DBCon.close(con, rs, stmt);
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
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sal.add(rs.getDouble("sal"));
			}
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
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

	/*
	 * select * from member01 where id = 'himan' and pwd = '777' 회원로그인 성공여부 확인
	 * 기능메서드..
	 */
	public boolean loginSucc(String id, String pwd) {
		boolean isLogSucc = false;
		String sql = "select * from member01 where id = '" + id + "' and pwd = '" + pwd + "'";
		try {
			// 1. 연결처리 ? 필드에 선언된 connection 객체를 con = DBConn에 할당
			con = DBCon.con();
			// 2. 대화처리
			stmt = con.createStatement();
			// 3. 결과처리
			rs = stmt.executeQuery(sql);
			// 데이터가 있는지 여부만 가져오면 되기에
			isLogSucc = rs.next();
			// + 예외처리
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			// 4. 자원해제(연결처리 후 사용한 객체들)
			DBCon.close(rs, stmt, con);
		}

		return isLogSucc;
	}

	/*
	 * SELECT * FROM DEPT WHERE deptno=10 if(rs.next()) { // ResultSet 객체 안에 있는 데이터를
	 * 메서드를 // 이용해서 EmpShort객체로 할당 se = new EmpShort( rs.getInt("empno"),
	 * rs.getString("ename"), rs.getString("job") );
	 */
	public Dept getDeptno(int deptno) {
		Dept d01 = null;
		String sql = "SELECT * FROM DEPT WHERE deptno=" + deptno;
		try {
			// 1. 연결처리 ? 필드에 선언된 connection 객체를 con = DBConn에 할당
			con = DBCon.con();
			// 2. 대화처리
			stmt = con.createStatement();
			// 3. 결과처리
			rs = stmt.executeQuery(sql);
			// 데이터가 있는지 여부만 가져오면 되기에
			if (rs.next()) {
				d01 = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			}
			// + 예외처리
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			// 4. 자원해제(연결처리 후 사용한 객체들)
			DBCon.close(rs, stmt, con);
		}
		return d01;
	}

	public Member getMember(String id) {
		Member m01 = null;
		String sql = "SELECT * FROM member01 WHERE id='" + id + "'";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				m01 = new Member(
						rs.getInt("mno"),
						rs.getString("name"),
						rs.getString("id"), 
						rs.getString("pwd"),
						rs.getString("auth"), 
						rs.getInt("point"));
			}
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
		}
		return m01;
	}

	public Jobs getjob(String id) {
		Jobs job = null;
		String sql = "SELECT * FROM jobs WHERE JOB_ID = '" + id + "'";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				job = new Jobs(
						rs.getString("job_id"),
						rs.getString("job_title"),
						rs.getInt("min_salary"),
						rs.getInt("max_salary"));
			}
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
		}
		return job;
	}
	/*
	 * private int empno; private String ename; private String job; private int mgr;
	 * private Date hiredate; private double sal; private double comm; private int
	 * deptno;
	 */

	public List<String> getEnames(int deptno) {
		List<String> enames = new ArrayList<String>();
		String sql = "SELECT ename FROM emp WHERE DEPTNO =" + deptno;
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// 다중행이 있을 때는 while문으로 행처리 단위로 가져온다.
			while (rs.next()) {
				// rs.getString(1) : select 문의 첫번째 문자열 데이터 가져오기
				enames.add(rs.getString(1));
				// 선언한 List<String>에 추가.
			}
			System.out.println("데이터건수 : " + enames.size());

		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		return enames;
	}

	public List<String> getEmployee(int manager_id) {
		List<String> e01 = new ArrayList<String>();
		String sql = "SELECT email FROM EMPLOYEES WHERE MANAGER_ID =" + manager_id;
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				e01.add(rs.getString("email"));
			}
			System.out.println("데이터 건수 : " + e01.size());
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		return e01;
	}

	// ===========================================================================================

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 기능메서드 잘 되어있는지 테스트 갑니다잉
		EmpDao dao = new EmpDao();
		System.out.println("매니저아이디별 이메일 : " + dao.getEmployee(101));

		System.out.println("부서번호별 연봉 정보 : " + dao.getSal(10));

		for (String ename : dao.getEnames(30)) {
			System.out.println(ename);
		}
		System.out.println("10번 부서 이름 : " + dao.getEnames(10));

		Jobs job = dao.getjob("AD_VP");
//		if(job!=null) {
//			System.out.println(job.getJob_id());
//			System.out.println(job.getJob_title());
//			System.out.println(job.getMin_salary());
//			System.out.println(job.getMax_salary());
//		}else {
//			System.out.println("데이터없음");
//		}

		Member m01 = dao.getMember("himan");
//		if(m01!=null) {
//			System.out.print(m01.getMno()+"\t");
//			System.out.print(m01.getName()+"\t");
//			System.out.print(m01.getId()+"\t");
//			System.out.print(m01.getPwd()+"\t");
//			System.out.print(m01.getAuth()+"\t");
//			System.out.print(m01.getPoint()+"\n");
//		}else {
//			System.out.println("데이터없음");
//		}

		Dept d01 = dao.getDeptno(10);
//		if(d01!=null) {
//			System.out.println(d01.getDeptno());
//			System.out.println(d01.getDname());
//			System.out.println(d01.getLoc());
//		}else {
//			System.err.println("데이터없음");
//		}

		EmpShort es = dao.getEmpShort(7499); // empno값에 따라 확인
//		if(es!=null) {
//			System.out.println("데이터 있음");
//			System.out.println(es.getEmpno());
//			System.out.println(es.getEname());
//			System.out.println(es.getJob());
//		}else {
//			System.out.println("데이터 없음");
//		}

//		System.out.println("사원 정보의 수 : "+dao.getEmpCount01());
//		System.out.println("부서별 최고급여 : "+dao.getMax(10));
//		System.out.println("성공여부 1 : "+dao.loginSucc("himan","7777"));
//		System.out.println("성공여부 2 : "+dao.loginSucc("himan","8888"));
//		System.out.println("성공여부 3 : "+dao.loginSucc("goodman","7777"));

	}

}
