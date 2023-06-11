/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package walett.go.proyectofinal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;
import model.*;
import persistencia.*;
import logic.*;

/**
 * FXML Controller class
 *
 * * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class registerController implements Initializable {

    @FXML
    private Hyperlink hvIniciarSesion;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtUsuario, txtEmail;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private StackPane stackpaneRegistar;
    
    private logica logica;

    @FXML
    public void clickIniciarSesion(ActionEvent a) throws IOException{
        
        App.setRoot("login");    
        // Crear la nueva escena que deseas mostrar al hacer clic en el hipervínculo
//        StackPane login = new StackPane(App.loadFXML("login"));
//        Scene newScene = new Scene(login, 1280, 768);
//
//        // Obtener la referencia al Stage actual
//        Stage currentStage = (Stage) stackpaneRegistar.getScene().getWindow();
//
//        // Cambiar la escena actual del Stage a la nueva escena
//        currentStage.setScene(newScene);
    }

    @FXML
    public void clickRegistrar(ActionEvent a) throws IOException, RuntimeException {
        if (a.getSource() == this.btnRegistrar) {
            try {
                    Usuario user = this.leerDatosUsuario();
                    this.logica.registrarUsuario(user);
                    System.out.println(user);
                    Alert alertas = new Alert(Alert.AlertType.CONFIRMATION);
                    alertas.setTitle("Registro exitoso");
                    alertas.setContentText("Usuario registrado");
                    alertas.showAndWait();
            } 
            catch (IOException ioe) {
                    Alert alertas = new Alert(Alert.AlertType.ERROR);
                    alertas.setTitle("Registro incorrecto");
                    alertas.setContentText("Usuario no registrado");
                    alertas.showAndWait();
            }
            catch (RuntimeException re) {
                    Alert alertas = new Alert(Alert.AlertType.ERROR);
                    alertas.setTitle("Registro incorrecto");
                    alertas.setContentText("Usuario no registrado");
                    alertas.showAndWait();
            }
        }
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logica = new logica();
    }
    
    private Usuario leerDatosUsuario() {
        Usuario user = null;
        String usuario = this.txtUsuario.getText();
        String correo = this.txtEmail.getText();
        String contraseña = this.txtContraseña.getText();
        
        user = new Usuario(usuario, correo, contraseña);
        
        return user;
    }

}
