package ejemplosAPI;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.commons.lang3.StringUtils;

import virtuoso.jena.driver.*;
import java.util.Hashtable;

public class CargueDatos {

	// algunas definiciones
    static String personURI    = "http://www.sistemarecomendacion.com/sitiosWifi#";
    static Hashtable<String, String> munTemp = new Hashtable<String, String>();
    static StringUtils quitaTildes = new StringUtils();
    
    public static void main (String args[]) {
	       Model model = ModelFactory.createDefaultModel();
	       
	       llenarTemp();
	       Property tiene = model.createProperty(personURI+"tiene");
	       Property name = model.createProperty(personURI+"name");
	       Property estado = model.createProperty(personURI+"estado");
	       Property tipo = model.createProperty(personURI+"tipo");
	       Property temperatura = model.createProperty(personURI+"temperatura");
	       Property direccion = model.createProperty(personURI+"direccion");
	       Property latitud = model.createProperty(personURI+"latitud");
	       Property longitud = model.createProperty(personURI+"longitud");
    	   VirtGraph set = new VirtGraph ("zonas-wifi","jdbc:virtuoso://18.219.194.215:1111", "dba", "dba"); 
    	   
    	   Query sparql = QueryFactory.create(
    			   "PREFIX ds:<https://www.datos.gov.co/resource/f4kx-n3nn/> "
    				+   "PREFIX dbo: <http://dbpedia.org/ontology/> "
    				+   "PREFIX dbpedia: <http://dbpedia.org/page/> "	
    				+   "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
    				+   "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
    				+   "SELECT DISTINCT ?Nombre ?Estado ?Direccion ?Municipio ?Departamento ?Temperatura "
    				+   "WHERE{ "
    				+   "?x ds:municipio ?Municipio. "
    				+   "?x ds:nombre_zona_wifi ?Nombre. "
    				+   "?x ds:departamento ?Departamento. "
    				+   "?x ds:direccion ?Direccion. "
    				+   "?x ds:zona_inagurada ?Estado. "
    				+   "?x ds:latitud ?Latitud. "
    				+   "?x ds:longitud ?Longitud. "
    				+   "} "	   		   
    			   );
    	VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
   		ResultSet results = vqe.execSelect();
	    String nombres[] = new String[7];
	    Resource recursos[] = new Resource[4];
	    //ResultSetFormatter.out(System.out, results);
   		while (results.hasNext()) {
   			QuerySolution soln = results.nextSolution();
   			//Traer datos de virtuoso
            nombres[0] = quitaTildes.stripAccents(soln.getLiteral("Nombre").getString());
            nombres[1] = quitaTildes.stripAccents(soln.getLiteral("Departamento").getString());
            nombres[2] = quitaTildes.stripAccents(soln.getLiteral("Municipio").getString());
            nombres[3] = soln.getLiteral("Estado").getString();
            nombres[4] = soln.getLiteral("Direccion").getString();
            //nombres[5] = soln.getLiteral("Georeferencia").getString();
            nombres[6] = getTemperatura(nombres[2]);
            //Agregar datos al modelo
	    	   recursos[0] = model.createResource(personURI + nombres[0]);
	    	   recursos[1] = model.createResource(personURI + nombres[1]);
	    	   recursos[2] = model.createResource(personURI + nombres[2]);
	    	   recursos[3] = model.createResource(personURI + "geo" + nombres[0]);
	    	   
	    	   recursos[1].addProperty(tiene, recursos[2]);
	    	   recursos[1].addProperty(name, nombres[1]);
	    	   recursos[2].addProperty(tiene, recursos[0]);
	    	   recursos[2].addProperty(name, nombres[2]);
	    	   recursos[0].addProperty(tiene, recursos[3]);
	    	   recursos[0].addProperty(name, nombres[0]);
	    	   recursos[0].addProperty(estado, nombres[3]);
	    	   if(nombres[6]!=null){
	    		   recursos[0].addProperty(temperatura, nombres[6]);
	    	   }
	    	   recursos[0].addProperty(tipo, "Abierto");
	    	   recursos[3].addProperty(name, "geo" + nombres[0]);
	    	   recursos[3].addProperty(direccion, nombres[4]);
   		}
   		  //Consulta a D2R
   		String sparqlQueryString1 = "PREFIX vocab: <http://localhost:2020/resource/vocab/> "+
									"SELECT DISTINCT ?Nombre ?Estado ?Direccion ?Municipio ?Departamento ?Georeferencia "+
									"WHERE{ "+
									"?x vocab:Biblioteca_municipio ?Municipio. "+
									"?x vocab:Biblioteca_departamento ?Departamento. "+
									"?x vocab:Biblioteca_nombre_de_la_biblioteca ?Nombre. "+
									"?x vocab:Biblioteca_direccion_de_la_biblioteca ?Direccion. "+
									"?x vocab:Biblioteca_georeferencia ?Georeferencia. "+
									"?x vocab:Biblioteca_estado_de_la_biblioteca ?Estado "+
									"}";
        Query query = QueryFactory.create(sparqlQueryString1);
        try{
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://18.219.194.215:2020/sparql", query);

        ResultSet resultsd2r = qexec.execSelect();
		while (resultsd2r.hasNext()) {
			QuerySolution soln = resultsd2r.nextSolution();
			nombres[0] = quitaTildes.capitalize(soln.getLiteral("Nombre").getString().toLowerCase());
            nombres[1] = quitaTildes.capitalize(soln.getLiteral("Departamento").getString().toLowerCase());
            nombres[2] = quitaTildes.capitalize(soln.getLiteral("Municipio").getString().toLowerCase());
            nombres[3] = soln.getLiteral("Estado").getString();
            nombres[4] = soln.getLiteral("Direccion").getString();
            //nombres[5] = soln.getLiteral("Georeferencia").getString();
            nombres[6] = getTemperatura(nombres[2]);
            //Agregar datos al modelo
	    	   recursos[0] = model.createResource(personURI + nombres[0]);
	    	   recursos[1] = model.createResource(personURI + nombres[1]);
	    	   recursos[2] = model.createResource(personURI + nombres[2]);
	    	   recursos[3] = model.createResource(personURI + "geo" + nombres[0]);
	    	   
	    	   recursos[1].addProperty(tiene, recursos[2]);
	    	   recursos[1].addProperty(name, nombres[1]);
	    	   recursos[2].addProperty(tiene, recursos[0]);
	    	   recursos[2].addProperty(name, nombres[2]);
	    	   recursos[0].addProperty(tiene, recursos[3]);
	    	   recursos[0].addProperty(name, nombres[0]);
	    	   recursos[0].addProperty(estado, nombres[3]);
	    	   if(nombres[6]!=null){
	    		   recursos[0].addProperty(temperatura, nombres[6]);
	    	   }
	    	   recursos[0].addProperty(tipo, "Cerrado");
	    	   recursos[3].addProperty(name, "geo" + nombres[0]);
	    	   recursos[3].addProperty(direccion, nombres[4]);
		}
        }finally{}

	      //escribe el modelo en forma de XML
	      model.write(System.out,"TURTLE");
    }
    public static String getTemperatura(String municipio){
    	String Muni;
    	if(municipio.length()>3){
    		Muni = municipio.substring(0, 3);
    	}else{
    		Muni = municipio.substring(0, 2);
    	}
        return munTemp.get(Muni);
    }
    
