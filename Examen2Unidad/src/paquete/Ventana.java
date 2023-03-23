package paquete;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	//private String logo = "logo";
	private String actual = "logo";
	private String anterior = "logo";

	private JPanel gran_panel = null;
	
	public Ventana() {
		
		//configuración_básica 
		this.setVisible(true);
		this.setSize(550, 600);
		this.setLayout(null);
		this.setTitle("Hola mundo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null); 
		this.getContentPane().setBackground(Color.decode("#8FDC91"));
		
		this.route();
		
	}
	
	public void route() {
		
		if(gran_panel!=null) {
			this.remove(gran_panel);
		}
		
		if(actual.equals("splash")) { 
			gran_panel = login();  
		}
		if(actual.equals("logo")) { 
			gran_panel = logo();  
		}
		if(actual.equals("login")) { 
			gran_panel = login();  
		}
		if(actual.equals("inicio")) { 
			gran_panel = inicio();  
		}
		if(actual.equals("miCuenta")) { 
			gran_panel = miCuenta();  
		}
		if(actual.equals("registro")) { 
			gran_panel = registro();  
		}
		
		this.add(gran_panel);
		this.revalidate();
		this.repaint(); 
		
	}
	
	public JPanel logo() {
		
		JPanel logo = new JPanel();
		logo.setVisible(true);
		logo.setSize(550, 600);
		logo.setBackground(Color.decode("#221B42"));
		logo.setLayout(null);
	
		
		JLabel img = new JLabel(new ImageIcon("espacio.jfif"));
		 img.setSize(350,230);
		 img.setLocation(100,50);
		logo.add(img);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setSize(100,40);
		btnEntrar.setLocation(200,350);
		logo.add(btnEntrar);
		
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "login";
				
				route();
				
				
			}});
		
		
		JLabel nameAlumno = new JLabel("José Eduardo Quirarte Arce");
		nameAlumno.setFont(new Font("Comic Sans",Font.BOLD,23));
		nameAlumno.setSize(400, 40);
		nameAlumno.setLocation(100, 520);
		//nameAlumno.setOpaque(true);
		//nameAlumno.setBackground(Color.white);
		logo.add(nameAlumno);
		
		return logo;
	}
	 
	public JPanel login() {
		
		JPanel login = new JPanel();
		login.setVisible(true);
		login.setSize(550, 600);
		login.setBackground(Color.decode("#5A51C4"));
		login.setLayout(null);
		
		JLabel tag1 = new JLabel("Inicia Sesión", JLabel.CENTER);
		tag1.setFont(new Font("Comic Sans",Font.BOLD,23));
		tag1.setSize(200, 40);
		tag1.setLocation(150, 10);
		tag1.setOpaque(true);
		//tag1.setBackground(Color.white);
		login.add(tag1);
		
		JLabel tag2 = new JLabel("Nombre de Usuario");
		tag2.setSize(200,20);
		tag2.setFont(new Font("Arial", Font.BOLD, 15));
		tag2.setLocation(50,70);
		login.add(tag2);
		
		JTextField mail = new JTextField();
		mail.setSize(300, 40);
		mail.setLocation(48, 100);
		mail.setFont(new Font("Comic Sans",Font.ITALIC,15));
		login.add(mail);
		
		JLabel tag3 = new JLabel("Contraseña");
		tag3.setSize(200, 20);
		tag3.setLocation(50, 150);
		tag3.setFont(new Font("Arial", Font.BOLD, 15));
		login.add(tag3);
		
		JPasswordField pwd = new JPasswordField();
		pwd.setSize(300, 40);
		pwd.setLocation(48, 175);
		login.add(pwd);
		
		JButton jbnAccess = new JButton("Listo");
		jbnAccess.setSize(100,30);
		jbnAccess.setLocation(150, 240);
		login.add(jbnAccess);
		
		jbnAccess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "inicio";
				
				route();
				
			}
			
		});
		
		return login;
	}
	
	
	public JPanel registro() {
		
		JPanel registro = new JPanel();
		registro.setVisible(true);
		registro.setSize(550, 600);
		registro.setBackground(Color.decode("#5A51C4"));
		registro.setLayout(null);
		
		JLabel tag4 = new JLabel("Panel de registro", JLabel.CENTER);
		tag4.setFont(new Font("Comic Sans",Font.BOLD,23));
		tag4.setSize(200, 40);
		tag4.setLocation(150, 10);
		tag4.setOpaque(true);
		tag4.setBackground(Color.white);
		registro.add(tag4);
		
		JLabel tag5 = new JLabel("Ingrese correo electrónico");
		tag5.setSize(200,20);
		tag5.setFont(new Font("Arial", Font.BOLD, 15));
		tag5.setLocation(50, 65);
		tag5.setForeground(Color.white);
		registro.add(tag5);
		
		JTextField mail_reg = new JTextField();
		mail_reg.setSize(380, 40);
		mail_reg.setLocation(48, 85);
		mail_reg.setFont(new Font("Comic Sans",Font.ITALIC,15));
		registro.add(mail_reg);
		
		JLabel tag6 = new JLabel("Ingrese su contraseña: ");
		tag6.setSize(200, 20);
		tag6.setLocation(50, 135);
		tag6.setFont(new Font("Arial", Font.BOLD, 15));
		tag6.setForeground(Color.white);
		registro.add(tag6);
		
		JPasswordField pwd_reg = new JPasswordField();
		pwd_reg.setSize(380, 40);
		pwd_reg.setLocation(48, 155);
		registro.add(pwd_reg);
		
		JLabel tag7 = new JLabel("Ingrese su nombre: ");
		tag7.setSize(200, 20);
		tag7.setLocation(50, 200);
		tag7.setFont(new Font("Arial", Font.BOLD, 15));
		tag7.setForeground(Color.white);
		registro.add(tag7);
		
		JTextField nombre = new JTextField();
		nombre.setSize(380, 40);
		nombre.setLocation(48, 225);
		registro.add(nombre);
		
		JLabel tag8 = new JLabel("Ingrese su apellido: ");
		tag8.setSize(200, 20);
		tag8.setLocation(50, 270);
		tag8.setFont(new Font("Arial", Font.BOLD, 15));
		tag8.setForeground(Color.white);
		registro.add(tag8);
		
		JTextField apellido = new JTextField();
		apellido.setSize(380, 40);
		apellido.setLocation(48, 295);
		registro.add(apellido);
		
		JButton saveUsr = new JButton("G U A R D A R");
		saveUsr.setSize(380, 35);
		saveUsr.setLocation(48,350);
		saveUsr.setBackground(Color.blue);
		registro.add(saveUsr);
		
		saveUsr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*anterior = actual;
				actual = "login";
				
				route();*/
			}
			
		});
		
		return registro;
		
	}
	
	public JPanel inicio() {
		
		
				
		
		JPanel inicio = new JPanel();
		inicio.setVisible(true);
		inicio.setSize(550, 600);
		inicio.setBackground(Color.decode("#5A51C4"));
		inicio.setLayout(null);
		
		
		JLabel saludo = new JLabel("Bienvenido Eduardo");
		saludo.setFont(new Font("Arial", Font.BOLD, 20));
		saludo.setSize(200,40);
		saludo.setLocation(160,50);
		inicio.add(saludo);
		
		
		//MENU SUPERIOR
		
		JMenuBar jmb = new JMenuBar();
	
		this.setJMenuBar(jmb);
		this.add(jmb);
		JMenu jm1 = new  JMenu("Cuenta");
		JMenu jm2 = new  JMenu("Usuarios");
		JMenu jm3 = new  JMenu("Ayuda");
		//para desactivar una opcion
		//jm3.setEnabled(false);
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		
		JMenuItem jmi1 = new JMenuItem("Mi Cuenta");
		JMenuItem jmi2 = new JMenuItem("Cerrar Sesión");

		jm1.add(jmi1);
		jm1.add(jmi2);
		
		jmi1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "miCuenta";
				
				route();
			}});
		inicio.add(jmb);
		
		return inicio;
	}
	
	public JPanel miCuenta() {
		JPanel miCuenta = new JPanel();
		miCuenta.setVisible(true);
		miCuenta.setSize(550, 600);
		miCuenta.setBackground(Color.decode("#5A51C4"));
		miCuenta.setLayout(null);
		
		
		JLabel saludo = new JLabel("estas es tu cuenta ");
		saludo.setFont(new Font("Arial", Font.BOLD, 20));
		saludo.setSize(200,40);
		saludo.setLocation(160,50);
		miCuenta.add(saludo);
		
		
		
		
		return miCuenta;
		
	}
}