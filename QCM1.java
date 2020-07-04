package projetJava;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

	import javax.swing.ButtonGroup;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;

	import java.awt.BorderLayout;
	import java.awt.Button;

	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.ImageIcon;
	import javax.swing.SwingConstants;
	import java.awt.Font;

	public class QCM1{
		Connection maConnexion;
		String user="root";
		String pass="";
		String Url="jdbc:mysql://localhost:3306/question";
		ArrayList<String>liste=new ArrayList<String>();
		ArrayList<String>listec1=new ArrayList<String>();
		ArrayList<String>listec2=new ArrayList<String>();
		ArrayList<String>listec3=new ArrayList<String>();
		ArrayList<String>listec4=new ArrayList<String>();
		String valeur;
		int i=0,score=0;
		ButtonGroup g1;
		JPanel panel ;

		 JFrame frame;

		/**
		 * Launch the application.
		 * @throws SQLException 
		 */
		public static void main(String[] args) throws SQLException {
			
		}

		/**
		 * Create the application.
		 * @throws SQLException 
		 * @wbp.parser.entryPoint
		 */
		public QCM1(String nom) throws SQLException {
			initialize(nom);
		}

		/**
		 * Initialize the contents of the frame.
		 * @throws SQLException 
		 */
		void initialize(String nom) throws SQLException {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				maConnexion=DriverManager.getConnection(Url, user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement st;
			  ResultSet rst;
			  st=maConnexion.createStatement();
			  rst=st.executeQuery("SELECT * FROM `qcm1` order by rand() LIMIT 20");
			  rst.next();
			frame = new JFrame();
			frame.setBounds(100, 100, 798, 401);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setTitle("Page des questions");
			
			panel= new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel =new JLabel(rst.getString("question"));
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel.setBounds(1, 52, 798, 49);
			panel.add(lblNewLabel);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton(rst.getString("choix1"));
			rdbtnNewRadioButton.setBounds(41, 126, 798, 31);
			panel.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setSelected(false);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(rst.getString("choix2"));
			rdbtnNewRadioButton_1.setBounds(41, 160, 798, 31);
			panel.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setSelected(false);
			
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(rst.getString("choix3"));
			rdbtnNewRadioButton_2.setBounds(41, 194, 798, 31);
			panel.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setSelected(false);
			
			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(rst.getString("choix4"));
			rdbtnNewRadioButton_3.setBounds(41, 228, 798, 31);
			panel.add(rdbtnNewRadioButton_3);
			rdbtnNewRadioButton_3.setSelected(false);
	rdbtnNewRadioButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					valeur=rdbtnNewRadioButton.getText();
					
				}
			});

			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					valeur=rdbtnNewRadioButton_1.getText();
					
				}
			});
				
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					valeur=rdbtnNewRadioButton_2.getText();
					
				}
			});
			
			
			rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					valeur=rdbtnNewRadioButton_3.getText();
					
				}
			});
			
			while(rst.next())
			  {
				  liste.add(rst.getString("question"));
				  listec1.add(rst.getString("choix1"));
				  listec2.add(rst.getString("choix2"));
				  listec3.add(rst.getString("choix3"));
				  listec4.add(rst.getString("choix4"));
			  }
			g1=new ButtonGroup();
			g1.add(rdbtnNewRadioButton);
			g1.add(rdbtnNewRadioButton_1);
			g1.add(rdbtnNewRadioButton_2);
			g1.add(rdbtnNewRadioButton_3);
			
			
			
			
			Button button = new Button("NEXT");
			button.setBounds(474, 263, 70, 22);
			panel.add(button);
			
			JLabel lblNewLabel_3 = new JLabel("Informatique");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(10, 6, 91, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("QCM1");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_4.setBounds(211, 8, 67, 14);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("JAVA");
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(435, 8, 46, 14);
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\coton-rose-uni-oeko-tex.jpg"));
			lblNewLabel_1.setBounds(-11, -8, 978, 42);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_6 = new JLabel("Prof cr\u00E9ateur: lakhrissi younes");
			lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_6.setBounds(504, 336, 207, 14);
			panel.add(lblNewLabel_6);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("D:\\java\\Projet\\src\\projetJava\\coton-rose-uni-oeko-tex.jpg"));
			lblNewLabel_2.setBounds(-11, 325, 793, 36);
			panel.add(lblNewLabel_2);
			button.addActionListener(new ActionListener() {
				@SuppressWarnings("resource")
				public void actionPerformed(ActionEvent arg0) {
					try {
						String extractQuery="select reponsechoisit.rep, reponse.Reponse from reponse inner join(select rep from reponsechoisit order by id desc limit 1) as reponsechoisit on reponsechoisit.rep=reponse.Reponse";
						PreparedStatement pst;
						pst=maConnexion.prepareStatement(extractQuery);
						ResultSet rs;
						rs=pst.executeQuery();
						
						
						String SubbmitQuerry="INSERT INTO reponsechoisit(rep) VALUES (?)";
						
						pst=maConnexion.prepareStatement(SubbmitQuerry);
						pst.setString(1,valeur);
						pst.executeUpdate();
						if(rs.next())
						{
							String valueQuerry="INSERT INTO verification(verif) VALUES (?)";
							pst=maConnexion.prepareStatement(valueQuerry);
							pst.setString(1, "correcte");
							pst.executeUpdate();
							score++;
							
								
						}
						else {
							String valueQuerry="INSERT INTO verification(verif) VALUES (?)";
							pst=maConnexion.prepareStatement(valueQuerry);
							pst.setString(1, "incorrect");
							pst.executeUpdate();
							
							}
						 
						
						
					}catch(Exception e1)
					{e1.printStackTrace();}
					
					
					if(i<19)
					
					{
					    lblNewLabel.setText(liste.get(i));
						rdbtnNewRadioButton.setText(listec1.get(i));
						rdbtnNewRadioButton_1.setText(listec2.get(i));
						rdbtnNewRadioButton_2.setText(listec3.get(i));
						rdbtnNewRadioButton_3.setText(listec4.get(i));
						i++;
						
					}
					
					else
					{ 
						  String requette="INSERT INTO `etudiants_et_leurs scores`(`NomEtudiant`, `Score`) VALUES (?,?)";
						 
						 try {
							 PreparedStatement st1= maConnexion.prepareStatement(requette);
								   st1.setString(1,nom);
								   st1.setInt(2, score);
							int nb=st1.executeUpdate();
							System.out.println(nb+"insertion de l'etudiant est reussie");
							 
								
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								System.out.println("insertion non reussi");
							}
						
						 System.out.println("le score final est:"+score);
						 JOptionPane.showMessageDialog(null, "le score est:"+score);
					
						 frame.dispose();
					}
						//System.exit(0);
					
					
					
					
						panel.repaint();
						
					
				
				}
				
			});
			
		panel.setVisible(true);
		}
	}



