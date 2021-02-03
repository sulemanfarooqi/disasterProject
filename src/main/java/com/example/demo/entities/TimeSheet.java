package com.example.demo.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="Timesheet")
public class TimeSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String siteCode;
	private String contractorName;
	private String date;
	private int totalHoursWorked;
	private double totalAmount;
	private double machineCharge;
	private String approvalStatus;
	
	

	@OneToMany(mappedBy = "tsl", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	private List<TsLaborCharge> tslcs =  new ArrayList<TsLaborCharge>();
	
	@OneToMany(mappedBy = "ts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TsMachineCharge> tsmcs = new ArrayList<TsMachineCharge>(); // to get reference when hitting the UI first time

	public TimeSheet() {}

	

	public TimeSheet(int id, String siteCode, String contractorName, String date, int totalHoursWorked, double totalAmount,
			double machineCharge, String approvalStatus, List<TsLaborCharge> tslcs, List<TsMachineCharge> tsmcs) {
		super();
		this.id = id;
		this.siteCode = siteCode;
		this.contractorName = contractorName;
		this.date = date;
		this.totalHoursWorked = totalHoursWorked;
		this.totalAmount = totalAmount;
		this.machineCharge = machineCharge;
		this.approvalStatus = approvalStatus;
		this.tslcs = tslcs;
		this.tsmcs = tsmcs;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getContractorName() {
		return contractorName;
	}
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public int getTotalHoursWorked() {
		return totalHoursWorked;
	}
	public void setTotalHoursWorked(int totalHoursWorked) {
		this.totalHoursWorked = totalHoursWorked;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getMachineCharge() {
		return machineCharge;
	}
	public void setMachineCharge(double machineCharge) {
		this.machineCharge = machineCharge;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public List<TsLaborCharge> getTslcs() {
		return tslcs;
	}
	public void setTslcs(List<TsLaborCharge> tslcs) {
		this.tslcs = tslcs;
	}
	public List<TsMachineCharge> getTsmcs() {
		return tsmcs;
	}
	public void setTsmcs(List<TsMachineCharge> tsmcs) {
		this.tsmcs = tsmcs;
	}



	
	



	
	
}