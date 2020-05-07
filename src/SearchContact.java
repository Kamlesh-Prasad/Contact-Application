import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SearchContact {
	static int row;
	static PreparedStatement pst=null;
	private static ResultSet rs;
	
	public static ResultSet searchContact(String name,String mobile,Connection con) 
	{
		String sql="SELECT ID, NAME, MOBILE, EMAIL, ADDRESS, WHATSAPP, IMAGE FROM CONTACT_ACCOUNT WHERE NAME='"+name+"' OR MOBILE='"+mobile+"'";// WHERE CONTACT_MOBILE='"+mobile+"' OR CONTACT_NAME='"+name+"'";
		
		if(con!=null)
		{
			try
			{
				pst=con.prepareStatement(sql);
				rs=pst.executeQuery();
				if(rs!=null)
					return rs;
				else 
					{
					JOptionPane.showMessageDialog(null, "Contact Not Exists");
					return null;
					}
				
				/*if(rs.next())
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
				*/
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null, e);
				System.out.println("Exception of Search Contact");
			}
		}
		else
			JOptionPane.showMessageDialog(null,"Database Not Connected");
		return null;
	}
	
/*public static void main(String[] anc)
{
SearchContact.searchContact("AMAR","MOBILE66",UserLogin.getConnection());
}*/
	
}

/*
/////////////////////////////////////
if(rs!=null)
{
	System.out.println(rs);
	while(rs.next())
	{
		
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
		
	}
}
else
	JOptionPane.showMessageDialog(null,"Contact Not Found");
	*/
