import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutputOracleData {

	public static void main(String[] args) {
		Connection conn = null;
		String user = "hr";
		String password = "1234";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql = "select * from test";
		//드라이버 올리기
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("OracleDriver OK");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("==>" + conn);
			Statement stm = conn.createStatement();
			ResultSet rst = stm.executeQuery(sql);
			while(rst.next()) {
				System.out.println(rst.getString(1)+ " : " + rst.getInt(2));
				//oracle 데이터 commit;해야함	
			}
			rst.close();
			stm.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("ERROR" + e);
		}

	}

}
