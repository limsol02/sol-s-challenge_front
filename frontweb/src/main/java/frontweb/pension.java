package frontweb;
import java.util.Date;

public class pension {
	private String no;
	private String name;
	private String numberOfPeople;
	private String price;
	private String checkIn;
	private String checkOut;
	private String loc;
	public pension() {
	}
	public pension(String no, String name, String numberOfPeople, String price, String checkIn, String checkOut,
			String loc) {
		this.no = no;
		this.name = name;
		this.numberOfPeople = numberOfPeople;
		this.price = price;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.loc = loc;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
