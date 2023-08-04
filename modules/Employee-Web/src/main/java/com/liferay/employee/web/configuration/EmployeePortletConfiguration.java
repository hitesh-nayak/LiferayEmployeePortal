package com.liferay.employee.web.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "employee-portlet-config", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)

@Meta.OCD(id = "com.liferay.employee.web.configuration.EmployeePortletConfiguration", name = "Employee Portlet")

public interface EmployeePortletConfiguration {
	
	
	@Meta.AD(deflt = "green", name = "color", optionLabels = { "Green", "Orange", "Purple" }, optionValues = { "green",
			"orange", "purple" }, required = false)
	public String color();

}
