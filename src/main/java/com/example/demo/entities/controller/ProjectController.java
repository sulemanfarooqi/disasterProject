package com.example.demo.entities.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Dropdown;
import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.entities.MachineCodeMangmnt;
import com.example.demo.entities.TimeSheet;
import com.example.demo.entities.TsLaborCharge;
import com.example.demo.entities.TsMachineCharge;
import com.example.demo.repo.TimesheetInterface;
import com.example.demo.services.JobServiceImpl;
import com.example.demo.services.MachineService;
import com.example.demo.services.MachineServiceImpl;
import com.example.demo.services.TimesheetServiceImpl;



@Controller
@SessionAttributes("dropdown")
public class ProjectController {
	@Autowired
	private JobServiceImpl jobService;
	
	@Autowired
	private MachineServiceImpl machineService;
	
	@Autowired
	private TimesheetInterface tsrepo;
	
	@Autowired
	private TimesheetServiceImpl tsServ;
	
	
	@ModelAttribute
	public Dropdown dropdown() {
		   
		return new Dropdown();
	}
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		return "index";
	}
	
	@RequestMapping("/login")
	public String viewLogin(Model model) {
		return "login";
	}
	

	
	
	
	
	/////////////////////////////////////////////////////////////
	//---------JOB MANAGEMENT-----------
	/////////////////////////////////////////////////////////////
	@RequestMapping("/jobmanagement")
	public String viewJobManagement(Model model) {
		List<JobCodeMngmnt> listJobs = jobService.listAll();
		model.addAttribute("listJobs", listJobs);
		return "jobs";
	}
	
	@RequestMapping(value= "/job/add")
	public String addjob(Model model) {
		JobCodeMngmnt job = new JobCodeMngmnt();
	    model.addAttribute("job", job);

	    return  "addjob";
	}
	
    @RequestMapping(value = "/savejob", method = RequestMethod.POST)
    public String saveJob(@ModelAttribute("job") JobCodeMngmnt job, Model model, BindingResult result) {
        jobService.save(job);
		List<JobCodeMngmnt> listJobs = jobService.listAll();
		model.addAttribute("listJobs", listJobs);
		return "jobs";
    }
	
	
	@RequestMapping(value= "/job/edit/{id}")
	public String editJob(@PathVariable("id") int id, ModelMap model ) {
	    model.put("job", jobService.get(id));
	    return  "editjobs";
	}
	
    @RequestMapping("/job/delete/{id}")
    public String deleteJob(@PathVariable("id") int id, @Validated JobCodeMngmnt job, BindingResult result, ModelMap model) {
    	jobService.delete(id);
		List<JobCodeMngmnt> listJobs = jobService.listAll();
		model.addAttribute("listJobs", listJobs);
		return "jobs";
    }
	
    @RequestMapping("/job/save/{id}")
    public String updateJob(@PathVariable("id") int id, @Validated JobCodeMngmnt job, BindingResult result, ModelMap model) {
    	jobService.save(job);
    	model.put("job", jobService.get(id));
		List<JobCodeMngmnt> listJobs = jobService.listAll();
		model.addAttribute("listJobs", listJobs);
		return "jobs";
    }
	
	
    
    
    
    ////////////////////////////////////////////////////////////
    //-------MACHINES AND EQUIPMENT MANAGEMENT-----------
    /////////////////////////////////////////////////////////////
	@RequestMapping("/machinemanagement")
	public String viewMachineManagement(Model model) {
		List<MachineCodeMangmnt> listMachines = machineService.listAll();
		model.addAttribute("listMachines", listMachines);
		return "machines";
	}
	
	
	@RequestMapping(value= "/machine/add")
	public String addMachine(Model model) {
		MachineCodeMangmnt machine = new MachineCodeMangmnt();
	    model.addAttribute("machine", machine);
	    
	    return  "addmachine";
	}
	
	

    @RequestMapping(value = "/savemachine", method = RequestMethod.POST)
    public String saveMachine(@ModelAttribute("machine") MachineCodeMangmnt machine, Model model, BindingResult result) {
        machineService.save(machine);
		List<MachineCodeMangmnt> listMachines = machineService.listAll();
		model.addAttribute("listMachines", listMachines);
		return "redirect:machinemanagement";
    }
	
	//Add editmachines html, change input value for edit button
	@RequestMapping(value= "/machine/edit/{id}")
	public String editMachine(@PathVariable("id") int id, ModelMap model ) {
	    model.put("machine", machineService.get(id));
	    return  "editmachines";
	}
	
	
    @RequestMapping("/machine/delete/{id}")
    public String deleteMachine(@PathVariable("id") int id, @Validated MachineCodeMangmnt machine, BindingResult result, ModelMap model) {
    	machineService.delete(id);
		List<MachineCodeMangmnt> listMachines = machineService.listAll();
		model.addAttribute("listMachines", listMachines);
		return "machines";
    }
	//
    @RequestMapping("/machine/save/{id}")
    public String updateJob(@PathVariable("id") int id, @Validated MachineCodeMangmnt machine, BindingResult result, ModelMap model) {
    	
    	machineService.save(machine);
    	model.put("machine", machineService.get(id));
		List<MachineCodeMangmnt> listMachines = machineService.listAll();
		model.addAttribute("listMachines", listMachines);
		return "machines";
    }

    
    ////////////////////////////////////////////////////
    /////Timesheet
    ///////////////////////////////////////////////////
    
    @RequestMapping("/add_timesheet")
	public String addTimesheet(Model model) {
		
		
		List<JobCodeMngmnt> list = jobService.listAll();
		model.addAttribute("jclist",list);
		
		List<MachineCodeMangmnt> mlist = machineService.listAll();
		model.addAttribute("mclist", mlist);
		
		System.out.println("in time sheet");
		
		TimeSheet ts = new TimeSheet();
		ts.getTslcs().add(new TsLaborCharge());//to get the row first time
		ts.getTsmcs().add(new TsMachineCharge());//to get row first time

		model.addAttribute("timesheet",ts);
		return "timesheet" ;
	}
	
	@RequestMapping(value= "/ts/approve/{id}")
	public String editTimesheet(@PathVariable("id") int id, @Validated TimeSheet ts, ModelMap model ) {
		System.out.println(ts.getContractorName());
		ts.setApprovalStatus("Approved");
		tsServ.get(id);
	    tsServ.save(ts);
	    
		List<TimeSheet> tslist = tsrepo.findAll();
		model.addAttribute("displaytslist", tslist);
	    return  "listTimeSheet";
	}
    

    
	@RequestMapping(value="/add_timesheet", method=RequestMethod.POST,params={"save"} )
	public String saveTimeSheet(@ModelAttribute("timesheet") TimeSheet ts, BindingResult bindingrequest) {
		
		System.out.println("in save ts");

		
		//summation amount and hrs
		List<TsLaborCharge>  tsl= ts.getTslcs();
		double totalamount = 0;
		int totalhours =0;
		for(TsLaborCharge tslc: tsl) {
			
			totalamount += tslc.getAmount();
			totalhours += tslc.getLaborHoursWorked();	
		}
		
		ts.setTotalAmount(totalamount);
		ts.setTotalHoursWorked(totalhours);
		ts.setApprovalStatus("Open");
		tsServ.save(ts);
		return "redirect:list_timesheet";
	}
	
	@RequestMapping("/list_timesheet")
	public String listTimeSheet(Model model) {
		
		List<TimeSheet> tslist = tsrepo.findAll();
		model.addAttribute("displaytslist", tslist);
		return "listTimeSheet";
	}
	
	
	//Changed to timesheet.html from selectJobCode.html
	@RequestMapping(value="/add_timesheet", method=RequestMethod.POST, params={"addRow"})
	public String addNewRows(@ModelAttribute("timesheet") TimeSheet ts, @ModelAttribute Dropdown dropdown) {
		
		System.out.println("in addRow");	
		ts.getTslcs().add(new TsLaborCharge());
		
		return "timesheet" ;
		
		
	}
	
	//Changed to timesheet.html from selectJobCode.html
	@RequestMapping(value="/add_timesheet", method=RequestMethod.POST, params={"addmachineRow"})
	public String addNewMRows(@ModelAttribute("timesheet") TimeSheet ts, @ModelAttribute Dropdown dropdown) {
		ts.getTsmcs().add(new TsMachineCharge());
		return "timesheet" ;
		
	}
    
	@RequestMapping("/listtimesheetadmin")
	public String displayApprovalAdmin(Model model){
		
		System.out.println("in admin list");
		List<TimeSheet> tslist = tsrepo.findAll();
		model.addAttribute("displaytslist", tslist);
		
		TimeSheet ts1 = new TimeSheet();
		model.addAttribute("searchts",ts1);
		
		return "listTimeSheetAdmin";
		
	}
	
	@RequestMapping(value="/listtimesheetadmin",method=RequestMethod.POST, params={"approve"})
	public String updateApprove( Model model, HttpServletRequest req) {
		
		Integer tsId = Integer.valueOf(req.getParameter("approve"));
		System.out.println("button triggered "+ tsId);
		
		TimeSheet ts = tsrepo.findById(tsId).get();
		ts.setApprovalStatus("Finalized");
		tsrepo.save(ts);
		
		List<TimeSheet> tslist = tsrepo.findAll();
		model.addAttribute("displaytslist", tslist);
		
		return "listTimeSheetAdmin";
	}
}
