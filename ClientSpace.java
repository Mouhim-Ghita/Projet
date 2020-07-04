package projetJava;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSpace extends Thread{
	Serveur server;
	Socket socket;
	DataInputStream depuisClient;
	DataOutputStream versClient;
	String username,msgin;
	
	public ClientSpace(Socket clientSocket,Serveur server) {
		this.socket=clientSocket;
		this.server=server;
		
			/*try {
			
			depuisClient=new DataInputStream(socket.getInputStream());
			versClient=new DataOutputStream(socket.getOutputStream());
			
			username=depuisClient.readUTF();	
			versClient.writeUTF(username);
			System.out.println(username+" est dans le qcm");

				} catch (IOException e) {
			
			e.printStackTrace();

		}*/
	}
	
	@Override
	public void run() 
	{
			try {
				
				depuisClient=new DataInputStream(socket.getInputStream());
				versClient=new DataOutputStream(socket.getOutputStream());
				
				username=depuisClient.readUTF();	
				versClient.writeUTF(username);
					
								
				System.out.println(username+" est dans le qcm");
				
				
				
					msgin=depuisClient.readUTF();
					
						for(ClientSpace c:server.listClients)
						{
							c.versClient.writeUTF(this.username+":"+msgin);
						}
				
						
					  
				
			} catch (IOException e) {
				System.out.println(username+" "+"s'est deconnecté");
				server.listClients.remove(this);
				System.out.println(server.listClients.size()+"restent dans l'application");
				if(server.listClients.size()==0)
				{
					System.exit(0);
				
				}
			}
		
		
	}
	

}
