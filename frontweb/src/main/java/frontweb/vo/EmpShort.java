package frontweb.vo;

public class EmpShort {
	private int empno;
	private String ename;
	private String job;
	public EmpShort() {
		// TODO Auto-generated constructor stub
	}
	public EmpShort(int empno, String ename, String job) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
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
	
}
