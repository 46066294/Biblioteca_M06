import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Date;

/**
 * Created by Mat on 16/01/2016.
 */
public class Controller {
 
    @FXML
    Button bAltaLlibre = new Button("Alta llibre");
    @FXML
    Button bBaixaLlibre = new Button("Baixa llibre");
    @FXML
    Button bModifLlibre = new Button("Modificar llibre");

    @FXML
    Button bAltaSoci = new Button("Alta llibre");
    @FXML
    Button bBaixaSoci = new Button("Baixa llibre");
    @FXML
    Button bModifSoci = new Button("Modificar llibre");


    @FXML
    Button bSortir = new Button("Sortir");

    /*
    * String sql = "CREATE TABLE LLIBRES " +
                    "(ID_LLIBRE     INT PRIMARY KEY   NOT NULL," +
                    " TITOL         TEXT              NOT NULL," +
                    " N_EXEMPLARS   INT               NOT NULL," +
                    " EDITORIAL     TEXT              NOT NULL," +
                    " PAGINES       INT               NOT NULL," +
                    " ANY_EDICIO    DATE              NOT NULL)";*/
    String titol;
    Integer nExemplars;
    String editorial;
    Integer pagines;
    Integer any;

    public void altaLlibre()throws Exception{
        Stage stg = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gAltaLlibre.fxml"));
        Parent p = loader.load();
        stg.setTitle("Alta Llibre");
        stg.setScene(new Scene(p, 600, 400));
        stg.show();

        TextField tfTitolLlibre = new TextField();
        TextField tfNombreExemplars = new TextField();
        TextField tfEditorial = new TextField();
        TextField tfPagines = new TextField();
        TextField tfAny = new TextField();
        Button btAccepta = new Button("Accepta");

        titol = tfTitolLlibre.getText();
        nExemplars = Integer.valueOf(tfNombreExemplars.getText());
        editorial = tfEditorial.getText();
        pagines = Integer.valueOf(tfPagines.getText());
        any = Integer.valueOf(tfAny.getText());

    }

    public void  fSortir(){
        Platform.exit();
    }

    public void fAltaLlibre() {
        DataAccessObject.fDAOaltaLlibre(titol, nExemplars, editorial, pagines, any);
    }
}
