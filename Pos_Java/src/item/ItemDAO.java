package item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ItemDAO {
	
	private ItemDAO() {	}
	
	private static ItemDAO instance = new ItemDAO();
	
	public static ItemDAO getInstance() {
		return instance;
	}
	
	//1. ��ü ���ڵ� �˻� ���(getAllItem())
	
	public Vector<Item> getAllItem() throws SQLException {
		
		Vector<Item> list = new Vector<Item>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from item";
		ResultSet rs = null;
		
		try {
			conn = DBconnect.connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//rs ��ȸ�ϸ鼭 Item ��ü ����, Vector�� ������ item �߰�
			while(rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_stock(rs.getInt("item_stock"));
				item.setItem_price(rs.getInt("item_price"));
				list.add(item);
			}			
		}catch(Exception e) {
			System.out.println("DB ���� �Ǵ� SQL ����!");
		}finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return list;
	}
	
	//2. ��ǰ�� ��� ó��
	public Vector<String> getItem() {
		
		Vector<Item> dblist = new Vector<Item>();
		Vector<String> itemlist = new Vector<String>();
		
		try {			
			dblist = getAllItem();			
			for(Item item: dblist) {
				itemlist.add(item.getItem_name());
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemlist;
	}
	
	//3. ��ǰ ���� ��������(item_price)
	public String getPrice(String name) throws SQLException {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select item_price from item where item_name=?";
		ResultSet rs = null;
		String price = null;
		
		try {
			conn = DBconnect.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			//rs ��ȸ�ϸ鼭 Item ��ü ����, Vector�� ������ item �߰�
			while(rs.next()) {
				price = Integer.toString(rs.getInt("item_price"));
			}			
		}catch(Exception e) {
			System.out.println("DB ���� �Ǵ� SQL ����!");
		}finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return price;
	}
	
	//4. ��ǰ ��� ��������(item_stock)
		public String getStock(String name) throws SQLException {		
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "select item_stock from item where item_name=?";
			ResultSet rs = null;
			String stock = null;
			
			try {
				conn = DBconnect.connect();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				
				//rs ��ȸ�ϸ鼭 Item ��ü ����, Vector�� ������ item �߰�
				while(rs.next()) {
					stock = Integer.toString(rs.getInt("item_stock"));
				}			
			}catch(Exception e) {
				System.out.println("DB ���� �Ǵ� SQL ����!");
			}finally {
				rs.close();
				pstmt.close();
				conn.close();
			}
			
			return stock;
		}
		
		//5. ��ǰ ��� ������Ʈ�ϱ�(item_stock==> total, stock, name)
			public void updateStock(String total, String stock, String name) throws SQLException {		
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql = "update item set item_stock=?-? where item_name=?";
								
				try {
					conn = DBconnect.connect();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, total);
					pstmt.setString(2, stock);
					pstmt.setString(3, name);
					pstmt.executeUpdate();				
							
				}catch(Exception e) {
					System.out.println("DB ���� �Ǵ� SQL ����!");
				}finally {
					pstmt.close();
					conn.close();
				}
			}
			
			
		//6. ������ȭ�� - ��ǰ �ű� ���
		public boolean insertItem(Item item) throws SQLException {
			boolean result = false;			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql="insert into item(item_name, item_stock, item_price) values(?, ?, ?)";
		
			try {
				conn = DBconnect.connect();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, item.getItem_name());
				pstmt.setInt(2, item.getItem_stock());
				pstmt.setInt(3, item.getItem_price());
				
				int r = pstmt.executeUpdate();
				
				if(r>0) {
					result = true;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				pstmt.close();
				conn.close();
			}
			
			return result;
		}
			
		//6. ������ȭ�� - ��ǰ ���� ����
			
		//6. ������ȭ�� - ��� ��ǰ ����	
			

}







