/*
package Fuck;

import okhttp3.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientOkHttp {


    private static Logger logger = Logger.getLogger(String.valueOf(ClientOkHttp.class));
    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor (logger, Level.INFO);

    static {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    static ObjectMapper mapper = new ObjectMapper();
    static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("genproxy.amdocs.com", 8080));

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10000, TimeUnit.MILLISECONDS);
        builder.readTimeout(10000, TimeUnit.MILLISECONDS);
        builder.addInterceptor(loggingInterceptor);
        builder.proxy(proxy);

        OkHttpClient client = builder.build();

        String bodyString = createBody();
        RequestBody body = RequestBody.create(JSON, bodyString);
        Request request = new Request.Builder().post(body).url("https://jf0wfold4b.execute-api.ap-southeast-2.amazonaws.com/dev/access").build();

        Response response = null;
        try {

            response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                new IOException();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        int code = response.code();
        Map respMap = mapper.readValue(response.body().string(), Map.class);
        System.out.println(respMap);
        response.body().close();

    }

    private static String createBody() throws IOException {

        HashMap reqMap = new HashMap();
        reqMap.put("type", "fibre");
        reqMap.put("accessRequestID", "kjfdjhjsdbnjsdnjk");
        reqMap.put("result", "4GJKJ-5635G");
        reqMap.put("Speed", "100Mbps");
        reqMap.put("site", "Vasya\'s House");

        return mapper.writeValueAsString(reqMap);
    }
}
*/
