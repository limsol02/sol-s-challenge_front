package frontweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frontweb.pension;

/*SELECT * FROM PENSION p 
WHERE loc = '가평' AND checkIn >= '2023-11-10' AND checkOut <= '2023-11-12' AND NUMBEROFPEOPLE =6;;*/

public class Yanolja {
	
	 private Connection con;
	 private PreparedStatement pstmt;
	 private ResultSet rs;
	
	public List<pension> getPensionList() {
	    List<pension> plist = new ArrayList<>();
	    String sql = "SELECT * FROM PENSION";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	
	        while (rs.next()) {
	        	plist.add(new pension(
	                    rs.getInt("no"),
	                    rs.getString("name"),
	                    rs.getInt("numberOfPeople"),
	                    rs.getInt("price"),
	                    rs.getDate("checkIn"),
	                    rs.getDate("checkOut"),
	                    rs.getString("loc")
	            ));
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return plist;
	}
	



public List<pension> getPensionList(String loc, Date checkIn,Date checkOut,int numberOfPeople) {
	    List<pension> plist = new ArrayList<>();
	    String sql = "SELECT * FROM PENSION p \r\n"
	    		+ "WHERE loc = '"+loc+"' AND checkIn >= '"+checkIn+"' AND checkOut <= '"+checkOut+"' AND NUMBEROFPEOPLE ="+numberOfPeople+";";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	
	        while (rs.next()) {
	        	plist.add(new pension(
	                    rs.getInt("no"),
	                    rs.getString("name"),
	                    rs.getInt("numberOfPeople"),
	                    rs.getInt("price"),
	                    rs.getDate("checkIn"),
	                    rs.getDate("checkOut"),
	                    rs.getString("loc")
	            ));
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return plist;
	}




public static void main(String[] args) {
	Yanolja y01 = new Yanolja();

	for(pension p01:y01.getPensionList()) {
		System.out.print(p01.getNo()+"\t");
		System.out.print(p01.getName()+"\t");
		System.out.print(p01.getNumberOfPeople()+"\t");
		System.out.print(p01.getPrice()+"\t");
		System.out.print(p01.getCheckIn()+"\t");
		System.out.print(p01.getCheckOut()+"\t");
		System.out.print(p01.getLoc()+"\n");
	}
}


}

