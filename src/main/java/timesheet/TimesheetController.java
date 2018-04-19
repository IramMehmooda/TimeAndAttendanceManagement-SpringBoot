package timesheet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import timesheet.Utils;
import timesheet.models.DailyEntry;
import timesheet.models.DailyEntryStore;
import timesheet.models.Employee;
import timesheet.models.EmployeeStore;
import timesheet.models.Project;
import timesheet.models.ProjectStore;
import timesheet.models.Supervisor;
import timesheet.models.SupervisorStore;
import timesheet.models.Timesheet;
import timesheet.models.TimesheetStore;
import timesheet.models.User;
import timesheet.models.UserStore;
import timesheet.service.DailyEntryCreateRequest;
import timesheet.service.ProjectCreateRequest;
import timesheet.service.TsCreateRequest;

@Controller
@SessionAttributes({"User","Project","Timesheet"})
@ComponentScan("timesheet.models")
public class TimesheetController {
	
	@Autowired
	TimesheetStore timesheetStore;
	
	@Autowired
	UserStore userStore;
	
	@Autowired
	EmployeeStore employeeStore;
	
	@Autowired
	ProjectStore projectStore;
	
	@Autowired
	SupervisorStore supervisorStore;
	

    @Autowired
    DailyEntryStore dailyEntryStore;
	
	
	
	
    @GetMapping(value="/createtimesheet")
    public String addTimeSheetForm(Model model) {
    	 if (model.asMap().containsKey("User")) {
    		
 	        	
 	        	User user = (User) model.asMap().get("User");
 	        	
 	        	System.out.println(model.asMap().get("User") + "yes i got this user");
 	        	System.out.println(user.getUsername());
 	        	User user1 = userStore.findByUsername(user.getUsername());
 	        	
 	        	if(user1.getDiscriminatorValue().equalsIgnoreCase("employee")) {
 	        		Employee employee=employeeStore.findByUsername(user.getUsername());
 	        		List<Project> empprojects =employee.getProject();
 	        		System.out.println("I am an employee");
 	        		model.addAttribute("employee",employee);
 	        		model.addAttribute("empprojects",empprojects);
 	        	}
 	        	else if(user1.getDiscriminatorValue().equalsIgnoreCase("supervisor")) {
 	        		Supervisor supervisor = supervisorStore.findByUsername(user.getUsername());
 	        		List<Project> empprojects = projectStore.findBySupervisor(supervisor);
 	        		model.addAttribute("employee",supervisor);
 	        		model.addAttribute("empprojects",empprojects);
 	        	}
 	        	model.addAttribute("dailyentry", new DailyEntry());
 	        	model.addAttribute("timesheet", new Timesheet());
 	        	
 	        	
    		 return "createtimesheet";
    	 }
    	 else {
    	      	
             model.addAttribute("message", "Please login first");
             return "home";
         }
    }
    
    
    @PostMapping("/createtimesheet")
    public String createTimesheet(@ModelAttribute("timesheet") TsCreateRequest timesheet ,@ModelAttribute("dailyentry") DailyEntryCreateRequest dailyentry , Model model, BindingResult result) {
    	
    	if(!result.hasErrors()) {
    		if(dailyentry == null) {
    		User user = (User) model.asMap().get("User");
    		//Employee employee = employeeStore.findByUsername(user.getUsername());
    		Date date=timesheet.getStartdate();
    		System.out.println(date);
    		System.out.println(timesheet.getStartdate());
    		Timesheet ts1 = new Timesheet();
    		ts1.setStartdate(timesheet.getStartdate());
    		ts1.setUser(user);
    		System.out.println(timesheetStore.save(ts1));
    		}
    		else {
    			User user = (User) model.asMap().get("User");
        		//Employee employee = employeeStore.findByUsername(user.getUsername());
        		Date date=timesheet.getStartdate();
        		System.out.println(date);
        		System.out.println(timesheet.getStartdate());
        		System.out.println("in the daily entries" + dailyentry.getFromtime() + "asdf   " + dailyentry.getTotime());
        		System.out.println(dailyentry.getProject());
        		Timesheet timesheet1 = timesheetStore.findByUser(user);
        		DailyEntry de = new DailyEntry();
        		de.setFromtime(dailyentry.getFromtime());
        		de.setTimesheet(timesheet1);
        		de.setTotime(dailyentry.getTotime());
        		de.setProject(dailyentry.getProject());
        		dailyEntryStore.save(de);
        		model.addAttribute("dailyentry", null);
    		}
   	}
    	return "/createtimesheet";
    
    }
    
