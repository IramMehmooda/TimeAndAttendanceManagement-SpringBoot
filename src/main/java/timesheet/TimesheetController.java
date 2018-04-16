package timesheet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import timesheet.Utils;
import timesheet.models.Employee;
import timesheet.models.EmployeeStore;
import timesheet.models.Project;
import timesheet.models.ProjectStore;
import timesheet.models.Timesheet;
import timesheet.models.TimesheetStore;
import timesheet.models.User;
import timesheet.models.UserStore;

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
	
	@GetMapping(value="/listTimesheets")
    public String listTimeSheets( Model model) {
        model.addAttribute("timesheets", Utils.toList(timesheetStore.findAll()));
        return "listTimesheets";
    }
	
    @GetMapping(value="/createTimesheet")
    public String addTimeSheetForm(Model model, @RequestParam(name="userid") Long userid) {
       	model.addAttribute("timesheet", new Timesheet());
       	model.addAttribute("userid", userid);//should be retrieved from session
        return "createTimesheet";
    }

    @PostMapping(value="/createTimesheet")
    public String addTimesheetSubmit(@ModelAttribute Timesheet timeSheet,  @RequestParam(name="userid") Long userid) {
    	
    	/*Employee emp = empService.getEmployee(employeeId);
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
    	timesheetStore.save(timeSheet);*/
    	
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
	
	
  
}
