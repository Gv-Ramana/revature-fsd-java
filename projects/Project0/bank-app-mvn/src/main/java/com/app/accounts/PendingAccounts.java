package com.app.accounts;
import java.sql.SQLException;



import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.dao.Util;
import com.app.dao.impl.AccountDaoImpl;
import com.mysql.cj.log.LogFactory;

public class PendingAccounts {
	
	private boolean success;

	public void viewPending(){
		
		AccountDaoImpl accdao = new AccountDaoImpl();
		final Logger LOGGER = LogFactory.getLogger(Util.class);
		Scanner sc = new Scanner(System.in);
		
		try {
			List<Account> account = accdao.pendingList();
			for(int i = 0; i < account.size(); i++) {
				LOGGER.info(account.get(i).printId());
				int tempId = account.get(i).getId();
				success = true;
				while(success) {
					LOGGER.info("Approve (A) or Reject (R)");
					char choice = sc.nextLine().charAt(0);
					if(choice == 'A') {
						accdao.approveAccount(tempId);
						success = false;
					} else if(choice == 'R') {
						accdao.rejectAccount(tempId);
						success = false;
					} else {
						LOGGER.info("Enter valid input");
					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
