package com.P5.controllers;

import com.P5.entities.Delegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DelegacionDetailController {

    @FXML
    private Button delegacionLayoutBtn;

    @FXML
    private Label idLabel;

    @FXML
    private Label direccionLabel;

    @FXML
    private Label ciudadLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label telefonoLabel;

    @FXML
    private Label centralLabel;

    @FXML
    void goToDelegacionLayout(ActionEvent event) throws IOException {
        Parent delegacionesLayout = FXMLLoader.load(getClass().getResource("../views/delegacionesLayout.fxml"));
        Stage window = (Stage) delegacionLayoutBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Delegaciones");
        window.setScene(new Scene(delegacionesLayout, 500, 500));
    }

    public void showDelegacionDetail(Delegacion delegacionSeleted) {
        idLabel.setText(delegacionSeleted.getId().toString());
        direccionLabel.setText(delegacionSeleted.getDireccion());
        ciudadLabel.setText(delegacionSeleted.getCiudad());
        emailLabel.setText(delegacionSeleted.getEmail());
        telefonoLabel.setText(delegacionSeleted.getTelefono());
        centralLabel.setText(delegacionSeleted.getCentral() ? "Si" : "No");
    }
}
