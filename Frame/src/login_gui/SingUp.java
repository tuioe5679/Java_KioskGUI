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
	private JLabel TitleLabel;
	private JTextField idTextField;
	private JTextField passwordTextField;
	private JTextField nameTextField;
	private JTextField moneyTextField;
	private JLabel nameLabel;
	private JLabel moneyLabel;
	private JButton signupBtn;

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
		
		TitleLabel = new JLabel("회원가입");
		TitleLabel.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		TitleLabel.setBounds(146, 28, 101, 38);
		panel.add(TitleLabel);
		
		idTextField = new JTextField();
		idTextField.setHorizontalAlignment(SwingConstants.LEFT);
		idTextField.setToolTipText("");
		idTextField.setColumns(10);
		idTextField.setBounds(125, 78, 165, 25);
		panel.add(idTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(125, 116, 165, 25);
		panel.add(passwordTextField);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(125, 156, 165, 25);
		panel.add(nameTextField);
		
		moneyTextField = new JTextField();
		moneyTextField.setColumns(10);
		moneyTextField.setBounds(125, 196, 165, 25);
		panel.add(moneyTextField);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		idLabel.setBounds(62, 83, 43, 15);
		panel.add(idLabel);
		
		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		passwordLabel.setBounds(62, 121, 56, 15);
		panel.add(passwordLabel);
		
		nameLabel = new JLabel("이름");
		nameLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		nameLabel.setBounds(62, 161, 43, 15);
		panel.add(nameLabel);
		
		moneyLabel = new JLabel("현재 잔고");
		moneyLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		moneyLabel.setBounds(62, 201, 64, 15);
		panel.add(moneyLabel);
		
		JButton cancelBtn = new JButton("취소하기");
		cancelBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		cancelBtn.setBackground(Color.WHITE);
		cancelBtn.setBounds(33, 254, 150, 30);
		panel.add(cancelBtn);
		
		signupBtn = new JButton("회원가입");
		signupBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		signupBtn.setBackground(Color.WHITE);
		signupBtn.setBounds(202, 254, 150, 30);
		panel.add(signupBtn);
		
		signupBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();
		
		if(text.equals("회원가입")) {
			Vector<String> memberV = new Vector<String>();
			
			memberV.add(idTextField.getText());
			memberV.add(passwordTextField.getText());
			memberV.add(nameTextField.getText());
			memberV.add(moneyTextField.getText());

			if(!memberV.get(0).equals("")&&!memberV.get(1).equals("")&&!memberV.get(2).equals("")&&!memberV.get(3).equals("")) {
				String index = RestApi.MemberDAO("members/post", memberV);
				if(index.equals("")) {
					JOptionPane.showConfirmDialog(null, "회원가입 완료","성공",JOptionPane.INFORMATION_MESSAGE);
					frmSingUp.setVisible(false);
					Loginpage.main(null);
				}
			}
			else {
					JOptionPane.showConfirmDialog(null, "회원가입에 실패하였습니다","경고",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(text.equals("취소하기")) {
			Loginpage loginP = new Loginpage();
			loginP.main(null);
			frmSingUp.setVisible(false);
		}
	}
}
