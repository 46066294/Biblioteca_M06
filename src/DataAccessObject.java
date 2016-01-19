import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.Date;
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

    }

    public static void fDAObaixaLlibre(Integer idLlibre) {

        Llibre llibre = new Llibre(idLlibre);

        System.out.println("___::" + idLlibre);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(llibre);
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
                            "\tANY: "+llibre.getAny_edicio() + "\tEDITORIAL: " + llibre.getEditorial() +
                            "\t N_EXEMPLARS: " + llibre.getnExemplars() + "\tPAGINES: " + llibre.getPagines() + "\n";
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

    public static String fDAOqueryTitolLlibre(String titola) {
        String salida = "";

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Llibre WHERE titol ='" + titola + "' ORDER BY id_llibre";
            System.out.println();
            Query query = session.createQuery(hql);
            List results = query.list();
            if(results.isEmpty()){
                System.out.println("No hi ha resultats");
            }else{
                System.out.println("Resultats:\n---------------");

                for (int i = 0; i < results.size(); i++) {
                    Llibre llibre = (Llibre) results.get(i);

                    System.out.println("ID_LLIBRE: " + llibre.getId_llibre());
                    System.out.println("TITOL: " + llibre.getTitol());

                    salida = salida + "ID_LLIBRE: " + llibre.getId_llibre() + "\tTITOL: " + llibre.getTitol() +
                            "\tANY: "+llibre.getAny_edicio() + "\tEDITORIAL: " + llibre.getEditorial() +
                            "\t\tN_EXEMPLARS: " + llibre.getnExemplars() + "\t\tPAGINES: " + llibre.getPagines() + "\n";
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


    public static String fDAOqueryCognomSoci(String cognomSoci) {
        String salida = "";

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Soci WHERE cognom_soci ='" + cognomSoci + "' ORDER BY cognom_soci";
            Query query = session.createQuery(hql);
            List results = query.list();
            if(results.isEmpty()){
                System.out.println("No hi ha resultats");
            }else{
                System.out.println("Resultats:\n---------------");

                for (int i = 0; i < results.size(); i++) {
                    Soci soci = (Soci) results.get(i);

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

    public static void fDAOaltaNouPrestec(Integer idLlibre, Integer idSoci, Date dataInici, Date dataFinal) {
        Llibre llibre = new Llibre(idLlibre);
        Soci soci = new Soci(idSoci);
        Prestec prestec = new Prestec(llibre, soci, dataInici, dataFinal);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(prestec);
            tx.commit();

            System.out.println("\n...prestec afegit");
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }


    public static String fDAOqueryLlibresPrestats() {
        String salida = "";

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            System.out.println();
            //String hql = "FROM Prestec JOIN Llibre ON Prestec.id_Llibre=Llibre.id_llibre";
            String hql = "FROM Prestec JOIN Llibre ON Prestec.idLlibre=(SELECT id_llibre FROM Llibre)";
            //SELECT Llibre.titol FROM Prestec JOIN Llibre ON Prestec.idllibre_id_llibre=Llibre.id_llibre
            Query query = session.createQuery(hql);
            List results = query.list();
            if(results.isEmpty()){
                System.out.println("No hi ha resultats");
            }else{
                System.out.println();
                System.out.println("Resultats:\n----------------");

                for (int i = 0; i < results.size(); i++) {
                    Soci soci = (Soci) results.get(i);

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




