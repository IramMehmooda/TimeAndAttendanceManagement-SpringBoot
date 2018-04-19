package timesheet.service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;



import timesheet.models.DailyEntry;
import timesheet.models.User;

public class TsCreateRequest {
	
	long timesheet_id;
	
	
	private User user;
	
	
	private Date startdate;
	
	private Date enddate;
	
	

	
	List<DailyEntry> entries;




	public Date getEnddate() {
		return enddate;
	}




	public void setEnddate(Date enddate) {
		this.enddate = enddate;
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




	public List<DailyEntry> getEntries() {
		return entries;
	}




	public void setEntries(List<DailyEntry> entries) {
		this.entries = entries;
	}



}
