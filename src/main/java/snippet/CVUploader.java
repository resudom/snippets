/*
package Fuck;

import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.*;

import javax.activation.DataHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

*/
/**
 * Created by IVANMO on 16/6/2017.
 *//*

public class CVUploader {

    WebClient client = WebClient.create("");

    public static void main(String[] args) {

        String fileName = "";
        CVUploader cvUploader = new CVUploader();
        WebClient client = cvUploader.client.path("rest/upload/cv");
        client.type(MediaType.MULTIPART_FORM_DATA_TYPE);

        ClientConfiguration configuration = WebClient.getConfig(client);
//        configuration.getBus().setFeatures(Arrays.asList(new LoggingFeature(1000000)));

        List<Attachment> attachments = new ArrayList<>();

        InputStream stream = cvUploader.getClass().getClassLoader().getResourceAsStream(fileName);
        ContentDisposition cd = new ContentDisposition("form-data; name=file; filename=" + fileName);
        DataHandler handler = new DataHandler(new InputStreamDataSource(stream, "application/pdf"));
        Attachment fileAttachment = new AttachmentBuilder().id("file").contentDisposition(cd).
                dataHandler(handler).build();
        attachments.add(fileAttachment);

        HashMap<String, String> attrMap = new HashMap<>();
        attrMap.put("firstname", "Ivan");
        attrMap.put("lastname", "Molchan");
        attrMap.put("email", "ivan.molchan@gmail.com");
        attrMap.put("jobtitle", "Software Engineer");
        attrMap.put("source", "Indeed");

        for (Map.Entry<String,String> entry :attrMap.entrySet()) {
            stream = new ByteArrayInputStream(entry.getValue().getBytes());
            handler = new DataHandler(new InputStreamDataSource(stream, MediaType.TEXT_PLAIN));
            cd = new ContentDisposition("form-data; name=" + entry.getKey());
            Attachment attachment = new AttachmentBuilder().id(entry.getKey()).contentDisposition(cd).dataHandler(handler).build();
            attachments.add(attachment);
        }

        MultipartBody multipartBody = new MultipartBody(attachments);

        Response response = client.post(multipartBody);
        System.out.println(response.readEntity(String.class));
    }

}
*/
