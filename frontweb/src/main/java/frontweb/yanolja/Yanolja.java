package frontweb.yanolja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import frontweb.dao.DB;

public class Yanolja {
	
	private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    /*SELECT * FROM PENSION p 
WHERE loc LIKE '%가평%' AND NUMBEROFPEOPLE = 6  
AND EMPTYOFDATE='2023-11-10';*/
    public List<Pension> getPensionList() {
	    List<Pension> plist = new ArrayList<>();
	    String sql = "SELECT * FROM PENSION";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	
	        while (rs.next()) {
	            plist.add(new Pension(
	                    rs.getInt("no"),
	                    rs.getString("name"),
	                    rs.getInt("numberOfPeople"),
	                    rs.getInt("price"),
	                    rs.getString("emptyOfDate"),
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
    
    
    
	/*
SELECT * FROM PENSION p 
WHERE loc = '가평' AND NUMBEROFPEOPLE = 6  
AND TO_CHAR(EMPTYOFDATE,'YYYY-MM-DD')='2023-11-10';
	 * */
	public List<Pension> getPensionList(String loc, int numberOfPeople, String emptyOfDate){
		List<Pension> plist = new ArrayList<Pension>();
		String sql = "SELECT * FROM PENSION p \r\n"
				+ "WHERE loc LIKE '"+loc+"' AND NUMBEROFPEOPLE = "+numberOfPeople+"\r\n"
				+ "AND EMPTYOFDATE='"+emptyOfDate+"'";
		
		 try {
		        con = DB.con();
		        pstmt = con.prepareStatement(sql); 
		        rs = pstmt.executeQuery();
		
		        while (rs.next()) {
		        	plist.add(new Pension(
		                    rs.getInt("no"),
		                    rs.getString("name"),
		                    rs.getInt("numberOfPeople"),
		                    rs.getInt("price"),
		                    rs.getString("emptyOfDate"),
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
	Yanolja dao = new Yanolja();
	System.out.println(dao.getPensionList().size());
	for(Pension pension:dao.getPensionList("가평",6,"20231110")) {
		System.out.print(pension.getNo()+"\t");
		System.out.print(pension.getName()+"\t");
		System.out.print(pension.getNumberOfPeople()+"\t");
		System.out.print(pension.getPrice()+"\t");
		System.out.print(pension.getEmptyOfDate()+"\t");
		System.out.print(pension.getLoc()+"\n");
	}
}



}

