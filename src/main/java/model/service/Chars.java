package model.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Base64;
import java.util.List;

import javax.management.RuntimeErrorException;

import controler.MyConnection;
import model.bean.chars.CharsBean;
import model.bean.chars.Chars_qualityBean;
import model.dao.chars.CharsDAO;
import model.dao.chars.Chars_qualityDAO;

public class Chars {
	public List<CharsBean> select_CharsByUID(int uid) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsDAO dao = new CharsDAO(con);
		List<CharsBean> mychars = null;
		mychars = dao.selectAllbyuid(uid);

		con.close();
		return mychars;
	}

	public CharsBean select_CharsBycharID(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsBean mychar = null;
		CharsDAO dao = new CharsDAO(con);
		mychar = dao.selectBycharid(char_id);
		con.close();
		return mychar;
	}

	public void insert_Chars(String char_name, String img, int uid) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsDAO dao = new CharsDAO(con);
		String img_base64 = "data:image/jpeg;base64,";
		if (dao.selectAllbyuid(uid).size() < 3) {
			@SuppressWarnings("resource")
			byte[] bytes = new BufferedInputStream(new FileInputStream(img)).readAllBytes();
			img_base64 += Base64.getEncoder().encodeToString(bytes);
			dao.insertChars(uid, char_name, img_base64);
			;
		} else {
			throw new RuntimeErrorException(null);
		}
		con.close();
	}

	public void delete_Chars(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsDAO dao = new CharsDAO(con);
		dao.delectChars(char_id);
		con.close();
	}

	public Chars_qualityBean selectChar_qBycharid(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		Chars_qualityBean mychar_q = dao.selectByChar_id(char_id);
		con.close();
		return mychar_q;
	}
}