    public static void llenarTemp(){
        String sparqlQueryString2 ="PREFIX dbo: <http://dbpedia.org/ontology/> " +
        "   PREFIX dbpedia: <http://es.dbpedia.org/> " +
        "   PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "   PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "   select distinct * where { " +
        "	?Municipio dbo:country ?pais. " +
        "	?pais rdfs:label ?nombrePais. " +
        "	?Municipio rdf:type dbo:Place. " +
        "	?Municipio rdfs:label ?nombreMunicipio. " +
        "	?Municipio dbo:annualTemperature ?Temperatura. " +
        "	}";
        Query query = QueryFactory.create(sparqlQueryString2);
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://es.dbpedia.org/sparql", query);

        try {
        	ResultSet results = qexec.execSelect();
        	while ( results.hasNext() ) {
                QuerySolution soln = results.nextSolution();
                String temp = soln.getLiteral("Temperatura").getString();
                String mun = soln.getLiteral("nombreMunicipio").getString();
            	String Muni;
            	if(mun.length()>3){
            		Muni = quitaTildes.stripAccents(mun.substring(0, 3));
            	}else{
            		Muni = quitaTildes.stripAccents(mun.substring(0, 2));
            	}
                munTemp.put(Muni, temp);
        	}
        }
        finally {
           qexec.close();
        }
    } 
    
}
