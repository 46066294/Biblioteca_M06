/**
 * Created by Mat on 16/01/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Jfx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {
        FXMLLoader loaderG = new FXMLLoader(getClass().getResource("Grafica.fxml"));
        Parent rootG = loaderG.load();
        primaryStage.setTitle("Biblioteca MC");
        primaryStage.setScene(new Scene(rootG, 200, 500));
        primaryStage.setX(100);
        primaryStage.setY(100);
        primaryStage.show();

        Stage stgQ = new Stage();
        FXMLLoader loaderQ = new FXMLLoader(getClass().getResource("gConsultes.fxml"));
        Parent rootQ = loaderQ.load();
        stgQ.setTitle("Consultes");
        stgQ.setScene(new Scene(rootQ, 700, 400));

        stgQ.show();

    }
}
