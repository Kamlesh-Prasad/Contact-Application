import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OracleDatabaseDemo extends JFrame implements DataBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Connection con=null;
	private ResultSetMetaData rsmd=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OracleDatabaseDemo frame = new OracleDatabaseDemo();
					frame.setVisible(true);
					frame.getConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OracleDatabaseDemo() {
		setTitle("Oracale Database Connection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOracleDatabase = new JLabel("Oracle Database");
		lblOracleDatabase.setFont(new Font("Verdana", Font.BOLD, 25));
		lblOracleDatabase.setForeground(Color.RED);
		lblOracleDatabase.setBounds(159, 32, 287, 54);
		contentPane.add(lblOracleDatabase);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(255, 215, 0));
		lblUserName.setFont(new Font("Verdana", Font.BOLD, 18));
		lblUserName.setBounds(127, 97, 168, 31);
		contentPane.add(lblUserName);
		
		JLabel label = new JLabel("User Name");
		label.setForeground(new Color(255, 215, 0));
		label.setFont(new Font("Verdana", Font.BOLD, 18));
		label.setBounds(127, 179, 168, 31);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		textField.setBackground(Color.DARK_GRAY);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Verdana", Font.BOLD, 16));
		textField.setBounds(127, 126, 287, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.BOLD, 16));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(127, 206, 292, 42);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user=textField.getText();
				password=passwordField.getText();
				
				try
				{
					Class.forName(driver);
					con=DriverManager.getConnection(url,user, password);
					con.close();
				}
				catch(ClassNotFoundException ee)
				{
					JOptionPane.showMessageDialog(null, ee);
					
				}
				catch(SQLException ee)
				{
					JOptionPane.showMessageDialog(null,"Incorrect User/Password");
				}
			}
		});
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 18));
		btnLogin.setBounds(76, 280, 89, 31);
		contentPane.add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnClose.setFont(new Font("Verdana", Font.BOLD, 18));
		btnClose.setBounds(391, 280, 89, 31);
		contentPane.add(btnClose);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnClear.setFont(new Font("Verdana", Font.BOLD, 18));
		btnClear.setBounds(232, 280, 89, 31);
		contentPane.add(btnClear);
	}
	
	public Connection getConnection()
	{
		if(con!=null)
			JOptionPane.showMessageDialog(null, "Oracle Connected");
		
			try {
				PreparedStatement stmt=con.prepareStatement("SELECT * FROM STD02");
				ResultSet rs=stmt.executeQuery();
				ResultSetMetaData rsmd=rs.getMetaData();
				System.out.println(rsmd.getTableName(1));
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
		
		
	
	}

}
