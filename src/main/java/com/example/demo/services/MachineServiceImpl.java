package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.MachineCodeMangmnt;
import com.example.demo.repo.MachineInterface;

@Service
public class MachineServiceImpl implements MachineService {

	@Autowired
	MachineInterface machineRepo;
	
	@Transactional
	@Override
	public void addMachine(String jobcode, String description, int hourlyrent, int maxhours) {
		
		MachineCodeMangmnt mc = new MachineCodeMangmnt();
		mc.setMachineCode(jobcode);
		mc.setDescription(description);
		mc.setMaxHours(4);
		mc.setHourlyRent(10);
		machineRepo.save(mc);
	
	}
	
	public List<MachineCodeMangmnt> listAll() {
		return machineRepo.findAll();
	}
	
	public void save(MachineCodeMangmnt mc) {
		machineRepo.save(mc);
	}
	
	public MachineCodeMangmnt get(int id) {
		return machineRepo.findById(id).get();
	}
	
	public void delete(int id) {
		machineRepo.deleteById(id);
	}

	public List<MachineCodeMangmnt> findAll() {
		return machineRepo.findAll();
	}

	
}
