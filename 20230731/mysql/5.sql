-- Active: 1690767170004@@127.0.0.1@3306@my_database

-- 子查询，把已经查询的结果集可以再看成一个表，跟其他表进行join等等操作

-- 子查询

SELECT *
FROM student s1
    INNER JOIN (
        SELECT
            s.sno,
            MAX(sc.score) max_score
        FROM student s
            INNER JOIN sc ON s.sno = sc.sno
        GROUP BY s.sno
        HAVING
            max_score > 81
    ) t ON s1.sno = t.sno;