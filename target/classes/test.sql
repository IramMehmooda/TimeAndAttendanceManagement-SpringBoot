
show tables;
select * from project;


drop table employee;

drop table user;



drop table project;

select * from user where user_type="supervisor";


insert into user(user_id,username,password,user_type,fullname,address,email,phone_no,job_title,salary,ssn) values(1003,"Inzemam","password","employee","Iram Mehmooda","DeKalb,IL,USA","iram.niu@gmail.com",6789087689,"Team Lead-CRM",200000,87887866);