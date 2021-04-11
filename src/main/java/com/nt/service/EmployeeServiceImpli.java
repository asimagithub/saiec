package com.nt.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.dao.EmployeeRepo;
import com.nt.domain.EmployeeDetails;
import com.nt.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpli implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	/**
	 * this method is used for save data
	 */
	@Override
	public boolean saveData(EmployeeDetails details) throws SQLException {
		// create EmployeeEntity class object
		EmployeeEntity entity = new EmployeeEntity();
		// copy all properties to details to entity
		BeanUtils.copyProperties(details, entity);
		// call save method for register all data in database
		EmployeeEntity save = repo.save(entity);
		if (save != null)
			return true;
		else

			return false;
	}

	/**
	 * This method is used for find data by using id
	 */
	@Override
	public List<EmployeeEntity> getDataById(Integer id) throws SQLException {
		EmployeeEntity entity = null;
		List<EmployeeEntity> list = null;
		Optional<EmployeeEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			entity = new EmployeeEntity();
			EmployeeEntity employeeEntity = findById.get();

			BeanUtils.copyProperties(employeeEntity, entity);
			list = new ArrayList<EmployeeEntity>();
			list.add(entity);

		}

		return list;
	}

	/**
	 * This method is used for delete records from database table by using employee
	 * id
	 */
	@Override
	public void deltRecord(Integer id) throws SQLException {
		repo.deleteById(id);

	}
/**
 * This method is used for read the text file from local machine
 */
	@Override
	public void readfile(MultipartFile file) throws IOException, SQLException {

		File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
		file.transferTo(convFile);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(convFile));

		String st;
		while ((st = br.readLine()) != null) {
			System.out.println(st);
			String readLine = st;
			EmployeeDetails details = new EmployeeDetails();
			details.setEmpName(readLine.split(",")[0]);
			details.setEmpDegination(readLine.split(",")[1]);
			details.setEmpDoj(readLine.split(",")[2]);
			saveData(details);
		}
	}

}
