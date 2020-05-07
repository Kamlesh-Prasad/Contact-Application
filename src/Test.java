import java.sql.Connection;
import java.sql.ResultSet;

public class Test {

	private static Connection con;
	static ResultSet rs=null;
	public static void main(String[] args) {
		try
		{	con=UserLogin.getConnection();
			int i=ShowContact.TotalCotact(con);
			System.out.println("Total id = "+i);
			ShowContact.ShowAllContact(con);
			
			
			con.close();
		}
		catch(Exception e)
		{
			
		}

	}

}
