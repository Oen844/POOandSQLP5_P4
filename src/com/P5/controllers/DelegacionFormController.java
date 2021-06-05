package com.P5.controllers;

import com.P5.entities.Delegacion;
import com.P5.repositories.DelegacionRepository;
import com.P5.utils.Dialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.exception.ConstraintViolationException;

import java.io.IOException;

public class DelegacionFormController {

    @FXML
    private Button delegacionLayoutBtn;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField ciudadField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telefonoField;

    @FXML
    private RadioButton centralFieldYes;

    @FXML
    private RadioButton centralFieldNo;

    @FXML
    private ToggleGroup centralRadioBtn;

    @FXML
    private Button saveBtn;

    @FXML
    void goToDelegacionLayout(ActionEvent event) throws IOException {
        Parent delegacionesLayout = FXMLLoader.load(getClass().getResource("../views/delegacionesLayout.fxml"));
        Stage window = (Stage) delegacionLayoutBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Delegaciones");
        window.setScene(new Scene(delegacionesLayout, 500, 500));
    }

    @FXML
    void addNewDelegacion(ActionEvent event) {
        String ciudad = ciudadField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();

        if (!ciudad.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !email.isEmpty()) {
            Delegacion newDelegacion = new Delegacion(ciudad, direccion, telefono, email, centralFieldYes.isSelected());

            try {
                DelegacionRepository.add(newDelegacion);
                goToDelegacionLayout(null);
            } catch (ConstraintViolationException cve) {
                Dialog.error(cve.getSQLException().getMessage());
            } catch (IOException e) {
                Dialog.error(e.getMessage());
            }
        } else {
            Dialog.error("Todos los campos son obligatorios.");
        }
    }
}
