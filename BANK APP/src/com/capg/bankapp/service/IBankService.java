package com.capg.bankapp.service;

import java.util.List;

import com.capg.bankapp.bean.CustomerBean;
import com.capg.bankapp.bean.TransactionBean;

public interface IBankService {

	boolean deposit(CustomerBean bankBean, double depositAmount, Long phoneNo);

	boolean validations(CustomerBean customerBean) throws Exception;

	boolean addCustomer(CustomerBean customerBean);

	boolean withDraw(CustomerBean bankBean, double withDrawAmount, Long phoneNo);

	double showBalance(CustomerBean customerBean,Long phoneNo);

	boolean fundTransfer(CustomerBean customerBean, Long senderPhoneNumber, Long recievePhoneNumber, double transferAmount);

	List<TransactionBean> transactions(Long phoneNo);

	
}
