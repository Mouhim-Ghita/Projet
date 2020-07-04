package projetJava;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Etudiant {
	Client client=new Client();
	 JFrame frmEtudiantSpace;
	JTextField textField;
	 Connection maConnexion;
	 String nom;
		String user="root";
		String pass="";
		String Url="jdbc:mysql://localhost:3306/question";

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Etudiant(Client v) {
	
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("chargement est ok");
			  } catch (ClassNotFoundException e) {
				//System.out.println("chargement non");
				System.exit(0);
			}
			  
			  // etape2: se connecter a la base
			  try {
				maConnexion=DriverManager.getConnection(Url, user, pass);
				//System.out.println("base de donne est accessible");
			  } catch (SQLException e) {
				  //System.out.println("base de donne est pas accessible");
			}
		frmEtudiantSpace = new JFrame();
		frmEtudiantSpace.setResizable(false);
		frmEtudiantSpace.setTitle("Etudiant Space");
		frmEtudiantSpace.setBounds(100, 100, 450, 300);
		frmEtudiantSpace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEtudiantSpace.getContentPane().setLayout(null);
		frmEtudiantSpace.setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(40, 87, 126, 14);
		frmEtudiantSpace.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(164, 85, 194, 20);
		frmEtudiantSpace.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fili\u00E8re:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(40, 134, 126, 14);
		frmEtudiantSpace.getContentPane().add(lblNewLabel_2);
		
		Choice choixfiliere = new Choice();
		choixfiliere.setBounds(210, 128, 105, 20);
		choixfiliere.add("");
		choixfiliere.add("Informatique");
		frmEtudiantSpace.getContentPane().add(choixfiliere);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")|| choixfiliere.getSelectedItem().equals(""))
				{
					JOptionPane.showMessageDialog(null, "veuillez remplir le champs pour continuer");
					
				}
				else {
				String requette	="select * from etudiants where Nom='"+textField.getText()+"'";
				Statement st;
				ResultSet rs;
				try {
					st = maConnexion.createStatement();
					rs = st.executeQuery(requette);
					client.ClientName=textField.getText();
						if(rs.next())
						{
							new Etud(client.ClientName).setVisible(true);
							client.OuvrirConnexion();
							client.start();
						}
						
						
						else
						{
							JOptionPane.showMessageDialog(null, "votre nom n'existe pas dans la filiere");
						}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}}
		});
		btnNewButton.setBounds(61, 196, 89, 23);
		frmEtudiantSpace.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEtudiantSpace.dispose();
			}
		});
		btnNewButton_1.setBounds(305, 196, 89, 23);
		frmEtudiantSpace.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Espace Etudiant");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(106, 31, 221, 28);
		frmEtudiantSpace.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\coton-rose-uni-oeko-tex.jpg"));
		lblNewLabel_1_1.setBounds(0, 0, 444, 76);
		frmEtudiantSpace.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\beige.jpg"));
		lblNewLabel.setBounds(0, 0, 444, 271);
		frmEtudiantSpace.getContentPane().add(lblNewLabel);
	}
}
