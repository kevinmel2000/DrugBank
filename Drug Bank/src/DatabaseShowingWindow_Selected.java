import java.awt.EventQueue;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;


public class DatabaseShowingWindow_Selected {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void method2(final String s1,final String s2) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseShowingWindow_Selected window = new DatabaseShowingWindow_Selected(s1,s2);
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
	public DatabaseShowingWindow_Selected(final String s1,final String s2) {
		initialize(s1,s2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String s1,final String s2) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1415, 680);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPane.setBounds(31, 69, 1360, 552);
		frame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JLabel lblDatabase = new JLabel("Medicine Database");
		lblDatabase.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatabase.setBounds(31, 12, 1360, 45);
		frame.getContentPane().add(lblDatabase);
		
		java.sql.Connection conn=MySqlConnectClass.connectDb();
		try {
			PreparedStatement pst=conn.prepareStatement("select *from DrugTable where "+s1+"=?");
			pst.setString(1, s2);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
