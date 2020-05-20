import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JSeparator;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.PreparedStatement;


public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 51, 0));
		frame.setResizable(false);
		frame.setBounds(100, 100, 875, 715);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DRUG BANK");
		lblNewLabel.setForeground(new Color(102, 51, 51));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(99, 42, 328, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 30));
		lblWelcome.setBounds(99, 110, 328, 48);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblNeedMedicalHelp = new JLabel("Medical Help");
		lblNeedMedicalHelp.setForeground(new Color(128, 0, 0));
		lblNeedMedicalHelp.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNeedMedicalHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeedMedicalHelp.setBounds(99, 274, 682, 35);
		frame.getContentPane().add(lblNeedMedicalHelp);
		
		JLabel lblAreAnAdmin = new JLabel("Admin Login");
		lblAreAnAdmin.setForeground(new Color(128, 0, 0));
		lblAreAnAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreAnAdmin.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAreAnAdmin.setBounds(579, 30, 202, 29);
		frame.getContentPane().add(lblAreAnAdmin);
		
		JLabel lblId = new JLabel("username");
		lblId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblId.setBounds(575, 62, 97, 29);
		frame.getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(575, 97, 97, 43);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField.setBounds(677, 67, 104, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				try{
					java.sql.Connection conn=MySqlConnectClass.connectDb();//databaseConnected
					PreparedStatement create=(PreparedStatement) conn.prepareStatement("CREATE TABLE IF NOT EXISTS UserPassword(id int NOT NULL AUTO_INCREMENT, User varchar(10005), Password varchar(10005), PRIMARY KEY(id))");
					create.executeUpdate();
					
					PreparedStatement pst=(PreparedStatement) conn.prepareStatement("select *from UserPassword where User=? and Password=?");
					pst.setString(1,"omar");
					pst.setString(2,"pass");
					
					ResultSet rs=pst.executeQuery();
					
					if(!rs.next()) {
						pst=(PreparedStatement) conn.prepareStatement("insert into UserPassword(User,Password) values(?,?)");
						pst.setString(1,"omar" );
						pst.setString(2, "pass");
						pst.execute();
					}
					
					
					pst=(PreparedStatement) conn.prepareStatement("select *from UserPassword where User=? and Password=?");
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					
					rs=pst.executeQuery();
					
					if(rs.next())AdminWindow.AdminWin();
					else JOptionPane.showMessageDialog(null,"User ID And Password Didn't Matched!");
					
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(575, 148, 97, 19);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.setBounds(677, 148, 104, 19);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 16));
		passwordField.setBounds(677, 109, 104, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblSearchForThe = new JLabel("Search For Medicine Information");
		lblSearchForThe.setForeground(Color.BLACK);
		lblSearchForThe.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSearchForThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchForThe.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSearchForThe.setBounds(99, 347, 394, 29);
		frame.getContentPane().add(lblSearchForThe);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_1.setBounds(99, 388, 508, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.BOLD, 16));
		comboBox.addItem("Name");
		comboBox.addItem("BrandName");
		comboBox.addItem("GenericName");
		comboBox.addItem("Indication");
		
		comboBox.setBounds(619, 389, 162, 26);
		frame.getContentPane().add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(0, 0, 0));
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=(String) comboBox.getSelectedItem();
				
				java.sql.Connection conn=MySqlConnectClass.connectDb();
				PreparedStatement create;
				try {
					create = (PreparedStatement) conn.prepareStatement("CREATE TABLE IF NOT EXISTS DrugTable(Id int NOT NULL AUTO_INCREMENT, Name varchar(10005), BrandName varchar(10005), GenericName varchar(10005), Indication varchar(10005), Dose varchar(10005),PriceInBDT varchar(10005), PRIMARY KEY(Id))");
					create.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try {
					PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select *from DrugTable where "+s+"=?");
					pst.setString(1, textField_1.getText());
					if(pst.executeQuery().next()){
						DatabaseShowingWindow_Selected.method2(s,textField_1.getText());
					}
					else {
						JOptionPane.showMessageDialog(null, "No Match Found!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnSearch.setBackground(new Color(211, 211, 211));
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 18));
		btnSearch.setBounds(281, 429, 117, 29);
		frame.getContentPane().add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(0, 0, 0));
		
		
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText(null);
				comboBox.setSelectedIndex(0);
			}
		});
		btnReset.setBackground(new Color(211, 211, 211));
		btnReset.setFont(new Font("Dialog", Font.BOLD, 18));
		btnReset.setBounds(453, 429, 117, 29);
		frame.getContentPane().add(btnReset);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setForeground(new Color(0, 0, 0));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpWindow.helpWin();
			}
		});
		btnHelp.setBackground(new Color(211, 211, 211));
		btnHelp.setFont(new Font("Dialog", Font.BOLD, 18));
		btnHelp.setBounds(374, 584, 119, 29);
		frame.getContentPane().add(btnHelp);
		
		JLabel label_1 = new JLabel("Need Help For Searching?");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(99, 585, 299, 27);
		frame.getContentPane().add(label_1);
		
		JLabel lblWantToSee = new JLabel("Complete Drug Database");
		lblWantToSee.setForeground(new Color(0, 0, 0));
		lblWantToSee.setHorizontalAlignment(SwingConstants.CENTER);
		lblWantToSee.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWantToSee.setBounds(219, 516, 334, 29);
		frame.getContentPane().add(lblWantToSee);
		
		JButton btnSee = new JButton("See");
		btnSee.setForeground(new Color(0, 0, 0));
		btnSee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.sql.Connection conn=MySqlConnectClass.connectDb();
				PreparedStatement create;
				try {
					create = (PreparedStatement) conn.prepareStatement("CREATE TABLE IF NOT EXISTS DrugTable(Id int NOT NULL AUTO_INCREMENT, Name varchar(10005), BrandName varchar(10005), GenericName varchar(10005), Indication varchar(10005), Dose varchar(10005),PriceInBDT varchar(10005), PRIMARY KEY(Id))");
					create.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				DatabaseShowingWindow_Full.ShowFullDatabase();
			}
		});
		btnSee.setFont(new Font("Dialog", Font.BOLD, 18));
		btnSee.setBackground(new Color(211, 211, 211));
		btnSee.setBounds(522, 515, 117, 30);
		frame.getContentPane().add(btnSee);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 260, 682, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(99, 557, 682, 2);
		frame.getContentPane().add(separator_1);
		
		
	}
}
