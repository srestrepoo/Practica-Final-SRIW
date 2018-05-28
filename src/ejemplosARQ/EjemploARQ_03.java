package ejemplosARQ;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.query.ResultSet;

public class EjemploARQ_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String sparqlQueryString1 = "PREFIX dbont: <http://dbpedia.org/ontology/> " +
                "PREFIX dbp: <http://dbpedia.org/property/>" +
                "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>" +
                "   SELECT ?musician  ?place" +
                "   WHERE { " +
                "       ?musician dbont:birthPlace ?place ." +
                "   }";

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
        
        // Crear el objeto consulta
        Query query = QueryFactory.create(sparqlQueryString2);
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://es.dbpedia.org/sparql", query);
        //qexec = QueryExecutionFactory.spar

        //Luego procesar la ejecución de la consulta y su resultado

        try {
        	ResultSet results = qexec.execSelect();
        	while ( results.hasNext() ) {
                QuerySolution soln = results.nextSolution();
                String temp = soln.getLiteral("Temperatura").getString();
                String mun = soln.getLiteral("nombreMunicipio").getString();
                System.out.println(mun + " " +temp);
            }
        }
        finally {
           qexec.close();
        }

	}

}
