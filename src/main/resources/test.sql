
show tables;
drop table employee;
drop table user;
drop table dailyentry;
drop table project;
select * from user where username = "Bhamati";

select * from user where user_id = 1016;

select * from project;
select * from project_employee;

delete from project_employee where project_id = 5002 and user_id = 1009;
select * from timesheet;
select * from dailyentry;
select * from user where user_type="supervisor";
select * from user where user_type="employee";
select * from user where user_type="admin";


insert into user(username,password,user_type,fullname) values( "AIram","password","admin","Iram Mehmooda");
insert into user(username,password,user_type,fullname) values( "AInze","password","admin","Inzemamuddin Mohammed");
insert into user(username,password,user_type,fullname) values( "ABhamati","password","admin","Bhamati Kuchibotla");




insert into user(user_id,username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values(1001,"Inzemam","password","employee","Iram Mehmooda","DeKalb,IL,USA","iram.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("Jason","password","employee","Jason Kors","DeKalb,IL,USA","Jason@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("Jade","password","employee","Jade Smith","DeKalb,IL,USA","Jade.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("Vicky","password","employee","Vicky Malwa","DeKalb,IL,USA","Vicky.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("maliha","password","employee","maliha fnu","DeKalb,IL,USA","maliha.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("fouzan","password","employee","fouzan ahmed","DeKalb,IL,USA","fouzan.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("suraj","password","employee","suraj pankhare","DeKalb,IL,USA","suraj.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("thandy","password","employee","thandy varun","DeKalb,IL,USA","thandy.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("whitesell","password","employee","whitesell matthew","DeKalb,IL,USA","whitesell.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("Insley","password","employee","Insley Joe","DeKalb,IL,USA","Insley.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);




insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("Inze","password","supervisor","Jason Kors","DeKalb,IL,USA","Jason@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("Gayathri","password","supervisor","Gayathri pallava","DeKalb,IL,USA","Jade.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("Bhamati","password","supervisor","Bhamati Malwa","DeKalb,IL,USA","Vicky.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("vaibhavi","password","supervisor","vaibhavi fnu","DeKalb,IL,USA","maliha.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("rahman","password","supervisor","rahman ahmed","DeKalb,IL,USA","fouzan.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("krishna","password","supervisor","krishna pankhare","DeKalb,IL,USA","suraj.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("matte","password","supervisor","matte hall","DeKalb,IL,USA","thandy.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("jason","password","supervisor","jason matthew","DeKalb,IL,USA","whitesell.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values("devon","password","supervisor","devon Joe","DeKalb,IL,USA","Insley.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);



insert into timesheet(end_date,startdate,user_user_id) values(DATE '2018-04-16',DATE '2018-04-16',1003);





insert into dailyentry(id,date,fromtime,totime,noofhours,project_project_id,timesheet_id,user_user_id) values (8001,)





insert into project values (5000,562500,"microsoft","Project14", 1014);
insert into project values (5005,400002,"wiki","Testing1", 1014);
insert into project values (5001,562520,"google","Spring project", 1015);
insert into project values (5002,852369,"amazon","Java project", 1016);
insert into project values (5003,895214,"netflix",".Net Project", 1016);
insert into project values (5004,852147,"iit","Express Project", 1014);

insert into project values (5009,852147,"HSBC","Project11", 1014);
insert into project values (5006,521486,"Deloitte","Project12", 1019);
insert into project values (5007,258741,"TCS","Project13", 1020);
insert into project values (5008,965123,"HP","Project14", 1017);

insert into project_employee values(5009, 1003);
insert into project_employee values(5000, 1008);
insert into project_employee values(5000, 1007);
insert into project_employee values(5000, 1009);
insert into project_employee values(5000, 1003);
insert into project_employee values(5000, 1006);
insert into project_employee values(5000, 1007);
insert into project_employee values(5000, 1008);
insert into project_employee values(5000, 1009);
insert into project_employee values(5000, 1010);
insert into project_employee values(5001, 1003);
insert into project_employee values(5001, 1008);
insert into project_employee values(5001, 1002);
insert into project_employee values(5002, 1003);
insert into project_employee values(5002, 1004);
insert into project_employee values(5002, 1005);


delete from project_employee where user_id=890;



select u.user_id, p.project_id from user u, project p where user_type = "supervisor";

