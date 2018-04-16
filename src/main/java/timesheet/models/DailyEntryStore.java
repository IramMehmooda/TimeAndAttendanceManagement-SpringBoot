package timesheet.models;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DailyEntryStore extends CrudRepository<DailyEntry, Long>{
	public DailyEntry findById(Long id);
	//@Query("select t from timesheet t where user.user_id = ?1")
	List<DailyEntry> findByUser(User user); 
	Iterable<DailyEntry> findByProject(Project project);
}
