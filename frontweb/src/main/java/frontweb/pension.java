package frontweb;
import java.util.Date;

public class pension {
	private int no;
	private String name;
	private int numberOfPeople;
	private int price;
	private Date checkIn;
	private Date checkOut;
	private String loc;
	public pension() {
	}
	public pension(int no, String name, int numberOfPeople, int price, Date checkIn, Date checkOut, String loc) {
		this.no = no;
		this.name = name;
		this.numberOfPeople = numberOfPeople;
		this.price = price;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}