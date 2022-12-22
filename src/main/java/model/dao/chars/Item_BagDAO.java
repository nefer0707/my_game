package model.dao.chars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.chars.Item_BagBean;

public class Item_BagDAO {

	Connection con;

	public Item_BagDAO(Connection con) {
		this.con = con;
	}

	public Item_BagBean select_item_bag(int char_id, int item_id) throws SQLException {
		String sql = "select * from ([MyGame].[dbo].[item_bag] as a inner join [MyGame].[dbo].[item] as b on a.item_id = b.item_id)inner join [MyGame].[dbo].[Item_type] as c on b.item_type_id = c.item_type_id where a.char_id = ? and a.item_id =?";
		Item_BagBean myItem = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, char_id);
		ps.setInt(2, item_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			char_id = rs.getInt("char_id");
			item_id = rs.getInt("item_id");
			String item_name = rs.getString("item_name");
			int item_type_id = rs.getInt("item_type_id");
			String caption = rs.getString("caption");
			int add_hp = rs.getInt("add_hp");
			int add_mp = rs.getInt("add_mp");
			int add_points = rs.getInt("add_points");
			int add_str = rs.getInt("add_str");
			int add_inte = rs.getInt("add_inte");
			int add_dex = rs.getInt("add_dex");
			int add_agi = rs.getInt("add_agi");
			int add_luk = rs.getInt("add_luk");
			int add_vit = rs.getInt("add_vit");
			int add_money = rs.getInt("add_money");
			int add_exp = rs.getInt("add_exp");
			int add_job_exp = rs.getInt("add_job_exp");
			int sell_money = rs.getInt("sell_money");
			int buy_money = rs.getInt("buy_money");
			int add_max_hp = rs.getInt("add_max_hp");
			int add_max_mp = rs.getInt("add_max_mp");
			int count = rs.getInt("count");
			int add_lv = rs.getInt("add_lv");
			int add_job_lv = rs.getInt("add_job_lv");
			String item_type_name = rs.getString("item_type_name");
			myItem = new Item_BagBean(char_id, item_id, count, item_name, item_type_id, caption, add_hp, add_mp,
					add_points, add_str, add_inte, add_dex, add_agi, add_luk, add_vit, add_money, add_exp, add_job_exp,
					sell_money, buy_money, add_max_hp, add_max_mp, add_lv, add_job_lv, item_type_name);
		}
		return myItem;
	}

	public List<Item_BagBean> select_item_bag_all(int char_id) throws SQLException {
		String sql = "select * from ([MyGame].[dbo].[item_bag] as a inner join [MyGame].[dbo].[item] as b on a.item_id = b.item_id)inner join [MyGame].[dbo].[Item_type] as c on b.item_type_id = c.item_type_id where a.char_id = ? ";
		List<Item_BagBean> myitems = new ArrayList<Item_BagBean>();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, char_id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			char_id = rs.getInt("char_id");
			int item_id = rs.getInt("item_id");
			String item_name = rs.getString("item_name");
			int item_type_id = rs.getInt("item_type_id");
			String caption = rs.getString("caption");
			int add_hp = rs.getInt("add_hp");
			int add_mp = rs.getInt("add_mp");
			int add_points = rs.getInt("add_points");
			int add_str = rs.getInt("add_str");
			int add_inte = rs.getInt("add_inte");
			int add_dex = rs.getInt("add_dex");
			int add_agi = rs.getInt("add_agi");
			int add_luk = rs.getInt("add_luk");
			int add_vit = rs.getInt("add_vit");
			int add_money = rs.getInt("add_money");
			int add_exp = rs.getInt("add_exp");
			int add_job_exp = rs.getInt("add_job_exp");
			int sell_money = rs.getInt("sell_money");
			int buy_money = rs.getInt("buy_money");
			int add_max_hp = rs.getInt("add_max_hp");
			int add_max_mp = rs.getInt("add_max_mp");
			int count = rs.getInt("count");
			int add_lv = rs.getInt("add_lv");
			int add_job_lv = rs.getInt("add_job_lv");
			String item_type_name = rs.getString("item_type_name");
			Item_BagBean myItem = new Item_BagBean(char_id, item_id, count, item_name, item_type_id, caption, add_hp,
					add_mp, add_points, add_str, add_inte, add_dex, add_agi, add_luk, add_vit, add_money, add_exp,
					add_job_exp, sell_money, buy_money, add_max_hp, add_max_mp, add_lv, add_job_lv, item_type_name);
			myitems.add(myItem);

		}
		return myitems;
	}

	public void update_item_bag(int char_id, int item_id, int count) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[item_bag] SET [count] = ? WHERE char_id = ? and item_id = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, count);
		ps.setInt(2, char_id);
		ps.setInt(3, item_id);
		ps.executeUpdate();
	}

	public void delete_item_bag(int char_id, int item_id) throws SQLException {
		String sql = "delete from [MyGame].[dbo].[item_bag] WHERE item_id= ? and char_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, item_id);
		ps.setInt(2, char_id);
		ps.executeUpdate();
	}

	public void insert_item_bag(int char_id, int item_id, int count) throws SQLException {
		String sql = "insert into [MyGame].[dbo].[item_bag](count,char_id,item_id) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, count);
		ps.setInt(2, char_id);
		ps.setInt(3, item_id);
		ps.executeUpdate();
	}

}
