package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.MachineCodeMangmnt;

public interface MachineInterface extends JpaRepository<MachineCodeMangmnt, Integer> {
	
	MachineCodeMangmnt findByMachineCode(String machinecode);
}
