/*
 * Copyright (C) 2016 Eduardo Noel Núñez <enoel@cubalub.cupet.cu>
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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import persistencia.TPaciente;
import util.DbUtil;

/**
 * FXML Controller class
 *
 * @author Eduardo Noel Núñez <enoel@cubalub.cupet.cu>
 */
public class BuscarPacientesController implements Initializable {

    @FXML
    private TableView<TPaciente> tabla = new TableView();

    @FXML
    private TableColumn<TPaciente, String> co_ci = new TableColumn<>();

    @FXML
    private TableColumn<TPaciente, String> co_nombre = new TableColumn<>();

    @FXML
    private TableColumn<TPaciente, String> co_apell = new TableColumn<>();

    @FXML
    private TextField edt_ci = new TextField();

    @FXML
    private void Llenar_Tabla() {

        String churre_ci = "%";
        String ci = edt_ci.getText();

        if (!(ci + churre_ci).startsWith("%")) {

            ObservableList<TPaciente> lista = DbUtil.Singleton().Lista_Paciente_dado_CI(ci + churre_ci);

            tabla.setItems(lista);
            tabla.refresh();

        } else {
        
            tabla.setItems(FXCollections.emptyObservableList());
        
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        co_ci.setCellValueFactory(new PropertyValueFactory("ci"));
        co_nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        co_apell.setCellValueFactory(new PropertyValueFactory("apellidos"));

    }

}
