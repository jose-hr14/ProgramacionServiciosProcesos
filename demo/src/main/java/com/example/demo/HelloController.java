package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HelloController {

    DatabaseManager databaseManager;
    public HelloController() {

    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private GridPane bottomPanel;

    @FXML
    private ImageView iconAdd;

    @FXML
    private ImageView iconBook;

    @FXML
    private ImageView iconEdit;

    @FXML
    private ImageView iconExit;

    @FXML
    private ImageView iconLentBook;

    @FXML
    private ImageView iconRead;

    @FXML
    private ImageView iconReturnBook;

    @FXML
    private ImageView iconUser;

    @FXML
    private TextField label11;

    @FXML
    private TextField lblUserBirthdate;

    @FXML
    private TextField lblUserCode;

    @FXML
    private TextField lblUserName;

    @FXML
    private TextField lblUserSurname;

    @FXML
    private GridPane paneBook;

    @FXML
    private GridPane paneLent;

    @FXML
    private GridPane paneUser;

    @FXML
    private GridPane upperPane;

    @FXML
    void iconReadListener(MouseEvent event) {

    }

    @FXML
    void userIconListener(MouseEvent event) {
        paneBook.setVisible(false);
        paneLent.setVisible(false);
        paneUser.setVisible(true);
    }

    @FXML
    void bookIconListener(MouseEvent event) {
        paneUser.setVisible(false);
        paneLent.setVisible(false);
        paneBook.setVisible(true);
    }

    @FXML
    void lentIconListener(MouseEvent event) {
        paneUser.setVisible(false);
        paneBook.setVisible(false);
        paneLent.setVisible(true);
    }

    @FXML
    void iconAddListener(MouseEvent event) {
        if(paneBook.isVisible())
        {
            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setCode(lblUserCode.getText());
            usersEntity.setName(lblUserName.getText());
            usersEntity.setSurname(lblUserSurname.getText());

        }
    }

}