import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.Toolkit;


public class LoginContact extends JFrame {

	private JPanel contentPane;
	static public JTextField textField;
	static public JTextField textField_1;
	
	public static LoginContact frame;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame=new LoginContact();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginContact() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Image of Software\\.login.png"));
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
		
		JLabel lblNewLabel_3 = new JLabel("Admin Login");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel_3.setBounds(259, 32, 222, 64);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 20));
		textField.setBounds(195, 132, 401, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setActionCommand("");
		textField_1.setFont(new Font("Verdana", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(195, 216, 401, 39);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorderPainted(false);
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(!textField.getText().isEmpty()&&!textField_1.getText().isEmpty())
					{
						if(ContectDetails.connectOracle())
						{
							//frame.setVisible(false);
						}
						
					}
					else
						JOptionPane.showMessageDialog(null,"Empty User Name or Password");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Invalid User Name or Password");
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!textField.getText().isEmpty()&&!textField_1.getText().isEmpty())
					{
						if(ContectDetails.connectOracle())
						{
							//frame.setVisible(false);
						}else
							JOptionPane.showMessageDialog(null,"Invalid User Name or Password");
						
					}else
						JOptionPane.showMessageDialog(null,"Empty User Name or Password");
				} 
				catch (SQLException e1) 
				{
				// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Database Not Connected");
				}
				catch(ClassNotFoundException e1)
				{
					JOptionPane.showMessageDialog(null,"Database Not Connected");
				}
			}
		});
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton.setBounds(101, 308, 121, 36);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBorderPainted(false);
		btnReset.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				
			}
		});
		btnReset.setBackground(SystemColor.info);
		btnReset.setFont(new Font("Verdana", Font.BOLD, 20));
		btnReset.setBounds(297, 308, 121, 36);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(1);
			}
		});
		btnClose.setBorderPainted(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
				
			}
		});
		btnClose.setFont(new Font("Verdana", Font.BOLD, 20));
		btnClose.setBackground(SystemColor.info);
		btnClose.setBounds(494, 308, 121, 36);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Image of Software\\user_12.png"));
		lblNewLabel_1.setBounds(128, 132, 68, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Image of Software\\pass_1.png"));
		label.setBounds(128, 216, 68, 39);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setDisplayedMnemonic('*');
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Image of Software\\Bg_1.jpg"));
		lblNewLabel_2.setBounds(-14, -11, 772, 417);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
