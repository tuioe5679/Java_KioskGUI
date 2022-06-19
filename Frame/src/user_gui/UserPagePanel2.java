package user_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.json.JSONArray;

public class UserPagePanel2 {

	JPanel panel_2;
	JButton proudctListBtn[];

	public UserPagePanel2() {

		JSONArray array = UserMainPage.ProudctList();

		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(7, 82, 870, 600);
		panel_2.setLayout(new GridLayout(0, 4, 10, 10));

		UserMainPage userpage = new UserMainPage("a");

		JPanel productListPanel[] = new JPanel[array.length()];
		JLabel productNameListLabel[] = new JLabel[array.length()];
		proudctListBtn = new JButton[array.length()];
		JLabel productPriceListLabel[] = new JLabel[array.length()];

		for (int i = 15; i < 20; i++) {
			productListPanel[i] = new JPanel();
			productListPanel[i].setBackground(Color.LIGHT_GRAY);

			productNameListLabel[i] = new JLabel(UserMainPage.name[i]);
			productNameListLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			productNameListLabel[i].setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
			productNameListLabel[i].setBounds(12, 230, 186, 15);
			productListPanel[i].add(productNameListLabel[i]);

			proudctListBtn[i] = new JButton("");
			proudctListBtn[i].setIcon(new ImageIcon("img/" + UserMainPage.image[i]));
			proudctListBtn[i].setBackground(new Color(255, 255, 255));
			proudctListBtn[i].setBounds(0, 0, 210, 210);
			proudctListBtn[i].setBorder(null);
			productListPanel[i].add(proudctListBtn[i]);

			productPriceListLabel[i] = new JLabel(UserMainPage.price[i] + "¿ø");
			productPriceListLabel[i].setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
			productPriceListLabel[i].setBounds(87, 255, 45, 15);
			productListPanel[i].add(productPriceListLabel[i]);

			panel_2.add(productListPanel[i]);
			productListPanel[i].setLayout(null);
		}
	}
}
