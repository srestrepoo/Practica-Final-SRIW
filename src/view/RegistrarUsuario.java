package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Users;
import model.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class RegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField textPassword;
	private JComboBox<String> comboBoxDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuario frame = new RegistrarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setBounds(58, 37, 100, 14);
		contentPane.add(lblNombreDeUsuario);
		
		textUserName = new JTextField();
		textUserName.setBounds(200, 34, 172, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(58, 82, 100, 14);
		contentPane.add(lblContrasea);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(200, 79, 172, 20);
		contentPane.add(textPassword);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(58, 132, 100, 14);
		contentPane.add(lblDepartamento);
		
		comboBoxDepartment = new JComboBox<String>();
		comboBoxDepartment.setModel(new DefaultComboBoxModel<String>(new String[] {"Amazonas", "Antioquia", "Arauca", "Atlantico", "Bogota D.C.", "Bolivar", "Boyaca", "Caldas", "Caqueta", "Casanare", "Cauca", "Cesar", "Choco", "C\u00F3rdoba", "Cundinamarca", "Guiania", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Nari\u00F1o", "Norte de Santander", "Putumayo", "Quindio", "Risaralda", "San Andres y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupes", "Vichada"}));
		comboBoxDepartment.setBounds(200, 129, 172, 20);
		contentPane.add(comboBoxDepartment);
		
		JButton btnBackToLogin = new JButton("Regresar a iniciar Sesion");
		btnBackToLogin.setBounds(58, 200, 163, 23);
		contentPane.add(btnBackToLogin);
		
		JButton btnRegister = new JButton("Registrar");
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotonRegistrar(e);
			}
		});
				
		btnRegister.setBounds(283, 200, 89, 23);
		contentPane.add(btnRegister);
		this.setLocationRelativeTo(null);
	}
	
	
	private void BotonRegistrar(java.awt.event.ActionEvent evt){
		if(!textUserName.getText().isEmpty()  &&  String.valueOf(textPassword.getPassword()).isEmpty() ) {
			Users.addUser(new User(textUserName.getText(), String.valueOf(textPassword.getPassword()), comboBoxDepartment.getSelectedItem().toString()));
			this.setVisible(false);
			(new CalificarPuntos()).setVisible(true);
		}else {
			System.out.print("Campos vacios");
		}
	}
}
