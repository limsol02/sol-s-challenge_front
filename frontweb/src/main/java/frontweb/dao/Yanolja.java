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
	        			rs.getString("no"),
	                    rs.getString("name"),
	                    rs.getString("numberOfPeople"),
	                    rs.getString("price"),
	                    rs.getString("checkIn"),
	                    rs.getString("checkOut"),
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
	

/*SELECT * FROM PENSION p 
WHERE loc LIKE '%가평%' AND checkIn LIKE '%10%' AND NUMBEROFPEOPLE LIKE '%6%';*/

public List<pension> getPensionList(String loc, String checkIn,String numberOfPeople) {
	    List<pension> plist = new ArrayList<>();
	    String sql = "SELECT * FROM PENSION p \r\n"
	    		+ "WHERE loc LIKE '%"+loc+"%' AND checkIn LIKE '%"+checkIn+"%' AND NUMBEROFPEOPLE LIKE '%"+numberOfPeople+"%';";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	
	        while (rs.next()) {
	        	plist.add(new pension(
	                    rs.getString("no"),
	                    rs.getString("name"),
	                    rs.getString("numberOfPeople"),
	                    rs.getString("price"),
	                    rs.getString("checkIn"),
	                    rs.getString("checkOut"),
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

