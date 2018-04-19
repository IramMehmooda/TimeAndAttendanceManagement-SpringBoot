package timesheet.models;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name="timesheet")
public class Timesheet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long timesheet_id;
	
	@ManyToOne
	private User user;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private Date startdate;
	
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="hh:mm a")
	private Date fromtime;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="hh:mm a")
	private Date totime;
	
	@ManyToOne
	private Project project;
	
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

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public double getNoofhours() {
		return noofhours;
	}

	public void setNoofhours(double noofhours) {
		this.noofhours = noofhours;
	}

	@Override
	public String toString() {
		return "Timesheet [timesheet_id=" + timesheet_id + ", user=" + user + ", startdate=" + startdate + ", fromtime="
				+ fromtime + ", totime=" + totime + ", project=" + project + ", noofhours=" + noofhours + "]";
	}

	public Timesheet(long timesheet_id, User user, Date startdate, Date fromtime, Date totime, Project project,
			double noofhours) {
		super();
		this.timesheet_id = timesheet_id;
		this.user = user;
		this.startdate = startdate;
		this.fromtime = fromtime;
		this.totime = totime;
		this.project = project;
		this.noofhours = noofhours;
	}

	public Timesheet() {
		super();
	}
	
	

	
	
	
	/*
	SimpleDateFormat format=new SimpleDateFormat("HH:mm");
	Date d1;
	Date d2;
	
	{
	try {
	
	d1=format.parse(from_time);
	d2=format.parse(to_time);	
	hours=((d2.getTime()-d1.getTime())/(60*60*1000))%24;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}*/
	
	

	
	
	
	

}

