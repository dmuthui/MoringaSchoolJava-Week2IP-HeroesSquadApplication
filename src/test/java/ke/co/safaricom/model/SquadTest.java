package ke.co.safaricom.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {
    @DisplayName("Test for SquadId if it passes the test")
    @Test
    void getSquadId() {
        Squad mySquad = new Squad(1, "Golden Flashes", 3, "Fast and Furious", false);
        Integer expected = 1;
        assertEquals(1, mySquad.getSquadId());
    }
    @DisplayName("Test for the Squad Name if it passes the test")
    @Test
    void getSquad() {
        Squad mySquad = new Squad(1, "Golden Flashes", 3, "Fast and Furious", false);
        String expected = "Golden Flashes";
        assertEquals("Golden Flashes", mySquad.getSquad());
    }
    @DisplayName("Test for the Squad Size if it passes the test")
    @Test
    void getSize() {
        Squad mySquad = new Squad(1, "Golden Flashes", 3, "Fast and Furious", false);
        Integer expected = 3;
        assertEquals(3, mySquad.getSize());
    }
    @DisplayName("Test for the Squad Cause if it passes the test")
    @Test
    void getCause() {
        Squad mySquad = new Squad(1, "Golden Flashes", 3, "Fast and Furious", false);
        String expected = "Fast and Furious";
        assertEquals("Fast and Furious", mySquad.getCause());
    }
    @DisplayName("Test for the Squad Deleted if false if it passes the test")
    @Test
    void getDeleted() {
        Squad mySquad = new Squad(1, "Golden Flashes", 3, "Fast and Furious", false);
        Boolean expected = false;
        assertEquals(false, mySquad.getDeleted());
    }
}