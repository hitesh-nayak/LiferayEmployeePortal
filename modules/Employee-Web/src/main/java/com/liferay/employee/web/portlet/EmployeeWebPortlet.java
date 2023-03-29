package com.liferay.employee.web.portlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.adaptive.media.image.model.AMImageEntry;
import com.liferay.adaptive.media.image.service.AMImageEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalService;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.employee.web.constants.EmployeeWebPortletKeys;
import com.liferay.headless.delivery.dto.v1_0.Document;
import com.liferay.headless.delivery.resource.v1_0.DocumentResource;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
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

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EmployeeWebPortlet extends MVCPortlet {
	
	@Reference
	EmployeeLocalService employeeLocalService;
	@Reference
	CounterLocalService counterLocalService;
	@Reference
	DocumentResource.Factory documentResourceFactory;
	
	
	

	@ProcessAction(name = "addEmployee")
	public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException, PortalException, Exception {
		Long companyEmpId = counterLocalService.increment(Employee.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long groupId = themeDisplay.getSiteGroupIdOrLiveGroupId();
		String empFirstName = ParamUtil.getString(actionRequest, "empFirstName");
		String empLastName = ParamUtil.getString(actionRequest, "empLastName");
		String email = ParamUtil.getString(actionRequest, "email");
		String phone = ParamUtil.getString(actionRequest, "phone");
		String companyName = ParamUtil.getString(actionRequest, "companyName");
		Long profImageId = counterLocalService.increment(Employee.class.getName());

		
		
		UploadPortletRequest portletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		File file = portletRequest.getFile("profImage");
		FileInputStream fileInputStream = new FileInputStream(file);
		



		DocumentResource.Builder documentBuilder = documentResourceFactory.create();
		DocumentResource documentResource = documentBuilder.user(themeDisplay.getUser()).build();

		

		BinaryFile binaryFile = new BinaryFile("multipart/form-data", StringUtil.randomString()+".jpg"	 , fileInputStream, file.length());
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
				put(StringUtil.randomString()+".jpg", StringUtil.randomString()+".jpg");
			}
		});

		Document document = documentResource.postSiteDocument(groupId, multipartBody);
		System.out.println(document.getId());



		Employee employee = employeeLocalService.createEmployee(companyEmpId);
		employee.setCompanyName(companyName);
		employee.setGroupId(groupId);
		employee.setEmpFirstName(empFirstName);
		employee.setEmpLastName(empLastName);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setProfImageId(document.getId());
		employeeLocalService.addEmployee(employee);

	}
	
	@ProcessAction(name = "updateEmployee")
	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
		
	}
	
	@ProcessAction(name = "deleteEmployee")
	public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
		
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse){
		try {
		List <Employee> employeeList = EmployeeLocalServiceUtil.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("employeeList", employeeList);
		super.render(renderRequest, renderResponse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}