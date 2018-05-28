package ejemplosAPI;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.commons.*;
import org.apache.commons.lang3.StringUtils;

public class EjemploIO_02 {

    public static void main(String[] args) {
    	StringUtils n = new StringUtils();
    	System.out.println(n.capitalize("HOLA".toLowerCase()));
        Model model = ModelFactory.createDefaultModel();
        // Recobra una URL correspondiente al vocabulario RDF Schema en formato RDF/XML
        model.read("https://www.w3.org/TR/2002/WD-rdf-schema-20020430/rdfs-namespace.xml", null, "RDF/XML");

        model.write(System.out, "TURTLE");
    }

}
