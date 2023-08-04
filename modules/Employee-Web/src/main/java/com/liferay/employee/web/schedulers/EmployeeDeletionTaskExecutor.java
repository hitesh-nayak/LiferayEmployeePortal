package com.liferay.employee.web.schedulers;


import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;


@Component(property = {
		"dispatch.task.executor.name=EmployeeDeletion", "dispatch.task.executor.type=onDelete"
}, service = DispatchTaskExecutor.class)

public class EmployeeDeletionTaskExecutor extends BaseDispatchTaskExecutor {

	@Override
	public String getName() {
		
		return "EmployeeDeletion";
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {
		
			_log.info("Executing scheduler");
			_log.info(getEmployees().size()+ " employee(s) is/are over 60 days old. Log from Task Executor.");
	}
	
	
	private List<Employee> getEmployees(){
		DynamicQuery dQuery = EmployeeLocalServiceUtil.dynamicQuery();
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_MONTH	, -60);
		Date dateSixtyDaysAgoDate = calendar.getTime();
		
		dQuery.add(RestrictionsFactoryUtil.le("createDate", dateSixtyDaysAgoDate));
		
		return EmployeeLocalServiceUtil.dynamicQuery(dQuery);
		
	}
	
	private static Log _log= LogFactoryUtil.getLog(EmployeeDeletionTaskExecutor.class);

}
