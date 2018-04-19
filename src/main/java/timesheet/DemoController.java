package timesheet;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


import timesheet.models.Admin;
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
public class DemoController {

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
    
    
    

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/content")
    public String content(Model model) {
        if (model.asMap().containsKey(("User"))) {
            return "content";
        } else {
            return "home";
        }
    }

/*    @RequestMapping("/projectregister")
    public String projectregister(Model model) {
        if (model.asMap().containsKey(("User"))) {
        	System.out.println("This loop is working" + model.asMap());
            return "content";
        } else {
            return "home";
        }
    }
*/
  
    ///////////////////////////////////////////////////////////////////
    
    
    
    @ModelAttribute("allemployees")
    public List<Employee> populateEmployees() {
        return  (List<Employee>) this.employeeStore.findAll();
    }
    
 /*   
    @ModelAttribute("allSeedStarters")
    public List<Project> populateSeedStarters() {
        return this.seedStarterService.findAll();
    }
    
   */ 
  
    
    
    
    @RequestMapping(value="/projectregister", params={"save"})
    public String saveSeedstarter(final Project project, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "projectregister";
        }
        this.projectStore.save(project);
        model.clear();
        return "redirect:/content";
    }
    


    
    
    ////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    @PostMapping("/login")
    public String processLogin(@RequestParam(value = "username") String userName,
                               @RequestParam(value = "password") String password,
                               Model model) {
    	
    	String userId ="";
    	String userType = "";
    	try {
    		User user = userStore.findByUsername(userName);
    		
            
            if (user != null) {
            	userId = String.valueOf(user.getUser_id());
            	if(user instanceof Admin)
            		userType = "Admin";
            	else if (user instanceof Employee)
            		userType = "Employee";
            	else if (user instanceof Supervisor)
            		userType = "Supervisor";
            	
                model.addAttribute("message", user.getUsername() + ": welcome back !" + "\n You have logged in as "+userType );
                model.addAttribute("User", user);
                return "content";
            } else {
                model.addAttribute("message", "Username/password not found");
                return "login";
            }
    		
    	}
    	catch(Exception ex) {
    		return "user not found"+ex.getMessage();
    	}
        
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    
    @PostMapping("/supervisorregister")
    public String processSupervisorRegister(@RequestParam(value = "fullname") String fullName,
            @RequestParam(value = "username") String userName,
            @RequestParam(value = "password") String password,
            Model model) {
    	try {
    		User user = userStore.findByUsername(userName);
            if (user != null) {
                model.addAttribute("message", "Username already taken");
                return "supervisorregister";
            } else {
//            	String type = "supervisor";
//            	if(user_type.equalsIgnoreCase(type)) {
            		 userStore.save(new Supervisor(userName, password, fullName));
                     model.addAttribute("message", "New Supervisor Added: " + userName);
                     
//            	}
//            	else {
//            		System.out.println(user_type +"and " + model);
//            		userStore.save(new Admin(userName, password, fullName));
//            	}
            	return "home";
            }
    		
    	}catch(Exception ex) {
    		return "user not found"+ex.getMessage();
    	}
    }

    
    @PostMapping("/register")
    public String processRegister(@RequestParam(value = "fullname") String fullName,
                                  @RequestParam(value = "username") String userName,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value= "address") String address,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="phoneno") long phone_no,
                                  @RequestParam(value="jobtitle") String job_title,
                                  @RequestParam(value="salary") int salary,
                                  @RequestParam(value="sSn") long sSN,
                                  //@RequestParam(value="user_type") String user_type,
                                  Model model) {
    	try {
    		User user = userStore.findByUsername(userName);
            if (user != null) {
                model.addAttribute("message", "Username already available, please try other username");
                return "register";
            } else {
            	
            		 userStore.save(new Employee(userName, password,fullName, address, email, phone_no, job_title, salary, sSN));
                     model.addAttribute("message", "New Employee Added: " + userName);
                    // userStore.save(new Admin(userName, password, fullName));
            	
            	
            		
            	return "content";
            }
    		
    	}catch(Exception ex) {
    		return "user not found"+ex.getMessage();
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


    @GetMapping("/register")
    public String showRegister(Model model) {
        if (model.asMap().containsKey("User")) {
            return "register";
        } else {
        	
            model.addAttribute("message", "Please login first"+model.asMap());
            return "home";
        }
    }
    
    
    @GetMapping("/supervisorregister")
    public String showSupervisorRegister(Model model) {
        if (model.asMap().containsKey("User")) {
            return "supervisorregister";
        } else {
        	
            model.addAttribute("message", "Please login first");
            return "home";
        }
    }
    
    @GetMapping("/projectregister")
//    @RequestParam(value="supervisorname", defaultValue="0")String supervisorname
    public String showProjectRegister(Model model) {
        if (model.asMap().containsKey("User")) {
        	
        	
        	/*List<Employee> employees =  (List<Employee>) employeeStore.findAll();
        	System.out.println(employees);
        	model.addAttribute("employees",employees);
        	List<Employee> emplist = new ArrayList<Employee>();
        	model.addAttribute(emplist);*/
        	//System.out.println("Yes i got the output cool");
        	
        	
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
    
    
    @RequestMapping("/logout")
    public String logout(Model model, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        model.addAttribute("message", "You have been logged out");
        model.addAttribute("User", null);
        return "home";
    }

}
