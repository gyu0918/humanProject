package DAO;


import ENTITY.Score;

import java.sql.*;
import java.util.*;

public  class SuperDAO<T> {
    private String url = "jdbc:mariadb://localhost:3306/product";
    private String user = "root";
    private String password = "1234";
    private Connection conn;

    public SuperDAO() throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }
    public Connection getConnection() {
        return conn;
    }

    public List<T> selectAll() throws SQLException {
        return new ArrayList<>();
    }

    public void add(){

    }
    public void update(){

    }
    public void delete(){

    }

}
