import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final public class Helpers {

    public static String getMatchDataForId(final String matchId) throws Exception {
        HttpRequestToJson httpRequestToJson = new HttpRequestToJson();
        CommonHTTPResponseBuilder commonHTTPResponseBuilder = new CommonHTTPResponseBuilder();
        HttpResponse httpResponse = commonHTTPResponseBuilder.getHTTPResponseForMatch(matchId);
        return httpRequestToJson.getJsonForHTTPRequest(httpResponse);
    }

    public static String getRecentMatchesForPlayer(final String accountId) throws Exception {
        HttpRequestToJson httpRequestToJson = new HttpRequestToJson();
        CommonHTTPResponseBuilder commonHTTPResponseBuilder = new CommonHTTPResponseBuilder();
        HttpResponse httpResponse = commonHTTPResponseBuilder.getHTTPResponseForRecentMatchesByPlayer(accountId);
        return httpRequestToJson.getJsonForHTTPRequest(httpResponse);
    }

    public static String getRandomPublicMatches() throws Exception {
        HttpRequestToJson httpRequestToJson = new HttpRequestToJson();
        CommonHTTPResponseBuilder commonHTTPResponseBuilder = new CommonHTTPResponseBuilder();
        HttpResponse httpResponse = commonHTTPResponseBuilder.getHTTPResponseForRandomSampledPublicMatches();
        return httpRequestToJson.getJsonForHTTPRequest(httpResponse);
    }

    public static String getHeros() throws Exception {
        HttpRequestToJson httpRequestToJson = new HttpRequestToJson();
        CommonHTTPResponseBuilder commonHTTPResponseBuilder = new CommonHTTPResponseBuilder();
        HttpResponse httpResponse = commonHTTPResponseBuilder.getHTTPResponseForHeros();
        return httpRequestToJson.getJsonForHTTPRequest(httpResponse);
    }

    public static String getProPlayers() throws Exception {
        HttpRequestToJson httpRequestToJson = new HttpRequestToJson();
        CommonHTTPResponseBuilder commonHTTPResponseBuilder = new CommonHTTPResponseBuilder();
        HttpResponse httpResponse = commonHTTPResponseBuilder.getHTTPResponseForProPlayers();
        return httpRequestToJson.getJsonForHTTPRequest(httpResponse);
    }

    public static List<String> getProPlayersIds() throws Exception {
        List<String> proPlayerIds = new ArrayList<String>();
        String response = getProPlayers();
        JsonParser parser = new JsonParser();
        JsonArray jsonTree = parser.parse(response).getAsJsonArray();
        for(JsonElement jsonElement : jsonTree) {
            proPlayerIds.add(jsonElement.getAsJsonObject().get("account_id").toString());
        }
        return proPlayerIds;
    }

    public static List<String> getRecentMatchIdsForPlayer(final String accountId) throws Exception {
        List<String> recentMatchIds = new ArrayList<String>();
        String response = getRecentMatchesForPlayer(accountId);
        JsonParser parser = new JsonParser();
        JsonArray jsonTree = parser.parse(response).getAsJsonArray();
        for(JsonElement jsonElement : jsonTree) {
            recentMatchIds.add(jsonElement.getAsJsonObject().get("match_id").toString());
        }
        return recentMatchIds;
    }

    public static HashMap<String, List<String>> getRecentMatchesForEachProPlayer() throws Exception {
        List<String> proPlayerIds = getProPlayersIds();
        HashMap<String, List<String>> recentMatchesForProPlayers = new HashMap<String, List<String>>();
        int count = 0;
        for(String proPlayer : proPlayerIds) {
            count++;
            if(count > 20) {
                break;
            } else {
                List<String> matchIdsForProPlayer = getRecentMatchIdsForPlayer(proPlayer);
                recentMatchesForProPlayers.put(proPlayer, matchIdsForProPlayer);
            }
        }
        return recentMatchesForProPlayers;
    }
}
