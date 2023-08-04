<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />
 
<portlet:actionURL name="updateEmployee" var="updateEmployeeActionURL"/>
            
                
<h1>Update employee details here</h1>


 
<aui:form action="<%=updateEmployeeActionURL %>" name="employeeForm" method="POST" >
	<% 
	String companyEmpId = renderRequest.getParameter("companyEmpId");
	String profImageId = renderRequest.getParameter("profImageId");
	String empFirstName = renderRequest.getParameter("empFirstName");
	String empLastName = renderRequest.getParameter("empLastName");
	String phone = renderRequest.getParameter("phone");
	String email  = renderRequest.getParameter ("email");
	String companyName  = renderRequest.getParameter("companyName");
	String groupId= renderRequest.getParameter ("groupId");
 %>	
 	 <aui:input name="companyEmpId" type="text" value= "${employee.companyEmpId}" >
         <aui:validator name="required"></aui:validator>
    </aui:input>
     <aui:input name="groupId" type="text" value = "${employee.groupId}" >
         <aui:validator name="required"></aui:validator>
    </aui:input>
    <aui:input name="profImage" type="file" >
         <aui:validator name="acceptFiles">'jpg,png,tif,gif'</aui:validator>
    </aui:input>
 
    <aui:input name="empFirstName" type="text" value="${employee.empFirstName}" >
         <aui:validator name="required"/>
         <aui:validator name="alpha"/>
    </aui:input>
 
    <aui:input name="empLastName" type="text" value="${employee.empLastName}">
         <aui:validator name="required"/>
         <aui:validator name="alpha"/>
    </aui:input> 
 
    <aui:input name="phone" type="text" value="${employee.phone}">
         <aui:validator name="required"/>
         <aui:validator name="string"/>
    </aui:input>
 
    <aui:input name="email"type="text" value="${employee.email}">
         <aui:validator name="required"/>
         <aui:validator name="alpha"/>
    </aui:input>  
    <aui:input name="companyName"type="text" value="${employee.companyName}">
         <aui:validator name="required"/>
         <aui:validator name="alpha"/>
    </aui:input> 
    <aui:input name="profImageId" type="text" value="${employee.profImageId}">
         <aui:validator name="required"/>
    </aui:input> 
 
    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>