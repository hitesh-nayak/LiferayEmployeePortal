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

package com.liferay.employee.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
public class EmployeeWrapper
	extends BaseModelWrapper<Employee>
	implements Employee, ModelWrapper<Employee> {

	public EmployeeWrapper(Employee employee) {
		super(employee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyEmpId", getCompanyEmpId());
		attributes.put("groupId", getGroupId());
		attributes.put("empFirstName", getEmpFirstName());
		attributes.put("empLastName", getEmpLastName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("companyName", getCompanyName());
		attributes.put("profImageId", getProfImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyEmpId = (Long)attributes.get("companyEmpId");

		if (companyEmpId != null) {
			setCompanyEmpId(companyEmpId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String empFirstName = (String)attributes.get("empFirstName");

		if (empFirstName != null) {
			setEmpFirstName(empFirstName);
		}

		String empLastName = (String)attributes.get("empLastName");

		if (empLastName != null) {
			setEmpLastName(empLastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		Long profImageId = (Long)attributes.get("profImageId");

		if (profImageId != null) {
			setProfImageId(profImageId);
		}
	}

	@Override
	public Employee cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company emp ID of this employee.
	 *
	 * @return the company emp ID of this employee
	 */
	@Override
	public long getCompanyEmpId() {
		return model.getCompanyEmpId();
	}

	/**
	 * Returns the company name of this employee.
	 *
	 * @return the company name of this employee
	 */
	@Override
	public String getCompanyName() {
		return model.getCompanyName();
	}

	/**
	 * Returns the email of this employee.
	 *
	 * @return the email of this employee
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the emp first name of this employee.
	 *
	 * @return the emp first name of this employee
	 */
	@Override
	public String getEmpFirstName() {
		return model.getEmpFirstName();
	}

	/**
	 * Returns the emp last name of this employee.
	 *
	 * @return the emp last name of this employee
	 */
	@Override
	public String getEmpLastName() {
		return model.getEmpLastName();
	}

	/**
	 * Returns the group ID of this employee.
	 *
	 * @return the group ID of this employee
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the phone of this employee.
	 *
	 * @return the phone of this employee
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prof image ID of this employee.
	 *
	 * @return the prof image ID of this employee
	 */
	@Override
	public long getProfImageId() {
		return model.getProfImageId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company emp ID of this employee.
	 *
	 * @param companyEmpId the company emp ID of this employee
	 */
	@Override
	public void setCompanyEmpId(long companyEmpId) {
		model.setCompanyEmpId(companyEmpId);
	}

	/**
	 * Sets the company name of this employee.
	 *
	 * @param companyName the company name of this employee
	 */
	@Override
	public void setCompanyName(String companyName) {
		model.setCompanyName(companyName);
	}

	/**
	 * Sets the email of this employee.
	 *
	 * @param email the email of this employee
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the emp first name of this employee.
	 *
	 * @param empFirstName the emp first name of this employee
	 */
	@Override
	public void setEmpFirstName(String empFirstName) {
		model.setEmpFirstName(empFirstName);
	}

	/**
	 * Sets the emp last name of this employee.
	 *
	 * @param empLastName the emp last name of this employee
	 */
	@Override
	public void setEmpLastName(String empLastName) {
		model.setEmpLastName(empLastName);
	}

	/**
	 * Sets the group ID of this employee.
	 *
	 * @param groupId the group ID of this employee
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the phone of this employee.
	 *
	 * @param phone the phone of this employee
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prof image ID of this employee.
	 *
	 * @param profImageId the prof image ID of this employee
	 */
	@Override
	public void setProfImageId(long profImageId) {
		model.setProfImageId(profImageId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected EmployeeWrapper wrap(Employee employee) {
		return new EmployeeWrapper(employee);
	}

}