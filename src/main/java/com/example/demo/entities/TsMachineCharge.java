package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TsMacCharge")
public class TsMachineCharge {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name= "timesheet_machinecode", referencedColumnName="machineCode")
//	private MachineCodeMangmnt machinecode;
	
	private String machinecode;
	private int hoursUsed;
	private double machinecharge;
	
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinColumn(name = "ts_id")
	private TimeSheet ts;

	public TsMachineCharge() {}
	
	public TsMachineCharge(int id, String machinecode, int hoursUsed, double machinecharge, TimeSheet ts) {
		super();
		this.id = id;
		this.machinecode = machinecode;
		this.hoursUsed = hoursUsed;
		this.machinecharge = machinecharge;
		this.ts = ts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMachinecode() {
		return machinecode;
	}

	public void setMachinecode(String machinecode) {
		this.machinecode = machinecode;
	}

	public int getHoursUsed() {
		return hoursUsed;
	}

	public void setHoursUsed(int hoursUsed) {
		this.hoursUsed = hoursUsed;
	}

	public double getMachinecharge() {
		return machinecharge;
	}

	public void setMachinecharge(double machinecharge) {
		this.machinecharge = machinecharge;
	}

	public TimeSheet getTs() {
		return ts;
	}

	public void setTs(TimeSheet ts) {
		this.ts = ts;
	}
	
	
	
	
	
}