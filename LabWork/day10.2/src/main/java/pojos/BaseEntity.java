package pojos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	
	@Id  // if we not specify this annotation than the( No identifier specified for entity: pojos.Employee) error will come
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	 private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
