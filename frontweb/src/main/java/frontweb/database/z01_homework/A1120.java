package frontweb.database.z01_homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import frontweb.Dept;
import frontweb.database.DBCon;
import frontweb.vo.Member;

public class A1120 {

	/* member01 테이블 기준으로 (회원관리) 리스트화면, 등록처리, 상세화면, 수정, 삭제 처리해서 출력*/
	
	public List<Member> getMemList(int mno){
		 List<Member> member = new ArrayList<Member>();
		 String sql = "SELECT * FROM MEMBER01 ";
		 if(mno!=0) {sql+= "where mno=?";}
		 try( 
					Connection con = DBCon.con();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				if (mno != 0) {
					pstmt.setInt(1, mno);
				}
				try( 
						ResultSet rs = pstmt.executeQuery();
						){
					while(rs.next()) {
						member.add(new Member(
								rs.getInt("mno"),
								rs.getString("name"),
								rs.getString("id"),
								rs.getString("pwd"),
								rs.getString("auth"),
								rs.getInt("point")
								));
					}
					System.out.println("데이터 건수:"+member.size());
				}
			}catch(SQLException e) {
				System.out.println("DB 에러:"+e.getMessage());
			}catch(Exception e) {
				System.out.println("일반 에러:"+e.getMessage());
			}		
		 return member;
	}
	
	public int insertMember(Member mem) {
		int ins = 0;
		String sql = "INSERT INTO MEMBER01 VALUES (?,?,?,?,?,?)";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
	        con.setAutoCommit(false);
	        // 처리코드1
	        pstmt.setInt(1, mem.getMno());
	        pstmt.setString(2, mem.getName());
	        pstmt.setString(3, mem.getId());
	        pstmt.setString(4, mem.getPwd());
	        pstmt.setString(5, mem.getAuth());
	        pstmt.setInt(6, mem.getPoint());
	        
	        ins = pstmt.executeUpdate();
	        if(ins == 0) {
	        	System.out.println("등록 실패");
	        	con.rollback();
	        }else {
	        	con.commit(); // Commit the transaction
	        	System.out.println("등록 성공");
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 에러:" + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 에러:" + e.getMessage());
	    }
		return ins;
		
	}
	
	public Member getMember(int mno) {
		Member mem = null;
		String sql="SELECT * FROM member01 WHERE mno =?";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 처리코드1
			pstmt.setInt(1,mno);
			try (ResultSet rs = pstmt.executeQuery();) {
				// 처리코드2
				if(rs.next()) {
					mem = new Member(
							rs.getInt("mno"),
							rs.getString("name"),
							rs.getString("id"),
							rs.getString("pwd"),
							rs.getString("auth"),
							rs.getInt("point")
							);
				}
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}
		return mem;
	}
	
	public int updateMember(Member mem) {
		int upt = 0;
		String sql = "UPDATE MEMBER01 "
		        + "SET "
		        + " name=?, id=?, pwd=?, auth=?, point=? where mno=?";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
	        con.setAutoCommit(false);
	        
	        // 처리코드1
	        pstmt.setString(1, mem.getName());
	        pstmt.setString(2, mem.getId());
	        pstmt.setString(3, mem.getPwd());
	        pstmt.setString(4, mem.getAuth());
	        pstmt.setInt(5, mem.getPoint());
	        pstmt.setInt(6, mem.getMno());

	        upt = pstmt.executeUpdate();
	        if(upt == 0) {
	        	System.out.println("수정 실패");
	        	con.rollback();
	        }else {
	        	con.commit(); // Commit the transaction
	        	System.out.println("수정 성공");
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 에러:" + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 에러:" + e.getMessage());
	    }
		return upt;
	}
	
	public int deleteMember(int mno) {
		int delCnt = 0;
		String sql = "delete from member01 where mno=?";
		 try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
		        con.setAutoCommit(false);
		        
		        // 처리코드1
		        pstmt.setInt(1, mno);
	
		        delCnt = pstmt.executeUpdate();
		        if(delCnt == 0) {
		        	System.out.println("삭제 실패");
		        	con.rollback();
		        }else {
		        	con.commit(); // Commit the transaction
		        	System.out.println("삭제 성공");
		        }
		    } catch (SQLException e) {
		        System.out.println("DB 에러:" + e.getMessage());
		    } catch (Exception e) {
		        System.out.println("일반 에러:" + e.getMessage());
		    }
		return delCnt;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A1120 dao = new A1120();
		dao.updateMember(new Member(6, "chl길동", "byeman", "9999", "쫄따구", 111));
		
		
	}

}
