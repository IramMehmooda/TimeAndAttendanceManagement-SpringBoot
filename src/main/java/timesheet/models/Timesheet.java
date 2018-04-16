package timesheet.models;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
@Table(name="timesheet")
public class Timesheet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long timesheet_id;
	
	@OneToOne
	private User user;
	
	@Temporal(TemporalType.DATE)
	private Date startdate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<DailyEntry> entries;



	public Timesheet() {
		super();
	}



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



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public List<DailyEntry> getEntries() {
		return entries;
	}



	public void setEntries(List<DailyEntry> entries) {
		this.entries = entries;
	}



	public Timesheet(User user, Date startdate, Date endDate, List<DailyEntry> entries) {
		super();
		this.user = user;
		this.startdate = startdate;
		this.endDate = endDate;
		this.entries = entries;
	}



	@Override
	public String toString() {
		return "Timesheet [timesheet_id=" + timesheet_id + ", user=" + user + ", startdate=" + startdate + ", endDate="
				+ endDate + ", entries=" + entries + "]";
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

