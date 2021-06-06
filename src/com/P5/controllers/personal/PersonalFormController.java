package com.P5.controllers.personal;

import com.P5.entities.Delegacion;
import com.P5.entities.Personal;
import com.P5.repositories.DelegacionRepository;
import com.P5.repositories.PersonalRepository;
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
import java.util.List;
import java.util.ResourceBundle;

public class PersonalFormController implements Initializable {

    @FXML
    private Label formTitle;

    @FXML
    private Button proyectoLayoutBtn;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField nifField;

    @FXML
    private TextField direccionField;

//    @FXML
//    private TextField lineaAccionField;
//
//    @FXML
//    private TextField subLineaAccionField;
//
//    @FXML
//    private DatePicker fechaInicioField;
//
//    @FXML
//    private DatePicker fechaFinField;
//
//    @FXML
//    private TextField socioLocalField;
//
//    @FXML
//    private TextField financiadorField;
//
//    @FXML
//    private TextField financiacionAportadaField;

    @FXML
    private ChoiceBox<Delegacion> selectDelegacionField;

    @FXML
    private Button saveBtn;

    private Personal personal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Delegacion> delegaciones = DelegacionRepository.getAll();
        ObservableList<Delegacion> delegacionesData = FXCollections.observableArrayList(delegaciones);
        selectDelegacionField.setItems(delegacionesData);
    }

    @FXML
    void goToPersonalLayout(ActionEvent event) throws IOException {
        Parent personalLayout = FXMLLoader.load(getClass().getResource("../../views/personal/personalLayout.fxml"));
        Stage window = (Stage) proyectoLayoutBtn.getScene().getWindow();
        window.setTitle("ONG Entre Culturas - Personal");
        window.setScene(new Scene(personalLayout, 500, 500));
    }

    @FXML
    void addNewEmpleado(ActionEvent event) {
        String nombre = nombreField.getText();
        String nif = nifField.getText();
        String direccion = direccionField.getText();
        Delegacion delegacion = selectDelegacionField.getValue();

        if (!nombre.isEmpty() && !nif.isEmpty() && !direccion.isEmpty() && delegacion != null) {
            if (this.personal != null) {
//                proyecto.setNombre(nombre);
//                proyecto.setPais(pais);
//                proyecto.setLocalizacion(localizacion);
//                proyecto.setLineaAccion(lineaAccion);
//                proyecto.setSubLineaAccion(subLineaAccion);
//                proyecto.setFechaInicio(fechaInicioEpochMilli);
//                proyecto.setFechaFin(fechaFinEpochMilli);
//                proyecto.setSocioLocal(socioLocal);
//                proyecto.setFinanciador(financiador);
//                proyecto.setFinanciacionAportada(financiacionAportada);
//                proyecto.setDelegacion(delegacion);
            } else {
                personal = new Personal(nombre, nif, direccion, delegacion);
            }

            try {
                PersonalRepository.save(personal);
                goToPersonalLayout(null);
            } catch (ConstraintViolationException cve) {
                Dialog.error(cve.getSQLException().getMessage());
            } catch (IOException e) {
                Dialog.error(e.getMessage());
            }
        } else {
            Dialog.error("Todos los campos son obligatorios.");
        }
    }

//    public void editProyecto(Proyecto proyectoSelected) {
//        this.proyecto = proyectoSelected;
//        formTitle.setText("Editar Proyecto");
//
//        nombreField.setText(proyectoSelected.getNombre());
//        paisField.setText(proyectoSelected.getPais());
//        localizacionField.setText(proyectoSelected.getLocalizacion());
//        lineaAccionField.setText(proyectoSelected.getLineaAccion());
//        subLineaAccionField.setText(proyectoSelected.getSubLineaAccion());
//        fechaInicioField.setValue(LOCAL_DATE(proyectoSelected.getFechaInicio().toString()));
//        fechaFinField.setValue(LOCAL_DATE(proyectoSelected.getFechaFin().toString()));
//        socioLocalField.setText(proyectoSelected.getSocioLocal());
//        financiadorField.setText(proyectoSelected.getFinanciador());
//        financiacionAportadaField.setText(proyectoSelected.getFinanciacionAportada());
//        selectDelegacionField.setValue(proyectoSelected.getDelegacion());
//    }
//
//    private LocalDate LOCAL_DATE(String dateString) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return LocalDate.parse(dateString, formatter);
//    }
}
