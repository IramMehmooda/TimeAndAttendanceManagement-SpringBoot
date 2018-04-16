package timesheet.models;

import java.sql.Time;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



public class DailyEntry {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	
	@Temporal(TemporalType.TIME)
	Time fromtime;
	
	
	@Temporal(TemporalType.TIME)
	Time totime;
	
	
	
	@ManyToOne
	Project project;
	
	
	@ManyToOne
	User user;
	
	double noofhours;
	
	
	


	public DailyEntry() {
		super();
	}

	@Override
	public String toString() {
		return "DailyEntry [id=" + id + ", date=" + date + ", fromtime=" + fromtime + ", totime=" + totime
				+ ", project=" + project + ", user=" + user + ", noofhours=" + noofhours + "]";
	}

	public DailyEntry(Date date, Time fromtime, Time totime, Project project, User user, double noofhours) {
		super();
		this.date = date;
		this.fromtime = fromtime;
		this.totime = totime;
		this.project = project;
		this.user = user;
		this.noofhours = noofhours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getFromtime() {
		return fromtime;
	}

	public void setFromtime(Time fromtime) {
		this.fromtime = fromtime;
	}

	public Time getTotime() {
		return totime;
	}

	public void setTotime(Time totime) {
		this.totime = totime;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getNoofhours() {
		return noofhours;
	}

	public void setNoofhours(double noofhours) {
		this.noofhours = noofhours;
	}
	
	
	
	

}
