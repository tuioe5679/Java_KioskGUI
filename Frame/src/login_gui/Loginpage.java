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
import javax.swing.JPasswordField;
import httpAPI.RestApi;


public class Loginpage implements ActionListener{

	public static JFrame frmLogin;
	private JTextField IdTextField;
	private JPasswordField passwordField;
	//as
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
		
		JLabel TitelLabel = new JLabel("fall in coffee");
		TitelLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
		TitelLabel.setBounds(163, 10, 215, 58);
		panel.add(TitelLabel);
		
		IdTextField = new JTextField();
		IdTextField.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		IdTextField.setToolTipText("Enter ID");
		IdTextField.setColumns(10);
		IdTextField.setBounds(165, 85, 164, 30);
		panel.add(IdTextField);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		idLabel.setBounds(122, 93, 36, 15);
		panel.add(idLabel);
		
		JLabel passwordLlabel = new JLabel("비밀번호");
		passwordLlabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		passwordLlabel.setBounds(115, 127, 48, 15);
		panel.add(passwordLlabel);
		
		JButton LoginBtn = new JButton("로그인");
		LoginBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		LoginBtn.setBackground(Color.WHITE);
		LoginBtn.setBounds(255, 159, 74, 25);
		panel.add(LoginBtn);
		
		JButton ManageLoginBtn = new JButton("관리자 로그인");
		ManageLoginBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		ManageLoginBtn.setBackground(Color.WHITE);
		ManageLoginBtn.setBounds(342, 85, 109, 65);
		panel.add(ManageLoginBtn);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		passwordField.setBounds(165, 119, 164, 30);
		panel.add(passwordField);
		
		JButton singupBtn = new JButton("회원가입");
		singupBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		singupBtn.setBackground(SystemColor.window);
		singupBtn.setBounds(165, 159, 84, 25);
		panel.add(singupBtn);
		
		LoginBtn.addActionListener(this);
		ManageLoginBtn.addActionListener(this);
		singupBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();
		
		
		if(text.equals("로그인")) {
			UserMainPage userpage = new UserMainPage();
			userpage.main(null);
			frmLogin.setVisible(false);
		}
		
		else if(text.equals("관리자 로그인")) {
			String urltext = IdTextField.getText();
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
				frmLogin.setVisible(false);
				getText ="";
			}
			else {
				JOptionPane.showConfirmDialog(null, "아이디와 패스워드를 확인해주세요","로그인 실패",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(text.equals("회원가입")) {
			SingUp singupPage = new SingUp();
			singupPage.main(null);
			frmLogin.setVisible(false);
		}
	}
}
//추가했음