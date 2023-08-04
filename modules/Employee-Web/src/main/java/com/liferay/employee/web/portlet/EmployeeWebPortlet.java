package com.liferay.employee.web.portlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.adaptive.media.image.model.AMImageEntry;
import com.liferay.adaptive.media.image.service.AMImageEntryLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalService;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.employee.service.service.persistence.EmployeePersistence;
import com.liferay.employee.web.configuration.EmployeePortletConfiguration;
import com.liferay.employee.web.constants.EmployeeWebPortletKeys;
import com.liferay.headless.delivery.dto.v1_0.Document;
import com.liferay.headless.delivery.resource.v1_0.DocumentResource;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.search.query.function.score.RandomScoreFunction;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Part;
import javax.ws.rs.core.NewCookie;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(immediate = true, configurationPid = "com.liferay.employee.web.configuration.EmployeePortletConfiguration", property = {
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "javax.portlet.display-name=EmployeeWeb",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + EmployeeWebPortletKeys.EMPLOYEEWEB,

		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EmployeeWebPortlet extends MVCPortlet {

	@Reference
	private EmployeeLocalService employeeLocalService;
	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private DocumentResource.Factory documentResourceFactory;
	@Reference
	private EmployeePersistence employeePersistence;

	private EmployeePortletConfiguration _getEmpPortletConfiguration(RenderRequest renderRequest)
			throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		try {
			return portletDisplay.getPortletInstanceConfiguration(EmployeePortletConfiguration.class);
		} catch (ConfigurationException configurationException) {
			throw new PortletException(configurationException);
		}
	}

	public List<Employee> getEmployees() {

		List<Employee> employeeList = new ArrayList<>();
		try {
			employeeList = employeePersistence.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;

	}

	public DocumentResource getDocumentResource(ThemeDisplay themeDisplay, ActionRequest actionRequest,
			ActionResponse actionResponse) {

		return documentResourceFactory.create().user(themeDisplay.getUser()).build();

	}

	@ProcessAction(name = "addEmployee")
	public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long companyEmpId = counterLocalService.increment(Employee.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long groupId = themeDisplay.getSiteGroupIdOrLiveGroupId();
		String empFirstName = ParamUtil.getString(actionRequest, "empFirstName");
		String empLastName = ParamUtil.getString(actionRequest, "empLastName");
		String email = ParamUtil.getString(actionRequest, "email");
		String phone = ParamUtil.getString(actionRequest, "phone");
		String companyName = ParamUtil.getString(actionRequest, "companyName");
		// Long profImageId = counterLocalService.increment(Employee.class.getName());
		Date joinDate = ParamUtil.getDate(actionRequest, "joinDate", new SimpleDateFormat("yyyy-MM-dd"));

		try {
			UploadPortletRequest portletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

			File file = portletRequest.getFile("profImage");
			FileInputStream fileInputStream = new FileInputStream(file);

			BinaryFile binaryFile = new BinaryFile("multipart/form-data", StringUtil.randomString() + ".jpg",
					fileInputStream, file.length());
			MultipartBody multipartBody = MultipartBody.of(new HashMap<String, BinaryFile>() {
				{
					put("file", binaryFile);
				}
			}, new MultipartBody.ObjectMapperProvider() {
				@Override
				public ObjectMapper provide(Class Document) {
					return new ObjectMapper();
				}
			}, new HashMap<String, String>() {
				{
					put(StringUtil.randomString() + ".jpg", StringUtil.randomString() + ".jpg");
				}
			});

			Document document = getDocumentResource(themeDisplay, actionRequest, actionResponse)
					.postSiteDocument(groupId, multipartBody);

			Employee employee = employeeLocalService.createEmployee(companyEmpId);
			employee.setCompanyName(companyName);
			employee.setGroupId(groupId);
			employee.setEmpFirstName(empFirstName);
			employee.setEmpLastName(empLastName);
			employee.setEmail(email);
			employee.setPhone(phone);
			employee.setProfImageId(document.getId());
			employee.setCreateDate(joinDate);
			employee.setCompanyId(themeDisplay.getUser().getCompanyId());

			employee = employeeLocalService.addEmployee(employee);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Employee.class.getName(), actionRequest);
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(),
					serviceContext.getScopeGroupId(), new Date(), new Date(), Employee.class.getName(),
					employee.getCompanyEmpId(), employee.getUuid(), 0, null, null, true, false, new Date(), null,
					new Date(), null, ContentTypes.TEXT_HTML, "employee", "employee", null, null, null, 0, 0, null);
			Indexer<Employee> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Employee.class);
			indexer.reindex(employee);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@ProcessAction(name = "updateEmployee")
	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long companyEmpId = ParamUtil.getLong(actionRequest, "companyEmpId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Employee employee = null;
		try {
			employee = employeeLocalService.getEmployee(companyEmpId);
			employee.setCompanyName(ParamUtil.getString(actionRequest, "companyName"));
			employee.setEmpFirstName(ParamUtil.getString(actionRequest, "empFirstName"));
			employee.setEmpLastName(ParamUtil.getString(actionRequest, "empLastName"));
			employee.setEmail(ParamUtil.getString(actionRequest, "email"));
			employee.setPhone(ParamUtil.getString(actionRequest, "phone"));

			UploadPortletRequest portletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

			File file = portletRequest.getFile("profImage");
			FileInputStream fileInputStream = new FileInputStream(file);
			BinaryFile binaryFile = new BinaryFile("multipart/form-data", StringUtil.randomString() + ".jpg",
					fileInputStream, file.length());
			MultipartBody multipartBody = MultipartBody.of(new HashMap<String, BinaryFile>() {
				{
					put("file", binaryFile);
				}
			}, new MultipartBody.ObjectMapperProvider() {
				@Override
				public ObjectMapper provide(Class Document) {
					return new ObjectMapper();
				}
			}, new HashMap<String, String>() {
				{
					put(StringUtil.randomString() + ".jpg", StringUtil.randomString() + ".jpg");
				}
			});

			getDocumentResource(themeDisplay, actionRequest, actionResponse)
					.putDocument(ParamUtil.getLong(actionRequest, "profImageId"), multipartBody);
			employee = employeeLocalService.updateEmployee(employee);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Employee.class.getName(), actionRequest);
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(),
					serviceContext.getScopeGroupId(), new Date(), new Date(), Employee.class.getName(),
					employee.getCompanyEmpId(), employee.getUuid(), 0, null, null, true, false, new Date(), null,
					new Date(), null, ContentTypes.TEXT_HTML, "employee", "employee", null, null, null, 0, 0, null);
			Indexer<Employee> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Employee.class);
			indexer.reindex(employee);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@ProcessAction(name = "deleteEmployee")
	public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long profImageId = ParamUtil.getLong(actionRequest, "profImageId");
		Long companyEmpId = ParamUtil.getLong(actionRequest, "companyEmpId");
		try {
			employeeLocalService.deleteEmployee(companyEmpId);

			documentResourceFactory.create().user(themeDisplay.getUser()).build().deleteDocument(profImageId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			renderRequest.setAttribute("employeeList", EmpUtil.getEmployees());
		} catch (Exception e) {
			e.printStackTrace();
		}

		renderRequest.setAttribute(EmployeePortletConfiguration.class.getName(),
				_getEmpPortletConfiguration(renderRequest));

		super.render(renderRequest, renderResponse);

	}

}