package tools;
import java.io.*;

import java.net.Socket;


import cartago.*;

public class Press extends Artifact {
    String serverName = "127.0.0.1";
	int port = 4445;

    void init(){

        defineObsProperty("positionX", 0);
        defineObsProperty("empty", true);
		defineObsProperty("forging", false);
		defineObsProperty("isForged", false);
		//defineObsProperty("isOpen", false);

    }

    @OPERATION
	void checkEmpty() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK PRESS IS EMPTY");
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
	void checkPositionX() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK POSX PRESS");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			int position = Integer.parseInt(in.readUTF());
			clientSocket.close();

			updateObsProperty("positionX", position);
          
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@OPERATION
	void checkForging() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK PRESS IS FORGING");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			Boolean forging = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();
            
			updateObsProperty("forging", forging);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@OPERATION
	void checkIsForged() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK PRESS IS FORGED");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			Boolean isForged = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();
            
			updateObsProperty("isForged", isForged);
           
            
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@OPERATION
	void forgePlate() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("FORGE");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			// position = Integer.parseInt(in.readUTF());
			clientSocket.close();

		
  
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@OPERATION
	void openPress(){
		try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("OPEN PRESS");
			//InputStream inFromServer = clientSocket.getInputStream();
			//Boolean isOpen = Boolean.parseBoolean(in.readUTF());
     
			clientSocket.close();

		
           // removeObsProperty("isOpen");
           // defineObsProperty("isOpen", isOpen);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OPERATION
	void closePress(){
		try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CLOSE PRESS");
			//InputStream inFromServer = clientSocket.getInputStream();
			//Boolean isOpen = Boolean.parseBoolean(in.readUTF());
     
			clientSocket.close();

		
           // removeObsProperty("isOpen");
           // defineObsProperty("isOpen", position);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OPERATION
	void setCondition(){
		updateObsProperty("isForged", true);
		updateObsProperty("forging", true);
		
	}


}