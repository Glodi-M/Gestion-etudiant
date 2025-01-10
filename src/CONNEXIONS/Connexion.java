/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONNEXIONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author HP ELITEBOOK
 */
public class Connexion {

    // Connextion à la Base de Données 
    String url = "jdbc:mysql://localhost:3306/ge-db";
    String user = "root";
    String pwd = "";

    private Connection connec;
    private Statement cmd;
    public ResultSet resultat;

    // Création du Constructeur de la classe 
    public Connexion() {

        try {

            connec = DriverManager.getConnection(url, user, pwd);
            System.out.println("La connexion est reussie !");

        } catch (SQLException e) {

            System.out.println("Echec de la connexion " + e.getMessage());

        }
    }

    // Création de la Méthode Mise à jouur
    public void mise_a_jour(String req) {

        try {

            cmd = connec.createStatement();
            cmd.execute(req);

        } catch (SQLException e) {

            System.out.println("Erreur " + e.getMessage());
        }
    }

    // Création de Methode Selection qui va Selectionner les infons dans la base de données
    public void selection(String req) {

        try {
            cmd = connec.createStatement();
            resultat = cmd.executeQuery(req);

        } catch (SQLException e) {

            System.out.println("Erreur" + e.getMessage());
        }
    }

}
