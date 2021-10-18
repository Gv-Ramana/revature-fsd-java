package com.revature.bankapp.dao;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

public interface CustomerDao {
  int create(Customer customer) throws AppException;
}
