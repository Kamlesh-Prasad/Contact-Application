import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RemoveContact {
	static PreparedStatement pst=null;
	
	
	static String  sql="DELETE FROM CONTACT_ACCOUNT WHERE NAME=? OR MOBILE=?";
	public static boolean removeContact(String name,String mobile,Connection con)
	{
		if(con!=null)
		{
			try
			{
				pst=con.prepareStatement(sql);
				pst.setString(1,name);
				pst.setString(2,mobile);
				
				if(1==pst.executeUpdate())
				return true;
				else
				return false;
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Database Not Connected");
		return false;
	}
	
/*public static void main(String []abc)
{
	
		System.out.println(RemoveContact.removeContact("ansh","8602691052",UserLogin.getConnection()));

}*/
}
