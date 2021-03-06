package timesheet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import timesheet.Utils;

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
	

	
	
    @InitBinder
    public void initDateBinder(final WebDataBinder binder) {
           binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(timeFormat()), true));
    }
    
    @ModelAttribute("dateFormat")
    public String dateFormat() {
        return "yyyy-MM-dd";
    }
    @ModelAttribute("timeFormat")
    public String timeFormat() {
        return "HH:mm";
    }
    
    @GetMapping("/viewmytimesheet")
    public String viewMyTimesheet(Model model) {
        if (model.asMap().containsKey("User")) {
        	User user = (User) model.asMap().get("User");
        	 List<Timesheet> timesheets = (List<Timesheet>) timesheetStore.findByUser(user);
        	 System.out.println(timesheets + "this is the list returned");
        	 model.addAttribute("timesheets", timesheets);
        	//model.addAttribute("supervisor", supervisor);
        	
            return "viewmytimesheet";
        } else {
        	
            model.addAttribute("message", "Please login first");
            return "home";
        }
    }
    
    @GetMapping("/viewmytimesheet/{emp.username}")
    public String viewMyTimesheetwithId(@PathVariable("emp.username") String username,Model model) {
        if (model.asMap().containsKey("User")) {
        	System.out.println(username+ "heroweiuro wei;h;oilhafsd;hf;kjasdhk;jfkdjsh kfk");
        	User user = userStore.findByUsername(username);
        	 List<Timesheet> timesheets = (List<Timesheet>) timesheetStore.findByUser(user);
        	 System.out.println(timesheets + "this is the list returned");
        	 model.addAttribute("timesheets", timesheets);
        	//model.addAttribute("supervisor", supervisor);
        	
            return "viewmytimesheet";
        } else {
        	
            model.addAttribute("message", "Please login first");
            return "home";
        }
    }
    
    @RequestMapping(value="/viewmytimesheet", method=RequestMethod.DELETE)
	public void deletetimesheet(Long timesheet_id,Model model) {
    		 timesheetStore.delete((long)timesheet_id);
    		 viewMyTimesheet(model);
    		
		
	}
	
    @GetMapping(value="/createtimesheet")
    public String addTimeSheetForm(Model model) {
    	 if (model.asMap().containsKey("User")) {
    		
 	        	
 	        	User user = (User) model.asMap().get("User");
 	        	
 	        	System.out.println(model.asMap().get("User") + "yes i got this user");
 	        	System.out.println(user.getUsername());
 	        	System.out.println(dateFormat());
 	        	User user1 = userStore.findByUsername(user.getUsername());
 	        	
 	        	if(user1.getDiscriminatorValue().equalsIgnoreCase("employee")) {
 	        		Employee employee=employeeStore.findByUsername(user.getUsername());
 	        		List<Project> empprojects =employee.getProject();
 	        		model.addAttribute("employee",employee);
 	        		model.addAttribute("empprojects",empprojects);
 	        	}
 	        	else if(user1.getDiscriminatorValue().equalsIgnoreCase("supervisor")) {
 	        		Supervisor supervisor = supervisorStore.findByUsername(user.getUsername());
 	        		List<Project> empprojects = projectStore.findBySupervisor(supervisor);
 	        		model.addAttribute("employee",supervisor);
 	        		model.addAttribute("empprojects",empprojects);
 	        	}
 	        	//model.addAttribute("dailyentry", new DailyEntry());
 	        	Timesheet timesheet = new Timesheet();
 	        	timesheet.setStartdate(new Date());
 	        	timesheet.setFromtime(new Date());
 	        	timesheet.setTotime(new Date());
 	        	
 	        	model.addAttribute("timesheet", timesheet);
 	        	
 	        	
    		 return "createtimesheet";
    	 }
    	 else {
    	      	
             model.addAttribute("message", "Please login first");
             return "home";
         }
    }
    
    
    @PostMapping("/createtimesheet")
    public String createTimesheet(@ModelAttribute("timesheet") TsCreateRequest timesheet , Model model, BindingResult result) {
    	if(!result.hasErrors()) {
    		
    		User user = (User) model.asMap().get("User");
    		//Employee employee = employeeStore.findByUsername(user.getUsername());
    		//Date date=timesheet.getStartdate();
    		
    		Timesheet ts1 = new Timesheet();
    		try {
				ts1.setStartdate(new SimpleDateFormat("yyyy-mm-dd").parse(timesheet.getStartdate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		ts1.setFromtime(timesheet.getFromtime());
    		ts1.setTotime(timesheet.getTotime());
    		ts1.setUser(user);
    		Project proj1 = projectStore.findByTitle(timesheet.getProject());
    		ts1.setProject(proj1);
    		double hours = ((timesheet.getTotime().getTime()-timesheet.getFromtime().getTime())/(60*60*1000))%24;
    		ts1.setNoofhours(hours);
    		
    		timesheetStore.save(ts1);
    	}
    	return "home";
    }
    
    
  /*  
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
    */
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
  

