package frontweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import frontweb.database.DBCon;
import frontweb.vo.EmpDTO;

public class Template {

	// 1. stmt 탬플릿
	
/*
	
	private Connection con; // 1. 연결
	private Statement stmt; // 2. 대화
	private PreparedStatement pstmt; // 2. (보안걸린)대화
	private ResultSet rs; // 3. 결과
	
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
*/
	
	// 2. pstmt 탬플릿
	
	/*
	 
	  public Object template(String dname) {
		Object ob = new Object();
		String sql = "select deptno, dname, loc from dept where dname like ?";
		try (Connection con = DBCon.con();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 내가 처리할 처리코드 1
			pstmt.setString(1, "");
			try (ResultSet rs = pstmt.executeQuery();) {
				// 내가 처리할 처리코드2
				rs.next();
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러 : " + e.getMessage());
		}
		return ob;
	}
	 
	 * */
	
	// 3. 등록 탬플릿
	
	/*
	 public int insertEmp01(EmpDTO ins) {
		int insCnt = 0;
		String sql = "INSERT INTO emp VALUES (?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?)";
		try (Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
				con.setAutoCommit(false);
			// 내가 처리할 처리코드 1
				pstmt.setInt(1,ins.getEmpno());
				pstmt.setString(2,ins.getEname());
				pstmt.setString(3,ins.getJob());
				pstmt.setInt(4,ins.getMgr());
				pstmt.setString(5,ins.getHiredateStr());
				pstmt.setDouble(6,ins.getSal());
				pstmt.setDouble(7,ins.getComm());
				pstmt.setInt(8,ins.getDeptno());
				
				insCnt = pstmt.executeUpdate();
				
				con.commit();
			} catch (SQLException e) {
				System.out.println("DB에러 : " + e.getMessage());
				//con.rollback;
			} catch (Exception e) {
				System.out.println("일반에러 : " + e.getMessage());
			}
		return insCnt;
	}
	 * */
}
