import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JLayeredPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Connection con=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String name,mobile,email,address,whatsapp;
	String imagepath;
	private JDesktopPane desktopPane,desktopPane_1,desktopPane_2,desktopPane_3,desktopPane_4,desktopPane_5;
	private JTextField Update_Name;
	private JTextField Search_By_Name;
	private JTextField Update_Mobile;
	private JTextField Search_By_Mobile;
	private JTextField Update_Email;
	private JTextField Search_By_Email;
	private JTextField Update_Add;
	private JTextField Search_By_Address;
	String nameIndex= "Name";
	String mobileIndex="Mobile";
	private JTextField Update_WhatsApp;
	private JTable table_3;
	private JTextField textField_11;
	boolean status;
	private JTable Show_Menu_Table;
	private JTextField Search_By_WhatsApp;
	String filename="/Person.png";
	//private JLabel timeLabelss;
	private JTextField textField_12;
	private JTextField Exists_Contact;
	private JTable Show_Table;
	private Color Pane_Color=new Color(128,0,0);
	private Color Button_Color=new Color(220,0,0);
	
	FileInputStream fin;
	private static String Total_Contacts="Total Contacts ";
	private static JLabel Total = new JLabel("");
	public static void main(Connection con2) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
					con=con2;
					OracleDatabae.contactAC(con);
					if(con!=null)
						JOptionPane.showMessageDialog(null, "DataBase Connected");
					Total_Contacts=Total_Contacts+": "+String.valueOf(ShowContact.TotalCotact(con));
					Total.setText(Total_Contacts);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		
		setMaximizedBounds(new Rectangle(0, 0, 1920, 1020));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1297,693);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//con=UserLogin.getConnection();
		
		
		
		desktopPane = new JDesktopPane();
		desktopPane.setVisible(false);
		desktopPane.setBackground(new Color(128, 0, 0));
		desktopPane.setBounds(343, 116, 940, 542);
		contentPane.add(desktopPane);
		
		desktopPane_1 = new JDesktopPane();
		desktopPane_1.setVisible(false);
		desktopPane_1.setBackground(new Color(128, 0, 0));
		desktopPane_1.setBounds(343, 116, 940, 542);
		contentPane.add(desktopPane_1);
		
		desktopPane_2 = new JDesktopPane();
		desktopPane_2.setVisible(false);
		desktopPane_2.setBackground(new Color(128, 0, 0));
		desktopPane_2.setBounds(343, 116, 940, 542);
		contentPane.add(desktopPane_2);
		
		desktopPane_3 = new JDesktopPane();
		desktopPane_3.setVisible(false);
		desktopPane_3.setBackground(new Color(128,0,0));
		desktopPane_3.setBounds(343, 116, 940, 542);
		contentPane.add(desktopPane_3);
		
		desktopPane_4 = new JDesktopPane();
		desktopPane_4.setVisible(false);
		desktopPane_4.setBackground(new Color(128,0,0));
		desktopPane_4.setBounds(343, 116, 940, 542);
		contentPane.add(desktopPane_4);
	

		desktopPane_5 = new JDesktopPane();
		desktopPane_5.setVisible(true);
		desktopPane_5.setBackground(new Color(255, 255, 255));
		desktopPane_5.setBounds(341, 117, 942, 538);
		contentPane.add(desktopPane_5);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(402, 0, 538, 516);
		layeredPane.setVisible(false);
		desktopPane_1.add(layeredPane);//Show_Contac Details
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(433, 11, 497, 517);
		layeredPane_1.setVisible(false);
		desktopPane_2.add(layeredPane_1);//Show_Table
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 497, 467);
		layeredPane_1.add(scrollPane);
		
		Show_Table = new JTable();
		scrollPane.setViewportView(Show_Table);
		
		
		JButton AddMenuBtn = new JButton("Add");
		AddMenuBtn.setForeground(new Color(255, 255, 255));
		JButton SearchMenuBtn = new JButton("Search");
		SearchMenuBtn.setForeground(new Color(255, 255, 255));
		JButton UpdateMenuBtn = new JButton("Update");
		UpdateMenuBtn.setForeground(new Color(255, 255, 255));
		JButton RemoveMenuBtn = new JButton("Remove");
		RemoveMenuBtn.setForeground(new Color(255, 255, 255));
		JButton ShowMenuBtn = new JButton("Show");
		ShowMenuBtn.setForeground(new Color(255, 255, 255));
		JButton ExitMenuBtn = new JButton("Exit");
		ExitMenuBtn.setForeground(new Color(255, 255, 255));
		
		AddMenuBtn.setBackground(Button_Color);
		SearchMenuBtn.setBackground(Button_Color);
		UpdateMenuBtn.setBackground(Button_Color);
		RemoveMenuBtn.setBackground(Button_Color);
		ShowMenuBtn.setBackground(Button_Color);
		ExitMenuBtn.setBackground(Button_Color);
		
		JLabel lblSelectedContact = new JLabel("Name");
		lblSelectedContact.setForeground(new Color(255, 255, 0));
		lblSelectedContact.setFont(new Font("Verdana", Font.BOLD, 30));
		lblSelectedContact.setBounds(20, 418, 121, 37);
		desktopPane_3.add(lblSelectedContact);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Verdana", Font.BOLD, 24));
		textField_11.setBounds(156, 418, 295, 37);
		desktopPane_3.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_11.getText().isEmpty()||!textField_12.getText().isEmpty())
				{
					if(RemoveContact.removeContact(textField_11.getText(),textField_12.getText(),con))
					{
						JOptionPane.showMessageDialog(null, "Successfully Removed");
					rs=ShowContact.ShowAllContact(con);
					if(rs!=null)
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
					else
						JOptionPane.showMessageDialog(null, "Contact Not Show");
				}
					else
						JOptionPane.showMessageDialog(null, "Contact Not Exits");
				}
				else
					JOptionPane.showMessageDialog(null, "Name or Mobile Empty");
			}
		});
		btnRemove_1.setFont(new Font("Verdana", Font.BOLD, 26));
		btnRemove_1.setBounds(210, 477, 171, 37);
		desktopPane_3.add(btnRemove_1);
		
		JLabel lblMobile_1 = new JLabel("Mobile");
		lblMobile_1.setForeground(new Color(255, 255, 0));
		lblMobile_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblMobile_1.setBounds(484, 418, 135, 37);
		desktopPane_3.add(lblMobile_1);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Verdana", Font.BOLD, 24));
		textField_12.setColumns(10);
		textField_12.setBounds(635, 418, 295, 37);
		desktopPane_3.add(textField_12);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				textField_11.setText(null);
				textField_12.setText(null);
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(true);
				
			}
		});
		btnCancel_1.setFont(new Font("Verdana", Font.BOLD, 26));
		btnCancel_1.setBounds(700, 477, 171, 37);
		desktopPane_3.add(btnCancel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(106, 90, 205));
		panel.setBounds(-15, 0, 1319, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Contacts");
		lblNewLabel.setForeground(new Color(250, 235, 215));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 62));
		lblNewLabel.setBounds(542, 11, 423, 83);
		panel.add(lblNewLabel);
		
		JLabel label_10 = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/Person_Add.png")).getImage();
		label_10.setIcon(new ImageIcon(img1));
		label_10.setBounds(43, 11, 254, 244);
		desktopPane_5.add(label_10);
		
		JLabel label_11 = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/Person_Remove.png")).getImage();
		label_11.setIcon(new ImageIcon(img2));
		label_11.setBounds(351, 11, 254, 244);
		desktopPane_5.add(label_11);
		
		JLabel label_12 = new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("/Person_Login.png")).getImage();
		label_12.setIcon(new ImageIcon(img3));
		
		label_12.setBounds(648, 11, 254, 244);
		desktopPane_5.add(label_12);
		
		JLabel label_13 = new JLabel("");
		Image img4=new ImageIcon(this.getClass().getResource("/Person_Register.png")).getImage();
		label_13.setIcon(new ImageIcon(img4));
		label_13.setBounds(53, 266, 254, 244);
		desktopPane_5.add(label_13);
		
		JLabel label_14 = new JLabel("");
		Image img5=new ImageIcon(this.getClass().getResource("/Person_Search.png")).getImage();
		label_14.setIcon(new ImageIcon(img5));
		label_14.setBounds(361, 266, 254, 244);
		desktopPane_5.add(label_14);
		
		JLabel label_15 = new JLabel("");
		Image img6=new ImageIcon(this.getClass().getResource("/Person.png")).getImage();
		label_15.setIcon(new ImageIcon(img6));
		label_15.setBounds(658, 266, 254, 244);
		desktopPane_5.add(label_15);
		
		
		JButton HomeButton = new JButton("");
		HomeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(true);
				
				
				
				
				
				
			}
		});
		Image img7=new ImageIcon(this.getClass().getResource("/Home_Menu2.png")).getImage();
		
		HomeButton.setIcon(new ImageIcon(img7));
		HomeButton.setBounds(43, 11, 100, 100);
		panel.add(HomeButton);
		
		
		
		//JLabel Total = new JLabel(Total_Contacts);
		
		Total.setFont(new Font("Courier New", Font.BOLD, 18));
		Total.setBounds(1012, 35, 248, 50);
		panel.add(Total);
		
		JLabel timeLabel = new JLabel("11:05:30");
		timeLabel.setForeground(Color.ORANGE);
		timeLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		timeLabel.setBounds(280, 33, 124, 49);
		panel.add(timeLabel);
		
		JLabel lblTime = new JLabel("Time: ");
		lblTime.setForeground(Color.ORANGE);
		lblTime.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTime.setBounds(207, 33, 107, 49);
		panel.add(lblTime);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 204));
		panel_1.setBounds(-5, 0, 345, 655);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Name");
		label.setForeground(new Color(245, 255, 250));
		label.setFont(new Font("Verdana", Font.BOLD, 28));
		label.setBounds(103, 43, 214, 38);
		desktopPane.add(label);
		
		textField = new JTextField();
		textField.setForeground(Color.MAGENTA);
		textField.setFont(new Font("Verdana", Font.BOLD, 24));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		textField.setBackground(new Color(139, 0, 0));
		textField.setBounds(103, 92, 359, 38);
		desktopPane.add(textField);
		
		JLabel label_1 = new JLabel("Mobile");
		label_1.setForeground(new Color(245, 255, 250));
		label_1.setFont(new Font("Verdana", Font.BOLD, 28));
		label_1.setBounds(103, 141, 214, 38);
		desktopPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.MAGENTA);
		textField_1.setFont(new Font("Verdana", Font.BOLD, 24));
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBackground(new Color(139, 0, 0));
		textField_1.setBounds(103, 190, 359, 38);
		desktopPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Email ID");
		label_2.setForeground(new Color(245, 255, 250));
		label_2.setFont(new Font("Verdana", Font.BOLD, 28));
		label_2.setBounds(103, 239, 214, 38);
		desktopPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.MAGENTA);
		textField_2.setFont(new Font("Verdana", Font.BOLD, 24));
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		textField_2.setBackground(new Color(139, 0, 0));
		textField_2.setBounds(103, 288, 359, 38);
		desktopPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Address");
		label_3.setForeground(new Color(245, 255, 250));
		label_3.setFont(new Font("Verdana", Font.BOLD, 28));
		label_3.setBounds(103, 337, 214, 38);
		desktopPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.MAGENTA);
		textField_3.setFont(new Font("Verdana", Font.BOLD, 24));
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		textField_3.setBackground(new Color(139, 0, 0));
		textField_3.setBounds(103, 386, 359, 38);
		desktopPane.add(textField_3);
		
		JLabel label_4 = new JLabel("WhatsApp");
		label_4.setForeground(new Color(245, 255, 250));
		label_4.setFont(new Font("Verdana", Font.BOLD, 28));
		label_4.setBounds(103, 435, 214, 38);
		desktopPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.MAGENTA);
		textField_4.setFont(new Font("Verdana", Font.BOLD, 24));
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		textField_4.setBackground(new Color(139, 0, 0));
		textField_4.setBounds(103, 484, 359, 38);
		desktopPane.add(textField_4);
		
		JLabel choicedImage = new JLabel("");
		Image img8=new ImageIcon(this.getClass().getResource("/Person.png")).getImage();
		
		choicedImage.setIcon(new ImageIcon(img8));
		choicedImage.setBounds(572, 42, 234, 235);
		desktopPane.add(choicedImage);
		
		JButton button = new JButton("Save");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().isEmpty()&&!textField_1.getText().isEmpty()&&!textField_2.getText().isEmpty()&&!textField_3.getText().isEmpty()&&!textField_4.getText().isEmpty())
				{
					
					try {
						fin = new FileInputStream(filename);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
					
					AddContact add=new AddContact();
					status=add.addContact(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),fin,con);
					if(status)
					{
						JOptionPane.showMessageDialog(null,"Contact Successfully Saved");
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						Image img9=new ImageIcon(this.getClass().getResource("/Person.png")).getImage();
						
						choicedImage.setIcon(new ImageIcon(img9));
						filename=null;
						
						
					}
					else
						JOptionPane.showMessageDialog(null,"Contact Not Save");
				}
				else
					JOptionPane.showMessageDialog(null,"Fill All Details");
			}
		});
		button.setForeground(new Color(0, 128, 0));
		button.setFont(new Font("Verdana", Font.BOLD, 30));
		button.setBounds(521, 454, 146, 44);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				Image img7=new ImageIcon(this.getClass().getResource("/people.jpg")).getImage();
				
				choicedImage.setText("/people.jpg");
				
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(true);
				
			}
		});
		button_1.setForeground(new Color(0, 128, 0));
		button_1.setFont(new Font("Verdana", Font.BOLD, 30));
		button_1.setBounds(729, 454, 146, 44);
		desktopPane.add(button_1);
		
		
		
		JButton button_2 = new JButton("Choice Image");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc=new JFileChooser();
			
				int i=fc.showOpenDialog(null);
				if(i==JFileChooser.APPROVE_OPTION)
				{
					try
					{
						File file=fc.getSelectedFile();
						filename=file.getAbsolutePath();
						//ImageIcon icon=new ImageIcon(filename);//With fixed height and width
						
						ImageIcon icon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(choicedImage.getWidth(),choicedImage.getHeight(),Image.SCALE_SMOOTH));
						choicedImage.setIcon(icon);
					}
					catch(Exception ee)
					{
						
					}
					//choicedImage.setIcon(new ImageIcon(file));
				}
			}
		});
		button_2.setForeground(Color.BLUE);
		button_2.setFont(new Font("Verdana", Font.BOLD, 18));
		button_2.setBounds(572, 300, 236, 38);
		desktopPane.add(button_2);
		
		
		
		
		
		AddMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMenuBtn.setBackground(Pane_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				
				desktopPane.setVisible(true);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(false);
				layeredPane.setVisible(false);
				layeredPane_1.setVisible(false);
				
			}
		});
		//AddMenuBtn.setBackground(new Color(0, 128, 128));
		AddMenuBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddMenuBtn.setFont(new Font("Verdana", Font.BOLD, 30));
		
		AddMenuBtn.setBounds(0, 120, 360, 84);
		panel_1.add(AddMenuBtn);
		
		
		JLabel lblContactName = new JLabel("Contact name");
		label.setForeground(new Color(245, 255, 250));
		label.setFont(new Font("Verdana", Font.BOLD, 28));
		label.setBounds(103, 43, 214, 38);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 920, 471);
		desktopPane_4.add(scrollPane_1);
		
		Show_Menu_Table = new JTable();
		scrollPane_1.setViewportView(Show_Menu_Table);
		desktopPane_4.add(lblContactName);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 24));
		btnNewButton.setBounds(403, 493, 136, 38);
		desktopPane_4.add(btnNewButton);
		
		
		JLabel Search_lb_Name = new JLabel("Name");
		Search_lb_Name.setForeground(new Color(245, 255, 250));
		Search_lb_Name.setFont(new Font("Verdana", Font.BOLD, 28));
		Search_lb_Name.setBounds(64, 0, 214, 38);
		desktopPane_1.add(Search_lb_Name);
		
		Search_By_Name = new JTextField();
		Search_By_Name.setForeground(Color.MAGENTA);
		Search_By_Name.setFont(new Font("Verdana", Font.BOLD, 24));
		Search_By_Name.setColumns(10);
		Search_By_Name.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Search_By_Name.setBackground(new Color(139, 0, 0));
		Search_By_Name.setBounds(64, 49, 318, 38);
		desktopPane_1.add(Search_By_Name);
		
		
		JLabel Search_lb_Mobile = new JLabel("Mobile");
		Search_lb_Mobile.setForeground(new Color(245, 255, 250));
		Search_lb_Mobile.setFont(new Font("Verdana", Font.BOLD, 28));
		Search_lb_Mobile.setBounds(64, 98, 214, 38);
		desktopPane_1.add(Search_lb_Mobile);
		
		Search_By_Mobile = new JTextField();
		Search_By_Mobile.setForeground(Color.MAGENTA);
		Search_By_Mobile.setFont(new Font("Verdana", Font.BOLD, 24));
		Search_By_Mobile.setColumns(10);
		Search_By_Mobile.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Search_By_Mobile.setBackground(new Color(139, 0, 0));
		Search_By_Mobile.setBounds(64, 147, 318, 38);
		desktopPane_1.add(Search_By_Mobile);
		
		JLabel Search_lb_Email = new JLabel("Email ID");
		Search_lb_Email.setForeground(new Color(245, 255, 250));
		Search_lb_Email.setFont(new Font("Verdana", Font.BOLD, 28));
		Search_lb_Email.setBounds(64, 196, 214, 38);
		desktopPane_1.add(Search_lb_Email);
		
		Search_By_Email = new JTextField();
		Search_By_Email.setForeground(Color.MAGENTA);
		Search_By_Email.setFont(new Font("Verdana", Font.BOLD, 24));
		Search_By_Email.setColumns(10);
		Search_By_Email.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Search_By_Email.setBackground(new Color(139, 0, 0));
		Search_By_Email.setBounds(64, 245, 318, 38);
		desktopPane_1.add(Search_By_Email);
		
		JLabel Search_lb_Add = new JLabel("Address");
		Search_lb_Add.setForeground(new Color(245, 255, 250));
		Search_lb_Add.setFont(new Font("Verdana", Font.BOLD, 28));
		Search_lb_Add.setBounds(64, 294, 214, 38);
		desktopPane_1.add(Search_lb_Add);
		
		Search_By_Address = new JTextField();
		Search_By_Address.setForeground(Color.MAGENTA);
		Search_By_Address.setFont(new Font("Verdana", Font.BOLD, 24));
		Search_By_Address.setColumns(10);
		Search_By_Address.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Search_By_Address.setBackground(new Color(139, 0, 0));
		Search_By_Address.setBounds(64, 343, 318, 38);
		desktopPane_1.add(Search_By_Address);
		
		JLabel Search_lb_WhatsApp = new JLabel("WhatsApp");
		Search_lb_WhatsApp.setForeground(new Color(245, 255, 250));
		Search_lb_WhatsApp.setFont(new Font("Verdana", Font.BOLD, 28));
		Search_lb_WhatsApp.setBounds(64, 392, 214, 38);
		desktopPane_1.add(Search_lb_WhatsApp);

		
		
		
		
		/////////////
		
		Search_By_WhatsApp = new JTextField();
		Search_By_WhatsApp.setForeground(Color.MAGENTA);
		Search_By_WhatsApp.setFont(new Font("Verdana", Font.BOLD, 24));
		Search_By_WhatsApp.setColumns(10);
		Search_By_WhatsApp.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Search_By_WhatsApp.setBackground(new Color(139, 0, 0));
		Search_By_WhatsApp.setBounds(64, 447, 318, 38);
		desktopPane_1.add(Search_By_WhatsApp);
		
		JLabel label_111 = new JLabel("(Optional)");
		label_111.setForeground(new Color(255, 69, 0));
		label_111.setFont(new Font("Verdana", Font.BOLD, 17));
		label_111.setBounds(243, 196, 139, 40);
		desktopPane_1.add(label_111);
		
		JLabel label_121 = new JLabel("(Optional)");
		label_121.setForeground(new Color(255, 69, 0));
		label_121.setFont(new Font("Verdana", Font.BOLD, 17));
		label_121.setBounds(243, 294, 139, 40);
		desktopPane_1.add(label_121);
		
		JLabel label_131 = new JLabel("(Optional)");
		label_131.setForeground(new Color(255, 69, 0));
		label_131.setFont(new Font("Verdana", Font.BOLD, 17));
		label_131.setBounds(243, 392, 139, 40);
		desktopPane_1.add(label_131);
		//////////////////////////////////////
		
		JLabel Searched_Name = new JLabel("Name");
		Searched_Name.setForeground(new Color(255, 69, 0));
		Searched_Name.setFont(new Font("Verdana", Font.BOLD, 17));
		Searched_Name.setBounds(36, 162, 90, 40);
		layeredPane.add(Searched_Name);
		
		JLabel Searched_Mobile = new JLabel("Mobile");
		Searched_Mobile.setForeground(new Color(255, 69, 0));
		Searched_Mobile.setFont(new Font("Verdana", Font.BOLD, 17));
		Searched_Mobile.setBounds(36, 213, 90, 40);
		layeredPane.add(Searched_Mobile);
		
		JLabel Search_Email = new JLabel("Email");
		Search_Email.setForeground(new Color(255, 69, 0));
		Search_Email.setFont(new Font("Verdana", Font.BOLD, 17));
		Search_Email.setBounds(36, 264, 90, 40);
		layeredPane.add(Search_Email);
		
		JLabel Searched_Add = new JLabel("Address");
		Searched_Add.setForeground(new Color(255, 69, 0));
		Searched_Add.setFont(new Font("Verdana", Font.BOLD, 17));
		Searched_Add.setBounds(36, 315, 90, 40);
		layeredPane.add(Searched_Add);
		
		JLabel Searched_whatsApp = new JLabel("WhatsApp");
		Searched_whatsApp.setForeground(new Color(255, 69, 0));
		Searched_whatsApp.setFont(new Font("Verdana", Font.BOLD, 17));
		Searched_whatsApp.setBounds(36, 366, 106, 40);
		layeredPane.add(Searched_whatsApp);
		
		JLabel Created_Date1 = new JLabel("Created Date");
		Created_Date1.setForeground(new Color(255, 69, 0));
		Created_Date1.setFont(new Font("Verdana", Font.BOLD, 17));
		Created_Date1.setBounds(36, 414, 127, 40);
		layeredPane.add(Created_Date1);
		
		JLabel Current_Date1 = new JLabel("Current Date");
		Current_Date1.setForeground(new Color(255, 69, 0));
		Current_Date1.setFont(new Font("Verdana", Font.BOLD, 17));
		Current_Date1.setBounds(36, 465, 127, 40);
		layeredPane.add(Current_Date1);
		
		JLabel C_Image = new JLabel("");
		Image img11=new ImageIcon(this.getClass().getResource("/Person.png")).getImage();
		C_Image.setIcon(new ImageIcon(img11));
		C_Image.setBounds(210, 11, 150, 158);
		layeredPane.add(C_Image);
		
		JLabel C_Name = new JLabel("Ansh Dwivedi");
		C_Name.setForeground(new Color(255, 255, 0));
		C_Name.setFont(new Font("Verdana", Font.BOLD, 17));
		C_Name.setBounds(177, 162, 351, 40);
		
		
		JLabel C_Mobile = new JLabel("8602691052");
		C_Mobile.setForeground(Color.YELLOW);
		C_Mobile.setFont(new Font("Verdana", Font.BOLD, 17));
		C_Mobile.setBounds(177, 213, 351, 40);
		
		
		JLabel C_Mail = new JLabel("anshdwivedi@gmail.com");
		C_Mail.setForeground(Color.YELLOW);
		C_Mail.setFont(new Font("Verdana", Font.BOLD, 17));
		C_Mail.setBounds(177, 264, 351, 40);
		
		
		JLabel C_Address = new JLabel("Satna");
		C_Address.setForeground(Color.YELLOW);
		C_Address.setFont(new Font("Verdana", Font.BOLD, 17));
		C_Address.setBounds(177, 315, 351, 40);
		
		
		JLabel C_WhatsApp = new JLabel("8602691052");
		C_WhatsApp.setForeground(Color.YELLOW);
		C_WhatsApp.setFont(new Font("Verdana", Font.BOLD, 17));
		C_WhatsApp.setBounds(177, 366, 351, 40);
		
		
		JLabel Created_Data = new JLabel("30-07-2019");
		Created_Data.setForeground(Color.YELLOW);
		Created_Data.setFont(new Font("Verdana", Font.BOLD, 17));
		Created_Data.setBounds(177, 414, 351, 40);
		layeredPane.add(Created_Data);
		
		JLabel Current_Data = new JLabel("30-07-2019");
		Current_Data.setForeground(Color.YELLOW);
		Current_Data.setFont(new Font("Verdana", Font.BOLD, 17));
		Current_Data.setBounds(177, 465, 351, 40);
		layeredPane.add(Current_Data);
		
		C_Name.setText(null);
		C_Mobile.setText(null);
		C_Mail.setText(null);
		C_Address.setText(null);
		C_WhatsApp.setText(null);
		
		layeredPane.add(C_Name);
		layeredPane.add(C_Mobile);
		layeredPane.add(C_Mail);
		layeredPane.add(C_Address);
		layeredPane.add(C_WhatsApp);
		////////////////////////////////////////
		JButton Search_Button = new JButton("Search");
		Search_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rs=SearchContact.searchContact(Search_By_Name.getText(),Search_By_Mobile.getText(),con);
				if(rs!=null)
				{
					layeredPane.setVisible(true);
					try {
						
						if(rs.next())
						{
							C_Name.setText(rs.getString(2));
							C_Mobile.setText(rs.getString(3));
							C_Mail.setText(rs.getString(4));
							C_Address.setText(rs.getString(5));
							C_WhatsApp.setText(rs.getString(6));
							byte[] img=rs.getBytes(7);
							
							ImageIcon icon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(choicedImage.getWidth(),choicedImage.getHeight(),Image.SCALE_SMOOTH));
							C_Image.setIcon(icon);
							
							
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Contact Not Found");
				
				
			}
		});
		
		Search_Button.setFont(new Font("Verdana", Font.BOLD, 22));
		Search_Button.setBounds(64, 491, 139, 31);
		desktopPane_1.add(Search_Button);
		
		JButton Cancel_Button = new JButton("Cancel");
		Cancel_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				Search_By_Name.setText(null);
				Search_By_Mobile.setText(null);
				Search_By_Email.setText(null);
				Search_By_Address.setText(null);
				Search_By_WhatsApp.setText(null);
				
				
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(true);
				
				
			}
		});
		Cancel_Button.setFont(new Font("Verdana", Font.BOLD, 22));
		Cancel_Button.setBounds(243, 491, 139, 31);
		desktopPane_1.add(Cancel_Button);
		
		
	
		SearchMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Pane_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				desktopPane.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(false);
				layeredPane.setVisible(false);
				layeredPane_1.setVisible(false);
				desktopPane_1.setVisible(true);
			}
		});
		//SearchMenuBtn.setBackground(new Color(0, 128, 128));
		SearchMenuBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SearchMenuBtn.setFont(new Font("Verdana", Font.BOLD, 30));
		
		SearchMenuBtn.setBounds(0, 209, 360, 84);
		panel_1.add(SearchMenuBtn);
		
		
		JLabel Upadta_lb_name = new JLabel("Name");
		Upadta_lb_name.setForeground(new Color(245, 255, 250));
		Upadta_lb_name.setFont(new Font("Verdana", Font.BOLD, 28));
		Upadta_lb_name.setBounds(64, 0, 214, 38);
		desktopPane_2.add(Upadta_lb_name);
		
		Update_Name = new JTextField();
		Update_Name.setToolTipText("Search By Name");
		Update_Name.setForeground(Color.MAGENTA);
		Update_Name.setFont(new Font("Verdana", Font.BOLD, 24));
		Update_Name.setColumns(10);
		Update_Name.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Update_Name.setBackground(new Color(139, 0, 0));
		Update_Name.setBounds(64, 49, 359, 38);
		desktopPane_2.add(Update_Name);
		
		JLabel Update_lb_Mobile = new JLabel("Mobile");
		Update_lb_Mobile.setForeground(new Color(245, 255, 250));
		Update_lb_Mobile.setFont(new Font("Verdana", Font.BOLD, 28));
		Update_lb_Mobile.setBounds(64, 98, 214, 38);
		desktopPane_2.add(Update_lb_Mobile);
		
		Update_Mobile = new JTextField();
		Update_Mobile.setToolTipText("Enter Exists Contact Mobile");
		Update_Mobile.setForeground(Color.MAGENTA);
		Update_Mobile.setFont(new Font("Verdana", Font.BOLD, 24));
		Update_Mobile.setColumns(10);
		Update_Mobile.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Update_Mobile.setBackground(new Color(139, 0, 0));
		Update_Mobile.setBounds(64, 147, 359, 38);
		desktopPane_2.add(Update_Mobile);
		
		JLabel Update_lb_Email = new JLabel("Email ID");
		Update_lb_Email.setForeground(new Color(245, 255, 250));
		Update_lb_Email.setFont(new Font("Verdana", Font.BOLD, 28));
		Update_lb_Email.setBounds(64, 196, 214, 38);
		desktopPane_2.add(Update_lb_Email);
		
		Update_Email = new JTextField();
		Update_Email.setForeground(Color.MAGENTA);
		Update_Email.setFont(new Font("Verdana", Font.BOLD, 24));
		Update_Email.setColumns(10);
		Update_Email.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Update_Email.setBackground(new Color(139, 0, 0));
		Update_Email.setBounds(64, 245, 359, 38);
		desktopPane_2.add(Update_Email);
		
		JLabel Update_lb_Add = new JLabel("Address");
		Update_lb_Add.setForeground(new Color(245, 255, 250));
		Update_lb_Add.setFont(new Font("Verdana", Font.BOLD, 28));
		Update_lb_Add.setBounds(64, 294, 214, 38);
		desktopPane_2.add(Update_lb_Add);
		
		Update_Add = new JTextField();
		Update_Add.setForeground(Color.MAGENTA);
		Update_Add.setFont(new Font("Verdana", Font.BOLD, 24));
		Update_Add.setColumns(10);
		Update_Add.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Update_Add.setBackground(new Color(139, 0, 0));
		Update_Add.setBounds(64, 343, 359, 38);
		desktopPane_2.add(Update_Add);
		
		JLabel Update_lb_WhatsApp = new JLabel("WhatsApp");
		Update_lb_WhatsApp.setForeground(new Color(245, 255, 250));
		Update_lb_WhatsApp.setFont(new Font("Verdana", Font.BOLD, 28));
		Update_lb_WhatsApp.setBounds(64, 392, 214, 38);
		desktopPane_2.add(Update_lb_WhatsApp);
		
		Update_WhatsApp = new JTextField();
		Update_WhatsApp.setForeground(Color.MAGENTA);
		Update_WhatsApp.setFont(new Font("Verdana", Font.BOLD, 24));
		Update_WhatsApp.setColumns(10);
		Update_WhatsApp.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Update_WhatsApp.setBackground(new Color(139, 0, 0));
		Update_WhatsApp.setBounds(64, 441, 359, 38);
		desktopPane_2.add(Update_WhatsApp);
		
		JLabel Update_image = new JLabel("");
		Image img12=new ImageIcon(this.getClass().getResource("/Person.png")).getImage();
		
		Update_image.setIcon(new ImageIcon(img12));
		Update_image.setBounds(584, 35, 250, 230);
		desktopPane_2.add(Update_image);
		
		JLabel Exists_lb_Contact = new JLabel("Exists Contact Name");
		Exists_lb_Contact.setForeground(new Color(255, 255, 255));
		Exists_lb_Contact.setFont(new Font("Verdana", Font.BOLD, 28));
		Exists_lb_Contact.setBounds(547, 392, 337, 38);
		desktopPane_2.add(Exists_lb_Contact);
		
		Exists_Contact = new JTextField();
		Exists_Contact.setToolTipText("Enter Mobile No");
		Exists_Contact.setForeground(new Color(0, 255, 255));
		Exists_Contact.setFont(new Font("Verdana", Font.BOLD, 24));
		Exists_Contact.setColumns(10);
		Exists_Contact.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		Exists_Contact.setBackground(new Color(139, 0, 0));
		Exists_Contact.setBounds(513, 441, 359, 38);
		desktopPane_2.add(Exists_Contact);
		
		
		JButton Update_Button = new JButton("Update");
		Update_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(!Update_Name.getText().isEmpty()&&!Update_Mobile.getText().isEmpty()&&!Update_Email.getText().isEmpty()&&!Update_Add.getText().isEmpty()&&!Update_WhatsApp.getText().isEmpty())
				{
					try {
						fin = new FileInputStream(filename);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					boolean status=UpdateContact.updateContact(Update_Name.getText(), Update_Mobile.getText(), Update_Email.getText(), Update_Add.getText(), Update_WhatsApp.getText(),Exists_Contact.getText(),Exists_Contact.getText(),fin,con);
					if(status)
					{
						JOptionPane.showMessageDialog(null,"Contact Successfully Updated");
						Update_Name.setText(null);
						Update_Mobile.setText(null);
						Update_Email.setText(null);
						Update_Add.setText(null);
						Update_WhatsApp.setText(null);
						Exists_Contact.setText(null);
						//filename=null;
						Image img13=new ImageIcon(this.getClass().getResource("/Person.png")).getImage();
						Update_image.setIcon(new ImageIcon(img13));
						
					}
					else
						JOptionPane.showMessageDialog(null,"Contact Not Updated");
				}
				else
					JOptionPane.showMessageDialog(null,"Fill All Details");
			
			}
		});
		Update_Button.setFont(new Font("Verdana", Font.BOLD, 20));
		Update_Button.setBounds(64, 490, 115, 38);
		desktopPane_2.add(Update_Button);
		
		JButton Update_Cancel_btn = new JButton("Cancel");
		Update_Cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				textField.setText(null);
				Update_Name.setText(null);
				Update_Mobile.setText(null);
				Update_Email.setText(null);
				Update_Add.setText(null);
				Update_WhatsApp.setText(null);
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(true);
				
				
			}
		});
		Update_Cancel_btn.setFont(new Font("Verdana", Font.BOLD, 20));
		Update_Cancel_btn.setBounds(186, 490, 115, 38);
		desktopPane_2.add(Update_Cancel_btn);
		
		
		
		
		
		JButton Reset_button = new JButton("Reset");
		JButton Search_Exists_Contact_btn = new JButton("Search");
		
		Show_Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				rs=SearchContact.searchContact(Update_Name.getText(),Exists_Contact.getText(),con);
				
				if(rs!=null)
				{
					try {
						if(rs.next())
						{
							Update_Name.setText(rs.getString(2));
							Update_Mobile.setText(rs.getString(3));
							Update_Email.setText(rs.getString(4));
							Update_Add.setText(rs.getString(5));
							Update_WhatsApp.setText(rs.getString(6));
							byte[] img=rs.getBytes(7);
							
							ImageIcon icon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(choicedImage.getWidth(),choicedImage.getHeight(),Image.SCALE_SMOOTH));
							C_Image.setIcon(icon);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
					JOptionPane.showMessageDialog(null, "Contact Not Exsts");
				
				
				
			}
		});
		
		JButton Close_Table = new JButton("Close Show");
		Close_Table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.setVisible(false);
				Reset_button.setVisible(true);
				Search_Exists_Contact_btn.setVisible(true);
			}
		});
		Close_Table.setFont(new Font("Verdana", Font.BOLD, 20));
		Close_Table.setBounds(162, 478, 198, 39);
		layeredPane_1.add(Close_Table);
		
		
		
		JButton showTableBtn = new JButton("Show");
		showTableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				layeredPane_1.setVisible(true);
				Reset_button.setVisible(false);
				Search_Exists_Contact_btn.setVisible(false);
				
				rs=ShowContact.ShowAllContact(con);
				if(rs!=null)
					{
					Show_Table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				else
					JOptionPane.showMessageDialog(null, "Contact Not Show");
				
				
				/*if(con!=null) {
					new ShowContact();
					rs=ShowContact.ShowAllContact(con);
					if(rs!=null) {
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
						int i=table_3.getSelectedRow();
						System.out.println(i);
					}
					else
						JOptionPane.showMessageDialog(null, "Contact Not Show");
				}
				else
					JOptionPane.showMessageDialog(null, "Database Not Connected");*/
				
				
			}
		});
		showTableBtn.setFont(new Font("Verdana", Font.BOLD, 20));
		showTableBtn.setBounds(308, 490, 115, 38);
		desktopPane_2.add(showTableBtn);
		
		
		
		
		
		
		
		JButton Update_Choice_Btn = new JButton("Choice Image");
		Update_Choice_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				
				int i=fc.showOpenDialog(null);
				if(i==JFileChooser.APPROVE_OPTION)
				{
					try
					{
						File file=fc.getSelectedFile();
						filename=file.getAbsolutePath();
						//ImageIcon icon=new ImageIcon(filename);//With fixed height and width
						
						ImageIcon icon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(Update_image.getWidth(),Update_image.getHeight(),Image.SCALE_SMOOTH));
						Update_image.setIcon(icon);
					}
					catch(Exception ee)
					{
						
					}
					//choicedImage.setIcon(new ImageIcon(file));
				}
			}
		});
		Update_Choice_Btn.setFont(new Font("Verdana", Font.BOLD, 20));
		Update_Choice_Btn.setBounds(584, 298, 250, 38);
		desktopPane_2.add(Update_Choice_Btn);
		
		
		
		
		Search_Exists_Contact_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				rs=SearchContact.searchContact(Exists_Contact.getText(),Update_Name.getText(), con);
				if(rs!=null)
				{
					try {
						if(rs.next())
						{
							Update_Name.setText(rs.getString(2));
							Update_Mobile.setText(rs.getString(3));
							Update_Email.setText(rs.getString(4));
							Update_Add.setText(rs.getString(5));
							Update_WhatsApp.setText(rs.getString(6));
							
							byte[] img=rs.getBytes(7);
							ImageIcon icon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(choicedImage.getWidth(),choicedImage.getHeight(),Image.SCALE_SMOOTH));
							Update_image.setIcon(icon);
							
							Image img1=icon.getImage();
							filename=img1.toString();
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Contact Not Found");
				
			}
		});
		Search_Exists_Contact_btn.setFont(new Font("Verdana", Font.BOLD, 20));
		Search_Exists_Contact_btn.setBounds(564, 490, 115, 38);
		desktopPane_2.add(Search_Exists_Contact_btn);
		
		
		Reset_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Name.setText(null);
				Update_Mobile.setText(null);
				Update_Email.setText(null);
				Update_Add.setText(null);
				Update_WhatsApp.setText(null);
				Exists_Contact.setText(null);
				Exists_Contact.setText(null);
				Image img14=new ImageIcon(this.getClass().getResource("/Person.png")).getImage();
				
				Update_image.setIcon(new ImageIcon(img14));
				
				
				
			}
		});
		Reset_button.setFont(new Font("Verdana", Font.BOLD, 20));
		Reset_button.setBounds(721, 490, 115, 38);
		desktopPane_2.add(Reset_button);
		
		
		
		
		UpdateMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Pane_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				desktopPane_3.setVisible(false);
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_5.setVisible(false);
				desktopPane_4.setVisible(false);
				layeredPane.setVisible(false);
				layeredPane_1.setVisible(false);
				desktopPane_2.setVisible(true);
				
			
				
				
			}
		});
		//UpdateMenuBtn.setBackground(new Color(0, 128, 128));
		UpdateMenuBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		UpdateMenuBtn.setFont(new Font("Verdana", Font.BOLD, 30));
		
		UpdateMenuBtn.setBounds(0, 298, 360, 84);
		panel_1.add(UpdateMenuBtn);
			
		table_3 = new JTable();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 920, 396);
		scrollPane_2.setVisible(true);
		desktopPane_3.add(scrollPane_2);
		scrollPane_2.setViewportView(table_3);
		
		
		RemoveMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Pane_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_5.setVisible(false);
				layeredPane.setVisible(false);
				layeredPane_1.setVisible(false);
				
				desktopPane_3.setVisible(true);
				
				
				rs=ShowContact.ShowAllContact(con);
				if(rs!=null)
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
				else
					JOptionPane.showMessageDialog(null, "Contact Not Show");
				
				
				
				
				
				/*if(con!=null) {
					new ShowContact();
					rs=ShowContact.ShowAllContact(con);
					if(rs!=null)
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
					else
						JOptionPane.showMessageDialog(null, "Contact Not Show");
				}
				else
					JOptionPane.showMessageDialog(null, "Database Not Connected");*/
			}
		});
		//RemoveMenuBtn.setBackground(new Color(0, 128, 128));
		RemoveMenuBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RemoveMenuBtn.setFont(new Font("Verdana", Font.BOLD, 30));
		
		RemoveMenuBtn.setBounds(0, 387, 360, 84);
		panel_1.add(RemoveMenuBtn);
		
		
		//ExitMenuBtn.setBackground(new Color(0, 128, 128));
		ExitMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Button_Color);
				ExitMenuBtn.setBackground(Pane_Color);
				
				try {
					
					
					if(0==JOptionPane.showConfirmDialog(null, "Do You Want To Close Application"))
					{
						if(con!=null)
						con.close();
						JOptionPane.showMessageDialog(null, "DataBase Disconnected");
						System.exit(0);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		ExitMenuBtn.setFocusable(false);
		ExitMenuBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExitMenuBtn.setFont(new Font("Verdana", Font.BOLD, 30));
		
		ExitMenuBtn.setBounds(0, 565, 360, 84);
		panel_1.add(ExitMenuBtn);
		
		
		ShowMenuBtn.setBounds(0, 476, 360, 84);
		panel_1.add(ShowMenuBtn);
		ShowMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				AddMenuBtn.setBackground(Button_Color);
				SearchMenuBtn.setBackground(Button_Color);
				UpdateMenuBtn.setBackground(Button_Color);
				RemoveMenuBtn.setBackground(Button_Color);
				ShowMenuBtn.setBackground(Pane_Color);
				ExitMenuBtn.setBackground(Button_Color);
				
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(true);
				layeredPane.setVisible(false);
				layeredPane_1.setVisible(false);
				desktopPane_5.setVisible(false);
				
				
				if(con!=null) {
					new ShowContact();
					rs=ShowContact.ShowAllContact(con);
					if(rs!=null)
						Show_Menu_Table.setModel(DbUtils.resultSetToTableModel(rs));
					else
						JOptionPane.showMessageDialog(null, "Contact Not Show");
				}
				else
					JOptionPane.showMessageDialog(null, "Database Not Connected");
				
			}
		});
		ShowMenuBtn.setFont(new Font("Verdana", Font.BOLD, 30));
		ShowMenuBtn.setFocusable(false);
		//ShowMenuBtn.setBackground(new Color(0, 128, 128));
		
		
		
		
		
		
		
		
		
	}
}
