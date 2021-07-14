import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
	
	private Connection conn = null;
	public DbManager() {
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="hr";
		String pass="1234";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading");
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("===>" + conn);
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println("Driver loading Faild " + e);
		}
	}
	
	public void insert(Person p1) {
		String query = "insert into person values(?, ?)";
		try {
			PreparedStatement ptm = conn.prepareStatement(query);
			ptm.setString(1,  p1.getName());
			ptm.setInt(2, p1.getAge());
			ptm.executeUpdate();
			ptm.close();
		} catch (SQLException e) {
			System.out.println("insert Error " + e);
		}
	}
	
	public List<Person> selectAll(){
		List<Person> li=new ArrayList<Person>();
		String query="select * from person";
		try {
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				li.add(new Person(rs.getString(1),rs.getInt(2)));
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;
	}
	
	public int select(String name) {
		String query="select age from person where name=?";
		int result = 0;
		try {
			PreparedStatement ptm=conn.prepareStatement(query);
			ptm.setString(1, name);
			ResultSet rs = ptm.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				System.out.println("result"  + result);
			}
			rs.close();
			ptm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int delete(String name) {
		int i =0;
		String query = "delete from person where name=?";
		try {
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setString(1, name);
			i = pstm.executeUpdate();
			
			pstm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int update(String name, int age) {
		String query="update person set age=? where name=?";
		int r=0;
		try {
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setInt(1, age);
			pstm.setString(2, name);
			r=pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;

	}

	
}