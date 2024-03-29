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

package com.liferay.employee.service.service.base;

import com.liferay.employee.service.model.Dummy;
import com.liferay.employee.service.service.DummyLocalService;
import com.liferay.employee.service.service.DummyLocalServiceUtil;
import com.liferay.employee.service.service.persistence.DummyPersistence;
import com.liferay.employee.service.service.persistence.EmployeePersistence;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the dummy local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.employee.service.service.impl.DummyLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.employee.service.service.impl.DummyLocalServiceImpl
 * @generated
 */
public abstract class DummyLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DummyLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DummyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DummyLocalServiceUtil</code>.
	 */

	/**
	 * Adds the dummy to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DummyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @return the dummy that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Dummy addDummy(Dummy dummy) {
		dummy.setNew(true);

		return dummyPersistence.update(dummy);
	}

	/**
	 * Creates a new dummy with the primary key. Does not add the dummy to the database.
	 *
	 * @param companyEmpId the primary key for the new dummy
	 * @return the new dummy
	 */
	@Override
	@Transactional(enabled = false)
	public Dummy createDummy(long companyEmpId) {
		return dummyPersistence.create(companyEmpId);
	}

	/**
	 * Deletes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DummyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy that was removed
	 * @throws PortalException if a dummy with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Dummy deleteDummy(long companyEmpId) throws PortalException {
		return dummyPersistence.remove(companyEmpId);
	}

	/**
	 * Deletes the dummy from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DummyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @return the dummy that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Dummy deleteDummy(Dummy dummy) {
		return dummyPersistence.remove(dummy);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dummyPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Dummy.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dummyPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.employee.service.model.impl.DummyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return dummyPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.employee.service.model.impl.DummyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return dummyPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dummyPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return dummyPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Dummy fetchDummy(long companyEmpId) {
		return dummyPersistence.fetchByPrimaryKey(companyEmpId);
	}

	/**
	 * Returns the dummy matching the UUID and group.
	 *
	 * @param uuid the dummy's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchDummyByUuidAndGroupId(String uuid, long groupId) {
		return dummyPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dummy with the primary key.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy
	 * @throws PortalException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy getDummy(long companyEmpId) throws PortalException {
		return dummyPersistence.findByPrimaryKey(companyEmpId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dummyLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Dummy.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("companyEmpId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(dummyLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Dummy.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"companyEmpId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(dummyLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Dummy.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("companyEmpId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dummyPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement DummyLocalServiceImpl#deleteDummy(Dummy) to avoid orphaned data");
		}

		return dummyLocalService.deleteDummy((Dummy)persistedModel);
	}

	@Override
	public BasePersistence<Dummy> getBasePersistence() {
		return dummyPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dummyPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the dummies matching the UUID and company.
	 *
	 * @param uuid the UUID of the dummies
	 * @param companyId the primary key of the company
	 * @return the matching dummies, or an empty list if no matches were found
	 */
	@Override
	public List<Dummy> getDummiesByUuidAndCompanyId(
		String uuid, long companyId) {

		return dummyPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of dummies matching the UUID and company.
	 *
	 * @param uuid the UUID of the dummies
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dummies, or an empty list if no matches were found
	 */
	@Override
	public List<Dummy> getDummiesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {

		return dummyPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the dummy matching the UUID and group.
	 *
	 * @param uuid the dummy's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dummy
	 * @throws PortalException if a matching dummy could not be found
	 */
	@Override
	public Dummy getDummyByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return dummyPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the dummies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.employee.service.model.impl.DummyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of dummies
	 */
	@Override
	public List<Dummy> getDummies(int start, int end) {
		return dummyPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dummies.
	 *
	 * @return the number of dummies
	 */
	@Override
	public int getDummiesCount() {
		return dummyPersistence.countAll();
	}

	/**
	 * Updates the dummy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DummyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @return the dummy that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Dummy updateDummy(Dummy dummy) {
		return dummyPersistence.update(dummy);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DummyLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dummyLocalService = (DummyLocalService)aopProxy;

		_setLocalServiceUtilService(dummyLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DummyLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Dummy.class;
	}

	protected String getModelClassName() {
		return Dummy.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dummyPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		DummyLocalService dummyLocalService) {

		try {
			Field field = DummyLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, dummyLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected DummyLocalService dummyLocalService;

	@Reference
	protected DummyPersistence dummyPersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.GroupLocalService
		groupLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		DummyLocalServiceBaseImpl.class);

}