package user_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class PaymentPage implements ActionListener{

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentPage window = new PaymentPage();
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
	public PaymentPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 405);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton BackBtn = new JButton("이전화면");
		BackBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		BackBtn.setForeground(Color.GRAY);
		BackBtn.setBackground(Color.WHITE);
		BackBtn.setBounds(100, 320, 97, 43);
		panel.add(BackBtn);
		BackBtn.addActionListener(this);
		
		JButton PayMentBtn = new JButton("결제");
		PayMentBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		PayMentBtn.setForeground(Color.WHITE);
		PayMentBtn.setBackground(Color.DARK_GRAY);
		PayMentBtn.setBounds(220, 320, 97, 43);
		panel.add(PayMentBtn);
		
		JLabel NowPrice = new JLabel("현재 금액:");
		NowPrice.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 17));
		NowPrice.setBounds(100, 233, 97, 38);
		panel.add(NowPrice);
		
		JLabel NowPricenumBtn = new JLabel("0원");
		NowPricenumBtn.setForeground(Color.DARK_GRAY);
		NowPricenumBtn.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		NowPricenumBtn.setBounds(258, 242, 97, 21);
		panel.add(NowPricenumBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(65, 10, 290, 213);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1.setBounds(0, 0, 180, 20);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel OrderList = new JLabel("주문목록");
		OrderList.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		OrderList.setVerticalAlignment(SwingConstants.BOTTOM);
		OrderList.setBounds(66, 2, 48, 15);
		panel_2_1.add(OrderList);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1_1.setBounds(180, 0, 45, 20);
		panel_1.add(panel_2_1_1);
		panel_2_1_1.setLayout(null);
		
		JLabel OrderIndex = new JLabel("수량");
		OrderIndex.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		OrderIndex.setBounds(10, 2, 24, 15);
		panel_2_1_1.add(OrderIndex);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1_1_1.setBounds(225, 0, 65, 20);
		panel_1.add(panel_2_1_1_1);
		panel_2_1_1_1.setLayout(null);
		
		JLabel OrderPrice = new JLabel("가격");
		OrderPrice.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		OrderPrice.setBounds(20, 2, 24, 15);
		panel_2_1_1_1.add(OrderPrice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1, 20, 287, 25);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel numBtn = new JLabel("1");
		numBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		numBtn.setBounds(10, 5, 23, 15);
		panel_2.add(numBtn);
		
		JLabel OrderNameBtn = new JLabel("아이스 아메리카노");
		OrderNameBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		OrderNameBtn.setBounds(45, 5, 135, 15);
		panel_2.add(OrderNameBtn);
		
		JLabel numBtn_1 = new JLabel("1");
		numBtn_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		numBtn_1.setBounds(198, 5, 23, 15);
		panel_2.add(numBtn_1);
		
		JLabel PriceBtn = new JLabel("5000원");
		PriceBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		PriceBtn.setBounds(240, 5, 45, 15);
		panel_2.add(PriceBtn);
		
		JLabel PayPrice = new JLabel("결제 금액 :");
		PayPrice.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 17));
		PayPrice.setBounds(100, 272, 97, 38);
		panel.add(PayPrice);
		
		JLabel PayPricenum = new JLabel("2000원");
		PayPricenum.setForeground(Color.RED);
		PayPricenum.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		PayPricenum.setBounds(258, 284, 97, 15);
		panel.add(PayPricenum);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();
		if(text.equals("이전화면")) {
			PaymentPage.frame.dispose();
		}
	}
}
