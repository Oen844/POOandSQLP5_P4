package com.P5.controllers.personal;

import com.P5.controllers.proyectos.ProyectoDetailController;
import com.P5.entities.Delegacion;
import com.P5.entities.Personal;
import com.P5.entities.Proyecto;
import com.P5.repositories.PersonalRepository;
import com.P5.repositories.ProyectoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class PersonalLayoutController implements Initializable {

    @FXML
    private Button homeBtn;

    @FXML
    private Button addPersonalBtn;

    @FXML
    private TableView<Personal> personalList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Personal> personal = PersonalRepository.getAll();

        TableColumn id = new TableColumn("ID");
        TableColumn nombre = new TableColumn("Nombre");
        TableColumn nif = new TableColumn("NIF");
        TableColumn direccion = new TableColumn("Dirección");
        TableColumn delegacion = new TableColumn("Delegacion ID");
        personalList.getColumns().addAll(id, nombre, nif, direccion, delegacion);

        ObservableList<Personal> personalData = FXCollections.observableArrayList(personal);

        id.setCellValueFactory(new PropertyValueFactory<Proyecto, Long>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("nombre"));
        nif.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("nif"));
        direccion.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("direccion"));
        delegacion.setCellValueFactory(new PropertyValueFactory<Proyecto, Delegacion>("delegacion"));

        personalList.setItems(personalData);

//        proyectosList.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
//                    System.out.println(proyectosList.getSelectionModel().getSelectedItem());
//                    try {
//                        goTOProyectoDetail(event, proyectosList.getSelectionModel().getSelectedItem());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
    }

//    private void goTOProyectoDetail(MouseEvent event, Proyecto proyectoSeleted) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("../../views/proyecto/proyectoDetail.fxml"));
//        Parent delegacionDetail = loader.load();
//
//        ProyectoDetailController proyectoDetailController = loader.getController();
//        proyectoDetailController.showProyectoDetail(proyectoSeleted);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setTitle("ONG Entre Culturas - Proyecto " + proyectoSeleted.getId());
//        window.setScene(new Scene(delegacionDetail, 500, 500));
//    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        Parent index = FXMLLoader.load(getClass().getResource("../../views/index.fxml"));
        Stage window = (Stage) homeBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas");
        window.setScene(new Scene(index, 500, 500));
    }

//    @FXML
//    void goToAddPersonal(ActionEvent event) throws IOException {
//        Parent index = FXMLLoader.load(getClass().getResource("../../views/proyecto/proyectoForm.fxml"));
//        Stage window = (Stage) homeBtn.getScene().getWindow();
//        window.setTitle("ONG Entre Culturas - Nuevo Proyecto");
//        window.setScene(new Scene(index, 500, 500));
//    }
}
