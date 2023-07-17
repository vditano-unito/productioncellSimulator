package tools;
import java.io.*;
import java.net.Socket;
import cartago.*;


public class FeedBelt extends Artifact  {
    String serverName = "127.0.0.1";
	int port = 4445;

    void init(){

       
        defineObsProperty("empty", true);
		defineObsProperty("supply", true);
		defineObsProperty("request", false);
    }

	@OPERATION
	void setRequest(Boolean condition){
		
		updateObsProperty("request", condition);
	}
    @OPERATION
    void checkSupply(){
        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("THERE IS SUPPLY");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			Boolean empty = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();

            updateObsProperty("supply", empty);
            
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @OPERATION
    void checkFeedBelt(){
        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK FEEDBELT");
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
    void addRawPlate(){
        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("ADD RAWPLATE IN FB");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//Boolean empty = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();

           
            
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


}
