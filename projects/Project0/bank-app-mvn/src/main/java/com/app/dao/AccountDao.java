package com.app.dao;

import java.sql.SQLException;

import com.app.accounts.Account;

public interface AccountDao {
	
	void create(Account account) throws SQLException;

}
