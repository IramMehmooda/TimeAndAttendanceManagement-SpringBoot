package timesheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
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
@SessionAttributes({"User","Supervisor","Employee","Project"})
@ComponentScan("timesheet.models")
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
	    public String showEmployeeRegister(Model model) {
	        if (model.asMap().containsKey("User")) {
	        	User user = (User) model.asMap().get("User");
	        	
	        	System.out.println(user + "yes i got this user");
	        	Supervisor supervisor = supervisorStore.findByUsername(user.getUsername());
	        	List<Project> supprojects = projectStore.findBySupervisor(supervisor);
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
	    
	    
	    @RequestMapping(value="/manageproject", method=RequestMethod.DELETE)
		public void deleteEmployee(String username,Model model) {
	    		 employeeStore.deleteByUsername(username);
	    		 showEmployeeRegister(model);
	    		
			
		}
	    
	    /*@RequestMapping(value="/maintianemployees/edit/{username}")
	    public String edit(@PathVariable String username, Model model) {
	    	model.addAttribute("employee",employeeStore.findByUsername(username));
	    	return "register";
	    }*/
	    
	   /* @GetMapping("/projectregister")
//	    @RequestParam(value="supervisorname", defaultValue="0")String supervisorname
	    public String showProjectRegister(Model model) {
	        if (model.asMap().containsKey("User")) {
	        	List<Employee> employees =  (List<Employee>) employeeStore.findAll();
	        	System.out.println(employees);
	        	model.addAttribute("employees",employees);
	        	List<Employee> emplist = new ArrayList<Employee>();
	        	model.addAttribute(emplist);
	        	Project project = new Project();
	        	
	        	model.addAttribute(project);
	        	Supervisor supervisor = new Supervisor();
	        	model.addAttribute(supervisor);
	        	List<Supervisor> supervisors = (List<Supervisor>) supervisorStore.findAll();
	        	model.addAttribute("supervisors",supervisors);
	        	//model.addAttribute("supervisor", supervisor);
	        	
	            return "projectregister";
	        } else {
	        	
	            model.addAttribute("message", "Please login first");
	            return "home";
	        }
	    }
	    
	    @PostMapping("/projectregister")
	    public String projectRegister(@ModelAttribute("project") ProjectCreateRequest project,@ModelAttribute("supervisor") String supervisorname,@ModelAttribute("emplist") String employees,Model model , BindingResult result) {
	    	if(!result.hasErrors()) {
	    		long budget = (long)project.getBudget();
	    		String title = project.getTitle();
	    		String customer = project.getCustomer();
	    		System.out.println(project.getCustomer());
	    		System.out.println(project.getSupervisorname());
	    		System.out.println(employees +"yes got it");
	    		Supervisor supervisor = supervisorStore.findByUsername(supervisorname);
	    		
	    		projectStore.save(new Project(title,budget,customer,supervisor,null));
	    		//save project
	    	}
	    	return "redirect:/";
	    }
	*/
	

}
