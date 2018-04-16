
show tables;
drop table employee;
drop table user;
drop table dailyentry;
drop table project;

select * from user;
select * from timesheet;
select * from dailyentry;
select * from user where user_type="supervisor";
select * from user where user_type="admin";


insert into user(username,password,user_type,fullname) values( "Iram","password","admin","Iram Mehmooda");
insert into user(username,password,user_type,fullname) values( "Inze","password","admin","Inzemamuddin Mohammed");
insert into user(username,password,user_type,fullname) values( "Bhamati","password","admin","Bhamati Kuchibotla");




insert into user(username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values(1003,"Inzemam","password","employee","Iram Mehmooda","DeKalb,IL,USA","iram.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);
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



