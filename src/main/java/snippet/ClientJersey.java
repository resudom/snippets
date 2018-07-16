/*
package Fuck;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.logging.LoggingFeature;
import sun.net.www.protocol.https.DefaultHostnameVerifier;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;


public class ClientJersey {

    public static void main(String[] args) {
        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();

        LoggingFeature loggingFeature = new LoggingFeature();
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(jacksonJsonProvider);
        clientConfig.register(loggingFeature);

        HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        ClientBuilder clientBuilder = JerseyClientBuilder.newBuilder()
                .hostnameVerifier(hostnameVerifier)
                .register(loggingFeature)
//                .connectTimeout(10000, TimeUnit.MILLISECONDS)
//                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .withConfig(clientConfig);

        Client client = clientBuilder.build();

        WebTarget target = client.target("https://jf0wfold4b.execute-api.ap-southeast-2.amazonaws.com/dev").path("access");


        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("type","fibre");
        reqMap.put("accessRequestID","kjfdjhjsdbnjsdnjk");
        reqMap.put("result","4GJKJ-5635G");
        reqMap.put("Speed","100Mbps");
        reqMap.put("site","Vasya's House");

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(reqMap));

        System.out.println(response.readEntity(String.class));
    }
}
*/
