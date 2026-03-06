package ludmi.projet.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ludmi.projet.model.Employe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:employe.db";

    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL);
    }

    public static void initDatabase(){
        String sql = """
               CREATE TABLE IF NOT EXISTS employe(
               id INTEGER PRIMARY KEY AUTOINCREMENT,
               prenom TEXT,
               nom TEXT,
               poste TEXT,
               departement TEXT,
               salaire REAL
               )
               """;

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
           e.printStackTrace();
        }

    }

    /**
     * Methode addEmploye() ajout d'un employé
     * @param employe
     */

    public static void addEmploye(Employe employe){

        String sql = "INSERT INTO employe (prenom, nom, poste, departement, salaire) VALUES (?,?,?,?,?)";

        try(Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            {
            stmt.setString(1, employe.getPrenom());
            stmt.setString(2, employe.getNom());
            stmt.setString(3, employe.getPoste());
            stmt.setString(4, employe.getDepartement());
            stmt.setDouble(5, employe.getSalaire());
            stmt.executeUpdate();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * methode deleteEmploye suppression d'un employé par son id
     * @param id
     */
    public static void deleteEmploye(int id){
        String sql = "DELETE FROM employe WHERE id = ?";

        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){

            stmt.setInt(1, id);
            stmt.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }

    /**
     * methode editEmploye() modification des données d'un employé préalablement enregistré
     * @param employe
     */

    public static void editEmploye(Employe employe){
        String sql = "UPDATE employe SET nom = ?, prenom = ?, poste = ?, departement = ?, salaire = ? WHERE id = ?" ;

        try(Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ){

            stmt.setString(1, employe.getNom());
            stmt.setString(2, employe.getPrenom());
            stmt.setString(3, employe.getPoste());
            stmt.setString(4, employe.getDepartement());
            stmt.setDouble(5, employe.getSalaire());
            stmt.setInt(6, employe.getId());

            stmt.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException();
        }
    }

    public static ObservableList<Employe> getAllSelect(){

        ObservableList<Employe> Liste = FXCollections.observableArrayList();

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ){
            ResultSet res = stmt.executeQuery("SELECT * from employe");

            while(res.next()){
                Employe employe = new Employe(res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("poste"), res.getString("departement"), res.getDouble("salaire"));
                Liste.add(employe);
            }
        }catch(SQLException e){
            throw new RuntimeException();
        }
        return Liste;
    }


}
