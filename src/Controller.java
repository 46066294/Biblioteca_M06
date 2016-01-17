import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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


    @FXML
    TextField tfId = new TextField();

    @FXML
    TextField tfTitolLlibre = new TextField();
    @FXML
    TextField tfNombreExemplars = new TextField();
    @FXML
    TextField tfEditorial = new TextField();
    @FXML
    TextField tfPagines = new TextField();
    @FXML
    TextField tfAny = new TextField();
    @FXML
    Button btAccepta = new Button("Accepta");

    @FXML
    TextField tfIdLlibre = new TextField();
//----------------------------------------------------------------------------

    @FXML
    TextField tfIdSoci = new TextField();
    @FXML
    TextField tfNomSoci = new TextField();
    @FXML
    TextField tfCognomSoci = new TextField();
    @FXML
    TextField tfEdat = new TextField();
    @FXML
    TextField tfDireccio = new TextField();
    @FXML
    TextField tfTelefon = new TextField();

    //LLIBRES
    private Integer idLlibre;
    private String titol;
    private Integer nExemplars;
    private String editorial;
    private Integer pagines;
    private Integer any;

    //SOCIS
    private Integer idSoci;
    private String nomSoci;
    private String cognomSoci;
    private Integer edat;
    private String direccio;
    private String telefon;

    @FXML
    TextArea taQuerys = new TextArea();

    /**
     * Nova stage per a interficie alta de llibre
     * @throws Exception
     */
    public void altaLlibre()throws Exception{
        Stage stg = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gAltaLlibre.fxml"));
        Parent p = loader.load();
        stg.setTitle("Alta Llibre");
        stg.setScene(new Scene(p, 350, 300));
        stg.show();

        //System.out.println(titol + " :: " + nExemplars + " :: " + editorial + " :: " + pagines + " :: " + any);
    }

    /**
     * Metode que s'activa quan es clica
     * al boto -accepta- de alta llibre
     */
    public void fAltaLlibre() {
        //System.out.println(titol + " :: " + nExemplars + " :: " + editorial + " :: " + pagines + " :: " + any);

        titol = tfTitolLlibre.getText();
        nExemplars = Integer.valueOf(tfNombreExemplars.getText());
        editorial = tfEditorial.getText();
        pagines = Integer.valueOf(tfPagines.getText());
        any = Integer.valueOf(tfAny.getText());

        System.out.println(titol + " :: " + nExemplars + " :: " + editorial + " :: " + pagines + " :: " + any);
        //System.out.println(titol);

        DataAccessObject.fDAOaltaLlibre(titol, nExemplars, editorial, pagines, any);
    }

    /**
     * Nova stage per les baixes
     * @throws Exception
     */
    public void baixaLlibre()throws Exception{
        Stage stg = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gBaixaLlibre.fxml"));
        Parent p = loader.load();
        stg.setTitle("Baixa Llibre");
        stg.setScene(new Scene(p, 300, 200));
        stg.show();
        System.out.println();
    }

    /**
     * Dona de baixa el llibre
     */
    public void fBaixaLlibre() {

        idLlibre = Integer.valueOf(tfIdLlibre.getText());
        titol = tfTitolLlibre.getText();
        editorial = tfEditorial.getText();

        System.out.println("Id_llibre: " + idLlibre);

        DataAccessObject.fDAObaixaLlibre(idLlibre);
    }

    /**
     * Nova stage per a interficie alta de llibre
     * @throws Exception
     */
    public void modifLlibre()throws Exception{
        Stage stg = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gModifLlibre.fxml"));
        Parent p = loader.load();
        stg.setTitle("Modificar Llibre");
        stg.setScene(new Scene(p, 350, 300));
        stg.show();

        System.out.println("" + "");
    }

    public void fModifLlibre() {
        idLlibre = Integer.valueOf(tfId.getText());
        titol = tfTitolLlibre.getText();
        nExemplars = Integer.valueOf(tfNombreExemplars.getText());
        editorial = tfEditorial.getText();
        pagines = Integer.valueOf(tfPagines.getText());
        any = Integer.valueOf(tfAny.getText());

        System.out.println(idLlibre + " :: " + titol + " :: " + nExemplars +
                " :: " + editorial + " :: " + pagines + " :: " + any);

        DataAccessObject.fDAOModifLlibre(idLlibre, titol, nExemplars, editorial, pagines, any);
    }




















    /**
     * Nova stage per a interficie alta de soci
     * @throws Exception
     */
    public void altaSoci()throws Exception{
        System.out.println("" + "");
        Stage stg = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gAltaSoci.fxml"));
        Parent p = loader.load();
        stg.setTitle("Alta Soci");
        stg.setScene(new Scene(p, 350, 300));
        stg.show();
        System.out.println("" + "");
    }

    /**
     * Metode que s'activa quan es clica
     * al boto -accepta- de alta Soci
     */
    public void fAltaSoci() {

        nomSoci = tfNomSoci.getText();
        cognomSoci = tfCognomSoci.getText();
        edat = Integer.valueOf(tfEdat.getText());
        direccio = tfDireccio.getText();
        telefon = tfTelefon.getText();

        System.out.println(titol + " :: " + nExemplars + " :: " + editorial + " :: " + pagines + " :: " + any);
        //System.out.println(titol);

        DataAccessObject.fDAOaltaSoci(nomSoci, cognomSoci, edat, direccio, telefon);
    }

    /**
     * Nova stage per les baixes
     * @throws Exception
     */
    public void baixaSoci()throws Exception{
        Stage stg = new Stage();
        System.out.println();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gBaixaSoci.fxml"));
        Parent p = loader.load();
        stg.setTitle("Baixa Soci");
        stg.setScene(new Scene(p, 300, 200));
        stg.show();
        System.out.println();
    }

    /**
     * Dona de baixa el soci
     */
    public void fBaixaSoci() {

        idSoci = Integer.valueOf(tfIdSoci.getText());

        System.out.println("Id_Soci: " + idSoci);

        DataAccessObject.fDAObaixaSoci(idSoci);
    }

    /**
     * Nova stage per a interficie modificar soci
     * @throws Exception
     */
    public void modifSoci()throws Exception{
        Stage stg = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gModifSoci.fxml"));
        Parent p = loader.load();
        stg.setTitle("Modificar dades de Soci");
        stg.setScene(new Scene(p, 350, 300));
        stg.show();
        System.out.println();
        System.out.println();

    }

    public void fModifSoci() {
        idSoci = Integer.valueOf(tfIdSoci.getText());
        nomSoci = tfNomSoci.getText();
        cognomSoci = tfCognomSoci.getText();
        edat = Integer.valueOf(tfEdat.getText());
        direccio = tfDireccio.getText();
        telefon = tfTelefon.getText();

        System.out.println(idSoci + " :: " + nomSoci + " :: " + cognomSoci +
                " :: " + edat + " :: " + direccio + " :: " + telefon);

        DataAccessObject.fDAOModifSoci(idSoci, nomSoci, cognomSoci, edat, direccio, telefon);
    }


    public void  consultes() throws IOException {

        Stage stg = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gConsultes.fxml"));
        Parent p = loader.load();
        stg.setTitle("Modificar dades de Soci");
        stg.setScene(new Scene(p, 700, 400));
        stg.show();
        System.out.println();


        //DataAccessObject.fDAOqueryLlibres();
    }

    public void  queryTotsLlibres() throws IOException {
        String out = DataAccessObject.fDAOqueryLlibres();
        taQuerys.setText(out);
    }

    public void  queryTotsSocis() throws IOException {
        String out = DataAccessObject.fDAOquerySocis();
        taQuerys.setText(out);
    }

    public void  fSortir(){
        Platform.exit();
    }

}
