
import controller.*;
import org.apache.jena.rdf.model.Model;

public class Main {

	public static void main(String[] args) {
		Model wifiPlace = model.getWifiPlace();
		wifiPlace.write(System.out,"RDF/XML");
	}

}
