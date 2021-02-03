package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.JobCodeMngmnt;

public interface JobService {

	public void addJob(String jobcode, String desccription,int hourlyrate,int maxhours);
	public List<JobCodeMngmnt> listAll();
	public void save(JobCodeMngmnt job);
	public JobCodeMngmnt get(int id);
	public void delete(int id);
	
}
