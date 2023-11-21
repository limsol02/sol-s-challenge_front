package frontweb.yanolja;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frontweb.database.DBCon;

public class Yanolja {
	private Connection con; // 1. 연결
	private Statement stmt; // 2. 대화
	private PreparedStatement pstmt; // 2. (보안걸린)대화
	private ResultSet rs; // 3. 결과
	
	/*SELECT * FROM PENSION WHERE loc='가평'AND NUMBEROFPEOPLE = 6 AND 
to_char(CHECKIN,'YYYY-MM-DD')='2023-11-10';*/
	public List<Pension> getPension(String loc, int number, String date){
		List<Pension> plist = new ArrayList<Pension>();
		String sql = "SELECT * FROM PENSION WHERE loc='"+loc+"'AND NUMBEROFPEOPLE = "+number+" AND \r\n"
				+ "to_char(CHECKIN,'YYYY-MM-DD')='"+date+"'";
		try {
			con = DBCon.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				plist.add(
					new Pension(
						rs.getInt("no"),
						rs.getString("name"),
						rs.getInt("numberOfPeople"),
						rs.getInt("price"),
						rs.getDate("checkIn"),
						rs.getDate("checkOut"),
						rs.getString("loc")
							)
						);
			}
		} catch (SQLException e) {
			System.out.println("DB예외" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외" + e.getMessage());
		} finally {
			DBCon.close(rs, stmt, con);
			System.out.println("자원해제처리!");
		}
		
		return plist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Yanolja dao = new Yanolja();
		for(Pension y01 : dao.getPension("가평", 6, "2023-11-10")) {
			System.out.print(y01.getNo()+"\t");
			System.out.print(y01.getName()+"\t");
			System.out.print(y01.getNumberOfPeople()+"\t");
			System.out.print(y01.getPrice()+"\t");
			System.out.print(y01.getCheckIn()+"\t");
			System.out.print(y01.getCheckOut()+"\t");
			System.out.print(y01.getLoc()+"\n");
		}
	}

}
