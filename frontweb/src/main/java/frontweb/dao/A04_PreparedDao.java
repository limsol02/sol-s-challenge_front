package frontweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import frontweb.Dept;
import frontweb.Emp;
/*
import="frontweb.Emp"
import="frontweb.dao.A04_PreparedDao"
*/
public class A04_PreparedDao {
	
	
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public List<Emp> getEmpList() {
	    List<Emp> elist = new ArrayList<>();
	    String sql = "SELECT * FROM emp order by empno";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	
	        while (rs.next()) {
	            elist.add(new Emp(
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
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return elist;
	}
/*
SELECT * FROM emp
WHERE ename LIKE '%A%' 
 */
	

	public List<Emp> getEmpList(String ename) {
	    List<Emp> elist = new ArrayList<>();
	    String sql = "SELECT * FROM emp\r\n"
	    		+ "WHERE ename LIKE '%"+ename+"%' ";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	
	        while (rs.next()) {
	            elist.add(new Emp(
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
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return elist;
	}
	/*
	SELECT * FROM emp
	WHERE ename LIKE '%A%' 
	 */
		/*
SELECT *
FROM dept
WHERE dname LIKE '%S%'
		 * */
//	
//		public List<Dept> getDeptList(String dname) {
//		    List<Dept> elist = new ArrayList<Dept>();
//		    String sql = "SELECT *\r\n"
//		    		+ "FROM dept\r\n"
//		    		+ "WHERE dname LIKE '%"+dname+"%' ";
//		    
//		    try {
//		        con = DB.con();
//		        pstmt = con.prepareStatement(sql); 
//		        rs = pstmt.executeQuery();
//		
//		        while (rs.next()) {
//		            elist.add(new Dept(
//		                    rs.getInt("deptno"),
//		                    rs.getString("dname"),
//		                    rs.getString("loc")
//		            ));
//		        }
//		    } catch (SQLException e) {
//		        System.out.println("DB 관련 오류: " + e.getMessage());
//		    } catch (Exception e) {
//		        System.out.println("일반 오류: " + e.getMessage());
//		    } finally {
//		        DB.close(rs, pstmt, con);
//		    }
//		    return elist;
//		}


	public static void main(String[] args) {
		A04_PreparedDao dao = new A04_PreparedDao();
		System.out.println(dao.getEmpList().size());
		for(Emp emp:dao.getEmpList("A")) {
			System.out.print(emp.getEmpno()+"\t");
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getJob()+"\t");
			System.out.print(emp.getSal()+"\n");
		}
	}
	
	
}
