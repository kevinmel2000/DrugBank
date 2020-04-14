import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;


public class DatabaseShowingWindow_Full {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void ShowFullDatabase() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseShowingWindow_Full window = new DatabaseShowingWindow_Full();
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
	public DatabaseShowingWindow_Full() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1415, 680);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPane.setBounds(31, 69, 1360, 552);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JLabel lblDatabase = new JLabel("DATABASE");
		lblDatabase.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatabase.setBounds(31, 12, 1360, 45);
		frame.getContentPane().add(lblDatabase);
		
		java.sql.Connection conn=MySqlConnectClass.connectDb();
		try {
			PreparedStatement pst=conn.prepareStatement("select *from DrugTable");
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
