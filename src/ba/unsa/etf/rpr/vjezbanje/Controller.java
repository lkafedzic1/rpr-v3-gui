package ba.unsa.etf.rpr.vjezbanje;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller {
    public TextArea textArea;

    public void akcijaKraj(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void actionOpen(ActionEvent actionEvent) {
        FileChooser izbornik = new FileChooser();
        izbornik.setTitle("Izaberite datoteku");
        izbornik.getExtensionFilters().add(new FileChooser.ExtensionFilter("Tekstualna datoteka","*.txt"));
        File izabrani = izbornik.showOpenDialog(textArea.getScene().getWindow());
        try {
            String tekst = new String (Files.readAllBytes(izabrani.toPath()));
            textArea.setText(tekst);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Došlo je do greške prilikom čitanja " + izabrani.getName());
            alert.setContentText(e.getMessage());
            alert.setTitle("Ne mogu otvoriti datoteku");
            alert.showAndWait();
        }
    }

    public void actionNewWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/properties.fxml"));
        stage.setTitle("Properties");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE ,  400));
        stage.setResizable(false);
        stage.show();
    }
}
