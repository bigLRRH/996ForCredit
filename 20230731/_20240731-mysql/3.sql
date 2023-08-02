-- cross join

-- inner join

-- left join/right join

--inner join 两张表的交集

SELECT *
FROM teacher
    INNER JOIN course ON teacher.tno = course.tno
WHERE
    course.cno IN('c001', 'c002', 'c003')
    AND teacher.tno IN('t002');

-- 优化 sql95

SELECT *
FROM teacher t
    INNER JOIN course c ON t.tno = c.tno
WHERE
    c.cno IN('c001', 'c002', 'c003')
    AND t.tno IN('t002');

-- sq192标准（不推荐）

SELECT *
FROM teacher t, course c
WHERE
    t.tno = c.tno
    AND c.cno IN('c001', 'c002', 'c003')
    AND t.tno IN('t002');

-- inner join 可以多张表

SELECT *
FROM teacher t
    INNER JOIN course c ON t.tno = c.tno
    INNER JOIN sc ON sc.cno = c.cno
WHERE
    c.cno IN('c001', 'c002', 'c003')
    AND t.tno IN('t002')
    AND sc.score > 75;

-- inner join可以省略inner

SELECT
    t.*,
    c.cno,
    c.cname,
    sc.sno,
    sc.score
FROM teacher t
    JOIN course c ON t.tno = c.tno
    JOIN sc ON sc.cno = c.cno
WHERE
    c.cno IN('c001', 'c002', 'c003')
    AND t.tno IN('t002')
    AND sc.score > 75;

-- left join : 主表和从表

-- left join 左边的表是主表 右边的表示从表，主表的数据要全部查询出来，如果从表没有对应的数据用nu11表示

SELECT *
from student s
    LEFT JOIN sc on s.sno = sc.sno
WHERE
    -- student的ssex为男
    -- sc的score为null（null表示不知道)
    s.ssex = '男'
    AND sc.cno IS NULL;

-- right join : 主表和从表

-- right join 右边的表是主表 左边的表示从表，主表的数据要全部查询出来，如果从表没有对应的数据用nu11表示

SELECT *
FROM sc
    RIGHT JOIN student s ON s.sno = sc.sno
WHERE
    -- student的ssex为男
    -- sc的score为null（null表示不知道)
    s.ssex = '男'
    AND sc.score IS NULL;