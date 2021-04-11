package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@SequenceGenerator(name = "seq", initialValue = 101)
@Table(name = "EmployeeDetails")
@Entity
public class EmployeeEntity {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Id
	@Column(name = "ID", length = 10)
	private int empId;

	@Column(name = "Name", length = 10)
	private String empName;

	@Column(name = "Deg", length = 10)
	private String empDegination;

	@Column(name = "Doj", length = 10)
	private String empDoj;

}
