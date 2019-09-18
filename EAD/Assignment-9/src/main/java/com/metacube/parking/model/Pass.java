package com.metacube.parking.model;

public class Pass {
	private String currency;
	private String plan;
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getPlan() {
		return plan;
	}
	
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public Pass(String currency, String plan) {
		this.currency = currency;
		this.plan = plan;
	}
	
	public Pass() {
	}
	
	@Override
	public String toString() {
		return "Pass [currency=" + currency + ", plan=" + plan + "]";
	}
}
