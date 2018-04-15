/**
 * 
 */
package timesheet.models;


import java.util.List;

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
	
	
	

}
