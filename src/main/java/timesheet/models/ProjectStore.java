/**
 * 
 */
package timesheet.models;


import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Owner
 *
 */
@Transactional
public interface ProjectStore extends CrudRepository<Project, Long>{
	
	Iterable<Project> findAll();
	
	public Project findByTitle(String title);
	
	//@Query("select p from Project p")
	//public List<Project> displayAll();
	
	
	//@Query("select p from Project p where p.user_id = ?1")
	public List<Project> findBySupervisor(Supervisor supervisor);
	
	
	

}
