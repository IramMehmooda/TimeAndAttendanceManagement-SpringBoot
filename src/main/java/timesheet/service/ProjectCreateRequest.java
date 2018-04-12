package timesheet.service;

import timesheet.models.Supervisor;

public class ProjectCreateRequest{
	private String title;
	private int budget;
	private String customer;
	private Supervisor supervisorname;
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