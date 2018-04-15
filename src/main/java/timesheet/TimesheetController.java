package timesheet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import timesheet.models.Employee;
import timesheet.models.EmployeeStore;
import timesheet.models.Project;
import timesheet.models.ProjectStore;
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
	
	@GetMapping("/addtimesheet")
	public String addTimesheet(Model model) {
		if (model.asMap().containsKey("User")) {
			
			
		      
		      return "addtimesheet";
			
		}
		
		else {
        	
            model.addAttribute("message", "Please login first");
            return "home";
        }
	}
	
	
  
}
