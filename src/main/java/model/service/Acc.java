package model.service;

import java.sql.Connection;

import javax.management.RuntimeErrorException;

import controler.MyConnection;
import model.bean.community.AccountBean;
import model.dao.community.AccountDAO;

public class Acc {
	public AccountBean login_SelectAccount(String account, String password) throws Exception {
		Connection con = MyConnection.getMyConnection();
		AccountDAO dao = null;
		boolean flag1 = false;
		boolean flag2 = false;
		dao = new AccountDAO(con);
		AccountBean acc = dao.selectByAccount(account);
		System.out.println(account.equals(acc.getAccount()));
		System.out.println(password.equals(acc.getPassword()));
		if (account.equals(acc.getAccount())) {
			flag1 = true;
		}
		if (password.equals(acc.getPassword())) {
			flag2 = true;
		}
		if (flag1 && flag2) {
			return acc;
		}
		con.close();
		return null;
	}

	public void insert_account(String account, String password) throws Exception {
		Connection con = MyConnection.getMyConnection();
		AccountDAO dao = null;
		dao = new AccountDAO(con);
		AccountBean acc = dao.selectByAccount(account);
		System.out.println(acc == null);
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		if (acc == null) {
			flag1 = true;
		}
		if(account.length()>0) {
			flag2 = true;
		}
		if(password.length()>0) {
			flag3 = true;
		}
		if(flag1&&flag2&&flag3) {
			dao.insertAccount(account, password);
		}else {
			throw new RuntimeErrorException(null);
		}
		con.close();
	}

}
