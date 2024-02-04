package dependent;

import dependency.CustomerNotificationService;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private double cash;
	private CustomerNotificationService notification;
	

	private ATMImpl(double  money) {
		this.cash =money;
		System.out.println("in cnstr of " + getClass().getName() + " " + cash);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling dependency's method to inform the bank
	    notification.alertCustomer(amt+"Deposited"+" using "+notification);
	}

	public Transport getMyTransport() {
		return myTransport;
	}

	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
		notification.alertCustomer(amt+"Withdrawnn");
	}

	// custom init method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

	public CustomerNotificationService getNotification() {
		return notification;
	}
	
	public void setNotification(CustomerNotificationService notification) {
		this.notification = notification;
	}
	
	
}
