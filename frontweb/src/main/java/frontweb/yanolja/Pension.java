package frontweb.yanolja;


public class Pension {
	private int no;
	private String name;
	private int numberOfPeople;
	private int price;
	private String emptyOfDate;
	private String loc;
	public Pension() {
		// TODO Auto-generated constructor stub
	}
	public Pension(int no, String name, int numberOfPeople,
			int price, String emptyOfDate, String loc) {
		this.no = no;
		this.name = name;
		this.numberOfPeople = numberOfPeople;
		this.price = price;
		this.emptyOfDate = emptyOfDate;
		this.loc = loc;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEmptyOfDate() {
		return emptyOfDate;
	}
	public void setEmptyOfDate(String emptyOfDate) {
		this.emptyOfDate = emptyOfDate;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
