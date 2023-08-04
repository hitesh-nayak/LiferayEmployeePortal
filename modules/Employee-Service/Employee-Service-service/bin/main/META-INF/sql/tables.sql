create table Company_Dummy (
	uuid_ VARCHAR(75) null,
	companyEmpId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	empFirstName VARCHAR(75) null,
	empLastName VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	companyName VARCHAR(75) null,
	profImageId LONG,
	createDate DATE null
);

create table Company_Employee (
	uuid_ VARCHAR(75) null,
	companyEmpId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	empFirstName VARCHAR(75) null,
	empLastName VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	companyName VARCHAR(75) null,
	profImageId LONG,
	createDate DATE null
);