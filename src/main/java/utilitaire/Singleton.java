package utilitaire;

import Controller.ProduitController;
import DAO.DAOProduit;
import Entities.Produit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Singleton {
    public static Connection con;
    private static String pass = "pass";
    private static String uselog = "postgres"; // Change this to your PostgreSQL username

    public static Connection seConnecter() {
        if (con == null) {
            try {
                Class.forName("org.postgresql.Driver"); // Use the PostgreSQL driver
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp_rest", uselog, pass);
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver Non Trouvée" + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("SQL incorrect " + ex.getMessage());
            }
        }
        return con;
    }

    public static String getUselog() {
        return uselog;
    }

    public static void setCon(Connection con) {
        Singleton.con = con;
    }

    public static void setPass(String pass) {
        Singleton.pass = pass;
    }

    public static void setUselog(String uselog) {
        Singleton.uselog = uselog;
    }

    public static void main(String[] args) {
        Singleton.setPass("pass"); // Change this to your PostgreSQL password
        Singleton.setUselog("postgres"); // Change this to your PostgreSQL username
        Singleton.seConnecter();
        DAOProduit controller = new DAOProduit();
        List<Produit> list = controller.listerProduits();
        if(list.size()!=0) {
            for (Produit produit:list){
                System.out.println(produit.toString());
            }
        }
        else System.out.println("liste vide");
    }
}
