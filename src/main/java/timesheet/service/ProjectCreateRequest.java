package timesheet.service;

import java.util.List;

import timesheet.models.Employee;
import timesheet.models.Supervisor;

public class ProjectCreateRequest{
	private String title;
	private int budget;
	private String customer;
	private Supervisor supervisorname;
	private List<Employee> emplist;
	
	
	public List<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Supervisor getSupervisorname() {
		return supervisorname;
	}
	public void setSupervisorname(Supervisor supervisorname) {
		this.supervisorname = supervisorname;
	}

	
}