package timesheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import timesheet.models.AdminStore;
import timesheet.models.Employee;
import timesheet.models.EmployeeStore;
import timesheet.models.Project;
import timesheet.models.ProjectStore;
import timesheet.models.Supervisor;
import timesheet.models.SupervisorStore;
import timesheet.models.TimesheetStore;
import timesheet.models.User;
import timesheet.models.UserStore;
import timesheet.service.ProjectCreateRequest;

@Controller
@SessionAttributes({"User","Supervisor"})
@ComponentScan("timesheet.models")
@Transactional
public class ProjectController {
	
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
	
	    @GetMapping("/manageproject")
	    public String showManageProject(Model model) {
	        if (model.asMap().containsKey("User")) {
	        	
	        	User user = (User) model.asMap().get("User");
	        	
	        	
	        	Supervisor supervisor = supervisorStore.findByUsername(user.getUsername());
	        	
	        	List<Project> supprojects = projectStore.findBySupervisor(supervisor);
	        	//List<Project> supprojects = new ArrayList<Project>();
	        	 
	        	model.addAttribute("supprojects",supprojects);
	        	/*List<Employee> emplist = new ArrayList<Employee>();
	        	model.addAttribute(emplist);
	        	Project project = new Project();
	        	
	        	model.addAttribute(project);
	        	Supervisor supervisor = new Supervisor();
	        	model.addAttribute(supervisor);
	        	List<Supervisor> supervisors = (List<Supervisor>) supervisorStore.findAll();
	        	model.addAttribute("supervisors",supervisors);*/
	        	//model.addAttribute("supervisor", supervisor);
	        	
	            return "manageproject";
	        } else {
	        	
	            model.addAttribute("message", "Please login first");
	            return "home";
	        }
	    }
	    
	    
	    @RequestMapping(value="/manageproject", method=RequestMethod.DELETE)
		public void deleteproject(String emp,Model model) {
	    		 //employeeStore.deleteByUsername(username);
	    	User user = (User) model.asMap().get("User");
        	
        	
        	Supervisor supervisor = supervisorStore.findByUsername(user.getUsername());
        	
        	List<Project> supprojects = projectStore.findBySupervisor(supervisor);
        	
        	for(Project project : supprojects) {
        		
        		for(Employee employee :project.getEmplist()) {
        			System.out.println("this is employee in this project" + employee);
        			System.out.println("remove this employee"+employee.getUsername()+" with "+ emp);
        			if(employee.getUsername().equalsIgnoreCase(emp)) {
        				
        				project.getEmplist().remove(employee);
        			}
        		}
        		
        	}
	    	
	    		
	    		//System.out.println(pid + "Hi i am here");
	    		
	    		//projectStore.findBySupervisor(supervisor)
	    	
	    	     showManageProject(model);
	    		
			
		}
	   
	    
	    
	    
	    
	    @GetMapping("/maintainprojects")
	    public String showProjectRegister(Model model) {
	        if (model.asMap().containsKey("User")) {
	        	List<Project> projects =  (List<Project>) projectStore.findAll();
	        	model.addAttribute("projects",projects);
	        	return "maintainprojects";
	        } else {
	        	
	            model.addAttribute("message", "Please login first");
	            return "home";
	        }
	    }
	    @RequestMapping(value="/maintainprojects", method=RequestMethod.DELETE)
		public void deleteEmployee(String title,Model model) {
	    		 projectStore.deleteByTitle(title);
	    		 showProjectRegister(model);
	    		
			
		}
	 

}
