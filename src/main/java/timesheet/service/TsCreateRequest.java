package timesheet.service;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Calendar;

import timesheet.models.Project;
import timesheet.models.User;

public class TsCreateRequest {
	
	long timesheet_id;
	
	
	private User user;
	
	
	private String startdate;
	


	private Date fromtime;

	private Date totime;

	String project;
	
	double noofhours;

	public long getTimesheet_id() {
		return timesheet_id;
	}

	public void setTimesheet_id(long timesheet_id) {
		this.timesheet_id = timesheet_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public Date getFromtime() {
		return fromtime;
	}

	public void setFromtime(Date fromtime) {
		this.fromtime = fromtime;
	}

	public Date getTotime() {
		return totime;
	}

	public void setTotime(Date totime) {
		this.totime = totime;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public double getNoofhours() {
		return noofhours;
	}

	public void setNoofhours(double noofhours) {
		this.noofhours = noofhours;
	}
	
	




}
