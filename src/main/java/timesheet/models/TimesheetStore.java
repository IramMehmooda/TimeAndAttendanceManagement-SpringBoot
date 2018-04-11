package timesheet.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface TimesheetStore  extends CrudRepository<Timesheet, Long>{
	//public List<Timesheet> findAllTimesheet();
	public Timesheet findByEmployee(Employee employee);
	public Timesheet findByProject(Project project);

}
