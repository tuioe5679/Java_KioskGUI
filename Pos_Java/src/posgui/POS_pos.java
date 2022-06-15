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
	//ItemDAO ��ü ����(dao) �� �ε�
	
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
	//"��ǰ �ҷ�����" ��ư ��ü ����(btnDB)
	//"��ǰ" �� ��ü ����(lblItem)
	//"��ǰ����Ʈ" �޺��ڽ� ��ü ����(cmbBox)
	//"����" �� ��ü ����(lblStock)
	//"�����Է¹ڽ�" �ؽ�Ʈ�ʵ� ��ü ����(txtStock)
	//"�Ѱ���" �� ��ü ����(lblTotal)
	//"�Ѱ��� ��¹ڽ�" �ؽ�Ʈ�ʵ� ��ü ����(txtTotal)
	//"�߰�" ��ư ��ü ����(btnAdd)
	//"����" ��ư ��ü ����(btnPay)
	//"���" ��ư ��ü ����(btnCancel)
	//"���̺����" JTable ��ü ����(jTableItem)
	
	//JTable�� ����� Model ��ü ����(tableModel)
	//JComboBox�� ����� Model ��ü ����(comboModel)
	
	//�Ѱ��� ������ ������ ������� ����(total)
	
	public POS_pos() {
		
		//�ڵ� ��ġ ���̾ƿ� ��Ȱ��ȭ
		setLayout(null);
		lblItem = new JLabel("��ǰ");
		lblItem.setBounds(20,90,100,30);
		
		lbStock = new JLabel("����");
		lbStock.setBounds(20,140,100,30);
		
		txtStock = new JTextField();
		txtStock.setBounds(70,140,200,30);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(70,250,200,40);
		
		lblTotal = new JLabel("�Ѱ���");
		lblTotal.setBounds(20,250,100,40);
		
		cmbBox = new JComboBox();
		cmbBox.setBounds(70,90,200,30);
		
		btnDB = new JButton("��ǰ �ҷ�����");
		btnDB.setBounds(20,20,140,40);
		
		btnAdd = new JButton("�߰�");
		btnAdd.setBounds(170,190,100,40);
		
		btnPay = new JButton("����");
		btnPay.setBounds(300,250,100,40);
		
		btnCancel = new JButton("���");
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
		
		//�� ������Ʈ ��ü ���� �� ȭ�� ��ġ/ũ�� ����
		//btnDB = new JButton("��ǰ �ҷ�����");
		//btnDB.setBounds(20, 20, 140, 40);
		
		
		//JPanel�� �߰�
		//add(btnDB);
		
		//�̺�Ʈ ó���� ���� ������ ���
		//btnDB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String text = e.getActionCommand();
		String name;
		String stock;
		String price;
		
		
		combomodel =(DefaultTableModel) jTableItem.getModel();
		
		//�̺�Ʈ ��ü�κ��� �ؽ�Ʈ ��������
		//��ǰ��, ���, ���� ������ �������� ���� �� �ʱ�ȭ
		
		//[��ǰ �ҷ�����] ��ư Ŭ�� ��
		if(text.equals("��ǰ �ҷ�����")) {
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
			
			
			//comboBox�� ��� ������ ��� ����(removeAllItems());
			
			//DB�κ��� ��ǰ�� ��ü �˻� �� Vector�� ����
			//Vector�� ������ ��ǰ���� comboBox�� �߰�
			
		}//[�߰�] ��ư Ŭ�� ��
		else if(text.equals("�߰�")) {
			
			// comboBox���� ������ ��ǰ��� �ؽ�Ʈ�ʵ忡 �Է��� ���� ����
			// DB�κ��� ����ڰ� ������ ��ǰ���� �ܰ� �ҷ�����
			// ����ڰ� ������ ��ǰ�� ���Ű���(�ܰ�*����)�� ���� �Ѿ� �����ϱ�
			// ��ǰ��, ���ż���, ���Ű���, �����Ѿ��� Vector�� ����
			// Vector ��ü�� tableModel�� �߰�
			
		}//[����] ��ư Ŭ�� ��
//		else if() {
//			// "�����Ͻðڽ��ϱ�?"��� ���̾�α� â ���(JOptionPane.showConfirmDialog())
//			// "YES"�� ������ "�ѱݾ��� ~�Դϴ�"�� ����� �� ����ڷκ��� ���� �Է¹ޱ�(JOptionPane.showInputDialog())
//			// ����� �Է±ݾ��� �ѱݾ׺��� ũ�� "���ұݾ�,�Ž�����"�� ����� �� DB ������Ʈ(stockUpdate), ��� ������Ʈ ���� ������ �ʱ�ȭ(clean())    
//			// �׷��� ������ "�ݾ��� �����ϴ�" Dialog â ���
//			
//		}//[���] ��ư Ŭ�� ��
//		else {
//			// "�ֹ��� ����Ͻðڽ��ϱ�?" Dialog â ���
//			// ��� ������Ʈ�� ������ �ʱ�ȭ
//		}
	}
	
	// JTable, ������ �Ѱ����� JTextField �� ������ �ʱ�ȭ
	public void clean() {
		
	}
	
	// JTable�� ��µ� ��� �������� ��ǰ��, ���, ������ �̿��Ͽ� DB ������ ������Ʈ 
	public void stockUpdate(DefaultTableModel model) {
					
	}		
}

