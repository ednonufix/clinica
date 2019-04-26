/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class AdminStages {

    final Stage stage_paciente = new Stage();
    final Stage stage_diag = new Stage();
    final Stage stage_def = new Stage();
    final Stage stage_tratamiento = new Stage();

    private AdminStages() {
    }

    public static AdminStages Singleton() {
        return AdminStagesHolder.INSTANCE;
    }

    private static class AdminStagesHolder {

        private static final AdminStages INSTANCE = new AdminStages();
    }

    public void Cerrar_Paciente() {

        stage_paciente.close();

    }

    public void Cerrar_Def() {

        stage_def.close();

    }

    public void Mostrar_Paciente() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Paciente.fxml"));

        Scene scene = new Scene(root);

        stage_paciente.setScene(scene);

        stage_paciente.setTitle("Insertar Paciente");
        stage_paciente.getIcons().add(TGraficos.Singleton().getIcon());
        stage_paciente.setResizable(false);
        stage_paciente.show();

    }

    public void Mostrar_Diagnostico() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Diagnostico.fxml"));

        Scene scene = new Scene(root);

        stage_diag.setScene(scene);

        stage_diag.setTitle("Insertar Diagnóstico");
        stage_diag.getIcons().add(TGraficos.Singleton().getIcon());
        stage_diag.setResizable(false);
        stage_diag.show();

    }

    public void Mostrar_Deficiencias() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Deficiencias.fxml"));

        Scene scene = new Scene(root);

        stage_def.setScene(scene);

        stage_def.setTitle("Insertar Deficiencias");
        stage_def.getIcons().add(TGraficos.Singleton().getIcon());
        stage_def.setResizable(false);
        stage_def.show();

    }

    public void Mostrar_Tratamiento() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/BuscarPacientes.fxml"));

        Scene scene = new Scene(root);

        stage_tratamiento.setScene(scene);

        stage_tratamiento.setTitle("Tratamientos");
        stage_tratamiento.getIcons().add(TGraficos.Singleton().getIcon());
        stage_tratamiento.setResizable(false);
        stage_tratamiento.show();

    }
    
    public void Cerrar_Tratamiento(){
    
        stage_tratamiento.close();
        
    }

    public void Cerrar_Diag() {

        stage_diag.close();

    }

}
