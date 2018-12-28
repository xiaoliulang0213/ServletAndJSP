package com.liuxiaonian.jdbc;

import oracle.jdbc.OracleDriver;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class ConnectDataBase {

    public static void main(String[] args) throws ClassNotFoundException,NamingException{
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            //DriverManager获取数据库连接
//          Class.forName("oracle.jdbc.OracleDriver");
//            OracleDriver oracleDriver = new OracleDriver();
//            DriverManager.registerDriver(oracleDriver);
//            //连接数据库
//            String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
//            String user = "xjpd";
//            String password = "xjpd";


//            connection = DriverManager.getConnection(url,user,password);
//            //数据库操作
//            statement = connection.createStatement();
//            //用于执行alert、drop、insert、create等改变表的语句
////            int number = statement.executeUpdate("");
//            //用于执行select查询语句
//            result = statement.executeQuery("select * from sys_holiday");
//            //返回true表示还有数据
//            while (result.next()){
//                //使用列名称取得数据
//                String result1 = result.getString("config_date");
//                //使用列顺序取得数据
//                String result2 = result.getString(1);
//            }
//            //带有占位符的数据库操作
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("select * from terminal where guid = ?");
//            preparedStatement.setString(1,"139cff57961b4b5da717825fecb9f682");
//            ResultSet resultSet = preparedStatement.executeQuery();

            if (!connection.isClosed()){
                System.err.println("数据库连接成功!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (result != null){
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
