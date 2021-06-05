package com.P5.controllers.proyectos;

import com.P5.entities.Delegacion;
import com.P5.entities.Proyecto;
import com.P5.repositories.DelegacionRepository;
import com.P5.repositories.ProyectoRepository;
import com.P5.utils.Dialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.exception.ConstraintViolationException;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ProyectoFormController implements Initializable {

    @FXML
    private Label formTitle;

    @FXML
    private Button proyectoLayoutBtn;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField paisField;

    @FXML
    private TextField localizacionField;

    @FXML
    private TextField lineaAccionField;

    @FXML
    private TextField subLineaAccionField;

    @FXML
    private DatePicker fechaInicioField;

    @FXML
    private DatePicker fechaFinField;

    @FXML
    private TextField socioLocalField;

    @FXML
    private TextField financiadorField;

    @FXML
    private TextField financiacionAportadaField;

    @FXML
    private ChoiceBox<Delegacion> selectDelegacionField;

    @FXML
    private Button saveBtn;

    private Proyecto proyecto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Delegacion> delegaciones = DelegacionRepository.getAll();
        ObservableList<Delegacion> delegacionesData = FXCollections.observableArrayList(delegaciones);
        selectDelegacionField.setItems(delegacionesData);
    }

    @FXML
    void goToProyectoLayout(ActionEvent event) throws IOException {
        Parent delegacionesLayout = FXMLLoader.load(getClass().getResource("../../views/proyecto/proyectosLayout.fxml"));
        Stage window = (Stage) proyectoLayoutBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Proyectos");
        window.setScene(new Scene(delegacionesLayout, 500, 500));
    }

    @FXML
    void addNewProyecto(ActionEvent event) {
        String nombre = nombreField.getText();
        String pais = paisField.getText();
        String localizacion = localizacionField.getText();
        String lineaAccion = lineaAccionField.getText();
        String subLineaAccion = subLineaAccionField.getText();
        LocalDate fechaInicio = fechaInicioField.getValue();
        LocalDate fechaFin = fechaFinField.getValue();
        String socioLocal = socioLocalField.getText();
        String financiador = financiadorField.getText();
        String financiacionAportada = financiacionAportadaField.getText();
        Delegacion delegacion = selectDelegacionField.getValue();

        if (!nombre.isEmpty() && !pais.isEmpty() && !localizacion.isEmpty() && !lineaAccion.isEmpty()
                && !subLineaAccion.isEmpty() && fechaInicio != null && fechaFin != null && !socioLocal.isEmpty()
                && !financiador.isEmpty() && !financiacionAportada.isEmpty() && delegacion != null) {
            if (this.proyecto != null) {
//                delegacion.setCiudad(ciudad);
//                delegacion.setDireccion(direccion);
//                delegacion.setTelefono(telefono);
//                delegacion.setEmail(email);
//                delegacion.setCentral(centralFieldYes.isSelected());
            } else {
                proyecto = new Proyecto(nombre, pais, localizacion, lineaAccion, subLineaAccion,
                        new Date(fechaInicio.toEpochDay()), new Date(fechaFin.toEpochDay()), socioLocal, financiador,
                        financiacionAportada, delegacion);
            }

            try {
                ProyectoRepository.save(proyecto);
                goToProyectoLayout(null);
            } catch (ConstraintViolationException cve) {
                Dialog.error(cve.getSQLException().getMessage());
            } catch (IOException e) {
                Dialog.error(e.getMessage());
            }
        } else {
            Dialog.error("Todos los campos son obligatorios.");
        }
    }

//    public void editDelegacion(Delegacion delegacionSeleted) {
//        this.delegacion = delegacionSeleted;
//        formTitle.setText("Editar Delegación");
//
//        direccionField.setText(delegacionSeleted.getDireccion());
//        ciudadField.setText(delegacionSeleted.getCiudad());
//        emailField.setText(delegacionSeleted.getEmail());
//        telefonoField.setText(delegacionSeleted.getTelefono());
//        centralFieldYes.setSelected(delegacionSeleted.getCentral());
//        centralFieldNo.setSelected(!delegacionSeleted.getCentral());
//    }
}
