import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mat on 13/01/2016.
 */
@Entity
public class Soci implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Type(type="integer")
    //@Column(name="ID_soci")
    private Integer id_soci = null;

    @Lob
    //@Column(name="NOM")
    private String nom_soci = null;

    @Lob
    //@Column(name="COGNOM")
    private String cognom_soci = null;

    @Type(type="integer")
    //@Column(name="EDAT")
    private Integer edat = null;

    @Lob
    //@Column(name="DIRECCIO")
    private String direccio = null;

    @Lob
    //@Column(name="TELEFON")
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

    public  Soci(){}

    public Integer getId_soci() {
        return id_soci;
    }

    public void setId_soci(Integer id_soci) {
        this.id_soci = id_soci;
    }

    public String getNom_soci() {
        return nom_soci;
    }

    public void setNom_soci(String nom_soci) {
        this.nom_soci = nom_soci;
    }

    public String getCognom_soci() {
        return cognom_soci;
    }

    public void setCognom_soci(String cognom_soci) {
        this.cognom_soci = cognom_soci;
    }

    public Integer getEdat() {
        return edat;
    }

    public void setEdat(Integer edat) {
        this.edat = edat;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
