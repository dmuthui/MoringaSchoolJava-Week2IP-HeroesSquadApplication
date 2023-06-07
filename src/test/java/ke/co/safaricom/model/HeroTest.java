package ke.co.safaricom.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @DisplayName("Test for heroId")
    @Test
    void getHeroId() {
        Hero myHero = new Hero(1, "ShanLee", 20, "Indomitable", "Loses Power", "Gigantic", false);
        Integer expected = 1;
        assertEquals(1,myHero.getHeroId());
    }
    @DisplayName("Test for Hero's name")
    @Test
    void getHeroName() {
        Hero myHero = new Hero(1, "ShanLee", 20, "Indomitable", "Loses Power", "Gigantic", false);
        String expected = "ShanLee";
        assertEquals("ShanLee", myHero.getHeroName());
    }
    @DisplayName("Test for Hero's Age")
    @Test
    void getAge() {
        Hero myHero = new Hero(1, "ShanLee", 20, "Indomitable", "Loses Power", "Gigantic", false);
        Integer expected = 20;
        assertEquals(20, myHero.getAge());
    }
   @DisplayName("Test for Hero's Special Power")
    @Test
    void getSpecialPower() {
       Hero myHero = new Hero(1, "ShanLee", 20, "Indomitable", "Loses Power", "Gigantic", false);
       String expected = "Indomitable";
       assertEquals("Indomitable", myHero.getSpecialPower());
    }
    @DisplayName("Test for Hero's weakness")
    @Test
    void getWeakness() {
        Hero myHero = new Hero(1, "ShanLee", 20, "Indomitable", "Loses Power", "Gigantic", false);
        String expected = "Loses Power";
        assertEquals("Loses Power", myHero.getWeakness());
    }
    @DisplayName("Test for Squad")
    @Test
    void getSquad() {
        Hero myHero = new Hero(1, "ShanLee", 20, "Indomitable", "Loses Power", "Gigantic", false);
        String expected = "Gigantic";
        assertEquals("Gigantic", myHero.getSquad());
    }
    @DisplayName("Test for Deleted")
    @Test
    void getDeleted() {
        Hero myHero = new Hero(1, "ShanLee", 20, "Indomitable", "Loses Power", "Gigantic", false);
        Boolean expected = false;
        assertEquals(false, myHero.getDeleted());
    }

}