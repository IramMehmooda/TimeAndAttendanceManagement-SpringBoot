package timesheet.models;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name="dailyentry")
public class DailyEntry {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	@Temporal(TemporalType.TIME)
	
	private Date fromtime;
	
	
	@Temporal(TemporalType.TIME)
	private Date totime;
	
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="timesheet_id")
	Timesheet timesheet;
	
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
