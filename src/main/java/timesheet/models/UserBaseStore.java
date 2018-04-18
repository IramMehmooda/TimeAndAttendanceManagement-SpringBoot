package timesheet.models;



import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.Query;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserBaseStore<T extends User> extends CrudRepository<T, Long>{
	
	List<T> findAll();
	public T findByUsername(String username);
	
	@Query("delete from User where user_id = ?1")
	public void deleteByUserid(int user_id);
	
	public void deleteByUsername(String username);
	
	
	
	

}
