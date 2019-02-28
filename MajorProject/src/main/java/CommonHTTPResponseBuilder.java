import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static constants.baseConstants.*;

public class CommonHTTPResponseBuilder {

    public HttpResponse getHTTPResponseForMatch(final String matchId) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URI uri = new URIBuilder()
                .setScheme(HTTPS_CONSTANT)
                .setHost(OPEN_DOTA_API_BASE_URL)
                .setPath(MATCHES_PATH.replace(MATCH_ID, matchId))
                .setParameter(API_KEY_CONSTANT, OPEN_DOTA_API_KEY)
                .build();
        HttpGet httpget = new HttpGet(uri);
        HttpResponse httpResponse = client.execute(httpget);
        return httpResponse;
    }

    public HttpResponse getHTTPResponseForRecentMatchesByPlayer(final String userId) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URI uri = new URIBuilder()
                .setScheme(HTTPS_CONSTANT)
                .setHost(OPEN_DOTA_API_BASE_URL)
                .setPath(RECENT_MATCHES_PATH.replace(USER_ID, userId))
                .setParameter(API_KEY_CONSTANT, OPEN_DOTA_API_KEY)
                .build();
        HttpGet httpget = new HttpGet(uri);
        HttpResponse httpResponse = client.execute(httpget);
        return httpResponse;
    }

    public HttpResponse getHTTPResponseForRandomSampledPublicMatches() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URI uri = new URIBuilder()
                .setScheme(HTTPS_CONSTANT)
                .setHost(OPEN_DOTA_API_BASE_URL)
                .setPath(PUBLIC_MATCHES_PATH)
                .setParameter(API_KEY_CONSTANT, OPEN_DOTA_API_KEY)
                .build();
        HttpGet httpget = new HttpGet(uri);
        HttpResponse httpResponse = client.execute(httpget);
        return httpResponse;
    }

    public HttpResponse getHTTPResponseForHeros() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URI uri = new URIBuilder()
                .setScheme(HTTPS_CONSTANT)
                .setHost(OPEN_DOTA_API_BASE_URL)
                .setPath(HEROS_PATH)
                .setParameter(API_KEY_CONSTANT, OPEN_DOTA_API_KEY)
                .build();
        HttpGet httpget = new HttpGet(uri);
        HttpResponse httpResponse = client.execute(httpget);
        return httpResponse;
    }

    public HttpResponse getHTTPResponseForProPlayers() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URI uri = new URIBuilder()
                .setScheme(HTTPS_CONSTANT)
                .setHost(OPEN_DOTA_API_BASE_URL)
                .setPath(PRO_PLAYERS_PATH)
                .setParameter(API_KEY_CONSTANT, OPEN_DOTA_API_KEY)
                .build();
        HttpGet httpget = new HttpGet(uri);
        HttpResponse httpResponse = client.execute(httpget);
        return httpResponse;
    }
}
