package com.example.rou;

import SQL.MySQL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInMenuCL {
    public static String NameLoggedIn;
    public static int ScoreLoggedIn;

    @FXML
    private TextField NameTXT;

    @FXML
    void LogInBTN(MouseEvent event) throws SQLException, IOException {
        boolean username_exist = false;
        ResultSet rs_check = MySQL.getMySQL().ExecuteQuery("SELECT * FROM scoreboard");
        while (rs_check.next()) {
            if (NameTXT.getText().equals(rs_check.getString("Name"))) {
                username_exist = true;
                NameLoggedIn = rs_check.getString("Name");
                ScoreLoggedIn = 0;;
                break;
            }
        }

        if (!username_exist) {
            String SQLCom = String.format("INSERT INTO scoreboard (Name) VALUES ('%s')", NameTXT.getText());
            MySQL.getMySQL().Execute(SQLCom);
            NameLoggedIn = NameTXT.getText();
            ScoreLoggedIn = 0;
        }

        Parent root = FXMLLoader.load(getClass().getResource("SelectMapMenu.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void MenuBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

}
