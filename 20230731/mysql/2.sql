SELECT * FROM course ORDER BY cno ASC;

SELECT * FROM course ORDER BY cno DESC;

SELECT * FROM course ORDER BY cname DESC;

SELECT * FROM course ORDER BY cname ASC,cno DESC;

SELECT * FROM course ORDER BY tno ASC,cno DESC;

SELECT * FROM course ORDER BY tno ASC,cno ASC;

SELECT * FROM course WHERE tno='t001' ORDER BY tno ASC,cno ASC;

SELECT *
FROM course
WHERE tno = 't001'
ORDER BY tno ASC, cno ASC
LIMIT 0, 2;

-- limit 写2个参数 第一个数据表示从哪条数据开始，第二个参数表示要查多少条数据

SELECT *
FROM course
WHERE tno = 't001'
ORDER BY tno ASC, cno ASC
LIMIT 1, 2;

-- limit 写1个参数 表示要查多少条数据，从0开始

SELECT *
FROM course
WHERE tno = 't001'
ORDER BY tno ASC, cno ASC
LIMIT 2;

-- 多条件 where中  or表示或者 and表示并且

SELECT *
FROM course
WHERE tno = 't001' OR tno = 't002'
ORDER BY tno ASC, cno ASC
LIMIT 2;

-- 分组 group by 一般情况会使用 聚合函数:sum avg count max min

-- 分组后查询的数据要与分组的字段一致，可以做聚合运算

select sno from sc group by sno;

-- 分组后香询数量

select sno,count(sno) from sc group by sno;

-- 分组后查询分数和

select sno,sum(score) from sc group by sno;

-- 分组后查询平均分

-- as 对结果集 进行起别名 as可以省略

select sno,avg(score) as avg_score from sc group by sno;

select sno,avg(score) avg_score from sc group by sno;

-- 分组后 查询最大分数

select sno,max(score) max_score from sc group by sno;

-- 分组后 查询最小分数

select sno,min(score) max_score from sc group by sno;

-- where只能对原表进行条件筛选，对于分组之后的结果集的列名进行筛选（例如平均分）用having

select
    sno,
    avg(score) avg_score
from sc
group by sno
having avg_score > 75;

-- 查询sno为s003而且平均分大于75

-- 不能用

-- select sno,avg(score)from sc where sno='s003'and avg(score)>75;

select
    sno,
    avg(score) avg_score
from sc
where sno = "s003"
group by sno
having avg_score > 75;

-- 用多个字段分组，分组字段的值同时都相等才能分到一个组中
select
    sage,
    ssex,
    count(*) count
from student
group by sage, ssex;

-- select from where group by having order by limit
select
    sage,
    ssex,
    count(*) count
from student
where sage >= 21
group by sage, ssex
having count >= 2
order by sage asc
limit 0, 1;