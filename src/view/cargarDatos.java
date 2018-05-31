package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
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
	

	
	private Model datosCalificar() {
		Model model = wifiPlace.getInstance();
		System.out.println("Consulta");
		String sparqlQueryString1 = "SELECT * {?s ?p ?o}";
		
		Query query = QueryFactory.create(sparqlQueryString1);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSet results = qexec.execSelect();
		}finally {
			qexec.close();
		}
		return model;
	}
	
	private void CargarDatos(java.awt.event.ActionEvent evt){
		Model model = datosCalificar();
		this.setVisible(false);
		(new CalificarPuntos(model)).setVisible(true);
	}
}
