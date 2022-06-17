package user_gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.json.JSONArray;
import org.json.JSONObject;
import httpAPI.RestApi;
import login_gui.Loginpage;

public class UserMainPage implements ActionListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainPage window = new UserMainPage();
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
	public UserMainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Map<String, String> map = new HashMap<String, String>();
		JSONArray array = RestApi.productDAO("product/all", null);
		String index[] = new String[array.length()];
		String spiltvlaue[];
		String name[] = new String[array.length()];
		String id[] = new String[array.length()];
		String price[] = new String[array.length()];
		String image[] = new String[array.length()];

		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i); // jsonÀ¸·Î º¯°æ (¿ªÁ÷·ÄÈ­)
			index[i] = (String) obj.get("id") + "," + (String) obj.get("name") + "," + (String) obj.get("price") + ","
					+ (String) obj.get("image");
		}
		for (int i = 0; i < array.length(); i++) {
			spiltvlaue = index[i].split(",");
			name[i] = spiltvlaue[0];
			id[i] = spiltvlaue[1];
			price[i] = spiltvlaue[2];
			image[i] = spiltvlaue[3];
		}

		for (int i = 0; i < array.length(); i++) {
			System.out.println(name[i] + " " + id[i] + " " + price[i] + " " + image[i]);
		}

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 900, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 884, 40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fall in Coffee");
		lblNewLabel.setForeground(new Color(51, 102, 255));
		lblNewLabel.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(400, 10, 166, 20);
		panel.add(lblNewLabel);

		JButton btnNewButton_6 = new JButton("\uB4A4\uB85C\uAC00\uAE30"); // µÚ·Î°¡±â
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(12, 10, 103, 24);
		btnNewButton_6.addActionListener(this);
		panel.add(btnNewButton_6);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 39, 884, 33);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));

		JButton btnNewButton = new JButton("Ä¿ÇÇ");
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(null);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("¶ó¶¼,ÃÊÄÝ¸´,Æ¼");
		btnNewButton_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBorder(null);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("ºù¼ö ¹× ½ºÄíµð");
		btnNewButton_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBorder(null);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("½ºÆÄÅ¬¸µ");
		btnNewButton_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBorder(null);
		panel_1.add(btnNewButton_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(7, 82, 870, 600);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 10, 10));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);

		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(45, 230, 139, 15);
		panel_3.add(lblNewLabel_1);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(
				"C:\\Users\\\uC774\uD55C\\Desktop\\\uC790\uBC14\uCE74\uD398 \uBA54\uB274 \uC218\uC815\uBCF8\\\uCEE4\uD53C\\\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8.png"));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(0, 0, 210, 210);
		btnNewButton_4.setBorder(null);
		panel_3.add(btnNewButton_4);

		JLabel lblNewLabel_1_8 = new JLabel("5000\uC6D0");
		lblNewLabel_1_8.setBounds(87, 255, 45, 15);
		panel_3.add(lblNewLabel_1_8);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3_1);
		panel_3_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("\uB514\uCE74\uD398\uC778 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_1_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(35, 230, 146, 15);
		panel_3_1.add(lblNewLabel_1_1);

		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.setIcon(new ImageIcon(
				"C:\\Users\\\uC774\uD55C\\Desktop\\\uC790\uBC14\uCE74\uD398 \uBA54\uB274 \uC218\uC815\uBCF8\\\uCEE4\uD53C\\\uB514\uCE74\uD398\uC778 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8.png"));
		btnNewButton_4_1.setBounds(0, 0, 210, 210);
		btnNewButton_4_1.setBackground(Color.WHITE);
		btnNewButton_4_1.setBorder(null);
		panel_3_1.add(btnNewButton_4_1);

		JLabel lblNewLabel_1_8_1 = new JLabel("5500\uC6D0");
		lblNewLabel_1_8_1.setBounds(87, 255, 45, 15);
		panel_3_1.add(lblNewLabel_1_8_1);

		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3_2);
		panel_3_2.setLayout(null);

		JButton btnNewButton_4_1_1 = new JButton("");
		btnNewButton_4_1_1.setIcon(new ImageIcon(
				"C:\\Users\\\uC774\uD55C\\Desktop\\\uC790\uBC14\uCE74\uD398 \uBA54\uB274 \uC218\uC815\uBCF8\\\uCEE4\uD53C\\\uB514\uCE74\uD398\uC778 \uCE74\uD398\uB77C\uB5BC.png"));
		btnNewButton_4_1_1.setBackground(Color.WHITE);
		btnNewButton_4_1_1.setBounds(0, 0, 210, 210);
		btnNewButton_4_1_1.setBorder(null);
		panel_3_2.add(btnNewButton_4_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_1_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(45, 230, 139, 15);
		panel_3_2.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_8_2 = new JLabel("5000\uC6D0");
		lblNewLabel_1_8_2.setBounds(87, 257, 45, 15);
		panel_3_2.add(lblNewLabel_1_8_2);

		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3_3);
		panel_3_3.setLayout(null);

		JButton btnNewButton_4_1_1_1 = new JButton("");
		btnNewButton_4_1_1_1.setIcon(new ImageIcon(
				"C:\\Users\\\uC774\uD55C\\Desktop\\\uC790\uBC14\uCE74\uD398 \uBA54\uB274 \uC218\uC815\uBCF8\\\uCEE4\uD53C\\\uC544\uD3EC\uAC00\uD1A0.png"));
		btnNewButton_4_1_1_1.setBackground(Color.WHITE);
		btnNewButton_4_1_1_1.setBounds(0, 0, 210, 210);
		btnNewButton_4_1_1_1.setBorder(null);
		panel_3_3.add(btnNewButton_4_1_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_1_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(45, 230, 139, 15);
		panel_3_3.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_8_3 = new JLabel("5000\uC6D0");
		lblNewLabel_1_8_3.setBounds(97, 256, 45, 15);
		panel_3_3.add(lblNewLabel_1_8_3);

		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3_4);
		panel_3_4.setLayout(null);

		JButton btnNewButton_4_1_1_2 = new JButton("");
		btnNewButton_4_1_1_2.setIcon(new ImageIcon(
				"C:\\Users\\\uC774\uD55C\\Desktop\\\uC790\uBC14\uCE74\uD398 \uBA54\uB274 \uC218\uC815\uBCF8\\\uCEE4\uD53C\\\uC5D0\uC2A4\uD504\uB808\uC18C.png"));
		btnNewButton_4_1_1_2.setBackground(Color.WHITE);
		btnNewButton_4_1_1_2.setBounds(0, 0, 210, 210);
		btnNewButton_4_1_1_2.setBorder(null);
		panel_3_4.add(btnNewButton_4_1_1_2);

		JLabel lblNewLabel_1_4 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_1_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(45, 230, 139, 15);
		panel_3_4.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_8_4 = new JLabel("5000\uC6D0");
		lblNewLabel_1_8_4.setBounds(87, 257, 45, 15);
		panel_3_4.add(lblNewLabel_1_8_4);

		JPanel panel_3_5 = new JPanel();
		panel_3_5.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3_5);
		panel_3_5.setLayout(null);

		JButton btnNewButton_4_1_1_3 = new JButton("");
		btnNewButton_4_1_1_3.setIcon(new ImageIcon(
				"C:\\Users\\\uC774\uD55C\\Desktop\\\uC790\uBC14\uCE74\uD398 \uBA54\uB274 \uC218\uC815\uBCF8\\\uCEE4\uD53C\\\uCE74\uB77C\uBA5C \uB9C8\uD0A4\uC544\uB610.png"));
		btnNewButton_4_1_1_3.setBackground(Color.WHITE);
		btnNewButton_4_1_1_3.setBounds(0, 0, 210, 210);
		btnNewButton_4_1_1_3.setBorder(null);
		panel_3_5.add(btnNewButton_4_1_1_3);

		JLabel lblNewLabel_1_5 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_1_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(45, 230, 139, 15);
		panel_3_5.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_8_5 = new JLabel("5000\uC6D0");
		lblNewLabel_1_8_5.setBounds(87, 257, 45, 15);
		panel_3_5.add(lblNewLabel_1_8_5);

		JPanel panel_3_6 = new JPanel();
		panel_3_6.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3_6);
		panel_3_6.setLayout(null);

		JButton btnNewButton_4_1_1_4 = new JButton("");
		btnNewButton_4_1_1_4.setIcon(new ImageIcon(
				"C:\\Users\\\uC774\uD55C\\Desktop\\\uC790\uBC14\uCE74\uD398 \uBA54\uB274 \uC218\uC815\uBCF8\\\uCEE4\uD53C\\\uCE74\uD398\uBAA8\uCE74.png"));
		btnNewButton_4_1_1_4.setBackground(Color.WHITE);
		btnNewButton_4_1_1_4.setBounds(0, 0, 210, 210);
		btnNewButton_4_1_1_4.setBorder(null);
		panel_3_6.add(btnNewButton_4_1_1_4);

		JLabel lblNewLabel_1_6 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_1_6.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(45, 230, 139, 15);
		panel_3_6.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_8_6 = new JLabel("5000\uC6D0");
		lblNewLabel_1_8_6.setBounds(87, 256, 45, 15);
		panel_3_6.add(lblNewLabel_1_8_6);

		JPanel panel_3_7 = new JPanel();
		panel_3_7.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3_7);
		panel_3_7.setLayout(null);

		JButton btnNewButton_4_1_1_5 = new JButton("");
		btnNewButton_4_1_1_5.setIcon(new ImageIcon(
				"C:\\Users\\\uC774\uD55C\\Desktop\\\uC790\uBC14\uCE74\uD398 \uBA54\uB274 \uC218\uC815\uBCF8\\\uCEE4\uD53C\\\uCF5C\uB4DC\uBE0C\uB8E8.png"));
		btnNewButton_4_1_1_5.setBackground(Color.WHITE);
		btnNewButton_4_1_1_5.setBounds(0, 0, 210, 210);
		btnNewButton_4_1_1_5.setBorder(null);
		panel_3_7.add(btnNewButton_4_1_1_5);

		JLabel lblNewLabel_1_7 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_1_7.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_1_7.setBounds(45, 230, 139, 15);
		panel_3_7.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_8_7 = new JLabel("5000\uC6D0");
		lblNewLabel_1_8_7.setBounds(87, 258, 45, 15);
		panel_3_7.add(lblNewLabel_1_8_7);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 692, 884, 260);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_5.setBounds(595, 10, 120, 50);
		btnNewButton_5.setBorder(null);
		panel_4.add(btnNewButton_5);

		JButton btnNewButton_5_1 = new JButton("New button");
		btnNewButton_5_1.setBorder(null);
		btnNewButton_5_1.setBackground(Color.WHITE);
		btnNewButton_5_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_5_1.setBounds(742, 10, 120, 50);
		btnNewButton_5_1.setBorder(null);
		panel_4.add(btnNewButton_5_1);

		JButton btnNewButton_5_2 = new JButton("\uACB0\uC81C\uD558\uAE30");
		btnNewButton_5_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_5_2.setForeground(Color.WHITE);
		btnNewButton_5_2.setBackground(Color.DARK_GRAY);
		btnNewButton_5_2.setBounds(595, 166, 267, 84);
		btnNewButton_5_2.setBorder(null);
		panel_4.add(btnNewButton_5_2);

		JLabel lblNewLabel_2 = new JLabel("\uC8FC\uBB38 \uAE08\uC561");
		lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		lblNewLabel_2.setBounds(595, 93, 85, 38);
		panel_4.add(lblNewLabel_2);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 556, 260);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();

		JScrollPane scrollPane = new JScrollPane(panel_6);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 5, 556, 255);
		panel_5.add(scrollPane);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_7_1 = new JPanel();
		panel_6.add(panel_7_1);
		panel_7_1.setLayout(null);

		JLabel lblNewLabel_3_2 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_3_2.setBounds(27, 0, 147, 50);
		lblNewLabel_3_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		panel_7_1.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_1_2 = new JLabel("5000\uC6D0");
		lblNewLabel_3_1_2.setBounds(364, 0, 41, 50);
		lblNewLabel_3_1_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		panel_7_1.add(lblNewLabel_3_1_2);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("1\uAC1C");
		lblNewLabel_3_1_1_1.setBounds(248, 0, 35, 50);
		lblNewLabel_3_1_1_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		panel_7_1.add(lblNewLabel_3_1_1_1);

		JButton btnNewButton_6_2 = new JButton("+");
		btnNewButton_6_2.setBounds(186, 14, 50, 23);
		btnNewButton_6_2.setBorder(null);
		btnNewButton_6_2.setBackground(Color.WHITE);
		panel_7_1.add(btnNewButton_6_2);

		JButton btnNewButton_6_1_1 = new JButton("-");
		btnNewButton_6_1_1.setBounds(280, 14, 50, 23);
		btnNewButton_6_1_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_6_1_1.setBorder(null);
		btnNewButton_6_1_1.setBackground(Color.WHITE);
		panel_7_1.add(btnNewButton_6_1_1);

		JButton btnNewButton_7_1 = new JButton("X");
		btnNewButton_7_1.setBounds(446, 7, 54, 37);
		btnNewButton_7_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_7_1.setBorder(null);
		btnNewButton_7_1.setBackground(Color.WHITE);
		panel_7_1.add(btnNewButton_7_1);

		JPanel panel_7_1_1 = new JPanel();
		panel_7_1_1.setLayout(null);
		panel_6.add(panel_7_1_1);

		JLabel lblNewLabel_3_2_1 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_3_2_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_2_1.setBounds(27, 0, 147, 50);
		panel_7_1_1.add(lblNewLabel_3_2_1);

		JLabel lblNewLabel_3_1_2_1 = new JLabel("5000\uC6D0");
		lblNewLabel_3_1_2_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_1_2_1.setBounds(364, 0, 41, 50);
		panel_7_1_1.add(lblNewLabel_3_1_2_1);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("1\uAC1C");
		lblNewLabel_3_1_1_1_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_1_1_1_1.setBounds(248, 0, 35, 50);
		panel_7_1_1.add(lblNewLabel_3_1_1_1_1);

		JButton btnNewButton_6_2_1 = new JButton("+");
		btnNewButton_6_2_1.setBorder(null);
		btnNewButton_6_2_1.setBackground(Color.WHITE);
		btnNewButton_6_2_1.setBounds(186, 14, 50, 23);
		panel_7_1_1.add(btnNewButton_6_2_1);

		JButton btnNewButton_6_1_1_1 = new JButton("-");
		btnNewButton_6_1_1_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_6_1_1_1.setBorder(null);
		btnNewButton_6_1_1_1.setBackground(Color.WHITE);
		btnNewButton_6_1_1_1.setBounds(280, 14, 50, 23);
		panel_7_1_1.add(btnNewButton_6_1_1_1);

		JButton btnNewButton_7_1_1 = new JButton("X");
		btnNewButton_7_1_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_7_1_1.setBorder(null);
		btnNewButton_7_1_1.setBackground(Color.WHITE);
		btnNewButton_7_1_1.setBounds(446, 7, 54, 37);
		panel_7_1_1.add(btnNewButton_7_1_1);

		JPanel panel_7_1_2 = new JPanel();
		panel_7_1_2.setLayout(null);
		panel_6.add(panel_7_1_2);

		JLabel lblNewLabel_3_2_2 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_3_2_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_2_2.setBounds(27, 0, 147, 50);
		panel_7_1_2.add(lblNewLabel_3_2_2);

		JLabel lblNewLabel_3_1_2_2 = new JLabel("5000\uC6D0");
		lblNewLabel_3_1_2_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_1_2_2.setBounds(364, 0, 41, 50);
		panel_7_1_2.add(lblNewLabel_3_1_2_2);

		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("1\uAC1C");
		lblNewLabel_3_1_1_1_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_1_1_1_2.setBounds(248, 0, 35, 50);
		panel_7_1_2.add(lblNewLabel_3_1_1_1_2);

		JButton btnNewButton_6_2_2 = new JButton("+");
		btnNewButton_6_2_2.setBorder(null);
		btnNewButton_6_2_2.setBackground(Color.WHITE);
		btnNewButton_6_2_2.setBounds(186, 14, 50, 23);
		panel_7_1_2.add(btnNewButton_6_2_2);

		JButton btnNewButton_6_1_1_2 = new JButton("-");
		btnNewButton_6_1_1_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_6_1_1_2.setBorder(null);
		btnNewButton_6_1_1_2.setBackground(Color.WHITE);
		btnNewButton_6_1_1_2.setBounds(280, 14, 50, 23);
		panel_7_1_2.add(btnNewButton_6_1_1_2);

		JButton btnNewButton_7_1_2 = new JButton("X");
		btnNewButton_7_1_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_7_1_2.setBorder(null);
		btnNewButton_7_1_2.setBackground(Color.WHITE);
		btnNewButton_7_1_2.setBounds(446, 7, 54, 37);
		panel_7_1_2.add(btnNewButton_7_1_2);

		JPanel panel_7_1_3 = new JPanel();
		panel_7_1_3.setLayout(null);
		panel_6.add(panel_7_1_3);

		JLabel lblNewLabel_3_2_3 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_3_2_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_2_3.setBounds(27, 0, 147, 50);
		panel_7_1_3.add(lblNewLabel_3_2_3);

		JLabel lblNewLabel_3_1_2_3 = new JLabel("5000\uC6D0");
		lblNewLabel_3_1_2_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_1_2_3.setBounds(364, 0, 41, 50);
		panel_7_1_3.add(lblNewLabel_3_1_2_3);

		JLabel lblNewLabel_3_1_1_1_3 = new JLabel("1\uAC1C");
		lblNewLabel_3_1_1_1_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_1_1_1_3.setBounds(248, 0, 35, 50);
		panel_7_1_3.add(lblNewLabel_3_1_1_1_3);

		JButton btnNewButton_6_2_3 = new JButton("+");
		btnNewButton_6_2_3.setBorder(null);
		btnNewButton_6_2_3.setBackground(Color.WHITE);
		btnNewButton_6_2_3.setBounds(186, 14, 50, 23);
		panel_7_1_3.add(btnNewButton_6_2_3);

		JButton btnNewButton_6_1_1_3 = new JButton("-");
		btnNewButton_6_1_1_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_6_1_1_3.setBorder(null);
		btnNewButton_6_1_1_3.setBackground(Color.WHITE);
		btnNewButton_6_1_1_3.setBounds(280, 14, 50, 23);
		panel_7_1_3.add(btnNewButton_6_1_1_3);

		JButton btnNewButton_7_1_3 = new JButton("X");
		btnNewButton_7_1_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_7_1_3.setBorder(null);
		btnNewButton_7_1_3.setBackground(Color.WHITE);
		btnNewButton_7_1_3.setBounds(446, 7, 54, 37);
		panel_7_1_3.add(btnNewButton_7_1_3);

		JPanel panel_7_1_4 = new JPanel();
		panel_7_1_4.setLayout(null);
		panel_6.add(panel_7_1_4);

		JLabel lblNewLabel_3_2_4 = new JLabel("\uB354\uBE14\uC0F7 \uBC14\uB2D0\uB77C \uB51C\uB77C\uC774\uD2B8");
		lblNewLabel_3_2_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_2_4.setBounds(27, 0, 147, 50);
		panel_7_1_4.add(lblNewLabel_3_2_4);

		JLabel lblNewLabel_3_1_2_4 = new JLabel("5000\uC6D0");
		lblNewLabel_3_1_2_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_1_2_4.setBounds(364, 0, 41, 50);
		panel_7_1_4.add(lblNewLabel_3_1_2_4);

		JLabel lblNewLabel_3_1_1_1_4 = new JLabel("1\uAC1C");
		lblNewLabel_3_1_1_1_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNewLabel_3_1_1_1_4.setBounds(248, 0, 35, 50);
		panel_7_1_4.add(lblNewLabel_3_1_1_1_4);

		JButton btnNewButton_6_2_4 = new JButton("+");
		btnNewButton_6_2_4.setBorder(null);
		btnNewButton_6_2_4.setBackground(Color.WHITE);
		btnNewButton_6_2_4.setBounds(186, 14, 50, 23);
		panel_7_1_4.add(btnNewButton_6_2_4);

		JButton btnNewButton_6_1_1_4 = new JButton("-");
		btnNewButton_6_1_1_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_6_1_1_4.setBorder(null);
		btnNewButton_6_1_1_4.setBackground(Color.WHITE);
		btnNewButton_6_1_1_4.setBounds(280, 14, 50, 23);
		panel_7_1_4.add(btnNewButton_6_1_1_4);

		JButton btnNewButton_7_1_4 = new JButton("X");
		btnNewButton_7_1_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		btnNewButton_7_1_4.setBorder(null);
		btnNewButton_7_1_4.setBackground(Color.WHITE);
		btnNewButton_7_1_4.setBounds(446, 7, 54, 37);
		panel_7_1_4.add(btnNewButton_7_1_4);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();

		if (text.equals("µÚ·Î°¡±â")) {
			Loginpage loginpage = new Loginpage();
			frame.dispose();
			loginpage.frmLogin.setVisible(true);
		}
	}

}
