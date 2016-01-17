import org.hibernate.*;
import org.hibernate.cfg.Configuration;


/**
 * Created by Mat on 16/01/2016.
 */
public class DataAccessObject {


    public static void fDAOaltaLlibre(String titol, Integer nExemplars,
                                      String editorial, Integer pagines, Integer any){

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

    public static void fDAObaixaLlibre(Integer idLlibre) {

        Llibre llibre = new Llibre(idLlibre);

        System.out.println("___::" + idLlibre);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{/*
            Query query = session.createQuery("delete from Llibre where id_llibre=" + idLlibre);
            //session.delete();
            //query.setParameter("idLlibre", idLlibre );

            int result = query.executeUpdate();
            String testQ = query.getQueryString();
            System.out.println("getQueryString :: " + testQ);
            System.out.println("result ::" + result);

            if (result > 0) {
                System.out.println("Llibre " + idLlibre + " esborrat");
            }
*/
            tx = session.beginTransaction();
            session.delete(llibre);
            /*
            String hql = "DELETE FROM Llibre "  +
                    "WHERE id_llibre=" + idLlibre;
            Query query = session.createQuery(hql);
            query.setParameter("Llibre", idLlibre);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            String testQ = query.getQueryString();
            System.out.println("getQueryString :: " + testQ);
            System.out.println("result ::" + result);*/
            tx.commit();

        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void fDAOModifLlibre(Integer id,String titol, Integer nExemplars,
                                       String editorial, Integer pagines, Integer any) {

        Llibre llibre = new Llibre(id, titol, nExemplars, editorial, pagines, any);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.saveOrUpdate(llibre);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        System.out.println(id + " :: " + titol + " :: " + nExemplars + " :: " +
                editorial + " :: " + pagines + " :: " + any);
    }

    public static void fDAOaltaSoci(String nomSoci, String cognomSoci, Integer edat, String direccio, String telefon) {

        Soci soci = new Soci(nomSoci, cognomSoci, edat, direccio, telefon);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            System.out.println();
            tx = session.beginTransaction();
            session.save(soci);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void fDAObaixaSoci(Integer idSoci) {
        Soci soci = new Soci(idSoci);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            System.out.println();
            tx = session.beginTransaction();
            session.delete(soci);
            tx.commit();

        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}




