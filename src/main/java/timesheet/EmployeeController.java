package timesheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import timesheet.models.AdminStore;
import timesheet.models.Employee;
import timesheet.models.EmployeeStore;
import timesheet.models.Project;
import timesheet.models.ProjectStore;
import timesheet.models.Supervisor;
import timesheet.models.SupervisorStore;
import timesheet.models.TimesheetStore;
import timesheet.models.UserStore;

@Controller
@SessionAttributes({"User"})
@ComponentScan("timesheet.models")
public class EmployeeController {
	
	
	 @Autowired
	    UserStore userStore;
	    
	    @Autowired
	    EmployeeStore employeeStore;
	    
	    @Autowired
	    SupervisorStore supervisorStore;
	    
	    
	    @Autowired
	    AdminStore adminStore;
	    
	    @Autowired
	    ProjectStore projectStore;
	    
	    @Autowired
	    TimesheetStore timesheetStore;
	
	
	    @GetMapping("/maintainemployees")
	    public String showEmployeeRegister(Model model) {
	        if (model.asMap().containsKey("User")) {
	        	List<Employee> employees =  (List<Employee>) employeeStore.findAll();
	        	//System.out.println(employees);
	        	//List<Employee> employees = new ArrayList<Employee>();
	        	model.addAttribute("employees",employees);
	        	
	        	
	        	
	        	//model.addAttribute("supervisor", supervisor);
	        	
	            return "maintainemployees";
	        } else {
	        	
	            model.addAttribute("message", "Please login first");
	            return "home";
	        }
	    }
	    
	  /*  
	    @DeleteMapping("/deleteEmployee")
	    public void deleteEmployee(Model model, @RequestParam(value = "id") int userid) {
	    	 try {
	    		 employeeStore.deleteByUserid(userid);
	    	 }
	    	 catch(Exception e) {
	    		 System.out.println(e);
	    	 }
	    	
	    	
	    }*/
	    
	    
	    @RequestMapping(value="/maintainemployees", method=RequestMethod.DELETE)
		public void deleteEmployee(String username,Model model) {
	    		 employeeStore.deleteByUsername(username);
	    		 showEmployeeRegister(model);
	    		
			
		}
	    
	    /*@RequestMapping(value="/maintianemployees/edit/{username}")
	    public String edit(@PathVariable String username, Model model) {
	    	model.addAttribute("employee",employeeStore.findByUsername(username));
	    	return "register";
	    }
	
	*/
	

}
