package dependency;

public class SmsBasedNotification implements CustomerNotificationService{
	
	public SmsBasedNotification() {
		System.out.println("Inside the smsBased Notification");
	}

	@Override
	public void alertCustomer(String mesg) {
		System.out.println(mesg);
		
	}

}
