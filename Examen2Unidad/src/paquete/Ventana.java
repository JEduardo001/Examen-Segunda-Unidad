package paquete;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

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

import javax.swing.AbstractCellEditor;
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

public class Ventana extends JFrame {

	//private String logo = "logoAA7799";
	private String actual = "logo";
	private String anterior = "logo";

	private JPanel gran_panel = null;
	private String nombreUsuario;
	
	private JTextField textFieldNombrePersona = new JTextField();
	private JTextField textFieldNombreUser = new JTextField();
	private JTextField textFieldEmail = new JTextField();
	private JTextField textFieldContrasena = new JTextField();
	private JTextField textFieldDescripcion = new JTextField();

	private String comidaFavorita=null;
	private String colorFavorito=null;

	//lista de ususarios usada en la seccion listaUsuarios
	private JComboBox listaUser = new JComboBox();
	
	
	//check boxs
	private JCheckBox marco1 = new JCheckBox("Boneless");
	private JCheckBox marco2= new JCheckBox("Sushi");
	private JCheckBox marco3 = new JCheckBox("Pizza");
	
	private JCheckBox marco4 = new JCheckBox("Rojo");
	private JCheckBox marco5= new JCheckBox("Azul");
	private JCheckBox marco6 = new JCheckBox("Amarillo");
	
	//esta variable se usa para indicar en que numero de fila estan los datos de el usuario que inicio sesion
	//esto se usara por si quiere actualizar sus datos, al igual que el arreglo que esta debajo
	//private int posicionFilaDatos=0;
	private String[] datosUsuario = new String[7];
	private String[] datos = new String[7];
	//private Object[][] datosUsuarios = new Object[cantFilas][8];
	String[][] datosUsuarios = new String[20][8];
	
	private boolean acceso=false;
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
		jbnAccess.setLocation(290, 510);
		login.add(jbnAccess);
		
		
		jbnAccess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
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
							datosUsuario[5]=datos[5];
							datosUsuario[6]=datos[6];
							
							
							
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
						JOptionPane.showMessageDialog(null,"No se encontró un usario con los datos ingresados");
						
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
		
		
		

		RoundJButton btnCrearCuenta = new RoundJButton("#4CC8F5");
		btnCrearCuenta.setText("Crear una cuenta nueva");
		btnCrearCuenta.setBackground(Color.white);
		btnCrearCuenta.setSize(200,30);
		btnCrearCuenta.setLocation(165, 550);
		login.add(btnCrearCuenta);
		

		btnCrearCuenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "crearNuevoUsuario";
				
