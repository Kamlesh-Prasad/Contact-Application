import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AddContact {
	int cid=111;
	Connection con;
	PreparedStatement pst;
	FileInputStream fin=null;

	int row;
	private String sql="INSERT INTO CONTACT_ACCOUNT VALUES(?,?,?,?,?,?,?)";
	
public boolean addContact(String name,String mobile,String email,String address,String whatsapp,FileInputStream fin,Connection con)
{
if(con!=null)
{
	System.out.println(name);
	System.out.println(mobile);
	System.out.println(email);
	System.out.println(address);
	System.out.println(whatsapp);
	//System.out.println(image);
	try {
		
		pst=con.prepareStatement(sql);
		int id=ShowContact.TotalCotact(con);
		id=id+1;
		pst.setInt(1,id);
		pst.setString(2,name);
		pst.setString(3,mobile);
		pst.setString(4,email);
		pst.setString(5,address);
		pst.setString(6,whatsapp);
		pst.setBinaryStream(7,fin,fin.available());
		//pst.setBytes(7,fin);
		//pst.setBinaryStream(7,fin,fin.available());
		
		if(0==JOptionPane.showConfirmDialog(null, "Do You Wnat To Saved"))
		{
			row=pst.executeUpdate();
			if(row!=0)
				return true;
		}else
			return false;
		
	} catch (SQLException | IOException e) {
		JOptionPane.showMessageDialog(null,e.getMessage());
	}
	return false;
}
else 
	JOptionPane.showMessageDialog(null, "Database Not Connected");
return false;
}

/*public static void main(String []abc)
{
	new AddContact("kamlesh","7869471711","1231@gmailcom","Rewa","7869471711",null);
	}*/
}
