create index IX_810C5EC on Company_Dummy (companyName[$COLUMN_LENGTH:75$]);
create index IX_38F4702D on Company_Dummy (empLastName[$COLUMN_LENGTH:75$]);
create index IX_AD27C9BE on Company_Dummy (groupId);
create index IX_4464A360 on Company_Dummy (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_637E81E2 on Company_Dummy (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5C17BA62 on Company_Employee (companyName[$COLUMN_LENGTH:75$]);
create index IX_8CFB64A3 on Company_Employee (empLastName[$COLUMN_LENGTH:75$]);
create index IX_9976934 on Company_Employee (groupId);
create index IX_ABF208AA on Company_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B8D8B1AC on Company_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);