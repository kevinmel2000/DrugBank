import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class RemoveDrugWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void removeDrug() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveDrugWindow window = new RemoveDrugWindow();
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
	public RemoveDrugWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 839, 621);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRemoveDrugFrom = new JLabel("Remove Drug From Database");
		lblRemoveDrugFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveDrugFrom.setFont(new Font("Dialog", Font.BOLD, 24));
		lblRemoveDrugFrom.setBounds(238, 12, 401, 36);
		frame.getContentPane().add(lblRemoveDrugFrom);
		
		JLabel lblRemoveByName = new JLabel("Remove By Name");
		lblRemoveByName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRemoveByName.setBounds(62, 148, 241, 25);
		frame.getContentPane().add(lblRemoveByName);
		
		JLabel lblRemoveByGeneric = new JLabel("Remove By Brand Name");
		lblRemoveByGeneric.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRemoveByGeneric.setBounds(62, 211, 241, 25);
		frame.getContentPane().add(lblRemoveByGeneric);
		
		JLabel lblRemoveByGeneric_1 = new JLabel("Remove By Generic Name");
		lblRemoveByGeneric_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRemoveByGeneric_1.setBounds(62, 276, 241, 25);
		frame.getContentPane().add(lblRemoveByGeneric_1);
		
		JLabel lblRemoveByIndication = new JLabel("Remove By Indication");
		lblRemoveByIndication.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRemoveByIndication.setBounds(62, 335, 241, 25);
		frame.getContentPane().add(lblRemoveByIndication);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
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
				
				try {
					PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select *from DrugTable where Name=?");
					pst.setString(1, textField.getText());
					if(pst.executeQuery().next()){
						pst = (PreparedStatement) conn.prepareStatement("delete from DrugTable where Name=?");
						pst.setString(1, textField.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Succesfully Removed!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Unable To Remove! No Match Found!");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRemove.setBackground(new Color(211, 211, 211));
		btnRemove.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRemove.setBounds(658, 148, 121, 25);
		frame.getContentPane().add(btnRemove);
		
		JButton button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
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
				
				try {
					PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select *from DrugTable where BrandName=?");
					pst.setString(1, textField_1.getText());
					
					if(pst.executeQuery().next()){
						pst = (PreparedStatement) conn.prepareStatement("delete from DrugTable where BrandName=?");
						pst.setString(1, textField_1.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Succesfully Removed!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Unable To Remove! No Match Found!");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBackground(new Color(211, 211, 211));
		button.setBounds(658, 211, 121, 25);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Remove");
		button_1.addActionListener(new ActionListener() {
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
				
				try {
					PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select *from DrugTable where GenericName=?");
					pst.setString(1, textField_2.getText());
					
					if(pst.executeQuery().next()){
						pst = (PreparedStatement) conn.prepareStatement("delete from DrugTable where GenericName=?");
						pst.setString(1, textField_2.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Succesfully Removed!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Unable To Remove! No Match Found!");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 16));
		button_1.setBackground(new Color(211, 211, 211));
		button_1.setBounds(658, 276, 121, 25);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Remove");
		button_2.addActionListener(new ActionListener() {
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
				
				try {
					PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select *from DrugTable where Indication=?");
					pst.setString(1, textField_3.getText());
					
					if(pst.executeQuery().next()){
						pst = (PreparedStatement) conn.prepareStatement("delete from DrugTable where Indication=?");
						pst.setString(1, textField_3.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Succesfully Removed!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Unable To Remove! No Match Found!");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 16));
		button_2.setBackground(new Color(211, 211, 211));
		button_2.setBounds(658, 335, 121, 25);
		frame.getContentPane().add(button_2);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnReset.setFont(new Font("Dialog", Font.BOLD, 16));
		btnReset.setBackground(new Color(211, 211, 211));
		btnReset.setBounds(371, 444, 117, 30);
		frame.getContentPane().add(btnReset);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(301, 145, 333, 32);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(301, 208, 333, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(301, 273, 333, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(301, 332, 333, 32);
		frame.getContentPane().add(textField_3);
	}
}
