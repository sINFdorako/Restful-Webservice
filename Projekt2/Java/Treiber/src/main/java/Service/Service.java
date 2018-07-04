package Service;
import org.apache.http.client.utils.URIBuilder;
import java.net.URI;
import java.net.URISyntaxException;


class Service {

    private static final String HOST = "localhost:8000";


    static URI buildURI(String endpoint) {

        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme("http")
                    .setHost(HOST)
                    .setPath(endpoint)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return uri;
    }



}
