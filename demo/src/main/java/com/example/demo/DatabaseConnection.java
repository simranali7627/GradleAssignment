package com.example.demo;
//
//public class DatabaseInsertion {
//}

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnection{


    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/GRADPROGRAM");
        dataSource.setUsername("root");
        dataSource.setPassword("simran");
        dataSource.setInitialSize(4);
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}

