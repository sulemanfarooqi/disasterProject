package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.repo.JobInterface;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	JobInterface jobRepo;
	
	@Transactional
	@Override
	public void addJob(String jobcode, String description, int hourlyrate, int maxhours) {
		
		JobCodeMngmnt jb = new JobCodeMngmnt();
		jb.setJobCode(jobcode);
		jb.setDescription(description);
		jb.setMaxHours(4);
		jb.setHourlyRate(10);
		jobRepo.save(jb);
	
	}
	
	public List<JobCodeMngmnt> listAll() {
		return jobRepo.findAll();
	}
	
	public void save(JobCodeMngmnt job) {
		jobRepo.save(job);
	}
	
	public JobCodeMngmnt get(int id) {
		return jobRepo.findById(id);
	}
	
	public void delete(int id) {
		jobRepo.deleteById(id);
	}
	
	
	public void update(JobCodeMngmnt job) {
		JobCodeMngmnt entity = new JobCodeMngmnt();
		System.out.println("+++++++++++++++++");
		System.out.println(job.getHourlyRate());
		System.out.println(job.getId());
		System.out.println(job.getJobCode());
		System.out.println(job.getMaxHours());

		
		entity.setDescription(job.getDescription());
		entity.setHourlyRate(job.getHourlyRate());
		entity.setJobCode(job.getJobCode());
		jobRepo.save(entity);
	}
	
	
	
}
