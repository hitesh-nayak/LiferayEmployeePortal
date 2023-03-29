<%@ include file="init.jsp"%>

 
<portlet:actionURL name="addEmployee" var="addEmployeeActionURL"/>
            
                
<h1>Enter employee details</h1>
 
<aui:form action="<%=addEmployeeActionURL %>" name="employeeForm" method="POST" >
    <aui:input name="profImage" type="file" >
         
         <aui:validator name="acceptFiles">'jpg,png,tif,gif'</aui:validator>
    </aui:input>
 
    <aui:input name="empFirstName" >
         <aui:validator name="required"/>
         <aui:validator name="alpha"/>
    </aui:input>
 
    <aui:input name="empLastName" >
         <aui:validator name="required"/>
         <aui:validator name="alpha"/>
    </aui:input> 
 
    <aui:input name="phone" >
         <aui:validator name="required"/>
         <aui:validator name="string"/>
    </aui:input>
 
    <aui:input name="email">
         <aui:validator name="required"/>
         <aui:validator name="alpha"/>
    </aui:input>  
    <aui:input name="companyName">
         <aui:validator name="required"/>
         <aui:validator name="alpha"/>
    </aui:input> 
 
    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>