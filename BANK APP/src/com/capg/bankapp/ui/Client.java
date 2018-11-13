package com.capg.bankapp.ui;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.capg.bankapp.bean.CustomerBean;
import com.capg.bankapp.bean.TransactionBean;
import com.capg.bankapp.service.BankServiceImp;
import com.capg.bankapp.service.IBankService;

public class Client {

	static Scanner scanner = new Scanner(System.in);
	static IBankService service = new BankServiceImp();
	static CustomerBean customerBean = new CustomerBean();
	static TransactionBean transactionBean= new TransactionBean();

	public static void main(String[] args) throws Exception {

		while (true) {

			System.out.println("*****XYZ BANK******");
			System.out.println(
					"1.create Account\n2.Deposit\n3.WithDraw\n4.FundTransfer\n5.ShowBalance\n6.printtransactions");
			System.out.print("enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addCustomer(customerBean);
				break;
			case 2:
				Deposit(customerBean);
				break;

			case 3:
				withDraw(customerBean);
				break;

			case 4:
				fundTransfer(customerBean);
				break;

			case 5:
				showBalance();
				break;

			case 6:
				transactions(transactionBean);
				break;

			case 7:
				System.out.println("thankyou visit again");
				System.exit(0);
				break;

			}
		}

	}

	public static void addCustomer(CustomerBean customerBean) throws Exception {

		System.out.print("\t\tenter your first name\t\t:");
		String firstName = scanner.next();
		customerBean.setFirstName(firstName);

		System.out.print("\t\tenter your last name\t\t:");
		String lastName = scanner.next();
		customerBean.setLastName(lastName);

		System.out.print("\t\tenter your age\t\t\t:");
		int age = scanner.nextInt();
		customerBean.setAge(age);

		System.out.print("\t\tenter your 12 digit adhar no.\t\t :");
		long adhar = scanner.nextLong();
		customerBean.setAdhar(adhar);

		Date date = new Date();
		customerBean.setDate(date);

		System.out.print("\t\tenter your 10 digit phone number\t\t");
		Long phoneNo = scanner.nextLong();
		customerBean.setPhNo(phoneNo);
		transactionBean.setPhoneNo(phoneNo);

		System.out.print("\t\tenter opening balance\t\t");
		Double balance = scanner.nextDouble();
		customerBean.setBalance(balance);

		try {
			if (service.validations(customerBean)) {

				if (service.addCustomer(customerBean)) {

					System.out.println("\n\n\t\tcreated successfully\n\n\t\t");

				} else {
					System.out.println("not created");
				}
			}
		} catch (Exception e) {

			System.out.println("enter details correctly");
			System.out.println(e.getMessage());
		}

	}

	public static void Deposit(CustomerBean bankBean) throws Exception {

		System.out.println("enter phone number");
		Long phoneNo = scanner.nextLong();
		System.out.println("enter money to deposit");
		double depositAmount = scanner.nextDouble();

		if (service.deposit(bankBean, depositAmount, phoneNo)) {
			System.out.println("deposited");
		} else {
			System.out.println("not deposited");
		}

	}

	public static void withDraw(CustomerBean bankBean) throws Exception {

		System.out.println("enter phone number");
		Long phoneNo = scanner.nextLong();
		System.out.println("enter money to withdraw");
		double withDrawAmount = scanner.nextDouble();

		if (service.withDraw(bankBean, withDrawAmount, phoneNo)) {
			System.out.println("withdrrawn");
		} else {
			System.out.println("not withdrrawn");
		}

	}

	public static void showBalance() {

		System.out.println("enter phone number");
		Long phoneNo = scanner.nextLong();
		double balance = service.showBalance(customerBean, phoneNo);
		System.out.println("balance=" + balance);

	}

	public static void fundTransfer(CustomerBean customerBean) {

		System.out.println("enter your phone num");
		Long senderPhoneNumber = scanner.nextLong();

		System.out.println("enter reciever phone num");
		Long recievePhoneNumber = scanner.nextLong();

		System.out.println("enter amount to transferr");
		double transferAmount = scanner.nextDouble();

		boolean b = service.fundTransfer(customerBean, senderPhoneNumber, recievePhoneNumber, transferAmount);
		if (b) {
			System.out.println("transfered");
		} else {
			System.out.println("not transfered");
		}

	}
	public static void transactions(TransactionBean transactionBean) {
		
		System.out.println("enter phone number");
		Long phoneNo = scanner.nextLong();
		List<TransactionBean> transactionBean2=service.transactions(phoneNo);
		//for (TransactionBean transactionBean3 : transactionBean2) {
		if(transactionBean2!=null)
			System.out.println(transactionBean2);
		}
	
		
	}

