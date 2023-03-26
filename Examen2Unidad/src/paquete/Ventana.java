package paquete;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
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
import java.util.Scanner;

import javax.swing.BorderFactory;
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

	//private String logo = "logoAA7799";
	private String actual = "actualizarMisDatos";
	private String anterior = "logo";

	private JPanel gran_panel = null;
	private String nombreUsuario;
	
	private JTextField textFieldNombrePersona = new JTextField();
	private JTextField textFieldNombreUser = new JTextField();
	private JTextField textFieldEmail = new JTextField();
	private JTextField textFieldContrasena = new JTextField();
	private JTextArea textAreaDescripcion = new JTextArea();
	
	
	
	//esta variable se usa para indicar en que numero de fila estan los datos de el usuario que inicio sesion
	//esto se usara por si quiere actualizar sus datos, al igual que el arreglo que esta debajo
	//private int posicionFilaDatos=0;
	private String[] datosUsuario = new String[5];
	private String[] datos = new String[5];
	

	BufferedReader reader = null;
	String line = null;
	
	public Ventana() {
		
		//configuración_básica 
		this.setVisible(true);
		this.setSize(550, 900);
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
		if(actual.equals("actualizarMisDatos")) { 
			gran_panel = actualizarMisDatos();  
		}
		if(actual.equals("listaUsuarios")) { 
			gran_panel = listaUsuarios();  
		}
		if(actual.equals("crearNuevoUsuario")) { 
			gran_panel = crearNuevoUsuario();  
		}
		if(actual.equals("ayuda")) { 
			gran_panel = ayuda();  
		}
		
		this.add(gran_panel);
		this.revalidate();
		this.repaint(); 
		
	}
	
	public JPanel logo() {
		
		//#234987   #293F9E
	
		JPanel logo = new JPanel();
		logo.setVisible(true);
		logo.setSize(550, 900);
		logo.setBackground(Color.decode("#3880D6"));
		logo.setLayout(null);
	
		ImageIcon imagen = new ImageIcon("logo.png");

		RoundJLabel labelImg = new RoundJLabel();
		labelImg.setSize(200,230);
		labelImg.setLocation(170,90);
		labelImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200, 200 , Image.SCALE_SMOOTH)));
		logo.add(labelImg);

		
		RoundJButton btnEntrar = new RoundJButton("#D3E9EB");
		btnEntrar.setText("Empezar");
		btnEntrar.setSize(100,40);
		btnEntrar.setBackground(Color.white);
		btnEntrar.setLocation(220,450);
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
		nameAlumno.setLocation(100, 790);
		//nameAlumno.setOpaque(true);
		//nameAlumno.setBackground(Color.white);
		logo.add(nameAlumno);
		
		return logo;
	}
	 

	
	 
	public JPanel login() {
		
		JPanel login = new JPanel();
		login.setVisible(true);
		login.setSize(550, 900);
		login.setBackground(Color.decode("#5A51C4"));
		login.setLayout(null);
		
		/*JPanel aviso = new JPanel();
		aviso.setVisible(true);
		aviso.setSize(300, 400);
		aviso.setLocation(100,250);
		aviso.setBackground(Color.decode("#5A51C4"));
		aviso.setLayout(null);*/
		
		
		
		JLabel tag1 = new JLabel("Inicia Sesión", JLabel.CENTER);
		tag1.setFont(new Font("Comic Sans",Font.BOLD,36));
		tag1.setSize(300, 40);
		tag1.setLocation(120, 30);
		//tag1.setOpaque(true);
		//tag1.setBackground(Color.white);
		login.add(tag1);
		
		ImageIcon imagen = new ImageIcon("login.png");

		RoundJLabel labelImg = new RoundJLabel();
		labelImg.setSize(200,230);
		labelImg.setLocation(170,90);
		labelImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200, 200 , Image.SCALE_SMOOTH)));
		login.add(labelImg);
		
		
		JLabel tag2 = new JLabel("Nombre de Usuario");
		tag2.setSize(200,40);
		tag2.setFont(new Font("Arial", Font.BOLD, 19));
		tag2.setLocation(140,340);
		login.add(tag2);
		
		RoundJTextField textFieldnombreUsuario = new RoundJTextField();
		textFieldnombreUsuario.setSize(250, 30);
		textFieldnombreUsuario.setLocation(140, 380);
		textFieldnombreUsuario.setFont(new Font("Comic Sans",Font.ITALIC,15));
		login.add(textFieldnombreUsuario);
		
		JLabel tag3 = new JLabel("Contraseña");
		tag3.setSize(200, 20);
		tag3.setLocation(140, 430);
		tag3.setFont(new Font("Arial", Font.BOLD, 19));
		login.add(tag3);
		
		RoundJPasswordField pwd = new RoundJPasswordField();
		pwd.setFont(new Font("Comic Sans",Font.ITALIC,15));
		pwd.setSize(250, 30);
		pwd.setLocation(140, 450);
		login.add(pwd);
		
		RoundJButton jbnAccess = new RoundJButton("#54EB9A");
		jbnAccess.setText("Listo");
		jbnAccess.setSize(80,30);
		jbnAccess.setBackground(Color.white);
		jbnAccess.setLocation(270, 510);
		login.add(jbnAccess);
		
		
		jbnAccess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				boolean acceso=false;
				nombreUsuario = textFieldnombreUsuario.getText();
				char[] pwChrs = pwd.getPassword();
				String password = new String(pwChrs);
				
				

				BufferedReader reader = null;
				//try catch es por si hay error que el programa no se cierre
				
					try {
						reader = new BufferedReader( new FileReader("users.txt"));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String line = null;
					try {
						line = reader.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						if(line==null) {
							System.out.println("linea: "+line);
						}
						e1.printStackTrace();
					}
					
					
					while(line!= null) {
						
					    datos = null;
						

						datos = line.split(","); 
					
						//esta condicion es por si la linea en la que esta en null, osea no hay nada no de error
						if(datos[0].equals("") ) {
					
						}else {
							//aqui capturo los todos los datos del usuario en caso de que desee actualiarlos
							datosUsuario[0]=datos[0];
							datosUsuario[1]=datos[1];
							datosUsuario[2]=datos[2];
							datosUsuario[3]=datos[3];
							datosUsuario[4]=datos[4];

							//String d=datos[2].replaceAll("\"", "");
							String p=datos[3];
							String d=datos[1];

							if(d.equals(nombreUsuario) && p.equals(password)) {
									acceso=true;
									break;
							}else {
								acceso=false;

							}
							
							
						}
						
						try {
							line= reader.readLine();
							//posicionFilaDatos++;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
					if(acceso==true) {
						JOptionPane.showMessageDialog(null,"Bienvenido "+nombreUsuario);
						anterior = actual;
						actual = "inicio";
						
						route();
					}else {
						JOptionPane.showMessageDialog(null,"El usuario y contraseña no coinciden");
						
					}
																
				
			}
			
		});
		
		
		RoundJButton btnAtras = new RoundJButton("#EA5C4E");
		btnAtras.setText("Cancelar");
		btnAtras.setBackground(Color.white);
		btnAtras.setSize(100,30);
		btnAtras.setLocation(150, 510);
		login.add(btnAtras);
		
		
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "logo";
				
				route();
			}});
		
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
		inicio.setSize(550, 900);
		inicio.setBackground(Color.decode("#5A51C4"));
		inicio.setLayout(null);
		
		ponerMenuSuperior(inicio);
		
		JLabel saludo = new JLabel("Bienvenido "+nombreUsuario);
		saludo.setFont(new Font("Arial", Font.BOLD, 36));
		saludo.setSize(500,40);
		saludo.setLocation(140,100);
		inicio.add(saludo);
		
		ImageIcon imagen = new ImageIcon("perfil.png");

		RoundJLabel labelImg = new RoundJLabel();
		labelImg.setSize(200,230);
		labelImg.setLocation(170,240);
		labelImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200, 200 , Image.SCALE_SMOOTH)));
		inicio.add(labelImg);
		
		
		
		
		return inicio;
	}
	
	public JPanel miCuenta() {
		JPanel miCuenta = new JPanel();
		miCuenta.setVisible(true);
		miCuenta.setSize(550, 900);
		miCuenta.setBackground(Color.decode("#5A51C4"));
		miCuenta.setLayout(null);
		
		ponerMenuSuperior(miCuenta);
		
		JLabel saludo = new JLabel("Mi Cuenta");
		saludo.setFont(new Font("Arial", Font.BOLD, 34));
		saludo.setSize(200,40);
		saludo.setLocation(180,50);
		miCuenta.add(saludo);
		

				JLabel tag5 = new JLabel("Nombre");
				tag5.setSize(200,20);
				tag5.setFont(new Font("Arial", Font.BOLD, 19));
				tag5.setLocation(100, 180);
				tag5.setForeground(Color.white);
				miCuenta.add(tag5);
				
				JTextField  nombrePersona= new JTextField();
				nombrePersona.setSize(300, 30);
				nombrePersona.setLocation(100, 220);
				nombrePersona.setFont(new Font("Comic Sans",Font.ITALIC,15));
				miCuenta.add(nombrePersona);
				
				JLabel nombreUsuario = new JLabel("Nombre de Usuario");
				nombreUsuario.setSize(200,20);
				nombreUsuario.setFont(new Font("Arial", Font.BOLD, 19));
				nombreUsuario.setLocation(100, 270);
				nombreUsuario.setForeground(Color.white);
				miCuenta.add(nombreUsuario);
				
				JTextField textFieldNombreUsuario = new JTextField();
				textFieldNombreUsuario.setSize(300, 30);
				textFieldNombreUsuario.setLocation(100, 300);
				textFieldNombreUsuario.setFont(new Font("Comic Sans",Font.ITALIC,15));
				miCuenta.add(textFieldNombreUsuario);
				
				JLabel labelEmail = new JLabel("Correo Electrónico");
				labelEmail.setSize(200,20);
				labelEmail.setFont(new Font("Arial", Font.BOLD, 19));
				labelEmail.setLocation(100, 345);
				labelEmail.setForeground(Color.white);
				miCuenta.add(labelEmail);
				
				JTextField textFieldEmail = new JTextField();
				textFieldEmail.setSize(300, 30);
				textFieldEmail.setLocation(100, 370);
				textFieldEmail.setFont(new Font("Comic Sans",Font.ITALIC,15));
				miCuenta.add(textFieldEmail);
				
				
				
				
				JLabel tag6 = new JLabel("Contraseña");
				tag6.setSize(300, 30);
				tag6.setLocation(100, 410);
				tag6.setFont(new Font("Arial", Font.BOLD, 19));
				tag6.setForeground(Color.white);
				miCuenta.add(tag6);
				
				
				
				JTextField contrasena = new JTextField();
				contrasena.setSize(300, 30);
				contrasena.setLocation(100, 450);
				contrasena.setFont(new Font("Comic Sans",Font.ITALIC,15));
				miCuenta.add(contrasena);
				
				
				//le ponemos sus respectivos datos del usuario a los campos, estos se tomaron cuando se inicia sesion
				
				nombrePersona.setText(datosUsuario[0]);
				textFieldNombreUsuario.setText(datosUsuario[1]);
				textFieldEmail.setText(datosUsuario[2]);
				contrasena.setText(datosUsuario[3]);
				
				RoundJButton btnActualizarDatos = new RoundJButton("#54EB9A");
				btnActualizarDatos.setText("Actualizar Datos");
				btnActualizarDatos.setSize(150, 35);
				btnActualizarDatos.setLocation(260,515);
				btnActualizarDatos.setBackground(Color.decode("#38BDE2"));
				miCuenta.add(btnActualizarDatos);
				
				
				
				
				btnActualizarDatos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
						
						anterior = actual;
						actual = "actualizarMisDatos";
						
						route();
					}});
				
				
				RoundJButton btnCancelar = new RoundJButton("#EB5041");
				btnCancelar.setText("Cancelar");
				btnCancelar.setSize(150, 35);
				btnCancelar.setLocation(90,515);
				btnCancelar.setBackground(Color.red);
				miCuenta.add(btnCancelar);
				
				
				
				
				btnCancelar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "inicio";
						
						route();
					}});
					
					
					
		
		
		
		
		return miCuenta;
		
	}
	
	public JPanel actualizarMisDatos() {
		
		
		JPanel miCuenta = new JPanel();
		miCuenta.setVisible(true);
		miCuenta.setSize(550, 900);
		miCuenta.setBackground(Color.decode("#5A51C4"));
		miCuenta.setLayout(null);
		
		ponerDatosRegistro(miCuenta);
		
		JLabel saludo = new JLabel("Mi Cuenta");
		saludo.setFont(new Font("Arial", Font.BOLD, 34));
		saludo.setSize(200,40);
		saludo.setLocation(160,80);
		miCuenta.add(saludo);
		
		//ponemos por defecto los datos que ya tiene el usuario en los campos, si los desea cambiar solo los cambia y 
		//da click en actualizar info
		textFieldNombrePersona.setText(datos[0]);
		textFieldNombreUser.setText(datos[1]);
		textFieldEmail.setText(datos[2]);
		textFieldContrasena.setText(datos[3]);
		textAreaDescripcion.setText(datos[4]);
				
		
		RoundJButton btnActualizarDatos = new RoundJButton("#54EB9A");
		btnActualizarDatos.setText("Actualizar Datos");
				btnActualizarDatos.setSize(150, 35);
				btnActualizarDatos.setLocation(260,750);
				btnActualizarDatos.setBackground(Color.blue);
				miCuenta.add(btnActualizarDatos);
				
				
				
			
				
				btnActualizarDatos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						BufferedReader reader = null;
						 BufferedWriter writer = null;
						//tomamos los nuevos datos del usuario si es que cambio alguno
						 datosUsuario[0]=textFieldNombrePersona.getText();
						 datosUsuario[1]=textFieldNombreUser.getText();
						 datosUsuario[2]=textFieldEmail.getText();
						 datosUsuario[3]=textFieldContrasena.getText();
						 datosUsuario[4]=textAreaDescripcion.getText();

						 
						 File archivo = new File("users.txt");
				            Scanner lector = null;
							try {
								lector = new Scanner(archivo);
							} catch (FileNotFoundException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}
				            StringBuilder contenido = new StringBuilder();
									
										
									
										//guardamos los datos anteriores del usuario
										String datoAEliminar=datos[0]+","+datos[1]+","+datos[2]+","+datos[3]+","+datos[4];
										//borramos los datos del usuario
										
										try {
								            // Leer el contenido completo del archivo
								            while (lector.hasNextLine()) {
								                String linea = lector.nextLine();
								                contenido.append(linea).append("\n");
								            }
								           lector.close();

								          
								            String contenidoActualizado = contenido.toString().replace(datoAEliminar, "");

								            // Escribir el contenido actualizado en el archivo
								            FileWriter escritor = new FileWriter(archivo);
								            escritor.write(contenidoActualizado);
								            escritor.close();
								        } catch (IOException e1) {
								            System.out.println("Error al actualizar el archivo: " + e1.getMessage());
								        }
										
									
							 
										try {
											writer = new BufferedWriter(new FileWriter("users.txt", true));
										} catch (IOException e2) {
											// TODO Auto-generated catch block
											e2.printStackTrace();
										}

												try {
													//añadimos el usuario con sus nuevos datos
													writer.write(datosUsuario[0]+","+datosUsuario[1]+","+datosUsuario[2]+","+datosUsuario[3]+","+datosUsuario[4]);
													writer.close();
													JOptionPane.showMessageDialog(null,"Registro Correcto en el sistema ");
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}

					}});
				
				
				RoundJButton btncCancelar = new RoundJButton("#EB5041");
				btncCancelar.setText("Cancelar");
				btncCancelar.setSize(150, 35);
				btncCancelar.setLocation(90,750);
				btncCancelar.setBackground(Color.red);
				miCuenta.add(btncCancelar);
				
				
				
				
				btncCancelar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "miCuenta";
						
						route();
					}});
					
					
		
		
		
		
		return miCuenta;
		
	}
	
	public JPanel listaUsuarios() {
		JPanel listaUsuarios = new JPanel();
		listaUsuarios.setVisible(true);
		listaUsuarios.setSize(550, 900);
		listaUsuarios.setBackground(Color.decode("#5A51C4"));
		listaUsuarios.setLayout(null);
		
		ponerMenuSuperior(listaUsuarios);
		
		
		JLabel txtListaUsuarios = new JLabel("Lista De Usuarios");
		txtListaUsuarios.setFont(new Font("Arial", Font.BOLD, 34));
		txtListaUsuarios.setSize(400,40);
		txtListaUsuarios.setLocation(120,80);
		listaUsuarios.add(txtListaUsuarios);
		
		JComboBox listaUser = new JComboBox();
		listaUser.setSize(300,40);
		listaUser.setLocation(90,200);
		listaUser.addItem("Editar a: "+datosUsuario[0]);
		listaUser.addItem("dadas");
		listaUsuarios.add(listaUser);
		
		RoundJButton editarUser= new RoundJButton("#54EB9A");
		editarUser.setText("Editar a: "+datosUsuario[0]);
		editarUser.setBackground(Color.red);
		editarUser.setSize(200,40);
		editarUser.setLocation(160,290);
		listaUsuarios.add(editarUser);
		
		
		editarUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
								
				anterior = actual;
				actual = "actualizarMisDatos";
				
				route();
				
				
			}});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setSize(50,50);
 
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("holaa");
			}});

		//se agrega la tabla 
		listaUsuarios.add(cargarTabla());

		return listaUsuarios;
		
	}
	
	public JScrollPane cargarTabla() {
		
		BufferedReader reader = null;
		//try catch es por si hay error que el programa no se cierre
		
			try {
				reader = new BufferedReader( new FileReader("users.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				if(line==null) {
					System.out.println("linea: "+line);
				}
				e1.printStackTrace();
			}
			int cantFilas=0;
			//esto es para saber que tamano tendra la tabla
			while(line!= null) {
				
			  
				if(line!="") {
					cantFilas++;
				}
				
				try {
					line= reader.readLine();
					//posicionFilaDatos++;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			System.out.println("tamano: "+cantFilas);
			//tabla
			 String [] nombresColumnas= {"Nombre","Nombre de Usuario","Correo Electrónico","Contraseña","Descripción","Acciones"};
			
			
			Object[][] datosUsuarios = new Object[cantFilas][6];
			
			try {
				reader = new BufferedReader(new FileReader("users.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 // este while es para meter los datos en la matriz que tiene los datos de las filas
			 int fila=0;
			
			 while (line != null) {
					
					String[] datos = null;
					
					datos = line.split(",");
					
					//esta condicion es por si la linea en la que esta en null, osea no hay nada no de error
					//ya que hay espacios vacios en users.txt cuando se actualizan los datos de algun usuario
					if(datos[0].equals("")) {
						
					}else {
						datosUsuarios[fila][0]=datos[0];
						datosUsuarios[fila][1]=datos[1];
						datosUsuarios[fila][2]=datos[2];
						datosUsuarios[fila][3]=datos[3];
						datosUsuarios[fila][4]=datos[4];
					
						
						fila++;
					}

					
					try {
						line = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			
			 
			 DefaultTableModel mod = new DefaultTableModel(datosUsuarios,nombresColumnas);
			 JTable tablaUsuarios = new JTable(mod);
			 JScrollPane scroll = new JScrollPane(tablaUsuarios);

			 tablaUsuarios.getColumn("Acciones").setCellRenderer(new tabla());
			 scroll.setBounds(80,400,400,100);
				
				
				
				
			return scroll;
			
			
	}
	
	//esta funcion es para reutilizar el codigo que tiene el momento de crear un nuevo usuario y modificar los datos de uno
	//ya existenete aqui va lo que pide para hacerlo en ambos casos, como correo, contrasena, usuario etc
	public JPanel ponerDatosRegistro(JPanel miCuenta) {
	
		
			ponerMenuSuperior(miCuenta);
				JLabel tag5 = new JLabel("Nombre");
				tag5.setSize(200,20);
				tag5.setFont(new Font("Arial", Font.BOLD, 19));
				tag5.setLocation(100, 180);
				tag5.setForeground(Color.white);
				miCuenta.add(tag5);
				
				
				
				textFieldNombrePersona.setSize(300, 30);
				textFieldNombrePersona.setLocation(100, 200);
				textFieldNombrePersona.setFont(new Font("Comic Sans",Font.ITALIC,15));
				miCuenta.add(textFieldNombrePersona);
				
				JLabel labelUser= new JLabel("Usuario");
				labelUser.setSize(200,20);
				labelUser.setFont(new Font("Arial", Font.BOLD, 19));
				labelUser.setLocation(100, 240);
				labelUser.setForeground(Color.white);
				miCuenta.add(labelUser);
				
				
				textFieldNombreUser.setSize(300, 30);
				textFieldNombreUser.setLocation(100, 260);
				textFieldNombreUser.setFont(new Font("Comic Sans",Font.ITALIC,19));
				miCuenta.add(textFieldNombreUser);
				
				JLabel labelEmail = new JLabel("Correo Electrónico");
				labelEmail.setSize(200,20);
				labelEmail.setFont(new Font("Arial", Font.BOLD, 19));
				labelEmail.setLocation(100, 300);
				labelEmail.setForeground(Color.white);
				miCuenta.add(labelEmail);
				
				
				textFieldEmail.setSize(300, 30);
				textFieldEmail.setLocation(100, 320);
				textFieldEmail.setFont(new Font("Comic Sans",Font.ITALIC,19));
				miCuenta.add(textFieldEmail);
				
				
				
				
				JLabel tag6 = new JLabel("Contraseña");
				tag6.setSize(300, 30);
				tag6.setLocation(100, 360);
				tag6.setFont(new Font("Arial", Font.BOLD, 19));
				tag6.setForeground(Color.white);
				miCuenta.add(tag6);
				
				
				
			
				textFieldContrasena.setSize(300, 30);
				textFieldContrasena.setLocation(100, 390);
				textFieldContrasena.setFont(new Font("Comic Sans",Font.ITALIC,15));
				miCuenta.add(textFieldContrasena);
				
			
					
					
				
				JLabel  labelDescripcion= new JLabel("Descripción");
				labelDescripcion.setSize(200,20);
				labelDescripcion.setFont(new Font("Arial", Font.BOLD, 19));
				labelDescripcion.setLocation(100, 430);
				labelDescripcion.setForeground(Color.white);
				miCuenta.add(labelDescripcion);
				
				
				textAreaDescripcion.setSize(300, 100);
				textAreaDescripcion.setLocation(100, 450);
				textAreaDescripcion.setFont(new Font("Comic Sans",Font.ITALIC,14));
				miCuenta.add(textAreaDescripcion);
					
				
				JLabel comidaFav = new JLabel("Comida Favorita");
				comidaFav.setSize(190,40);
				comidaFav.setLocation(100,555);
				comidaFav.setForeground(Color.white);
				comidaFav.setFont(new Font("Arial",Font.BOLD,19));
				miCuenta.add(comidaFav);
				
				JCheckBox marco1 = new JCheckBox("Boneless");
				JCheckBox marco2= new JCheckBox("Sushi");
				JCheckBox marco3 = new JCheckBox("Pizza");
		  
				
				marco1.setBackground(Color.decode("#56D5F0"));
				marco2.setBackground(Color.decode("#D58FF0"));
				marco3.setBackground(Color.decode("#B0D7F5"));
				
				
				
				marco1.setSize(120,30);
				marco2.setSize(120,30);
				marco3.setSize(120,30);

				marco1.setLocation(50,600);
				marco2.setLocation(200,600);
				marco3.setLocation(350,600);
				
				
				miCuenta.add(marco1);
				miCuenta.add(marco2);
				miCuenta.add(marco3);
				
				
				JLabel colorFavorito = new JLabel("Color Favorito");
				colorFavorito.setSize(190,40);
				colorFavorito.setLocation(100,635);
				colorFavorito.setForeground(Color.white);
				colorFavorito.setFont(new Font("Arial",Font.BOLD,19));
				miCuenta.add(colorFavorito);
				
				JCheckBox marco4 = new JCheckBox("Rojo");
				JCheckBox marco5= new JCheckBox("Azul");
				JCheckBox marco6 = new JCheckBox("Amarillo");
		  
				marco4.setBackground(Color.decode("#F55857"));
				marco5.setBackground(Color.decode("#5580FA"));
				marco6.setBackground(Color.decode("#FAE855"));
				
				marco4.setSize(120,30);
				marco5.setSize(120,30);
				marco6.setSize(120,30);

				marco4.setLocation(50,680);
				marco5.setLocation(200,680);
				marco6.setLocation(350,680);
				
				
				miCuenta.add(marco4);
				miCuenta.add(marco5);
				miCuenta.add(marco6);
				
				
				return miCuenta;
	}
	public JPanel crearNuevoUsuario() {
		
		
		JPanel miCuenta = new JPanel();
		miCuenta.setVisible(true);
		miCuenta.setSize(550, 900);
		miCuenta.setBackground(Color.decode("#5A51C4"));
		miCuenta.setLayout(null);
		
		ponerDatosRegistro(miCuenta);
		
		
		JLabel saludo = new JLabel("Crear Usuario");
		saludo.setFont(new Font("Arial", Font.BOLD, 34));
		saludo.setSize(500,40);
		saludo.setLocation(140,80);
		miCuenta.add(saludo);
		
				
				RoundJButton btnCrearNuevoUsuario = new RoundJButton("#54EB9A");
				btnCrearNuevoUsuario.setText("Crear Usuario");
				btnCrearNuevoUsuario.setSize(150, 35);
				btnCrearNuevoUsuario.setLocation(260,750);
				btnCrearNuevoUsuario.setBackground(Color.blue);
				miCuenta.add(btnCrearNuevoUsuario);
				
				
				
				
				btnCrearNuevoUsuario.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						boolean acceso=false;
						String nombrePersona = textFieldNombrePersona.getText();
						String nombreUser = textFieldNombreUser.getText();
						String email = textFieldEmail.getText();
						String contrasena = textFieldContrasena.getText();
						String descripcion = textAreaDescripcion.getText();
				
						if(nombreUser.equals("") || contrasena.equals("")) {
							JOptionPane.showMessageDialog(null,"Error, Los campos nombre de usuario y contraseña no pueden estar vacios ");
						}else {
							
							System.out.println(comprobarSiUsuarioExiste(nombreUser,contrasena));
							if(comprobarSiUsuarioExiste(nombreUser,contrasena)==false) {

								 BufferedWriter writer = null;
								 
								try {
									writer = new BufferedWriter(new FileWriter("users.txt", true));
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}

								try {
									writer.newLine();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}

										try {
								
											writer.write(nombrePersona+","+nombreUser+","+email+","+contrasena+","+descripcion);
											writer.close();
											
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
			
									JOptionPane.showMessageDialog(null,"Registro Correcto en el sistema ");
							}else {
								JOptionPane.showMessageDialog(null,"Datos ya registrados! Porfavor escoge otros");
							}
							
						}
						
			
					}});
				
				RoundJButton btnCancelar = new RoundJButton("#EB5041");
				btnCancelar.setText("Cancelar");
				btnCancelar.setSize(150, 35);
				btnCancelar.setLocation(90,750);
				btnCancelar.setBackground(Color.red);
				miCuenta.add(btnCancelar);
				
				
				
				
				btnCancelar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}});

		
		return miCuenta;
		
	}
	
	public boolean comprobarSiUsuarioExiste(String nombreUser,String contrasena) {
		
		boolean existe=false;
		

		try {
			reader = new BufferedReader( new FileReader("users.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			line = reader.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			if(line==null) {
				System.out.println("linea: "+line);
			}
			e1.printStackTrace();
		}
		while(line!= null) {
			
		    datos = null;

			datos = line.split(","); 
			
			if(datos[0].equals("")) {
				
			}else {
				
				if(datos[1].equals(nombreUser) && datos[3].equals(contrasena)) {
					
					existe=true;
					break;
				}else {
					existe=false;
				}
			}
					

			try {
				line= reader.readLine();
				//posicionFilaDatos++;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		return existe;
		
		
		
	}
	public JPanel ponerMenuSuperior(JPanel panel) {

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
				
				JMenuItem jmi3 = new JMenuItem("Lista de Usuarios");
				JMenuItem jmi4 = new JMenuItem("Crear Usuario");
				
				JMenuItem jmi5 = new JMenuItem("¿Cómo crear un usuario?");
				
				jm1.add(jmi1);
				jm1.add(jmi2);
				
				jm2.add(jmi3);
				jm2.add(jmi4);
				
				jm3.add(jmi5);
				

				
				jmi1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "miCuenta";
						
						route();
					}});
				
				jmi2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "logo";
						
						route();
				}});
				
				jmi3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "listaUsuarios";
						
						route();
				}});
				
				jmi4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "crearNuevoUsuario";
						
						route();
				}});
				jmi5.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "ayuda";
						
						route();
					}});
				
				panel.add(jmb);

		
		
		return panel;
	}
	public JPanel ayuda() {
		
		JPanel panelAyuda = new JPanel();
		panelAyuda.setVisible(true);
		panelAyuda.setSize(550, 900);
		panelAyuda.setBackground(Color.decode("#5A51C4"));
		panelAyuda.setLayout(null);
		
		
		ponerMenuSuperior(panelAyuda);

		JLabel label = new JLabel("¿Cómo crear un usuario?");
		label.setFont(new Font("Arial", Font.BOLD, 34));
		label.setSize(500,40);
		label.setLocation(80,80);
		panelAyuda.add(label);
		
		
		JTextArea  txtArea1 = new JTextArea("1. Hacer click en la opción \"Usuario\" en el menú superior."
				+"\n 2. Hacer click en la opción \"Crear Usuario\" en el menu desplegado."
				+"\n 3. Llenar los campos solicitados."
				+"\n 4. Escribir una pequeña descripción de ti."
				+"\n 5. Seleccionar tu comida favorita."
				+"\n 6. Seleccionar tu color favorito."
				+"\n 7. Hacer click en el botón \"Crear Usuario\""
				+"\n 8. Listo, el usuario se ha creado.");
		txtArea1.setSize(400,200);
		txtArea1.setLocation(80,200);
		txtArea1.setFont(new Font("Arial", Font.BOLD, 18));
		//txtArea1.setBackground(Color.red);
	
		JScrollPane scroll = new JScrollPane(txtArea1);

		 
		 scroll.setBounds(80,200,400,200);

		
		panelAyuda.add(scroll);
		
		
		
		RoundJButton btnCrearUsuario = new RoundJButton("#54EB9A");
		btnCrearUsuario.setText("Crear un usuario ahora");
		btnCrearUsuario.setSize(200, 35);
		btnCrearUsuario.setLocation(180,450);
		btnCrearUsuario.setBackground(Color.decode("#4187FA"));
		panelAyuda.add(btnCrearUsuario);
		
		
		
		
		btnCrearUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "crearNuevoUsuario";
				
				route();
			}});
		
		
		
		
		return panelAyuda;
	}


	
}
