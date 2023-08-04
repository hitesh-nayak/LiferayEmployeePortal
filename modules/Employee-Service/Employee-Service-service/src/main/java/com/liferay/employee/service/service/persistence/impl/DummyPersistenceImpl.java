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

package com.liferay.employee.service.service.persistence.impl;

import com.liferay.employee.service.exception.NoSuchDummyException;
import com.liferay.employee.service.model.Dummy;
import com.liferay.employee.service.model.DummyTable;
import com.liferay.employee.service.model.impl.DummyImpl;
import com.liferay.employee.service.model.impl.DummyModelImpl;
import com.liferay.employee.service.service.persistence.DummyPersistence;
import com.liferay.employee.service.service.persistence.DummyUtil;
import com.liferay.employee.service.service.persistence.impl.constants.CompanyPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dummy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DummyPersistence.class)
public class DummyPersistenceImpl
	extends BasePersistenceImpl<Dummy> implements DummyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DummyUtil</code> to access the dummy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DummyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the dummies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dummies
	 */
	@Override
	public List<Dummy> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dummy> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Dummy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Dummy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Dummy> list = null;

		if (useFinderCache) {
			list = (List<Dummy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dummy dummy : list) {
					if (!uuid.equals(dummy.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DummyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Dummy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByUuid_First(
			String uuid, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByUuid_First(uuid, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUuid_First(
		String uuid, OrderByComparator<Dummy> orderByComparator) {

		List<Dummy> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByUuid_Last(
			String uuid, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByUuid_Last(uuid, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUuid_Last(
		String uuid, OrderByComparator<Dummy> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Dummy> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Dummy[] findByUuid_PrevAndNext(
			long companyEmpId, String uuid,
			OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		uuid = Objects.toString(uuid, "");

		Dummy dummy = findByPrimaryKey(companyEmpId);

		Session session = null;

		try {
			session = openSession();

			Dummy[] array = new DummyImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dummy, uuid, orderByComparator, true);

			array[1] = dummy;

			array[2] = getByUuid_PrevAndNext(
				session, dummy, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dummy getByUuid_PrevAndNext(
		Session session, Dummy dummy, String uuid,
		OrderByComparator<Dummy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUMMY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DummyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dummy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Dummy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dummies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Dummy dummy :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dummies
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "dummy.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dummy.uuid IS NULL OR dummy.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByUUID_G(String uuid, long groupId)
		throws NoSuchDummyException {

		Dummy dummy = fetchByUUID_G(uuid, groupId);

		if (dummy == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDummyException(sb.toString());
		}

		return dummy;
	}

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Dummy) {
			Dummy dummy = (Dummy)result;

			if (!Objects.equals(uuid, dummy.getUuid()) ||
				(groupId != dummy.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Dummy> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Dummy dummy = list.get(0);

					result = dummy;

					cacheResult(dummy);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Dummy)result;
		}
	}

	/**
	 * Removes the dummy where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dummy that was removed
	 */
	@Override
	public Dummy removeByUUID_G(String uuid, long groupId)
		throws NoSuchDummyException {

		Dummy dummy = findByUUID_G(uuid, groupId);

		return remove(dummy);
	}

	/**
	 * Returns the number of dummies where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dummies
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"dummy.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dummy.uuid IS NULL OR dummy.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dummy.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dummies
	 */
	@Override
	public List<Dummy> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Dummy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Dummy> list = null;

		if (useFinderCache) {
			list = (List<Dummy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dummy dummy : list) {
					if (!uuid.equals(dummy.getUuid()) ||
						(companyId != dummy.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DummyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Dummy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Dummy findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator) {

		List<Dummy> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Dummy findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Dummy> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Dummy[] findByUuid_C_PrevAndNext(
			long companyEmpId, String uuid, long companyId,
			OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		uuid = Objects.toString(uuid, "");

		Dummy dummy = findByPrimaryKey(companyEmpId);

		Session session = null;

		try {
			session = openSession();

			Dummy[] array = new DummyImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dummy, uuid, companyId, orderByComparator, true);

			array[1] = dummy;

			array[2] = getByUuid_C_PrevAndNext(
				session, dummy, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dummy getByUuid_C_PrevAndNext(
		Session session, Dummy dummy, String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DUMMY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DummyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dummy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Dummy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dummies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Dummy dummy :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dummies
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"dummy.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dummy.uuid IS NULL OR dummy.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dummy.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByEmpLastName;
	private FinderPath _finderPathWithoutPaginationFindByEmpLastName;
	private FinderPath _finderPathCountByEmpLastName;

	/**
	 * Returns all the dummies where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @return the matching dummies
	 */
	@Override
	public List<Dummy> findByEmpLastName(String empLastName) {
		return findByEmpLastName(
			empLastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dummy> findByEmpLastName(
		String empLastName, int start, int end) {

		return findByEmpLastName(empLastName, start, end, null);
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
	@Override
	public List<Dummy> findByEmpLastName(
		String empLastName, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return findByEmpLastName(
			empLastName, start, end, orderByComparator, true);
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
	@Override
	public List<Dummy> findByEmpLastName(
		String empLastName, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		empLastName = Objects.toString(empLastName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmpLastName;
				finderArgs = new Object[] {empLastName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmpLastName;
			finderArgs = new Object[] {
				empLastName, start, end, orderByComparator
			};
		}

		List<Dummy> list = null;

		if (useFinderCache) {
			list = (List<Dummy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dummy dummy : list) {
					if (!empLastName.equals(dummy.getEmpLastName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindEmpLastName = false;

			if (empLastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLASTNAME_EMPLASTNAME_3);
			}
			else {
				bindEmpLastName = true;

				sb.append(_FINDER_COLUMN_EMPLASTNAME_EMPLASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DummyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmpLastName) {
					queryPos.add(empLastName);
				}

				list = (List<Dummy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByEmpLastName_First(
			String empLastName, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByEmpLastName_First(empLastName, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("empLastName=");
		sb.append(empLastName);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the first dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByEmpLastName_First(
		String empLastName, OrderByComparator<Dummy> orderByComparator) {

		List<Dummy> list = findByEmpLastName(
			empLastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByEmpLastName_Last(
			String empLastName, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByEmpLastName_Last(empLastName, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("empLastName=");
		sb.append(empLastName);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the last dummy in the ordered set where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByEmpLastName_Last(
		String empLastName, OrderByComparator<Dummy> orderByComparator) {

		int count = countByEmpLastName(empLastName);

		if (count == 0) {
			return null;
		}

		List<Dummy> list = findByEmpLastName(
			empLastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Dummy[] findByEmpLastName_PrevAndNext(
			long companyEmpId, String empLastName,
			OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		empLastName = Objects.toString(empLastName, "");

		Dummy dummy = findByPrimaryKey(companyEmpId);

		Session session = null;

		try {
			session = openSession();

			Dummy[] array = new DummyImpl[3];

			array[0] = getByEmpLastName_PrevAndNext(
				session, dummy, empLastName, orderByComparator, true);

			array[1] = dummy;

			array[2] = getByEmpLastName_PrevAndNext(
				session, dummy, empLastName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dummy getByEmpLastName_PrevAndNext(
		Session session, Dummy dummy, String empLastName,
		OrderByComparator<Dummy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUMMY_WHERE);

		boolean bindEmpLastName = false;

		if (empLastName.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMPLASTNAME_EMPLASTNAME_3);
		}
		else {
			bindEmpLastName = true;

			sb.append(_FINDER_COLUMN_EMPLASTNAME_EMPLASTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DummyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmpLastName) {
			queryPos.add(empLastName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dummy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Dummy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dummies where empLastName = &#63; from the database.
	 *
	 * @param empLastName the emp last name
	 */
	@Override
	public void removeByEmpLastName(String empLastName) {
		for (Dummy dummy :
				findByEmpLastName(
					empLastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies where empLastName = &#63;.
	 *
	 * @param empLastName the emp last name
	 * @return the number of matching dummies
	 */
	@Override
	public int countByEmpLastName(String empLastName) {
		empLastName = Objects.toString(empLastName, "");

		FinderPath finderPath = _finderPathCountByEmpLastName;

		Object[] finderArgs = new Object[] {empLastName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindEmpLastName = false;

			if (empLastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLASTNAME_EMPLASTNAME_3);
			}
			else {
				bindEmpLastName = true;

				sb.append(_FINDER_COLUMN_EMPLASTNAME_EMPLASTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmpLastName) {
					queryPos.add(empLastName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLASTNAME_EMPLASTNAME_2 =
		"dummy.empLastName = ?";

	private static final String _FINDER_COLUMN_EMPLASTNAME_EMPLASTNAME_3 =
		"(dummy.empLastName IS NULL OR dummy.empLastName = '')";

	private FinderPath _finderPathFetchByCompanyEmpId;
	private FinderPath _finderPathCountByCompanyEmpId;

	/**
	 * Returns the dummy where companyEmpId = &#63; or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByCompanyEmpId(long companyEmpId)
		throws NoSuchDummyException {

		Dummy dummy = fetchByCompanyEmpId(companyEmpId);

		if (dummy == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyEmpId=");
			sb.append(companyEmpId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDummyException(sb.toString());
		}

		return dummy;
	}

	/**
	 * Returns the dummy where companyEmpId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByCompanyEmpId(long companyEmpId) {
		return fetchByCompanyEmpId(companyEmpId, true);
	}

	/**
	 * Returns the dummy where companyEmpId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyEmpId the company emp ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByCompanyEmpId(
		long companyEmpId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyEmpId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCompanyEmpId, finderArgs, this);
		}

		if (result instanceof Dummy) {
			Dummy dummy = (Dummy)result;

			if (companyEmpId != dummy.getCompanyEmpId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DUMMY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYEMPID_COMPANYEMPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyEmpId);

				List<Dummy> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCompanyEmpId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {companyEmpId};
							}

							_log.warn(
								"DummyPersistenceImpl.fetchByCompanyEmpId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Dummy dummy = list.get(0);

					result = dummy;

					cacheResult(dummy);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Dummy)result;
		}
	}

	/**
	 * Removes the dummy where companyEmpId = &#63; from the database.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the dummy that was removed
	 */
	@Override
	public Dummy removeByCompanyEmpId(long companyEmpId)
		throws NoSuchDummyException {

		Dummy dummy = findByCompanyEmpId(companyEmpId);

		return remove(dummy);
	}

	/**
	 * Returns the number of dummies where companyEmpId = &#63;.
	 *
	 * @param companyEmpId the company emp ID
	 * @return the number of matching dummies
	 */
	@Override
	public int countByCompanyEmpId(long companyEmpId) {
		FinderPath finderPath = _finderPathCountByCompanyEmpId;

		Object[] finderArgs = new Object[] {companyEmpId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUMMY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYEMPID_COMPANYEMPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyEmpId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYEMPID_COMPANYEMPID_2 =
		"dummy.companyEmpId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyName;
	private FinderPath _finderPathWithoutPaginationFindByCompanyName;
	private FinderPath _finderPathCountByCompanyName;

	/**
	 * Returns all the dummies where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @return the matching dummies
	 */
	@Override
	public List<Dummy> findByCompanyName(String companyName) {
		return findByCompanyName(
			companyName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dummy> findByCompanyName(
		String companyName, int start, int end) {

		return findByCompanyName(companyName, start, end, null);
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
	@Override
	public List<Dummy> findByCompanyName(
		String companyName, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return findByCompanyName(
			companyName, start, end, orderByComparator, true);
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
	@Override
	public List<Dummy> findByCompanyName(
		String companyName, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		companyName = Objects.toString(companyName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyName;
				finderArgs = new Object[] {companyName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyName;
			finderArgs = new Object[] {
				companyName, start, end, orderByComparator
			};
		}

		List<Dummy> list = null;

		if (useFinderCache) {
			list = (List<Dummy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dummy dummy : list) {
					if (!companyName.equals(dummy.getCompanyName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindCompanyName = false;

			if (companyName.isEmpty()) {
				sb.append(_FINDER_COLUMN_COMPANYNAME_COMPANYNAME_3);
			}
			else {
				bindCompanyName = true;

				sb.append(_FINDER_COLUMN_COMPANYNAME_COMPANYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DummyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCompanyName) {
					queryPos.add(companyName);
				}

				list = (List<Dummy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByCompanyName_First(
			String companyName, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByCompanyName_First(companyName, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyName=");
		sb.append(companyName);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the first dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByCompanyName_First(
		String companyName, OrderByComparator<Dummy> orderByComparator) {

		List<Dummy> list = findByCompanyName(
			companyName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByCompanyName_Last(
			String companyName, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByCompanyName_Last(companyName, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyName=");
		sb.append(companyName);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the last dummy in the ordered set where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByCompanyName_Last(
		String companyName, OrderByComparator<Dummy> orderByComparator) {

		int count = countByCompanyName(companyName);

		if (count == 0) {
			return null;
		}

		List<Dummy> list = findByCompanyName(
			companyName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Dummy[] findByCompanyName_PrevAndNext(
			long companyEmpId, String companyName,
			OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		companyName = Objects.toString(companyName, "");

		Dummy dummy = findByPrimaryKey(companyEmpId);

		Session session = null;

		try {
			session = openSession();

			Dummy[] array = new DummyImpl[3];

			array[0] = getByCompanyName_PrevAndNext(
				session, dummy, companyName, orderByComparator, true);

			array[1] = dummy;

			array[2] = getByCompanyName_PrevAndNext(
				session, dummy, companyName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dummy getByCompanyName_PrevAndNext(
		Session session, Dummy dummy, String companyName,
		OrderByComparator<Dummy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUMMY_WHERE);

		boolean bindCompanyName = false;

		if (companyName.isEmpty()) {
			sb.append(_FINDER_COLUMN_COMPANYNAME_COMPANYNAME_3);
		}
		else {
			bindCompanyName = true;

			sb.append(_FINDER_COLUMN_COMPANYNAME_COMPANYNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DummyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCompanyName) {
			queryPos.add(companyName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dummy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Dummy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dummies where companyName = &#63; from the database.
	 *
	 * @param companyName the company name
	 */
	@Override
	public void removeByCompanyName(String companyName) {
		for (Dummy dummy :
				findByCompanyName(
					companyName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies where companyName = &#63;.
	 *
	 * @param companyName the company name
	 * @return the number of matching dummies
	 */
	@Override
	public int countByCompanyName(String companyName) {
		companyName = Objects.toString(companyName, "");

		FinderPath finderPath = _finderPathCountByCompanyName;

		Object[] finderArgs = new Object[] {companyName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindCompanyName = false;

			if (companyName.isEmpty()) {
				sb.append(_FINDER_COLUMN_COMPANYNAME_COMPANYNAME_3);
			}
			else {
				bindCompanyName = true;

				sb.append(_FINDER_COLUMN_COMPANYNAME_COMPANYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCompanyName) {
					queryPos.add(companyName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYNAME_COMPANYNAME_2 =
		"dummy.companyName = ?";

	private static final String _FINDER_COLUMN_COMPANYNAME_COMPANYNAME_3 =
		"(dummy.companyName IS NULL OR dummy.companyName = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the dummies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dummies
	 */
	@Override
	public List<Dummy> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dummy> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Dummy> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Dummy> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Dummy> list = null;

		if (useFinderCache) {
			list = (List<Dummy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dummy dummy : list) {
					if (groupId != dummy.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DUMMY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DummyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Dummy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByGroupId_First(
			long groupId, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByGroupId_First(groupId, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the first dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByGroupId_First(
		long groupId, OrderByComparator<Dummy> orderByComparator) {

		List<Dummy> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByGroupId_Last(
			long groupId, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = fetchByGroupId_Last(groupId, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDummyException(sb.toString());
	}

	/**
	 * Returns the last dummy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByGroupId_Last(
		long groupId, OrderByComparator<Dummy> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Dummy> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Dummy[] findByGroupId_PrevAndNext(
			long companyEmpId, long groupId,
			OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {

		Dummy dummy = findByPrimaryKey(companyEmpId);

		Session session = null;

		try {
			session = openSession();

			Dummy[] array = new DummyImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, dummy, groupId, orderByComparator, true);

			array[1] = dummy;

			array[2] = getByGroupId_PrevAndNext(
				session, dummy, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dummy getByGroupId_PrevAndNext(
		Session session, Dummy dummy, long groupId,
		OrderByComparator<Dummy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUMMY_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DummyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dummy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Dummy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dummies where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Dummy dummy :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dummies
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUMMY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"dummy.groupId = ?";

	public DummyPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Dummy.class);

		setModelImplClass(DummyImpl.class);
		setModelPKClass(long.class);

		setTable(DummyTable.INSTANCE);
	}

	/**
	 * Caches the dummy in the entity cache if it is enabled.
	 *
	 * @param dummy the dummy
	 */
	@Override
	public void cacheResult(Dummy dummy) {
		entityCache.putResult(DummyImpl.class, dummy.getPrimaryKey(), dummy);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {dummy.getUuid(), dummy.getGroupId()}, dummy);

		finderCache.putResult(
			_finderPathFetchByCompanyEmpId,
			new Object[] {dummy.getCompanyEmpId()}, dummy);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dummies in the entity cache if it is enabled.
	 *
	 * @param dummies the dummies
	 */
	@Override
	public void cacheResult(List<Dummy> dummies) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dummies.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Dummy dummy : dummies) {
			if (entityCache.getResult(DummyImpl.class, dummy.getPrimaryKey()) ==
					null) {

				cacheResult(dummy);
			}
		}
	}

	/**
	 * Clears the cache for all dummies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DummyImpl.class);

		finderCache.clearCache(DummyImpl.class);
	}

	/**
	 * Clears the cache for the dummy.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dummy dummy) {
		entityCache.removeResult(DummyImpl.class, dummy);
	}

	@Override
	public void clearCache(List<Dummy> dummies) {
		for (Dummy dummy : dummies) {
			entityCache.removeResult(DummyImpl.class, dummy);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DummyImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DummyImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(DummyModelImpl dummyModelImpl) {
		Object[] args = new Object[] {
			dummyModelImpl.getUuid(), dummyModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, dummyModelImpl);

		args = new Object[] {dummyModelImpl.getCompanyEmpId()};

		finderCache.putResult(
			_finderPathCountByCompanyEmpId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCompanyEmpId, args, dummyModelImpl);
	}

	/**
	 * Creates a new dummy with the primary key. Does not add the dummy to the database.
	 *
	 * @param companyEmpId the primary key for the new dummy
	 * @return the new dummy
	 */
	@Override
	public Dummy create(long companyEmpId) {
		Dummy dummy = new DummyImpl();

		dummy.setNew(true);
		dummy.setPrimaryKey(companyEmpId);

		String uuid = _portalUUID.generate();

		dummy.setUuid(uuid);

		dummy.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dummy;
	}

	/**
	 * Removes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy that was removed
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy remove(long companyEmpId) throws NoSuchDummyException {
		return remove((Serializable)companyEmpId);
	}

	/**
	 * Removes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dummy
	 * @return the dummy that was removed
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy remove(Serializable primaryKey) throws NoSuchDummyException {
		Session session = null;

		try {
			session = openSession();

			Dummy dummy = (Dummy)session.get(DummyImpl.class, primaryKey);

			if (dummy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDummyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dummy);
		}
		catch (NoSuchDummyException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Dummy removeImpl(Dummy dummy) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dummy)) {
				dummy = (Dummy)session.get(
					DummyImpl.class, dummy.getPrimaryKeyObj());
			}

			if (dummy != null) {
				session.delete(dummy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dummy != null) {
			clearCache(dummy);
		}

		return dummy;
	}

	@Override
	public Dummy updateImpl(Dummy dummy) {
		boolean isNew = dummy.isNew();

		if (!(dummy instanceof DummyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dummy.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dummy);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dummy proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Dummy implementation " +
					dummy.getClass());
		}

		DummyModelImpl dummyModelImpl = (DummyModelImpl)dummy;

		if (Validator.isNull(dummy.getUuid())) {
			String uuid = _portalUUID.generate();

			dummy.setUuid(uuid);
		}

		if (isNew && (dummy.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dummy.setCreateDate(date);
			}
			else {
				dummy.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dummy);
			}
			else {
				dummy = (Dummy)session.merge(dummy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DummyImpl.class, dummyModelImpl, false, true);

		cacheUniqueFindersCache(dummyModelImpl);

		if (isNew) {
			dummy.setNew(false);
		}

		dummy.resetOriginalValues();

		return dummy;
	}

	/**
	 * Returns the dummy with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dummy
	 * @return the dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDummyException {

		Dummy dummy = fetchByPrimaryKey(primaryKey);

		if (dummy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDummyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dummy;
	}

	/**
	 * Returns the dummy with the primary key or throws a <code>NoSuchDummyException</code> if it could not be found.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy findByPrimaryKey(long companyEmpId)
		throws NoSuchDummyException {

		return findByPrimaryKey((Serializable)companyEmpId);
	}

	/**
	 * Returns the dummy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy, or <code>null</code> if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy fetchByPrimaryKey(long companyEmpId) {
		return fetchByPrimaryKey((Serializable)companyEmpId);
	}

	/**
	 * Returns all the dummies.
	 *
	 * @return the dummies
	 */
	@Override
	public List<Dummy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dummy> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Dummy> findAll(
		int start, int end, OrderByComparator<Dummy> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Dummy> findAll(
		int start, int end, OrderByComparator<Dummy> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Dummy> list = null;

		if (useFinderCache) {
			list = (List<Dummy>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DUMMY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DUMMY;

				sql = sql.concat(DummyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Dummy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dummies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Dummy dummy : findAll()) {
			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies.
	 *
	 * @return the number of dummies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DUMMY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "companyEmpId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DUMMY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DummyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dummy persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByEmpLastName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmpLastName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"empLastName"}, true);

		_finderPathWithoutPaginationFindByEmpLastName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmpLastName",
			new String[] {String.class.getName()}, new String[] {"empLastName"},
			true);

		_finderPathCountByEmpLastName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmpLastName",
			new String[] {String.class.getName()}, new String[] {"empLastName"},
			false);

		_finderPathFetchByCompanyEmpId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCompanyEmpId",
			new String[] {Long.class.getName()}, new String[] {"companyEmpId"},
			true);

		_finderPathCountByCompanyEmpId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyEmpId",
			new String[] {Long.class.getName()}, new String[] {"companyEmpId"},
			false);

		_finderPathWithPaginationFindByCompanyName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyName"}, true);

		_finderPathWithoutPaginationFindByCompanyName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyName",
			new String[] {String.class.getName()}, new String[] {"companyName"},
			true);

		_finderPathCountByCompanyName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyName",
			new String[] {String.class.getName()}, new String[] {"companyName"},
			false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_setDummyUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDummyUtilPersistence(null);

		entityCache.removeCache(DummyImpl.class.getName());
	}

	private void _setDummyUtilPersistence(DummyPersistence dummyPersistence) {
		try {
			Field field = DummyUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, dummyPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CompanyPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CompanyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CompanyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DUMMY =
		"SELECT dummy FROM Dummy dummy";

	private static final String _SQL_SELECT_DUMMY_WHERE =
		"SELECT dummy FROM Dummy dummy WHERE ";

	private static final String _SQL_COUNT_DUMMY =
		"SELECT COUNT(dummy) FROM Dummy dummy";

	private static final String _SQL_COUNT_DUMMY_WHERE =
		"SELECT COUNT(dummy) FROM Dummy dummy WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dummy.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Dummy exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Dummy exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DummyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}