package com.nt.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nt.domain.EmployeeDetails;
import com.nt.entity.EmployeeEntity;


public interface EmployeeService {
	
	public boolean saveData(EmployeeDetails details) throws SQLException;
	
	public List<EmployeeEntity> getDataById(Integer id) throws SQLException;
	
	public void deltRecord(Integer id) throws SQLException;
	
	public void readfile(MultipartFile file) throws Exception ;

}
