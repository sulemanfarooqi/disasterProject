package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.entities.MachineCodeMangmnt;
import com.example.demo.entities.Role;
import com.example.demo.entities.TimeSheet;
import com.example.demo.repo.JobInterface;
import com.example.demo.repo.MachineInterface;
import com.example.demo.repo.RoleInterface;
import com.example.demo.repo.TimesheetInterface;


@SpringBootTest
class DisasterRecoveryApplicationTests {

	
	void contextLoads() {
	}

//	@Autowired
//	RoleInterface role;
//	
	@Autowired
	JobInterface jobRepo;
	
	@Autowired
	MachineInterface machineRepo;
	
	@Autowired
	TimesheetInterface tsRepo;
	

//	
//	public void testRoleRepo() {
//		Role  userRole = new Role();
//		userRole.setName("Jish");
//		userRole.setAdmin(false);
//		role.save(userRole);
//	}
//	
	@Test
	public void testJobRepo() {
		JobCodeMngmnt jobcode = new JobCodeMngmnt();
		jobcode.setJobCode("Plumber");
		jobcode.setDescription("Fix the plumbing");
		jobcode.setHourlyRate(65);
		jobcode.setMaxHours(4);
		jobRepo.save(jobcode);
	}
	
	
	@Test
	public void testJobRepo2() {
		JobCodeMngmnt jobcode = new JobCodeMngmnt();
		jobcode.setJobCode("Carpenter");
		jobcode.setDescription("Wood work");
		jobcode.setHourlyRate(50);
		jobcode.setMaxHours(4);
		jobRepo.save(jobcode);
	}
	
	@Test
	public void testJobRepo3() {
		JobCodeMngmnt jobcode = new JobCodeMngmnt();
		jobcode.setJobCode("Electrician");
		jobcode.setDescription("Electric Work");
		jobcode.setHourlyRate(45);
		jobcode.setMaxHours(4);
		jobRepo.save(jobcode);
	}
	
	@Test
	public void testJobRepo4() {
		JobCodeMngmnt jobcode = new JobCodeMngmnt();
		jobcode.setJobCode("General Labor");
		jobcode.setDescription("General work");
		jobcode.setHourlyRate(30);
		jobcode.setMaxHours(8);
		jobRepo.save(jobcode);
	}
	
	
	@Test
	public void testMachineRepo() {
		MachineCodeMangmnt machineCode = new MachineCodeMangmnt();
		machineCode.setMachineCode("HT-100");
		machineCode.setDescription("Hand Truck with 1000 LBS");
		machineCode.setHourlyRent(8);
		machineCode.setMaxHours(8);
		machineRepo.save(machineCode);
	}
	
	@Test
	public void testMachineRepo2() {
		MachineCodeMangmnt machineCode = new MachineCodeMangmnt();
		machineCode.setMachineCode("AT-800");
		machineCode.setDescription("Appliance Truck");
		machineCode.setHourlyRent(8);
		machineCode.setMaxHours(4);
		machineRepo.save(machineCode);
	}
	
	@Test
	public void testMachineRepo3() {
		MachineCodeMangmnt machineCode = new MachineCodeMangmnt();
		machineCode.setMachineCode("AirComp");
		machineCode.setDescription("Air Compressor");
		machineCode.setHourlyRent(10);
		machineCode.setMaxHours(4);
		machineRepo.save(machineCode);
	}
	
	@Test
	public void testMachineRepo4() {
		MachineCodeMangmnt machineCode = new MachineCodeMangmnt();
		machineCode.setMachineCode("Power Tools");
		machineCode.setDescription("Power Tools");
		machineCode.setHourlyRent(6);
		machineCode.setMaxHours(8);
		machineRepo.save(machineCode);
	}
	/*
	public void testTsRepo() {
		TimeSheet ts = new TimeSheet();
		ts.setContractorName("Josh");
		ts.setApprovalStatus("open");
		ts.setDate("1/23/2021");
		ts.setLaborHoursWorked(4);
		ts.setSiteCode(111);
		ts.setHoursUsed(4);
	    tsRepo.save(ts);
	}
	*/
	
}
