package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;

import database.Users;
import model.wifiPlace;
import javax.swing.JButton;

public class cargarDatos extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public cargarDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargarDatos = new JButton("Cargar datos a calificar");
		btnCargarDatos.setBounds(67, 55, 179, 29);
		contentPane.add(btnCargarDatos);
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarDatos(e);
			}
		});
		this.setLocationRelativeTo(null);
	}
	

	
	private ArrayList<wifiPlace> datosCalificar() {
		Model model = wifiPlace.getModel();
		ArrayList<wifiPlace> puntosWifi;
		String departamento = Users.getActiveUser().getDepartment();
		String sparqlQueryString1 = "PREFIX base:<http://www.sistemarecomendacion.com/sitiosWifi#>"  //Prefijo propio de la ontologia
				+ "SELECT DISTINCT ?municipio ?nombrePuntoWIFI ?tipo ?temperatura "
				+ "WHERE {"  			
				+ "?departamento base:tiene ?municipio."							//Primera relacion objeto1->tiene->objeto2
				+ "?municipio base:tiene ?puntoWIFI."								//Primera relacion objeto2->tiene->objeto3
				+ "?departamento base:name ?nombreDepartamento."
				+ "?puntoWIFI base:name ?nombrePuntoWIFI."
				+ "?puntoWIFI base:tipo ?tipo."	
				+ "?puntoWIFI base:temperatura ?temperatura." 										//En nuestra ontologia es posible que exista un 4to
				+ "FILTER REGEX(?nombreDepartamento,'"+ departamento +"')}";
		
		Query q = QueryFactory.create(sparqlQueryString1);											//ya que solo los puntosWIFI tienen este tipo de 
		QueryExecution qexec = QueryExecutionFactory.create(q,model);
		//Validar la cantidad de filas
		try {
			ResultSet results = qexec.execSelect();
			puntosWifi = new ArrayList<wifiPlace>();
			System.out.println(results.getRowNumber()); //Cantidad de filas
			while ( results.hasNext() ) {
                QuerySolution soln = results.nextSolution();
                String nombre = soln.getLiteral("nombrePuntoWIFI").getString();
                String tipo = soln.getLiteral("tipo").getString();
                String temperatura = soln.getLiteral("temperatura").getString();
                puntosWifi.add(new wifiPlace(nombre, tipo, temperatura));
        	}
		}finally {
			qexec.close();
		}
		return puntosWifi;
	}
	
	private void CargarDatos(java.awt.event.ActionEvent evt){
		ArrayList<wifiPlace> puntosCalificar = datosCalificar();
		this.setVisible(false);
		(new CalificarPuntos(puntosCalificar)).setVisible(true);
	}
}
