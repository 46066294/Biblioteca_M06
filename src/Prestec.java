import org.hibernate.annotations.Entity;
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
    @Type(type="integer")
    @Column(name="ID_PRESTEC")
    private Integer id_prestec = null;

    @Type(type="integer")
    @Column(name="ID_SOCI")
    private Integer id_soci = null;

    @Type(type="integer")
    @Column(name="ID_LLIBRE")
    private Integer id_llibre = null;

    @Temporal(TemporalType.DATE)
    @Column(name="ANY_EDICIO")
    private Date DATA_INICI;

    @Temporal(TemporalType.DATE)
    @Column(name="DATA_FINAL")
    private Date data_final;

    public Prestec(){}


    public Prestec(Integer id_prestec, Integer id_llibre,
                   Integer id_soci){

        this.id_prestec = id_prestec;
        this.id_llibre = id_llibre;
        this.id_soci = id_soci;
    }
}
