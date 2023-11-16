package frontweb.database.z01_homework.vo;

public class Emp04 {
	private int deptno;
	private int cnt;
	private double aSal;
	public Emp04() {
		// TODO Auto-generated constructor stub
	}
	public Emp04(int deptno, int cnt, double aSal) {
		this.deptno = deptno;
		this.cnt = cnt;
		this.aSal = aSal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public double getaSal() {
		return aSal;
	}
	public void setaSal(double aSal) {
		this.aSal = aSal;
	}
	
}
