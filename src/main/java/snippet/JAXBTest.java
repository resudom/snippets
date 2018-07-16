package snippet;





import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class JAXBTest {

    public static void main(String[] args) {

        try {
            JAXBContext context = JAXBContext.newInstance(String.class);
            JAXBElement<String> element = new JAXBElement<String>(new QName("Fuck"), String.class, "aaaaaaaaaaaaaa");
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(element, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
