package com.P5.controllers.proyectos;

import com.P5.controllers.delegacion.DelegacionDetailController;
import com.P5.entities.Delegacion;
import com.P5.entities.Proyecto;
import com.P5.repositories.DelegacionRepository;
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

public class ProyectoLayoutController implements Initializable {

    @FXML
    private Button homeBtn;

    @FXML
    private Button addProyectoBtn;

    @FXML
    private TableView<Proyecto> proyectosList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Proyecto> proyectos = ProyectoRepository.getAll();

        TableColumn id = new TableColumn("ID");
        TableColumn nombre = new TableColumn("Nombre");
        TableColumn pais = new TableColumn("País");
        TableColumn localizacion = new TableColumn("Localización");
        TableColumn lineaAccion = new TableColumn("Linea de Acción");
        TableColumn subLineaAccion = new TableColumn("SubLinea de Acción");
        TableColumn fechaInicio = new TableColumn("Fecha de Inicio");
        TableColumn fechaFin = new TableColumn("Fecha de Fin");
        TableColumn socioLocal = new TableColumn("Socio Local");
        TableColumn financiador = new TableColumn("Financiador");
        TableColumn financiacionAportada = new TableColumn("Financiación Aportada");
        proyectosList.getColumns().addAll(id, nombre, pais, localizacion, lineaAccion, subLineaAccion, fechaInicio, fechaFin, socioLocal, financiador, financiacionAportada);

        ObservableList<Proyecto> proyectosData = FXCollections.observableArrayList(proyectos);

        id.setCellValueFactory(new PropertyValueFactory<Delegacion, Long>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("nombre"));
        pais.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("pais"));
        localizacion.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("localizacion"));
        lineaAccion.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("lineaAccion"));
        subLineaAccion.setCellValueFactory(new PropertyValueFactory<Delegacion, Boolean>("subLineaAccion"));
        fechaInicio.setCellValueFactory(new PropertyValueFactory<Delegacion, Date>("fechaInicio"));
        fechaFin.setCellValueFactory(new PropertyValueFactory<Delegacion, Date>("fechaFin"));
        socioLocal.setCellValueFactory(new PropertyValueFactory<Delegacion, Boolean>("socioLocal"));
        financiador.setCellValueFactory(new PropertyValueFactory<Delegacion, Boolean>("financiador"));
        financiacionAportada.setCellValueFactory(new PropertyValueFactory<Delegacion, Boolean>("financiacionAportada"));

        proyectosList.setItems(proyectosData);

//        proyectosList.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
//                    System.out.println(proyectosList.getSelectionModel().getSelectedItem());
//                    try {
//                        goTODelegacionDetail(event, proyectosList.getSelectionModel().getSelectedItem());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
    }

//    private void goTODelegacionDetail(MouseEvent event, Delegacion delegacionSeleted) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("../../views/delegacion/delegacionDetail.fxml"));
//        Parent delegacionDetail = loader.load();
//
//        DelegacionDetailController delegacionDetailController = loader.getController();
//        delegacionDetailController.showDelegacionDetail(delegacionSeleted);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setTitle("ONG Entre Culturas - Delegacion " + delegacionSeleted.getId());
//        window.setScene(new Scene(delegacionDetail, 500, 500));
//    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        Parent index = FXMLLoader.load(getClass().getResource("../../views/index.fxml"));
        Stage window = (Stage) homeBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas");
        window.setScene(new Scene(index, 500, 500));
    }

    @FXML
    void goToAddProyecto(ActionEvent event) throws IOException {
//        Parent index = FXMLLoader.load(getClass().getResource("../../views/delegacion/delegacionForm.fxml"));
//        Stage window = (Stage) homeBtn.getScene().getWindow();
//        window.setTitle("ONG Entre Culturas - Nueva Delegación");
//        window.setScene(new Scene(index, 500, 500));
    }
}
