import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mat on 13/01/2016.
 */
@Entity
@Table(name="Prestec")
public class Prestec implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    //@Column(name="ID_PRESTEC")
    private Integer id_prestec = null;


    @OneToOne(targetEntity = Soci.class, fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_soci")
    //@AttributeOverride(name="caca", column=@Column(name="idSoci_id_soci"))
    //@Column(name="id_soci")
    private Soci id_soci = null;

    @OneToOne(targetEntity = Llibre.class, fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_llibre")
    //@AttributeOverride(name="coco", column=@Column(name="idLlibre_id_llibre"))
    //@Column(name="id_llibre")
    private Llibre id_llibre = null;

    @Temporal(TemporalType.DATE)
    //@Column(name="DATA_INICI")
    private Date data_inici;

    @Temporal(TemporalType.DATE)
    //@Column(name="DATA_FINAL")
    private Date data_final;


    public Prestec(){}

    /*Date(int year, int month, int date)
    Deprecated.
    As of JDK version 1.1, replaced by Calendar.set(year + 1900, month, date) or GregorianCalendar(year + 1900, month, date).
    */

    public Prestec(Integer id_prestec, Llibre id_llibre,
                   Soci id_soci, Date data_inici, Date data_final){

        this.id_prestec = id_prestec;
        this.id_llibre = id_llibre;
        this.id_soci = id_soci;
        this.data_inici = data_inici;
        this.data_final = data_final;
    }

    public Prestec(Llibre id_llibre,
                   Soci id_soci, Date data_inici, Date data_final){

        this.id_llibre = id_llibre;
        this.id_soci = id_soci;
        this.data_inici = data_inici;
        this.data_final = data_final;
    }

    public Integer getId_prestec() {
        return id_prestec;
    }

    protected void setId_prestec(Integer id_prestec) {
        this.id_prestec = id_prestec;
    }

    //@Column(name="idSoci")
    public Soci getId_soci() {
        return id_soci;
    }
    public Integer getIdint_soci() {
        return id_soci.getId_soci();
    }

    protected void setId_soci(Soci id_soci) {
        this.id_soci = id_soci;
    }

    public Llibre getId_llibre() {
        return id_llibre;
    }

    public Integer getIdint_llibre() {
        return id_llibre.getId_llibre();
    }

    protected void setId_llibre(Llibre id_llibre) {
        this.id_llibre = id_llibre;
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
