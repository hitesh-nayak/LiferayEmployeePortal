package com.liferay.employee.panel.portlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.employee.panel.constants.EmployeePanelPortletKeys;
import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalService;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.headless.delivery.dto.v1_0.Document;
import com.liferay.headless.delivery.resource.v1_0.DocumentResource;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=EmployeePanel",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeePanelPortletKeys.EMPLOYEEPANEL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",

	},
	service = Portlet.class
)
public class EmployeePanelPortlet extends MVCPortlet {
	
	@Reference
	EmployeeLocalService employeeLocalService;
	@Reference
	CounterLocalService counterLocalService;
	@Reference
	DocumentResource.Factory documentResourceFactory;

	public DocumentResource getDocumentResource(ThemeDisplay themeDisplay, ActionRequest actionRequest,
			ActionResponse actionResponse) {

		return documentResourceFactory.create().user(themeDisplay.getUser()).build();

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
			employeeLocalService.updateEmployee(employee);

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
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) {
		try {
			List<Employee> employeeList = EmployeeLocalServiceUtil.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			renderRequest.setAttribute("employeeList", employeeList);

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}