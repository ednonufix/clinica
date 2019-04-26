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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Eduardo Noel Núñez <enoel@cubalub.cupet.cu>
 */
public class NuevoTController implements Initializable {

    @FXML
    private Label lbl_nombre = new Label();
    
    @FXML
    private ComboBox<String> combo_lugar = new ComboBox<>();
    
    @FXML
    private ListView<String> list_diag = new ListView<>();
    
    @FXML
    private ComboBox<String> combo_referencia = new ComboBox<>();
    
    @FXML
    private CheckBox check_presuntivo = new CheckBox();

    @FXML
    private CheckBox check_confirmado = new CheckBox();
    
    @FXML
    private DatePicker fecha_ingreso = new DatePicker();
    
    @FXML
    private DatePicker fecha_egreso = new DatePicker();
    
    @FXML
    private Button btn_cerrar = new Button();
    
    @FXML
    private Button btn_crear = new Button();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }
    
}
