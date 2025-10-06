package athome.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
    
@Override
public void start(Stage stage) throws Exception {
    stage.setScene(scene);
    stage.show();
}

    public static void main(String[] args) {
        
        launch(args);
    }
}
