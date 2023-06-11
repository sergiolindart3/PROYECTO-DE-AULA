
package walett.go.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logic.logica;
import model.Usuario;
import persistencia.fileObjetos;

/**
 * * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class LoginController implements Initializable {

    @FXML
    private Hyperlink hvRegistrar;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField password;

    @FXML
    private Button btnRegistrar;
    
    @FXML
    private StackPane stackPaneLogin;
    
    private fileObjetos fileObjetosManager;
    
    private Stage stage;


    @FXML
    public void clickRegistrar(ActionEvent a) throws IOException {
        App.setRoot("register");
    }

    public void clickIniciarSesion(ActionEvent e) throws IOException {
        String correo = txtUsuario.getText();
        String contraseña = password.getText();
        
        
        try {
            Usuario usuario = this.fileObjetosManager.buscarUsuario(correo);
            if (usuario != null && usuario.getContraseña().equals(contraseña)) {
                Alert alertas = new Alert(Alert.AlertType.CONFIRMATION);
                alertas.setTitle("Login exitoso");
                alertas.setContentText("Ingresó correctamente");
                alertas.showAndWait();
//                Scene scene = new Scene(loadFXML("menu"), 1600, 900);
//                stage = (Stage) stackPaneLogin.getScene().getWindow();
//                stage.setScene(scene);
//
//                stage.setResizable(false);
//                stage.show();
                  
            } else {
                Alert alertas = new Alert(Alert.AlertType.ERROR);
                alertas.setTitle("Login Error");
                alertas.setContentText("Usuario incorrecto o no existe");
                alertas.showAndWait();
            }
        } 
        catch (IOException ioe) {
            Alert alertas = new Alert(Alert.AlertType.ERROR);
            alertas.setTitle("Login Error");
            alertas.setContentText("Error al leer el archivo");
            alertas.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileObjetosManager = new fileObjetos();
    }

    private Parent loadFXML(String menu) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(menu + ".fxml"));
        return fxmlLoader.load();
    }

}
