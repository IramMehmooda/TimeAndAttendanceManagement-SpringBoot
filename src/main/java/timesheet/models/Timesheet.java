package timesheet.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="timesheet")
public class Timesheet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	int timesheet_id;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	String from_time;
	String to_time;
	long hours;
	
	@Temporal (TemporalType.DATE)
	Date date;
	
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
	}
	
	public Timesheet(User user, Project project, Date date, String from_time, String to_time) {
		super();
		this.user = user;
		this.project = project;
		this.date = date;
		this.from_time = from_time;
		this.to_time = to_time;
	}
	
	public int getTimesheet_id() {
		return timesheet_id;
	}
	
	public void setTimesheet_id(int timesheet_id) {
		this.timesheet_id = timesheet_id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User employee) {
		this.user = employee;
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFrom_time() {
		return from_time;
	}

	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}

	public String getTo_time() {
		return to_time;
	}

	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}

	public long getHours() {
		return hours;
	}

	public void setHours(long hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Timesheet [timesheet_id=" + timesheet_id + ", user=" + user + ", project=" + project + ", from_time="
				+ from_time + ", to_time=" + to_time + ", hours=" + hours + ", date=" + date + "]";
	}

	
	
	
	

}

