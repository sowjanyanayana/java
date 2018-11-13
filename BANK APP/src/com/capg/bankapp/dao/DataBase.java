package com.capg.bankapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.capg.bankapp.bean.CustomerBean;



public class DataBase {
	
	
	private static List<CustomerBean> custList=new ArrayList<>();
	
	public static List<CustomerBean> getCustomerDetails(){
		
		CustomerBean bean1=new CustomerBean();
		bean1.setLastName("sowjanya");
		bean1.setLastName("nayana");
		bean1.setBalance(5000);
		bean1.setAge(21);
		bean1.setPhNo(9032974524L);
		bean1.setAdhar(245781121382L);
		custList.add(bean1);
		
		CustomerBean bean2=new CustomerBean();
		bean2.setLastName("silpa");
		bean2.setLastName("nayana");
		bean2.setBalance(5000);
		bean2.setAge(21);
		bean2.setPhNo(9032652514L);
		bean2.setAdhar(345781121382L);
		custList.add(bean2);
		
		return custList;
		
	}

	public static boolean validatePhnNo(Long PhoneNumber) {
		for (CustomerBean customerBean : custList) {
			if(customerBean.getPhNo().equals(PhoneNumber)) {
				return true;
			}
		}
		return false;
	}
}
