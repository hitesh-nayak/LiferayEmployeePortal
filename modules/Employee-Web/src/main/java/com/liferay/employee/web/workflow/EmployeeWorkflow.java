package com.liferay.employee.web.workflow;

import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;


@Component(property = {"model.class.name=com.liferay.employee.service.model.Employee"}, service = WorkflowHandler.class
		)
public class EmployeeWorkflow extends BaseWorkflowHandler<Employee> {

	

	@Override
	public String getClassName() {
		return Employee.class.getName();
	}

	
	@Override
	public String getType(Locale locale) {
		return "Employee";
	}


	@Override
	public Employee updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
