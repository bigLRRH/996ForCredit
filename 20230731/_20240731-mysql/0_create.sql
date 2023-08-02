-- Active: 1690767170004@@127.0.0.1@3306@my_database
CREATE TABLE student(
sno VARCHAR(10) PRIMARY KEY,  	#学生学号
sname VARCHAR(20),		#学生姓名
sage NUMERIC(2),			#学生年龄
ssex VARCHAR(5)			#学生性别
);
CREATE TABLE teacher(
tno VARCHAR(10) PRIMARY KEY,	#教师编号
tname VARCHAR(20)		#教师姓名
);
CREATE TABLE course(
cno VARCHAR(10),		#课程编号
cname VARCHAR(20),		#程名称
tno VARCHAR(20),			#教师编号
CONSTRAINT pk_course PRIMARY KEY (cno,tno)	#课程编号和教师编号 联合主键
);
CREATE TABLE sc(
sno VARCHAR(10),			#学生编号
cno VARCHAR(10),		#课程编号
score decimal(4,2),		#成绩
CONSTRAINT pk_sc PRIMARY KEY (sno,cno)	#学生编号和课程编号 联合主键
);


/*******初始化学生表的数据******/
insert into student values ('s001','张三',23,'男');  
insert into student values ('s002','李四',23,'男');  
insert into student values ('s003','吴鹏',25,'男');  
insert into student values ('s004','琴沁',20,'女');  
insert into student values ('s005','王丽',20,'女');  
insert into student values ('s006','李波',21,'男');  
insert into student values ('s007','刘玉',21,'男');  
insert into student values ('s008','萧蓉',21,'女');
insert into student values ('s009','陈萧晓',23,'女');
insert into student values ('s010','陈美',22,'女');

/******************初始化教师表***********************/
insert into teacher values ('t001', '刘阳');  
insert into teacher values ('t002', '谌燕');  
insert into teacher values ('t003', '胡明星');  

/***************初始化课程表****************************/
insert into course values ('c001','J2SE','t002');
insert into course values ('c002','Java Web','t002');
insert into course values ('c003','SSH','t001');  
insert into course values ('c004','Oracle','t001');  
insert into course values ('c005','SQL SERVER 2005','t003');  
insert into course values ('c006','C#','t003');  
insert into course values ('c007','JavaScript','t002');  
insert into course values ('c008','DIV+CSS','t001');  
insert into course values ('c009','PHP','t003');
insert into course values ('c010','EJB3.0','t002');

/***************初始化成绩表***********************/
insert into sc values ('s001','c001',78.9);
insert into sc values ('s002','c001',80.9);  
insert into sc values ('s003','c001',81.9);  
insert into sc values ('s004','c001',60.9);  
insert into sc values ('s001','c002',82.9);  
insert into sc values ('s002','c002',72.9);  
insert into sc values ('s003','c002',81.9);  
insert into sc values ('s001','c003','59'); 