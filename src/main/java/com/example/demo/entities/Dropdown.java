package com.example.demo.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repo.JobInterface;
import com.example.demo.repo.MachineInterface;

@Component
public class Dropdown {

	
	
	public List<JobCodeMngmnt> jclist ;
	
	public List<MachineCodeMangmnt> mclist ;
	
	
	public Dropdown() {}
	
	

	public Dropdown( List<JobCodeMngmnt> jclist,
			List<MachineCodeMangmnt> mclist) {
	
		
		this.jclist = jclist;
		this.mclist = mclist;
	}

	
	public List<JobCodeMngmnt> getJclist() {
		return jclist;
	}

	public void setJclist(List<JobCodeMngmnt> jclist) {
		this.jclist = jclist;
	}

	public List<MachineCodeMangmnt> getMclist() {
		return mclist;
	}

	public void setMclist(List<MachineCodeMangmnt> mclist) {
		this.mclist = mclist;
	}
	
	
	
}