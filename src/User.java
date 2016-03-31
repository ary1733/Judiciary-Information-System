import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User{
	
	private String username, password, type;
	
	
	private JPanel panel;


	protected JPanel mainPanel;


	private JPanel pwdchangePanel;
	private JTextField txtKeywords;
	private JTable table;
	private JPasswordField pwdOld;
	private JPasswordField pwdNew_1;
	private JPasswordField pwdNew_2;
	
	
	
	private int changePassword(){
		if(! pwdOld.getPassword().toString().equals(password))
			return 1;
		else if(! pwdNew_1.getPassword().toString().equals(pwdNew_2.getPassword().toString())){
			return 2;
		}
		else{
			password = pwdNew_1.getPassword().toString();
			return 0;
		}
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initPanel(){
		
		panel = new JPanel();
		panel.setSize(500,500);
		panel.setLayout(new CardLayout(0, 0));
		
		mainPanel = new JPanel();
		panel.add(mainPanel, "name_1007512518629");
		mainPanel.setLayout(null);
		
		
		JLabel lblEnterKeywords = new JLabel("Enter keyword(s):");
		lblEnterKeywords.setBounds(57, 49, 174, 15);
		mainPanel.add(lblEnterKeywords);
		
		txtKeywords = new JTextField();
		txtKeywords.setBounds(204, 47, 174, 19);
		mainPanel.add(txtKeywords);
		txtKeywords.setColumns(10);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(371, 12, 117, 25);
		mainPanel.add(btnLogOut);
		
		table = new JTable();
		table.setBounds(57, 104, 393, 274);
		mainPanel.add(table);
		
		pwdchangePanel = new JPanel();
		panel.add(pwdchangePanel, "name_1113697649244");
		pwdchangePanel.setLayout(null);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				pwdchangePanel.setVisible(true);
			}
		});
		btnChangePassword.setBounds(280, 447, 167, 25);
		mainPanel.add(btnChangePassword);
		
		JLabel lblLoggedInAs = new JLabel("Welcome");
		lblLoggedInAs.setBounds(56, 24, 73, 15);
		mainPanel.add(lblLoggedInAs);
		
		JLabel lblLoggedUsername = new JLabel(username);
		lblLoggedUsername.setBounds(139, 24, 109, 15);
		mainPanel.add(lblLoggedUsername);
		
		JButton btnUserManagement = new JButton("User management");
		btnUserManagement.setBounds(35, 410, 193, 25);
		mainPanel.add(btnUserManagement);
		
		JButton btnCaseManagement = new JButton("Case management");
		btnCaseManagement.setBounds(35, 447, 194, 25);
		mainPanel.add(btnCaseManagement);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(390, 46, 60, 25);
		mainPanel.add(btnGo);
			
		
		JLabel lblEnterOldPassword = new JLabel("Enter old password:");
		lblEnterOldPassword.setBounds(35, 80, 186, 15);
		pwdchangePanel.add(lblEnterOldPassword);
		
		JLabel lblEnterNewPassword = new JLabel("Enter new password:");
		lblEnterNewPassword.setBounds(35, 122, 151, 15);
		pwdchangePanel.add(lblEnterNewPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm new password:");
		lblConfirmNewPassword.setBounds(35, 169, 167, 15);
		pwdchangePanel.add(lblConfirmNewPassword);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwdchangePanel.setVisible(false);
				mainPanel.setVisible(true);
				pwdOld.setText("");
				pwdNew_1.setText("");
				pwdNew_2.setText("");
			}
		});
		btnCancel.setBounds(55, 233, 117, 25);
		pwdchangePanel.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(changePassword() == 0){
					pwdchangePanel.setVisible(false);
					mainPanel.setVisible(true);
				}
				else if(changePassword() == 1){
					JOptionPane.showMessageDialog(panel, "Wrong old password!");
				}
				else if(changePassword() == 2){
					JOptionPane.showMessageDialog(panel, "Re-typed password does not match!");
				}
				
				pwdOld.setText("");
				pwdNew_1.setText("");
				pwdNew_2.setText("");
			}
			
		});
		btnOk.setBounds(203, 233, 117, 25);
		pwdchangePanel.add(btnOk);
		
		pwdOld = new JPasswordField();
		pwdOld.setBounds(214, 78, 139, 25);
		pwdchangePanel.add(pwdOld);
		
		pwdNew_1 = new JPasswordField();
		pwdNew_1.setBounds(214, 117, 139, 25);
		pwdchangePanel.add(pwdNew_1);
		
		pwdNew_2 = new JPasswordField();
		pwdNew_2.setBounds(214, 167, 139, 25);
		pwdchangePanel.add(pwdNew_2);
		
	}
	public JPanel getPanel(){
		return panel;
	}
	
//	public JPanel getMainPanel(){
//		return mainPanel;
//	}
}