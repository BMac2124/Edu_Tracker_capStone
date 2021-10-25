package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "parent" )
public class Parent {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id; 
	private String name; 
	private String role; 
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parents")
	private Set<child> children = new HashSet<>();
	
	public Parent() {
		
	}
	
	public Parent(String name, String role, Set<child> children) {
		super();
		this.name = name;
		this.role = role;
	
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<child> getChildren() {
		return children;
	}
	public void setChildren(Set<child> children) {
		this.children = children;
	}
	
}
