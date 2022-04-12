package com.sinensia.services;

import java.sql.SQLException;
import java.util.List;

import com.sinensia.contracts.IDao;
import com.sinensia.dao.UserAccountDao;
import com.sinensia.model.UserAccount;

public class UserAccountService implements IDao<UserAccount>{
	private UserAccountDao userAccountDao  = new UserAccountDao();
	@Override
	public int add(UserAccount userAccount) throws SQLException {
		return userAccountDao.add(userAccount);
	}

	@Override
	public int modify(UserAccount userAccount) throws SQLException {
		return 0;
	}

	@Override
	public List<UserAccount> get() throws SQLException {
		return userAccountDao.get();
	}

	@Override
	public UserAccount getById(int id) throws SQLException {
		return userAccountDao.getById(id);
	}

	@Override
	public int remove(int id) throws SQLException {
		return 0;
	}
}
