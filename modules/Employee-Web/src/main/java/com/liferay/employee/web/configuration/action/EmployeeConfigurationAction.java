package com.liferay.employee.web.configuration.action;

import com.liferay.employee.web.constants.EmployeeWebPortletKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component
(
		configurationPolicy = ConfigurationPolicy.OPTIONAL,
		property = "javax.portlet.name=" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		service = ConfigurationAction.class

)

public class EmployeeConfigurationAction extends DefaultConfigurationAction {

	
	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		setPreference(
			actionRequest, "color",
			ParamUtil.getString(actionRequest, "color"));

		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
