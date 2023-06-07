package ke.co.safaricom;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.dao.HeroDao;
import ke.co.safaricom.dao.SquadDao;
import ke.co.safaricom.model.Hero;
import ke.co.safaricom.model.Squad;
import org.sql2o.Connection;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        //INITIALIZATION OF THE HANDLEBARS
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
//        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine("/templates");

        //THE ROUTE TO VIEW HOME PAGE
        get("/", (request, response) -> {
            List<Hero> allHeroes = null;
            List<Squad> allSquads = null;
            try (Connection db = Database.getConnect().open()) {
                String heroes = "SELECT * FROM heroes;";
                String squads = "SELECT * FROM squads";
                allHeroes = db.createQuery(heroes).executeAndFetch(Hero.class);
                allSquads = db.createQuery(squads).executeAndFetch(Squad.class);
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
            Map<String, Object> heroSquadList = new HashMap<>();
            heroSquadList.put("hero", allHeroes);
            heroSquadList.put("squad", allSquads);
            return new ModelAndView(new HashMap<>(), "home.hbs");
        }, engine);

        // THE ROUTE TO ADD HEROFORM FOR DATA ENTRY FOR THE HEROES DETAILS
        get("/heroes", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "heroForm.hbs");
        }, engine);

        //TO POST THE HEROES ADDED ON THE HEROFORM TO THE DATABASE
        post("/heroes", (request, response) -> {
            //Initializing the heroes list
            Integer heroId = null;
            String heroName = request.queryParams("heroName");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("specialPower");
            String weakness = request.queryParams("weakness");
            String squad = null;

            Hero additionalHero = new Hero(heroId, heroName, age, specialPower, weakness, squad);
            HeroDao.addHero(additionalHero);
            response.redirect("/");
            return null;
        });

        // THE ROUTE TO HANDLE GETTING ALL HEROES FROM DATABASE ON THE VIEW HEROES LIST
        get("/hero-list", (req,res) -> {
            Map<String, List<Hero>> heroList = new HashMap<>();
            heroList.put("heroes", HeroDao.getAllHeroes());
            return new ModelAndView(heroList, "heroes.hbs");
        },engine);

        //DELETING A HERO FROM THE PAGE
       get("/delete-hero/:heroName", (req,res)-> {
            String heroName = req.params(":heroName");
            HeroDao.deleteHero(heroName);
            res.redirect("/hero-list");
            return null;
        }, engine);

        //THE ROUTE TO ADD SQUADFORM FOR DATA ENTRY TO ADD A NEW SQUAD
        get("/squads", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "squadForm.hbs");
        }, engine);

        //TO POST THE SQUAD ADDED ON THE SQUADFORM TO THE DATABASE
        post("/squads", (request, response) -> {
            //Initializing the squad list
            Integer squadId = null;
            String squad = request.queryParams("squad");
            Integer size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");
            Squad addedSquad = new Squad(squadId, squad, size, cause);
            SquadDao.addSquad(addedSquad);
            response.redirect("/");
            return null;
        });


        // GETTING ALL SQUADS SHOWING ALL SQUADS DETAILS FROM DATABASE ON VIEW SQUAD LIST
        get("/squad-list", (req,res) -> {
            Map<String, List<Squad>> squadList = new HashMap<>();
            squadList.put("squads", SquadDao.getAllSquads());
            return new ModelAndView(squadList, "squads.hbs");
        },engine);

        //DELETING A SQUAD FROM THE PAGE
        get("/delete-squad/:squad", (req,res)-> {
            String squad = req.params(":squad");
            SquadDao.deleteSquad(squad);
            res.redirect("/squad-list");
            return null;
        }, engine);

        //TO ROUTE TO THE SQUADHEROESFORM FOR ASSIGNING HERO TO SQUAD
        get("/assign-hero/:squad", (request, response) -> {
            String squad = request.params("squad");
            System.out.println(squad);
            Map<String, Object> mixedList = new HashMap<>();
            if(HeroDao.heroCount(squad) < SquadDao.maxSize(squad)){
                mixedList.put("querySquadName", squad);
                mixedList.put("heroNameObject", HeroDao.membership(squad));
            }else response.redirect("/fullSquad");
            return new ModelAndView(mixedList, "squadHeroesForm.hbs");
        }, engine);

        //ROUTE TO SERVE ASSIGN A HERO TO A SQUAD
        post("/assign-hero/:squad", (req,res) -> {
            String heroName = req.queryParams("heroName");
            String squad    = req.queryParams("squad");
            System.out.println(heroName);
            System.out.println(squad);
            HeroDao.updateMembership(heroName, squad);
            res.redirect("/");
            return null;
        }, engine);

        // GETTING THE PAGE OF HEROES ASSIGNED TO A SQUAD IN THE VIEW ASSIGNED HERO TO SQUAD
        get("/hero-to-squad", (req,res) -> {
            return new ModelAndView(new HashMap<>(), "heroToSquad.hbs");
        }, engine);

        //ROUTE TO SERVE FULL SQUAD ALERT PAGE
        get("/full-squad", (req,res) -> {
                return new ModelAndView(new HashMap<>(),"fullSquad.hbs");
        }, engine);
    }
}