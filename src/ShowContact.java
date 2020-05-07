import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class ShowContact {
	
	
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	private static int totalContact;
	
	private static String sql="SELECT * FROM CONTACT_ACCOUNT";
public static ResultSet ShowAllContact(Connection con)
{
	if(con!=null)
	{
		try 
		{
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs!=null)
				return rs;
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			con.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}

	}
	else
		JOptionPane.showMessageDialog(null, "Database Not Connected");
	return null;
}



public static int TotalCotact(Connection con)
{
	if(con!=null)
	{
		try 
		{
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next())
			{
				totalContact=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}

	}
	else
		JOptionPane.showMessageDialog(null, "Database Not Connected");
	return totalContact;
	

}

/*public static void main(String[] abs)
{
ShowContact.ShowAllContact(UserLogin.getConnection());
}
*/
}
