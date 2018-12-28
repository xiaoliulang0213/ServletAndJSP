package com.liuxiaonian.jdbc;

import com.sun.net.httpserver.HttpServer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/datasource")
public class DataSourceTest extends HttpServlet{
    private static DataSource dataSource;
    private static Connection connection;

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //DataSource获取数据库连接
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/demo");
            connection = dataSource.getConnection();
            if (!connection.isClosed()){
                System.err.println("OK");
            }else {
                System.err.println("No");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
