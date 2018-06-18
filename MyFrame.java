import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	JTextField id, title, p, year, price, author;
	JButton previousButton, nextButton, InsertButton, deleteButton, searchButton;
	ResultSet rs;
	java.sql.Statement stmt;
	GridLayout gl;
	JLabel jb;

	public MyFrame() throws SQLException {   super("Database Viewer");   Connection con = makeConnection ();   
	stmt = con.createStatement();  
	rs = stmt.executeQuery("SELECT * FROM books");  
	setLayout(new GridLayout(0, 2)); 
	add(new JLabel("ID", JLabel. CENTER )); 
	add(id = new JTextField()); 
	add(new JLabel("TITLE", JLabel. CENTER ));  
	add(title = new JTextField()); 
	add(new JLabel("PUBLISHER", JLabel. CENTER )); 
	add(p = new JTextField());  
	add(new JLabel("YEAR", JLabel. CENTER )); 
	add(year = new JTextField()); 
	add(new JLabel("PRICE", JLabel. CENTER )); 
	add(price = new JTextField()); 
	add(new JLabel("저자 검색", JLabel. CENTER )); 
	add(author = new JTextField()); 
	

 
  previousButton = new JButton("Previous"); 
  previousButton.addActionListener(new ActionListener() { 
	  public void actionPerformed1(ActionEvent event) {  
		  try {      rs.previous();  
   id.setText("" + rs.getInt("book_id")); 
   title.setText("" + rs.getString("title"));   
   p.setText("" + rs.getString("publisher"));    
   year.setText("" + rs.getString("year"));   
   price.setText("" + rs.getInt("price"));    
   } catch (SQLException e) {    
	  e.printStackTrace();     }    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}   }); 

 
  nextButton = new JButton("Next");   nextButton.addActionListener(new ActionListener() {  
	  public void actionPerformed(ActionEvent event) {  
		  try {      rs.next();   
		  id.setText("" + rs.getInt("book_id"));  
		  title.setText("" + rs.getString("title"));  
		  p.setText("" + rs.getString("publisher"));   
		  year.setText("" + rs.getString("year"));   
		  price.setText("" + rs.getInt("price"));   
		  } catch (SQLException e) {      e.printStackTrace();     }    }   });
  add(nextButton);  
  add(previousButton); 
  setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE ); 
  setSize(350, 200);  
}

	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/book_db";
		String id = "root";
		String password = "password";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}
}

class Create {
	public static void main(String[] args) throws SQLException {
		new MyFrame();
	}
}