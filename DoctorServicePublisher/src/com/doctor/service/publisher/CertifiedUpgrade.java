package com.doctor.service.publisher;

public class CertifiedUpgrade {

	private String name;
	private String duration;
	private String dose;
	
	public CertifiedUpgrade(String name, String duration, String dose) {
		super();
		this.name = name;
		this.duration = duration;
		this.dose = dose;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}
	
	
	
}
