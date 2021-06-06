package com.P5.controllers.personal;

import com.P5.entities.Personal;
import com.P5.repositories.PersonalRepository;
import com.P5.utils.Dialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonalDetailController {

    @FXML
    private Button proyectoLayoutBtn;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label nifLabel;

    @FXML
    private Label direccionLabel;

//    @FXML
//    private Label lineaAccionLabel;
//
//    @FXML
//    private Label sublineaAccionLabel;
//
//    @FXML
//    private Label fechaInicioLabel;
//
//    @FXML
//    private Label fechaFinLabel;
//
//    @FXML
//    private Label socioLocalLabel;
//
//    @FXML
//    private Label financiadorLabel;
//
//    @FXML
//    private Label financiacionAportadaLabel;

    @FXML
    private Button editBtn;

    @FXML
    private Button deleteBtn;

    private Personal personalSelected;

    @FXML
    void goToPersonalLayout(ActionEvent event) throws IOException {
        Parent personalLayout = FXMLLoader.load(getClass().getResource("../../views/personal/personalLayout.fxml"));
        Stage window = (Stage) proyectoLayoutBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Personal");
        window.setScene(new Scene(personalLayout, 500, 500));
    }

    public void showPersonalDetail(Personal personal) {
        this.personalSelected = personal;
        nombreLabel.setText(personal.getNombre());
        nifLabel.setText(personal.getNif());
        direccionLabel.setText(personal.getDireccion());
//        lineaAccionLabel.setText(personal.getLineaAccion());
//        sublineaAccionLabel.setText(personal.getSubLineaAccion());
//        fechaInicioLabel.setText(personal.getFechaInicio().toString());
//        fechaFinLabel.setText(personal.getFechaFin().toString());
//        socioLocalLabel.setText(personal.getSocioLocal());
//        financiadorLabel.setText(personal.getFinanciador());
//        financiacionAportadaLabel.setText(personal.getFinanciacionAportada());
    }

    @FXML
    void goToEditPersonalForm(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../views/personal/personalForm.fxml"));
        Parent delegacionFom = loader.load();

        PersonalFormController personalFormController = loader.getController();
        personalFormController.editPersonal(personalSelected);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Editar Empleado " + personalSelected.getId());
        window.setScene(new Scene(delegacionFom, 500, 500));
    }

    @FXML
    void deletePersonal(ActionEvent event) {
        ButtonType responseDialog = Dialog.confirmation("¿Desea eleminar definitivamente este empleado?");

        if (responseDialog == ButtonType.YES) {
            PersonalRepository.delete(personalSelected);
            try {
                goToPersonalLayout(null);
            } catch (IOException e) {
                Dialog.error(e.getMessage());
            }
        }
    }
}
