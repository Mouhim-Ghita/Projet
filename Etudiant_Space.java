package projetJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Etudiant_Space extends JFrame {
	Client c;
	Connection maConnexion;
	String user="root";
	String pass="";
	String Url="jdbc:mysql://localhost:3306/question";
	JPanel contentPane;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Etudiant_Space(String nom) {
		setResizable(false);
		
		setTitle("Formulaire d'examen");
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 279);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Bienvenue dans l'examen veuillez remplir ce formulaire pour commencer:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(22, 0, 553, 44);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("./images/coton-rose-uni-oeko-tex.jpg"));
		lblNewLabel_1.setBounds(0, 0, 595, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("Mati\u00E8re:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(84, 55, 120, 44);
		contentPane.add(lblNewLabel_6);
		
		Choice choixMatier = new Choice();
		choixMatier.setBounds(324, 65, 109, 20);
		choixMatier.add("");
		choixMatier.add("JAVA");
		contentPane.add(choixMatier);
		
		JLabel lblNewLabel_7 = new JLabel("QCM:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(120, 110, 46, 22);
		contentPane.add(lblNewLabel_7);
		
		Choice choixQcm = new Choice();
		choixQcm.setBounds(361, 110, 46, 20);
		choixQcm.add("");
		choixQcm.add("1");
		choixQcm.add("2");
		contentPane.add(choixQcm);
		
		JButton btnNewButton = new JButton("Commencer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String k,l;
					k=choixMatier.getSelectedItem();
					l=choixQcm.getSelectedItem();
					
						
							if(k.equals("JAVA")&&l.equals("1"))
							
						{
						try {
							new QCM1(nom).frame.setVisible(true);
							dispose();
						
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//JOptionPane.showMessageDialog(null,"les champs bien saisie");
						
						}
							else if(k.equals("JAVA")&&l.equals("2"))
							{
						
						try {
							new Question2_prof1(nom).frame.setVisible(true);
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
						
						if(choixMatier.getSelectedItem().equals("")||choixQcm.getSelectedItem().equals(""))
						{
							JOptionPane.showMessageDialog(null,"veuillez remplir tout les champs");
								}
				}
				catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(106, 167, 102, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(372, 167, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("./images/beige.jpg"));
		lblNewLabel.setBounds(0, 0, 595, 317);
		contentPane.add(lblNewLabel);
	}
}
