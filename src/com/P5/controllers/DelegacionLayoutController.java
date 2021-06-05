package com.P5.controllers;

import com.P5.entities.Delegacion;
import com.P5.repositories.DelegacionRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DelegacionLayoutController implements Initializable {

    @FXML
    private Button homeBtn;

    @FXML
    private TableView<Delegacion> delegacionesList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Delegacion> delegaciones = DelegacionRepository.getAll();

        TableColumn id = new TableColumn("ID");
        TableColumn direccion = new TableColumn("Direccion");
        TableColumn ciudad = new TableColumn("Ciudad");
        TableColumn email = new TableColumn("Email");
        TableColumn telefono = new TableColumn("Telefono");
        TableColumn central = new TableColumn("Central");
        delegacionesList.getColumns().addAll(id, direccion, ciudad, email, telefono, central);

        ObservableList<Delegacion> delegacionesData = FXCollections.observableArrayList(delegaciones);

        id.setCellValueFactory(new PropertyValueFactory<Delegacion, Long>("id"));
        direccion.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("direccion"));
        ciudad.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("ciudad"));
        email.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("email"));
        telefono.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("telefono"));
        central.setCellValueFactory(new PropertyValueFactory<Delegacion, Boolean>("central"));

        delegacionesList.setItems(delegacionesData);
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        Parent index = FXMLLoader.load(getClass().getResource("../views/index.fxml"));
        Stage window = (Stage) homeBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas");
        window.setScene(new Scene(index, 500, 500));
    }
}
