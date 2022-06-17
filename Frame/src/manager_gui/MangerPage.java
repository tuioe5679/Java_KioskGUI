package manager_gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import httpAPI.RestApi;


public class MangerPage {

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
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Loginpanel = new JPanel();
		Loginpanel.setBounds(0, 0, 784, 462);
		frame.getContentPane().add(Loginpanel);
		Loginpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38\uD655\uC778");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 25));
		lblNewLabel.setBounds(352, 10, 135, 49);
		Loginpanel.add(lblNewLabel);
		
		table_1 = new JTable(value,header);
		table_1.setBounds(95, 55, 283, 384);
		JScrollPane jscp1 = new JScrollPane(table_1);
		jscp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jscp1.setLocation(198,69);
		jscp1.setSize(427,354);
		Loginpanel.add(jscp1);
	}
}
