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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Dummy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Dummy
 * @generated
 */
public class DummyWrapper
	extends BaseModelWrapper<Dummy> implements Dummy, ModelWrapper<Dummy> {

	public DummyWrapper(Dummy dummy) {
		super(dummy);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyEmpId", getCompanyEmpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("empFirstName", getEmpFirstName());
		attributes.put("empLastName", getEmpLastName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("companyName", getCompanyName());
		attributes.put("profImageId", getProfImageId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long companyEmpId = (Long)attributes.get("companyEmpId");

		if (companyEmpId != null) {
			setCompanyEmpId(companyEmpId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public Dummy cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company emp ID of this dummy.
	 *
	 * @return the company emp ID of this dummy
	 */
	@Override
	public long getCompanyEmpId() {
		return model.getCompanyEmpId();
	}

	/**
	 * Returns the company ID of this dummy.
	 *
	 * @return the company ID of this dummy
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the company name of this dummy.
	 *
	 * @return the company name of this dummy
	 */
	@Override
	public String getCompanyName() {
		return model.getCompanyName();
	}

	/**
	 * Returns the create date of this dummy.
	 *
	 * @return the create date of this dummy
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this dummy.
	 *
	 * @return the email of this dummy
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the emp first name of this dummy.
	 *
	 * @return the emp first name of this dummy
	 */
	@Override
	public String getEmpFirstName() {
		return model.getEmpFirstName();
	}

	/**
	 * Returns the emp last name of this dummy.
	 *
	 * @return the emp last name of this dummy
	 */
	@Override
	public String getEmpLastName() {
		return model.getEmpLastName();
	}

	/**
	 * Returns the group ID of this dummy.
	 *
	 * @return the group ID of this dummy
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the phone of this dummy.
	 *
	 * @return the phone of this dummy
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this dummy.
	 *
	 * @return the primary key of this dummy
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prof image ID of this dummy.
	 *
	 * @return the prof image ID of this dummy
	 */
	@Override
	public long getProfImageId() {
		return model.getProfImageId();
	}

	/**
	 * Returns the uuid of this dummy.
	 *
	 * @return the uuid of this dummy
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company emp ID of this dummy.
	 *
	 * @param companyEmpId the company emp ID of this dummy
	 */
	@Override
	public void setCompanyEmpId(long companyEmpId) {
		model.setCompanyEmpId(companyEmpId);
	}

	/**
	 * Sets the company ID of this dummy.
	 *
	 * @param companyId the company ID of this dummy
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the company name of this dummy.
	 *
	 * @param companyName the company name of this dummy
	 */
	@Override
	public void setCompanyName(String companyName) {
		model.setCompanyName(companyName);
	}

	/**
	 * Sets the create date of this dummy.
	 *
	 * @param createDate the create date of this dummy
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this dummy.
	 *
	 * @param email the email of this dummy
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the emp first name of this dummy.
	 *
	 * @param empFirstName the emp first name of this dummy
	 */
	@Override
	public void setEmpFirstName(String empFirstName) {
		model.setEmpFirstName(empFirstName);
	}

	/**
	 * Sets the emp last name of this dummy.
	 *
	 * @param empLastName the emp last name of this dummy
	 */
	@Override
	public void setEmpLastName(String empLastName) {
		model.setEmpLastName(empLastName);
	}

	/**
	 * Sets the group ID of this dummy.
	 *
	 * @param groupId the group ID of this dummy
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the phone of this dummy.
	 *
	 * @param phone the phone of this dummy
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this dummy.
	 *
	 * @param primaryKey the primary key of this dummy
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prof image ID of this dummy.
	 *
	 * @param profImageId the prof image ID of this dummy
	 */
	@Override
	public void setProfImageId(long profImageId) {
		model.setProfImageId(profImageId);
	}

	/**
	 * Sets the uuid of this dummy.
	 *
	 * @param uuid the uuid of this dummy
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DummyWrapper wrap(Dummy dummy) {
		return new DummyWrapper(dummy);
	}

}