package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.jena.query.QueryExecution;

import model.ObjetoRecomendar;
import model.wifiPlace;

public class PuntosRecomendados extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PuntosRecomendados(ArrayList<ObjetoRecomendar> puntosCalificar) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPuntosACalificar = new JLabel("PUNTOS RECOMENDADOS");
		lblPuntosACalificar.setBounds(114, 13, 174, 14);
		contentPane.add(lblPuntosACalificar);
		
		if(puntosCalificar.size() >= 1) {

			JPanel panel = new JPanel();
			panel.setBounds(40, 160, 343, 109);
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
			
			JLabel lblPrimernombre = new JLabel(puntosCalificar.get(0).Nombre);
			lblPrimernombre.setBounds(91, 6, 235, 16);
			panel.add(lblPrimernombre);
			
			JLabel lblPrimerTemperatura = new JLabel(puntosCalificar.get(0).Temperatura);
			lblPrimerTemperatura.setBounds(91, 27, 235, 16);
			panel.add(lblPrimerTemperatura);
			
			JLabel lblPrimerTipo = new JLabel(puntosCalificar.get(0).Tipo);
			lblPrimerTipo.setBounds(91, 49, 125, 16);
			panel.add(lblPrimerTipo);
			
			JLabel lblMunicipio = new JLabel("Municipio");
			lblMunicipio.setBounds(6, 69, 90, 16);
			panel.add(lblMunicipio);
			
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(6, 88, 90, 16);
			panel.add(lblDireccion);
			
			JLabel label = new JLabel(puntosCalificar.get(0).Municipio);
			label.setBounds(91, 69, 125, 16);
			panel.add(label);
			
			JLabel label_1 = new JLabel(puntosCalificar.get(0).Direccion);
			label_1.setBounds(91, 88, 125, 16);
			panel.add(label_1);
		}
		if(puntosCalificar.size() >= 2) {

			JPanel panel1 = new JPanel();
			panel1.setBounds(40, 39, 343, 109);
			contentPane.add(panel1);
			panel1.setLayout(null);
			
			JLabel lblNewLabel1 = new JLabel("Nombre:");
			lblNewLabel1.setBounds(6, 6, 90, 16);
			panel1.add(lblNewLabel1);
			
			JLabel lblTemperatura1 = new JLabel("Temperatura:");
			lblTemperatura1.setBounds(6, 27, 90, 16);
			panel1.add(lblTemperatura1);
			
			JLabel lblTipo1 = new JLabel("Tipo:");
			lblTipo1.setBounds(6, 49, 90, 16);
			panel1.add(lblTipo1);
			
			JLabel lblPrimernombre1 = new JLabel(puntosCalificar.get(1).Nombre);
			lblPrimernombre1.setBounds(91, 6, 235, 16);
			panel1.add(lblPrimernombre1);
			
			JLabel lblPrimerTemperatura1 = new JLabel(puntosCalificar.get(1).Temperatura);
			lblPrimerTemperatura1.setBounds(91, 27, 235, 16);
			panel1.add(lblPrimerTemperatura1);
			
			JLabel lblPrimerTipo1 = new JLabel(puntosCalificar.get(1).Tipo);
			lblPrimerTipo1.setBounds(91, 49, 125, 16);
			panel1.add(lblPrimerTipo1);
			
			JLabel lblMunicipio1 = new JLabel("Municipio");
			lblMunicipio1.setBounds(6, 69, 90, 16);
			panel1.add(lblMunicipio1);
			
			JLabel lblDireccion1 = new JLabel("Direccion");
			lblDireccion1.setBounds(6, 88, 90, 16);
			panel1.add(lblDireccion1);
		
		
			JLabel label1 = new JLabel(puntosCalificar.get(1).Municipio);
			label1.setBounds(91, 69, 125, 16);
			panel1.add(label1);
			
			JLabel label_12 = new JLabel(puntosCalificar.get(1).Direccion);
			label_12.setBounds(91, 88, 125, 16);
			panel1.add(label_12);
		}
		if(puntosCalificar.size() >= 3) {
			
		
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(40, 281, 343, 109);
			contentPane.add(panel_1);
			
			JLabel label_2 = new JLabel("Nombre:");
			label_2.setBounds(6, 6, 90, 16);
			panel_1.add(label_2);
			
			JLabel label_3 = new JLabel("Temperatura:");
			label_3.setBounds(6, 27, 90, 16);
			panel_1.add(label_3);
			
			JLabel label_4 = new JLabel("Tipo:");
			label_4.setBounds(6, 49, 90, 16);
			panel_1.add(label_4);
			
			JLabel label_5 = new JLabel(puntosCalificar.get(2).Nombre);
			label_5.setBounds(91, 6, 235, 16);
			panel_1.add(label_5);
			
			JLabel label_6 = new JLabel(puntosCalificar.get(2).Temperatura);
			label_6.setBounds(91, 27, 235, 16);
			panel_1.add(label_6);
			
			JLabel label_7 = new JLabel(puntosCalificar.get(2).Tipo);
			label_7.setBounds(91, 49, 125, 16);
			panel_1.add(label_7);
			
			JLabel label_8 = new JLabel("Municipio");
			label_8.setBounds(6, 69, 90, 16);
			panel_1.add(label_8);
			
			JLabel label_9 = new JLabel("Direccion");
			label_9.setBounds(6, 88, 90, 16);
			panel_1.add(label_9);
			
			JLabel label_10 = new JLabel(puntosCalificar.get(2).Municipio);
			label_10.setBounds(91, 69, 125, 16);
			panel_1.add(label_10);
			
			JLabel label_11 = new JLabel(puntosCalificar.get(2).Direccion);
			label_11.setBounds(91, 88, 125, 16);
			panel_1.add(label_11);
		}
		if(puntosCalificar.size() >= 4) {
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBounds(40, 402, 343, 109);
			contentPane.add(panel_2);
			
			JLabel label_13 = new JLabel("Nombre:");
			label_13.setBounds(6, 6, 90, 16);
			panel_2.add(label_13);
			
			JLabel label_14 = new JLabel("Temperatura:");
			label_14.setBounds(6, 27, 90, 16);
			panel_2.add(label_14);
			
			JLabel label_15 = new JLabel("Tipo:");
			label_15.setBounds(6, 49, 90, 16);
			panel_2.add(label_15);
			
			JLabel label_16 = new JLabel(puntosCalificar.get(3).Nombre);
			label_16.setBounds(91, 6, 235, 16);
			panel_2.add(label_16);
			
			JLabel label_17 = new JLabel(puntosCalificar.get(3).Temperatura);
			label_17.setBounds(91, 27, 235, 16);
			panel_2.add(label_17);
			
			JLabel label_18 = new JLabel(puntosCalificar.get(3).Tipo);
			label_18.setBounds(91, 49, 125, 16);
			panel_2.add(label_18);
			
			JLabel label_19 = new JLabel("Municipio");
			label_19.setBounds(6, 69, 90, 16);
			panel_2.add(label_19);
			
			JLabel label_20 = new JLabel("Direccion");
			label_20.setBounds(6, 88, 90, 16);
			panel_2.add(label_20);
			
			JLabel label_21 = new JLabel(puntosCalificar.get(3).Municipio);
			label_21.setBounds(91, 69, 125, 16);
			panel_2.add(label_21);
			
			JLabel label_22 = new JLabel(puntosCalificar.get(3).Direccion);
			label_22.setBounds(91, 88, 125, 16);
			panel_2.add(label_22);
			
		}if(puntosCalificar.size() == 5) {
			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBounds(40, 524, 343, 109);
			contentPane.add(panel_3);
			
			JLabel label_23 = new JLabel("Nombre:");
			label_23.setBounds(6, 6, 90, 16);
			panel_3.add(label_23);
			
			JLabel label_24 = new JLabel("Temperatura:");
			label_24.setBounds(6, 27, 90, 16);
			panel_3.add(label_24);
			
			JLabel label_25 = new JLabel("Tipo:");
			label_25.setBounds(6, 49, 90, 16);
			panel_3.add(label_25);
			
			JLabel label_26 = new JLabel(puntosCalificar.get(4).Nombre);
			label_26.setBounds(91, 6, 235, 16);
			panel_3.add(label_26);
			
			JLabel label_27 = new JLabel(puntosCalificar.get(4).Temperatura);
			label_27.setBounds(91, 27, 235, 16);
			panel_3.add(label_27);
			
			JLabel label_28 = new JLabel(puntosCalificar.get(4).Tipo);
			label_28.setBounds(91, 49, 125, 16);
			panel_3.add(label_28);
			
			JLabel label_29 = new JLabel("Municipio");
			label_29.setBounds(6, 69, 90, 16);
			panel_3.add(label_29);
			
			JLabel label_30 = new JLabel("Direccion");
			label_30.setBounds(6, 88, 90, 16);
			panel_3.add(label_30);
			
			JLabel label_31 = new JLabel(puntosCalificar.get(4).Municipio);
			label_31.setBounds(91, 69, 125, 16);
			panel_3.add(label_31);
			
			JLabel label_32 = new JLabel(puntosCalificar.get(4).Direccion);
			label_32.setBounds(91, 88, 125, 16);
			panel_3.add(label_32);
		}
		this.setLocationRelativeTo(null);
	}
}
