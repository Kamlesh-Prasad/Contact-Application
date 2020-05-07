import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTable;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import Project1991.com.DataBaseConnection;
import net.proteanit.sql.DbUtils;
import javax.swing.JDesktopPane;

public class ContectDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	static private Connection con=null;
	static private PreparedStatement ps=null;
	static private ResultSet rs=null;
	static private String driver="oracle.jdbc.driver.OracleDriver";
	static private String url="jdbc:oracle:thin:@localhost:1521:XE";
	static private String user_name,password;
	static private int x;
	
	private String c_name,nick_name,faimily_name,mobile,home,office,address,relationShip;
	private JTable table;
	
	

	/**
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ContectDetails().setVisible(true);//////////////////////////////////For Test
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public ContectDetails() {
		setTitle("CONTECT INFORMATION");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1020);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setForeground(new Color(220, 220, 220));
		panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "CONTACT INFORMATION", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 30, 688, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblContactName = new JLabel("CONTACT NAME");
		lblContactName.setFont(new Font("Verdana", Font.BOLD, 18));
		lblContactName.setBounds(10, 40, 165, 34);
		panel.add(lblContactName);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 18));
		textField.setBounds(192, 40, 433, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNickName = new JLabel("NICK NAME");
		lblNickName.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNickName.setBounds(10, 102, 165, 34);
		panel.add(lblNickName);
		
		JLabel lblFaimilyName = new JLabel("FAIMILY NAME\r\n");
		lblFaimilyName.setFont(new Font("Verdana", Font.BOLD, 18));
		lblFaimilyName.setBounds(10, 162, 165, 34);
		panel.add(lblFaimilyName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(192, 102, 433, 36);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(192, 160, 433, 36);
		panel.add(textField_2);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setFont(new Font("Verdana", Font.BOLD, 18));
		lblMobile.setBounds(10, 218, 165, 34);
		panel.add(lblMobile);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(192, 218, 217, 36);
		panel.add(textField_3);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setFont(new Font("Verdana", Font.BOLD, 18));
		lblHome.setBounds(10, 274, 165, 34);
		panel.add(lblHome);
		
		JLabel lblOffice = new JLabel("OFFICE");
		lblOffice.setFont(new Font("Verdana", Font.BOLD, 18));
		lblOffice.setBounds(10, 333, 165, 34);
		panel.add(lblOffice);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(192, 265, 217, 36);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.BOLD, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(192, 318, 217, 36);
		panel.add(textField_5);
		
		JLabel lblAdress = new JLabel("ADDRESS");
		lblAdress.setFont(new Font("Verdana", Font.BOLD, 18));
		lblAdress.setBounds(10, 386, 165, 34);
		panel.add(lblAdress);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Verdana", Font.BOLD, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(192, 371, 433, 36);
		panel.add(textField_6);
		
		JLabel lblRelationship = new JLabel("RELATIONSHIP");
		lblRelationship.setFont(new Font("Verdana", Font.BOLD, 18));
		lblRelationship.setBounds(10, 440, 165, 34);
		panel.add(lblRelationship);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//JOptionPane.showMessageDialog(null,e.getItemSelectable());///////////////panding
			}
		});
		comboBox.setForeground(new Color(128, 0, 0));
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"FRIEND", "FAIMILY", "PEOPLE", "OTHER", "CLOSE FRIEND", "OTHER"}));
		comboBox.setBounds(192, 440, 217, 34);
		panel.add(comboBox);
		
		JLabel label = new JLabel("(Optional)");
		label.setForeground(Color.PINK);
		label.setFont(new Font("Verdana", Font.BOLD, 12));
		label.setBounds(419, 265, 105, 34);
		panel.add(label);
		
		JLabel label_1 = new JLabel("(Optional)");
		label_1.setForeground(Color.PINK);
		label_1.setFont(new Font("Verdana", Font.BOLD, 12));
		label_1.setBounds(419, 318, 105, 34);
		panel.add(label_1);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(textField.getText().isEmpty()!=true&&textField_1.getText().isEmpty()!=true&&textField_2.getText().isEmpty()!=true&&textField_3.getText().isEmpty()!=true&&textField_6.getText().isEmpty()!=true)
				{
					if(addContect())
					{	
						JOptionPane.showMessageDialog(null, "Contect Saved");
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						textField_5.setText(null);
						textField_6.setText(null);
						
					}
					else
						JOptionPane.showMessageDialog(null, "Contect Not Saved");

				}else
					JOptionPane.showMessageDialog(null, "Field Are Empty ?");

			}
		});
		btnSave.setBounds(35, 509, 101, 32);
		panel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()!=true&&textField_1.getText().isEmpty()!=true&&textField_2.getText().isEmpty()!=true&&textField_3.getText().isEmpty()!=true&&textField_6.getText().isEmpty()!=true)
				{
					if(addContect())
					{	
						JOptionPane.showMessageDialog(null, "Contect Saved");
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						textField_5.setText(null);
						textField_6.setText(null);
						
					}
					else
						JOptionPane.showMessageDialog(null, "Contect Not Saved");

				}else
					JOptionPane.showMessageDialog(null, "Field Are Empty ?");
			}
		});
		btnSave.setBackground(new Color(153, 204, 0));
		
		JButton btnShow = new JButton("SHOW");
		btnShow.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					ps=con.prepareStatement("SELECT * FROM CONTECT");
					rs=ps.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(685, 38, 598, 552);
		contentPane.add(desktopPane);
		desktopPane.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 598, 562);
		desktopPane.add(scrollPane);
		
		btnShow.setBounds(167, 509, 101, 32);
		panel.add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//panel.setVisible(false);
					desktopPane.setVisible(true);
					scrollPane.setVisible(true);
					ps=con.prepareStatement("SELECT * FROM CONTECT");
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					/*while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
					}*/
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow.setBackground(new Color(102, 205, 170));
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(302, 509, 101, 32);
		panel.add(btnSearch);
		btnSearch.setBackground(Color.ORANGE);
		
		JButton btnDelete = new JButton("RESET");
		btnDelete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				
			}
		});
		btnDelete.setBounds(434, 509, 101, 32);
		panel.add(btnDelete);
		btnDelete.setBackground(new Color(204, 204, 0));
		
		JButton btnClose = new JButton("DELETE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.close();
					System.exit(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnClose.setBounds(564, 509, 101, 32);
		panel.add(btnClose);
		btnClose.setBackground(new Color(255, 215, 0));
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		
	}
	
	
	static boolean connectOracle() throws ClassNotFoundException, SQLException
	{
	Class.forName(driver);
	user_name=LoginContact.textField.getText();
	password=LoginContact.textField_1.getText();
	con=DriverManager.getConnection(url,user_name,password);
	if(con!=null)
	{	
		JOptionPane.showMessageDialog(null,"Database Connected");
		ContectDetails frame = new ContectDetails();
		frame.setVisible(true);
		return true;
	}else
		return false;
	}
	
	
	boolean addContect()
	{
	try
	{	getContect();
	   	ps=con.prepareStatement("SELECT * FROM EMP");
	   	rs=ps.executeQuery();
	   	while(rs.next())
	   	{
	   		x=rs.getInt(1);
	   		
	   	}
	   
	   	
	   	
		ps=con.prepareStatement("insert into contect values(?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, x);
		ps.setString(2,c_name.toUpperCase());
		ps.setString(3,nick_name.toUpperCase());
		ps.setString(4,faimily_name.toUpperCase());
		ps.setString(5,mobile);
		ps.setString(6,home);
		ps.setString(7,office);
		ps.setString(8,address.toUpperCase());
		ps.setString(9,"FRIEND");
		
		
		
		int i=ps.executeUpdate();
		if(i!=0)
		{
			return true;
		}
		
	}
	catch(SQLException e)
	{
		JOptionPane.showMessageDialog(null,e.getMessage());
	}
	
	return false;
	}
	
	void getContect()
	{
		c_name=textField.getText();
		nick_name=textField_1.getText();
		faimily_name=textField_2.getText();
		mobile=textField_3.getText();
		home=textField_3.getText();
		office=textField_4.getText();
		address=textField_5.getText();
		
		
	}

	
}
