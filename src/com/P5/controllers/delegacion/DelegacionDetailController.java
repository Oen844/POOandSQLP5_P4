package com.P5.controllers.delegacion;

import com.P5.entities.Delegacion;
import com.P5.repositories.DelegacionRepository;
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
    private Button editBtn;

    @FXML
    private Button deleteBtn;

    private Delegacion delegacionSeleted;

    @FXML
    void goToDelegacionLayout(ActionEvent event) throws IOException {
        Parent delegacionesLayout = FXMLLoader.load(getClass().getResource("../../views/delegacion/delegacionesLayout.fxml"));
        Stage window = (Stage) delegacionLayoutBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Delegaciones");
        window.setScene(new Scene(delegacionesLayout, 500, 500));
    }

    public void showDelegacionDetail(Delegacion delegacionSeleted) {
        this.delegacionSeleted = delegacionSeleted;
        idLabel.setText(delegacionSeleted.getId().toString());
        direccionLabel.setText(delegacionSeleted.getDireccion());
        ciudadLabel.setText(delegacionSeleted.getCiudad());
        emailLabel.setText(delegacionSeleted.getEmail());
        telefonoLabel.setText(delegacionSeleted.getTelefono());
        centralLabel.setText(delegacionSeleted.getCentral() ? "Si" : "No");
    }

    @FXML
    void goToEditDelegacionForm(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../views/delegacion/delegacionForm.fxml"));
        Parent delegacionFom = loader.load();

        DelegacionFormController delegacionFormController = loader.getController();
        delegacionFormController.editDelegacion(delegacionSeleted);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Editar Delegacion " + delegacionSeleted.getId());
        window.setScene(new Scene(delegacionFom, 500, 500));
    }

    @FXML
    void deleteDelegacion(ActionEvent event) {
        ButtonType responseDialog = Dialog.confirmation("¿Desea eleminar definitivamente esta delegación?");

        if (responseDialog == ButtonType.YES) {
            DelegacionRepository.delete(delegacionSeleted);
            try {
                goToDelegacionLayout(null);
            } catch (IOException e) {
                Dialog.error(e.getMessage());
            }
        }
    }
}
