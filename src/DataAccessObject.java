import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Mat on 16/01/2016.
 */
public class DataAccessObject {


    public static void fDAOaltaLlibre(String titol, Integer nExemplars,
                                      String editorial, Integer pagines, Integer any){

        //System.out.println(titol + " :: " + nExemplars + " :: " + editorial + " :: " + pagines + " :: " + any);

        Llibre llibre = new Llibre(titol, nExemplars, editorial, pagines, any);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(llibre);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        System.out.println(titol + " :: " + nExemplars + " :: " + editorial + " :: " + pagines + " :: " + any);
        //System.out.println(pkid);

        //Llibre(Integer id_llibre, String titol, Integer nExemplars,
        //       String editorial, Integer pagines, Date any_edicio)
    }
}
