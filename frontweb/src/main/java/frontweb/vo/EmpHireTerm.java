package frontweb.vo;

public class EmpHireTerm {
	private int empno;
	private String ename;
	private String job;
	private String hirestr;
	private int deptno;
	public EmpHireTerm() {
		// TODO Auto-generated constructor stub
	}
	public EmpHireTerm(int empno, String ename, String job, String hirestr, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hirestr = hirestr;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHirestr() {
		return hirestr;
	}
	public void setHirestr(String hirestr) {
		this.hirestr = hirestr;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
