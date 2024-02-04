package pojos;

public class Student {
	
	private int id;
	private String firstName;
	private String lasrName;
	private String email;
	private int score;
	private int course_id;
	
	
	public Student(int id, String firstName, String lasrName, String email, int score, int course_id) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasrName = lasrName;
		this.email = email;
		this.score = score;
		this.course_id = course_id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lasrName=" + lasrName + ", email=" + email
				+ ", score=" + score + ", course_id=" + course_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasrName() {
		return lasrName;
	}
	public void setLasrName(String lasrName) {
		this.lasrName = lasrName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	
	

}
