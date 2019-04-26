package launch;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.TGraficos;

/**
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class TMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HClinica.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Gestión de Historias Clínicas");
        stage.getIcons().add(TGraficos.Singleton().getIcon());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
