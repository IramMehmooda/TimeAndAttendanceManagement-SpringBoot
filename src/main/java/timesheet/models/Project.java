package timesheet.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="project")
public class Project {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	int project_id;
	
	String title;
	long budget;
	String customer;
	
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Supervisor supervisor;
	
	

	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "project_employee",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
	private List<Employee> emplist;



	public int getProject_id() {
		return project_id;
	}



	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public long getBudget() {
		return budget;
	}



	public void setBudget(long budget) {
		this.budget = budget;
	}



	public String getCustomer() {
		return customer;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}



	public Supervisor getSupervisor() {
		return supervisor;
	}



	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}



	public List<Employee> getEmplist() {
		return emplist;
	}



	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}



	public Project(String title, long budget, String customer, Supervisor supervisor, List<Employee> emplist) {
		super();
		this.title = title;
		this.budget = budget;
		this.customer = customer;
		this.supervisor = supervisor;
		this.emplist = emplist;
	}



	public Project() {
		super();
	}



	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", title=" + title + ", budget=" + budget + ", customer="
				+ customer + ", supervisor=" + supervisor + ", emplist=" + emplist + "]";
	}
	
	
	
	

	
}

	
	