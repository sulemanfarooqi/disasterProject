package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

//import org.springframework.transaction.annotation.Transactional;
import javax.transaction.Transactional;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.entities.MachineCodeMangmnt;
import com.example.demo.entities.TimeSheet;
import com.example.demo.repo.JobInterface;
import com.example.demo.repo.MachineInterface;
import com.example.demo.repo.TimesheetInterface;

@Service
public class TimesheetServiceImpl implements TimesheetService{

	@Autowired
	TimesheetInterface timesheetrepo ;
	
	@Autowired
	JobInterface jobrepo;
	
	@Autowired 
	MachineInterface mrepo;
	
	
	@Transactional
	@Override
	public void addTimeSheet(String sitecode, String contractorName, String date,  int laborHoursWorked ,int hoursUsed,String approvalStatus) {
		// TODO Auto-generated method stub
		JobCodeMngmnt jbc = jobrepo.findByJobCode("plumber"); 
		double hourlyrate = jbc.getHourlyRate();
        double amount = hourlyrate * laborHoursWorked;
        
        
        MachineCodeMangmnt mcm = mrepo.findByMachineCode("ht-11");
        double rent = mcm.getHourlyRent();
        double charge =  rent * hoursUsed;
        
		
		TimeSheet ts = new TimeSheet();
		ts.setApprovalStatus(approvalStatus);
		ts.setContractorName( contractorName);
		ts.setDate(date);
		ts.setSiteCode( sitecode);
//		ts.setAmount(amount);
//		ts.setMachinecharge(charge);
//		ts.setHoursUsed(hoursUsed);
//		ts.setLaborHoursWorked(laborHoursWorked);
		timesheetrepo.save(ts);
		
		//find by labor code
		//find by machine code
		
				
	}
	
	public TimeSheet get(int id) {
		return timesheetrepo.findById(id).get();
	}
	
	
	@Transactional
	@Override
	public void save(TimeSheet ts) {
		timesheetrepo.save(ts);
		
	}

	public List<TimeSheet> findAll() {
		return timesheetrepo.findAll();
	}

}