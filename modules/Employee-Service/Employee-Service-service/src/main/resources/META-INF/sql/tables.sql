create table Company_Employee (
	companyEmpId LONG not null primary key,
	groupId LONG,
	empFirstName VARCHAR(75) null,
	empLastName VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	companyName VARCHAR(75) null,
	profImageId LONG
);