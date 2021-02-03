package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.MachineCodeMangmnt;

public interface MachineService {

	public void addMachine(String machinecode, String desccription,int hourlyrent,int maxhours);
	public List<MachineCodeMangmnt> listAll();
	public void save(MachineCodeMangmnt mc);
	public MachineCodeMangmnt get(int id);
	public void delete(int id);
}
