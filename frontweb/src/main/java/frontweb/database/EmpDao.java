package frontweb.database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import frontweb.Dept;
import frontweb.vo.EmpShort;
import frontweb.vo.Member;

public class EmpDao {
	// 공통으로 사용할 전역 객체 선언
	private Connection con; // 1. 연결
	private Statement stmt; // 2. 대화
	private PreparedStatement pstmt; // 2. (보안걸린)대화
	private ResultSet re; // 3. 결과
	// 각 기능별 메서드 처리.
	
	// 1단계 
	// select count(*) from emp;
	public int getEmpCount(){
		int cnt= 0;
		String sql="select count(*) from emp";
		return cnt;
	}
	
	public EmpShort getEmpShotr(int empno) {
		EmpShort se=null;
		String sql="";
		return se;
	}
	/*SELECT count(*) FROM DEPT d WHERE deptno=10;*/
	public int getCount(int deptno){
		String sql = "SELECT count(*) FROM DEPT WHERE deptno="+deptno+"";
		int cnt=0; 
		return cnt;
	}
	
	//SELECT ename FROM emp WHERE sal BETWEEN 1000 AND 2000;

	
	public List<String> getEnames(int start, int end){
		List<String> enames = new ArrayList<String>();
		String sql="SELECT ename FROM emp WHERE sal BETWEEN "+start+" AND "+end+"";
		return enames;
	}
	public List<Double> getSal(int deptno){
		List<Double> sal = new ArrayList<Double>();
		String sql = "SELECT sal FROM emp WHERE deptno="+deptno+"";
		return sal;
	}
	public List<Dept> getDList(String dname){
	 	List<Dept> dlist = new ArrayList<Dept>();
	 	String sql = "SELECT * FROM dept WHERE dname LIKE '%"+dname+"%'";
	 	return dlist;
	 }
	/*
	 ### 회원가입 기능 ###
	 - 주의) sql 문자열 숫자
	 
	INSERT INTO member01 values(1,'홍길동','himan','7777','admin',1000);
	 * */
	public void insertMember(Member ins){
		String sql="INSERT INTO member01 values("+ins.getMno()+",'"+ins.getName()+"'"
			+ ",'"+ins.getId()+"','"+ins.getPwd()+"','"+ins.getAuth()+"',"+ins.getPoint()+")";
	}
	/*
	SELECT * FROM member01 WHERE name LIKE '%길동%';
 public List<Member> schMember(String nameSch)
	 * */
	public List<Member> schMember(String nameSch){
		List<Member> mlist = new ArrayList<Member>();
		String src = "SELECT * FROM member01 WHERE name LIKE '%"+nameSch+"%'";
		return mlist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
