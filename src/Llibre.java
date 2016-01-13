import java.util.Date;

/**
 * Created by Mat on 13/01/2016.
 */
public class Llibre {

    private Integer id_llibre = null;
    private String titol = null;
    private Integer nExemplars = null;
    private String editorial = null;
    private Integer pagines = null;
    private Integer any_edicio = null;

    public Llibre(Integer id_llibre, String titol, Integer nExemplars,
                  String editorial, Integer pagines, Integer any_edicio){

        this.id_llibre = id_llibre;
        this.titol = titol;
        this.nExemplars = nExemplars;
        this.editorial = editorial;
        this.pagines = pagines;
        this.any_edicio = any_edicio;
    }

}
