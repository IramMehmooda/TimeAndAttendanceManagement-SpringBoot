package timesheet.models;



import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface TimesheetStore  extends CrudRepository<Timesheet, Long>{
	//public List<Timesheet> findAllTimesheet();
	public List<Timesheet> findByUser(User user);
	
	public List<Timesheet> findByUserAndStartdate(User user,Date startdate);
	
	public List<Timesheet> findByProject(Project project);


}
