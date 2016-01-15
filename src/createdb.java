/**
 * Created by Mat on 13/01/2016.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createdb {

    private static String DRIVERDD = "org.postgresql.Driver";
    private static String nomdb = "jdbc:postgresql://192.168.1.111:5432/biblioHibernate";

    public static void main(String[] args) {
        createTableLlibre();
        createTableSoci();
        createTablePrestec();
        System.out.println("FI");
    }

    public static void createDB (String nom) {
        Connection c = null;

        try {
            Class.forName(DRIVERDD);
            c = DriverManager.getConnection(nomdb,"marc","marc");
            System.out.println("...Created database successfully");
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return;
    }

    public static void createTableLlibre(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVERDD);
            c = DriverManager.getConnection(nomdb,"marc","marc");
            System.out.println("...Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE LLIBRES " +
                    "(ID_LLIBRE     INT PRIMARY KEY   NOT NULL," +
                    " TITOL         TEXT              NOT NULL," +
                    " N_EXEMPLARS   INT               NOT NULL," +
                    " EDITORIAL     TEXT              NOT NULL," +
                    " PAGINES       INT               NOT NULL," +
                    " ANY_EDICIO    DATE              NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("...Table created successfully");
    }

    public static void createTableSoci(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVERDD);
            c = DriverManager.getConnection(nomdb,"marc","marc");
            System.out.println("...Opened database successfully");

            System.out.println();
            stmt = c.createStatement();
            String sql = "CREATE TABLE SOCIS " +
                    "(ID_SOCI       INT PRIMARY KEY   NOT NULL," +
                    " NOM           TEXT              NOT NULL," +
                    " COGNOM        TEXT              NOT NULL," +
                    " EDAT          INT               NOT NULL," +
                    " DIRECCIO      TEXT              NOT NULL," +
                    " TELEFON       TEXT              NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("...Table created successfully");
    }

    public static void createTablePrestec(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVERDD);
            c = DriverManager.getConnection(nomdb,"marc","marc");
            System.out.println("...Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE PRESTEC " +
                    "(ID_PRESTEC    INT PRIMARY KEY                    NOT NULL," +
                    " ID_SOCI       INT REFERENCES SOCIS (ID_SOCI)     NOT NULL," +
                    " ID_LLIBRE     INT REFERENCES LLIBRES (ID_LLIBRE) NOT NULL," +
                    " DATA_INICI    DATE                               NOT NULL," +
                    " DATA_FINAL    DATE                               NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("...Table created successfully");
    }


}
