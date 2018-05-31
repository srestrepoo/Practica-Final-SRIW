package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.wifiPlace;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.util.ArrayList;

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

	/**
	 * Create the frame.
	 */
	public CalificarPuntos(ArrayList<wifiPlace> puntosCalificar) {
		
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
			this.setLocationRelativeTo(null);
		}
		
	}
	
	private void calificarPuntos(ActionEvent evt){
		System.out.println(primerComboBox.getSelectedItem());
		System.out.println(segundoComboBox.getSelectedItem());
		System.out.println(tercerComboBox.getSelectedItem());
		System.out.println(cuartoComboBox.getSelectedItem());
		System.out.println(quintoComboBox.getSelectedItem());
	}
}
