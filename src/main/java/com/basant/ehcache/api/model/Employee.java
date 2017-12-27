package com.basant.ehcache.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Employee_TBL")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8033707059439650526L;
	@Id
	private int id;
	private String name;
	private String dept;
	private double salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