				route();
			}});
		
		
		return login;
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
				
				System.out.println(datosUsuario[0]);
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
		
		
	
		//Listeners de los checkBox
				marco1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						comidaFavorita=marco1.getText();
					}});
				
				
				marco2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						comidaFavorita=marco2.getText();
					}});
				
				marco3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						comidaFavorita=marco3.getText();
					}});
				
				marco4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						colorFavorito=marco4.getText();

					}});
				
				marco5.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						colorFavorito=marco5.getText();
					}});
				
				marco6.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						colorFavorito=marco6.getText();
					}});
		
		//ponemos por defecto los datos que ya tiene el usuario en los campos, si los desea cambiar solo los cambia y 
		
				
				textFieldNombrePersona.setText(datosUsuario[0]);
				textFieldNombreUser.setText(datosUsuario[1]);
				textFieldEmail.setText(datosUsuario[2]);
				textFieldContrasena.setText(datosUsuario[3]);
				textFieldDescripcion.setText(datosUsuario[4]);

				
		
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
						 datosUsuario[4]=textFieldDescripcion.getText();
						 datosUsuario[5]=comidaFavorita;
						 datosUsuario[6]=colorFavorito;
						 
						 //comprobamos si los datos Nombre de Usuario y contrasena ya los tiene un usuario
						 if(!comprobarSiUsuarioExiste(datosUsuario[1],datosUsuario[3])) {
							 File archivo = new File("users.txt");
					            Scanner lector = null;
								try {
									lector = new Scanner(archivo);
								} catch (FileNotFoundException e3) {
									// TODO Auto-generated catch block
									e3.printStackTrace();
								}
					            StringBuilder contenido = new StringBuilder();
										
											
									//cuanto llamar a comprobarSiusuarioExiste ahi datos[] se queda con los datos del ultimo user
					           //cargo los datos anteriores del usuario en el que estoy 
					            cargarDatosDelUsuario();
					            
					          //tomamos los nuevos datos del usuario si es que cambio alguno
								 datosUsuario[0]=textFieldNombrePersona.getText();
								 datosUsuario[1]=textFieldNombreUser.getText();
								 datosUsuario[2]=textFieldEmail.getText();
								 datosUsuario[3]=textFieldContrasena.getText();
								 datosUsuario[4]=textFieldDescripcion.getText();
								 datosUsuario[5]=comidaFavorita;
								 datosUsuario[6]=colorFavorito;
					            
											//guardamos los datos anteriores del usuario
											String datoAEliminar=datos[0]+","+datos[1]+","+datos[2]+","+datos[3]+","+datos[4]+","+datos[5]+","+datos[6];
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
														writer.write(datosUsuario[0]+","+datosUsuario[1]+","+datosUsuario[2]+","+datosUsuario[3]+","+datosUsuario[4]+","+datosUsuario[5]+","+datosUsuario[6]);
														writer.close();
														listaCargada=false;
														JOptionPane.showMessageDialog(null,"Registro Correcto en el Sistema");
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
						 }else {
								JOptionPane.showMessageDialog(null,"Datos Nombre de Usuario o Contraseña ya registrados! Porfavor escoge otros");

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
	
	boolean listaCargada=false;
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
		
	
		listaUser.setSize(300,40);
		listaUser.setLocation(90,200);
		//Hacer la lista de todos los usuarios para añadirla al JComboBox y el usuario pueda seleccionar cual editar
	
		
		if(listaCargada==false) {
			doListaUsuarios();
			listaCargada=true;
		}
		
		
		
		
		
		listaUsuarios.add(listaUser);
		
		listaUser.addActionListener(new ActionListener() {

			@Override
			//getSelectedIndex()  getSelectedItem()
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//llamo a cargar todos los datos del usuario que selecciono para actualizar el boton 
				cargarDatosDelUsuario(listaUser.getSelectedItem());
				route();
				//System.out.println(listaUser.getSelectedItem());
			}});
		
		RoundJButton editarUser= new RoundJButton("#54EB9A");
		editarUser.setText("Editar a: "+datosUsuario[1]);
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
		
		
		
		//se agrega la tabla 
		listaUsuarios.add(cargarTabla());

		return listaUsuarios;
		
	}
	
	public void doListaUsuarios() {
		BufferedReader reader = null;
		
		
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
					listaUser.addItem(datos[1]);

				}
				
				try {
					line= reader.readLine();
					//posicionFilaDatos++;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
	}
	public void cargarDatosDelUsuario() {
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
					datosUsuario[5]=datos[5];
					datosUsuario[6]=datos[6];

				
					String d=datos[1];
						
					if(d.equals(nombreUsuario)) {
						System.out.println("nombre    "+nombreUsuario);
							System.out.println("dasd    "+datosUsuario[0]);
							break;
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
	}
	public void cargarDatosDelUsuario(Object nombreUsuario) {
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
					datosUsuario[5]=datos[5];
					datosUsuario[6]=datos[6];

				
					String d=datos[1];

					if(d.equals(nombreUsuario)) {
							
							break;
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
			
			//System.out.println("tamano: "+cantFilas);
			//tabla
			 String [] nombresColumnas= {"Nombre","Nombre de Usuario","Correo Electrónico","Contraseña","Descripción","Comida Favorita","Color Favorito","Acciones"};
			
			
			
			
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
						datosUsuarios[fila][5]=datos[5];
						datosUsuarios[fila][6]=datos[6];
						
						
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
			 scroll.setBounds(80,400,400,150);
	
			return scroll;
			
			
	}
	
	public void borrarUser() {
		 StringBuilder contenido = new StringBuilder();
			 File archivo = new File("users.txt");
	            Scanner lector = null;
				try {
					lector = new Scanner(archivo);
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			
			//guardamos los datos anteriores del usuario
			String datoAEliminar=datos[0]+","+datos[1]+","+datos[2]+","+datos[3]+","+datos[4]+","+datos[5]+","+datos[6];
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
				
				
				//textAreaDescripcion.setSize(300, 100);
				//textAreaDescripcion.setLocation(100, 450);
				textFieldDescripcion.setFont(new Font("Comic Sans",Font.ITALIC,14));
				miCuenta.add(textFieldDescripcion);
				
				JScrollPane scroll = new JScrollPane(textFieldDescripcion);

				 scroll.setSize(300,100);
				 scroll.setLocation(100,450);
				 
				
				miCuenta.add(scroll);
					
				
				JLabel comidaFav = new JLabel("Comida Favorita");
				comidaFav.setSize(190,40);
				comidaFav.setLocation(100,555);
				comidaFav.setForeground(Color.white);
				comidaFav.setFont(new Font("Arial",Font.BOLD,19));
				miCuenta.add(comidaFav);
				
				
		  
				
				
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
		
		//ponemos por defecto los campos a llenar vacios
		textFieldNombrePersona.setText("");
		textFieldNombreUser.setText("");
		textFieldEmail.setText("");
		textFieldContrasena.setText("");
		textFieldDescripcion.setText("");
		
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
		
		//Listeners de los checkBox
		marco1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comidaFavorita=marco1.getText();
			}});
		
		
		marco2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comidaFavorita=marco2.getText();
			}});
		
		marco3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comidaFavorita=marco3.getText();
			}});
		
		marco4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				colorFavorito=marco4.getText();

			}});
		
		marco5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				colorFavorito=marco5.getText();
			}});
		
		marco6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				colorFavorito=marco6.getText();
			}});

		
				
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
						String descripcion = textFieldDescripcion.getText();
				
						if(nombreUser.equals("") || contrasena.equals("")) {
							JOptionPane.showMessageDialog(null,"Error, Los campos nombre de usuario y contraseña no pueden estar vacios ");
						}else {
							
							//System.out.println(comprobarSiUsuarioExiste(nombreUser,contrasena));
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
								
											writer.write(nombrePersona+","+nombreUser+","+email+","+contrasena+","+descripcion+","+comidaFavorita+","+colorFavorito);
											writer.close();
											
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										listaCargada=false;
									JOptionPane.showMessageDialog(null,"Registro Correcto en el sistema ");
									anterior = actual;
									actual = "login";
									
									route();
							}else {
								JOptionPane.showMessageDialog(null,"Datos Nombre de Usuario o Contraseña ya registrados! Porfavor escoge otros");
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
						if(acceso!=false) {
							anterior = actual;
							actual = "miCuenta";
						}else {
							anterior = actual;
							actual = "login";
						}
						
						route();
					}});

		
		return miCuenta;
		
	}
	
	public boolean comprobarSiUsuarioExiste(String nombreUsuario,String contrasena) {
		
		boolean existe=false;
		//esta variable se usa como contador para saber si usuario con el mismo nombre de usuario
		//+1 para contar mi nuebvo nombre d eusuario
		int i=0;
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
				
					if(datos[1].equals(nombreUsuario) && datos[3].equals(contrasena)) {
						existe=true;
						break;
	
					}else {
						//System.out.println("NO ES IGUAL: "+datos[1]+" :"+ nombreUsuario);
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
		if(acceso!=false) {
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
					
					acceso=false;
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

		}
		
		
		
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
		label.setLocation(80,50);
		panelAyuda.add(label);
		
		

		ImageIcon imagen = new ImageIcon("info.png");

		RoundJLabel labelImg = new RoundJLabel();
		labelImg.setSize(200,230);
		labelImg.setLocation(170,110);
		labelImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200, 200 , Image.SCALE_SMOOTH)));
		panelAyuda.add(labelImg);
		
		JTextArea  txtArea1 = new JTextArea("1. Hacer click en la opción \"Usuario\" en el menú superior."
				+"\n 2. Hacer click en la opción \"Crear Usuario\" en el menu desplegado."
				+"\n 3. Llenar los campos solicitados."
				+"\n 4. Escribir una pequeña descripción de ti."
				+"\n 5. Seleccionar tu comida favorita."
				+"\n 6. Seleccionar tu color favorito."
				+"\n 7. Hacer click en el botón \"Crear Usuario\""
				+"\n 8. Listo, el usuario se ha creado.");
		txtArea1.setSize(400,200);
		txtArea1.setLocation(80,300);
		txtArea1.setFont(new Font("Arial", Font.BOLD, 18));
		//txtArea1.setBackground(Color.red);
	
		JScrollPane scroll = new JScrollPane(txtArea1);

		 
		 scroll.setBounds(80,380,400,200);

		
		panelAyuda.add(scroll);
		
		
		
		RoundJButton btnCrearUsuario = new RoundJButton("#54EB9A");
		btnCrearUsuario.setText("Crear un usuario ahora");
		btnCrearUsuario.setSize(200, 35);
		btnCrearUsuario.setLocation(180,610);
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
