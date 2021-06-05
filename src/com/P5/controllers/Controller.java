package com.P5.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.P5.repositories.DelegacionRepository;

public class Controller {

    @FXML
    void goToProjects(ActionEvent event) {
        System.out.println(DelegacionRepository.getAll());
    }

}
