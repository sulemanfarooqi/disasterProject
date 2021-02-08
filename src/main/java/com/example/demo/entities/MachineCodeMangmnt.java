package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MachineCode")
public class MachineCodeMangmnt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String machineCode;
	private String description;
	private int hourlyRent;
	private int maxHours;
	
	
	
	public MachineCodeMangmnt() {}

	
	public MachineCodeMangmnt(String machineCode, String description, int hourlyRent, int maxHours) {
		super();
		this.machineCode = machineCode;
		this.description = description;
		this.hourlyRent = hourlyRent;
		this.maxHours = maxHours;
		//this.machineCodeMngmnt = machineCodeMngmnt;
	}


	public String getMachineCode() {
		return machineCode;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getHourlyRent() {
		return hourlyRent;
	}


	public void setHourlyRent(int hourlyRent) {
		this.hourlyRent = hourlyRent;
	}


	public int getMaxHours() {
		return maxHours;
	}


	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}



}