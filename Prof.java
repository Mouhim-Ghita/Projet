package projetJava;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
	public class Prof extends JFrame {
		Client client=new Client();
		JPanel contentPane;
		 JTextField textField;
		 String  nom;
		P1 prof=new P1();
		int i;
		Connection maConnexion;
		String user="root";
		String pass="";
		String Url="jdbc:mysql://localhost:3306/question";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prof frame = new Prof("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Prof(String nom) {
		setResizable(false);
		this.nom=nom;

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
			  setTitle("Teatcher Space");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NOM:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(54, 76, 81, 17);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(164, 76, 198, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sp\u00E9cialit\u00E9");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(54, 120, 81, 17);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Se Connecter");
		
		btnNewButton.setBounds(84, 170, 120, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PageAcceuil().frame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(291, 170, 89, 23);
		contentPane.add(btnNewButton_1);
		
		Choice choice = new Choice();
		choice.setBounds(227, 117, 101, 20);
		choice.add("");
		choice.add("Informatique");
		contentPane.add(choice);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String j=choice.getSelectedItem();
				if(j.equals("")||textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "veuillezn remplir tous les champs");
				}
				else {
				String requette="SELECT*FROM professeur WHERE NOM='"+textField.getText()+"'";
				Statement st;
				ResultSet rs;
				try {
					st = maConnexion.createStatement();
					rs = st.executeQuery(requette);
					rs.next();
					
					i=rs.getInt(1);
					
					if(i==1) 
					{
						client.ClientName=textField.getText();
						//client.port=Integer.parseInt(textPort.getText());
						client.OuvrirConnexion();
						client.start();
						if(j=="Informatique")
						{try {
							prof.setVisible(true);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "mal saisie");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Espace Professeur");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(75, 0, 283, 49);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\coton-rose-uni-oeko-tex.jpg"));
		lblNewLabel_3.setBounds(0, 0, 444, 49);
		contentPane.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\beige.jpg"));
		lblNewLabel.setBounds(0, 0, 444, 271);
		contentPane.add(lblNewLabel);
	}
}
