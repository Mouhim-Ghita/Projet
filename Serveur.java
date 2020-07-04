package projetJava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Serveur {
	public ServerSocket socketServer;
	String ip;
	int port=3;
	Client cp=new Client();
	Socket socket;
	DataInputStream depuisClient;
	DataOutputStream versClient;
	String username;
	
	public ArrayList<ClientSpace> listClients=new ArrayList<ClientSpace>();

	public static void main(String[] args) {
		Serveur server=new Serveur();
		try {server.exec();}
		catch (Exception e) {
			System.out.println("serveur peut pas etre execute");
		}
	}
	
			


	public void exec() {
		try {
				
			ip=InetAddress.getLocalHost().getHostAddress().toString();
			socketServer=new ServerSocket(port);
		while(true)
				{Socket clientSocket=socketServer.accept();
				
				
					ClientSpace c=new ClientSpace(clientSocket,this);
					
					
					if(!listClients.contains(c))
					
					{
						
						this.listClients.add(c);
						c.start();
					}
						
						
						
					
					//System.out.println("il y a "+this.listClients.size()+" participants dans l'application");
			}
		}		
			 catch (UnknownHostException e) {
			System.out.println("Impossible de resoudre l'adresse du serveur!");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Impossible de créer serveur!");
			System.exit(0);
		}
			}
	

}

