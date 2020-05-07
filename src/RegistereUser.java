
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class RegistereUser extends JFrame implements DataBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	public static Connection con;
	public ResultSet rs=null;
	public int id=00001;

	/**
	 * Launch the application.
	 */
	public static void main(Connection con2) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistereUser frame = new RegistereUser();
					frame.setVisible(true);
					con=con2;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistereUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(225,90, 823, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER ID");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNewLabel.setBounds(197, 50, 211, 45);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(197, 112, 419, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblUserName.setBounds(197, 168, 211, 45);
		contentPane.add(lblUserName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(197, 224, 419, 45);
		contentPane.add(textField_1);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblPassword.setBounds(197, 280, 211, 45);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(197, 336, 419, 45);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					//con=getConnection("system","system");
					if(con!=null&&!textField.getText().isBlank()&&!textField_1.getText().isBlank()&&passwordField.getPassword()!=null)
					{	
						
						PreparedStatement ps=con.prepareStatement("INSERT INTO CONTACT_USER_ACCOUNT VALUES(?,?,?)");
						ps.setInt(1,Integer.parseInt(textField.getText()));
						ps.setString(2,textField_1.getText());
						ps.setString(3,String.copyValueOf(passwordField.getPassword()));
						int i=0;
						i=ps.executeUpdate();
						if(i!=0)
						{
							JOptionPane.showMessageDialog(null, "User Registered");
							textField.setText(null);
							textField_1.setText(null);
							passwordField.setText(null);
						}
						
					}else
						JOptionPane.showMessageDialog(null, "Field Are Empty");
				}catch(SQLException w)
				{
					JOptionPane.showMessageDialog(null,w.getMessage());
					System.out.println("Exception of Register User");
					if(!OracleDatabae.contactUserAC(con))
					{
						
						System.out.println("CONTACT_USER_ACCOUNT TABLE CREATED");
						try {
							PreparedStatement ps=con.prepareStatement("INSERT INTO CONTACT_USER_ACCOUNT VALUES(?,?,?)");
							ps.setInt(1,Integer.parseInt(textField.getText()));
							ps.setString(2,textField_1.getText());
							ps.setString(3,String.copyValueOf(passwordField.getPassword()));
							int i=0;
							i=ps.executeUpdate();
							if(i!=0)
							{
								JOptionPane.showMessageDialog(null, "User Registered");
								textField.setText(null);
								textField_1.setText(null);
								passwordField.setText(null);
								DashboardLogin frame = new DashboardLogin();
								
							}
						}
						catch(Exception e1) {
							System.out.println("Exception of During Insertion User");
						}
						
					}
					else
					{
						System.out.println("CONTACT_USER_ACCOUNT Table Already Exist");
					}
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton.setBounds(88, 427, 211, 45);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(0,128, 128));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				passwordField.setText(null);
				
				setVisible(false);
				
			}
		});
		btnCancel.setFont(new Font("Verdana", Font.BOLD, 20));
		btnCancel.setBounds(504, 427, 211, 45);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 0, 809, 503);
		contentPane.add(lblNewLabel_1);
	}
	
	/*public Connection getConnection(String user,String pass)
	{
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pass);
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}*/
}
