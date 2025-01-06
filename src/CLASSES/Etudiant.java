/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

import CONNEXIONS.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP ELITEBOOK
 */
public class Etudiant {

    Connexion cnx = new Connexion();

    String matricule, nom, sexe, telephone;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Methode pour ajouter l'etudiant dans la basse de données
    public void ajouter() {

        try {

            String req = "INSERT INTO etudiant (matricule, nom, sexe, telephone) values ('" + getMatricule() + "','" + getNom() + "','" + getSexe() + "','" + getTelephone() + "')";
            cnx.mise_a_jour(req);

        } catch (Exception e) {

            System.out.println("" + e.getMessage());
        }
    }

    // Methode pour remplir les données dans la Grille
    public void remplir(JTable jt, String req) {

        try {
            // Nombre de ligne 
            int ligne = 0;
            cnx.selection(req);
            while (cnx.resultat.next()) {
                ligne++;
            }
            // Mettre les données dans le tableau 

            Object data[][] = new Object[ligne][4];
            ligne = 0;
            cnx.selection(req);

            while (cnx.resultat.next()) {
                data[ligne][0] = cnx.resultat.getString(1);
                data[ligne][1] = cnx.resultat.getString(2);
                data[ligne][2] = cnx.resultat.getString(3);
                data[ligne][3] = cnx.resultat.getString(4);
                ligne++;
            }

            // Mettre le titre et données 
            String titre[] = {"Matricule", "Nom", "Sexe", "Téléphone"};
            jt.setModel(new DefaultTableModel(data, titre));

        } catch (Exception e) {

            System.out.println("Erreur " + e.getMessage());
        }

    }
}
