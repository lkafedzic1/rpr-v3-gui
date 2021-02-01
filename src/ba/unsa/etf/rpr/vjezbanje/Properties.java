package ba.unsa.etf.rpr.vjezbanje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Properties {
    public Button btnCancel;
    public TextField fdPrezime;
    public TextField fdIme;
    public DatePicker dateRodjenja;

    @FXML
    public void initialize() {
        fdIme.textProperty().addListener((obs, stara, nova)->{
            if(fdIme.getText().isEmpty()) {
                fdIme.getStyleClass().removeAll("poljeIspravno");
                fdIme.getStyleClass().add("poljeNeispravno");
            } else {
                fdIme.getStyleClass().removeAll("poljeNeispravno");
                fdIme.getStyleClass().add("poljeIspravno");
            }
        });
        fdPrezime.textProperty().addListener((obs, stara, nova) -> {
            if(fdPrezime.getText().isEmpty()) {
                fdPrezime.getStyleClass().removeAll("poljeIspravno");
                fdPrezime.getStyleClass().add("poljeNeispravno");
            } else {
                fdPrezime.getStyleClass().removeAll("poljeNeispravno");
                fdPrezime.getStyleClass().add("poljeIspravno");
            }
        });
        dateRodjenja.getEditor().textProperty().addListener((obs, stara, nova) -> {
            if(dateRodjenja.getEditor().getText().equals("") || dateRodjenja.getValue() == null || (dateRodjenja.getValue().isAfter(LocalDate.now()))) {
                dateRodjenja.getEditor().getStyleClass().removeAll("poljeIspravno");
                dateRodjenja.getEditor().getStyleClass().add("poljeNeispravno");
            } else {
                dateRodjenja.getEditor().getStyleClass().removeAll("poljeNeispravno");
                dateRodjenja.getEditor().getStyleClass().add("poljeIspravno");
            }
        });
    }

    public void actionClose(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void actionSubmit(ActionEvent actionEvent) {
        if(!validiraj()) return;
    }

    private boolean validiraj() {
        boolean sveIspravno = true;
        if(fdIme.getText().isEmpty()) {
            sveIspravno = false;
            fdIme.getStyleClass().removeAll("poljeIspravno");
            fdIme.getStyleClass().add("poljeNeispravno");
            fdIme.requestFocus();
        } else {
            fdIme.getStyleClass().removeAll("poljeNeispravno");
            fdIme.getStyleClass().add("poljeIspravno");
        }
        if(fdPrezime.getText().isEmpty()) {
            sveIspravno = false;
            fdPrezime.getStyleClass().removeAll("poljeIspravno");
            fdPrezime.getStyleClass().add("poljeNeispravno");
            fdPrezime.requestFocus();
        } else {
            fdPrezime.getStyleClass().removeAll("poljeNeispravno");
            fdPrezime.getStyleClass().add("poljeIspravno");
        }
        if( dateRodjenja.getValue() == null || (dateRodjenja.getValue().isAfter(LocalDate.now()))) {
            dateRodjenja.getEditor().getStyleClass().removeAll("poljeIspravno");
            dateRodjenja.getEditor().getStyleClass().add("poljeNeispravno");
            dateRodjenja.requestFocus();
        } else {
            dateRodjenja.getEditor().getStyleClass().removeAll("poljeNeispravno");
            dateRodjenja.getEditor().getStyleClass().add("poljeIspravno");
        }
        return sveIspravno;
    }
}
