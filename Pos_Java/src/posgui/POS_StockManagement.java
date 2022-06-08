package posgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import item.Item;
import item.ItemDAO;

public class POS_StockManagement extends JPanel implements ActionListener {
	
	private JLabel labelName;
	private JTable jtableStock;
	private JButton buttonDB;
	private JButton buttonRegister;
	private JButton buttonUpdate;
	private JButton buttonDelete;
	
	public POS_StockManagement() {
		setLayout(null);
		
		labelName = new JLabel("�����Ȳ");
		labelName.setSize(100,40);
		labelName.setLocation(60,20);
		
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int i,int c) {
				return false;
			}
		};
		model.addColumn("id");
		model.addColumn("��ǰ��");
		model.addColumn("���");
		model.addColumn("��ǰ����");
		
		jtableStock = new JTable(model);
		jtableStock.setBounds(200,20,300,200);
		
		buttonDB = new JButton("��ǰ ���� ��ħ");
		buttonDB.setBounds(10,70,150,40);
		
		buttonRegister = new JButton("���");
		buttonRegister.setBounds(10,130,150,40);
		
		buttonUpdate = new JButton("����");
		buttonUpdate.setBounds(10,190,150,40);
		
		buttonDelete = new JButton("����");
		buttonDelete.setBounds(10,250,150,40);
		
		add(labelName);
		add(jtableStock);
		add(buttonDB);
		add(buttonRegister);
		add(buttonUpdate);
		add(buttonDelete);
		
		buttonDB.addActionListener(this);
		buttonRegister.addActionListener(this);
		buttonUpdate.addActionListener(this);
		buttonDelete.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();// �ش� ��ü�� ������ 
		
		DefaultTableModel model =(DefaultTableModel) jtableStock.getModel();
		
		if(obj==buttonDB) {
			try {
				lodaDB(model);
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void lodaDB(DefaultTableModel model) throws SQLException{
		Vector<Item> itemlist = ItemDAO.getInstance().getAllItem();
		int rows = model.getRowCount();
		
		for(int i=rows-1;i>=0;i--) {
			model.removeRow(i);
		}
		for(Item item:itemlist) {
			System.out.println(model.getRowCount());
			String item_id = String.valueOf(item.getId());// String���� ����ȯ 
			String item_name = item.getItem_name();
			String item_stock = String.valueOf(item.getItem_stock());
			String item_price = String.valueOf(item.getItem_price());
			Vector<String> in = new Vector<String>();
			in.add(item_id);
			in.add(item_name);
			in.add(item_stock);
			in.add(item_price);
			model.addRow(in);
		}
	}
}
