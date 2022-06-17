package login_gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import httpAPI.RestApi;

public class SingUp implements ActionListener{

	private JFrame frmSingUp;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingUp window = new SingUp();
					window.frmSingUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SingUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmSingUp = new JFrame();
		frmSingUp.setTitle("Sing Up");
		frmSingUp.setBounds(100, 100,660, 400);
		frmSingUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSingUp.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(115, 10, 404, 327);
		frmSingUp.getContentPane().add(panel);
		
		lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 25));
		lblNewLabel.setBounds(146, 28, 101, 38);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(125, 78, 165, 25);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 116, 165, 25);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(125, 156, 165, 25);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(125, 196, 165, 25);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(85, 82, 32, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(74, 121, 43, 15);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\uC774\uB984");
		lblNewLabel_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(95, 161, 22, 15);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\uD604\uC7AC \uC794\uACE0");
		lblNewLabel_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(66, 201, 51, 15);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C\uD558\uAE30");
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(33, 254, 150, 30);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(202, 254, 150, 30);
		panel.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(this);
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();
		
		if(text.equals("È¸¿ø°¡ÀÔ")) {
			Vector<String> memberV = new Vector<String>();
			
			memberV.add(textField.getText());
			memberV.add(textField_1.getText());
			memberV.add(textField_2.getText());
			memberV.add(textField_3.getText());
			 
			if(!memberV.get(0).equals("")&&!memberV.get(1).equals("")&&!memberV.get(2).equals("")&&!memberV.get(3).equals("")) {
				String index = RestApi.MemberDAO("members/post", memberV);
				if(index.equals("")) {
					JOptionPane.showConfirmDialog(null, "È¸¿ø°¡ÀÔ ¿Ï·á","¼º°ø",JOptionPane.INFORMATION_MESSAGE);
					frmSingUp.setVisible(false);
					Loginpage.main(null);
				}
			}
			else {
					JOptionPane.showConfirmDialog(null, "È¸¿ø°¡ÀÔ¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù","°æ°í",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(text.equals("Ãë¼ÒÇÏ±â")) {
			Loginpage loginP = new Loginpage();
			loginP.main(null);
			frmSingUp.setVisible(false);
		}
	}
}
