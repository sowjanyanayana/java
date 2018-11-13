package com.capg.bankapp.dao;

import java.util.List;

import com.capg.bankapp.bean.CustomerBean;
import com.capg.bankapp.bean.TransactionBean;

public interface IBankDAO {

	boolean addCustomer(CustomerBean customerBean);

	boolean deposit(CustomerBean bankBean, double depositAmount, Long phoneNo);

	boolean withDraw(CustomerBean customerBean, double withDrawAmount, Long phoneNo);

	double showBalance(CustomerBean customerBean,Long phoneNo);

	boolean fundTransfer(CustomerBean customerBean, Long senderPhoneNumber, Long recievePhoneNumber, double transferAmount);

	List<TransactionBean> transactions(Long phoneNo);

	






}
