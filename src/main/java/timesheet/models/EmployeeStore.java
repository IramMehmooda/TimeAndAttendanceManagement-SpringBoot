package timesheet.models;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeeStore extends UserBaseStore<Employee>{
	

}
