package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.jena.rdf.model.Model;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CalificarPuntos extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CalificarPuntos(Model database) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
		comboBox.setBounds(199, 38, 127, 27);
		panel.add(comboBox);
		
		JLabel lblPuntosACalificar = new JLabel("PUNTOS A CALIFICAR");
		lblPuntosACalificar.setBounds(144, 13, 144, 14);
		contentPane.add(lblPuntosACalificar);
		
		JButton btnPuntosQueMe = new JButton("Puntos que me podrian gustar");
		btnPuntosQueMe.setBounds(89, 450, 245, 23);
		contentPane.add(btnPuntosQueMe);
		
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
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
		comboBox_1.setBounds(199, 38, 127, 27);
		panel_1.add(comboBox_1);
		
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
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
		comboBox_2.setBounds(199, 38, 127, 27);
		panel_2.add(comboBox_2);
		
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
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
		comboBox_3.setBounds(199, 38, 127, 27);
		panel_3.add(comboBox_3);
		
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
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setModel(new DefaultComboBoxModel<String>(new String[] {"Me gusta", "No me gusta"}));
		comboBox_4.setBounds(199, 38, 127, 27);
		panel_4.add(comboBox_4);
		this.setLocationRelativeTo(null);
	}
}
