package com.learn.ssm.chapter5.mapper;

import com.learn.ssm.chapter5.pojo.Employee;

public interface EmployeeMapper {

	public Employee getEmployee(Long id);

	public Employee getEmployee2(Long id);
}
