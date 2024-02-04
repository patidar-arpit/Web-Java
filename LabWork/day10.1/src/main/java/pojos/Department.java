package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Department extends BaseEntity{
	
	@Column(length=20)
	private String name;
	@Column(length=20)
	
	
	
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}
