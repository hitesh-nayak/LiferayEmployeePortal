<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ page import="com.liferay.employee.service.service.EmployeeLocalServiceUtil"%>
<%@ page import="java.util.List"%>



<% 
	Long companyEmpId = ParamUtil.getLong(actionRequest ,"companyEmpId");
	Long profImageId = ParamUtil.getLong(actionRequest, "profImageId");
	String empFirstName = ParamUtil.getString(actionRequest, "empFirstName");
	String empLastName = ParamUtil.getString(actionRequest, "empLastName");
	String phone = ParamUtil.getString(actionRequest, "phone");
	String email  = ParamUtil.getString(actionRequest, "email");
	String companyName  = ParamUtil.getString(actionRequest, "companyName");
	String groupId= ParamUtil.getString(actionRequest, "groupId");
 %>	

<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<table class="table table-striped">
    <tr >
        <th>employee ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
        <th>email</th>
        <th>company name/th>
        <th>prof image id</th>
        <th>group id</th>
        <th colspan="2" style="width: 100px">Action</th>
    </tr>
    <% List <Employee> employeeList = EmployeeLocalServiceUtil.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS); %>
    <c:forEach items="${employeeList}" var="employee">  
    
        <portlet:renderURL var="updateEmployeeRenderURL">
            <portlet:param name="mvcPath" value="/updateEmployee.jsp"/>
            <portlet:param name="companyEmpId" value="${employee.getCompanyEmpId()}"/>
            <portlet:param name="empFirstName" value="${employee.getEmpFirstName()}"/>
            <portlet:param name="empLastName" value="${employee.getEmpLastName()}"/>
            <portlet:param name="phone" value="${employee.getPhone()}"/>
            <portlet:param name="email" value="${employee.getEmail()}"/>
            <portlet:param name="companyName" value="${employee.getCompanyName()}"/>
            <portlet:param name="profileImageId" value="${employee.getProfImageId()}"/>
            <portlet:param name="groupId" value="${employee.getGroupId()}"/>
            
        </portlet:renderURL>
        
        <portlet:actionURL name="deleteEmployee" var="deleteEmployeeActionURL">
            <portlet:param name="companyEmpId" value="${employee.getCompanyEmpId()}"/>
        </portlet:actionURL>
                
        <tr> 
            <td>${employee.getCompanyEmpId()}</td>
            <td>${employee.getEmpFirstName()}</td>
            <td>${employee.getLastName()}</td>
            <td>${employee.getPhone()}</td>
            <td>${employee.getEmail()}</td>
            <td>${employee.getCompanyName()}</td>
            <td>${employee.getProfileImageId()}</td>
            <td>${employee.getgroupId()}</td>
            <td class="text-center" style="width: 50px">
                <a href="<%=updateEmployeeRenderURL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
                <i class ="glyphicon glyphicon-edit"></i>
                </a>
            </td> 
            <td class="text-center" style="width:50px">
                <a href="<%=deleteEmployeeActionURL%>" 
                    class="btn  btn-primary btn-default btn-sm px-2 py-1"
                    onclick="return confirm('Are you sure you want to delete this item?');"> 
                    <i class ="glyphicon glyphicon-remove"></i>
                </a>
            </td>                                     
         </tr>
    </c:forEach>
</table>