import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
public class ResultSett {
	public static void main (String args[]) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/company","root","dairymilk");
		Statement stmt= con.createStatement
				(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		PreparedStatement pstmt=con.prepareStatement("insert into emp234 values(?,?,?)");
		pstmt.setInt(1,101);//1 specifies the first parameter in the query  
		pstmt.setString(2,"Ratan");
		pstmt.setInt(3,101898);
		int i=pstmt.executeUpdate();  
		System.out.println(i+" records inserted");  
		ResultSet rs=stmt.executeQuery("SELECT * FROM emp234 ");
		rs.absolute(4);
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));  
		 while (rs.next()) {
		  System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		 }
		 while (rs.previous()) {
			  System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			 }
		 rs.last();
		 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		con.close();  
		
	}

}
