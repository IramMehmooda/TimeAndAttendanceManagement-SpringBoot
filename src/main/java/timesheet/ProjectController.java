package timesheet;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	        	 
	        	model.addAttribute("supprojects",supprojects);
	        	
	        	
	        	
	        	
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
        			
        			if(employee.getUsername().equalsIgnoreCase(emp)) {
        				
        				project.getEmplist().remove(employee);
        			}
        		}
        		
        	}
	    	
	    		
	    		//System.out.println(pid + "Hi i am here");
	    		
	    		//projectStore.findBySupervisor(supervisor)
	    	
	    	     showManageProject(model);
	    		
			
		}
	   
	    @RequestMapping(value="/manageempproject", method=RequestMethod.GET)
		public void showEmployeesInProject(String title,Model model) {
	    		     	
        	 Project project = projectStore.findByTitle(title);
        	 model.addAttribute("project", project);
        	 System.out.println(project.getEmplist());
        	 List<Supervisor> supervisors = (List<Supervisor>) supervisorStore.findAll();
         	model.addAttribute("supervisors",supervisors);
        	
        	List<Employee> allemployees = employeeStore.findAll();
        			
        		
        		
        	
        	model.addAttribute("employees", allemployees);
	    		//System.out.println(pid + "Hi i am here");
	    		//projectStore.findBySupervisor(supervisor)
	    	     //showManageProject(model);
        	
			
		}
	    
	    @PostMapping("/manageempproject")
	    public String projectRegister(@ModelAttribute("project") ProjectCreateRequest project,@ModelAttribute("supervisor") String supervisorname,@ModelAttribute("emplist") String employees,Model model , BindingResult result) {
	    	if(!result.hasErrors()) {
	    		long budget = (long)project.getBudget();
	    		String title = project.getTitle();
	    		String customer = project.getCustomer();
	    		System.out.println(project.getCustomer());
	    		System.out.println(project.getSupervisorname());
	    		System.out.println(employees +"yes got it");
	    		Supervisor supervisor = supervisorStore.findByUsername(supervisorname);
	    		System.out.println(project.getEmplist() + "value of emplist");
	    		
	    		System.out.println(title+" hello");
	    		 Project p1 = projectStore.findByTitle(title);
	    		 
	    		// p1.setCustomer(project.getCustomer());
	    		 for(Employee useremp : project.getEmplist()) {
	    		 for(Employee emp : p1.getEmplist()) {
	    			 if(emp.getUser_id()==useremp.getUser_id())
	    				 project.getEmplist().remove(emp);
	    		 }
	    		 }
	    		 p1.getEmplist().addAll(project.getEmplist());
	    		 //p1.getEmplist().addAll(project.getEmplist());
	    		 
	    		 projectStore.save(p1);
	    		
	    		
	    		//projectStore.save(new Project(title,budget,customer,supervisor,null));
	    		//save project
	    	}
	    	return "redirect:/";
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
	    
	   /* @RequestMapping(value="/maintainprojects", method=RequestMethod.GET)
		public void show(String title,Model model) {
	    		     	
        	 Project project = projectStore.findByTitle(title);
        	 model.addAttribute("project", project);
        	 System.out.println(project.getEmplist());
        	 List<Supervisor> supervisors = (List<Supervisor>) supervisorStore.findAll();
         	model.addAttribute("supervisors",supervisors);
        	
        	List<Employee> allemployees = employeeStore.findAll();
        			
        		
        		
        	
        	model.addAttribute("employees", allemployees);
	    		//System.out.println(pid + "Hi i am here");
	    		//projectStore.findBySupervisor(supervisor)
	    	     //showManageProject(model);
        	
			
		}*/
	    
	    @PostMapping("/maintainprojects")
	    public String edit(@ModelAttribute("project") ProjectCreateRequest project,@ModelAttribute("supervisor") String supervisorname,@ModelAttribute("emplist") String employees,Model model , BindingResult result) {
	    	if(!result.hasErrors()) {
	    		long budget = (long)project.getBudget();
	    		String title = project.getTitle();
	    		String customer = project.getCustomer();
	    		System.out.println(project.getCustomer());
	    		System.out.println(project.getSupervisorname());
	    		System.out.println(employees +"yes got it");
	    		Supervisor supervisor = supervisorStore.findByUsername(supervisorname);
	    		System.out.println(project.getEmplist() + "value of emplist");
	    		
	    		System.out.println(title+" hello");
	    		 Project p1 = projectStore.findByTitle(title);
	    		 
	    		// p1.setCustomer(project.getCustomer());
	    		 for(Employee useremp : project.getEmplist()) {
	    		 for(Employee emp : p1.getEmplist()) {
	    			 if(emp.getUser_id()==useremp.getUser_id())
	    				 project.getEmplist().remove(emp);
	    		 }
	    		 }
	    		 p1.getEmplist().addAll(project.getEmplist());
	    		 //p1.getEmplist().addAll(project.getEmplist());
	    		 
	    		 projectStore.save(p1);
	    		
	    		
	    		//projectStore.save(new Project(title,budget,customer,supervisor,null));
	    		//save project
	    	}
	    	return "redirect:/";
	    }
	 

}
