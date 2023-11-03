package tools;
import java.io.*;
import java.net.Socket;
import cartago.*;


public class DepositBelt extends Artifact  {
    
    String serverName = "127.0.0.1";
	int port = 4445;

    void init(){

       
        defineObsProperty("empty", true);
		

    }

    @OPERATION
    void checkDepositBelt(){
        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK DEPOSITBELT");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			Boolean empty = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();

            updateObsProperty("empty", empty);
            
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    @OPERATION
    void storeMetalPlate(){
        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("STORE METALPLATE");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//Boolean empty = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();

           
            
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
