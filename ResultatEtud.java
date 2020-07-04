package projetJava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class ResultatEtud extends JFrame {

	 JPanel contentPane;
	 String nom;
		Connection maConnexion;
		String user="root";
		String pass="";
		String Url="jdbc:mysql://localhost:3306/question";
		private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultatEtud frame = new ResultatEtud("");
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
	public ResultatEtud(String name) {
		nom=name;
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
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("le particiapant est:"+nom);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(64, 12, 343, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\coton-rose-uni-oeko-tex.jpg"));		lblNewLabel_1.setBounds(0, 0, 434, 58);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Qcm1Java");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				afficher1();
				
			}
		});
		btnNewButton.setBounds(22, 89, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Qcm2Java");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				afficher2();
			}	});
		btnNewButton_1.setBounds(215, 89, 148, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 143, 314, 107);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\AdMiN\\Desktop\\beige.jpg517;"));	lblNewLabel.setBounds(0, 0, 434, 261);
contentPane.add(lblNewLabel);
		
	}
	public void afficher1()
	{
		String requete="SELECT `NomEtudiant`, `Score` FROM `etudiants_et_leurs scores` WHERE NomEtudiant='"+nom+"'";
		
		PreparedStatement prep;
		ResultSet resultat;
		try {
			prep=maConnexion.prepareStatement(requete);
			resultat=prep.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void afficher2()
	{
		String requete="SELECT `etudiant`, `note` FROM `scoreetudiantsqcm2`  WHERE etudiant='"+nom+"'";
		PreparedStatement prep;
		ResultSet resultat;
		try {
			prep=maConnexion.prepareStatement(requete);
			resultat=prep.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
