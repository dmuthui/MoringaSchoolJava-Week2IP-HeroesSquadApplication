package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.Squad;
import org.sql2o.Connection;

import java.util.List;

public class SquadDao {
    //ADDS SQUAD INTO THE DATABASE
    public static void addSquad(Squad addedSquad) {
        try (Connection db = Database.getConnect().open()) {
            //Database action
            String squadAdd = "INSERT INTO squads (squad, size, cause) VALUES (:squad, :size, :cause);";
            db.createQuery(squadAdd).bind(addedSquad).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    //RETRIEVES A LIST OF ALL THE SQUADS FROM THE SQUADS DATABASE
    public static List<Squad> getAllSquads() {
        List<Squad> allSquads = null;
        try (Connection db = Database.getConnect().open()) {
            String squads = "SELECT * FROM squads;";
            allSquads = db.createQuery(squads).executeAndFetch(Squad.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return allSquads;
        }
        return allSquads;
    }

    //RETURNS THE SET SQUAD SIZE FROM THE DATABASE
    public static Integer maxSize(String squad) {
        List<Squad> squadSize = null;
        try (Connection db = Database.getConnect().open()) {
            String sizeList = "SELECT size FROM squads WHERE squad = (:squad)"; //gets the size
            squadSize = db.createQuery(sizeList).addParameter("squad", squad).executeAndFetch(Squad.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
//        return squadSize.get(0).getSize();
          return 4;
    }

    //DELETES A SQUAD FROM THE DATABASE
    public static void deleteSquad(String squad) {
        try (Connection db = Database.getConnect().open()) {
            String deletedSquad = "DELETE FROM squads WHERE squad = (:squad);";
            db.createQuery(deletedSquad).addParameter("squad", squad).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}


