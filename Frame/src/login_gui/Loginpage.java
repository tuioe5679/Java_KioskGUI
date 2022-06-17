package login_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import manager_gui.MangerPage;
import user_gui.UserMainPage;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import httpAPI.RestApi;

import javax.swing.SwingConstants;

public class Loginpage implements ActionListener{

	public JFrame frmLogin;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage window = new Loginpage();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setBounds(100, 100, 716, 534);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(76, 94, 597, 357);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("fall in coffee");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel.setBounds(163, 10, 215, 58);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		textField_1.setToolTipText("Enter ID");
		textField_1.setColumns(10);
		textField_1.setBounds(165, 85, 164, 30);
		panel.add(textField_1);
		
		JLabel id_label = new JLabel("\uC544\uC774\uB514:");
		id_label.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		id_label.setBounds(122, 93, 36, 15);
		panel.add(id_label);
		
		JLabel password_label = new JLabel("\uBE44\uBC00\uBC88\uD638:");
		password_label.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		password_label.setBounds(111, 127, 47, 15);
		panel.add(password_label);
		
		JButton Login_Btn = new JButton("\uB85C\uADF8\uC778");
		Login_Btn.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		Login_Btn.setBackground(Color.WHITE);
		Login_Btn.setBounds(255, 159, 74, 25);
		panel.add(Login_Btn);
		
		JButton UserLogin_btn = new JButton("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
		UserLogin_btn.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		UserLogin_btn.setBackground(Color.WHITE);
		UserLogin_btn.setBounds(342, 85, 109, 65);
		panel.add(UserLogin_btn);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		passwordField.setBounds(165, 119, 164, 30);
		panel.add(passwordField);
		
		JButton singup_Btn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		singup_Btn.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		singup_Btn.setBackground(SystemColor.window);
		singup_Btn.setBounds(165, 159, 84, 25);
		panel.add(singup_Btn);
		
		Login_Btn.addActionListener(this);
		UserLogin_btn.addActionListener(this);
		singup_Btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();
		
		
		if(text.equals("·Î±×ÀÎ")) {
			UserMainPage userpage = new UserMainPage();
			userpage.main(null);
			frmLogin.dispose();
		}
		
		else if(text.equals("°ü¸®ÀÚ ·Î±×ÀÎ")) {
			String urltext = textField_1.getText();
			char[] pwd = passwordField.getPassword();
			for(int i=0;i<pwd.length;i++) {
				if(i==0) {
					urltext+=","+pwd[i];
				}
				else {
					urltext+=pwd[i];
				}
			}
			String getText = RestApi.MemberDAO("members/"+urltext, null);
			if(getText != "") {
				MangerPage managerpage = new MangerPage();
				managerpage.main(null);
				frmLogin.dispose();
			}
			else {
				JOptionPane.showConfirmDialog(null, "¾ÆÀÌµð¿Í ÆÐ½º¿öµå¸¦ È®ÀÎÇØÁÖ¼¼¿ä","·Î±×ÀÎ ½ÇÆÐ",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(text.equals("È¸¿ø°¡ÀÔ")) {
			SingUp singupPage = new SingUp();
			singupPage.main(null);
			frmLogin.dispose();
		}
	}
}
//Ãß°¡ÇßÀ½