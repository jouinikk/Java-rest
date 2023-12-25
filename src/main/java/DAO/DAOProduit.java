package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Produit;
import utilitaire.Singleton;

public class DAOProduit {

    public List<Produit> listerProduits() {
        Connection con=Singleton.seConnecter();
        List<Produit> l=new ArrayList<Produit>();
        String sql = "SELECT id, \"description\", prix FROM produit";
        Produit p= null;
        try
        {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet R=ps.executeQuery();
            while (R.next()) {
                p = new Produit();
                p.setId(R.getInt("id"));
                p.setDescription((R.getString("description")));
                p.setPrix(R.getFloat("prix"));
                l.add(p);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return l;
    }

}