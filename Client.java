package projetJava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client extends Thread
{
	Socket soket;
	int port=3;
	String ClientName;
	DataInputStream inputs;
	DataOutputStream outputs;
	/*public Client()
	{
		new Etud(this);
			
		
	}*/
	public void OuvrirConnexion()
	{
		try {
			System.out.println("Etape1 : se connecter au serveur");
			soket= new Socket("localhost", port);
			System.out.println("<<<<<<<<Etape1 : ok");
			System.out.println("Etape2 : creation des canneux in et out ");
			inputs=new DataInputStream(soket.getInputStream());
			outputs=new DataOutputStream(soket.getOutputStream());
			System.out.println("<<<<<<<<Etape2 : ok");
			System.out.println("Etape3:envoie du nom au serveur");
			outputs.writeUTF(ClientName);
			System.out.println("<<<<<<etape3:ok");
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unused")
	@Override
	public void run()
	{
			try {
				
				String msg=inputs.readUTF();
				
			} catch (IOException e)
				{
				// TODO Auto-generated catch block
				System.out.println("probleme de reception");
				}
		
			
			//System.out.println(this.ClientName);
		
		
		
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c=new Client();
		Etudiant e=new Etudiant(c);
		Authentification a=new Authentification();
		a.frame.setVisible(true);

	}

}
