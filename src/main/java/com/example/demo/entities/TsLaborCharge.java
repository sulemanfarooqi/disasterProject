package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TsLabCharge")
public class TsLaborCharge {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
//	@OneToOne(fetch = FetchType.EAGER,optional = false)
//	@JoinColumn(name= "timesheet_jobcode", referencedColumnName="jobCode", insertable = false, updatable = false )
//	private JobCodeMngmnt jbcode;
	private String jbcode;
	private int laborHoursWorked;
	private double amount;
	
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinColumn(name = "ts_id")
	private TimeSheet tsl;

	public TsLaborCharge(){}
	
	public TsLaborCharge(int id, String jbcode, int laborHoursWorked, double amount, TimeSheet ts) {
		super();
		this.id = id;
		this.jbcode = jbcode;
		this.laborHoursWorked = laborHoursWorked;
		this.amount = amount;
		this.tsl = ts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJbcode() {
		return jbcode;
	}

	public void setJbcode(String jbcode) {
		this.jbcode = jbcode;
	}

	public int getLaborHoursWorked() {
		return laborHoursWorked;
	}

	public void setLaborHoursWorked(int laborHoursWorked) {
		this.laborHoursWorked = laborHoursWorked;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TimeSheet getTs() {
		return tsl;
	}

	public void setTs(TimeSheet ts) {
		this.tsl = ts;
	}
	
	
	
	
	
	
	
}