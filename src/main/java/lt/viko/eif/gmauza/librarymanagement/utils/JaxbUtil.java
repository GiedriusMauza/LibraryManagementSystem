package lt.viko.eif.gmauza.librarymanagement.utils;

import lt.viko.eif.gmauza.librarymanagement.model.Library;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public final class JaxbUtil {

    private JaxbUtil() {
    }

    public static String transformToXML(Library library) {
        try {

            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            // OutputStream os = new FileOutputStream("generated.xm");
            marshaller.marshal(library, new File("library.xml"));
            /*marshaller.marshal(library, System.out);*/

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(library, stringWriter);

            return stringWriter.toString();

        } catch (/*FileNotFoundException | */JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static Library transformToPOJO(String path) {
        try {

            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            String xmlContent = Files.readString(Path.of(path));
            /*System.out.println(xmlContent);*/
            StringReader reader = new StringReader(xmlContent);

            return (Library) unmarshaller.unmarshal(reader);

        } catch (/*FileNotFoundException | */JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void transformToPOJOFromString(String xml) {
        try {

            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            /*System.out.println(xmlContent);*/
            StringReader reader = new StringReader(xml);

            System.out.println(unmarshaller.unmarshal(reader));

        } catch (/*FileNotFoundException | */JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}
