package timesheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
import timesheet.models.User;
import timesheet.models.UserStore;
import timesheet.service.EmployeeCreateReq;
import timesheet.service.ProjectCreateRequest;

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
	    
	   /* @PostMapping("/editemployee")
	    public String processeditingEmployee(@ModelAttribute("employee")  Employee employee,Model model, BindingResult result) {
	    	try {
	    		
	    		System.out.println(employee);
	    		
	    		//Employee employee1= employeeStore.findByUsername(userName);
	    		System.out.println("Employee is inside post mapping");
	    		 if (user != null) {
	                model.addAttribute("message", "Username already available, please try other username");
	                return "register";
	            } else {
	            //new Employee(userName, password,fullName, address, email, phone_no, job_title, salary, sSN)
	            	
	            		 userStore.save(employee);
	                     model.addAttribute("message", "Employee : " + employee + "modified");
	                    // userStore.save(new Admin(userName, password, fullName));
	            	
	            	
	            		
	            	return "maintainemployee";
	            
	    		
	    	}catch(Exception ex) {
	    		return "user not found"+ex.getMessage();
	    	}
	        
	    }*/
	    
	    
	    @PostMapping("/editemployee")
	    public String editEmployeeregister(@ModelAttribute("employee") EmployeeCreateReq employee,Model model , BindingResult result) {
	    	if(!result.hasErrors()) {
	    		
	    		System.out.println(employee.toString());
	    		Employee employeesave = new Employee();
	    		employeeStore.save(employeesave);
	    		
	    		/*long budget = (long)project.getBudget();
	    		String title = project.getTitle();
	    		String customer = project.getCustomer();
	    		
	    		Supervisor supervisor = supervisorStore.findByUsername(supervisorname);
	    	
	    		
	    		
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
	    		 
	    		 projectStore.save(p1);*/
	    		
	    		
	    		//projectStore.save(new Project(title,budget,customer,supervisor,null));
	    		//save project
	    	}
	    	return "home";
	    }
	   


	    
	    @GetMapping(value="/editemployee/{username}")
	    public String editEmployee(@PathVariable("username") String username , Model model) {
	    	System.out.println(username);
	    	
	    	Employee employee=employeeStore.findByUsername(username);
	    	model.addAttribute("employee", employee);
	    	return "editemployee";
	    }
	    
	    
	    
	    
	    /*@RequestMapping(value="/maintianemployees/edit/{username}")
	    public String edit(@PathVariable String username, Model model) {
	    	model.addAttribute("employee",employeeStore.findByUsername(username));
	    	return "register";
	    }
	
	*/
	

}
