package timesheet.models;

import java.util.List;
import java.util.Set;

import javax.persistence.*;




@Entity
//@Table(name="supervisor")
@DiscriminatorValue("supervisor")
public class Supervisor extends User{

	String fullname;
	
	@OneToMany(mappedBy = "supervisor" )
	private List<Project> projects;
	
	

	public Supervisor() {
		super();
	}

	

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Supervisor(String username, String password,String fullname) {
		super(username, password);
		
		this.fullname=fullname;
		// TODO Auto-generated constructor stub
	}
	
	



	public Supervisor(String username, String password,String fullname, List<Project> projects) {
		super(username, password);
		this.fullname = fullname;
		this.projects = projects;
	}



	@Override
	public String toString() {
		return "Supervisor [fullname=" + fullname + ", projects=" + projects + ", toString()=" + super.toString() + "]";
	}
	
	
	

	
	
}
