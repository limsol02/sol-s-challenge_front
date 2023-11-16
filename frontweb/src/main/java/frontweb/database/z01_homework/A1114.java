package frontweb.database.z01_homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
import = "frontweb.database.z01_homework.vo.locations"
import = "frontweb.database.z01_homework.A1114"
 * */
import frontweb.database.DBCon;
import frontweb.database.z01_homework.vo.locations;
import frontweb.vo.Member;


public class A1114 {
	
	/*private int location_id;
	private String street_address;
	private String postal_code;
	private String city;
	private String state_province;
	private String country_id;*/
	
	//SELECT * FROM locations WHERE STREET_ADDRESS LIKE ? AND city LIKE ?
	public List<locations> getLocList(String add, String city) {
		List<locations> llist = new ArrayList<locations>();
		String sql = "SELECT * FROM locations WHERE STREET_ADDRESS LIKE ? AND city LIKE ?";
		try (Connection con = DBCon.con();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 내가 처리할 처리코드 1
			pstmt.setString(1, "%"+add+"%");
			pstmt.setString(2, "%"+city+"%");
			try (ResultSet rs = pstmt.executeQuery();) {
				// 내가 처리할 처리코드2
				while(rs.next()) {
					llist.add( new locations(
						rs.getInt("location_id"),
						rs.getString("street_address"),
						rs.getString("postal_code"),
						rs.getString("city"),
						rs.getString("state_province"),
						rs.getString("country_id"))
						);
				}
				System.out.println("데이터건수 : "+llist.size());
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러 : " + e.getMessage());
		}
		return llist;
	}

	public static void main(String[] args) {
/*

[1단계:확인] 1. PreparedStatement의 사용하는 이유와 장단점을 기술하세요.
=> 장점으로는 Sql injection을 막을 수 있고 계속적으로 해석해서 실행하지 않고 기본적으로
읽었던 sql문은 바로 실행하기 때문에 데이터베이스의 부하를 줄일 수 있습니다.
단점으로는 초반에 컴파일 과정이 필요하기 때문에 초기 실행 속도가 느릴수 있습니다.
또한 쿼리 구조가 변경할 때마다 pstmt를 새로 생성해야하기에 복잡한 코드를 초래할 수 있습니다.


[1단계:확인] 2. login 처리 예제를 기준으로 PreparedStatement를 활용하여 id, pwd를 입력하는 처리를 해보세요.
   select * from member01 where id=? and pwd=? 기능메서드 처리
   public List<Member> getMemberList(String id, String pwd) {
		List<Member> mlist = new ArrayList<Member>();
		String sql = "select * from member01 where id=? and pwd=?";
		try (Connection con = DBCon.con();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 내가 처리할 처리코드 1
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			try (ResultSet rs = pstmt.executeQuery();) {
				// 내가 처리할 처리코드2
				while(rs.next()) {
					mlist.add( new Member(
						rs.getInt("mno"),
						rs.getString("name"),
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("auth"),
						rs.getInt("point"))
						);
				}
				System.out.println("데이터건수 : "+mlist.size());
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러 : " + e.getMessage());
		}
		return mlist;
   
[1단계:확인] 3. select * from member01 where name like ? 기능메서드 처리 

public List<Member> getMemberList(String name) {
		List<Member> mlist = new ArrayList<Member>();
		String sql = "select * from member01 where name like ?";
		try (Connection con = DBCon.con();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 내가 처리할 처리코드 1
			pstmt.setString(1, name);
			try (ResultSet rs = pstmt.executeQuery();) {
				// 내가 처리할 처리코드2
				while(rs.next()) {
					mlist.add( new Member(
						rs.getInt("mno"),
						rs.getString("name"),
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("auth"),
						rs.getInt("point"))
						);
				}
				System.out.println("데이터건수 : "+mlist.size());
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러 : " + e.getMessage());
		}
		return mlist;
	}

[1단계:확인] 4. SELECT *  FROM locations WHERE STREET_ADDRESS LIKE ? AND city LIKE ?;
           처리기능메서드 하고, 웹화면 출력까지 해보세요.
       
	public List<locations> getLocList(String add, String city) {
		List<locations> llist = new ArrayList<locations>();
		String sql = "SELECT * FROM locations WHERE STREET_ADDRESS LIKE ? AND city LIKE ?";
		try (Connection con = DBCon.con();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 내가 처리할 처리코드 1
			pstmt.setString(1, "%"+add+"%");
			pstmt.setString(2, "%"+city+"%");
			try (ResultSet rs = pstmt.executeQuery();) {
				// 내가 처리할 처리코드2
				while(rs.next()) {
					llist.add( new locations(
						rs.getInt("location_id"),
						rs.getString("street_address"),
						rs.getString("postal_code"),
						rs.getString("city"),
						rs.getString("state_province"),
						rs.getString("country_id"))
						);
				}
				System.out.println("데이터건수 : "+llist.size());
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러 : " + e.getMessage());
		}
		return llist;
	}
  ========================================================================
 <jsp>
 <body>
	<%
	A1114 dao = new A1114();
	%>
	<h2>뭔지모를 주소조회</h2>
	<table>
		<tr>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
		</tr>
		<%for(locations l01 : dao.getLocList("S","T")) {%>
		<tr>
			<th><%=l01.getLocation_id() %></th>
			<th><%=l01.getCity() %></th>
			<th><%=l01.getCountry_id() %></th>
			<th><%=l01.getPostal_code() %></th>
			<th><%=l01.getState_province() %></th>
			<th><%=l01.getStreet_address() %></th>
		</tr>
		<%} %>
	</table>

 * */

	}

}
