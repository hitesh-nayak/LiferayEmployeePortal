/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.employee.service.service.impl;

import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.employee.service.service.base.EmployeeLocalServiceBaseImpl;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.employee.service.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	
	public  List<Employee> getEmployeesList(){
		
//		List<Employee> employeeList = new ArrayList<>();
//		try {
//			employeeList = 
//			employeePersistence.findAll();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		return employeePersistence.findAll();
		
	}
//	@Override
//	@Indexable(type = IndexableType.REINDEX)
//	public Employee addEmployee(Employee employee) {
//		
//		return employeeLocalService.addEmployee(employee);
//	}
//	
//	@Override
//	@Indexable(type = IndexableType.REINDEX)
//	public Employee updateEmployee(Employee employee) {
//		
//		return employeeLocalService.updateEmployee(employee);
//	}
//	
//	@Override
//	@Indexable(type = IndexableType.DELETE)
//	public Employee deleteEmployee(long companyEmployeeId) throws PortalException {
//		
//		return employeeLocalService.deleteEmployee(companyEmployeeId);
//	}
	
}