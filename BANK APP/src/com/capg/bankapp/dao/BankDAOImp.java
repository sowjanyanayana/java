package com.capg.bankapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capg.bankapp.bean.CustomerBean;
import com.capg.bankapp.bean.TransactionBean;

public class BankDAOImp implements IBankDAO {


	private static List<CustomerBean> list = DataBase.getCustomerDetails();
	private static List<TransactionBean> transList=new ArrayList<TransactionBean>();
	CustomerBean bean = new CustomerBean();

	@Override
	public boolean addCustomer(CustomerBean customerBean) {
		// TODO Auto-generated method stub
		return list.add(customerBean);
	}

	@Override
	public boolean deposit(CustomerBean customerBean, double depositAmount, Long phoneNo) {

		boolean b1 = false;
		for (CustomerBean bean1 : list) {
			if (depositAmount > 0) {
				
				if (bean1.getPhNo().equals(phoneNo)) {

					bean1.setBalance(bean1.getBalance() + depositAmount);
					
					TransactionBean transactionBean=new TransactionBean();
					transactionBean.setDeposit(depositAmount);
					transactionBean.setDateTime(new Date());
					transactionBean.setPhoneNo(phoneNo);
					transactionBean.setTransactionType("Deposit");
					transList.add(transactionBean);
					
					b1 = true;
				}
			}
		}
		return b1;

	}

	@Override
	public boolean withDraw(CustomerBean customerBean, double withDrawAmount, Long phoneNo) {
		boolean b2 = false;
		for (CustomerBean bean2 : list) {
			if (bean2.getBalance() - withDrawAmount > 0) {
				if (bean2.getPhNo().equals(phoneNo)) {

					bean2.setBalance(bean2.getBalance() - withDrawAmount);
					TransactionBean transactionBean=new TransactionBean();
					transactionBean.setWithDraw(withDrawAmount);
					transactionBean.setPhoneNo(phoneNo);
					transactionBean.setDateTime(new Date());
					transactionBean.setTransactionType("withdraw");
					transList.add(transactionBean);
					b2 = true;
				}
			}
		}
		return b2;

	}

	@Override
	public double showBalance(CustomerBean customerBean, Long phoneNo) {
		double bal = 0.0;
		for (CustomerBean customerBean2 : list) {
			if (customerBean2.getPhNo().equals(phoneNo)) {
				bal=customerBean2.getBalance();
				
			}
		}
		return bal;
	}

	@Override
	public boolean fundTransfer(CustomerBean customerBean, Long senderPhoneNumber, Long recievePhoneNumber,
			double transferAmount) {

		boolean valid=false ;
		if(DataBase.validatePhnNo(senderPhoneNumber)) {

			if( DataBase.validatePhnNo(recievePhoneNumber)) {
				
				if(withDraw(customerBean, transferAmount, senderPhoneNumber)) {
					deposit(customerBean, transferAmount, recievePhoneNumber);
					valid=true;
				}
			}
			
			
		}
		return valid;
	}

	@Override
	public List<TransactionBean> transactions(Long phoneNo) {
		
		List<TransactionBean> trans = new ArrayList<>();
		for (TransactionBean transactionBean1 : transList) {
			if(transactionBean1.getPhoneNo().equals(phoneNo)) {
				trans.add(transactionBean1);	
			
			}
				
		}
		return trans;
	}

}