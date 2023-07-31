-- Active: 1690767170004@@127.0.0.1@3306@my_database

--  union 去重
SELECT cno, cname, tno
FROM course
WHERE tno = 't001' OR tno = 't002'
UNION
SELECT cno, cname, tno
FROM course
WHERE tno = 't002';

-- union all 不去重，保留重复数据 （效率更高）
SELECT cno, cname, tno
FROM course
WHERE tno = 't001' OR tno = 't002'
UNION ALL
SELECT cno, cname, tno
FROM course
WHERE tno = 't002';

-- distinct 去重复，可以多个字段，所有的字段是同时不重复
SELECT DISTINCT sno FROM sc;