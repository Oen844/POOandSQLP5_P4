package com.P5.controllers.proyectos;

import com.P5.entities.Proyecto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ProyectoDetailController {

    @FXML
    private Button proyectoLayoutBtn;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label paisLabel;

    @FXML
    private Label localizacionLabel;

    @FXML
    private Label lineaAccionLabel;

    @FXML
    private Label sublineaAccionLabel;

    @FXML
    private Label fechaInicioLabel;

    @FXML
    private Label fechaFinLabel;

    @FXML
    private Label socioLocalLabel;

    @FXML
    private Label financiadorLabel;

    @FXML
    private Label financiacionAportadaLabel;

    @FXML
    private Button editBtn;

    @FXML
    private Button deleteBtn;

    private Proyecto proyectoSelected;

    @FXML
    void goToProyectoLayout(ActionEvent event) throws IOException {
        Parent proyectosLayout = FXMLLoader.load(getClass().getResource("../../views/proyecto/proyectosLayout.fxml"));
        Stage window = (Stage) proyectoLayoutBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Proyectos");
        window.setScene(new Scene(proyectosLayout, 500, 500));
    }

    public void showProyectoDetail(Proyecto proyectoSeleted) {
        this.proyectoSelected = proyectoSeleted;
        nombreLabel.setText(proyectoSeleted.getNombre());
        paisLabel.setText(proyectoSeleted.getPais());
        localizacionLabel.setText(proyectoSeleted.getLocalizacion());
        lineaAccionLabel.setText(proyectoSeleted.getLineaAccion());
        sublineaAccionLabel.setText(proyectoSeleted.getSubLineaAccion());
        fechaInicioLabel.setText(proyectoSeleted.getFechaInicio().toString());
        fechaFinLabel.setText(proyectoSeleted.getFechaFin().toString());
        socioLocalLabel.setText(proyectoSeleted.getSocioLocal());
        financiadorLabel.setText(proyectoSeleted.getFinanciador());
        financiacionAportadaLabel.setText(proyectoSeleted.getFinanciacionAportada());
    }

//    @FXML
//    void goToEditProyectoForm(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("../../views/delegacion/delegacionForm.fxml"));
//        Parent delegacionFom = loader.load();
//
//        DelegacionFormController delegacionFormController = loader.getController();
//        delegacionFormController.editDelegacion(delegacionSeleted);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setTitle("ONG Entre Culturas - Editar Delegacion " + delegacionSeleted.getId());
//        window.setScene(new Scene(delegacionFom, 500, 500));
//    }

//    @FXML
//    void deleteProyecto(ActionEvent event) {
//        ButtonType responseDialog = Dialog.confirmation("¿Desea eleminar definitivamente esta delegación?");
//
//        if (responseDialog == ButtonType.YES) {
//            DelegacionRepository.delete(delegacionSeleted);
//            try {
//                goToDelegacionLayout(null);
//            } catch (IOException e) {
//                Dialog.error(e.getMessage());
//            }
//        }
//    }
}