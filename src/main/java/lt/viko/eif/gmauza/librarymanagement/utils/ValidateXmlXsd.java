package lt.viko.eif.gmauza.librarymanagement.utils;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;

public class ValidateXmlXsd {



    public static void validate(String xmlFile) {
        try {
            System.out.println("Validate XML against XSD Schema");
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(ValidateXmlXsd.class.getResource("/library.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xmlFile)));
            System.out.println("Validation is successful");
        } catch (IOException e) {
            // handle exception while reading source
        } catch (SAXException e) {
            System.out.println("Error when validate XML against XSD Schema");
            System.out.println("Message: " + e.getMessage());
        }
    }

}
