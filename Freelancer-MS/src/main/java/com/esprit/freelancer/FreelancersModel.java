package com.esprit.freelancer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "freelancer", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class FreelancersModel {

	public FreelancersModel(String name, String family_name, String gender, String mdp, String address, String email) {
		this.name = name;
		this.family_name = family_name;
		this.gender = gender;
		this.mdp = mdp;
		this.address = address;
		this.email = email;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "freelancer_id")
	private Integer freelancerId;
	private String name;
	@Column(name = "family_name")
	private String family_name;
	private String gender;
	private String mdp;

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	private String address;
	@Column(name = "email", unique = true)
	private String email;
	public FreelancersModel() {
	}

	public Integer getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(Integer freelancerId) {
		this.freelancerId = freelancerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FreelancersModel [FreelancerId=" + freelancerId + ", name=" + name + ", family_name=" + family_name + ", address=" + address + ", gender=" + gender
				+ "]";
	}

}
