import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


public class HelpWindow {

	private JFrame frmHelp;

	/**
	 * Launch the application.
	 */
	public static void helpWin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpWindow window = new HelpWindow();
					window.frmHelp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelpWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHelp = new JFrame();
		frmHelp.setResizable(false);
		frmHelp.setBounds(100, 100, 770, 633);
		frmHelp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmHelp.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToDrug = new JLabel("Welcome To Drug Bank Medicine Search Help!");
		lblWelcomeToDrug.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWelcomeToDrug.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToDrug.setBounds(82, 35, 615, 32);
		frmHelp.getContentPane().add(lblWelcomeToDrug);
		
		JLabel lblNewLabel = new JLabel("You can search medicine differently. Either by Name, Brand Name,");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(82, 95, 615, 32);
		frmHelp.getContentPane().add(lblNewLabel);
		
		JLabel lblMedicineWillBe = new JLabel("will be showed.");
		lblMedicineWillBe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMedicineWillBe.setBounds(82, 242, 633, 32);
		frmHelp.getContentPane().add(lblMedicineWillBe);
		
		JLabel lblIfYouSelect_1 = new JLabel("If you select Brand Name, then all the medicine of that brand will be ");
		lblIfYouSelect_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIfYouSelect_1.setBounds(82, 301, 633, 32);
		frmHelp.getContentPane().add(lblIfYouSelect_1);
		
		JLabel lblShowed = new JLabel("showed.");
		lblShowed.setFont(new Font("Dialog", Font.BOLD, 16));
		lblShowed.setBounds(82, 325, 633, 32);
		frmHelp.getContentPane().add(lblShowed);
		
		JLabel lblForGenericName = new JLabel("For Generic Name all the medicine of all the brands of that genre will");
		lblForGenericName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblForGenericName.setBounds(82, 369, 633, 32);
		frmHelp.getContentPane().add(lblForGenericName);
		
		JLabel lblOrByGeneric = new JLabel("Generic Name or Indication Of disease. You can select the type of ");
		lblOrByGeneric.setFont(new Font("Dialog", Font.BOLD, 16));
		lblOrByGeneric.setBounds(82, 120, 615, 32);
		frmHelp.getContentPane().add(lblOrByGeneric);
		
		JLabel lblYouCanSelect = new JLabel("search from the right side of the Search box.");
		lblYouCanSelect.setFont(new Font("Dialog", Font.BOLD, 16));
		lblYouCanSelect.setBounds(82, 146, 615, 32);
		frmHelp.getContentPane().add(lblYouCanSelect);
		
		JLabel lblIfYouSelect = new JLabel("If You Select Name, then all the information related to that medicine");
		lblIfYouSelect.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIfYouSelect.setBounds(82, 216, 633, 32);
		frmHelp.getContentPane().add(lblIfYouSelect);
		
		JLabel lblBeShowed = new JLabel("be showed.");
		lblBeShowed.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBeShowed.setBounds(82, 398, 633, 32);
		frmHelp.getContentPane().add(lblBeShowed);
		
		JLabel lblForIndicationAll = new JLabel("For Indication all the related medicine will be showed.");
		lblForIndicationAll.setFont(new Font("Dialog", Font.BOLD, 16));
		lblForIndicationAll.setBounds(82, 466, 633, 32);
		frmHelp.getContentPane().add(lblForIndicationAll);
	}
}
