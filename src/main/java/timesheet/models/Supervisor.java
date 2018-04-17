package timesheet.models;

import java.util.Set;

import javax.persistence.*;




@Entity
//@Table(name="supervisor")
@DiscriminatorValue("supervisor")
public class Supervisor extends User{

	String fullname;
	
	@OneToMany(mappedBy = "supervisor" , cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Project> projects;
	
	

	public Supervisor() {
		super();
	}

	

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Supervisor(String username, String password,String fullname) {
		super(username, password);
		
		this.fullname=fullname;
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Supervisor [fullname=" + fullname + ", projects=" + projects + ", toString()=" + super.toString() + "]";
	}
	
	
	

	
	
}
