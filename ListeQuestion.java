package projetJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListeQuestion {

	ArrayList<String> listeQcm=new ArrayList<String>();
	Connection maConnexion;
	String user="root";
	String pass="";
	String Url="jdbc:mysql://localhost:3306/question";
	public ListeQuestion() throws Exception
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("chargement est ok");
		  } catch (ClassNotFoundException e) {
			System.out.println("chargement non");
			System.exit(0);
		}
		  
		  // etape2: se connecter a la base
		  try {
			maConnexion=DriverManager.getConnection(Url, user, pass);
			System.out.println("base de donne est accessible");
		  } catch (SQLException e) {
			  System.out.println("base de donne est pas accessible");
		}
		  
		  
		  String requette="SELECT * FROM qcm1 WHERE 1";
		  Statement st;
			
			st = maConnexion.createStatement();
			ResultSet rs;
			PreparedStatement pst;
			rs = st.executeQuery(requette);
			while(rs.next())
			{
				listeQcm.add(rs.getString(4));
				String mes="INSERT INTO listequestion (idquestions,liste) VALUES(?,?)";
				pst=maConnexion.prepareStatement(mes);
				pst.setInt(1, rs.getInt(1));
				pst.setString(2,rs.getString(4));
				pst.executeUpdate();
			
			
			}
	}

}
