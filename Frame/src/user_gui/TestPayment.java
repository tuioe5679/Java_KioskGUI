//package user_gui;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JButton;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Vector;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
//import javax.swing.border.TitledBorder;
//import httpAPI.RestApi;
//import jssc.SerialPort;
//import jssc.SerialPortException;
//import jssc.SerialPortList;
//
//import javax.swing.border.EtchedBorder;
//import java.awt.GridLayout;
//
//public class TestPayment implements ActionListener {
//
//	public static JFrame frame;
//	static int as = 1;
//	public static String retrunvalue;
//	
//	JLabel numlabel_2[];
//	JLabel OrderNamelabel_1[];
//	JLabel countLabel_1_1[];
//	JLabel Pricelabel_1[];
//	static JLabel NowPricenum;
//
//	/**
//	 * Launch the application.
//	 * @throws SerialPortException 
//	 */
//	public static void main(String[] args) throws SerialPortException {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TestPayment window = new TestPayment();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		String[] portNames = SerialPortList.getPortNames();
//		SerialPort serialPort = new SerialPort("COM12");
//		serialPort.openPort();// Open serial port
//		serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
//				SerialPort.PARITY_NONE);
//		while (true) {
//			byte[] read = serialPort.readBytes();
//			if (read != null && read.length > 0) {
//				if (new String(read).equals("1")) {
//					NowPricenum.setText(as*5000 + "원");
//					as++;
//				}
//			}
//		}
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public TestPayment() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		
//		numlabel_2 = new JLabel[UserMainPage.count];
//		OrderNamelabel_1 = new JLabel[UserMainPage.count];
//		countLabel_1_1 = new JLabel[UserMainPage.count];
//		Pricelabel_1 = new JLabel[UserMainPage.count];
//		
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 445);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//
//		JPanel panel = new JPanel();
//		panel.setBounds(0, 0, 434, 405);
//		frame.getContentPane().add(panel);
//		panel.setLayout(null);
//
//		JButton BackBtn = new JButton("\uCDE8\uC18C\uD558\uAE30");
//		BackBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
//		BackBtn.setForeground(Color.GRAY);
//		BackBtn.setBackground(Color.WHITE);
//		BackBtn.setBounds(100, 320, 97, 43);
//		panel.add(BackBtn);
//		BackBtn.addActionListener(this);
//
//		JButton PayMentBtn = new JButton("\uACB0\uC81C\uD558\uAE30");
//		PayMentBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
//		PayMentBtn.setForeground(Color.WHITE);
//		PayMentBtn.setBackground(Color.DARK_GRAY);
//		PayMentBtn.setBounds(220, 320, 97, 43);
//		PayMentBtn.addActionListener(this);
//		panel.add(PayMentBtn);
//
//		JLabel NowPrice = new JLabel("\uD22C\uC785\uAE08\uC561");
//		NowPrice.setFont(new Font("나눔고딕", Font.BOLD, 18));
//		NowPrice.setBounds(100, 233, 97, 38);
//		panel.add(NowPrice);
//
//		NowPricenum = new JLabel("0원");
//		NowPricenum.setForeground(Color.DARK_GRAY);
//		NowPricenum.setFont(new Font("나눔고딕", Font.BOLD, 18));
//		NowPricenum.setBounds(258, 242, 97, 21);
//		panel.add(NowPricenum);
//
//		JPanel panel_1 = new JPanel();
//		panel_1.setBorder(new TitledBorder(
//				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
//				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
//		panel_1.setBounds(65, 10, 290, 213);
//		panel.add(panel_1);
//		panel_1.setLayout(null);
//
//		JPanel panel_2_1 = new JPanel();
//		panel_2_1.setBackground(Color.LIGHT_GRAY);
//		panel_2_1.setBounds(0, 0, 180, 20);
//		panel_1.add(panel_2_1);
//		panel_2_1.setLayout(null);
//
//		JLabel OrderList = new JLabel("\uC8FC\uBB38\uBAA9\uB85D");
//		OrderList.setFont(new Font("나눔고딕", Font.PLAIN, 12));
//		OrderList.setVerticalAlignment(SwingConstants.BOTTOM);
//		OrderList.setBounds(66, 2, 48, 15);
//		panel_2_1.add(OrderList);
//
//		JPanel panel_2_1_1 = new JPanel();
//		panel_2_1_1.setBackground(Color.LIGHT_GRAY);
//		panel_2_1_1.setBounds(180, 0, 45, 20);
//		panel_1.add(panel_2_1_1);
//		panel_2_1_1.setLayout(null);
//
//		JLabel OrderIndex = new JLabel("\uC218\uB7C9");
//		OrderIndex.setFont(new Font("나눔고딕", Font.PLAIN, 12));
//		OrderIndex.setBounds(10, 2, 24, 15);
//		panel_2_1_1.add(OrderIndex);
//
//		JPanel panel_2_1_1_1 = new JPanel();
//		panel_2_1_1_1.setBackground(Color.LIGHT_GRAY);
//		panel_2_1_1_1.setBounds(225, 0, 65, 20);
//		panel_1.add(panel_2_1_1_1);
//		panel_2_1_1_1.setLayout(null);
//
//		JLabel OrderPrice = new JLabel("\uAC00\uACA9");
//		OrderPrice.setFont(new Font("나눔고딕", Font.PLAIN, 12));
//		OrderPrice.setBounds(20, 2, 24, 15);
//		panel_2_1_1_1.add(OrderPrice);
//
//		JPanel panel_3 = new JPanel();
//		panel_3.setBounds(0, 22, 290, 191);
//		panel_1.add(panel_3);
//		panel_3.setLayout(new GridLayout(8, 1, 0, 0));
//		
//		JLabel PayPrice = new JLabel("\uACB0\uC81C\uAE08\uC561");
//		PayPrice.setFont(new Font("나눔고딕", Font.BOLD, 18));
//		PayPrice.setBounds(100, 272, 97, 38);
//		panel.add(PayPrice);
//
//		JLabel PayPricenum = new JLabel("0원");
//		PayPricenum.setForeground(Color.RED);
//		PayPricenum.setFont(new Font("나눔고딕", Font.BOLD, 18));
//		PayPricenum.setBounds(258, 278, 97, 26);
//		panel.add(PayPricenum);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String text = e.getActionCommand();
//		if (text.equals("취소하기")) {
//			PaymentPage.frame.dispose();
//		}
//		else if (text.equals("결제하기")) {
//			Vector<String> postvalue = new Vector<String>();
//			for(int i=0;i<UserMainPage.count;i++) {
//				postvalue.add(0, numlabel_2[i].getText());
//				postvalue.add(1, OrderNamelabel_1[i].getText());
//				postvalue.add(2, Pricelabel_1[i].getText().substring(0,4));
//				postvalue.add(3, countLabel_1_1[0].getText().substring(0,1));
//				retrunvalue=RestApi.ordersDAOPost("orders/post", postvalue);
//			}	
//			if(!retrunvalue.equals("")) {
//				JOptionPane.showConfirmDialog(null, "결제완료","성공",JOptionPane.INFORMATION_MESSAGE);
//			}
//			else if(retrunvalue.equals("")){
//				JOptionPane.showConfirmDialog(null, "결제실패","경고",JOptionPane.WARNING_MESSAGE);
//			}
//		}
//	}
//}