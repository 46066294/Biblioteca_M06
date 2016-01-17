import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mat on 13/01/2016.
 */
@Entity
public class Prestec implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    //@Column(name="ID_PRESTEC")
    private Integer id_prestec = null;

    @OneToOne(targetEntity = Soci.class, fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_soci")
    //@Column(name="ID_SOCI")
    private Soci idSoci = null;

    @OneToOne(targetEntity = Llibre.class, fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_llibre")
    //@Column(name="ID_LLIBRE")
    private Llibre idLlibre = null;

    @Temporal(TemporalType.DATE)
    //@Column(name="ANY_EDICIO")
    private Date data_inici;

    @Temporal(TemporalType.DATE)
    //@Column(name="DATA_FINAL")
    private Date data_final;

    public Prestec(){}


    public Prestec(Integer id_prestec, Llibre id_llibre,
                   Soci id_soci){

        this.id_prestec = id_prestec;
        this.idLlibre = id_llibre;
        this.idSoci = id_soci;
    }

    public Integer getId_prestec() {
        return id_prestec;
    }

    public void setId_prestec(Integer id_prestec) {
        this.id_prestec = id_prestec;
    }

    public Soci getId_soci() {
        return idSoci;
    }

    public void setId_soci(Soci id_soci) {
        this.idSoci = id_soci;
    }

    public Llibre getId_llibre() {
        return idLlibre;
    }

    public void setId_llibre(Llibre id_llibre) {
        this.idLlibre = id_llibre;
    }

    public Date getData_inici() {
        return data_inici;
    }

    public void setData_inici(Date data_inici) {
        this.data_inici = data_inici;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }
}
