import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddDrugWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void addDrug() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDrugWindow window = new AddDrugWindow();
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
	public AddDrugWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 764, 592);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewDrug = new JLabel("New Drug");
		lblNewDrug.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewDrug.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewDrug.setBounds(319, 12, 158, 48);
		frame.getContentPane().add(lblNewDrug);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(82, 87, 113, 28);
		frame.getContentPane().add(lblName);
		
		JLabel lblBrandname = new JLabel("Brand Name");
		lblBrandname.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBrandname.setBounds(82, 134, 113, 28);
		frame.getContentPane().add(lblBrandname);
		
		JLabel lblGenericName = new JLabel("Generic Name");
		lblGenericName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGenericName.setBounds(82, 189, 134, 32);
		frame.getContentPane().add(lblGenericName);
		
		JLabel lblIndication = new JLabel("Indication");
		lblIndication.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIndication.setBounds(82, 245, 113, 34);
		frame.getContentPane().add(lblIndication);
		
		JLabel lblDose = new JLabel("Dose");
		lblDose.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDose.setBounds(82, 310, 113, 33);
		frame.getContentPane().add(lblDose);
		
		JLabel lblPriceInBdt = new JLabel("Price In BDT");
		lblPriceInBdt.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPriceInBdt.setBounds(82, 375, 113, 33);
		frame.getContentPane().add(lblPriceInBdt);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField.setBounds(251, 86, 379, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
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
					PreparedStatement pst=(PreparedStatement)conn.prepareStatement("select *from DrugTable where Name=? and BrandName=? and GenericName=? and Indication=? and Dose=? and PriceInBDT=?");
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					if(textField.getText().length()==0 && textField_1.getText().length()==0
							&& textField_2.getText().length()==0 && textField_3.getText().length()==0
							&& textField_4.getText().length()==0 && textField_5.getText().length()==0) {
						JOptionPane.showMessageDialog(null, "Error! Empty File!");
					}
					else if(pst.executeQuery().next()){
						JOptionPane.showMessageDialog(null, "Data already Exists!");
					}
					else {
						pst=(PreparedStatement)conn.prepareStatement("insert into DrugTable(Name,BrandName,GenericName,Indication,Dose,PriceInBDT) values(?,?,?,?,?,?)");
						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
						pst.setString(4, textField_3.getText());
						pst.setString(5, textField_4.getText());
						pst.setString(6, textField_5.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Succesfully Added!");
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdd.setBackground(new Color(211, 211, 211));
		btnAdd.setBounds(226, 450, 117, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
			}
		});
		btnReset.setFont(new Font("Dialog", Font.BOLD, 16));
		btnReset.setBackground(new Color(211, 211, 211));
		btnReset.setBounds(396, 450, 117, 25);
		frame.getContentPane().add(btnReset);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(251, 133, 379, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(251, 190, 379, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(251, 247, 379, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(251, 311, 379, 32);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(251, 376, 379, 32);
		frame.getContentPane().add(textField_5);
	}
}
