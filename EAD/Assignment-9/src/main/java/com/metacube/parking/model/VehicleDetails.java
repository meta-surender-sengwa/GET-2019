package com.metacube.parking.model;

import javax.validation.constraints.NotBlank;

public class VehicleDetails {
	
	@NotBlank(message = "{blankVehicleName}")
	private String vehicleName;
	
	@NotBlank(message = "blankVehicletype")
	private String vehicleType;
	
	@NotBlank(message = "blankVehicleNo")
	private String vehicleNumber;
	
	@NotBlank(message = "blankEmployeeId")
	private String empId;
	
	private String identification;
	
	public String getVehicleName() {
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getIdentification() {
		return identification;
	}
	
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public VehicleDetails(String vehicleName, String vehicleType,
			String vehicleNumber, String empId, String identification) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.empId = empId;
		this.identification = identification;
	}
	
	public VehicleDetails() {
	}
	
	@Override
	public String toString() {
		return "VehicleDetails [vehicleName=" + vehicleName + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber + ", empId=" + empId + ", identification=" + identification + "]";
	}
}
