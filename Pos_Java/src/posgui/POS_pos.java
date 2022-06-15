package posgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import item.Item;
import item.ItemDAO;


public class POS_pos extends JPanel implements ActionListener{
	
	ItemDAO item;
	//ItemDAO 객체 생성(dao) 및 로드
	
	JLabel lblItem;
	JLabel lblTotal;
	JComboBox cmbBox;
	JLabel lbStock;
	JTextField txtStock;
	JTextField txtTotal;
	JButton btnDB;
	JButton btnAdd;
	JButton btnPay;
	JButton btnCancel;
	JTable jTableItem;
	
	DefaultTableModel tableModel;
	DefaultTableModel combomodel;
	
	int total;
	//"제품 불러오기" 버튼 객체 선언(btnDB)
	//"상품" 라벨 객체 선언(lblItem)
	//"상품리스트" 콤보박스 객체 선언(cmbBox)
	//"수량" 라벨 객체 선언(lblStock)
	//"수량입력박스" 텍스트필드 객체 선언(txtStock)
	//"총가격" 라벨 객체 선언(lblTotal)
	//"총가격 출력박스" 텍스트필드 객체 선언(txtTotal)
	//"추가" 버튼 객체 선언(btnAdd)
	//"결재" 버튼 객체 선언(btnPay)
	//"취소" 버튼 객체 선언(btnCancel)
	//"테이블출력" JTable 객체 선언(jTableItem)
	
	//JTable에 출력할 Model 객체 선언(tableModel)
	//JComboBox에 출력할 Model 객체 선언(comboModel)
	
	//총가격 저장할 정수형 멤버변수 선언(total)
	
	public POS_pos() {
		
		//자동 배치 레이아웃 비활성화
		setLayout(null);
		lblItem = new JLabel("상품");
		lblItem.setBounds(20,90,100,30);
		
		lbStock = new JLabel("수량");
		lbStock.setBounds(20,140,100,30);
		
		txtStock = new JTextField();
		txtStock.setBounds(70,140,200,30);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(70,250,200,40);
		
		lblTotal = new JLabel("총가격");
		lblTotal.setBounds(20,250,100,40);
		
		cmbBox = new JComboBox();
		cmbBox.setBounds(70,90,200,30);
		
		btnDB = new JButton("제품 불러오기");
		btnDB.setBounds(20,20,140,40);
		
		btnAdd = new JButton("추가");
		btnAdd.setBounds(170,190,100,40);
		
		btnPay = new JButton("결제");
		btnPay.setBounds(300,250,100,40);
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(410,250,100,40);
		
		jTableItem = new JTable();
		jTableItem.setBounds(300,20,210,210);
		
		add(btnDB);
		add(btnAdd);
		add(btnPay);
		add(btnCancel);
		add(lbStock);
		add(lblItem);
		add(lblTotal);
		add(txtStock);
		add(txtTotal);
		add(jTableItem);
		add(cmbBox);
		
		btnDB.addActionListener(this);
		btnAdd.addActionListener(this);
		btnPay.addActionListener(this);
		btnCancel.addActionListener(this);
		
		setVisible(true);
		
		//각 컴포넌트 객체 생성 및 화면 배치/크기 조정
		//btnDB = new JButton("제품 불러오기");
		//btnDB.setBounds(20, 20, 140, 40);
		
		
		//JPanel에 추가
		//add(btnDB);
		
		//이벤트 처리를 위한 리스너 등록
		//btnDB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String text = e.getActionCommand();
		String name;
		String stock;
		String price;
		
		
		combomodel =(DefaultTableModel) jTableItem.getModel();
		
		//이벤트 객체로부터 텍스트 가져오기
		//제품명, 재고량, 가격 저장할 지역변수 선언 및 초기화
		
		//[제품 불러오기] 버튼 클릭 시
		if(text.equals("제품 불러오기")) {
			cmbBox.removeAllItems();
			try {
				Vector<Item> itemlist = ItemDAO.getInstance().getAllItem();
				for(Item item:itemlist) {
					String item_name = item.getItem_name();
					Vector<String> in = new Vector<String>();
					in.add(item_name);
					combomodel.addRow(in);
				}
			
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//comboBox의 모든 데이터 요소 삭제(removeAllItems());
			
			//DB로부터 상품명 전체 검색 및 Vector에 저장
			//Vector에 저장한 상품명을 comboBox에 추가
			
		}//[추가] 버튼 클릭 시
		else if(text.equals("추가")) {
			
			// comboBox에서 선택한 상품명과 텍스트필드에 입력한 수량 저장
			// DB로부터 사용자가 선택한 상품명의 단가 불러오기
			// 사용자가 선택한 상품의 구매가격(단가*수량)과 누적 총액 연산하기
			// 상품명, 구매수량, 구매가격, 누적총액을 Vector에 저장
			// Vector 객체를 tableModel에 추가
			
		}//[결재] 버튼 클릭 시
//		else if() {
//			// "결재하시겠습니까?"라는 다이얼로그 창 출력(JOptionPane.showConfirmDialog())
//			// "YES"를 누르면 "총금액은 ~입니다"를 출력한 후 사용자로부터 숫자 입력받기(JOptionPane.showInputDialog())
//			// 사용자 입력금액이 총금액보다 크면 "지불금액,거스름돈"을 출력한 후 DB 업데이트(stockUpdate), 모든 컴포넌트 내의 데이터 초기화(clean())    
//			// 그렇지 않으면 "금액이 적습니다" Dialog 창 출력
//			
//		}//[취소] 버튼 클릭 시
//		else {
//			// "주문을 취소하시겠습니까?" Dialog 창 출력
//			// 모든 컴포넌트의 데이터 초기화
//		}
	}
	
	// JTable, 수량과 총가격의 JTextField 내 데이터 초기화
	public void clean() {
		
	}
	
	// JTable에 출력된 모든 데이터의 상품명, 재고량, 가격을 이용하여 DB 데이터 업데이트 
	public void stockUpdate(DefaultTableModel model) {
					
	}		
}

