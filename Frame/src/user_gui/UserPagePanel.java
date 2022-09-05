package user_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import httpAPI.RestApi;

public class UserPagePanel {
	
	JPanel panel_2;
	JButton proudctListBtn[];

	public UserPagePanel() {
		
		JSONArray array = UserMainPage.ProudctList();

		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(42, 100, 979, 1269);
		panel_2.setLayout(new GridLayout(3, 6, 50, 50));

		UserMainPage userpage = new UserMainPage("a");

		JPanel productListPanel[] = new JPanel[array.length()];
		JLabel productNameListLabel[] = new JLabel[array.length()];
		proudctListBtn = new JButton[array.length()];
		JLabel productPriceListLabel[] = new JLabel[array.length()];
		
		for(int i=8;i<15;i++) {
			productListPanel[i] = new JPanel();
			productListPanel[i].setBackground(Color.LIGHT_GRAY);

			productNameListLabel[i] = new JLabel(UserMainPage.name[i]);
			productNameListLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			productNameListLabel[i].setFont(new Font("나눔고딕", Font.PLAIN, 12));
			productNameListLabel[i].setBounds(55, 350, 186, 15);
			productListPanel[i].add(productNameListLabel[i]);

			proudctListBtn[i] = new JButton("");
			proudctListBtn[i].setIcon(new ImageIcon("img/"+UserMainPage.image[i]));
			proudctListBtn[i].setBackground(new Color(255, 255, 255));
			proudctListBtn[i].setBounds(0, 0, 300, 300);
			proudctListBtn[i].setBorder(null);
			
			productListPanel[i].add(proudctListBtn[i]);
			

			productPriceListLabel[i] = new JLabel(UserMainPage.price[i]+"원");
			productPriceListLabel[i].setFont(new Font("나눔고딕", Font.PLAIN, 12));
			productPriceListLabel[i].setBounds(130, 320, 45, 15);
			productListPanel[i].add(productPriceListLabel[i]);
			
			panel_2.add(productListPanel[i]);
			productListPanel[i].setLayout(null);
		}
	}
}
