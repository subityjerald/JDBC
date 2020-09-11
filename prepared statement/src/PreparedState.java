import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class PreparedState {
	public static void main (String args[]) {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/company","root","dairymilk");
		PreparedStatement pstmt= con.prepareStatement("insert into emp234 values(?,?,?)");
		pstmt.setInt(1,228);
		pstmt.setString(2, "lucky");
		pstmt.setInt(3, 10000);
		//to execute update we use int
		int i=pstmt.executeUpdate();
		System.out.println(i+"inserted");
		Statement stmt=con.createStatement
				(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet a=stmt.executeQuery("SELECT * FROM emp234");
	a.last();
			System.out.println(a.getInt(1)+" "+a.getString(2)+" "+a.getInt(3));
		
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
