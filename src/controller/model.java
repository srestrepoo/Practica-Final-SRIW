package controller;
import org.apache.jena.rdf.model.Model;
import model.wifiPlace;

public class model {
	
	public static Model getWifiPlace() {
		return wifiPlace.getInstance();
	}
	
}
