
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mat on 13/01/2016.
 */
@Entity
//@Table(name="llibre")
public class Llibre implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_llibre")
    @NotNull
    private Integer id_llibre;

    //@Lob
    @Column(name="titol")
    private String titol = null;

    //@Column(name="N_EXEMPLARS")
    private Integer nExemplars = null;

    //@Lob
    @Column(name="editorial")
    private String editorial = null;

    @Column(name="pagines")
    private Integer pagines = null;

    //@Temporal(TemporalType.DATE)
    @Column(name="any_edicio")
    private Integer any_edicio = null;


    public Llibre(){
    }

    public Llibre(Integer id){
        this.id_llibre = id;
    }


    public Llibre(/*Integer id_llibre,*/ String titol, Integer nExemplars,
                  String editorial, Integer pagines, Integer any_edicio){

        //this.id_llibre = id_llibre;
        this.titol = titol;
        this.nExemplars = nExemplars;
        this.editorial = editorial;
        this.pagines = pagines;
        this.any_edicio = any_edicio;
    }

    public Llibre(Integer id_llibre, String titol, Integer nExemplars,
                  String editorial, Integer pagines, Integer any_edicio){

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

    public Integer getAny_edicio() {
        return any_edicio;
    }

    public void setAny_edicio(Integer any_edicio) {
        this.any_edicio = any_edicio;
    }

}
