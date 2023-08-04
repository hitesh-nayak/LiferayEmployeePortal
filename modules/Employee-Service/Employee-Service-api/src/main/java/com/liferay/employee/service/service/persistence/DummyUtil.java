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

package com.liferay.employee.service.service.persistence;

import com.liferay.employee.service.model.Dummy;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dummy service. This utility wraps <code>com.liferay.employee.service.service.persistence.impl.DummyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyPersistence
 * @generated
 */
public class DummyUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Dummy dummy) {
		getPersistence().clearCache(dummy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Dummy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Dummy> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dummy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dummy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Dummy update(Dummy dummy) {
		return getPersistence().update(dummy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Dummy update(Dummy dummy, ServiceContext serviceContext) {
		return getPersistence().update(dummy, serviceContext);
	}

	/**
	 * Returns all the dummies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dummies
	 */
	public static List<Dummy> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the dummies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of matching dummies
	 */
	public static List<Dummy> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the dummies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dummies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByUuid_First(
			String uuid, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByUuid_First(
		String uuid, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByUuid_Last(
			String uuid, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByUuid_Last(
		String uuid, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where uuid = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public static Dummy[] findByUuid_PrevAndNext(
			long companyEmpId, String uuid,
			OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByUuid_PrevAndNext(
			companyEmpId, uuid, orderByComparator);
	}

	/**
	 * Removes all the dummies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of dummies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dummies
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByUUID_G(String uuid, long groupId)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the dummy where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dummy that was removed
	 */
	public static Dummy removeByUUID_G(String uuid, long groupId)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of dummies where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dummies
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dummies
	 */
	public static List<Dummy> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of matching dummies
	 */
	public static List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public static Dummy[] findByUuid_C_PrevAndNext(
			long companyEmpId, String uuid, long companyId,
			OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByUuid_C_PrevAndNext(
			companyEmpId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the dummies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dummies
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the dummies where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @return the matching dummies
	 */
	public static List<Dummy> findByEmpLastName(String empLastName) {
		return getPersistence().findByEmpLastName(empLastName);
	}

	/**
	 * Returns a range of all the dummies where empLastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param empLastName the emp last name
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of matching dummies
	 */
	public static List<Dummy> findByEmpLastName(
		String empLastName, int start, int end) {

		return getPersistence().findByEmpLastName(empLastName, start, end);
	}

	/**
	 * Returns an ordered range of all the dummies where empLastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param empLastName the emp last name
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByEmpLastName(
		String empLastName, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().findByEmpLastName(
			empLastName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dummies where empLastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param empLastName the emp last name
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByEmpLastName(
		String empLastName, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEmpLastName(
			empLastName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByEmpLastName_First(
			String empLastName, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByEmpLastName_First(
			empLastName, orderByComparator);
	}

	/**
	 * Returns the first dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByEmpLastName_First(
		String empLastName, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByEmpLastName_First(
			empLastName, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByEmpLastName_Last(
			String empLastName, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByEmpLastName_Last(
			empLastName, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByEmpLastName_Last(
		String empLastName, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByEmpLastName_Last(
			empLastName, orderByComparator);
	}

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public static Dummy[] findByEmpLastName_PrevAndNext(
			long companyEmpId, String empLastName,
			OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByEmpLastName_PrevAndNext(
			companyEmpId, empLastName, orderByComparator);
	}

	/**
	 * Removes all the dummies where empLastName = &#63; from the database.
	 *
	 * @param empLastName the emp last name
	 */
	public static void removeByEmpLastName(String empLastName) {
		getPersistence().removeByEmpLastName(empLastName);
	}

	/**
	 * Returns the number of dummies where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @return the number of matching dummies
	 */
	public static int countByEmpLastName(String empLastName) {
		return getPersistence().countByEmpLastName(empLastName);
	}

	/**
	 * Returns the dummy where companyEmpId = &#63; or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByCompanyEmpId(long companyEmpId)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByCompanyEmpId(companyEmpId);
	}

	/**
	 * Returns the dummy where companyEmpId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByCompanyEmpId(long companyEmpId) {
		return getPersistence().fetchByCompanyEmpId(companyEmpId);
	}

	/**
	 * Returns the dummy where companyEmpId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyEmpId the company emp ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByCompanyEmpId(
		long companyEmpId, boolean useFinderCache) {

		return getPersistence().fetchByCompanyEmpId(
			companyEmpId, useFinderCache);
	}

	/**
	 * Removes the dummy where companyEmpId = &#63; from the database.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the dummy that was removed
	 */
	public static Dummy removeByCompanyEmpId(long companyEmpId)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().removeByCompanyEmpId(companyEmpId);
	}

	/**
	 * Returns the number of dummies where companyEmpId = &#63;.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the number of matching dummies
	 */
	public static int countByCompanyEmpId(long companyEmpId) {
		return getPersistence().countByCompanyEmpId(companyEmpId);
	}

	/**
	 * Returns all the dummies where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @return the matching dummies
	 */
	public static List<Dummy> findByCompanyName(String companyName) {
		return getPersistence().findByCompanyName(companyName);
	}

	/**
	 * Returns a range of all the dummies where companyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param companyName the company name
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of matching dummies
	 */
	public static List<Dummy> findByCompanyName(
		String companyName, int start, int end) {

		return getPersistence().findByCompanyName(companyName, start, end);
	}

	/**
	 * Returns an ordered range of all the dummies where companyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param companyName the company name
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByCompanyName(
		String companyName, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().findByCompanyName(
			companyName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dummies where companyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param companyName the company name
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByCompanyName(
		String companyName, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyName(
			companyName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByCompanyName_First(
			String companyName, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByCompanyName_First(
			companyName, orderByComparator);
	}

	/**
	 * Returns the first dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByCompanyName_First(
		String companyName, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByCompanyName_First(
			companyName, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByCompanyName_Last(
			String companyName, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByCompanyName_Last(
			companyName, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByCompanyName_Last(
		String companyName, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByCompanyName_Last(
			companyName, orderByComparator);
	}

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public static Dummy[] findByCompanyName_PrevAndNext(
			long companyEmpId, String companyName,
			OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByCompanyName_PrevAndNext(
			companyEmpId, companyName, orderByComparator);
	}

	/**
	 * Removes all the dummies where companyName = &#63; from the database.
	 *
	 * @param companyName the company name
	 */
	public static void removeByCompanyName(String companyName) {
		getPersistence().removeByCompanyName(companyName);
	}

	/**
	 * Returns the number of dummies where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @return the number of matching dummies
	 */
	public static int countByCompanyName(String companyName) {
		return getPersistence().countByCompanyName(companyName);
	}

	/**
	 * Returns all the dummies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dummies
	 */
	public static List<Dummy> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the dummies where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of matching dummies
	 */
	public static List<Dummy> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the dummies where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dummies where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dummies
	 */
	public static List<Dummy> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByGroupId_First(
			long groupId, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByGroupId_First(
		long groupId, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public static Dummy findByGroupId_Last(
			long groupId, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public static Dummy fetchByGroupId_Last(
		long groupId, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where groupId = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public static Dummy[] findByGroupId_PrevAndNext(
			long companyEmpId, long groupId,
			OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByGroupId_PrevAndNext(
			companyEmpId, groupId, orderByComparator);
	}

	/**
	 * Removes all the dummies where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of dummies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dummies
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the dummy in the entity cache if it is enabled.
	 *
	 * @param dummy the dummy
	 */
	public static void cacheResult(Dummy dummy) {
		getPersistence().cacheResult(dummy);
	}

	/**
	 * Caches the dummies in the entity cache if it is enabled.
	 *
	 * @param dummies the dummies
	 */
	public static void cacheResult(List<Dummy> dummies) {
		getPersistence().cacheResult(dummies);
	}

	/**
	 * Creates a new dummy with the primary key. Does not add the dummy to the database.
	 *
	 * @param companyEmpId the primary key for the new dummy
	 * @return the new dummy
	 */
	public static Dummy create(long companyEmpId) {
		return getPersistence().create(companyEmpId);
	}

	/**
	 * Removes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy that was removed
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public static Dummy remove(long companyEmpId)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().remove(companyEmpId);
	}

	public static Dummy updateImpl(Dummy dummy) {
		return getPersistence().updateImpl(dummy);
	}

	/**
	 * Returns the dummy with the primary key or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public static Dummy findByPrimaryKey(long companyEmpId)
		throws com.liferay.employee.service.exception.NoSuchDummyException {

		return getPersistence().findByPrimaryKey(companyEmpId);
	}

	/**
	 * Returns the dummy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy, or <code>null</code> if a dummy with the primary key could not be found
	 */
	public static Dummy fetchByPrimaryKey(long companyEmpId) {
		return getPersistence().fetchByPrimaryKey(companyEmpId);
	}

	/**
	 * Returns all the dummies.
	 *
	 * @return the dummies
	 */
	public static List<Dummy> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dummies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of dummies
	 */
	public static List<Dummy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dummies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dummies
	 */
	public static List<Dummy> findAll(
		int start, int end, OrderByComparator<Dummy> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dummies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DummyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dummies
	 */
	public static List<Dummy> findAll(
		int start, int end, OrderByComparator<Dummy> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dummies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dummies.
	 *
	 * @return the number of dummies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DummyPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DummyPersistence _persistence;

}