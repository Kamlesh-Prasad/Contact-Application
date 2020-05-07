import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Rectangle;
import java.awt.Cursor;


public class UserLogin extends JFrame implements DataBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static public JTextField User_Name;
	static public JPasswordField Password;
	public static Connection con=null;
	public String user_name,password;
	public static UserLogin frame;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(Connection con2) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame=new UserLogin();
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
	public UserLogin(){
		setBounds(new Rectangle(0, 0, 0, 0));
		setUndecorated(true);
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,100, 726, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Admin_Label = new JLabel("Admin Login");
		Admin_Label.setForeground(new Color(165, 42, 42));
		Admin_Label.setFont(new Font("Verdana", Font.BOLD, 35));
		Admin_Label.setBounds(243, 32, 286, 89);
		contentPane.add(Admin_Label);
		
		UserLogin.getConnection();
		
		
		User_Name = new JTextField();
		User_Name.setFont(new Font("Verdana", Font.BOLD, 20));
		User_Name.setBounds(195, 132, 401, 39);
		contentPane.add(User_Name);
		User_Name.setColumns(10);
		
		Password = new JPasswordField();
		Password.setActionCommand("");
		Password.setFont(new Font("Verdana", Font.BOLD, 20));
		Password.setColumns(10);
		Password.setBounds(195, 216, 401, 39);
		contentPane.add(Password);
		
		JButton Login_Button = new JButton("Login");
		Login_Button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				user_name=User_Name.getText();
				password=Password.getText();
				boolean check=false;
				//con=getConnection("system","system");
				if(con!=null)
				{
					try {
						PreparedStatement ps=con.prepareStatement("select * from contact_user_account");
						ResultSet rs=ps.executeQuery();
						
						
							while(rs.next())
							{
								if(user_name.equalsIgnoreCase(rs.getString(2))&&password.equalsIgnoreCase(rs.getString(3)))
								{
									JOptionPane.showMessageDialog(null, "main Dash Board");
									check=true;
									setVisible(false);
									Dashboard.main(con);
									break;
								}
							}
							if(check==false)
								JOptionPane.showMessageDialog(null, "Wrrong User Name OR Password");
								
		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Dataase Not Connected");
			}
		});
		Login_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_name=User_Name.getText();
				password=Password.getText();
				boolean check=false;
				//con=getConnection("system","system");
				if(con!=null)
				{
					try {
						PreparedStatement ps=con.prepareStatement("select * from contact_user_account");
						ResultSet rs=ps.executeQuery();
						
						
							while(rs.next())
							{
								if(user_name.equalsIgnoreCase(rs.getString(2))&&password.equalsIgnoreCase(rs.getString(3)))
								{
									JOptionPane.showMessageDialog(null, "main Dash Board");
									check=true;
									setVisible(false);
									Dashboard.main(con);
									break;
								}
							}
							if(check==false)
								JOptionPane.showMessageDialog(null, "Wrrong User Name OR Password");
								
		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Dataase Not Connected");
			}
		});
		Login_Button.setBorderPainted(false);
		Login_Button.setBackground(SystemColor.info);
		Login_Button.setFont(new Font("Verdana", Font.BOLD, 20));
		Login_Button.setBounds(101, 308, 121, 36);
		contentPane.add(Login_Button);
		
		JButton Reset_Button = new JButton("Reset");
		Reset_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Reset_Button.setBorderPainted(false);
		Reset_Button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				User_Name.setText(null);
				Password.setText(null);
			}
		});
		Reset_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Name.setText(null);
				Password.setText(null);
				
			}
		});
		Reset_Button.setBackground(SystemColor.info);
		Reset_Button.setFont(new Font("Verdana", Font.BOLD, 20));
		Reset_Button.setBounds(297, 308, 121, 36);
		contentPane.add(Reset_Button);
		
		JButton Close_Button = new JButton("Close");
		Close_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Close_Button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setVisible(false);
				DashboardLogin.main(null);
				
			}
		});
		Close_Button.setBorderPainted(false);
		Close_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				DashboardLogin.main(null);
				
				
			}
		});
		Close_Button.setFont(new Font("Verdana", Font.BOLD, 20));
		Close_Button.setBackground(SystemColor.info);
		Close_Button.setBounds(494, 308, 121, 36);
		contentPane.add(Close_Button);
		
		JLabel User_lb_Icon = new JLabel("");
		User_lb_Icon.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\DBProject\\ImageSources\\user_12.png"));
		User_lb_Icon.setBounds(128, 132, 68, 39);
		contentPane.add(User_lb_Icon);
		
		JLabel Password_lb_icon = new JLabel("");
		Password_lb_icon.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\DBProject\\ImageSources\\Password.png"));
		Password_lb_icon.setBounds(128, 216, 68, 39);
		contentPane.add(Password_lb_icon);
		
		JLabel Background_img_Label = new JLabel("");
		Background_img_Label.setDisplayedMnemonic('*');
		Background_img_Label.setIcon(new ImageIcon("E:\\Image of Software\\light-blue-wallpaper.jpg"));
		Background_img_Label.setBounds(-14, -11, 754, 399);
		contentPane.add(Background_img_Label);
	}
	public static Connection getConnection()
	{
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"system","system");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
