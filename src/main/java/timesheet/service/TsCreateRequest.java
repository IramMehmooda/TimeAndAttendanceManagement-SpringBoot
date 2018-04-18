package timesheet.service;

import java.util.Date;
import java.util.List;


import timesheet.models.DailyEntry;
import timesheet.models.User;

public class TsCreateRequest {
long timesheet_id;
	
	
	private User user;
	
	
	private Date startdate;
	
	

	
	List<DailyEntry> entries;




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
