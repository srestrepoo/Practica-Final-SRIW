package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CalificarPuntos extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CalificarPuntos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 39, 343, 71);
		contentPane.add(panel);
		
		JLabel lblPuntosACalificar = new JLabel("PUNTOS A CALIFICAR");
		lblPuntosACalificar.setBounds(161, 11, 117, 14);
		contentPane.add(lblPuntosACalificar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 121, 343, 71);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(40, 203, 343, 71);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(40, 285, 343, 71);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(40, 367, 343, 71);
		contentPane.add(panel_4);
		
		JButton btnPuntosQueMe = new JButton("Puntos que me podr\u00EDan gustar");
		btnPuntosQueMe.setBounds(116, 449, 198, 23);
		contentPane.add(btnPuntosQueMe);
	}
}
