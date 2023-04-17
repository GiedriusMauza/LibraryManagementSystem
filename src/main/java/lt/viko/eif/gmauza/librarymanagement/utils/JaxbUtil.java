package lt.viko.eif.gmauza.librarymanagement.utils;

import lt.viko.eif.gmauza.librarymanagement.model.Library;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class JaxbUtil {
    public static void convertToXML(Library library) {
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            // OutputStream os = new FileOutputStream("generated.xm");
            marshaller.marshal(library, System.out);

        } catch (/*FileNotFoundException | */JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
