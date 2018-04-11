package timesheet.models;



//import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserBaseStore<T extends User> extends CrudRepository<T, Long>{
	
	Iterable<T> findAll();
	public T findByUsername(String username);
	
	
	

}
