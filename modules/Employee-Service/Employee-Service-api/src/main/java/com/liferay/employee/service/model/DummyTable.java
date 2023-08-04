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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Company_Dummy&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Dummy
 * @generated
 */
public class DummyTable extends BaseTable<DummyTable> {

	public static final DummyTable INSTANCE = new DummyTable();

	public final Column<DummyTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DummyTable, Long> companyEmpId = createColumn(
		"companyEmpId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DummyTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DummyTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DummyTable, String> empFirstName = createColumn(
		"empFirstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DummyTable, String> empLastName = createColumn(
		"empLastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DummyTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DummyTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DummyTable, String> companyName = createColumn(
		"companyName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DummyTable, Long> profImageId = createColumn(
		"profImageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DummyTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DummyTable() {
		super("Company_Dummy", DummyTable::new);
	}

}