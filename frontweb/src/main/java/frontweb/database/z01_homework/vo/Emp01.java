package frontweb.database.z01_homework.vo;

public class Emp01 {
// avg(sal) , sum(sal)
	private String job;
	private Double avsal;
//	private Double sum;
	public Emp01() {
		// TODO Auto-generated constructor stub
	}
	public Emp01(String job, Double avsal) {
		this.job = job;
		this.avsal = avsal; 
	}
	public Double getAvsal() {
		return avsal;
	}
	public void setAvsal(Double avsal) {
		this.avsal = avsal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		job = job;
	}
	
}
