package projetJava;

import java.io.BufferedReader;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Filiere
	{
	
		String NomFil;
		Connection maConnexion;
		String user="root";
		String pass="";
		String Url="jdbc:mysql://localhost:3306/question";
		public Filiere(String nom)
		 {
			NomFil=nom;
			  // etape1: tester l'accessibilite du driver
			  
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
		}
		
		void insererEtudiant(String nom,int Niveau,String fil) throws Exception
		{
			String requette="insert into etudiants values(?,?,?)";
			 PreparedStatement st= maConnexion.prepareStatement(requette);
				    st.setString(1, nom);
					st.setInt(2, Niveau);
					st.setString(3, fil);
			int nb=st.executeUpdate();
			System.out.println(nb+"insertion de l'etudiant est reussie");
		}
		
		void afficher() throws SQLException
		{
			String requette="select*from etudiants";
			  Statement st=maConnexion.createStatement();
			  ResultSet rs=st.executeQuery(requette);
			  System.out.println("la filiere est:"+NomFil);
			  while(rs.next())
			  {
				  System.out.println("le nom: "+rs.getString(1)+"\t"+"son niveau est: "+rs.getInt(2));
			  }
		}
		void supprimer(String nom ) throws Exception
		  {
			  String requette="delete from etudiants where Nom=?";
			  PreparedStatement st= maConnexion.prepareStatement(requette);
			  st.setString(1, nom);
			  int nb=st.executeUpdate();
			  System.out.println(nb+"suppression reussies");
			  
		  }
		
		
		
		 void inserer(String message,int n,String f) throws Exception
		{
			String requette="insert into etudiants values(?,?,?)";
			 PreparedStatement st= maConnexion.prepareStatement(requette);
			 message=message.replaceAll(",.*?;", "");
				    st.setString(1, message);
				    st.setInt(2, n);
				    st.setString(3, f);
	    			int nb=st.executeUpdate();
			System.out.println(nb+"insertion de l'etudiant est reussie");
			
		}
		 public  void lireFichier() throws Exception
			{
				String monFich,message;
				Scanner sc=new Scanner(System.in);
				boolean res=false;
				FileReader f=null;
				do {
					res=true;
					System.out.println("saisir le nom du fichier a lire:");
					monFich=sc.nextLine();
					
					try {
				 f=new FileReader(monFich);}
					catch(Exception e) 
				{
					res=false;
				}
							
				}while(res==false);
				BufferedReader buff=new BufferedReader(f);//buff pointeur qui lit
				
				System.out.println("voila votre msg");
				do {
					message=buff.readLine();
					inserer(message,1,"INFORMATIQUE");
					System.out.println(message);
				}while(message!=null);

				
				buff.close();
				sc.close();
				
			
			}
		 void InsererEtudiant(String nom,String Niveau,String fil) throws Exception
			{
				
				String requette="insert into etudiants values(?,?,?)";
				 PreparedStatement st= maConnexion.prepareStatement(requette);
				 		
				 		st.setString(1, nom);
				 		st.setString(3, fil);
						st.setString(2, Niveau);
						
				int nb=st.executeUpdate();
				System.out.println(nb+"insertion de l'etudiant est reussie");
				
			}

		public static void main(String[] args) throws Exception 
		{
			Filiere f=new Filiere("Informatique");
			f.lireFichier();

		}
			
	}
