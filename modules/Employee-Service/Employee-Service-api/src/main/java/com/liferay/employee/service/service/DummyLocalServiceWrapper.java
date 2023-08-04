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

package com.liferay.employee.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DummyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DummyLocalService
 * @generated
 */
public class DummyLocalServiceWrapper
	implements DummyLocalService, ServiceWrapper<DummyLocalService> {

	public DummyLocalServiceWrapper() {
		this(null);
	}

	public DummyLocalServiceWrapper(DummyLocalService dummyLocalService) {
		_dummyLocalService = dummyLocalService;
	}

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
	@Override
	public com.liferay.employee.service.model.Dummy addDummy(
		com.liferay.employee.service.model.Dummy dummy) {

		return _dummyLocalService.addDummy(dummy);
	}

	/**
	 * Creates a new dummy with the primary key. Does not add the dummy to the database.
	 *
	 * @param companyEmpId the primary key for the new dummy
	 * @return the new dummy
	 */
	@Override
	public com.liferay.employee.service.model.Dummy createDummy(
		long companyEmpId) {

		return _dummyLocalService.createDummy(companyEmpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dummyLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.liferay.employee.service.model.Dummy deleteDummy(
		com.liferay.employee.service.model.Dummy dummy) {

		return _dummyLocalService.deleteDummy(dummy);
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
	@Override
	public com.liferay.employee.service.model.Dummy deleteDummy(
			long companyEmpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dummyLocalService.deleteDummy(companyEmpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dummyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dummyLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dummyLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dummyLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dummyLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dummyLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dummyLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dummyLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _dummyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.employee.service.model.Dummy fetchDummy(
		long companyEmpId) {

		return _dummyLocalService.fetchDummy(companyEmpId);
	}

	/**
	 * Returns the dummy matching the UUID and group.
	 *
	 * @param uuid the dummy's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public com.liferay.employee.service.model.Dummy fetchDummyByUuidAndGroupId(
		String uuid, long groupId) {

		return _dummyLocalService.fetchDummyByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dummyLocalService.getActionableDynamicQuery();
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
	public java.util.List<com.liferay.employee.service.model.Dummy> getDummies(
		int start, int end) {

		return _dummyLocalService.getDummies(start, end);
	}

	/**
	 * Returns all the dummies matching the UUID and company.
	 *
	 * @param uuid the UUID of the dummies
	 * @param companyId the primary key of the company
	 * @return the matching dummies, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.employee.service.model.Dummy>
		getDummiesByUuidAndCompanyId(String uuid, long companyId) {

		return _dummyLocalService.getDummiesByUuidAndCompanyId(uuid, companyId);
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
	public java.util.List<com.liferay.employee.service.model.Dummy>
		getDummiesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.employee.service.model.Dummy> orderByComparator) {

		return _dummyLocalService.getDummiesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dummies.
	 *
	 * @return the number of dummies
	 */
	@Override
	public int getDummiesCount() {
		return _dummyLocalService.getDummiesCount();
	}

	/**
	 * Returns the dummy with the primary key.
	 *
	 * @param companyEmpId the primary key of the dummy
	 * @return the dummy
	 * @throws PortalException if a dummy with the primary key could not be found
	 */
	@Override
	public com.liferay.employee.service.model.Dummy getDummy(long companyEmpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dummyLocalService.getDummy(companyEmpId);
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
	public com.liferay.employee.service.model.Dummy getDummyByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dummyLocalService.getDummyByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dummyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dummyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dummyLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.liferay.employee.service.model.Dummy updateDummy(
		com.liferay.employee.service.model.Dummy dummy) {

		return _dummyLocalService.updateDummy(dummy);
	}

	@Override
	public DummyLocalService getWrappedService() {
		return _dummyLocalService;
	}

	@Override
	public void setWrappedService(DummyLocalService dummyLocalService) {
		_dummyLocalService = dummyLocalService;
	}

	private DummyLocalService _dummyLocalService;

}