import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OracleDatabae {

	static String driver="oracle.jdbc.driver.OracleDriver";
	static String url="jdbc:oracle:thin:@localhost:1521:XE";
	static Connection con=null;
	public static Connection getConnection(String userName,String password)
	{
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url, userName, password);
			if(con!=null)
				return con;
			else
				return null;
		
		}
		catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"Oracle Driver Not Found");
			
		}
		catch(SQLException e)
		{
		JOptionPane.showMessageDialog(null,"User or Password Incorrect");
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	public static boolean contactUserAC(Connection con) {
		boolean status=true;
		try {
			PreparedStatement stmt=con.prepareStatement("CREATE TABLE CONTACT_USER_ACCOUNT(ID NUMBER(10),USERNAME VARCHAR2(30),PASSWORD VARCHAR2(15))");
			status=stmt.execute();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception of contactUserAC");
			return true;
		}
		return status;
	}
	
	
	public static boolean contactAC(Connection con) {
		boolean status=true;
		try {
			PreparedStatement stmt=con.prepareStatement("CREATE TABLE CONTACT_ACCOUNT(ID NUMBER(10),NAME VARCHAR2(30),MOBILE VARCHAR2(15),EMAIL VARCHAR2(30),ADDRESS VARCHAR2(12),WHATSAPP VARCHAR2(12),IMAGE BLOB)");
			status=stmt.execute();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception of contactAC");
			return true;
		}
		return status;
	}
}
