-- Active: 1690767170004@@127.0.0.1@3306@my_database

-- 1、查询同一个学生的“c001”课程比“c002”课程成绩高的所有学生的学号；

SELECT sc.sno
FROM sc
    INNER JOIN sc sc1 ON sc.sno = sc1.sno
WHERE
    sc.cno = 'c001'
    AND sc1.cno = 'c002'
    and sc.score > sc1.score;

-- 2、查询平均成绩大于60 分的每个同学的学号和平均成绩；

SELECT
    sno,
    AVG(score) avg_score
FROM sc
GROUP BY sno
HAVING avg_score > 60;

-- 3、查询所有同学的学号、姓名、选课数、总成绩；

SELECT
    s.sno,
    s.sname,
    t.count,
    t.sum_score
FROM student s
    LEFT JOIN(
        SELECT
            sno,
            COUNT(*) count,
            SUM(score) sum_score
        FROM sc
        GROUP BY
            sno
    ) t on s.sno = t.sno;

-- 4、查询姓“刘”的老师的个数；

SELECT COUNT(*) FROM teacher WHERE tname LIKE '刘%';

-- 5、查询没学过“谌燕”老师课的同学的学号、姓名；

SELECT sno,sname
FROM student
WHERE sno NOT IN(
        -- 学过的
        SELECT DISTINCT s.sno
        FROM student s
            INNER JOIN sc ON s.sno = sc.sno
            INNER JOIN course c on sc.cno = c.cno
            INNER JOIN teacher t ON c.tno = t.tno
        WHERE t.tname = '谌燕'
        -- GROUP BY
        --     s.sno,
        --     s.sname
    );