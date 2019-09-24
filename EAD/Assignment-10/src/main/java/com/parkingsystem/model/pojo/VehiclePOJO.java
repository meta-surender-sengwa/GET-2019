package com.parkingsystem.model.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class VehiclePOJO {

	private int empId;
	
	@Pattern(regexp="[a-zA-Z0-9 ]{3,30}",message="please enter your vehicle's name (company)")
	private String name;
	
	@NotBlank(message="please select your vehicle type")
	private String type;
	
	@Pattern(regexp="[a-zA-Z0-9 ]{10}",message="please enter a valid vehicle number")
	private String number;
	
	@NotBlank(message="please add description of your vehicle")
	private String identification;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
