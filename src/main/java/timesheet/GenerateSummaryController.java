package timesheet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import timesheet.service.TsCreateRequest;

@Controller
@SessionAttributes({"User","Project","Timesheet"})
@ComponentScan("timesheet.models")
public class GenerateSummaryController {
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
           binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
    }
    @ModelAttribute("dateFormat")
    public String dateFormat() {
        return "yyyy-mm-dd";
    }
	
    @GetMapping(value="/generatesummary")
    public String generateForm(Model model) {
    	if (model.asMap().containsKey("User")) {
        	
        	User user = (User) model.asMap().get("User");
        	
        	
        	Supervisor supervisor = supervisorStore.findByUsername(user.getUsername());
        	
        	List<Project> supprojects = projectStore.findBySupervisor(supervisor);
        	
        	 
        	model.addAttribute("supprojects",supprojects);
        	System.out.println("I am going to generate"+ supprojects);
        	for(Project p:supprojects) {
        		List<Timesheet> t=timesheetStore.findByProject(p);
        		for(Timesheet timesheet:t) {
        			model.addAttribute("timesheet", timesheet);
        		}
        	}
            return "generatesummary";
        } else {
        	
            model.addAttribute("message", "Please login first");
            return "home";
        }
   	 
    }
   
    @RequestMapping(value="/generatesummary/{project.getTitle()}/date/{date}", method=RequestMethod.GET)
    public String showResult(@PathVariable("project.getTitle()")String title,@PathVariable("date")Date date, Model model) {
    		System.out.println("It reached showResult");
    		Project project = projectStore.findByTitle(title);
    		model.addAttribute("project", project);
    		
    		for(Employee emp:project.getEmplist()) {
    			List<Timesheet> timesheetlist=timesheetStore.findByUserAndStartdate(emp, date);
        		model.addAttribute("timesheetlist",timesheetlist);
    		}
    		
    		
    		
    		return "report";
}
    
}
