package timesheet.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserBaseStore<T extends User> extends CrudRepository<T, Long>{
	
	public List<T> findAllUser();
	public T findByUsername(String username);
	

}
