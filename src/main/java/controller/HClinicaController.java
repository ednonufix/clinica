/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import util.AdminStages;
import util.TGraficos;

/**
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class HClinicaController implements Initializable {

    @FXML
    private MenuItem btn_cerrar = new MenuItem();

    @FXML
    private MenuItem item_paciente = new MenuItem();

    @FXML
    private MenuItem item_diag = new MenuItem();

    @FXML
    private MenuItem item_def = new MenuItem();
    
    @FXML
    private MenuItem item_tratamiento = new MenuItem();
    
    @FXML
    private AnchorPane anchor = new AnchorPane();
        
    @FXML
    private void CerrarApp(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    private void Mostrar_Paciente(ActionEvent event) throws IOException {

        AdminStages.Singleton().Mostrar_Paciente();

    }

    @FXML
    private void Mostrar_Diag(ActionEvent event) throws IOException {

        AdminStages.Singleton().Mostrar_Diagnostico();

    }
    
    @FXML
    private void Mostrar_Def(ActionEvent event) throws IOException {

        AdminStages.Singleton().Mostrar_Deficiencias();

    }
    
    @FXML
    private void Mostrar_Tratamiento(ActionEvent event) throws IOException {

        AdminStages.Singleton().Mostrar_Tratamiento();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btn_cerrar.setGraphic(TGraficos.Singleton().getCerrar());
        
    }

}
