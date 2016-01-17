import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Mat on 16/01/2016.
 */
public class DataAccessObject implements Serializable{


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
            factory.close();
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
            factory.close();
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
            factory.close();
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
            factory.close();
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
            factory.close();
        }
    }

    public static void fDAOModifSoci(Integer idSoci,String nomSoci, String cognomSoci,
                                     Integer edat, String direccio, String telefon) {

        Soci soci = new Soci(idSoci, nomSoci, cognomSoci, edat, direccio, telefon);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            System.out.println();
            tx = session.beginTransaction();
            session.saveOrUpdate(soci);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

        System.out.println(idSoci + " :: " + nomSoci + " :: " + cognomSoci + " :: " +
                edat + " :: " + direccio + " :: " + telefon);
    }

    public static String fDAOqueryLlibres() {
        String salida = "";

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{//SELECT id_llibre, titol, any_edicio
            tx = session.beginTransaction();
            String hql = "FROM Llibre ORDER BY id_llibre";
            Query query = session.createQuery(hql);
            List results = query.list();
            if(results.isEmpty()){
                System.out.println("No hi ha resultats");
            }else{
                System.out.println("Resultats:\n---------------");
                //for (int i = 0; i < results.size(); i++) {System.out.println(results.get(i));}

                for (int i = 0; i < results.size(); i++) {
                    Llibre llibre = (Llibre) results.get(i);

                    System.out.println("ID_LLIBRE: " + llibre.getId_llibre());
                    System.out.println("TITOL: " + llibre.getTitol());
                    System.out.println("ANY: "+llibre.getAny_edicio() + "\n");

                    salida = salida + "ID_LLIBRE: " + llibre.getId_llibre() + "\tTITOL: " + llibre.getTitol() +
                            "\tANY: "+llibre.getAny_edicio() + "\n";
                }
            }
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

        return salida;
    }

    public static String fDAOquerySocis() {

        String salida = "";
        System.out.println();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{//SELECT id_llibre, titol, any_edicio
            System.out.println();

            tx = session.beginTransaction();
            String hql = "FROM Soci ORDER BY id_soci";
            Query query = session.createQuery(hql);
            List results = query.list();
            if(results.isEmpty()){
                System.out.println("No hi ha resultats");
            }else{
                System.out.println("Resultats:\n---------------");

                for (int i = 0; i < results.size(); i++) {
                    Soci soci = (Soci) results.get(i);

                    System.out.println("ID_SOCI: " + soci.getId_soci());
                    System.out.println("NOM: " + soci.getNom_soci());
                    System.out.println("COGNOMS: "+ soci.getCognom_soci());
                    System.out.println("EDAT: " + soci.getEdat());
                    System.out.println("DIRECCIO: " + soci.getDireccio());
                    System.out.println("TELEFON: " + soci.getTelefon());

                    salida = salida + "ID_SOCI: " + soci.getId_soci() + "\tNOM: " + soci.getNom_soci() +
                            "\tCOGNOMS: " + soci.getCognom_soci() + "\tEDAT: " +  soci.getEdat() +
                            "\tDIRECCIO: " + soci.getDireccio() + "\t\tTELEFON: " + soci.getTelefon() + "\n";
                }
            }
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

        return salida;
    }


}




