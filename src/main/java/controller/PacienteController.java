/*
 * Copyright (C) 2016 Eduardo Noel <enoel.corebsd@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package controller;

import java.net.ConnectException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import org.hibernate.HibernateException;
import persistencia.TPaciente;
import util.AdminStages;
import util.DbUtil;
import util.TGraficos;

/**
 * FXML Controller class
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class PacienteController implements Initializable {

    @FXML
    private TextField nombre = new TextField();

    @FXML
    private TextField apellidos = new TextField();

    @FXML
    private TextField edad = new TextField();

    @FXML
    private TextField ci = new TextField();

    @FXML
    private ComboBox<Character> sexo = new ComboBox<>();

    @FXML
    private DatePicker alta = new DatePicker();

    @FXML
    private Button btn_agregar = new Button();

    @FXML
    private Button btn_cancelar = new Button();

    @FXML
    private void Cerrar_Paciente(ActionEvent event) {

        AdminStages.Singleton().Cerrar_Paciente();

    }

    @FXML
    private void Crear_Paciente() {

        try {

            TPaciente pac = new TPaciente();

            pac.setNombre(nombre.getText());
            pac.setApellidos(apellidos.getText());
            pac.setCi(ci.getText());
            pac.setEdad(Integer.parseInt(edad.getText()));
            pac.setSexo(sexo.getValue());
            pac.setFecha_ingreso(alta.getValue());

            DbUtil.Singleton().Crear_Paciente(pac);

            msg_ok();

        }
        catch (NumberFormatException | HibernateException | SQLException ex) {

            msg_err(ex.getMessage());

        }
        finally {

            Reset();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        sexo.getItems().add('M');
        sexo.getItems().add('F');
        sexo.getSelectionModel().select(-1);
        alta.setValue(LocalDate.now());
        
        btn_agregar.setGraphic(TGraficos.Singleton().getNuevo());
        btn_cancelar.setGraphic(TGraficos.Singleton().getCerrar());

    }

    private void Reset() {

        nombre.setText(null);
        apellidos.setText(null);
        edad.setText(null);
        ci.setText(null);
        sexo.getSelectionModel().select(-1);
        alta.setValue(LocalDate.now());

    }

    private void msg_ok() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText("Registro guardado exitosamente");
        alert.getDialogPane().setHeaderText(null);
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK);

    }

    private void msg_err(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText(error);
        alert.getDialogPane().setHeaderText(null);
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK);

    }

}
