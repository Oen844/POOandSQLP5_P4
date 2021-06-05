package com.P5.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Dialog {
    public static void error(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR, text, ButtonType.CLOSE);
        alert.showAndWait();
    }
}
