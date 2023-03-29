<%@ include file="init.jsp" %>
<%@ page import="com.liferay.employee.service.service.EmployeeLocalServiceUtil"%>
<%@ page import="java.util.List"%>

<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>




<portlet:renderURL var="addEmployeeRenderURL">
    <portlet:param name="mvcPath" value="/addEmployee.jsp"/>
</portlet:renderURL>
 
<div class="mb-5">
    <a href="<%= addEmployeeRenderURL %>" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Add Employee
    </a>
</div>




<table class="table table-striped">
    <tr >
        <th>employee ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
        <th>email</th>
        <th>company name</th>
        <th>prof image id</th>
        <th>group id</th>
        <th colspan="2" style="width: 100px">Action</th>
    </tr>
    
    <c:forEach items="${employeeList}" varStatus="employee">  
    
        <portlet:renderURL var="updateEmployeeRenderURL">
            <portlet:param name="mvcPath" value="/updateEmployee.jsp"/>
            <portlet:param name="companyEmpId" value="${employee.companyEmpId}"/>
            <portlet:param name="empFirstName" value="${employee.empFirstName}"/>
            <portlet:param name="empLastName" value="${employee.empLastName}"/>
            <portlet:param name="phone" value="${employee.phone}"/>
            <portlet:param name="email" value="${employee.email}"/>
            <portlet:param name="companyName" value="${employee.companyName}"/>
            <portlet:param name="profileImageId" value="${employee.profImageId}"/>
            <portlet:param name="groupId" value="${employee.groupId}"/>
            
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
