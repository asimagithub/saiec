package com.nt.dao;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.EmployeeEntity;


//@Repository (This annotation is not required buz if You use spring data)

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Integer> {

}
