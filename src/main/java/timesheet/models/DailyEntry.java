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
	private Time fromtime;
	private Time totime;
	@ManyToOne
	Project project;
	double noofhours;
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="timesheet_id")
	Timesheet timesheet;
	
	public DailyEntry() {
		super();
	}

	public DailyEntry(Time fromtime, Time totime, Project project, double noofhours, Timesheet timesheet) {
		super();
		this.fromtime = fromtime;
		this.totime = totime;
		this.project = project;
		this.noofhours = noofhours;
		this.timesheet = timesheet;
	}

	@Override
	public String toString() {
		return "DailyEntry [id=" + id + ", fromtime=" + fromtime + ", totime=" + totime + ", project=" + project
				+ ", noofhours=" + noofhours + ", timesheet=" + timesheet + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getNoofhours() {
		return noofhours;
	}

	public void setNoofhours(double noofhours) {
		this.noofhours = noofhours;
	}

	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}

	

}
