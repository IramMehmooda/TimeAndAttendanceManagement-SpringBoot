package timesheet.service;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import timesheet.models.Project;
import timesheet.models.Timesheet;

public class EmployeeCreateReq {
	
	
	 String fullname;
	    String address;
	    String email;
	    long phone_no;
	    String job_title;
	    int salary;
	    long SSN;
	    
	    private long user_id;
	    private String username;
	
		private String password;
		
		
		private List<Timesheet> timesheets;
	    private List<Project> project;
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
		public long getUser_id() {
			return user_id;
		}
		public void setUser_id(long user_id) {
			this.user_id = user_id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public List<Timesheet> getTimesheets() {
			return timesheets;
		}
		public void setTimesheets(List<Timesheet> timesheets) {
			this.timesheets = timesheets;
		}
		public List<Project> getProject() {
			return project;
		}
		public void setProject(List<Project> project) {
			this.project = project;
		}
		@Override
		public String toString() {
			return "EmployeeCreateReq [fullname=" + fullname + ", address=" + address + ", email=" + email
					+ ", phone_no=" + phone_no + ", job_title=" + job_title + ", salary=" + salary + ", SSN=" + SSN
					+ ", user_id=" + user_id + ", username=" + username + ", password=" + password + ", timesheets="
					+ timesheets + ", project=" + project + "]";
		}
	    
	    
	    

}
