import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class SampleTestClass {

    @Test
    public void testGameDataForMatchId() throws Exception {
        String testMatchId = "271145478";
        String response = Helpers.getMatchDataForId(testMatchId);
        System.out.println(response);
    }

    @Test
    public void testRecentGamesForPlayer() throws Exception {
        String testUserId = "393082323";
        String response = Helpers.getRecentMatchesForPlayer(testUserId);
        System.out.println(response);
    }

    @Test
    public void testRecentMatchIdsForPlayer() throws Exception {
        String testUserId = "393082323";
        for(String matchId : Helpers.getRecentMatchIdsForPlayer(testUserId)) {
            System.out.println(matchId);
        }
    }

    @Test
    public void testRandomPublicMatches() throws Exception {
        String response = Helpers.getRandomPublicMatches();
        System.out.println(response);
    }

    @Test
    public void testHeros() throws Exception {
        String response = Helpers.getHeros();
        System.out.println(response);
    }

    @Test
    public void testProPlayers() throws Exception {
        String response = Helpers.getProPlayers();
        System.out.println(response);
    }

    @Test
    public void testProPlayerIds() throws Exception {
        for(String proPlayersId : Helpers.getProPlayersIds()) {
            System.out.println(proPlayersId);
        }
    }

    @Test
    public void testMatchIdsForProPlayers() throws Exception {
        HashMap<String , List<String>> matchIdsForProPlayers = Helpers.getRecentMatchesForEachProPlayer();
        for (HashMap.Entry<String, List<String>> entry : matchIdsForProPlayers.entrySet()) {
            System.out.println(entry.getKey());
            List<String> matchIds = entry.getValue();
            for(String matchId : matchIds) {
                System.out.println("             " + matchId);
            }
        }
    }
}
