package frontweb.database.z01_homework.vo;

import java.util.Date;

public class Emp02 {
	private String ename;
	private Date hiredate;
	public Emp02() {
		// TODO Auto-generated constructor stub
	}
	public Emp02(String ename, Date hiredate) {
		this.ename = ename;
		this.hiredate = hiredate;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
}
