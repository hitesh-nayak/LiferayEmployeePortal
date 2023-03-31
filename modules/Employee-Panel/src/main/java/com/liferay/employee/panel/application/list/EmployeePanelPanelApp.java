package com.liferay.employee.panel.application.list;

import com.liferay.employee.panel.constants.EmployeePanelPanelCategoryKeys;
import com.liferay.employee.panel.constants.EmployeePanelPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + EmployeePanelPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class EmployeePanelPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return EmployeePanelPortletKeys.EMPLOYEEPANEL;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + EmployeePanelPortletKeys.EMPLOYEEPANEL + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}