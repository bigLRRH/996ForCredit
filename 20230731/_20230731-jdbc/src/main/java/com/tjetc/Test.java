package com.tjetc;

import com.tjetc.entity.User;

import java.math.BigInteger;
import java.sql.*;

import static com.oracle.util.Checksums.update;
import static java.nio.file.Files.delete;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        query("jim", "11111");
        insert("laowang", "000000");
        update();
        delete();
    }

    private static void delete() throws ClassNotFoundException, SQLException {
        //        1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        2、创建连接
        String url = "jdbc:mysql://localhost:3306/20230731_jdbc?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai" ;
        Connection conn = DriverManager.getConnection(url, "996forCredit", "123456");
//        3、创建PreparedStatement并执行sgl语句
        String sql = "delete from `user` where id in(?,?,?,?);" ;
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < 4; ++i) {
            ps.setObject(i + 1, i + 6);
        }
//        4、执行sql语句，返回影响行数
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }

//        5、关闭资源
        ps.close();
        conn.close();
    }

    private static void update() throws ClassNotFoundException, SQLException {
//        1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        2、创建连接
        String url = "jdbc:mysql://localhost:3306/20230731_jdbc?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai" ;
        Connection conn = DriverManager.getConnection(url, "996forCredit", "123456");
//        3、创建PreparedStatement并执行sgl语句
        String sql = "update `user` set `password` = ? where id=?;" ;
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setObject(1, 99999);
        ps.setObject(2, 2);
//        4、执行sql语句，返回影响行数
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }

//        5、关闭资源
        ps.close();
        conn.close();

    }

    private static void insert(String username, String password) throws ClassNotFoundException, SQLException {
//        1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        2、创建连接
        String url = "jdbc:mysql://localhost:3306/20230731_jdbc?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai" ;
        Connection conn = DriverManager.getConnection(url, "996forCredit", "123456");
//        3、创建PreparedStatement并执行sgl语句
        String sql = "insert into `user` (`username`,`password`) values (?,?)" ;
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setObject(1, username);
        ps.setObject(2, password);
//        4、执行sql语句，返回影响行数
        int rows = ps.executeUpdate();
        System.out.println("rows:" + rows);
//        获取自增主键id
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            BigInteger idObj = (BigInteger) rs.getObject(1);
            System.out.println(idObj.longValue());
        }

//        5、关闭资源
        rs.close();
        ps.close();
        conn.close();

    }

    //查询数据
    private static void query(String username, String password) throws ClassNotFoundException, SQLException {
        //1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、创建连接
        String url = "jdbc:mysql://localhost:3306/20230731_jdbc?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai" ;
        Connection conn = DriverManager.getConnection(url, "996forCredit", "123456");
        //3、创建PreparedStatement并执行sgl语句
        String sql = "select `id`,`username`,`password` from `user` where `username`=? and `password`=?" ;
        PreparedStatement ps = conn.prepareStatement(sql);
        //设置问号参数的值
        ps.setObject(1, username);
        ps.setObject(2, password);
        //执行sql语句，处理结果集
        ResultSet rs = ps.executeQuery();
        //4、处理结果集
        if (rs.next()) {
            //处理数据
            Long id1 = (Long) rs.getObject("id");
            String username1 = (String) rs.getObject("username");
            String password1 = (String) rs.getObject("password");
            User user = new User();
            user.setId(id1);
            user.setUsername(username1);
            user.setPassword(password1);
            System.out.println(user);
        } else {
            System.out.println("用户名或密码错误");
        }
        //5、关闭资源
        rs.close();
        ps.close();
        conn.close();
    }
}
