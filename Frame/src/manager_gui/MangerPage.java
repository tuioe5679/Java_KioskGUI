package manager_gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import httpAPI.RestApi;
import login_gui.Loginpage;

import javax.swing.JButton;
import java.awt.Color;


public class MangerPage implements ActionListener{

	String[] header = {"주문번호","상품명","가격","개수"};
	private JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MangerPage window = new MangerPage();
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
	public MangerPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		JSONObject obj = null;
		JSONArray text = (JSONArray) RestApi.ordersDAO("orders/all", null);
		String[][] value = new String[text.length()][4];
		 for(int j=0;j<text.length();j++) {
			 while(true){
				 obj = text.getJSONObject(j); // json으로 변경 (역직렬화)
				 value[j][0] = obj.getString("ordernum");
				 value[j][1] = obj.getString("name");
				 value[j][2] = obj.getString("price");
				 value[j][3] = obj.getString("count");
				 break;
			 }
		}
		 //
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Loginpanel = new JPanel();
		Loginpanel.setBounds(0, 0, 784, 462);
		frame.getContentPane().add(Loginpanel);
		Loginpanel.setLayout(null);
		
		JLabel TitleLabel = new JLabel("\uC8FC\uBB38\uD655\uC778");
		TitleLabel.setFont(new Font("나눔고딕", Font.BOLD, 25));
		TitleLabel.setBounds(352, 10, 135, 49);
		Loginpanel.add(TitleLabel);
		
		table_1 = new JTable(value,header);
		table_1.setBounds(95, 55, 283, 384);
		JScrollPane jscp1 = new JScrollPane(table_1);
		jscp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jscp1.setLocation(198,69);
		jscp1.setSize(427,354);
		Loginpanel.add(jscp1);
		
		JButton backBtn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		backBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(43, 43, 95, 41);
		backBtn.setBorder(null);
		backBtn.addActionListener(this);
		Loginpanel.add(backBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();
		if(text.equals("뒤로가기")) {
			frame.dispose();
			Loginpage loginpage = new Loginpage();
			loginpage.frmLogin.setVisible(true);
		}
	}
}
