-- Active: 1690767170004@@127.0.0.1@3306@my_database
insert into `teacher`(`tno`, tname) values('t004', '张三');

-- 不推荐使用

insert into `teacher` values('t005', '李四');

-- 更新

update `teacher`
set tname = '赵六', tno = 't008'
where tno = 't004'

delete from `teacher`
where tno = 't004' or tno = 't005';

delete from `teacher` where tno in ('t004', 't005');

-- 简单查询

select * from teacher;

select tno, tname from teacher;