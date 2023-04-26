package com.yxz.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "patient")
public class PatientModel {


	@Id		
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myGenerator")
	@Column(name = "patient_id")
	private Long patientId;
	
	@Column(name = "doctor_id")
	private Long doctorId;
	
	@Column(name = "patient_name")
	private String patientName;
	
	
	public PatientModel(Long doctorId, String patientName) {
		super();
		this.doctorId = doctorId;
		this.patientName = patientName;
	}

	public PatientModel() {
		super();
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
}
