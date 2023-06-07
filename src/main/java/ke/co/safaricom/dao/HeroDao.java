package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.Hero;
import ke.co.safaricom.config.Database;
import org.sql2o.Connection;

import java.util.List;

public class HeroDao {
    //ADDS A HERO INTO THE DATABASE
    public static void addHero (Hero additionalHero) {
        try (Connection db = Database.getConnect().open()) {
            //Database action
            String heroAdd = "INSERT INTO heroes (heroName, age, specialPower, weakness) VALUES (:heroName, :age, :specialPower, :weakness);";
            db.createQuery(heroAdd).bind(additionalHero).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    //RETRIEVES A LIST OF ALL THE HEROES FROM THE HEROES DATABASE
    public static List<Hero> getAllHeroes(){
        List<Hero> allHeroes = null;

        try (Connection db = Database.getConnect().open()) {
            String heroes = "SELECT * FROM heroes WHERE deleted = (false)";
            allHeroes = db.createQuery(heroes).executeAndFetch(Hero.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return allHeroes;
        }
        return allHeroes;

    }
    //CONFIRMS THE NUMBER OF HEROES IN A SQUAD
    public static Integer heroCount(String squad) {
        Integer heroesInSquad = null;
        try (Connection db = Database.getConnect().open()) {
            //CHECKS THE NUMBER OF HEROES IN THE PARAM SQUAD
            String heroCounter = "SELECT COUNT(*) FROM heroes WHERE squad = (:squad)";
            heroesInSquad = db.createQuery(heroCounter).addParameter("squad", squad).executeScalar(Integer.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return heroesInSquad;
    }
    //UPDATES THE HERO DETAILS TO INCLUDE THE SQUAD MEMBERSHIP
    public static void updateMembership (String heroName, String squad) {
        try(Connection db = Database.getConnect().open()){
            String heroUpdate = "UPDATE heroes SET squad = (:squad) WHERE heroName = (:heroName)";
            db.createQuery(heroUpdate).addParameter("heroName", heroName).addParameter("squad", squad).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    //GIVES A LIST OF HEROES WHO HAVE NOT YET BEEN ADDED IN ANY SQUAD/NOT IN THE PARAM SQUAD
    public static List<Hero> membership (String squad) {
        List<Hero> allHeroes = null;
        try(Connection db = Database.getConnect().open()){
            String heroList = "SELECT * FROM heroes WHERE squad IS NULL OR squad <> (:squad);";
            allHeroes = db.createQuery(heroList).addParameter("squad", squad).executeAndFetch(Hero.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return allHeroes;
    }
    //DELETES A HERO FROM THE HEROES DATABASE
    public static void deleteHero(String heroName){
        try(Connection db = Database.getConnect().open()){
            String deletedHero = "UPDATE heroes SET deleted = (true) WHERE heroName = (:heroName);";
            db.createQuery(deletedHero).addParameter("heroName", heroName).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
