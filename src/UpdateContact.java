import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UpdateContact {
	
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	public static boolean updateContact(String name,String mobile,String email,String address,String whatsapp,String Exist_Name,String Exits_Mobile,FileInputStream fin,Connection con)
	{
		
		String sql="UPDATE CONTACT_ACCOUNT SET NAME=?, MOBILE=?, EMAIL=?, ADDRESS=?, WHATSAPP=?, IMAGE=? WHERE NAME='"+Exist_Name+"' OR MOBILE='"+Exits_Mobile+"'";
	if(con!=null)
	{
		try {
			
			pst=con.prepareStatement(sql);

			pst.setString(1,name);
			pst.setString(2,mobile);
			pst.setString(3,email);
			pst.setString(4,address);
			pst.setString(5,whatsapp);
			pst.setBinaryStream(6,fin,fin.available());
			int i=pst.executeUpdate();
			System.out.println(i);
			if(i!=JOptionPane.showConfirmDialog(null, "Do You Wnat To Update"))
			{
				return true;
			}
	
		con.close();
			
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
		}
	else
		JOptionPane.showMessageDialog(null, "Not Connected");
	return false;
	}

public static void main(String[] abs) throws IOException
{
	//FileInputStream fin=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\DBProject\\ImageSources\\Person.png");
	
	//System.out.println(UpdateContact.updateContact("ANSH","MOBILE88","MAIL","ADD","CHAT","ANSH88","MOBILE",fin,UserLogin.getConnection()));

	//fin.close();
}

}
