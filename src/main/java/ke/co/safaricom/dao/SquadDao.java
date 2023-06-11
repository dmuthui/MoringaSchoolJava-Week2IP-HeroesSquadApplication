package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.Hero;
import ke.co.safaricom.model.Squad;
import org.sql2o.Connection;

import java.util.List;

public class SquadDao {
    //THIS CODE CREATES THE SQUADS TABLE AUTOMATICALLY ON THE DATABASE ON STARTING THE APP
    public static void getStarted (){

        try(Connection db = Database.getConnect().open()){
            String createTable = "CREATE TABLE IF NOT EXISTS squads (squadId SERIAL, squad varchar unique, size integer default 5, cause varchar, deleted boolean default false);";
            db.createQuery(createTable).executeUpdate();
        } catch (Exception error) {System.out.println(error.getMessage());}
    }

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
    //RETRIEVES DETAILS OF SQUAD FOR THE PARTICULAR ASSIGNED HEROES
    public static List<Squad> getsquad(String squad) {
        List<Squad> viewedSquads = null;
        try (Connection db = Database.getConnect().open()) {
            String squadsQuery = "SELECT * FROM squads WHERE squad = (:squad) AND deleted = false";
            viewedSquads = db.createQuery(squadsQuery)
                    .addParameter("squad", squad)
                    .executeAndFetch(Squad.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return viewedSquads;
    }
    //RETRIEVES A LIST OF ALL THE SQUADS FROM THE SQUADS DATABASE
    public static List<Squad> getAllSquads() {
        List<Squad> allSquads = null;
        try (Connection db = Database.getConnect().open()) {
            String squads = "SELECT * FROM squads WHERE deleted = (false)";
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
       return squadSize.get(0).getSize();
    }

    //DELETES A SQUAD FROM THE DATABASE
    public static void deleteSquad(String squad) {
        try (Connection db = Database.getConnect().open()) {
            String deletedSquad = "UPDATE squads SET deleted = (true) WHERE squad = (:squad);";
            db.createQuery(deletedSquad).addParameter("squad", squad).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}


