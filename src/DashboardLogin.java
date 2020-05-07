
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class DashboardLogin extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection con=null;
	private JTextField textField;
	private JPasswordField passwordField;
	private String user="system";
	private String password="system";
	private boolean status=false;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Demo For Testing");
					DashboardLogin frame = new DashboardLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public DashboardLogin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try
				{
					if(1==JOptionPane.showConfirmDialog(null, "Do You Want Close Application"))
					{
						if(con!=null)
							con.close();
						System.exit(0);
					}
					
				}
				catch(SQLException ee){}
				
			}
		});
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(160,20, 954, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Header_Panel = new JPanel();
		Header_Panel.setBackground(new Color(165, 42, 42));
		Header_Panel.setBounds(-11, 0, 964, 141);
		contentPane.add(Header_Panel);
		Header_Panel.setLayout(null);
		
		
		JPanel Login_Panel = new JPanel();
		Login_Panel.setBackground(Color.DARK_GRAY);
		Login_Panel.setBounds(207, 152, 554, 308);
		contentPane.add(Login_Panel);
		Login_Panel.setLayout(null);
		
		JLabel Oracle = new JLabel("Oracle Disconnected");
		Oracle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Oracle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					Login_Panel.setVisible(true);
				
			}
		});
		Oracle.setForeground(new Color(255, 69, 0));
		Oracle.setFont(new Font("Verdana", Font.BOLD, 18));
		Oracle.setBounds(721, 44, 222, 41);
		Header_Panel.add(Oracle);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 215, 0));
		textField.setBackground(Color.DARK_GRAY);
		textField.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		textField.setFont(new Font("Verdana", Font.BOLD, 18));
		textField.setBounds(108, 99, 336, 37);
		Login_Panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		passwordField.setForeground(new Color(255, 215, 0));
		passwordField.setFont(new Font("Verdana", Font.BOLD, 18));
		passwordField.setBounds(108, 173, 336, 37);
		Login_Panel.add(passwordField);
		
		
		JLabel lblNewLabel = new JLabel("Admin User");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(108, 56, 161, 44);
		Login_Panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPassword.setBounds(108, 137, 161, 44);
		Login_Panel.add(lblPassword);
		Login_Panel.setVisible(false);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				user=textField.getText();
				password=passwordField.getText();
				con=DashboardLogin.getConnection(user, password);
				if(con!=null)
				{
				JOptionPane.showMessageDialog(null, "Database connected");
				Oracle.setText("Oracle Connected");
				status=true;
				textField.setText(null);
				passwordField.setText(null);
				Login_Panel.setVisible(false);
				//con.close();
				
				}
				
			}
			
			
		});
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				user=textField.getText();
				password=passwordField.getText();
				con=DashboardLogin.getConnection(user, password);
				
				if(con!=null)
				{
				JOptionPane.showMessageDialog(null, "Database connected");
				status=true;
				Oracle.setText("Oracle Connected");
				textField.setText(null);
				passwordField.setText(null);
				Login_Panel.setVisible(false);
				//con.close();
				//JOptionPane.showMessageDialog(null, "Database Disconnected");	
				}
				
				
				
			}
		});
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 15));
		btnLogin.setBounds(81, 250, 89, 23);
		Login_Panel.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnClear.setFont(new Font("Verdana", Font.BOLD, 15));
		btnClear.setBounds(233, 250, 89, 23);
		Login_Panel.add(btnClear);
		
		JButton btnClose = new JButton("Close");
		btnClose.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textField.setText(null);
				passwordField.setText(null);
				Login_Panel.setVisible(false);
			}
		});
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
				Login_Panel.setVisible(false);
				
			}
		});
		btnClose.setFont(new Font("Verdana", Font.BOLD, 15));
		btnClose.setBounds(382, 252, 89, 23);
		Login_Panel.add(btnClose);
		
		
		
		JPanel Footer_Panel = new JPanel();
		Footer_Panel.setLayout(null);
		Footer_Panel.setBackground(new Color(165, 42, 42));
		Footer_Panel.setBounds(-11, 473, 964, 141);
		contentPane.add(Footer_Panel);
		JLabel Login_Label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/Person_Login.png")).getImage();
		Login_Label.setIcon(new ImageIcon(img));
		
		Login_Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Login_Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(status)
				{
				UserLogin.main(con);
				setVisible(false);
				}else
					JOptionPane.showMessageDialog(null, "Database Not Connected");
			}
		});
		Login_Label.setBounds(207, 168, 254, 244);
		contentPane.add(Login_Label);
		
		JLabel Register_label = new JLabel("");
		Register_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Register_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(status)
				{
				RegistereUser.main(con);
				setVisible(false);
				}else
					JOptionPane.showMessageDialog(null, "Database Not Connected");
			}
		});
		
		Image img1=new ImageIcon(this.getClass().getResource("/Person_Register.png")).getImage();
		Register_label.setIcon(new ImageIcon(img1));
		Register_label.setBounds(507, 170, 254, 231);
		contentPane.add(Register_label);
		JLabel Login_Label2 = new JLabel("Login");
		
		Login_Label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Login_Label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(status)
				{
				UserLogin.main(con);
				setVisible(false);
				}else
					JOptionPane.showMessageDialog(null, "Database Not Connected");
			}
		});
		Login_Label2.setForeground(new Color(0, 100, 0));
		Login_Label2.setFont(new Font("Verdana", Font.BOLD, 30));
		Login_Label2.setBounds(276, 411, 103, 51);
		contentPane.add(Login_Label2);
		
		JLabel lRegister_Label2 = new JLabel("Sign Up");
		lRegister_Label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lRegister_Label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(status)
				{
				RegistereUser.main(con);
				//setVisible(false);
				}else
					JOptionPane.showMessageDialog(null, "Database Not Connected");
			}
		});
		lRegister_Label2.setForeground(new Color(0, 100, 0));
		lRegister_Label2.setFont(new Font("Verdana", Font.BOLD, 30));
		lRegister_Label2.setBounds(569, 412, 141, 51);
		contentPane.add(lRegister_Label2);
		
	}
	
	
	public static Connection getConnection(String user,String password)
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,password);
		}
		catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Invalid User/Password");

		}
		return con;
	}
	
	
}
