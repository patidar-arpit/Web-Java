package pojos;

public class Course {
	
	private int course_id;
	private String name;
	private String short_form;
	private int duration;
	private int min_score;
	
	public Course(int course_id, String name, String short_form, int duration, int min_score) {
		super();
		this.course_id = course_id;
		this.name = name;
		this.short_form = short_form;
		this.duration = duration;
		this.min_score = min_score;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_form() {
		return short_form;
	}

	public void setShort_form(String short_form) {
		this.short_form = short_form;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getMin_score() {
		return min_score;
	}

	public void setMin_score(int min_score) {
		this.min_score = min_score;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", name=" + name + ", short_form=" + short_form + ", duration="
				+ duration + ", min_score=" + min_score + "]";
	}
	
	
	
	

}
