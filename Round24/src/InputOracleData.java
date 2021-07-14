import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InputOracleData {

	public static void main(String[] args) {
		String user = "hr";
		String password = "1234";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql ="insert into test values(?,?)";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("OK");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("==>" + conn);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "ÀÌ¿µÈñ");
			pstm.setInt(2, 40);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("ERROR" + e);
		}

	}

}
