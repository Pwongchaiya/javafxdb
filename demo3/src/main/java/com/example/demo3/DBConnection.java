package com.example.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  public Connection dbLink;

  public Connection getDbLink(){
    String url = "jdbc:sqlite:db/movieDb.db";
    try {
      dbLink = DriverManager.getConnection(url);

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return dbLink;
  }

}
