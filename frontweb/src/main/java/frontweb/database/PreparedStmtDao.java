package frontweb.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import frontweb.Dept;
import frontweb.Emp;
import frontweb.vo.EmpDTO;
import frontweb.vo.Member;
/* 
 import="frontweb.database.PreparedStmtDao"
 import="frontweb.Emp" 
 */
public class PreparedStmtDao {

//============복사용==============================================================
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
//=============복사용===========================================================

	public List<Dept> getDeptList(String dname) {
		List<Dept> dlist = new ArrayList<Dept>();
		String sql = "select deptno, dname, loc from dept where dname like  ?";
		// try(객체처리){} : try resource 구문 파일이나 DB연결 자동 자원해제..
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, "%" + dname + "%");
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					dlist.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
				}
				System.out.println("데이터 건수 : " + dlist.size());
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러 : " + e.getMessage());
		}
		return dlist;
	}

	/*SELECT * FROM emp WHERE ename LIKE ? AND job LIKE ? AND deptno=? */
	public List<Emp> getEmpList(Emp sch){
		List<Emp> empList = new ArrayList<Emp>();
		String sql = "SELECT * FROM emp01 WHERE ename LIKE ? AND job LIKE ? AND deptno=?";
		try (Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
				// 내가 처리할 처리코드 1
				pstmt.setString(1, "%" + sch.getEname() + "%");
				pstmt.setString(2, "%" + sch.getJob() + "%");
				pstmt.setInt(3, sch.getDeptno());
				try (ResultSet rs = pstmt.executeQuery();) {
					// 내가 처리할 처리코드2
					while(rs.next()) {
						empList.add(new Emp(
							rs.getInt("empno"),
							rs.getString("ename"),
							rs.getString("job"),
							rs.getInt("mgr"),
							rs.getDate("hiredate"),
							rs.getDouble("sal"),
							rs.getDouble("comm"),
							rs.getInt("deptno")
								));
					}
				System.out.println("데이터 건수 : "+empList.size());
				}
			} catch (SQLException e) {
				System.out.println("DB에러 : " + e.getMessage());
			} catch (Exception e) {
				System.out.println("일반에러 : " + e.getMessage());
			}
		
		return empList;
	}
	
	public List<Dept> getDeptList(String dname, String loc) {
		List<Dept> dlist = new ArrayList<Dept>();
		String sql = "select deptno, dname, loc from dept01 where dname like ? and loc like ?";
		// try(객체처리){} : try resource 구문 파일이나 DB연결 자동 자원해제..
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, "%" + dname + "%");
			pstmt.setString(2, "%" + loc + "%");
			
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					dlist.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
				}
				System.out.println("데이터 건수 : " + dlist.size());
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러 : " + e.getMessage());
		}
		return dlist;
	}

	public Member getMember(String id) {
		Member mem = null;
		String sql = "SELECT * FROM member01 WHERE id = ?";
		try (Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
				// 내가 처리할 처리코드 1
				pstmt.setString(1, id);
				try (ResultSet rs = pstmt.executeQuery();) {
					if (rs.next()) {
						mem = new Member(
								rs.getInt("mno"),
								rs.getString("name"),
								rs.getString("id"), 
								rs.getString("pwd"),
								rs.getString("auth"), 
								rs.getInt("point"));
					}
				}
			} catch (SQLException e) {
				System.out.println("DB에러 : " + e.getMessage());
			} catch (Exception e) {
				System.out.println("일반에러 : " + e.getMessage());
			}
		return mem;
	}
	
	//INSERT INTO emp01 VALUES (?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?)
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
	
	public List<Emp> getEmpList02(int deptno){
		List<Emp> empList = new ArrayList<Emp>();
		String sql = "SELECT * FROM emp WHERE deptno=?";
		try (Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
				// 내가 처리할 처리코드 1
				pstmt.setInt(1, deptno);
				try (ResultSet rs = pstmt.executeQuery();) {
					// 내가 처리할 처리코드2
					while(rs.next()) {
						empList.add(new Emp(
							rs.getInt("empno"),
							rs.getString("ename"),
							rs.getString("job"),
							rs.getInt("mgr"),
							rs.getDate("hiredate"),
							rs.getDouble("sal"),
							rs.getDouble("comm"),
							rs.getInt("deptno")
								));
					}
				System.out.println("데이터 건수 : "+empList.size());
				}
			} catch (SQLException e) {
				System.out.println("DB에러 : " + e.getMessage());
			} catch (Exception e) {
				System.out.println("일반에러 : " + e.getMessage());
			}
		
		return empList;
	}
	
	//SELECT * FROM emp WHERE job LIKE upper(?) AND to_char(hiredate,'Q')=?
	public List<Emp> getEmpList03(String job, int date){
		List<Emp> empList = new ArrayList<Emp>();
		String sql = "SELECT * FROM emp WHERE job LIKE ? AND to_char(hiredate,'Q')=?";
		try (Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
				// 내가 처리할 처리코드 1
				pstmt.setString(1, "%" + job + "%");
				pstmt.setInt(2, date);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					// 내가 처리할 처리코드2
					while(rs.next()) {
						empList.add(new Emp(
							rs.getInt("empno"),
							rs.getString("ename"),
							rs.getString("job"),
							rs.getInt("mgr"),
							rs.getDate("hiredate"),
							rs.getDouble("sal"),
							rs.getDouble("comm"),
							rs.getInt("deptno")
								));
					}
				System.out.println("데이터 건수 : "+empList.size());
				}
			} catch (SQLException e) {
				System.out.println("DB에러 : " + e.getMessage());
			} catch (Exception e) {
				System.out.println("일반에러 : " + e.getMessage());
			}
		
		return empList;
	}
	
	
	// SELECT * FROM emp WHERE to_char(HIREDATE,'YYYY/MM/DD') BETWEEN ? AND ?
	
	public List<Emp> getEmpList04(String start, String end){
		List<Emp> empList = new ArrayList<Emp>();
		String sql = "SELECT * FROM emp WHERE to_char(HIREDATE,'YYYY/MM/DD') BETWEEN ? AND ?";
		try (Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
				// 내가 처리할 처리코드 1
				pstmt.setString(1, start);
				pstmt.setString(2, end);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					// 내가 처리할 처리코드2
					while(rs.next()) {
						empList.add(new Emp(
							rs.getInt("empno"),
							rs.getString("ename"),
							rs.getString("job"),
							rs.getInt("mgr"),
							rs.getDate("hiredate"),
							rs.getDouble("sal"),
							rs.getDouble("comm"),
							rs.getInt("deptno")
								));
					}
				System.out.println("데이터 건수 : "+empList.size());
				}
			} catch (SQLException e) {
				System.out.println("DB에러 : " + e.getMessage());
			} catch (Exception e) {
				System.out.println("일반에러 : " + e.getMessage());
			}
		
		return empList;
	}
	
// new EmpDTO(1003,"하길동","대리",7799,"2023-11-01",3500,1000,20)
	// dao.insertEmp01(new EmpDTO(1003,"하길동","대리",7799,"2023-11-01",3500,1000,20));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparedStmtDao dao = new PreparedStmtDao();
	int insCnt = dao.insertEmp01(new EmpDTO(1006,"전길동","대리",7777,"2023-11-16",5500,1000,20));
	System.out.println(insCnt>0 ? "등록성공":"등록실패");
	
//		for(Emp e : dao.getEmpList04("1980/12/17","1981/04/02")) {
//			System.out.print(e.getEmpno()+"\t");
//			System.out.print(e.getEname()+"\t");
//			System.out.print(e.getDeptno()+"\n");
//		}
}
}