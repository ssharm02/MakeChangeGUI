package Assignment5_Sarthak_Sharma;

/**
 * 
 * Sarthak Sharma
 * PROG24178 JAVA 2 Professor Johnathan Penava 
 * Summary: makeChange with GUI now accepts dollar amount up 99
 * OOP Java 2
 * Make change main simply calls makeChangeGUI
 */
/**
 *
 * @author SarthaksComp

 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class makeChangeMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("makeChangeGUI.fxml"));
        
        Scene scene = new Scene(root);
        
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

