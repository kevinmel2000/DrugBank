import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;


public class AdminWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void AdminWin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow window = new AdminWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.setBounds(100, 100, 742, 604);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddDrug = new JButton("Add");
		btnAddDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddDrugWindow.addDrug();
			}
		});
		btnAddDrug.setBackground(new Color(211, 211, 211));
		btnAddDrug.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAddDrug.setBounds(423, 162, 223, 23);
		frame.getContentPane().add(btnAddDrug);
		
		JButton btnRemoveDrug = new JButton("Remove");
		btnRemoveDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveDrugWindow.removeDrug();
			}
		});
		btnRemoveDrug.setBackground(new Color(211, 211, 211));
		btnRemoveDrug.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRemoveDrug.setBounds(423, 206, 223, 23);
		frame.getContentPane().add(btnRemoveDrug);
		
		JLabel lblWelcome = new JLabel("Admin");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 24));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(239, 73, 266, 32);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblFoundNewDrug = new JLabel("Found New Drug To Add?");
		lblFoundNewDrug.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFoundNewDrug.setBounds(98, 161, 323, 23);
		frame.getContentPane().add(lblFoundNewDrug);
		
		JLabel lblWantToRemove = new JLabel("Want To Remove Drug(s)?");
		lblWantToRemove.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWantToRemove.setBounds(98, 206, 323, 23);
		frame.getContentPane().add(lblWantToRemove);
		
		JLabel lblIfYouForgot = new JLabel("Want Changes In Admin Panel?");
		lblIfYouForgot.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIfYouForgot.setBounds(98, 348, 407, 35);
		frame.getContentPane().add(lblIfYouForgot);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblId.setBounds(226, 395, 98, 25);
		frame.getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(226, 432, 98, 25);
		frame.getContentPane().add(lblPassword);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					java.sql.Connection conn=MySqlConnectClass.connectDb();
					
					PreparedStatement pst=(PreparedStatement) conn.prepareStatement("select *from UserPassword where User=? and Password=?");
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					if(rs.next()){
						pst=(PreparedStatement) conn.prepareStatement("delete from UserPassword where User=? and Password=?");
						pst.setString(1, textField.getText());
						pst.setString(2, passwordField.getText());
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "Succesfully Removed!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Unable To Remove! User Information Didn't Matched!");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemove.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRemove.setBackground(new Color(211, 211, 211));
		btnRemove.setBounds(317, 498, 117, 25);
		frame.getContentPane().add(btnRemove);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(342, 395, 114, 25);
		frame.getContentPane().add(textField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String s1=textField.getText();
					String s2=passwordField.getText();
					
					java.sql.Connection conn=MySqlConnectClass.connectDb();
					
					PreparedStatement pst=(PreparedStatement) conn.prepareStatement("select *from UserPassword where User=?");
					pst.setString(1, s1);
					
					ResultSet rs=pst.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null,"Unable To Create User! This ID Is Already Registered!");
					}
					else {
						pst=(PreparedStatement) conn.prepareStatement("insert into UserPassword(User,Password) values(?,?)");
						pst.setString(1,s1 );
						pst.setString(2, s2);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Succesfully Registered!");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdd.setBackground(new Color(211, 211, 211));
		btnAdd.setBounds(169, 498, 117, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setFont(new Font("Dialog", Font.BOLD, 16));
		btnReset.setBackground(new Color(211, 211, 211));
		btnReset.setBounds(479, 498, 117, 25);
		frame.getContentPane().add(btnReset);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 16));
		passwordField.setBounds(342, 433, 114, 23);
		frame.getContentPane().add(passwordField);
		
		JLabel lblWantToSee = new JLabel("Want To See Full Admin Panel?");
		lblWantToSee.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWantToSee.setBounds(98, 304, 314, 32);
		frame.getContentPane().add(lblWantToSee);
		
		JButton btnClick = new JButton("SEE");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanelShowingWindow.adminPanelShow();
				
			}
		});
		btnClick.setFont(new Font("Dialog", Font.BOLD, 16));
		btnClick.setBackground(new Color(211, 211, 211));
		btnClick.setBounds(423, 308, 223, 25);
		frame.getContentPane().add(btnClick);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(98, 269, 548, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("DRUG BANK");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(102, 51, 51));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 36));
		lblNewLabel.setBounds(208, 22, 328, 56);
		frame.getContentPane().add(lblNewLabel);
	}
}
