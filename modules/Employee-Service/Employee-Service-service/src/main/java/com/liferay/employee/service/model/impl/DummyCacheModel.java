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

package com.liferay.employee.service.model.impl;

import com.liferay.employee.service.model.Dummy;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dummy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DummyCacheModel implements CacheModel<Dummy>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DummyCacheModel)) {
			return false;
		}

		DummyCacheModel dummyCacheModel = (DummyCacheModel)object;

		if (companyEmpId == dummyCacheModel.companyEmpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, companyEmpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", companyEmpId=");
		sb.append(companyEmpId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", empFirstName=");
		sb.append(empFirstName);
		sb.append(", empLastName=");
		sb.append(empLastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", profImageId=");
		sb.append(profImageId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dummy toEntityModel() {
		DummyImpl dummyImpl = new DummyImpl();

		if (uuid == null) {
			dummyImpl.setUuid("");
		}
		else {
			dummyImpl.setUuid(uuid);
		}

		dummyImpl.setCompanyEmpId(companyEmpId);
		dummyImpl.setGroupId(groupId);
		dummyImpl.setCompanyId(companyId);

		if (empFirstName == null) {
			dummyImpl.setEmpFirstName("");
		}
		else {
			dummyImpl.setEmpFirstName(empFirstName);
		}

		if (empLastName == null) {
			dummyImpl.setEmpLastName("");
		}
		else {
			dummyImpl.setEmpLastName(empLastName);
		}

		if (email == null) {
			dummyImpl.setEmail("");
		}
		else {
			dummyImpl.setEmail(email);
		}

		if (phone == null) {
			dummyImpl.setPhone("");
		}
		else {
			dummyImpl.setPhone(phone);
		}

		if (companyName == null) {
			dummyImpl.setCompanyName("");
		}
		else {
			dummyImpl.setCompanyName(companyName);
		}

		dummyImpl.setProfImageId(profImageId);

		if (createDate == Long.MIN_VALUE) {
			dummyImpl.setCreateDate(null);
		}
		else {
			dummyImpl.setCreateDate(new Date(createDate));
		}

		dummyImpl.resetOriginalValues();

		return dummyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		companyEmpId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		empFirstName = objectInput.readUTF();
		empLastName = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
		companyName = objectInput.readUTF();

		profImageId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(companyEmpId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (empFirstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(empFirstName);
		}

		if (empLastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(empLastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (companyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		objectOutput.writeLong(profImageId);
		objectOutput.writeLong(createDate);
	}

	public String uuid;
	public long companyEmpId;
	public long groupId;
	public long companyId;
	public String empFirstName;
	public String empLastName;
	public String email;
	public String phone;
	public String companyName;
	public long profImageId;
	public long createDate;

}