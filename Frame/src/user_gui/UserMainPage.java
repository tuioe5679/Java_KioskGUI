package user_gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import httpAPI.RestApi;
import login_gui.Loginpage;

public class UserMainPage implements ActionListener {

	public JFrame frame;
	public JPanel panel_2;
	public JPanel panel;
	public JPanel panel_6;
	
	int totalprice = 0;
	int num[] = {1,1,1,1,1};
	static int count = 0;
	
	JPanel ListPanel[];
	static JLabel productName[];
	static JLabel productPrice[];
	static JLabel productCount[];
	static JLabel totalPrice;
	JButton plus[];
	JButton minus[];
	JButton delete[];
	
	static String index[];
	static String name[];
	static String id[];
	static String price[];
	static String image[];
	
	static JButton proudctListBtn[];
	
	UserPagePanel panels;
	UserPagePanel2 panels2;
	UserPagePanel3 panels3;

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
	public UserMainPage(String a) {
		
	}
	public UserMainPage() {
		initialize();
	}
	
	public static JSONArray ProudctList() {
		JSONArray array = RestApi.productDAO("product/all", null);
		String spiltvlaue[];
		index = new String[array.length()];
		name = new String[array.length()];
		id = new String[array.length()];
		price = new String[array.length()];
		image = new String[array.length()];

		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i); 
			index[i] = (String) obj.get("id") + "," + (String) obj.get("name") + "," + (String) obj.get("price") + ","
					+ (String) obj.get("image");
		}
		for (int i = 0; i < array.length(); i++) {
			spiltvlaue = index[i].split(",");
			id[i] = spiltvlaue[0];
			name[i] = spiltvlaue[1];
			price[i] = spiltvlaue[2];
			image[i] = spiltvlaue[3];
		}
		return array;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		JSONArray array = UserMainPage.ProudctList();
		JPanel productListPanel[] = new JPanel[array.length()];
		JLabel productNameListLabel[] = new JLabel[array.length()];
		proudctListBtn = new JButton[array.length()]; 
		JLabel productPriceListLabel[] = new JLabel[array.length()];
		
		
		ListPanel = new JPanel[array.length()];
		productName = new JLabel[array.length()];
		productPrice = new JLabel[array.length()];
		productCount = new JLabel[array.length()];
		plus = new JButton[array.length()];
		minus = new JButton[array.length()];
		delete = new JButton[array.length()];

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 900, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 884, 40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel TitleLabel = new JLabel("Fall in Coffee");
		TitleLabel.setForeground(new Color(51, 102, 255));
		TitleLabel.setFont(new Font("????????????", Font.BOLD, 20));
		TitleLabel.setBackground(Color.CYAN);
		TitleLabel.setBounds(400, 10, 166, 20);
		panel.add(TitleLabel);

		JButton backBtn = new JButton("\uB4A4\uB85C\uAC00\uAE30"); // ????????????????????????
		backBtn.setFont(new Font("????????????", Font.PLAIN, 12));
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(12, 10, 103, 24);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 39, 884, 33);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));

		JButton menuBtn1 = new JButton("\uCEE4\uD53C");
		menuBtn1.setFont(new Font("????????????", Font.PLAIN, 15));
		menuBtn1.setBackground(Color.WHITE);
		menuBtn1.setBorder(null);
		panel_1.add(menuBtn1);
		menuBtn1.addActionListener(this);

		JButton menuBtn2 = new JButton("\uC2A4\uD30C\uD074\uB9C1");
		menuBtn2.setFont(new Font("????????????", Font.PLAIN, 15));
		menuBtn2.setBackground(Color.WHITE);
		menuBtn2.setBorder(null);
		panel_1.add(menuBtn2);
		menuBtn2.addActionListener(this);

		JButton MenuBtn3 = new JButton("\uBE59\uC218 \uBC0F \uC2A4\uBB34\uB514");
		MenuBtn3.setFont(new Font("????????????", Font.PLAIN, 15));
		MenuBtn3.setBackground(Color.WHITE);
		MenuBtn3.setBorder(null);
		panel_1.add(MenuBtn3);
		MenuBtn3.addActionListener(this);

		JButton MenuBtn4 = new JButton("\uB77C\uB5BC,\uCD08\uCF5C\uB9BF,\uD2F0");
		MenuBtn4.setFont(new Font("????????????", Font.PLAIN, 15));
		MenuBtn4.setBackground(Color.WHITE);
		MenuBtn4.setBorder(null);
		panel_1.add(MenuBtn4);
		MenuBtn4.addActionListener(this);
		
		panels = new UserPagePanel();
		panels2 = new UserPagePanel2();
		panels3 = new UserPagePanel3();

		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(7, 82, 870, 600);
		frame.getContentPane().add(panels.panel_2);
		frame.getContentPane().add(panels2.panel_2);
		frame.getContentPane().add(panels3.panel_2);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 10, 10));
		
		panels.panel_2.setVisible(false);
		panels2.panel_2.setVisible(false);
		panels3.panel_2.setVisible(false);
		
		for(int i=0;i<8;i++) {
			productListPanel[i] = new JPanel();
			productListPanel[i].setBackground(Color.LIGHT_GRAY);

			productNameListLabel[i] = new JLabel(name[i]);
			productNameListLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			productNameListLabel[i].setFont(new Font("????????????", Font.PLAIN, 12));
			productNameListLabel[i].setBounds(12, 230, 186, 15);
			productListPanel[i].add(productNameListLabel[i]);

			proudctListBtn[i] = new JButton("");
			proudctListBtn[i].setIcon(new ImageIcon("img/"+image[i]));
			proudctListBtn[i].setBackground(new Color(255, 255, 255));
			proudctListBtn[i].setBounds(0, 0, 210, 210);
			proudctListBtn[i].setBorder(null);
			proudctListBtn[i].addActionListener(this);
			
			productListPanel[i].add(proudctListBtn[i]);
			

			productPriceListLabel[i] = new JLabel(price[i]+"???");
			productPriceListLabel[i].setFont(new Font("????????????", Font.PLAIN, 12));
			productPriceListLabel[i].setBounds(87, 255, 45, 15);
			productListPanel[i].add(productPriceListLabel[i]);
			
			panel_2.add(productListPanel[i]);
			productListPanel[i].setLayout(null);
		}
		
		for(int i=8;i<15;i++) {
			proudctListBtn[i] = panels.proudctListBtn[i];
			panels.proudctListBtn[i].addActionListener(this);
		}
		for(int i=15;i<20;i++) {
			proudctListBtn[i] = panels2.proudctListBtn[i];
			panels2.proudctListBtn[i].addActionListener(this);
		}
		for(int i=20;i<28;i++) {
			proudctListBtn[i] = panels3.proudctListBtn[i];
			panels3.proudctListBtn[i].addActionListener(this);
		}
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 692, 884, 260);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JButton deleteBtn = new JButton("?????? ??????");
		deleteBtn.setBorder(null);
		deleteBtn.setBackground(Color.WHITE);
		deleteBtn.setFont(new Font("????????????", Font.PLAIN, 12));
		deleteBtn.setBounds(595, 10, 120, 50);
		deleteBtn.setBorder(null);
		deleteBtn.addActionListener(this);
		panel_4.add(deleteBtn);

		JButton PayBtn = new JButton("\uACB0\uC81C\uD558\uAE30");
		PayBtn.setFont(new Font("????????????", Font.PLAIN, 12));
		PayBtn.setForeground(Color.WHITE);
		PayBtn.setBackground(Color.DARK_GRAY);
		PayBtn.setBounds(595, 166, 267, 84);
		PayBtn.setBorder(null);
		panel_4.add(PayBtn);
		PayBtn.addActionListener(this);

		JLabel orderPriceLabel = new JLabel("?????? ??????:");
		orderPriceLabel.setFont(new Font("????????????", Font.BOLD, 20));
		orderPriceLabel.setBounds(595, 93, 95, 38);
		panel_4.add(orderPriceLabel);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 556, 260);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		panel_6 = new JPanel();

		JScrollPane scrollPane = new JScrollPane(panel_6);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 5, 556, 255);
		panel_5.add(scrollPane);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		totalPrice = new JLabel("2000???");
		totalPrice.setFont(new Font("????????????", Font.BOLD, 20));
		totalPrice.setBounds(767, 93, 95, 38);
		panel_4.add(totalPrice);

		for(int i=0;i<5;i++) {
			ListPanel[i] = new JPanel();
			
			productName[i] = new JLabel();
			productName[i].setBounds(27, 0, 147, 50);
			productName[i].setFont(new Font("????????????", Font.PLAIN, 12));
			ListPanel[i].add(productName[i]);

			productPrice[i] = new JLabel();
			productPrice[i].setBounds(364, 0, 50, 50);
			productPrice[i].setFont(new Font("????????????", Font.PLAIN, 12));
			ListPanel[i].add(productPrice[i]);

			productCount[i] = new JLabel();
			productCount[i].setBounds(248, 0, 35, 50);
			productCount[i].setFont(new Font("????????????", Font.PLAIN, 12));
			ListPanel[i].add(productCount[i]);

			plus[i] = new JButton("+");
			plus[i].setFont(new Font("????????????", Font.PLAIN, 12));
			plus[i].setBounds(280, 14, 50, 23);
			plus[i].setBorder(null);
			plus[i].setBackground(Color.WHITE);
			plus[i].addActionListener(this);
			plus[i].setVisible(false);
			ListPanel[i].add(plus[i]);

			minus[i] = new JButton("-");
			minus[i].setBounds(186, 14, 50, 23);
			minus[i].setFont(new Font("????????????", Font.PLAIN, 12));
			minus[i].setBorder(null);
			minus[i].setBackground(Color.WHITE);
			minus[i].addActionListener(this);
			minus[i].setVisible(false);
			ListPanel[i].add(minus[i] );

			delete[i] = new JButton("X");
			delete[i].setBounds(446, 7, 54, 37);
			delete[i].setFont(new Font("????????????", Font.PLAIN, 12));
			delete[i].setBorder(null);
			delete[i].setBackground(Color.WHITE);
			delete[i].addActionListener(this);
			delete[i].setVisible(false);
			ListPanel[i].add(delete[i]);
			
			panel_6.add(ListPanel[i]);
			ListPanel[i].setLayout(null);
		}
	}
	
	void remove(int i) {
		productName[i].setText("");
		productPrice[i].setText("");
		productCount[i].setText("");
		plus[i].setVisible(false);
		minus[i].setVisible(false);
		delete[i].setVisible(false);
		count=i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		for(int i=0;i<29;i++) {
			if(obj==proudctListBtn[i]) {
				productName[count].setText(name[i]);
				productPrice[count].setText(price[i]+"???");
				productCount[count].setText(num[count]+"???");
				plus[count].setVisible(true);
				minus[count].setVisible(true);
				delete[count].setVisible(true);
				totalprice += Integer.parseInt(price[i]);
				totalPrice.setText(totalprice+"???");
				count++;
			}
		}
		for(int j=0;j<5;j++) {
			if(obj == plus[j]) {
				productCount[j].setText(++num[j]+"???");
				for(int i=0;i<num[j]-1;i++) {
					totalprice+=Integer.parseInt(productPrice[j].getText().substring(0,4));
				}
				totalPrice.setText(totalprice+"???");
			}
			else if(obj == minus[j]) {
				productCount[j].setText(--num[j]+"???");
				for(int i=0;i<num[j];i++) {
					totalprice-=Integer.parseInt(productPrice[j].getText().substring(0,4));
				}
				totalPrice.setText(totalprice+"???");
			}
			else if(obj == delete[j]) {
				totalprice-=Integer.parseInt(productPrice[j].getText().substring(0,4));
				totalPrice.setText(totalprice+"???");
				remove(j);
			}
		}
		
		String text = e.getActionCommand();

		switch(text) {
		case "????????????":
			Loginpage loginpage = new Loginpage();
			frame.dispose();
			loginpage.frmLogin.setVisible(true);
			break;
		case "????????????":
			PaymentPage paymentpage = new PaymentPage();
			paymentpage.frame.setVisible(true);
			break;
		case "??????":
			panel_2.setVisible(true);
			panels.panel_2.setVisible(false);
			panels2.panel_2.setVisible(false);
			panels3.panel_2.setVisible(false);
			break;
		case "????????????":
			panel_2.setVisible(false);
			panels.panel_2.setVisible(true);
			panels2.panel_2.setVisible(false);
			panels3.panel_2.setVisible(false);
			break;
		case "?????? ??? ?????????":
			panel_2.setVisible(false);
			panels.panel_2.setVisible(false);
			panels2.panel_2.setVisible(true);
			panels3.panel_2.setVisible(false);
			break;
		case "??????,?????????,???":
			panel_2.setVisible(false);
			panels.panel_2.setVisible(false);
			panels2.panel_2.setVisible(false);
			panels3.panel_2.setVisible(true);
			break;
		case "?????? ??????":
			totalprice=0;
			totalPrice.setText(totalprice+"???");
			for(int i=0;i<5;i++) {
				num[i]=1;
				productName[i].setText("");
				productPrice[i].setText("");
				productCount[i].setText("");
				plus[i].setVisible(false);
				minus[i].setVisible(false);
				delete[i].setVisible(false);
				count=0;
			}
			break;
		}
	}
}