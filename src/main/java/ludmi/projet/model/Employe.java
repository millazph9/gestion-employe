package ludmi.projet.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Date;

public class Employe {

    private int id;
    private String nom;
    private String prenom;
    private String poste;
    private String departement;
    private double salaire;
    private String contrat;
    private LocalDate dateRecrutement;

    public Employe(int id, String nom, String prenom, String poste, String departement, double salaire, String contrat, LocalDate dateRecrutement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.departement = departement;
        this.salaire = salaire;
        this.contrat = contrat;
        this.dateRecrutement = dateRecrutement;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public LocalDate getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(LocalDate dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public String toString(){
        return "Prenom : " + this.prenom + " Nom : " + this.nom;
    }


}
