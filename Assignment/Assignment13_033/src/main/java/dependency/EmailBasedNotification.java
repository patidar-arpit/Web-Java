package dependency;

public class EmailBasedNotification implements CustomerNotificationService{

	public EmailBasedNotification() {
		System.out.println("Inside the Email based Notifictaion");
	}
	@Override
	public void alertCustomer(String mesg) {
		
		System.out.println(mesg);
		
	}

}
