import java.sql.*;

public class SQLSelectTest{
	public static Connection makeConnection() throws SQLException{
		String select = "SELECT * FROM books ORDER BY book_id";
		Connection con = null;
		Statement s = con.createStatement();
		ResultSet rows = s.executeQuery(select);
		return con;
	}

	public static void main(String arg[]) throws SQLException{
		Connection con = makeConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT*FROM books");
		while(rs.next()){
			int id = rs.getInt("book _id:");
			String title = rs.getString("title");
			System.out.println(id + "" + title);
		}
	}
}
	
	
	

