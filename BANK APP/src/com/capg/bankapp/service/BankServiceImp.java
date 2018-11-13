package com.capg.bankapp.service;

import java.util.List;

import com.capg.bankapp.bean.CustomerBean;
import com.capg.bankapp.bean.TransactionBean;
import com.capg.bankapp.dao.BankDAOImp;
import com.capg.bankapp.dao.IBankDAO;
import com.capg.bankapp.exception.ExceptionMessage;

public class BankServiceImp implements IBankService {

	IBankDAO dao = new BankDAOImp();

	@Override
	public boolean addCustomer(CustomerBean customerBean) {
		// TODO Auto-generated method stub
		return dao.addCustomer(customerBean);
	}

	@Override
	public boolean deposit(CustomerBean customerBean, double depositAmount, Long phoneNo) {
		return dao.deposit(customerBean, depositAmount, phoneNo);
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validations(CustomerBean customerBean) throws Exception {
		boolean check = true;
		Long adhar = customerBean.getAdhar();
		Long phoneNo = customerBean.getPhNo();

		if (!(customerBean.getFirstName().length() >= 4) && !(customerBean.getLastName().length() >= 4)) {
			throw new Exception(ExceptionMessage.ERROR1);
		} else if (customerBean.getFirstName() == null && customerBean.getLastName() == null) {
			throw new Exception(ExceptionMessage.ERROR2);
		}
		if (!(customerBean.getFirstName().matches("[A-Za-z]{4,20}"))
				&& !(customerBean.getLastName().matches("[A-Za-z]{4,20}"))) {
			throw new Exception(ExceptionMessage.ERROR10);
		}
		if (!(customerBean.getAge() >= 18) || !(customerBean.getAge() <= 100)) {
			throw new Exception(ExceptionMessage.ERROR3);
		}

		if (!(phoneNo.toString().length() == 10) && !(phoneNo.toString().matches("[6-9]{1}[0-9]{9}"))) {
			throw new Exception(ExceptionMessage.ERROR6);
		} else if (phoneNo.toString() == null) {
			throw new Exception(ExceptionMessage.ERROR7);
		}
		if (!(adhar.toString().length() == 12) && !(adhar.toString().matches("[1-9][0-9]{11}"))) {
			throw new Exception(ExceptionMessage.ERROR4);
		} else if (adhar.toString() == null) {
			throw new Exception(ExceptionMessage.ERROR5);
		}

		return check;

	}

	@Override
	public boolean withDraw(CustomerBean customerBean, double withDrawAmount, Long phoneNo) {
		return dao.withDraw(customerBean, withDrawAmount, phoneNo);
	}

	@Override
	public double showBalance(CustomerBean customerBean, Long phoneNo) {
		return dao.showBalance(customerBean, phoneNo);
	}

	@Override
	public boolean fundTransfer(CustomerBean customerBean, Long senderPhoneNumber, Long recievePhoneNumber,
			double transferAmount) {
		return dao.fundTransfer(customerBean, senderPhoneNumber, recievePhoneNumber, transferAmount);
	}

	@Override
	public List<TransactionBean> transactions(Long phoneNo) {
		// TODO Auto-generated method stub
		return dao.transactions(phoneNo);
	}

}
