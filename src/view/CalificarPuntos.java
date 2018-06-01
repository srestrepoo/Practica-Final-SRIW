package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;

import database.Users;
import model.ObjetoRecomendar;
import model.wifiPlace;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalificarPuntos extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> primerComboBox;
	private JComboBox<String> segundoComboBox;
	private JComboBox<String> tercerComboBox;
	private JComboBox<String> cuartoComboBox;
	private JComboBox<String> quintoComboBox;
	private ArrayList<wifiPlace> PuntosCalificar;
	private QueryExecution results;

	/**
	 * Create the frame.
	 */
	public CalificarPuntos(ArrayList<wifiPlace> puntosCalificar, QueryExecution query) {
		
		PuntosCalificar = puntosCalificar;
		results = query;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPuntosACalificar = new JLabel("PUNTOS A CALIFICAR");
		lblPuntosACalificar.setBounds(144, 13, 144, 14);
		contentPane.add(lblPuntosACalificar);
		
		JButton btnPuntosQueMe = new JButton("Puntos que me podrian gustar");
		btnPuntosQueMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calificarPuntos(e);
			}
		});
		btnPuntosQueMe.setBounds(89, 450, 245, 23);
		contentPane.add(btnPuntosQueMe);
		
		if(puntosCalificar.size() >= 1) {

			JPanel panel = new JPanel();
			panel.setBounds(40, 39, 343, 71);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(6, 6, 90, 16);
			panel.add(lblNewLabel);
			
			JLabel lblTemperatura = new JLabel("Temperatura:");
			lblTemperatura.setBounds(6, 27, 90, 16);
			panel.add(lblTemperatura);
			
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(6, 49, 90, 16);
			panel.add(lblTipo);
			
			primerComboBox = new JComboBox<String>();
			primerComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
			primerComboBox.setBounds(216, 45, 127, 27);
			panel.add(primerComboBox);
			
			JLabel lblPrimernombre = new JLabel(puntosCalificar.get(0).getNombre());
			lblPrimernombre.setBounds(91, 6, 235, 16);
			panel.add(lblPrimernombre);
			
			JLabel lblPrimerTemperatura = new JLabel(puntosCalificar.get(0).getTemperatura());
			lblPrimerTemperatura.setBounds(91, 27, 235, 16);
			panel.add(lblPrimerTemperatura);
			
			JLabel lblPrimerTipo = new JLabel(puntosCalificar.get(0).getTipo());
			lblPrimerTipo.setBounds(91, 49, 125, 16);
			panel.add(lblPrimerTipo);
		}
		
		if(puntosCalificar.size() >= 2) {
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(40, 122, 343, 71);
			contentPane.add(panel_1);
			
			JLabel label = new JLabel("Nombre:");
			label.setBounds(6, 6, 90, 16);
			panel_1.add(label);
			
			JLabel label_1 = new JLabel("Temperatura:");
			label_1.setBounds(6, 27, 90, 16);
			panel_1.add(label_1);
			
			JLabel label_2 = new JLabel("Tipo:");
			label_2.setBounds(6, 49, 90, 16);
			panel_1.add(label_2);
			
			segundoComboBox = new JComboBox<String>();
			segundoComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
			segundoComboBox.setBounds(216, 45, 127, 27);
			panel_1.add(segundoComboBox);
			
			JLabel lblSegundoNombre = new JLabel(puntosCalificar.get(1).getNombre());
			lblSegundoNombre.setBounds(93, 6, 233, 16);
			panel_1.add(lblSegundoNombre);
			
			JLabel lblSegundaTemperatura = new JLabel(puntosCalificar.get(1).getTemperatura());
			lblSegundaTemperatura.setBounds(93, 27, 233, 16);
			panel_1.add(lblSegundaTemperatura);
			
			JLabel lblSegundoTipo = new JLabel(puntosCalificar.get(1).getTipo());
			lblSegundoTipo.setBounds(93, 49, 125, 16);
			panel_1.add(lblSegundoTipo);
		}
		
		if(puntosCalificar.size() >= 3) {
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBounds(40, 205, 343, 71);
			contentPane.add(panel_2);
			
			JLabel label_3 = new JLabel("Nombre:");
			label_3.setBounds(6, 6, 90, 16);
			panel_2.add(label_3);
			
			JLabel label_4 = new JLabel("Temperatura:");
			label_4.setBounds(6, 27, 90, 16);
			panel_2.add(label_4);
			
			JLabel label_5 = new JLabel("Tipo:");
			label_5.setBounds(6, 49, 90, 16);
			panel_2.add(label_5);
			
			tercerComboBox = new JComboBox<String>();
			tercerComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
			tercerComboBox.setBounds(216, 45, 127, 27);
			panel_2.add(tercerComboBox);
			
			JLabel lblTercerNombre = new JLabel(puntosCalificar.get(2).getNombre());
			lblTercerNombre.setBounds(93, 6, 233, 16);
			panel_2.add(lblTercerNombre);
			
			JLabel lblTercerTemperatura = new JLabel(puntosCalificar.get(2).getTemperatura());
			lblTercerTemperatura.setBounds(93, 27, 233, 16);
			panel_2.add(lblTercerTemperatura);
			
			JLabel lblTercerTipo = new JLabel(puntosCalificar.get(2).getTipo());
			lblTercerTipo.setBounds(93, 49, 125, 16);
			panel_2.add(lblTercerTipo);
		}
		
		if(puntosCalificar.size() >= 4) {
			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBounds(40, 288, 343, 71);
			contentPane.add(panel_3);
			
			JLabel label_6 = new JLabel("Nombre:");
			label_6.setBounds(6, 6, 90, 16);
			panel_3.add(label_6);
			
			JLabel label_7 = new JLabel("Temperatura:");
			label_7.setBounds(6, 27, 90, 16);
			panel_3.add(label_7);
			
			JLabel label_8 = new JLabel("Tipo:");
			label_8.setBounds(6, 49, 90, 16);
			panel_3.add(label_8);
			
			cuartoComboBox = new JComboBox<String>();
			cuartoComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
			cuartoComboBox.setBounds(216, 45, 127, 27);
			panel_3.add(cuartoComboBox);
			
			JLabel lblCuartoNombre = new JLabel(puntosCalificar.get(3).getNombre());
			lblCuartoNombre.setBounds(91, 6, 235, 16);
			panel_3.add(lblCuartoNombre);
			
			JLabel lblCuartaTemperatura = new JLabel(puntosCalificar.get(3).getTemperatura());
			lblCuartaTemperatura.setBounds(91, 27, 235, 16);
			panel_3.add(lblCuartaTemperatura);
			
			JLabel lblCuartoTipo = new JLabel(puntosCalificar.get(3).getTipo());
			lblCuartoTipo.setBounds(91, 49, 125, 16);
			panel_3.add(lblCuartoTipo);
		}
		
		if(puntosCalificar.size() == 5) {
			JPanel panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.setBounds(40, 367, 343, 71);
			contentPane.add(panel_4);
			
			JLabel label_9 = new JLabel("Nombre:");
			label_9.setBounds(6, 6, 90, 16);
			panel_4.add(label_9);
			
			JLabel label_10 = new JLabel("Temperatura:");
			label_10.setBounds(6, 27, 90, 16);
			panel_4.add(label_10);
			
			JLabel label_11 = new JLabel("Tipo:");
			label_11.setBounds(6, 49, 90, 16);
			panel_4.add(label_11);
			
			quintoComboBox = new JComboBox<String>();
			quintoComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
			quintoComboBox.setBounds(216, 45, 127, 27);
			panel_4.add(quintoComboBox);
			
			JLabel lblQuintoNombre = new JLabel(puntosCalificar.get(4).getNombre());
			lblQuintoNombre.setBounds(94, 6, 232, 16);
			panel_4.add(lblQuintoNombre);
			
			JLabel lblQuintaTemperatura = new JLabel(puntosCalificar.get(4).getTemperatura());
			lblQuintaTemperatura.setBounds(94, 27, 232, 16);
			panel_4.add(lblQuintaTemperatura);
			
			JLabel lblQuintoTipo = new JLabel(puntosCalificar.get(4).getTipo());
			lblQuintoTipo.setBounds(94, 49, 125, 16);
			panel_4.add(lblQuintoTipo);
		}
		this.setLocationRelativeTo(null);
		
	}
	
	private void calificarPuntos(ActionEvent evt){		
		ArrayList<String> decisiones = new ArrayList<String>();
		decisiones.add((String) primerComboBox.getSelectedItem());
		decisiones.add((String) segundoComboBox.getSelectedItem());
		decisiones.add((String) tercerComboBox.getSelectedItem());
		decisiones.add((String) cuartoComboBox.getSelectedItem());
		decisiones.add((String) quintoComboBox.getSelectedItem());
		Double[][] matrix = new Double[5][5];
		
		for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
               matrix[i][j] = 0.0;  
            }
        }
		
		for(int i = 0; i < 5; i++) {
			if(decisiones.get(i).equals("No me gusta")) {
				if(Double.parseDouble(PuntosCalificar.get(i).getTemperatura()) < 20) {
					matrix[0][2] = matrix[0][2] + 1.0;
				}else if(Double.parseDouble(PuntosCalificar.get(i).getTemperatura()) < 25) {
					matrix[1][2] = matrix[1][2] + 1.0;
				}else if(Double.parseDouble(PuntosCalificar.get(i).getTemperatura()) >= 25) {
					matrix[2][2] = matrix[2][2] + 1.0;
				}
				
				if(PuntosCalificar.get(i).getTipo().equals("Abierto")) {
					matrix[3][2] = matrix[3][2] + 1.0;
				}else if(PuntosCalificar.get(i).getTipo().equals("Cerrado")){
					matrix[4][2] = matrix[4][2] + 1.0;
				}
			}else if(decisiones.get(i).equals("Me gusta")) {
				if(Double.parseDouble(PuntosCalificar.get(i).getTemperatura()) < 20) {
					matrix[0][0] = matrix[0][0] + 1.0;
				}else if(Double.parseDouble(PuntosCalificar.get(i).getTemperatura()) < 25) {
					matrix[1][0] = matrix[1][0] + 1.0;
				}else if(Double.parseDouble(PuntosCalificar.get(i).getTemperatura()) >= 25) {
					matrix[2][0] = matrix[2][0] + 1.0;
				}
				
				if(PuntosCalificar.get(i).getTipo().equals("Abierto")) {
					matrix[3][0] = matrix[3][0] + 1.0;
				}else if(PuntosCalificar.get(i).getTipo().equals("Cerrado")){
					matrix[4][0] = matrix[4][0] + 1.0;
				}
			}
		}
		
		//Probabilidad de que me gusta
		if(matrix[0][0] == 0) {
			matrix[0][1] = 0.01;
		}else {
			matrix[0][1] = matrix[0][0]/5.0;
		}
		
		if(matrix[1][0] == 0) {
			matrix[1][1] = 0.01;
		}else {
			matrix[1][1] = matrix[1][0]/5.0;
		}
		
		if(matrix[2][0] == 0) {
			matrix[2][1] = 0.01;
		}else {
			matrix[2][1] = matrix[2][0]/5.0;
		}
		
		if(matrix[3][0] == 0) {
			matrix[3][1] = 0.01;
		}else {
			matrix[3][1] = matrix[3][0]/5.0;
		}
		
		if(matrix[4][0] == 0) {
			matrix[4][1] = 0.01;
		}else {
			matrix[4][1] = matrix[4][0]/5.0;
		}
		
		
		//Probabilidad de que no me gusta
		if(matrix[0][2] == 0) {
			matrix[0][3] = 0.01;
		}else {
			matrix[0][3] = matrix[0][2]/5.0;
		}
		
		if(matrix[1][2] == 0) {
			matrix[1][3] = 0.01;
		}else {
			matrix[1][3] = matrix[1][2]/5.0;
		}
		
		if(matrix[2][2] == 0) {
			matrix[2][3] = 0.01;
		}else {
			matrix[2][3] = matrix[2][2]/5.0;
		}
		
		if(matrix[3][2] == 0) {
			matrix[3][3] = 0.01;
		}else {
			matrix[3][3] = matrix[3][2]/5.0;
		}
		
		if(matrix[4][2] == 0) {
			matrix[4][3] = 0.01;
		}else {
			matrix[4][3] = matrix[4][3]/5.0;
		}
		matrix[0][4] = (matrix[0][0] + matrix [0][2])/5.0;
		matrix[1][4] = (matrix[1][0] + matrix [1][2])/5.0;
		matrix[2][4] = (matrix[2][0] + matrix [2][2])/5.0;
		matrix[3][4] = (matrix[3][0] + matrix [3][2])/5.0;
		matrix[4][4] = (matrix[4][0] + matrix [4][2])/5.0;
		Model model = wifiPlace.getModel();
		String departamento = Users.getActiveUser().getDepartment();
		
		String sparqlQueryString1 = "PREFIX base:<http://www.sistemarecomendacion.com/sitiosWifi#>"  //Prefijo propio de la ontologia
				+ "SELECT DISTINCT ?nombremunicipio ?nombrePuntoWIFI ?tipo ?temperatura ?nombreDepartamento ?direccion "
				+ "WHERE {"  			
				+ "?departamento base:tiene ?municipio."							//Primera relacion objeto1->tiene->objeto2
				+ "?municipio base:tiene ?puntoWIFI."
				+ "?puntoWIFI base:tiene ?geo."
				+ "?geo base:direccion ?direccion."
				+ "?municipio base:name ?nombremunicipio."							//Primera relacion objeto2->tiene->objeto3
				+ "?departamento base:name ?nombreDepartamento."
				+ "?puntoWIFI base:name ?nombrePuntoWIFI."
				+ "?puntoWIFI base:tipo ?tipo."	
				+ "?puntoWIFI base:temperatura ?temperatura." 										//En nuestra ontologia es posible que exista un 4to
				+ "FILTER REGEX(?nombreDepartamento,'"+departamento+"')}";
		
		Query q = QueryFactory.create(sparqlQueryString1);											//ya que solo los puntosWIFI tienen este tipo de 
		QueryExecution qexec = QueryExecutionFactory.create(q,model);
		
		ObjetoRecomendar[] arregloRecomendador;
		try {
			ResultSet resultsNew = qexec.execSelect();
			System.out.println(resultsNew.getRowNumber());
			ArrayList<ObjetoRecomendar> arregloRecomendadorTemporal = new ArrayList<ObjetoRecomendar>();
			while ( resultsNew.hasNext() ) {
				QuerySolution soln = resultsNew.nextSolution();
				String tipo = soln.getLiteral("tipo").getString();
	            String temperatura = soln.getLiteral("temperatura").getString();
	            String nombre = soln.getLiteral("nombrePuntoWIFI").getString();
	            String municipio = soln.getLiteral("nombremunicipio").getString();
	            String departament = soln.getLiteral("nombreDepartamento").getString();
	            String direccion = soln.getLiteral("direccion").getString();
	            String temperaturaTemporal = "";
	            if(Double.parseDouble(temperatura) < 20) {
	            	temperaturaTemporal = "Frio";
				}else if(Double.parseDouble(temperatura) < 25) {
					temperaturaTemporal = "Tibio";
				}else if(Double.parseDouble(temperatura) >= 25) {
					temperaturaTemporal = "Caliente";
				}
	            
	            double probabilidadGustar = 0.0;
	            
	            if (temperaturaTemporal=="Frio" && tipo== "Cerrado") {
	                probabilidadGustar = ((0.5)*(matrix[0][1])*matrix[4][1])/((matrix[0][4]*matrix[4][4]));           
	            }else if(temperaturaTemporal=="Frio" && tipo=="Abierto"){
	                probabilidadGustar = ((0.5)*(matrix[0][1])*matrix[3][1])/((matrix[0][4]*matrix[3][4])); 
	            }else if(temperaturaTemporal=="Tibio" && tipo=="Cerrado"){
	                probabilidadGustar = ((0.5)*(matrix[1][1])*matrix[4][1])/((matrix[1][4]*matrix[4][4]));
	            }else if(temperaturaTemporal=="Tibio" && tipo=="Abierto"){
	                probabilidadGustar = ((0.5)*(matrix[1][1])*matrix[3][1])/((matrix[1][4]*matrix[3][4]));
	            }else if(temperaturaTemporal=="Caliente" && tipo=="Cerrado"){
	                probabilidadGustar = ((0.5)*(matrix[2][1])*matrix[4][1])/((matrix[2][4]*matrix[4][4]));
	            }else if(temperaturaTemporal=="Caliente" && tipo=="Abierto"){
	                probabilidadGustar = ((0.5)*(matrix[2][1])*matrix[3][1])/((matrix[2][4]*matrix[3][4]));
	            }
	            if(probabilidadGustar <=  1) {
	            	arregloRecomendadorTemporal.add(new ObjetoRecomendar(nombre, temperatura, direccion, departament, municipio , tipo ,probabilidadGustar));
	            }
	    	}
			arregloRecomendador = new ObjetoRecomendar[arregloRecomendadorTemporal.size()];
			for(int j = 0; j < arregloRecomendadorTemporal.size(); j++) {
				arregloRecomendador[j] = arregloRecomendadorTemporal.get(j);
			}
			Arrays.sort(arregloRecomendador);
			ArrayList<ObjetoRecomendar> recomendados = new ArrayList<ObjetoRecomendar>();
			for(int j = 0; j < 5; j++) {
				recomendados.add(arregloRecomendador[j]);
			}
			this.setVisible(false);
			(new PuntosRecomendados(recomendados)).setVisible(true);
		}finally {
			qexec.close();
		}
	}
}
