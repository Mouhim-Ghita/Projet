package projetJava;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Etud extends JFrame   {

		Client client=new Client();
		Etudiant etudiant;
	 JPanel contentPane;
	 JTextField textPort;
	 Connection maConnexion;
	 String nom;
		String user="root";
		String pass="";
		String Url="jdbc:mysql://localhost:3306/question";

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Etud(String name) {
		setResizable(false);
		//client=new Client();
		//this.client=c;
	//client.ClientName=name;
		//etudiant=new Etudiant(c);
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_2 = new JLabel("le particiapant est:"+name);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(64, 12, 343, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\coton-rose-uni-oeko-tex.jpg"));
		lblNewLabel_1.setBounds(0, 0, 444, 76);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Consulter les r\u00E9sultats");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						
						new ResultatEtud(name).setVisible(true);
					
				
			}
		});
		btnNewButton.setBounds(163, 157, 158, 23);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Passer l'examen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			
						new Etudiant_Space(name).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(163, 108, 158, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Deconnexion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
						//new PageAcceuil().frame.setVisible(true);
						System.exit(0);
			}
		});
		btnNewButton_2.setBounds(163, 214, 158, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\beige.jpg"));
		lblNewLabel.setBounds(0, 0, 444, 271);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
	}
}