  /*  @PostMapping("/createtimesheet")
    public String createentries(@ModelAttribute("timesheet") TsCreateRequest timesheet,@ModelAttribute("dailyentry") DailyEntryCreateRequest dailyentry , Model model, BindingResult result) {
    	
    	if(!result.hasErrors()) {
    		User user = (User) model.asMap().get("User");
    		//Employee employee = employeeStore.findByUsername(user.getUsername());
    		Date date=timesheet.getStartdate();
    		System.out.println(date);
    		System.out.println(timesheet.getStartdate());
    		System.out.println("in the daily entries" + dailyentry.getFromtime() + "asdf   " + dailyentry.getTotime());
    		System.out.println(dailyentry.getProject());
    		Timesheet timesheet1 = timesheetStore.findByUser(user);
    		DailyEntry de = new DailyEntry();
    		de.setFromtime(dailyentry.getFromtime());
    		de.setTimesheet(timesheet1);
    		de.setTotime(dailyentry.getTotime());
    		de.setProject(dailyentry.getProject());
    		dailyEntryStore.save(de);
    		
   	}
    	return "redirect:/";
    
    }*/

}
    	
    	
    	
    	
    	
    	
    	
    /////////////////////////////////////////////////////////////////////////  made to add entries in timesheet
   /* @GetMapping(value="/createentries")
    public void addEntries(Model model) {
    	model.addAttribute("dailyEntry", new DailyEntry());
    	
    	
    }

    @PostMapping(value="/createTimesheet")
    public String addTimesheetSubmit(@ModelAttribute Timesheet timeSheet,  @RequestParam(name="userid") Long userid) {
    	
    	Employee emp = empService.getEmployee(employeeId);
		Project proj = emp.getProjects().get(0);
		Calendar cal = Calendar.getInstance();
		List<DailyEntry> entries = new ArrayList<DailyEntry>(5);
		for(int i = 1; i< 6;i++) {
			DailyEntry e = new DailyEntry(cal.getTime(), proj, proj.getTasks().get(0), emp, 1);
			entries.add(e);
			cal.add(Calendar.DAY_OF_WEEK, -1);
		}
		
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_WEEK, 5);
		
		TimeSheet ts = new TimeSheet(emp, cal.getTime(), cal2.getTime());
		ts.setEntries(entries);
    	timesheetStore.save(timeSheet);
    	
        return "redirect:/listTimesheets";
    }

   
	
	
	@PostMapping("/timesheets")
	public Timesheet createTimesheet(@RequestBody Timesheet timesheet) {
		return timesheetStore.save(timesheet);
	}
	
	
	@GetMapping("/timesheets/{id}")
	public Timesheet getTimeSheet(@PathVariable(name="id") Long id) {
		 User user = userStore.findOne(id);
		 return timesheetStore.findByUser(user);
	}
	
	
	@GetMapping("/timesheets")
	public List<Timesheet> listTimesheets() {
		return Utils.toList(timesheetStore.findAll());
	}
	
	  @RequestMapping(value="/createTimesheet", params={"addRow"})
	    public String addRow(final Timesheet timesheet, final BindingResult bindingResult) {
	      timesheet.getEntries().add(new DailyEntry());  
		  return "createTimesheet";
	    }
	    
	    
	    @RequestMapping(value="/createTimesheet", params={"removeRow"})
	    public String removeRow(final Timesheet timesheet, final BindingResult bindingResult, final HttpServletRequest req) {
	        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
	        timesheet.getEntries().remove(rowId.intValue());
	        
	        return "createTimesheet";
	    }
	
	*/
  

