import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mat on 13/01/2016.
 */
@Entity
public class Llibre implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Type(type="integer")
    @Column(name="ID_LLIBRE")
    private Integer id_llibre = null;

    @Lob
    @Column(name="TITOL")
    private String titol = null;

    @Type(type="integer")
    @Column(name="N_EXEMPLARS")
    private Integer nExemplars = null;

    @Lob
    @Column(name="EDITORIAL")
    private String editorial = null;

    @Type(type="integer")
    @Column(name="PAGINES")
    private Integer pagines = null;

    @Temporal(TemporalType.DATE)
    @Column(name="ANY_EDICIO")
    private Date any_edicio = null;


    public Llibre(){
    }


    public Llibre(Integer id_llibre, String titol, Integer nExemplars,
                  String editorial, Integer pagines, Date any_edicio){

        this.id_llibre = id_llibre;
        this.titol = titol;
        this.nExemplars = nExemplars;
        this.editorial = editorial;
        this.pagines = pagines;
        this.any_edicio = any_edicio;
    }

    //getter - setter

    public Integer getId_llibre() {
        return id_llibre;
    }

    public void setId_llibre(Integer id_llibre) {
        this.id_llibre = id_llibre;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public Integer getnExemplars() {
        return nExemplars;
    }

    public void setnExemplars(Integer nExemplars) {
        this.nExemplars = nExemplars;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getPagines() {
        return pagines;
    }

    public void setPagines(Integer pagines) {
        this.pagines = pagines;
    }

    public Date getAny_edicio() {
        return any_edicio;
    }

    public void setAny_edicio(Date any_edicio) {
        this.any_edicio = any_edicio;
    }

}
