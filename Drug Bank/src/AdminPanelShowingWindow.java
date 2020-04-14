import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.JScrollPane;


public class AdminPanelShowingWindow {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void adminPanelShow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanelShowingWindow window = new AdminPanelShowingWindow();
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
	public AdminPanelShowingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.setBounds(100, 100, 701, 564);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminList = new JLabel("ADMIN LIST");
		lblAdminList.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdminList.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminList.setBounds(29, 20, 646, 43);
		frame.getContentPane().add(lblAdminList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPane.setBounds(30, 75, 645, 430);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		
		java.sql.Connection conn=MySqlConnectClass.connectDb();
		try {
			PreparedStatement pst=(PreparedStatement)conn.prepareStatement("select *from UserPassword");
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
