package frontweb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon2 {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	public static Connection con() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public static void close(AutoCloseable... resources) {
		for (AutoCloseable resource : resources) {
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception e) {
					System.out.print(resource.getClass().getSimpleName());
					System.out.println("닫기실패");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			close(con());
			System.out.println("접속성공!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("에러발생:" + e.getMessage());
		}
	}

}
