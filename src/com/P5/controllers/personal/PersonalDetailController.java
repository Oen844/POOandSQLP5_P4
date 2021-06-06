package com.P5.controllers.personal;

import com.P5.entities.Personal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

//    @FXML
//    void goToEditProyectoForm(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("../../views/proyecto/personalForm.fxml"));
//        Parent delegacionFom = loader.load();
//
//        ProyectoFormController proyectoFormController = loader.getController();
//        proyectoFormController.editProyecto(proyectoSelected);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setTitle("ONG Entre Culturas - Editar Proyecto " + proyectoSelected.getId());
//        window.setScene(new Scene(delegacionFom, 500, 500));
//    }
//
//    @FXML
//    void deleteProyecto(ActionEvent event) {
//        ButtonType responseDialog = Dialog.confirmation("¿Desea eleminar definitivamente este proyecto?");
//
//        if (responseDialog == ButtonType.YES) {
//            ProyectoRepository.delete(proyectoSelected);
//            try {
//                goToProyectoLayout(null);
//            } catch (IOException e) {
//                Dialog.error(e.getMessage());
//            }
//        }
//    }
}