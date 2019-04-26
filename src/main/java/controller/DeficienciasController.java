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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import org.hibernate.HibernateException;
import persistencia.TDeficiencias;
import util.AdminStages;
import util.DbUtil;
import util.TGraficos;

/**
 * FXML Controller class
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class DeficienciasController implements Initializable {

    @FXML
    private Button btn_cerrar_def = new Button();

    @FXML
    private TableView<TDeficiencias> tabla_def = new TableView();

    @FXML
    private TableColumn<TDeficiencias, Long> tb_no_def = new TableColumn<>();

    @FXML
    private TableColumn<TDeficiencias, String> tb_def = new TableColumn<>();

    @FXML
    private TextField nombre_def = new TextField();

    @FXML
    private Button btn_agregar_def = new Button();

    @FXML
    private MenuItem menu_borrar_def = new MenuItem();

    @FXML
    private void Cerrar_Def(ActionEvent event) throws IOException {

        AdminStages.Singleton().Cerrar_Def();

    }

    @FXML
    private void Guardar_Def(ActionEvent event) {

        try {

            TDeficiencias valor = new TDeficiencias();
            valor.setDeficiencia(nombre_def.getText().toUpperCase());

            DbUtil.Singleton().Crear_Def(valor);
            Actualizar_Tabla();
            Reset();

            msg_ok();

        } catch (HibernateException ex) {

            msg_err(ex.getMessage());

        }

    }

    @FXML
    private void Borrar_Def() {

        try {

            ObservableList<TDeficiencias> diag = tabla_def.getSelectionModel().getSelectedItems();

            diag.forEach(valor -> {

                DbUtil.Singleton().Borrar_Deficiencias(valor.getId_def());

            });

            Actualizar_Tabla();

            msg_ok_delete();

        } catch (HibernateException ex) {

            msg_err(ex.getMessage());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_cerrar_def.setGraphic(TGraficos.Singleton().getCerrar());
        btn_agregar_def.setGraphic(TGraficos.Singleton().getNuevo());
        menu_borrar_def.setGraphic(TGraficos.Singleton().getDel());

        ObservableList<TDeficiencias> data = DbUtil.Singleton().Lista_Def();

        tb_no_def.setCellValueFactory(new PropertyValueFactory("id_def"));
        tb_def.setCellValueFactory(new PropertyValueFactory("deficiencia"));

        tabla_def.setItems(data);

        tabla_def.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    private void msg_ok() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText("Registro guardado exitosamente");
        alert.getDialogPane().setHeaderText(null);
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK);

    }

    private void msg_ok_delete() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText("Registro(s) borrado exitosamente");
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

    public void Actualizar_Tabla() {

        ObservableList<TDeficiencias> data = DbUtil.Singleton().Lista_Def();

        tabla_def.setItems(data);
        tabla_def.refresh();

    }

    public void Reset() {

        nombre_def.setText(null);

    }

}
