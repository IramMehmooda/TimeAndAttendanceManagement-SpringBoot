package timesheet.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="user")
@Inheritance
@DiscriminatorColumn(name="user_type")
public abstract class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long user_id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	
	@OneToMany(mappedBy = "user" , cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Timesheet> timesheets;

	public User() {
		super();
	}
	
	
	/*public List<Timesheet> getTimesheets() {
		return timesheets;
	}


	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
*/

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}


	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}


	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

	    return val == null ? null : val.value();
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
