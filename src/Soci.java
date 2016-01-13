/**
 * Created by Mat on 13/01/2016.
 */
public class Soci {

    private Integer id_soci = null;
    private String nom_soci = null;
    private String cognom_soci = null;
    private Integer edat = null;
    private String direccio = null;
    private String telefon = null;

    public Soci(Integer id_soci, String nom_soci,
                String cognom_soci, Integer edat, String direccio, String telefon){

        this.id_soci = id_soci;
        this.nom_soci = nom_soci;
        this.cognom_soci = cognom_soci;
        this.edat = edat;
        this.direccio = direccio;
        this.telefon = telefon;
    }
}
