package frontweb.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import frontweb.Dept;
import frontweb.Emp;
import frontweb.vo.Employee;

public class ExpDao {
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

//===================================================================================
	public List<String> getStreetAddress(String country_id) {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT STREET_ADDRESS FROM LOCATIONS where country_id= upper('" + country_id + "')";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString("STREET_ADDRESS"));
			}
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		return list;
	}

	/*
	 * private int empno; private String ename; private String job; private int mgr;
	 * private Date hiredate; private double sal; private double comm; private int
	 * deptno;
	 */
	
	
	public List<Emp> getEmpList(String sch) {
		List<Emp> empList = new ArrayList<Emp>();
		String sql = "SELECT * FROM emp01 WHERE ename LIKE UPPER('%" + sch + "%')";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				empList.add(new Emp(
						rs.getInt("empno"), 
						rs.getString("ename"), 
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"), 
						rs.getDouble("sal"), 
						rs.getDouble("comm"),
						rs.getInt("deptno"))
						);

			}
			System.out.println("조회된 사원 정보 갯수 : "+empList.size());
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		return empList;
	}
	/*SELECT * FROM dept WHERE dname LIKE upper('%a%');
	 * private int deptno;
	private String dname;
	private String loc;
	 * */
	public List<Dept> getDeptList(String sch){
		List<Dept> dlist = new ArrayList<Dept>();
		String sql = "SELECT * FROM dept WHERE dname LIKE upper('%"+sch+"%')";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				dlist.add(new Dept(
					rs.getInt("deptno"),
					rs.getString("dname"),
					rs.getString("loc")
						));
			}
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		return dlist;
	}
	
	// SELECT EMPLOYEE_ID , FIRST_NAME , EMAIL , SALARY  FROM EMPLOYEES WHERE SALARY BETWEEN  1000 AND 3000;
	public List<Employee> getEmployeeList(int min, int max){
		List<Employee> elist = new ArrayList<Employee>();
		String sql = "SELECT EMPLOYEE_ID , FIRST_NAME , EMAIL , SALARY  FROM EMPLOYEES WHERE SALARY BETWEEN  "+min+" AND "+max;
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				elist.add(new Employee(
					rs.getInt("employee_id"),
					rs.getString("first_name"),
					rs.getString("email"),
					rs.getDouble("salary")
						));
			}
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

//===================메인================================================================
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpDao dao = new ExpDao();
		for(Employee elist : dao.getEmployeeList(1000, 3000)) {
			System.out.print(elist.getEmployee_id()+"\t");
			System.out.print(elist.getFirst_name()+"\t");
			System.out.print(elist.getEmail()+"\t");
			System.out.print(elist.getSalary()+"\n");
		}
		
//		System.out.println("검색된 detp 테이블 사원 정보");
//		for(Dept dlist : dao.getDept("a") ) {
//			System.out.print(dlist.getDeptno()+"\t");
//			System.out.print(dlist.getDname()+"\t");
//			System.out.print(dlist.getLoc()+"\n");
//		}
		
//		System.out.println("## 검색된 사원 정보 ##");
//		for(Emp elist : dao.getEmpList("a")) {
//			System.out.print(elist.getEmpno()+"\t");
//			System.out.print(elist.getEname()+"\t");
//			System.out.print(elist.getJob()+"\t");
//			System.out.print(elist.getMgr()+"\t");
//			System.out.print(elist.getSal()+"\t");
//			System.out.print(elist.getComm()+"\t");
//			System.out.print(elist.getHiredate()+"\t");
//			System.out.print(elist.getDeptno()+"\n");
//		}
		
//		System.out.println("처리결과 : " + dao.getStreetAddress("us"));
//		for (String list : dao.getStreetAddress("us")) {
//			System.out.println(list);
//		}

	}

}
