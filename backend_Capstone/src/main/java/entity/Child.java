package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity 
@Table(name = "child")//table name-table details
public class Child {
	
	@Id//define primary key. 
	//@GeneratedValue is define primary key generation
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	//@column is defining names of columns for table fields
	@Column(name = "name")
	private String name; 
	@Column(name = "grade")
	private int grade;
	@Column(name = "avg")
	private double avg; 
	@Column(name = "subject")
	private String subject; 
	@Column(name = "tutoring")
	private String tutoring;
	
	//Many to Many relationship being defined.JPA annotation is used to link the source entity with the target entity. 
	//FetchType.LAZY is saying fetch (entities) when relationship used. 
	//CascadeType.ALL is updating and deleting entities. 
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	
	//Joining table JPA annotation for joining table with third table.
	@JoinTable(name = "child_parent",
		joinColumns = {@JoinColumn(name = "child_id")},
		inverseJoinColumns = {@JoinColumn (name = "parent_id")})
	// directional many to many mapping
	private Set<Parent> parents = new HashSet<>();
	
	public Child() {
		
	}
	
	public Child(String name, int grade, double avg, String subject, String tutoring) {
		super();
		this.name = name;
		this.grade = grade;
		this.avg = avg;
		this.subject = subject;
		this.tutoring = tutoring;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTutoring() {
		return tutoring;
	}
	public void setTutoring(String tutoring) {
		this.tutoring = tutoring;
	}
	public Set<Parent> getParents() {
		return parents;
	}
	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}
	
}
