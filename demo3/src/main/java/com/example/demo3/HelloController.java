package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.sql.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

  @FXML
  private ListView<String> moviesListView;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    DBConnection connectionNow = new DBConnection();
    Connection connectionDb = connectionNow.getDbLink();

    String query = "SELECT * FROM movies";

    try {

      Statement statement = connectionDb.createStatement();
      ResultSet queryOutput = statement.executeQuery(query);

      while(queryOutput.next()){
        String title = queryOutput.getString("title");
        String actor = queryOutput.getString("actor");
        String releaseDate = queryOutput.getString("release_date");
        String length = queryOutput.getString("length");

        String output = title + ": " + actor + ", " + releaseDate + ", " +length;

        moviesListView.getItems().add(output);
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }

  }
}

