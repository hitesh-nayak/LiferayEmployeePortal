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

import com.liferay.employee.service.exception.NoSuchDummyException;
import com.liferay.employee.service.model.Dummy;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dummy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyUtil
 * @generated
 */
@ProviderType
public interface DummyPersistence extends BasePersistence<Dummy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DummyUtil} to access the dummy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dummies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dummies
	 */
	public java.util.List<Dummy> findByUuid(String uuid);

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
	public java.util.List<Dummy> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Dummy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

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
	public java.util.List<Dummy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where uuid = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public Dummy[] findByUuid_PrevAndNext(
			long companyEmpId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Removes all the dummies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dummies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dummies
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByUUID_G(String uuid, long groupId)
		throws NoSuchDummyException;

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dummy where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dummy that was removed
	 */
	public Dummy removeByUUID_G(String uuid, long groupId)
		throws NoSuchDummyException;

	/**
	 * Returns the number of dummies where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dummies
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dummies
	 */
	public java.util.List<Dummy> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

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
	public java.util.List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

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
	public Dummy[] findByUuid_C_PrevAndNext(
			long companyEmpId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Removes all the dummies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dummies
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the dummies where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @return the matching dummies
	 */
	public java.util.List<Dummy> findByEmpLastName(String empLastName);

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
	public java.util.List<Dummy> findByEmpLastName(
		String empLastName, int start, int end);

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
	public java.util.List<Dummy> findByEmpLastName(
		String empLastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

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
	public java.util.List<Dummy> findByEmpLastName(
		String empLastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByEmpLastName_First(
			String empLastName,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the first dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByEmpLastName_First(
		String empLastName,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the last dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByEmpLastName_Last(
			String empLastName,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the last dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByEmpLastName_Last(
		String empLastName,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public Dummy[] findByEmpLastName_PrevAndNext(
			long companyEmpId, String empLastName,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Removes all the dummies where empLastName = &#63; from the database.
	 *
	 * @param empLastName the emp last name
	 */
	public void removeByEmpLastName(String empLastName);

	/**
	 * Returns the number of dummies where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @return the number of matching dummies
	 */
	public int countByEmpLastName(String empLastName);

	/**
	 * Returns the dummy where companyEmpId = &#63; or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByCompanyEmpId(long companyEmpId)
		throws NoSuchDummyException;

	/**
	 * Returns the dummy where companyEmpId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByCompanyEmpId(long companyEmpId);

	/**
	 * Returns the dummy where companyEmpId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyEmpId the company emp ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByCompanyEmpId(long companyEmpId, boolean useFinderCache);

	/**
	 * Removes the dummy where companyEmpId = &#63; from the database.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the dummy that was removed
	 */
	public Dummy removeByCompanyEmpId(long companyEmpId)
		throws NoSuchDummyException;

	/**
	 * Returns the number of dummies where companyEmpId = &#63;.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the number of matching dummies
	 */
	public int countByCompanyEmpId(long companyEmpId);

	/**
	 * Returns all the dummies where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @return the matching dummies
	 */
	public java.util.List<Dummy> findByCompanyName(String companyName);

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
	public java.util.List<Dummy> findByCompanyName(
		String companyName, int start, int end);

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
	public java.util.List<Dummy> findByCompanyName(
		String companyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

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
	public java.util.List<Dummy> findByCompanyName(
		String companyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByCompanyName_First(
			String companyName,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the first dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByCompanyName_First(
		String companyName,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the last dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByCompanyName_Last(
			String companyName,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the last dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByCompanyName_Last(
		String companyName,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public Dummy[] findByCompanyName_PrevAndNext(
			long companyEmpId, String companyName,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Removes all the dummies where companyName = &#63; from the database.
	 *
	 * @param companyName the company name
	 */
	public void removeByCompanyName(String companyName);

	/**
	 * Returns the number of dummies where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @return the number of matching dummies
	 */
	public int countByCompanyName(String companyName);

	/**
	 * Returns all the dummies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dummies
	 */
	public java.util.List<Dummy> findByGroupId(long groupId);

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
	public java.util.List<Dummy> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Dummy> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

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
	public java.util.List<Dummy> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the first dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the last dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	public Dummy findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Returns the last dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	public Dummy fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where groupId = &#63;.
	 *
	 * @param companyEmpId the primary key of the current dummy
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public Dummy[] findByGroupId_PrevAndNext(
			long companyEmpId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Dummy>
				orderByComparator)
		throws NoSuchDummyException;

	/**
	 * Removes all the dummies where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of dummies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dummies
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the dummy in the entity cache if it is enabled.
	 *
	 * @param dummy the dummy
	 */
	public void cacheResult(Dummy dummy);

	/**
	 * Caches the dummies in the entity cache if it is enabled.
	 *
	 * @param dummies the dummies
	 */
	public void cacheResult(java.util.List<Dummy> dummies);

	/**
	 * Creates a new dummy with the primary key. Does not add the dummy to the database.
	 *
	 * @param companyEmpId the primary key for the new dummy
	 * @return the new dummy
	 */
	public Dummy create(long companyEmpId);

	/**
	 * Removes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy that was removed
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public Dummy remove(long companyEmpId) throws NoSuchDummyException;

	public Dummy updateImpl(Dummy dummy);

	/**
	 * Returns the dummy with the primary key or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	public Dummy findByPrimaryKey(long companyEmpId)
		throws NoSuchDummyException;

	/**
	 * Returns the dummy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy, or <code>null</code> if a dummy with the primary key could not be found
	 */
	public Dummy fetchByPrimaryKey(long companyEmpId);

	/**
	 * Returns all the dummies.
	 *
	 * @return the dummies
	 */
	public java.util.List<Dummy> findAll();

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
	public java.util.List<Dummy> findAll(int start, int end);

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
	public java.util.List<Dummy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator);

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
	public java.util.List<Dummy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dummies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dummies.
	 *
	 * @return the number of dummies
	 */
	public int countAll();

}