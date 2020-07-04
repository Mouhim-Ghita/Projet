package projetJava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class P1 extends JFrame {
	JPanel contentPane;
	JTable table;
	Connection maconnexion;
	String user="root";
	String pass="";
	String Url="jdbc:mysql://localhost:3306/question";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P1 frame = new P1();
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
	public P1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		  } catch (ClassNotFoundException e) {
			
			System.exit(0);
		}
		  
		  // etape2: se connecter a la base
		  try {
			maconnexion=DriverManager.getConnection(Url, user, pass);
			
		  } catch (SQLException e) {
			  
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("HISTORIQUE PROFESSEUR");
		setBounds(100, 100, 1000, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("Professeur cr\u00E9ateur: Lakhrissi younes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(157, 2, 256, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fili\u00E8re: G\u00E9nie Informatique");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(406, 335, 203, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("R\u00E9sultats QCM1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				afficher1();
			}
		});
		btnNewButton.setBounds(36, 75, 130, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("R\u00E9sultats QCM2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficher2();
			}
		});
		btnNewButton_1.setBounds(36, 266, 130, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 41, 800, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("QCM1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				afficher3();
			}
		});
		btnNewButton_2.setBounds(36, 41, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("QCM2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				afficher4();
			}
		});
		btnNewButton_3.setBounds(36, 232, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Deconnexion");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(118, 315, 141, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\beige.jpg"));
		lblNewLabel.setBounds(0, 0, 3000, 349);
		contentPane.add(lblNewLabel);
	}
	public void afficher1()
	{
		String sql1="SELECT NomEtudiant,Score FROM `etudiants_et_leurs scores` WHERE 1";
		PreparedStatement prep;
		ResultSet resultat;
		try {
			prep=maconnexion.prepareStatement(sql1);
			resultat=prep.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void afficher2()
	{
		String sql1="SELECT etudiant,note FROM `scoreetudiantsqcm2` WHERE 1";
		PreparedStatement prep;
		ResultSet resultat;
		try {
			prep=maconnexion.prepareStatement(sql1);
			resultat=prep.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void afficher3()
	{
		String sql1="SELECT `ID`,`question`, `choix1`, `choix2`, `choix3`, `choix4` FROM `qcm1` WHERE 1";
		PreparedStatement prep;
		ResultSet resultat;
		try {
			prep=maconnexion.prepareStatement(sql1);
			resultat=prep.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void afficher4()
	{
		String sql1="SELECT `ID`,`question`, `choix1`, `choix2`, `choix3`, `choix4` FROM `qcm2prof1` WHERE 1";
		PreparedStatement prep;
		ResultSet resultat;
		try {
			prep=maconnexion.prepareStatement(sql1);
			resultat=prep.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
