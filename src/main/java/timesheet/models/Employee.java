package timesheet.models;

import java.util.Set;

import javax.persistence.*;



@Entity
//@Table(name="Employee")
@DiscriminatorValue("employee")
public class Employee extends User{
    
    //String user_type;
    String fullname;
    String address;
    String email;
    long phone_no;
    String job_title;
    int salary;
    long SSN;
    
    @ManyToMany(mappedBy = "emplist")
    private Set<Project> project;

	public Employee(String fullname, String address, String email, long phone_no, String job_title, int salary,
			long sSN) {
		super();
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.phone_no = phone_no;
		this.job_title = job_title;
		this.salary = salary;
		SSN = sSN;
	}

	public Employee(String username, String password,String fullname, String address, String email, long phone_no, String job_title, int salary,
			long sSN) {
		super(username, password);
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.phone_no = phone_no;
		this.job_title = job_title;
		this.salary = salary;
		SSN = sSN;
		
		// TODO Auto-generated constructor stub
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public long getSSN() {
		return SSN;
	}

	public void setSSN(long sSN) {
		SSN = sSN;
	}

	public Set<Project> getProject() {
		return project;
	}

	public void setProject(Set<Project> project) {
		this.project = project;
	}
	
    
    
    
	

	    
}
