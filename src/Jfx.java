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
        primaryStage.setScene(new Scene(rootG, 200, 750));
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();

        Stage stgQ = new Stage();
        FXMLLoader loaderQ = new FXMLLoader(getClass().getResource("gConsultes.fxml"));
        Parent rootQ = loaderQ.load();
        stgQ.setTitle("Consultes");
        stgQ.setScene(new Scene(rootQ, 1100, 400));
        stgQ.setX(210);
        stgQ.setY(0);
        stgQ.show();

        Stage stgAltaLlibre = new Stage();
        FXMLLoader loaderALl = new FXMLLoader(getClass().getResource("gAltaLlibre.fxml"));
        Parent rootALl = loaderALl.load();
        stgAltaLlibre.setTitle("Alta Llibre");
        stgAltaLlibre.setScene(new Scene(rootALl, 350, 300));
        stgAltaLlibre.setX(210);
        stgAltaLlibre.setY(450);
        stgAltaLlibre.show();

        Stage stgAltaSoci = new Stage();
        FXMLLoader loaderSoc = new FXMLLoader(getClass().getResource("gAltaSoci.fxml"));
        Parent rootSoc = loaderSoc.load();
        stgAltaSoci.setTitle("Alta Soci");
        stgAltaSoci.setScene(new Scene(rootSoc, 350, 300));
        stgAltaSoci.setX(570);
        stgAltaSoci.setY(450);
        stgAltaSoci.show();

        Stage stgPrestec = new Stage();
        FXMLLoader loaderPrestec = new FXMLLoader(getClass().getResource("gPrestecs.fxml"));
        Parent rootPrestec = loaderPrestec.load();
        stgPrestec.setTitle("Nou prestec");
        stgPrestec.setScene(new Scene(rootPrestec, 350, 300));
        stgPrestec.setX(930);
        stgPrestec.setY(450);
        stgPrestec.show();

    }
}
