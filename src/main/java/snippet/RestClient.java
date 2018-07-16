/*
package Fuck;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

public class RestClient {


    ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider(objectMapper);


//        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();
        WebClient client = WebClient.create("https://jf0wfold4b.execute-api.ap-southeast-2.amazonaws.com/dev/access", Arrays.asList(jacksonJsonProvider));


        client.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE);



        ClientConfiguration configuration = WebClient.getConfig(client);
        final LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
        final LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();

        configuration.getBus().getOutInterceptors().add(outInterceptor);
        configuration.getBus().getOutFaultInterceptors().add(outInterceptor);
        configuration.getBus().getInInterceptors().add(inInterceptor);
        configuration.getBus().getInFaultInterceptors().add(inInterceptor);
//        configuration.getBus().getFeatures().add(new LoggingFeature());


        HTTPConduit httpConduit = configuration.getHttpConduit();
        httpConduit.getClient().setConnectionTimeout(10000);
        httpConduit.getClient().setReceiveTimeout(10000);

        httpConduit.getClient().setProxyServer("genproxy.amdocs.com");
        httpConduit.getClient().setProxyServerPort(8080);

        TLSClientParameters tlsClientParameters = new TLSClientParameters();
*/
/*
 FiltersType filtersType = new FiltersType();
        List<String> excludeList = filtersType.getExclude();
        List<String> includeList = filtersType.getInclude();
        includeList.add(".*_WITH_3DES_.*");
        includeList.add(".*_ECDHE_RSA_WITH_AES_.*");
        includeList.add(".*_EXPORT_.*");
        includeList.add(".*_EXPORT1024_.*");
        includeList.add(".*_WITH_DES_.*");
//        includeList.add(".*TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256.*");
//        excludeList.add(".*_EXPORT_.*");
//        excludeList.add(".*_WITH_DES_.*");
        excludeList.add(".*_anon_.*");
        excludeList.add(".*_NULL_.*");
        tlsClientParameters.setCipherSuitesFilter(filtersType);
        HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        tlsClientParameters.setHostnameVerifier(hostnameVerifier);
*//*



//        tlsClientParameters.setUseHttpsURLConnectionDefaultHostnameVerifier(false);
       tlsClientParameters.setUseHttpsURLConnectionDefaultHostnameVerifier(false);
//        tlsClientParameters.setHostnameVerifier(new DefaultHostnameVerifier());
        httpConduit.setTlsClientParameters(tlsClientParameters);
//jersey
//        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("type","fibre");
        reqMap.put("accessRequestID","kjfdjhjsdbnjsdnjk");
        reqMap.put("result","4GJKJ-5635G");
        reqMap.put("Speed","100Mbps");
        reqMap.put("site","Vasya's House");


        Message m = new Message("ok", "shit" , "fuck");

//        Response response = client.post("{\"accessRequestID\":\"kjfdjhjsdbnjsdnjk\",\"result\":\"4GJKJ-5635G\",\"Speed\":\"100Mbps\",\"site\":\"Vasya's House\", \"type\":\"fibre\"}");
        System.err.println(reqMap.toString());
        Response response = client.post(reqMap);
//        Response response = client.post(reqMap.toString());
        System.out.println(response.readEntity(String.class));
    }

}
*/
