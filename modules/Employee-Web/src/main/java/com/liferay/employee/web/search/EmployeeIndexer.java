package com.liferay.employee.web.search;

import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = Indexer.class)
/**Code is non-functional in 7.4-u70 StackOverflow error*/
public class EmployeeIndexer extends BaseIndexer<Employee> {

	public static final String CLASS_NAME = Employee.class.getName();

	/**
	 * Create constants for your entity(Employee) fields that you want to provide in
	 * search parameter
	 */
	public static final String COMPANY_EMP_ID = "companyEmpId";
	public static final String EMP_FIRST_NAME = "empFirstName";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String COMPANY_NAME = "companyName";

	@Reference
	private IndexWriterHelper indexWriterHelper;

	private final static Log _log = LogFactoryUtil.getLog(EmployeeIndexer.class);

	public EmployeeIndexer() {

		/**
		 * Sets the default selected localized field names. This ensures that the
		 * localized version of the field is searched and returned.
		 */
		setDefaultSelectedFieldNames(Field.CREATE_DATE, Field.GROUP_ID, new Field(COMPANY_EMP_ID).getName(),
				Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, new Field(EMAIL).getName(), new Field(PHONE).getName(),
				new Field(COMPANY_NAME).getName(), Field.CONTENT, Field.TITLE);

		/**
		 * Makes the search results permissions-aware at search time, as well as in the
		 * index. Without this, a search query returns all matching Employees regardless
		 * of the user’s permissions on the resource.
		 */
		setPermissionAware(true);

		/**
		 * Sets filter search to true, enabling a document-by-document check of the
		 * search results’ VIEW permissions. This is redundant most of the time, but
		 * safeguards against unexpected problems like the search index becoming stale,
		 * or if permission inheritance doesn’t happen fast enough. Most of Liferay
		 * DXP’s internal apps use this setting. If not set, the indexer relies on the
		 * permissions information indexed in the search engine.
		 */
		setFilterSearch(true);
	}

	@Override
	public String getClassName() {

		return CLASS_NAME;
	}

	/**
	 * Here, you ensure that the VIEW permission on Employees can be used to find
	 * and display appropriate search results.
	 */
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK,
			String actionId) throws Exception {

		return true;
	}

	/**
	 * This method is invoked while the main search query is being constructed. The
	 * base implementation of addStatus in BaseIndexer adds the workflow status to
	 * the filter. This ensures that entities with the status STATUS_IN_TRASH aren’t
	 * added to the query. You’ll learn more about workflow later.
	 */
	@Override
	public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext)
			throws Exception {

		addStatus(contextBooleanFilter, searchContext);
	}

	/**
	 * Override postProcessSearchQuery to add clauses to the ongoing search query.
	 * It’s best to add the localized value of any full text fields that might
	 * contribute to search relevance. By specifying the localized search term, you
	 * ensure that the regular search term has the locale appended (e.g.,
	 * title_en_US). For the Employee entity, add the title field (Field.TITLE):
	 */
	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext) throws Exception {

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
	}

	/**
	 * Override the doDelete() method, which deletes the document corresponding to
	 * the Employee object parameter. Call BaseIndexer’s deleteDocument method with
	 * the Employee’s company ID and guestbook ID:
	 */

	@Override
	protected void doDelete(Employee object) throws Exception {

		deleteDocument(object.getCompanyId(), object.getCompanyEmpId());
	}

	/**
	 * Implement the doGetDocument method to select the entity’s fields to build a
	 * search document that’s indexed by the search engine. The main searchable
	 * field for Employee is the Employee first name, which is stored in a guestbook
	 * search document’s title field:
	 */
	@Override
	protected Document doGetDocument(Employee object) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, object);
		document.addDate(Field.CREATE_DATE, object.getCreateDate());
		Locale defaultLocale = PortalUtil.getSiteDefaultLocale(object.getGroupId());
		String localizedField = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());
		document.addText(localizedField, object.getEmpFirstName());
		return document;
	}

	/**
	 * Implement the doGetSummary method to return a summary. A summary is a
	 * condensed, text-based version of the entity that can be displayed
	 * generically. You create it by combining key parts of the entity’s data so
	 * users can browse through search results to find the entity they want. Call
	 * BaseIndexer’s createSummary method, then use summary.setMaxContentLength to
	 * set the summary content’s maximum size. Most Liferay DXP applications use a
	 * value of 200, so it’s a good idea to use the same to ensure uniform result
	 * summaries:
	 */
	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		doReindex(EmployeeLocalServiceUtil.getEmployee(classPK));

	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEmployees(companyId);

	}

	/**
	 * Override the overloaded doReindex method, which gets called when an entity is
	 * updated or a user explicitly triggers a reindex. The first doReindex method
	 * takes a single object argument. Retrieve the associated document with
	 * BaseIndexer’s getDocument method, then invoke IndexWriterHelper’s
	 * updateDocument method to update (reindex) the document:
	 */
	@Override
	protected void doReindex(Employee object) throws Exception {

		Document document = getDocument(object);
		indexWriterHelper.updateDocument(object.getCompanyId(), document);

	}

	/**
	 * To reindex Employees, provide the helper method. In this
	 * method, use an actionable dynamic query helper method to retrieve all the
	 * employees in the Liferay DXP instance. Service Builder generated this query
	 * method for you when you built the services. Each employee’s document is then
	 * retrieved and added to a collection:
	 */

	protected void reindexEmployees(long companyId) throws PortalException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = EmployeeLocalServiceUtil
				.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		indexableActionableDynamicQuery.setPerformActionMethod(

				new ActionableDynamicQuery.PerformActionMethod<Employee>() {
					@Override
					public void performAction(Employee employee) {
						try {
							Document document = getDocument(employee);
							indexableActionableDynamicQuery.addDocuments(document);
						} catch (PortalException pe) {
							if (_log.isWarnEnabled()) {
								_log.warn("Unable to index Employee " + employee.getCompanyEmpId(), pe);
							}
						}
					}
				});
		indexableActionableDynamicQuery.performActions();

	}

}
