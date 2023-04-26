package com.yxz.hibernate.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "account")
public class AccountModel implements Serializable {
	
	private static final long serialVersionUID = -7775240961398209642L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private Long uId;
	
	@Column(name = "user_name", unique = true)
	private String userName;
	
	@Column(name = "doctor_id", unique = true)
	private Long doctorId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")		//this column in database have to set to foreign key
											// ALTER TABLE `account` 	ADD CONSTRAINT `FK_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION;
	private AddressModel addressModel;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private List<PatientModel> patients;	//automatically indicate primary key(uId) in the PatientModel two patient have same doctor in one uid

	public List<PatientModel> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientModel> patients) {
		this.patients = patients;
	}

	public Long getuId() {
		return uId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public AddressModel getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}

	public AccountModel(String userName, AddressModel addressModel) {
		super();
		this.userName = userName;
		this.addressModel = addressModel;
	}

	public AccountModel() {
		super();
	}
	
	

}
