import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Lawyer extends User {
	
	private String l_id; //lawyer ID
	private int no_of_views;
	
	public void initPanel(){
		super.initPanel();
		
	}
	
	public Lawyer(){
		no_of_views = 0;
	}
	
	
}