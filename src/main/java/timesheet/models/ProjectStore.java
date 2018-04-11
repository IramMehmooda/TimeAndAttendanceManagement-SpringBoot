/**
 * 
 */
package timesheet.models;


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
