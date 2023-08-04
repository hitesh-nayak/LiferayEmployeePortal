package com.liferay.employee.web.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalService;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.employee.service.service.persistence.EmployeePersistence;
import com.liferay.headless.delivery.resource.v1_0.DocumentResource;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Reference;

public class EmpUtil {
	
	
	@Reference
	private  EmployeeLocalService employeeLocalService;
	@Reference
	 private CounterLocalService counterLocalService;
	@Reference
	 private DocumentResource.Factory documentResourceFactory;
	@Reference
	private EmployeePersistence employeePersistence;
	
	public static List<Employee> getEmployees(){
		
		List<Employee> employeeList = new ArrayList<>();
		try {
			employeeList = 
			EmployeeLocalServiceUtil.getEmployeesList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employeeList;
		
	}
	
	public static List<Employee> getEmployees(int size){
		
		DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
		
		dynamicQuery.addOrder(OrderFactoryUtil.asc("companyEmpId"));
		
		return Collections.EMPTY_LIST;
	}

}
